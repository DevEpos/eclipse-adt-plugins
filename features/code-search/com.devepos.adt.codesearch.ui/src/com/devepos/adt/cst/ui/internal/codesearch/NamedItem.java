package com.devepos.adt.cst.ui.internal.codesearch;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IImageProvider;

/**
 * Named Items in the context of the Code Search
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public enum NamedItem implements INamedItemType, IImageProvider {
  API_STATE("releaseState", AdtBaseUIResources.getImage(IAdtBaseImages.API_STATE), false, true),
  APPLICATION_COMPONENT("applcomp",
      AdtBaseUIResources.getImage(IAdtBaseImages.APPLICATION_COMPONENT)),
  SOFTWARE_COMPONENT("softwarecomp",
      AdtBaseUIResources.getImage(IAdtBaseImages.SOFTWARE_COMPONENT)),
  TRANSPORT_REQUEST("transportRequest", AdtBaseUIResources.getImage(IAdtBaseImages.TRANSPORT)),
  TRANSPORT_REQ_TYPE("transportRequestType",
      AdtBaseUIResources.getImage(IAdtBaseImages.WB_OBJECT_TYPE), false, true),
  SERVER_GROUP("servergroup", null, true, true);

  private final String discoveryTerm;
  private final boolean caseSensitive;
  private final boolean isBuffered;
  private final Image image;

  NamedItem(final String discoveryTerm, final Image image) {
    this(discoveryTerm, image, false, false);
  }

  NamedItem(final String discoveryTerm, final Image image, final boolean caseSensitive,
      final boolean isBuffered) {
    this.discoveryTerm = discoveryTerm;
    this.caseSensitive = caseSensitive;
    this.isBuffered = isBuffered;
    this.image = image;
  }

  @Override
  public String getDiscoveryTerm() {
    return discoveryTerm;
  }

  @Override
  public boolean isCaseSensitive() {
    return caseSensitive;
  }

  @Override
  public boolean isBuffered() {
    return isBuffered;
  }

  @Override
  public Image getImage() {
    return image;
  }

}
