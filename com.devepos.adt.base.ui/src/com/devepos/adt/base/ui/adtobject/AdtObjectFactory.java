package com.devepos.adt.base.ui.adtobject;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.ObjectType;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class AdtObjectFactory {

    /**
     * Creates {@link IAdtObject} from the given {@code objectReference}
     *
     * @param objectReference ADT Object Reference
     * @return
     */
    public static IAdtObject create(final IAdtObjectReference objectReference, final IProject project) {
        return new AdtObject(objectReference.getName(), objectReference, ObjectType.getFromAdtType(objectReference
                .getType()), project);
    }
}
