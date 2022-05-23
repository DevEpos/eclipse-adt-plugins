package com.devepos.adt.base.ui.search.ext;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Composite;

/**
 * Additional section on a search page that provides a UI for entering parameter values
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface ISearchPageParameterSection {

  public interface ILayoutChangeListener {
    /**
     * signals that the layout of the sender changed
     */
    void layoutChanged();
  }

  /**
   * Adds layout change listener
   *
   * @param l a layout change listener
   */
  void addLayoutChangeListener(ILayoutChangeListener l);

  /**
   * Creates the UI for entering search parameter values
   *
   * @param parent the parent composite for the section
   */
  void createControl(Composite parent);

  /**
   * Retrieves the parameter id
   *
   * @return the parameter id
   */
  String getParameterId();

  /**
   * Retrieves a list of the currently entered parameter values.
   *
   * @return list of the currently entered parameter values
   */
  List<String> getParameterValues();

  /**
   * Removes layout change listener
   *
   * @param l a layout change listener
   */
  void removeLayoutChangeListener(ILayoutChangeListener l);

  /**
   * Sets status to indicate if the parameter section is enabled or not
   * 
   * @param status enablement status of this section
   */
  void setEnabledStatus(IStatus status);

  /**
   * Sets the parameter id as specified in the contribution <br>
   * Will be called before any other methods
   *
   * @param parameterId the value of the <code>parameterId</code> attribute
   */
  void setParameterId(String parameterId);

  /**
   * Sets the given list of parameter values as the new input of the section
   *
   * @param paramValues list of parameter values
   */
  void setParameterValues(List<String> paramValues);

  /**
   * Will be called from the search page implementation once the project scope was updated
   *
   * @param project the new project of the search page
   */
  void setProject(IProject project);
}
