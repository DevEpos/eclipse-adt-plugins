package com.devepos.adt.tools.base.destinations;

import com.devepos.adt.tools.base.project.AbapProjectProviderAccessor;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.sap.adt.destinations.model.IDestinationData;

/**
 * Util class for destinaion handling of ABAP projects
 *
 * @author stockbal
 */
public final class DestinationUtil {

	/**
	 * Retrieves the system id from the given destination id
	 *
	 * @param  destinationId a destination id to an ABAP project
	 * @return               the system id from the given destination id
	 */
	public static String getSystemId(final String destinationId) {
		if (destinationId == null) {
			return "";
		}
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null || !projectProvider.hasProject()) {
			return "";
		}
		return projectProvider.getDestinationData().getSystemConfiguration().getSystemId();
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
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null || !projectProvider.hasProject()) {
			return null;
		}
		return projectProvider.getDestinationData();
	}
}
