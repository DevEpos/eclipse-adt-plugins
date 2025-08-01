package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.MessageType;
import com.devepos.adt.cst.internal.search.client.engine.AdtRepoTreeContent.AdtRepoTreeObjectNode;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.FunctionGroupInclude;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.SearchableObject;
import com.sap.adt.communication.resources.ResourceException;

public class FugrSearchProvider implements ISearchProvider {

  private final IClientCodeSearchConfig config;
  private final IProgressMonitor monitor;
  private final AdtRepoTreeService repoTreeSrv;

  public FugrSearchProvider(final IClientCodeSearchConfig config, final IProgressMonitor monitor,
      final String destinationId) {
    this.config = config;
    this.monitor = monitor;
    repoTreeSrv = new AdtRepoTreeService(destinationId);
  }

  @Override
  public ICodeSearchResult search(final SearchableObject object,
      final ISourceCodeReader srcCodeReader, final ISourceCodeSearcherFactory searcherFactory) {

    var result = ICodeSearchFactory.eINSTANCE.createCodeSearchResult();

    // we need to determine the correct node id's as they are not the same for all function
    // groups
    var fugrTreeContent = repoTreeSrv.loadTreeContent(monitor, object.getName(),
        IAdtObjectTypeConstants.FUNCTION_GROUP, "000000");

    var relevantNodeIds = new ArrayList<String>();
    for (var objectType : fugrTreeContent.getObjectTypes()) {
      if ((IAdtObjectTypeConstants.FUNCTION_INCLUDE.equals(objectType.getObjectType())
          && (config.getFugrIncludeFlags()
              & FunctionGroupInclude.NON_FUNCTION_INCLUDE.getBit()) != 0)
          || (IAdtObjectTypeConstants.FUNCTION_MODULE.equals(objectType.getObjectType())
              && (config.getFugrIncludeFlags()
                  & FunctionGroupInclude.FUNCTION_INCLUDE.getBit()) != 0)) {
        relevantNodeIds.add(objectType.getNodeId());
        continue;
      }
    }

    if (!relevantNodeIds.isEmpty()) {
      searchSubObjects(object, relevantNodeIds, srcCodeReader, searcherFactory, result);
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

  private void searchSubObjects(final SearchableObject object, final List<String> nodeIds,
      final ISourceCodeReader srcCodeReader, final ISourceCodeSearcherFactory searcherFactory,
      final ICodeSearchResult result) {

    var subObjects = determineSubObjects(object, nodeIds, result);
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
            subObject.getObjectType(), object.getName()), MessageType.ERROR, exc);
      }
    }

  }

  private List<AdtRepoTreeObjectNode> determineSubObjects(final SearchableObject object,
      final List<String> nodeIds, final ICodeSearchResult result) {
    try {
      var treeContent = repoTreeSrv.loadTreeContent(monitor, object.getName(),
          IAdtObjectTypeConstants.FUNCTION_GROUP, nodeIds.toArray(String[]::new));
      return treeContent != null ? treeContent.getObjectNodes() : null;
    } catch (ResourceException exc) {
      result.addResponseMessage(
          String.format("Error during determination of tree nodes of function group '%s'",
              object.getName()),
          MessageType.ERROR, exc);
    }
    return null;
  }

  private void insertSubObjResult(final SearchableObject object, final ICodeSearchResult result,
      final AdtRepoTreeObjectNode subObject, final String sourceUri, final List<Match> matches) {
    var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
    searchObject.setUri(subObject.getUri());
    var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
    adtMainObj.setType(subObject.getObjectType());
    adtMainObj.setName(subObject.getObjectName());
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
