package com.devepos.adt.cst.internal.search.client.engine;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.MessageType;
import com.devepos.adt.cst.internal.messages.Messages;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.client.SearchableObject;
import com.sap.adt.communication.exceptions.CommunicationException;
import com.sap.adt.communication.exceptions.SystemFailureException;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.resources.ResourceForbiddenException;
import com.sap.adt.communication.resources.ResourceNotFoundException;

/**
 * Generic search provider for searching in string-based source code
 *
 * @author stockbal
 */
public class StringSourceSearchProvider implements ISearchProvider {
  private static final String PROG_INCLUDE_URI_SEGMENT = "/programs/includes/";
  private static final String PROG_PROGRAM_URI_SEGMENT = "/programs/programs/";

  @Override
  public ICodeSearchResult search(final SearchableObject o, final ISourceCodeReader srcCodeReader,
      final ISourceCodeSearcherFactory searcherFactory) {
    var result = ICodeSearchFactory.eINSTANCE.createCodeSearchResult();

    try {
      var sourceUri = o.getUri() + ISourceCodeReader.MAIN_SOURCE_PATH;
      var code = getSourceCode(o, sourceUri, srcCodeReader);
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
          // do not reuse possibly adjusted source code URI
          match.setUri(o.getUri() + ISourceCodeReader.MAIN_SOURCE_PATH
              + String.format(MATCH_SUFFIX_FORMAT, plainMatch.line() + 1, plainMatch.offset(),
                  plainMatch.endLine() + 1, plainMatch.endOffset()));
          searchObject.getMatches().add(match);
        });

        result.getSearchObjects().add(searchObject);
        result.setNumberOfResults(matches.size());
      }
      result.setLinesOfSearchedCode(code.lineCount());
    } catch (SystemFailureException exc) {
      result.addResponseMessage(String.format(Messages.StringSourceSearchProvider_SystemError_xmsg,
          o.getName(), o.getType()), MessageType.ERROR, exc);
    } catch (ResourceForbiddenException exc) {
      result.addResponseMessage(
          String.format(Messages.StringSourceSearchProvider_MissingAuthorizationError_xmsg,
              o.getName(), o.getType()),
          MessageType.ERROR, exc);
    } catch (ResourceNotFoundException exc) {
      result
          .addResponseMessage(String.format(Messages.StringSourceSearchProvider_ObjectNotFound_xmsg,
              o.getName(), o.getType()), MessageType.ERROR, exc);
    } catch (CommunicationException | ResourceException exc) {
      AdtResourceUtil.handleNetworkError(exc);
      result.addResponseMessage(String.format(Messages.StringSourceSearchProvider_UnknownError_xmsg,
          o.getType(), o.getName()), MessageType.ERROR, exc);
    }
    result.setNumberOfSearchedObjects(1);
    result.setNumberOfSearchedSources(1);
    return result;
  }

  private ISourceCode getSourceCode(SearchableObject o, String uri,
      ISourceCodeReader srcCodeReader) {
    try {
      return srcCodeReader.getSourceCode(uri);
    } catch (ResourceException exc) {
      // Bug in ADT backend could return incorrect type from virtual folder tree
      if (uri.contains(PROG_INCLUDE_URI_SEGMENT)) {
        uri = uri.replace(PROG_INCLUDE_URI_SEGMENT, PROG_PROGRAM_URI_SEGMENT);
        var code = srcCodeReader.getSourceCode(uri);
        // adjust type and uri in object, so result node is created correctly
        o.setType(IAdtObjectTypeConstants.PROGRAM);
        o.setUri(o.getUri().replace(PROG_INCLUDE_URI_SEGMENT, PROG_PROGRAM_URI_SEGMENT));
        return code;
      } else {
        throw exc;
      }
    }
  }
}
