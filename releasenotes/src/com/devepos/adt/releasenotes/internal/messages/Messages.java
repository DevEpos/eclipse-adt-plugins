package com.devepos.adt.releasenotes.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
  private static final String BUNDLE_NAME = Messages.class.getPackageName() + ".messages"; //$NON-NLS-1$
  public static String ReleaseNotesEditorInput_editorTitleSuffix_xtit;
  public static String Startup_releaseNotesJobPrefix_xmsg;

  private Messages() {
  }

  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }
}
