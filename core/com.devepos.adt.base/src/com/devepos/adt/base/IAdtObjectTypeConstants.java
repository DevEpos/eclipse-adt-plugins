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
  String CDS_VIEW = "STOB/DO";
  String CDS_VIEW_FIELD_TYPE = "STOB/DOF";

  /**
   * Global Workbench Type for Data Definitions
   */
  String DATA_DEFINITION = "DDLS/DF";

  String TABLE_DEFINITION_TYPE = "TABL/DT";
  String STRUCTURE = "TABL/DS";
  String TABLE_SIMPLE_TYPE = "TABL";
  String TABLE_FIELD_TYPE = "TABL/DTF";
  String TABLE_SETTINGS_TYPE = "TABL/DTT";

  String VIEW_DEFINITION_TYPE = "VIEW/DV";
  String VIEW_FIELD_TYPE = "VIEW/DVF";
  String VIEW_SIMPLE_TYPE = "VIEW";

  /**
   * Global Workbench Type for Classes
   */
  String CLASS = "CLAS/OC";
  /**
   * Type for Include of a Global Class
   */
  String CLASS_INCLUDE = "CLAS/I";
  /**
   * Type for a method implementation include
   */
  String METHOD_IMPLEMENTATION = "CLAS/OM";
  /**
   * Type for Local Class in Global Class
   */
  String CLASS_LOCAL_CLASS = "CLAS/OCL";
  /**
   * Type for Local Interface in Global Class
   */
  String CLASS_LOCAL_INTERFACE = "CLAS/ON";
  /**
   * Global Workbench Type for Interfaces
   */
  String INTERFACE = "INTF/OI";
  /**
   * Type for method definition in Interface
   */
  String INTERFACE_METHOD = "INTF/IO";
  /**
   * Global Workbench type for Programs
   */
  String PROGRAM = "PROG/P";
  /**
   * Global Workbench type for Include programs
   */
  String PROGRAM_INCLUDE = "PROG/I";
  /**
   * Subroutine in program
   */
  String PROGRAM_SUBROUTINE = "PROG/PU";
  /**
   * Local Class in Program (Include)
   */
  String PROGRAM_LOCAL_CLASS = "PROG/PL";
  /**
   * Local Interface in Program (Include)
   */
  String PROGRAM_LOCAL_INTERFACE = "PROG/PN";
  /**
   * Program source of a Business Object Type
   */
  String BUSINESS_OBJ_TYPE_PROGRAM = "SOBJ/P";
  /**
   * Global Workbench Type for Type Groups
   */
  String TYPE_GROUP = "TYPE/DG";
  /**
   * Global Workbench Type for Simple Transformations
   */
  String SIMPLE_TRANSFORMATION = "XSLT/VT";
  /**
   * Global Workbench Type for Behavior Definitions
   */
  String BEHAVIOR_DEFINITION = "BDEF/BDO";

  String BUSINESS_OBJECT_TYPE = "BOBF";

  /**
   * Global Workbench Type for Metadata Extensions
   */
  String METADATA_EXTENSION = "DDLX/EX";

  /**
   * Global Workbench Type for Access Controls
   */
  String ACCESS_CONTROL = "DCLS/DL";

  String PACKAGE = "DEVC/K";

  /**
   * Global workbench Type for Function Groups
   */
  String FUNCTION_GROUP = "FUGR/F";
  /**
   * Global workbench Type for Function modules
   */
  String FUNCTION_MODULE = "FUGR/FF";
  /**
   * Global workbench Type for Function Group includes
   */
  String FUNCTION_INCLUDE = "FUGR/I";
  /**
   * Local Class in Function Group Include
   */
  String FUNCTION_GROUP_LOCAL_CLASS = "FUGR/PL";
  /**
   * Local Interface in Function Group Include
   */
  String FUNCTION_GROUP_LOCAL_INTERFACE = "FUGR/PN";
  /**
   * Global Workbench Type for Service Definition
   */
  String SERVICE_DEFINITION = "SRVD/SRV";
}
