package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.MessageType;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.ClassInclude;
import com.devepos.adt.cst.search.IIncludeToSearch;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.SearchableObject;
import com.sap.adt.communication.exceptions.CommunicationException;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.resources.ResourceNotFoundException;

public class AbapClassSearchProvider implements ISearchProvider {
  private static final String METHOD_URI_SEGMENT = "#type=CLAS%2FOM;name=";
  private static final String PUB_SEC_URI_SEGMENT = "#type=CLAS%2FOSU;name=";
  private static final String PROT_SEC_URI_SEGMENT = "#type=CLAS%2FOSO;name=";
  private static final String PRIV_SEC_URI_SEGMENT = "#type=CLAS%2FOSI;name=";

  private static final String PUBLIC_SEC_NAME = "public";
  private static final String PROTECTED_SEC_NAME = "protected";
  private static final String PRIVATE_SEC_NAME = "private";

  private static final String INCLUDES_PATH_SEGMENT = "/includes/";

  private static final Pattern END_CLASS_PATTERN = Pattern.compile("^\s*endclass\s*",
      Pattern.CASE_INSENSITIVE);
  private static final Pattern SECTIONS_PATTERN = Pattern
      .compile("^\s*(public|protected|private)\s*section\s*.", Pattern.CASE_INSENSITIVE);
  private static final Pattern METHOD_IMPL_BEGIN_PATTERN = Pattern
      .compile("^\\s*method\\s+([\\w/~]+)", Pattern.CASE_INSENSITIVE);
  private static final Pattern METHOD_IMPL_END_PATTERN = Pattern.compile("^\s*endmethod\s*\\.",
      Pattern.CASE_INSENSITIVE);

  private final IClientCodeSearchConfig config;

  private record SourceSection(int startLine, int endLine, String type, String uriSuffix,
      String name) {
  }

  private static final class ClassSectionException extends Exception {
    private static final long serialVersionUID = 1L;

    public ClassSectionException(final String message) {
      super(message);
    }
  }

  public AbapClassSearchProvider(final IClientCodeSearchConfig config) {
    this.config = config;
  }

  @Override
  public ICodeSearchResult search(final SearchableObject object,
      final ISourceCodeReader srcCodeReader, final ISourceCodeSearcherFactory searcherFactory) {

    var result = ICodeSearchFactory.eINSTANCE.createCodeSearchResult();

    searchMainInclude(object, srcCodeReader, searcherFactory, result);
    if ((config.getClassIncludeFlags() & ClassInclude.LOCAL_DEFINITIONS.getBit()) != 0) {
      searchInclude(ClassInclude.LOCAL_DEFINITIONS, object, srcCodeReader, searcherFactory, result);
    }
    if ((config.getClassIncludeFlags() & ClassInclude.LOCAL_IMPLEMENTATIONS.getBit()) != 0) {
      searchInclude(ClassInclude.LOCAL_IMPLEMENTATIONS, object, srcCodeReader, searcherFactory,
          result);
    }
    if ((config.getClassIncludeFlags() & ClassInclude.MACROS.getBit()) != 0) {
      searchInclude(ClassInclude.MACROS, object, srcCodeReader, searcherFactory, result);
    }
    if ((config.getClassIncludeFlags() & ClassInclude.TESTS.getBit()) != 0) {
      searchInclude(ClassInclude.TESTS, object, srcCodeReader, searcherFactory, result);

    }

    if (!result.getSearchObjects().isEmpty()) {
      insertClassResultObject(object, result);
    }
    result.setNumberOfSearchedObjects(1);
    return result;
  }

  private void searchMainInclude(final SearchableObject object,
      final ISourceCodeReader srcCodeReader, final ISourceCodeSearcherFactory searcherFactory,
      final ICodeSearchResult result) {

    var flags = config.getClassIncludeFlags();
    var isPublicSec = (flags & ClassInclude.PUBLIC_SECTION.getBit()) != 0;
    var isProtSec = (flags & ClassInclude.PROTECTED_SECTION.getBit()) != 0;
    var isPrivateSec = (flags & ClassInclude.PRIVATE_SECTION.getBit()) != 0;
    var isMethods = (flags & ClassInclude.METHODS.getBit()) != 0;

    if (flags == 0 || !isPublicSec && !isProtSec && !isPrivateSec && !isMethods) {
      return;
    }

    try {
      var main = srcCodeReader.getSourceCode(object.getUri() + ISourceCodeReader.MAIN_SOURCE_PATH);
      var code = main.content()[0];
      var codeLines = code.split("\n");
      getRelevantSections(codeLines, object.getName(), isPublicSec, isProtSec, isPrivateSec,
          isMethods).forEach(section -> {
            try {
              searchMainIncludeSection(object, section, main, codeLines, searcherFactory, result);
            } catch (Exception exc) {
              exc.printStackTrace();
            }
            result.increaseNumberOfSearchedSources(1);
          });
    } catch (ResourceNotFoundException exc) {
      return;
    } catch (ClassSectionException | ResourceException | CommunicationException exc) {
      result.addResponseMessage(
          String.format("Error during search of global class include of %s", object.getName()),
          MessageType.ERROR, exc);
    }
  }

