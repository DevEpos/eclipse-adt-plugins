package com.devepos.adt.cst.internal.search.client.engine;

import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.MessageType;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.client.SearchableObject;
import com.sap.adt.communication.exceptions.CommunicationException;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.resources.ResourceNotFoundException;

public class StringSourceSearchProvider implements ISearchProvider {

  @Override
  public ICodeSearchResult search(final SearchableObject o, final ISourceCodeReader srcCodeReader,
      final ISourceCodeSearcherFactory searcherFactory) {
    var result = ICodeSearchFactory.eINSTANCE.createCodeSearchResult();

    try {
      var sourceUri = o.getUri() + ISourceCodeReader.MAIN_SOURCE_PATH;
      var code = srcCodeReader.getSourceCode(sourceUri);
      var matches = searcherFactory.createSearcher(code).search();

      if (matches != null && !matches.isEmpty()) {
        var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
        searchObject.setUri(o.getUri());
        var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
        adtMainObj.setType(o.getType());
        adtMainObj.setName(o.getName());
        adtMainObj.setUri(o.getUri());
        searchObject.setAdtMainObject(adtMainObj);
        matches.forEach(plainMatch -> {
          var match = ICodeSearchFactory.eINSTANCE.createCodeSearchMatch();
          match.setSnippet(plainMatch.snippet());
          match.setLongSnippet(plainMatch.longSnippet());
          match.setUri(sourceUri + String.format(MATCH_SUFFIX_FORMAT, plainMatch.line() + 1,
              plainMatch.offset(), plainMatch.endLine() + 1, plainMatch.endOffset()));
          searchObject.getMatches().add(match);
        });

        result.getSearchObjects().add(searchObject);
        result.setNumberOfResults(matches.size());
      }
      result.setLinesOfSearchedCode(code.lineCount());
    } catch (ResourceNotFoundException exc) {
      // do nothing
    } catch (CommunicationException | ResourceException exc) {
      result.addResponseMessage(
          String.format("Error during search of object [%s]: %s", o.getType(), o.getName()),
          MessageType.ERROR, exc);
    }
    result.setNumberOfSearchedObjects(1);
    result.setNumberOfSearchedSources(1);
    return result;
  }

}
