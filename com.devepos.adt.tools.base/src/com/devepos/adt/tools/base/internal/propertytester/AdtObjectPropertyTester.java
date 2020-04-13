package com.devepos.adt.tools.base.internal.propertytester;

import org.eclipse.core.expressions.PropertyTester;

import com.devepos.adt.tools.base.adtobject.IAdtObject;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class AdtObjectPropertyTester extends PropertyTester {

	/**
	 * Property to test if the ADT object supports the data preview feature or not
	 */
	private static final String SUPPORTS_DATA_PREVIEW = "supportsDataPreview"; //$NON-NLS-1$

	private static final String ADT_TYPE = "adtType"; //$NON-NLS-1$

	public AdtObjectPropertyTester() {
	}

	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		if (!(receiver instanceof IAdtObject)) {
			return false;
		}
		final IAdtObject res = (IAdtObject) receiver;
		if (property.equals(SUPPORTS_DATA_PREVIEW)) {
			final boolean expectedBooleanValue = expectedValue instanceof Boolean ? (Boolean) expectedValue : true;
			return res.supportsDataPreview() == expectedBooleanValue;
		} else if (property.equals(ADT_TYPE)) {
			final IAdtObjectReference objectRef = res.getReference();
			if (objectRef != null) {
				final String type = objectRef.getType();
				if (type != null && expectedValue instanceof String) {
					return type.equalsIgnoreCase((String) expectedValue);
				}
			}
			return false;
		}
		return false;
	}

}
