package com.devepos.adt.saat.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
  private static final String BUNDLE_NAME = Messages.class.getPackageName() + ".messages"; //$NON-NLS-1$
  public static String FeatureStatus_CdsAnalysisFeatureNotAvailable_xmsg;
  public static String FeatureStatus_GeneralFeatureNotAvailable_xmsg;

  private Messages() {
  }

  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }
}
