package com.devepos.adt.saat.ui.internal.search.view;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.nameditem.INamedItem;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.model.objectsearch.ImageRegistryId;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;

/**
 * Provides images for content assist proposals
 */
class ProposalImageProvider implements IImageProvider {
  private static final String DATA_MARKER = "@@##@@";
  private static final String IMAGE_ID_MARKER = "imageId=";
  private final Image image;
  private final ImageRegistryId registryId;

  public ProposalImageProvider(final Image image) {
    this(null, image);
  }

  public ProposalImageProvider(final ImageRegistryId proposalImageRegistryId) {
    this(proposalImageRegistryId, null);
  }

  public ProposalImageProvider(final ImageRegistryId registryId, final Image image) {
    this.image = image;
    this.registryId = registryId;
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public Image getImage(final Object data) {
    if (image != null) {
      return image;
    }
    if (!(data instanceof INamedItem)) {
      return null;
    }
    var namedItem = (INamedItem) data;
    if (namedItem.getData() == null) {
      return null;
    }
    var dataEntries = namedItem.getData().split(DATA_MARKER);
    if (dataEntries.length > 0) {
      for (var entry : dataEntries) {
        if (entry.startsWith(IMAGE_ID_MARKER)) {
          return getImageFromRegistry(entry.split(IMAGE_ID_MARKER)[1]);
        }
      }
    }
    return null;
  }

  private Image getImageFromRegistry(final String imageId) {
    if (StringUtil.isEmpty(imageId)) {
      return null;
    }
    if (registryId == ImageRegistryId.ADT_OBJECT_TYPE) {
      return AdtTypeUtil.getInstance().getTypeImage(imageId);
    }
    if (registryId == ImageRegistryId.CALLING_PLUGIN) {
      return SearchAndAnalysisPlugin.getDefault().getImage(imageId);
    }
    return null;
  }

}