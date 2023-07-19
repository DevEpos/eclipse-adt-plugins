package com.devepos.adt.saat.navtargets;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;

import com.devepos.adt.base.ObjectType;
import com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets;

/**
 * Service which handles the retrieval of available navigation targets for ADT
 * objects
 *
 * @author stockbal
 */
public interface INavigationTargetService {

  IStatus testNavigationTargetsAvailable(IProject project);

  /**
   * Retrieves a list of navigation targets for the given object name and type or
   * <code>null</code> if none could be determined
   *
   * @param destinationId destination Id of ABAP project
   * @param objectName    the name of the object
   * @param type          the type of the object
   * @return
   */
  ICdsQueryNavTargets getTargets(String destinationId, String objectName, ObjectType type);
}
