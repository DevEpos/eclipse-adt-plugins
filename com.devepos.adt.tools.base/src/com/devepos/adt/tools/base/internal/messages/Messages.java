package com.devepos.adt.tools.base.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.devepos.adt.tools.base.internal.messages.messages"; //$NON-NLS-1$
	public static String AdtUtil_LogonToProjectFailed_xmsg;
	public static String LazyLoadingTreeContentProvider_LoadingChildNodes_xmsg;
	public static String LazyLoadingTreeContentProvider_LoadingContent_xmsg;
	public static String LazyLoadingTreeContentProvider_UpdatingTreeContent_xmsg;
	public static String ProjectInput_BrowseProjects_xbut;
	public static String ProjectInput_NoProjectEntered_xmsg;
	public static String ProjectInput_Project_xfld;
	public static String ProjectInput_ProjectDoesNotExist_xmsg;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
