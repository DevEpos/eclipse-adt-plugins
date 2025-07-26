package com.devepos.adt.cst.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

  public static String CodeSearchSearchService_searchNotAvailableInProjectError_xmsg;
  public static String CodeSearchSearchService_namedItemNotAvailableInProject_xmsg;
  public static String ClassInclude_localClassDefinitionsInclude_xlbl;
  public static String ClassInclude_localClassTypesInclude_xlbl;
  public static String ClassInclude_macrosInclude_xlbl;
  public static String ClassInclude_methodsIncludes_xlbl;
  public static String ClassInclude_privateSectionInclude_xlbl;
  public static String ClassInclude_protectedSectionInclude_xlbl;
  public static String ClassInclude_publicSectionInclude_xlbl;
  public static String ClassInclude_testClassesInclude_xlbl;
  public static String FunctionGroupInclude_functionsIncludes_xchk;
  public static String FunctionGroupInclude_otherIncludes_xchk;

  private Messages() {
  }

  static {
    // initialize resource bundle
    NLS.initializeMessages("com.devepos.adt.cst.internal.messages.messages", Messages.class); //$NON-NLS-1$
  }
}
