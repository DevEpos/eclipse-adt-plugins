package com.devepos.adt.tools.base.ui.project;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.tools.base.destinations.IDestinationProvider;
import com.devepos.adt.tools.base.project.AbapProjectProviderAccessor;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.sap.adt.project.IProjectProvider;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Adapter Factory to adapt object to {@link IProjectProvider}
 *
 * @author stockbal
 */
public class ProjectProviderAdapterFactory {
	/**
	 * Adapts destination provider to project provider
	 *
	 * @param  adtObjectRef EMF ADT Object Reference
	 * @return              the adapted project provider
	 */
	public static IProjectProvider adaptToProjectProvider(final IAdtObjectReference adtObjectRef) {
		if (adtObjectRef == null || !(adtObjectRef instanceof IDestinationProvider)) {
			return null;
		}
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor
			.getProviderForDestination(((IDestinationProvider) adtObjectRef).getDestinationId());
		if (projectProvider != null && projectProvider.hasProject()) {
			return new ProjectProvider(projectProvider.getProject());
		}
		return null;
	}

	/*
	 * Simple implementation of a project provider
	 */
	private static final class ProjectProvider implements IProjectProvider {

		private final IProject project;

		public ProjectProvider(final IProject project) {
			this.project = project;
		}

		@Override
		public IProject getProject() {
			return this.project;
		}

	}
}
