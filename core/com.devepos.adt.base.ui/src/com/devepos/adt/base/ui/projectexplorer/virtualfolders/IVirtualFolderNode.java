package com.devepos.adt.base.ui.projectexplorer.virtualfolders;

import java.util.List;

import org.eclipse.core.resources.IProject;

/**
 * Represents a virtual folder in an ABAP project
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IVirtualFolderNode {
  String FOLDER_TYPE_PACKAGE = "package";
  String FOLDER_TYPE_OWNER = "owner";
  String FOLDER_TYPE_APPL_COMP = "appl";
  String FOLDER_TYPE_CREATED = "created";
  String FOLDER_TYPE_MONTH = "month";
  String FOLDER_TYPE_DATE = "date";
  String FOLDER_TYPE_TYPE = "type";
  String FOLDER_TYPE_GROUP = "group";

  String FOLDER_KEY_SOURCE_LIBRARY = "source_library";
  String FOLDER_KEY_CORE_DATA_SERVICES = "core_data_services";
  String FOLDER_KEY_TRANSFORMATIONS = "transformations";
  String FOLDER_KEY_DICTIONARY = "dictionary";

  /**
   * Retrieves the filter values of the <code>appl</code> filter facet of this virtual folder
   *
   * @return filter values
   */
  List<String> getApplicationComponentFilters();

  /**
   * Retrieves the filter values of the <code>date</code> filter facet of this virtual folder
   *
   * @return filter values
   */
  List<String> getCreatedDateFilters();

  /**
   * Retrieves the filter values of the <code>month</code> filter facet of this virtual folder
   *
   * @return filter values
   */
  List<Integer> getCreatedMonthFilters();

  /**
   * Retrieves the filter values of the <code>created</code> filter facet of this virtual folder
   *
   * @return filter values
   */
  List<Integer> getCreatedYearFilters();

  /**
   * Returns the key of the folder, e.g. "CLAS"
   *
   * @return key of the folder
   */
  String getFolderKey();

  /**
   * Returns the type of the folder, e.g. "type"
   *
   * @return type of the folder
   */
  String getFolderType();

  /**
   * Retrieves the filter values of the <code>package</code> filter facet of this virtual folder
   *
   * @return filter values
   */
  List<String> getPackageFilters();

  /**
   * Returns the associated project of this node
   *
   * @return the associated project of this node
   */
  IProject getProject();

  /**
   * Returns the search string defined for this virtual folder
   *
   * @return search string
   */
  String getSearchString();

  /**
   * Retrieves the filter values of the <code>type</code> filter facet of this virtual folder
   *
   * @return filter values
   */
  List<String> getTypeFilters();

  /**
   * Retrieves the filter values of the <code>owner</code> filter facet of this virtual folder
   *
   * @return filter values
   */
  List<String> getUserFilters();

  /**
   * Returns {@code true} if the node is the root node of a tree, e.g.:
   *
   * @return
   */
  boolean isTree();

}
