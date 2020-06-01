package com.devepos.adt.tools.base.adtobject;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.tools.base.ObjectType;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class AdtObjectFactory {

	/**
	 * Creates {@link IAdtObject} from the given {@code objectReference}
	 *
	 * @param  objectReference ADT Object Reference
	 * @return
	 */
	public static IAdtObject create(final IAdtObjectReference objectReference, final IProject project) {
		final ObjectType objType = ObjectType.getFromAdtType(objectReference.getType());
		return new AdtObject(objectReference.getName(), objectReference, objType, project);
	}
}
