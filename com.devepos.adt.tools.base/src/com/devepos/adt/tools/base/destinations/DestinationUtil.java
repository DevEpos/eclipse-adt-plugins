package com.devepos.adt.tools.base.destinations;

import org.eclipse.core.resources.IProject;

import com.sap.adt.destinations.model.IDestinationData;
import com.sap.adt.tools.core.project.AdtProjectServiceFactory;
import com.sap.adt.tools.core.project.IAbapProject;

/**
 * Util class for destinaion handling of ABAP projects
 *
 * @author stockbal
 */
public final class DestinationUtil {

	private static IAbapProject findProjectByDestination(final String destinationId) {
		final IProject project = AdtProjectServiceFactory.createProjectService().findProject(destinationId);
		return project != null ? project.getAdapter(IAbapProject.class) : null;
	}

	/**
	 * Retrieves the system id from the given destination id
	 *
	 * @param  destinationId a destination id to an ABAP project
	 * @return               the system id from the given destination id
	 */
	public static String getSystemId(final String destinationId) {
		if (destinationId == null) {
			return null;
		}
		final IAbapProject project = findProjectByDestination(destinationId);
		return project != null ? project.getDestinationData().getSystemConfiguration().getSystemId() : null;
	}

	/**
	 * Retrieves destination data for the given destination id
	 * 
	 * @param  destinationId destination id to an ABAP Project
	 * @return               the destination data
	 */
	public static IDestinationData getDestinationData(final String destinationId) {
		if (destinationId == null) {
			return null;
		}
		final IAbapProject project = findProjectByDestination(destinationId);
		return project != null ? project.getDestinationData() : null;
	}

	/**
	 * Returns the owner of the destination behind the given ABAP project
	 * 
	 * @param  project an ABAP project
	 * @return         the owner of the destination
	 */
	public static String getDestinationOwner(final IProject project) {
		if (project == null) {
			return null;
		}
		final IAbapProject abapProject = project.getAdapter(IAbapProject.class);
		return abapProject.getDestinationData().getUser();
	}

	/**
	 * Read destination id from the given project. If the project is not of type
	 * {@link IAbapProject} <code>null</code> will be returned
	 *
	 * @param  project project instance which must be adaptable to type
	 *                 {@link IAbapProject}
	 * @return
	 */
	public static String getDestinationId(final IProject project) {
		if (project == null) {
			return null;
		}
		final IAbapProject abapProject = project.getAdapter(IAbapProject.class);
		return abapProject != null ? abapProject.getDestinationId() : null;
	}

}
