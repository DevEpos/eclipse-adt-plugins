package com.devepos.adt.atm.model.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.devepos.adt.atm.model.internal.messages.messages"; //$NON-NLS-1$
	public static String TagListValidator_TagLengthInvalid_xmsg;
	public static String TagListValidator_DuplicateTagNameFound_xmsg;
	public static String TagListValidator_InvalidCharactersInTag_xmsg;
	public static String TagListValidator_NoTagName_xmsg;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
