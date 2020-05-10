package com.devepos.adt.tools.base.elementinfo;

import org.eclipse.swt.graphics.Image;

/**
 * Information about a search result element
 *
 * @author stockbal
 */
public interface IElementInfo extends IPropertyBag {
	/**
	 * @return the name of the element
	 */
	String getName();

	/**
	 * Sets the name of the element info
	 *
	 * @param name the name to be set
	 */
	void setName(String name);

	/**
	 * @return the image of this element
	 */
	Image getImage();

	/**
	 * Sets the image to be associated with this element
	 *
	 * @param imageId
	 */
	void setImage(Image image);

	/**
	 * @return the display name of the element
	 */
	String getDisplayName();

	/**
	 * Sets the display name of the element information
	 *
	 * @param displayName the display name to be set
	 */
	void setDisplayName(String displayName);

	/**
	 * @return the description of the element
	 */
	String getDescription();

	/**
	 * Sets the description of the element info
	 *
	 * @param description the description to be set
	 */
	void setDescription(String description);

	/**
	 * Sets additional information object
	 *
	 * @param info
	 */
	void setAdditionalInfo(Object info);

	/**
	 * Returns the additional info object
	 *
	 * @return
	 */
	Object getAdditionalInfo();

	/**
	 * Returns <code>true</code> if this element information has an object with
	 * additional information
	 *
	 * @return <code>true</code> if this element information has an object with
	 *         additional information
	 */
	boolean hasAdditionalInfo();
}