  private void searchInclude(final IIncludeToSearch include, final SearchableObject o,
      final ISourceCodeReader srcCodeReader, final ISourceCodeSearcherFactory searcherFactory,
      final ICodeSearchResult result) {
    try {
      var uri = o.getUri() + INCLUDES_PATH_SEGMENT + include.getAdtApiInclName();
      var code = srcCodeReader.getSourceCode(uri);
      result.increaseNumberOfSearchedSources(1);
      var matches = searcherFactory.createSearcher(code).search();

      if (matches != null && !matches.isEmpty()) {
        var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
        searchObject.setUri(uri);
        var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
        adtMainObj.setType(IAdtObjectTypeConstants.CLASS_INCLUDE);
        adtMainObj.setName(include.getLabelWoMnemonic());
        searchObject.setAdtMainObject(adtMainObj);
        searchObject.setParentUri(o.getUri());
        matches.forEach(plainMatch -> {
          var match = ICodeSearchFactory.eINSTANCE.createCodeSearchMatch();
          match.setSnippet(plainMatch.snippet());
          match.setLongSnippet(plainMatch.longSnippet());
          match.setUri(uri + String.format(MATCH_SUFFIX_FORMAT, plainMatch.line() + 1,
              plainMatch.offset(), plainMatch.endLine() + 1, plainMatch.endOffset()));
          searchObject.getMatches().add(match);
        });
        result.getSearchObjects().add(searchObject);
        result.increaseNumberOfResults(matches.size());
      }
      result.setLinesOfSearchedCode(code.lineCount());
    } catch (ResourceNotFoundException exc) {
      return;
    } catch (CommunicationException | ResourceException exc) {
      result.addResponseMessage(
          String.format("Error during search of include '%s' of object [%s]: %s",
              include.getLabelWoMnemonic(), o.getType(), o.getName()),
          MessageType.ERROR, exc);
    }
  }

  private void searchMainIncludeSection(final SearchableObject o, final SourceSection section,
      final ISourceCode main, final String[] codeLines,
      final ISourceCodeSearcherFactory searcherFactory, final ICodeSearchResult result) {
    ISourceCode sectionCode = null;
    if (config.isMultilineSearchOption()) {
      sectionCode = main.extract(section.startLine(), section.endLine());
    } else {
      sectionCode = new SourceCode(
          Arrays.copyOfRange(codeLines, section.startLine(), section.endLine() + 1), null,
          main.commentRegex());
    }

    var matches = searcherFactory.createSearcher(sectionCode).search();
    if (matches != null && !matches.isEmpty()) {
      var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
      searchObject.setUri(o.getUri() + ISourceCodeReader.MAIN_SOURCE_PATH + section.uriSuffix());
      var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
      adtMainObj.setType(section.type());
      adtMainObj.setName(section.name());
      searchObject.setAdtMainObject(adtMainObj);
      searchObject.setParentUri(o.getUri());
      matches.forEach(plainMatch -> {
        var match = ICodeSearchFactory.eINSTANCE.createCodeSearchMatch();
        match.setSnippet(plainMatch.snippet());
        match.setLongSnippet(plainMatch.longSnippet());
        if (!config.isMultilineSearchOption()) {
          match.setUri(o.getUri() + ISourceCodeReader.MAIN_SOURCE_PATH
              + String.format(MATCH_SUFFIX_FORMAT, section.startLine() + plainMatch.line() + 1,
                  plainMatch.offset(), section.startLine() + plainMatch.endLine() + 1,
                  plainMatch.endOffset()));
        } else {
          // determine the start and end line in the full main include
          var mainStartLine = main.indexes()[section.startLine() + plainMatch.line()];
          var mainEndLine = plainMatch.line() != plainMatch.endLine()
              ? main.indexes()[section.startLine() + plainMatch.endLine()]
              : mainStartLine;
          match.setUri(o.getUri() + ISourceCodeReader.MAIN_SOURCE_PATH
              + String.format(MATCH_SUFFIX_FORMAT, mainStartLine.number() + 1, plainMatch.offset(),
                  mainEndLine.number() + 1, plainMatch.endOffset()));
        }
        searchObject.getMatches().add(match);
      });

      result.getSearchObjects().add(searchObject);
      result.increaseNumberOfResults(matches.size());
    }
    result.increaseLinesSearchedCode(sectionCode.lineCount());
  }

