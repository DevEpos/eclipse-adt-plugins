package com.devepos.adt.atm.ui.internal.propertytester;

import org.eclipse.core.expressions.PropertyTester;

import com.devepos.adt.atm.ui.internal.util.AdtObjectCapabilities;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.util.AdtTypeUtil;

public class AdtObjectPropertyTester extends PropertyTester {

  private static final String IS_TAGGABLE = "isTaggable";
  private static final String IS_GLOBAL_TYPE = "isGlobalType";

  public AdtObjectPropertyTester() {
  }

  @Override
  public boolean test(final Object receiver, final String property, final Object[] args,
      final Object expectedValue) {
    if (!(receiver instanceof IAdtObject)) {
      return false;
    }
    var adtObj = (IAdtObject) receiver;
    if (property.equals(IS_TAGGABLE)) {
      return AdtObjectCapabilities.getInstance().isTaggable(adtObj);
    } else if (property.equals(IS_GLOBAL_TYPE)) {
      var typeUtil = AdtTypeUtil.getInstance();
      var adtType = adtObj.getReference().getType();
      return !typeUtil.isLocalClassType(adtType) && !typeUtil.isLocalInterfaceType(adtType);
    }
    return false;
  }

}
