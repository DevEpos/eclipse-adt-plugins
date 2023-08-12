package com.devepos.adt.base.elementinfo;

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

  public ElementInfoBase(final String name, final String displayName, final Image image,
      final String description) {
    this.name = name;
    properties = new HashMap<>();
    this.displayName = displayName;
    this.description = description;
    this.image = image;
  }

  @Override
  public <T> T getAdapter(final Class<T> adapter) {
    try {
      return adapter.cast(additionalInfo);
    } catch (final ClassCastException exc) {
    }
    return null;
  }

  @Override
  public Object getAdditionalInfo() {
    return additionalInfo;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Map<String, String> getProperties() {
    return properties;
  }

  @Override
  public String getPropertyValue(final String key) {
    return properties.get(key);
  }

  @Override
  public boolean hasAdditionalInfo() {
    return additionalInfo != null;
  }

  @Override
  public void setAdditionalInfo(final Object info) {
    additionalInfo = info;
  }

  @Override
  public void setDescription(final String description) {
    this.description = description;
  }

  @Override
  public void setDisplayName(final String displayName) {
    this.displayName = displayName;
  }

  @Override
  public void setImage(final Image image) {
    this.image = image;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }
}
