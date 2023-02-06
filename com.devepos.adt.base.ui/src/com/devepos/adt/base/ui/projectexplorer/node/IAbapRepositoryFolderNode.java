package com.devepos.adt.base.ui.projectexplorer.node;

import java.util.List;

import org.eclipse.core.resources.IProject;

/**
 *
 * Represents an ABAP repository tree node
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IAbapRepositoryFolderNode {

  String CATEGORY_SOURCE_LIB = "source_library";
  String CATEGORY_DICTIONARY = "dictionary";
  String CATEGORY_CORE_DATA_SERVICES = "core_data_services";

  /**
   * Returns type category of the repository node
   *
   * @return type category
   */
  String getCategory();

  /**
   * Returns all referenced packages of the node
   *
   * @return list of package names
   */
  List<String> getPackages();

  /**
   * Returns the project associated with this node
   *
   * @return the project
   */
  IProject getProject();

  /**
   * Returns the type of the repository node, e.g. DDLS/DF
   *
   * @return the type of the node
   */
  String getType();

  /**
   * Returns the user associated with a chosen $TMP package folder
   *
   * @return the user of a $TMP package
   */
  String getUser();
}
