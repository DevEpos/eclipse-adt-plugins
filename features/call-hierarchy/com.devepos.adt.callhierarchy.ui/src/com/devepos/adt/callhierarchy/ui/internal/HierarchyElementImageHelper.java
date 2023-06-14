package com.devepos.adt.callhierarchy.ui.internal;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.ui.util.IAdtObjectTypeProxy;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;
import com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties;
import com.sap.adt.tools.abapsource.model.abapsource.AbapSourceObjectVisibility;
import com.sap.adt.tools.abapsource.model.abapsource.LevelEnum;
import com.sap.adt.tools.abapsource.ui.AbapSourceUi;
import com.sap.adt.tools.abapsource.ui.ISharedImages;

@SuppressWarnings("restriction")
public class HierarchyElementImageHelper {

  private HierarchyElementImageHelper() {
  }

  public static ImageDescriptor getImageDescrOfElement(IHierarchyResultEntry entry) {
    Image img = getImageOfElement(entry);
    return img != null ? ImageDescriptor.createFromImage(img) : null;
  }

  public static Image getImageOfElement(IHierarchyResultEntry entry) {
    if (entry != null) {
      IMethodProperties methProps = entry.getMethodProperties();
      if (methProps != null) {
        AbapSourceObjectVisibility visibility = null;
        switch (methProps.getVisibility()) {
        case PRIVATE:
          visibility = AbapSourceObjectVisibility.PRIVATE;
          break;
        case PROTECTED:
          visibility = AbapSourceObjectVisibility.PROTECTED;
          break;
        case PUBLIC:
          visibility = AbapSourceObjectVisibility.PUBLIC;
          break;
        case UNKNOWN:
          visibility = AbapSourceObjectVisibility.UNKNOWN;
          break;
        }
        LevelEnum level = methProps.isStatic() ? LevelEnum.STATIC : LevelEnum.INSTANCE;
        ISharedImages abapSourceImages = AbapSourceUi.getInstance().getSharedImages();
        if (methProps.isHandler()) {
          return abapSourceImages.getEventHandlerImage(visibility, level);
        } else {
          return abapSourceImages.getMethodImage(visibility, level, methProps.isAbstract(),
              methProps.isFinal(), methProps.isRedefined(), methProps.isConstructor(), methProps
                  .isTestMethod());
        }
      }
      // retrieve image from adt type
      IAdtObjectTypeProxy type = AdtTypeUtil.getInstance().getType(entry.getType());
      return type.getImage();
    }
    return null;
  }

  public static Image getImageOfHierResult(IHierarchyResult result) {
    if (result == null || result.getEntries().isEmpty()) {
      return null;
    }
    for (IHierarchyResultEntry entry : result.getEntries()) {
      if (entry.getParentUri() == null) {
        return getImageOfElement(entry);
      }
    }
    return null;
  }
}
