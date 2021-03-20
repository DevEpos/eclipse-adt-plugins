package com.devepos.adt.base.adtobject;

import java.net.URI;

import com.sap.adt.tools.core.AdtObjectReference;
import com.sap.adt.tools.core.IAdtObjectReference;

/**
 * Adapter Factory for ADT Object Reference
 *
 * @author stockbal
 */
public class AdtObjectReferenceAdapterFactory {

    /**
     * Adapts an EMF ADT Object Reference to the ADT Object reference
     *
     * @param adtObjectRef EMF ADT Object Reference
     * @return
     */
    public static IAdtObjectReference adaptToNonEmfAdtObjectRef(
            final com.sap.adt.tools.core.model.adtcore.IAdtObjectReference adtObjectRef) {
        if (adtObjectRef == null) {
            return null;
        }
        final String uriString = adtObjectRef.getUri();
        final URI refUri = uriString != null ? URI.create(uriString) : null;
        return new AdtObjectReference(refUri, adtObjectRef.getName(), adtObjectRef.getType(), null, adtObjectRef
                .getPackageName(), adtObjectRef.getDescription());
    }
}
