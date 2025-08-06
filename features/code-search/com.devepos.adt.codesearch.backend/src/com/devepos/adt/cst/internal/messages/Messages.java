package com.devepos.adt.cst.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

  public static String AbapClassSearchProvider_ClassSystemError_xmsg;
  public static String AbapClassSearchProvider_GlobalClassNotFound_xmsg;
  public static String AbapClassSearchProvider_IncludeSystemError_xmsg;
  public static String AbapClassSearchProvider_NoEndOfClassDefFound_xmsg;
  public static String AbapClassSearchProvider_UnknownClassError_xmsg;
  public static String AbapClassSearchProvider_UnknownIncludeError_xmsg;
  public static String CodeSearchSearchService_searchNotAvailableInProjectError_xmsg;
  public static String CodeSearchSearchService_clientSearchNotAvailableInProjectError_xmsg;
  public static String CodeSearchSearchService_namedItemNotAvailableInProject_xmsg;
  public static String ClassInclude_localClassDefinitionsInclude_xlbl;
  public static String ClassInclude_localClassTypesInclude_xlbl;
  public static String ClassInclude_macrosInclude_xlbl;
  public static String ClassInclude_methodsIncludes_xlbl;
  public static String ClassInclude_privateSectionInclude_xlbl;
  public static String ClassInclude_protectedSectionInclude_xlbl;
  public static String ClassInclude_publicSectionInclude_xlbl;
  public static String ClassInclude_testClassesInclude_xlbl;
  public static String FugrSearchProvider_FunctionNotFound_xmsg;
  public static String FugrSearchProvider_IncludeNotFound_xmsg;
  public static String FugrSearchProvider_RepoTreeLoadError_xmsg;
  public static String FugrSearchProvider_SubObjectSystemFailure_xmsg;
  public static String FugrSearchProvider_SubObjectTreeLoadError_xmsg;
  public static String FugrSearchProvider_UnknownSubObjectError_xmsg;
  public static String FunctionGroupInclude_functionsIncludes_xchk;
  public static String FunctionGroupInclude_otherIncludes_xchk;

  public static String PatternUtil_ErrBoundaryNotClosed_xmsg;
  public static String PatternUtil_ErrCtrlSequWithoutPattern_xmsg;
  public static String PatternUtil_ErrInvalidControlSequCombo_xmsg;
  public static String PatternUtil_ErrInvalidControlSequInPattern_xmsg;
  public static String PatternUtil_ErrMatchControlSequViolated_xmsg;
  public static String PatternUtil_ErrNoMatchSequStart_xmsg;
  public static String PatternUtil_ErrNoUnopenedBoundarySequence_xmsg;
  public static String PatternUtil_ErrOnlyExcludesFound_xmsg;
  public static String PatternUtil_ErrUnclosedBoundarySequence_xmsg;
  public static String PatternUtil_ErrUnclosedMatchSequence_xmsg;

  public static String StringSourceSearchProvider_ObjectNotFound_xmsg;
  public static String StringSourceSearchProvider_SystemError_xmsg;
  public static String StringSourceSearchProvider_UnknownError_xmsg;

  private Messages() {
  }

  static {
    // initialize resource bundle
    NLS.initializeMessages("com.devepos.adt.cst.internal.messages.messages", Messages.class); //$NON-NLS-1$
  }
}
