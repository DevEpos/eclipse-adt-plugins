package com.devepos.adt.base;

/**
 * Relevant (ADT) Object type for the Plugin
 *
 * @author stockbal
 */
public enum ObjectType {
  DATA_DEFINITION("C", IAdtObjectTypeConstants.DATA_DEFINITION_GWT, true),
  CDS_VIEW_FIELD("", IAdtObjectTypeConstants.CDS_VIEW_FIELD_TYPE),
  VIEW("V", IAdtObjectTypeConstants.VIEW_DEFINITION_TYPE, true),
  TABLE("T", IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE, true),
  TABLE_FIELD("", IAdtObjectTypeConstants.TABLE_FIELD_TYPE),
  TABLE_SETTINGS("", IAdtObjectTypeConstants.TABLE_SETTINGS_TYPE),
  CLASS("", IAdtObjectTypeConstants.CLASS_GWT),
  INTERFACE("", IAdtObjectTypeConstants.INTERFACE_GWT),
  PROGRAM("", IAdtObjectTypeConstants.PROGRAM_GWT),
  BEHAVIOR_DEFINITION("", IAdtObjectTypeConstants.BEHAVIOR_DEFINITION_GWT),
  SIMPLE_TRANSFORMATION("", IAdtObjectTypeConstants.SIMPLE_TRANSFORMATION_GWT),
  TYPE_GROUP("", IAdtObjectTypeConstants.TYPE_GROUP_GWT),
  FUNCTION_GROUP("", IAdtObjectTypeConstants.FUNCTION_GROUP_GWT),
  BUSINESS_OBJECT("", IAdtObjectTypeConstants.BUSINESS_OBJECT_TYPE),
  METADATA_EXT("", IAdtObjectTypeConstants.METADATA_EXTENSION_GT),
  ACCESS_CONTROL("", IAdtObjectTypeConstants.ACCESS_CONTROL_GT),
  PACKAGE("", IAdtObjectTypeConstants.PACKAGE),
  UNRECOGNIZED("", "");

  private final String id;
  private final String adtExecutionType;
  private final boolean supportsDataPreview;

  ObjectType(final String id, final String adtExecutionType) {
    this(id, adtExecutionType, false);
  }

  ObjectType(final String id, final String adtExecutionType, final boolean supportsDataPreview) {
    this.id = id;
    this.adtExecutionType = adtExecutionType;
    this.supportsDataPreview = supportsDataPreview;
  }

  /**
   * Returns <code>true</code> if the object type supports Data Preview
   *
   * @return
   */
  public boolean supportsDataPreview() {
    return supportsDataPreview;
  }

  /**
   * Retrieve the internal id of the Object type
   *
   * @return
   */
  public String getId() {
    return id;
  }

  /**
   * Retrieve the ADT execution type of this object type
   *
   * @return
   */
  public String getAdtExecutionType() {
    return adtExecutionType;
  }

  /**
   * Retrieve Object type for the given id
   *
   * @param id
   * @return
   */
  public static ObjectType getFromId(final String id) {
    for (final ObjectType ot : ObjectType.values()) {
      if (ot.id.equals(id)) {
        return ot;
      }
    }
    return null;
  }

  /**
   * Get object type instance from the given ADT type
   *
   * @param execType
   * @return
   */
  public static ObjectType getFromAdtType(final String execType) {
    for (final ObjectType ot : ObjectType.values()) {
      if (ot.adtExecutionType.equalsIgnoreCase(execType)) {
        return ot;
      }
    }
    return ObjectType.UNRECOGNIZED;
  }

}
