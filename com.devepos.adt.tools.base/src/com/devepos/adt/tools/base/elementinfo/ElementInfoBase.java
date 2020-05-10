package com.devepos.adt.tools.base.elementinfo;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.swt.graphics.Image;

/**
 * Information about an element. Holds some basic information like the
 * <b>name</b> or the <b>description</b> of the element
 *
 * @author stockbal
 */
public abstract class ElementInfoBase implements IElementInfo, IAdaptable {
	protected String name;
	protected String displayName;
	protected String description;
	protected Image image;
	private Object additionalInfo;
	private final Map<String, String> properties;

	public ElementInfoBase() {
		this("", "", null, null);
	}

	public ElementInfoBase(final String name) {
		this(name, name, null, null);
	}

	public ElementInfoBase(final String name, final Image image) {
		this(name, name, image, null);
	}

	public ElementInfoBase(final String name, final String displayName, final Image image, final String description) {
		this.name = name;
		this.properties = new HashMap<>();
		this.displayName = displayName;
		this.description = description;
		this.image = image;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}

	@Override
	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Image getImage() {
		return this.image;
	}

	@Override
	public void setImage(final Image image) {
		this.image = image;
	}

	@Override
	public Object getAdditionalInfo() {
		return this.additionalInfo;
	}

	@Override
	public void setAdditionalInfo(final Object info) {
		this.additionalInfo = info;
	}

	@Override
	public boolean hasAdditionalInfo() {
		return this.additionalInfo != null;
	}

	@Override
	public <T> T getAdapter(final Class<T> adapter) {
		try {
			return adapter.cast(this.additionalInfo);
		} catch (final ClassCastException exc) {
		}
		return null;
	}

	@Override
	public Map<String, String> getProperties() {
		return this.properties;
	}

	@Override
	public String getPropertyValue(final String key) {
		return this.properties.get(key);
	}
}
