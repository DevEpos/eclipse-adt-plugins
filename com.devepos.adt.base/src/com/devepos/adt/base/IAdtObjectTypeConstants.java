package com.devepos.adt.base;

/**
 * Constants for ADT object types
 *
 * @author stockbal
 */
public interface IAdtObjectTypeConstants {
  /**
   * Global Workbench type for CDS Entity
   */
  String CDS_VIEW_GWT = "STOB/DO";
  String CDS_VIEW_FIELD_TYPE = "STOB/DOF";

  /**
   * Global Workbench Type for Data Definitions
   */
  String DATA_DEFINITION_GWT = "DDLS/DF";

  String TABLE_DEFINITION_TYPE = "TABL/DT";
  String TABLE_SIMPLE_TYPE = "TABL";
  String TABLE_FIELD_TYPE = "TABL/DTF";
  String TABLE_SETTINGS_TYPE = "TABL/DTT";

  String VIEW_DEFINITION_TYPE = "VIEW/DV";
  String VIEW_SIMPLE_TYPE = "VIEW";

  /**
   * Global Workbench Type for Classes
   */
  String CLASS_GWT = "CLAS/OC";
  /**
   * Global Workbench Type for Interfaces
   */
  String INTERFACE_GWT = "INTF/OI";
  /**
   * Global Workbench type for Programs
   */
  String PROGRAM_GWT = "PROG/P";
  /**
   * Global Workbench Type for Type Groups
   */
  String TYPE_GROUP_GWT = "TYPE/DG";
  /**
   * Global Workbench Type for Simple Transformations
   */
  String SIMPLE_TRANSFORMATION_GWT = "XSLT/VT";
  /**
   * Global Workbench Type for Behavior Definitions
   */
  String BEHAVIOR_DEFINITION_GWT = "BDEF/BDO";

  String BUSINESS_OBJECT_TYPE = "BOBF";

  /**
   * Global Workbench Type for Metadata Extensions
   */
  String METADATA_EXTENSION_GT = "DDLX/EX";

  /**
   * Global Workbench Type for Access Controls
   */
  String ACCESS_CONTROL_GT = "DCLS/DL";

  String PACKAGE = "DEVC/K";

  /**
   * Global workbench Type for Function Groups
   */
  String FUNCTION_GROUP_GWT = "FUGR/F";
}
