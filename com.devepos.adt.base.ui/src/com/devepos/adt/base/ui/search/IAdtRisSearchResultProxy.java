package com.devepos.adt.base.ui.search;

import org.eclipse.core.resources.IProject;

import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Proxy to result of ADT RIS Search Dialog result
 *
 * @author stockbal
 */
public interface IAdtRisSearchResultProxy {

  /**
   * Returns the selected project in the RIS Search Dialog
   *
   * @return the selected project in the RIS Search Dialog
   */
  IProject getSelectedProject();

  /**
   * Returns the first selected result from the RIS Search Dialog
   *
   * @return the first selected result from the RIS Search Dialog
   */
  IAdtObjectReference getFirstResult();

  /**
   * Returns all selected results from the RIS Search Dialog
   *
   * @return all selected results from the RIS Search Dialog
   */
  IAdtObjectReference[] getAllSelectedResults();

}
