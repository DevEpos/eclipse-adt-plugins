package com.devepos.adt.saat.ui.internal.cdsanalysis;

import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.saat.ui.internal.CdsSourceType;
import com.devepos.adt.saat.ui.internal.ExtendedAdtObjectInfo;

/**
 * Converts {@link IAdtObjRef} into {@link IAdtObjectReferenceElementInfo}.<br />
 * It also sets additional object if some custom attributes are available in the object reference.
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class AdtObjRefToElemInfoConverter {

  public static IAdtObjectReferenceElementInfo convert(final String destinationId,
      final IAdtObjRef adtObjRef) {
    if (adtObjRef == null) {
      return null;
    }
    var elementInfo = new AdtObjectReferenceElementInfo(adtObjRef.getName(),
        adtObjRef.getDisplayName(), adtObjRef.getDescription());
    elementInfo.setAdtObjectReference(
        AdtObjectReferenceModelFactory.createReference(destinationId, adtObjRef));
    adtObjRef.getProperties()
        .forEach(p -> elementInfo.getProperties().put(p.getKey(), p.getValue()));

    // handle custom properties
    var apiState = adtObjRef.getProperties().get("API_STATE");
    var sourceType = adtObjRef.getProperties().get("SOURCE_TYPE");
    if (apiState != null || sourceType != null) {
      var extendedAdtObjInfo = new ExtendedAdtObjectInfo();
      extendedAdtObjInfo.setApiState(apiState);
      extendedAdtObjInfo.setSourceType(CdsSourceType.getFromId(sourceType));
      elementInfo.setAdditionalInfo(extendedAdtObjInfo);
    }
    return elementInfo;
  }
}
