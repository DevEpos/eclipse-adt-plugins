package com.devepos.adt.tools.base.ui.adtobject;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.tools.base.ObjectType;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Simple representation of an ADT Object
 *
 * @author stockbal
 */
public interface IAdtObject {

	/**
	 * Returns the name of the object
	 *
	 * @return the name of the object
	 */
	String getName();

	/**
	 * Returns the object type of the ADT object
	 *
	 * @return the type of the object
	 */
	ObjectType getObjectType();

	/**
	 * Returns the image for the type of the encapsulated ADT object reference, if
	 * it can be determined, otherwise {@code null}
	 * 
	 * @return the image for the type of the encapsulated ADT object reference, if
	 *         it can be determined, otherwise {@code null}
	 */
	Image getImage();

	/**
	 * Returns the project connected to this object
	 *
	 * @return the ABAP project of the object
	 */
	IProject getProject();

	/**
	 * Returns the reference to the ADT object
	 *
	 * @return
	 */
	IAdtObjectReference getReference();

	/**
	 * Returns {@code true} if the ADT object supports the Data Preview feature
	 *
	 * @return {@code true} if the ADT object supports the Data Preview feature
	 */
	boolean supportsDataPreview();
}
