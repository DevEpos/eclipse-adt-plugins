package com.devepos.adt.tools.base.util;

import com.sap.adt.communication.message.HeadersFactory;
import com.sap.adt.communication.message.IHeaders;

/**
 * ADT convenience methods for UI
 *
 * @author stockbal
 */
public class AdtUtil {

	/**
	 * Retrieve headers for REST request
	 *
	 * @return headers for REST request
	 */
	public static IHeaders getHeaders() {
		final IHeaders headers = HeadersFactory.newHeaders();
		headers.addField(HeadersFactory.newField("Accept", "application/xml")); //$NON-NLS-1$ //$NON-NLS-2$
		return headers;
	}
}
