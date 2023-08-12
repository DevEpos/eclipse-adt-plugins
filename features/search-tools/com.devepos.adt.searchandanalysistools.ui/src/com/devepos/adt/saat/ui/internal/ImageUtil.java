package com.devepos.adt.saat.ui.internal;

import java.util.Map;
import java.util.Optional;

import org.eclipse.swt.graphics.Image;

import com.sap.adt.tools.abapsource.model.abapsource.AbapSourceObjectVisibility;
import com.sap.adt.tools.abapsource.model.abapsource.LevelEnum;
import com.sap.adt.tools.abapsource.ui.AbapSourceUi;
import com.sap.adt.tools.abapsource.ui.ISharedImages;

@SuppressWarnings("restriction")
public class ImageUtil {

  public static final Image getMethodImage(Map<String, String> properties, boolean isInterface) {
    boolean isFinal = properties.get("isFinal") != null;
    boolean isAbstract = properties.get("isAbstract") != null;
    AbapSourceObjectVisibility visibility = AbapSourceObjectVisibility.UNKNOWN;
    boolean isEventHandler = properties.get("isEventHandler") != null;
    boolean isConstructor = properties.get("isConstructor") != null;
    boolean isRedefined = properties.get("isRedefined") != null;

    LevelEnum level = properties.get("isStatic") != null ? LevelEnum.STATIC : LevelEnum.INSTANCE;

    switch (Optional.of(properties.get("visibility")).orElse("UNKNOWN")) {
    case "PRIVATE":
      visibility = AbapSourceObjectVisibility.PRIVATE;
      break;
    case "PROTECTED":
      visibility = AbapSourceObjectVisibility.PROTECTED;
      break;
    case "PUBLIC":
      visibility = AbapSourceObjectVisibility.PUBLIC;
      break;
    case "UNKNOWN":
      visibility = AbapSourceObjectVisibility.UNKNOWN;
      break;
    }
    ISharedImages abapSourceImages = AbapSourceUi.getInstance().getSharedImages();
    if (isEventHandler) {
      return abapSourceImages.getEventHandlerImage(visibility, level);
    } else {
      return abapSourceImages.getMethodImage(visibility, level, isAbstract, isFinal, isRedefined,
          isConstructor, false);
    }
  }
}
