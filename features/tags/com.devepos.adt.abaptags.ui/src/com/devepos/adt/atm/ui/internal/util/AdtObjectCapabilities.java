package com.devepos.adt.atm.ui.internal.util;

import java.util.Arrays;
import java.util.List;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.ui.adtobject.IAdtObject;

/**
 * Simple utility class to check capabilities of an ADT object for ABAP Tags specific activities
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class AdtObjectCapabilities {

  private static AdtObjectCapabilities INSTANCE;
  private final List<String> taggableObjectTypes;
  private final List<String> validTypesForObjectTagsView;

  private AdtObjectCapabilities() {
    taggableObjectTypes = Arrays.asList(IAdtObjectTypeConstants.CLASS,
        IAdtObjectTypeConstants.CLASS_LOCAL_CLASS, IAdtObjectTypeConstants.CLASS_LOCAL_INTERFACE,
        IAdtObjectTypeConstants.PROGRAM, IAdtObjectTypeConstants.PROGRAM_LOCAL_CLASS,
        IAdtObjectTypeConstants.PROGRAM_LOCAL_INTERFACE,
        IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE, IAdtObjectTypeConstants.FUNCTION_GROUP,
        IAdtObjectTypeConstants.STRUCTURE, IAdtObjectTypeConstants.FUNCTION_INCLUDE,
        IAdtObjectTypeConstants.FUNCTION_MODULE, IAdtObjectTypeConstants.FUNCTION_GROUP_LOCAL_CLASS,
        IAdtObjectTypeConstants.FUNCTION_GROUP_LOCAL_INTERFACE);
    validTypesForObjectTagsView = Arrays.asList(IAdtObjectTypeConstants.CLASS,
        IAdtObjectTypeConstants.PROGRAM, IAdtObjectTypeConstants.PROGRAM_INCLUDE,
        IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE, IAdtObjectTypeConstants.STRUCTURE,
        IAdtObjectTypeConstants.FUNCTION_GROUP, IAdtObjectTypeConstants.FUNCTION_INCLUDE,
        IAdtObjectTypeConstants.FUNCTION_MODULE);
  }

  public static AdtObjectCapabilities getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AdtObjectCapabilities();
    }
    return INSTANCE;
  }

  /**
   * Returns {@code true} if the given Adt Object is taggable
   *
   * @param adtObject adt object to test
   * @return
   */
  public boolean isTaggable(final IAdtObject adtObject) {
    if (adtObject == null) {
      return false;
    }
    return isTypeTaggable(adtObject.getReference().getType());
  }

  /**
   * Returns {@code true} if the given ADT Object type (e.g. CLAS/OC) is a taggable type
   *
   * @param adtType adt workbench type
   */
  public boolean isTypeTaggable(final String adtType) {
    if (adtType == null) {
      return false;
    }
    return isRestrictedType(adtType) ? taggableObjectTypes.contains(adtType) : true;
  }

  /**
   * Returns {@code true} if the given ADT Object type (e.g. CLAS/OC) is valid so the corresponding
   * object can be shown in the 'Object Tags' view
   *
   * @param adtType ADT workbench type
   */
  public boolean isTypeValidForObjectTagsView(final String adtType) {
    if (adtType == null) {
      return false;
    }
    return isRestrictedType(adtType) ? validTypesForObjectTagsView.contains(adtType) : true;
  }

  public boolean isValidForObjectTagsView(final IAdtObject adtObject) {
    if (adtObject == null) {
      return false;
    }
    return isTypeValidForObjectTagsView(adtObject.getReference().getType());
  }

  /*
   * Some types have sub types that are not relevant at all places/views, therefore a restriction to
   * certain sub types is required.
   *
   * This method checks if a type needs restriction or not
   */
  private boolean isRestrictedType(final String adtType) {
    return adtType.startsWith(ITadirTypeConstants.CLASS)
        || adtType.startsWith(ITadirTypeConstants.FUNCTION_GROUP)
        || adtType.startsWith(ITadirTypeConstants.PROGRAM)
        || adtType.startsWith(ITadirTypeConstants.TABLE);
  }
}
