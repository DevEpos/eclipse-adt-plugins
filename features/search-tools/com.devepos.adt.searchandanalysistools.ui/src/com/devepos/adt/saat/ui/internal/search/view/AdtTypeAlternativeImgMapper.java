package com.devepos.adt.saat.ui.internal.search.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.saat.model.objectsearch.IAdtAlternativeTypeImage;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;

public class AdtTypeAlternativeImgMapper {

  private final Map<String, String> typeToImageKeyMap = new HashMap<>();

  public AdtTypeAlternativeImgMapper(final List<IAdtAlternativeTypeImage> imageMapEntries) {
    var plugin = SearchAndAnalysisPlugin.getDefault();

    for (var mappedImage : imageMapEntries) {
      var imageInfo = mappedImage.getImgInfo();
      if (imageInfo.getImageEncoded() != null && imageInfo.getImageId() != null) {
        if (plugin.getImage(imageInfo.getImageId()) == null) {
          plugin.registerEncodedImage(imageInfo.getImageId(), imageInfo.getImageEncoded());
        }
        // clear encoded image from buffer to reduce memory
        imageInfo.setImageEncoded(null);
      }
      typeToImageKeyMap.put(mappedImage.getType(), imageInfo.getImageId());
    }
  }

  public String getAlternativeImageKey(final String adtType) {
    return typeToImageKeyMap.get(adtType);
  }

  public Image mapTypeToImage(final String adtType) {
    var imageKey = getAlternativeImageKey(adtType);
    if (imageKey != null) {
      return SearchAndAnalysisPlugin.getDefault().getImage(imageKey);
    }
    return null;
  }
}
