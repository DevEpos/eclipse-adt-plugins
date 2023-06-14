package com.devepos.adt.base.project;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.util.IPropertyChangeSupport;
import com.sap.adt.communication.session.ISystemSession;
import com.sap.adt.destinations.model.IDestinationData;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;
import com.sap.adt.tools.core.project.IAbapProject;

/**
 * Provides information about current ABAP project
 *
 * @author stockbal
 */
public interface IAbapProjectProvider extends IPropertyChangeSupport {

  /**
   * Identifies project property
   */
  String PROPERTY_PROJECT = "project";

  /**
   * Creates a real copy of this project provider
   *
   * @return a copy of this project provider
   */
  IAbapProjectProvider copy();

  /**
   * Creates a stateless system session with current project in the provider
   *
   * @return
   */
  ISystemSession createStatelessSession();

  /**
   * Ensures that the current user is logged on to the project
   *
   * @return <code>true</code> if user is logged on to the project
   */
  boolean ensureLoggedOn();

  /**
   * Retrieve instance of the current ABAP Project
   *
   * @return
   */
  IAbapProject getAbapProject();

  /**
   * Returns the destination data of the ABAP Project
   *
   * @return the destination data of the ABAP Project
   */
  IDestinationData getDestinationData();

  /**
   * Retrieves the destination id of the project
   *
   * @return
   */
  String getDestinationId();

  /**
   * Retrieves the original Project reference
   *
   * @return
   */
  IProject getProject();

  /**
   * Retrieves the name of the project
   *
   * @return
   */
  String getProjectName();

  /**
   * Returns <code>true</code> if the provider references a valid ABAP project
   *
   * @return <code>true</code> if a project reference exists
   */
  boolean hasProject();

  /**
   * Opens the given object reference in the ABAP project
   *
   * @param objectReference
   */
  void openObjectReference(final IAdtObjectReference objectReference);

  /**
   * Opens the given object reference in a SAP GUI editor
   *
   * @param objectReference the ADT object reference to be opened
   */
  void openObjectReferenceInSapGui(IAdtObjectReference objectReference);

  /**
   * Sets the project in the project provider
   *
   * @param project the project to be used
   */
  void setProject(IProject project);
}
