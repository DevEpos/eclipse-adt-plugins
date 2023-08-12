package com.devepos.adt.base.internal.nameditem;

import com.devepos.adt.base.nameditem.INamedItem;

/**
 * Simple Implementation of the named item interface {@link INamedItem}
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class NamedItem implements INamedItem {
  private String name;
  private String description;
  private String data;

  public NamedItem() {
  }

  @Override
  public String getData() {
    return data;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setData(final String data) {
    this.data = data;
  }

  @Override
  public void setDescription(final String description) {
    this.description = description;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

}
