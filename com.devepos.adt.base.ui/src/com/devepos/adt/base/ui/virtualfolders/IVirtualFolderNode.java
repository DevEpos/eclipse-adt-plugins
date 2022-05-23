package com.devepos.adt.base.ui.virtualfolders;

import java.util.List;

import org.eclipse.core.resources.IProject;

/**
 * Represents a virtual folder in an ABAP project
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IVirtualFolderNode {

  /**
   * Retrieves the filter values of the <code>appl</code> filter facet of this virtual folder
   * 
   * @return filter values
   */
  List<String> getApplicationComponentFilters();

  /**
   * Retrieves the filter values of the <code>created</code> filter facet of this virtual folder
   * 
   * @return filter values
   */
  List<String> getCreatedFilters();

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

}