  /*
   * Extracts relevant sections in the global include that shall be searched
   */
  private List<SourceSection> getRelevantSections(final String[] codeLines, final String className,
      final boolean pubSec, final boolean protSec, final boolean privSec, final boolean methodSecs)
      throws ClassSectionException {
    List<SourceSection> sections = new ArrayList<>();

    var methodStartIndex = 0;
    if (pubSec || protSec || privSec) {
      var endClassLine = findEndClassLine(codeLines);
      if (endClassLine == -1) {
        throw new ClassSectionException("End of class definition not found");
      }

      var privIndex = -1;
      var protIndex = -1;
      var pubIndex = -1;
      for (var i = endClassLine; i > 0; i--) {
        var sectionMatcher = SECTIONS_PATTERN.matcher(codeLines[i]);
        if (!sectionMatcher.find()) {
          continue;
        }
        var sectionName = sectionMatcher.group(1).toLowerCase();
        if (privIndex == -1 && PRIVATE_SEC_NAME.equals(sectionName)) {
          privIndex = i;
          if (privSec) {
            sections.add(new SourceSection(i, endClassLine - 1,
                IAdtObjectTypeConstants.CLASS_INCLUDE, PRIV_SEC_URI_SEGMENT + className,
                ClassInclude.PRIVATE_SECTION.getLabelWoMnemonic()));
          }
          continue;
        }
        if (protIndex == -1 && PROTECTED_SEC_NAME.equals(sectionName)) {
          protIndex = i;
          if (protSec) {
            sections.add(new SourceSection(i, privIndex == -1 ? endClassLine - 1 : privIndex - 1,
                IAdtObjectTypeConstants.CLASS_INCLUDE, PROT_SEC_URI_SEGMENT + className,
                ClassInclude.PROTECTED_SECTION.getLabelWoMnemonic()));
          }
          continue;
        }
        if (pubIndex == -1 && PUBLIC_SEC_NAME.equals(sectionName) && pubSec) {
          pubIndex = i;
          sections.add(new SourceSection(0,
              protIndex != -1 ? protIndex - 1 : privIndex != -1 ? privIndex - 1 : endClassLine - 1,
              IAdtObjectTypeConstants.CLASS_INCLUDE, PUB_SEC_URI_SEGMENT + className,
              ClassInclude.PUBLIC_SECTION.getLabelWoMnemonic()));
        }
      }
      // edge case when public section has not been specified
      if (pubSec && pubIndex == -1) {
        sections.add(new SourceSection(0,
            protIndex != -1 ? protIndex - 1 : privIndex != -1 ? privIndex - 1 : endClassLine - 1,
            IAdtObjectTypeConstants.CLASS_INCLUDE, PUB_SEC_URI_SEGMENT + className,
            ClassInclude.PUBLIC_SECTION.getLabelWoMnemonic()));
      }
    }

    if (methodSecs) {
      var methodBegin = -1;
      String methodName = null;
      for (var i = methodStartIndex; i < codeLines.length; i++) {
        if (methodBegin == -1) {
          methodName = getMethodName(codeLines[i]);
          if (methodName != null) {
            methodBegin = i;
          }
          continue;
        }
        if (isMethodEnd(codeLines[i])) {
          sections
              .add(new SourceSection(methodBegin, i, IAdtObjectTypeConstants.METHOD_IMPLEMENTATION,
                  METHOD_URI_SEGMENT + methodName.toUpperCase(), methodName.toUpperCase()));
          methodBegin = -1;
          methodName = null;
        }
      }
    }
    return sections;
  }

  private int findEndClassLine(final String[] codeLines) {
    for (var i = 0; i < codeLines.length; i++) {
      if (END_CLASS_PATTERN.matcher(codeLines[i]).find()) {
        return i;
      }
    }
    return -1;
  }

  private String getMethodName(final String codeLine) {
    var matcher = METHOD_IMPL_BEGIN_PATTERN.matcher(codeLine);
    if (matcher.find()) {
      return matcher.group(1);
    }
    return null;
  }

  private boolean isMethodEnd(final String codeLine) {
    return METHOD_IMPL_END_PATTERN.matcher(codeLine).find();
  }

  private void insertClassResultObject(final SearchableObject object,
      final ICodeSearchResult result) {
    var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
    searchObject.setUri(object.getUri());
    var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
    adtMainObj.setType(object.getType());
    adtMainObj.setName(object.getName());
    adtMainObj.setUri(object.getUri());
    searchObject.setAdtMainObject(adtMainObj);
    result.getSearchObjects().add(0, searchObject);
  }

}
