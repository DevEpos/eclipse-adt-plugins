package com.devepos.adt.base.util;

/**
 * Provider for modifications
 *
 * @author stockbal
 */
public interface IModificationProvider<T> {
	/**
	 * Adds the given modification listener to the object search favorites
	 *
	 * @param listener the listener to be added
	 */
	void addModificationListener(IModificationListener<T> listener);

	/**
	 * Removes the given modification listener from the object search favorites
	 *
	 * @param listener the listener to be removed
	 */
	void removeModificationListener(IModificationListener<T> listener);
}
