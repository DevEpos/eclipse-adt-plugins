package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.MessageType;
import com.devepos.adt.cst.internal.search.client.AdtObject;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.FunctionGroupInclude;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.SearchableObject;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.ris.search.repositoryservice.RepositoryTreeService;

@SuppressWarnings("restriction")
public class FugrSearchProvider implements ISearchProvider {

  private final IClientCodeSearchConfig config;
  private final RepositoryTreeService treeService;
  private IProgressMonitor monitor;

  public FugrSearchProvider(final IClientCodeSearchConfig config, IProgressMonitor monitor,
      final String destinationId) {
    this.config = config;
    this.monitor = monitor;
    treeService = new RepositoryTreeService(destinationId);
  }

  @Override
  public ICodeSearchResult search(final SearchableObject object,
      final ISourceCodeReader srcCodeReader, final ISourceCodeSearcherFactory searcherFactory) {

    var result = ICodeSearchFactory.eINSTANCE.createCodeSearchResult();

    // we need to determine the correct node id's as they are not the same for all function groups
    var fugrTreeContent = treeService.readTreeContent(monitor,
        IAdtObjectTypeConstants.FUNCTION_GROUP, object.getName(), object.getName(), null,
        new String[] { "000000" }, false, false, false, false);

    String functionModulesNodeId = null;
    String fugrIncludeNodeId = null;
    for (var objectType : fugrTreeContent.getObjectTypes()) {
      if (functionModulesNodeId != null && fugrIncludeNodeId != null) {
        break;
      }
      if (IAdtObjectTypeConstants.FUNCTION_INCLUDE.equals(objectType.getType())) {
        fugrIncludeNodeId = objectType.getNodeId();
        continue;
      }
      if (IAdtObjectTypeConstants.FUNCTION_MODULE.equals(objectType.getType())) {
        functionModulesNodeId = objectType.getNodeId();
        continue;
      }
    }

    if (functionModulesNodeId != null
        && (config.getFugrIncludeFlags() & FunctionGroupInclude.FUNCTION_INCLUDE.getBit()) != 0) {
      searchSubObjects(object, functionModulesNodeId, IAdtObjectTypeConstants.FUNCTION_MODULE,
          srcCodeReader, searcherFactory, result);
    }

    if (fugrIncludeNodeId != null && (config.getFugrIncludeFlags()
        & FunctionGroupInclude.NON_FUNCTION_INCLUDE.getBit()) != 0) {
      searchSubObjects(object, fugrIncludeNodeId, IAdtObjectTypeConstants.FUNCTION_INCLUDE,
          srcCodeReader, searcherFactory, result);
    }

    if (!result.getSearchObjects().isEmpty()) {
      insertFugrObject(object, result);
    }

    result.setNumberOfSearchedObjects(1);

    return result;
  }

  private void insertFugrObject(final SearchableObject object, final ICodeSearchResult result) {
    var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
    searchObject.setUri(object.getUri());
    var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
    adtMainObj.setType(object.getType());
    adtMainObj.setName(object.getName());
    adtMainObj.setUri(object.getUri());
    searchObject.setAdtMainObject(adtMainObj);
    result.getSearchObjects().add(0, searchObject);
  }

  private void searchSubObjects(final SearchableObject object, final String nodeId,
      final String relevantType, final ISourceCodeReader srcCodeReader,
      final ISourceCodeSearcherFactory searcherFactory, final ICodeSearchResult result) {

    var subObjects = determineSubObjects(object, relevantType, nodeId, result);
    if (subObjects == null) {
      return;
    }

    for (var subObject : subObjects) {
      if (monitor.isCanceled()) {
        return;
      }
      try {
        var sourceUri = subObject.getUri() + ISourceCodeReader.MAIN_SOURCE_PATH;
        var code = srcCodeReader.getSourceCode(sourceUri);
        var matches = searcherFactory.createSearcher(code).search();
        result.increaseLinesSearchedCode(code.lineCount());

        if (matches != null && !matches.isEmpty()) {
          insertSubObjResult(object, result, subObject, sourceUri, matches);
        }
        result.increaseNumberOfSearchedSources(1);
      } catch (ResourceException exc) {
        result.addResponseMessage(String.format("Error during source retrieval of [%] %s",
            subObject.getType(), object.getName()), MessageType.ERROR, exc);
      }
    }

  }

  private List<AdtObject> determineSubObjects(final SearchableObject object,
      final String relevantType, final String nodeId, final ICodeSearchResult result) {
    try {
      var treeContent = treeService.readTreeContent(monitor, IAdtObjectTypeConstants.FUNCTION_GROUP,
          object.getName(), object.getName(), null, new String[] { nodeId }, false, false, false,
          false);
      var searchableNodes = new ArrayList<AdtObject>();
      treeContent.forEach(c -> {
        if (relevantType.equals(c.getType())) {
          searchableNodes
              .add(new AdtObject(c.getUri().toString(), c.getName(), null, c.getType(), null));
        }
      });
      return searchableNodes;
    } catch (ResourceException exc) {
      result.addResponseMessage(
          String.format("Error during determination of tree nodes of function group '%s'",
              object.getName()),
          MessageType.ERROR, exc);
    }
    return null;
  }

  private void insertSubObjResult(final SearchableObject object, final ICodeSearchResult result,
      final AdtObject subObject, final String sourceUri, final List<Match> matches) {
    var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
    searchObject.setUri(subObject.getUri());
    var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
    adtMainObj.setType(subObject.getType());
    adtMainObj.setName(subObject.getName());
    searchObject.setAdtMainObject(adtMainObj);
    searchObject.setParentUri(object.getUri());
    matches.forEach(plainMatch -> {
      var match = ICodeSearchFactory.eINSTANCE.createCodeSearchMatch();
      match.setSnippet(plainMatch.snippet());
      match.setLongSnippet(plainMatch.longSnippet());
      match.setUri(sourceUri + String.format(MATCH_SUFFIX_FORMAT, plainMatch.line() + 1,
          plainMatch.offset(), plainMatch.endLine() + 1, plainMatch.endOffset()));
      searchObject.getMatches().add(match);
    });
    result.getSearchObjects().add(searchObject);
    result.increaseNumberOfResults(matches.size());
  }

}
