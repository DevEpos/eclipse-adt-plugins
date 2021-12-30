package com.devepos.adt.base.ui.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.AbapCore;
import com.sap.adt.tools.core.ui.AbapCoreUi;
import com.sap.adt.tools.core.ui.IAdtObjectTypeInfoUi;
import com.sap.adt.tools.core.ui.IAdtObjectTypeRegistryUi;
import com.sap.adt.tools.core.wbtyperegistry.IWbObjectType;

/**
 * Utility for accessing {@link IAdtObjectTypeRegistryUi}
 *
 * @author stockbal
 */
@SuppressWarnings("restriction")
public class AdtTypeUtil {

  private static AdtTypeUtil INSTANCE;

  public static AdtTypeUtil getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AdtTypeUtil();
    }
    return INSTANCE;
  }

  /**
   * Returns Image for the given ADT Type
   *
   * @param adtType ADT type (e.g. DDLS/DF)
   * @return the found image or null
   */
  public Image getTypeImage(final String adtType) {
    if (StringUtil.isEmpty(adtType)) {
      return null;
    }
    Image image = null;
    String adtWbType = adtType;
    if (adtType.startsWith("CLAS")) {
      adtWbType = IAdtObjectTypeConstants.CLASS;
    }
    final IAdtObjectTypeInfoUi type = AbapCoreUi.getObjectTypeRegistry()
        .getObjectTypeByGlobalWorkbenchType(adtWbType);
    if (type != null) {
      image = type.getImage();
    } else {
      image = AdtBaseUIResources.getImage(IAdtBaseImages.SAP_GUI_OBJECT);
    }
    return image;
  }

  /**
   * Retrieves the description of the given {@code adtType} by accessing the
   * workbench type registry in the given project
   *
   * @param adtType ADT type (e.g. DDLS/DF)
   * @param project project to access workbench type registry
   * @return the found type description or {@code null}
   */
  public String getTypeDescriptionByProject(final String adtType, final IProject project) {
    final IWbObjectType type = AbapCore.getInstance()
        .getWbTypeRegistry(project)
        .getWbObjectType(new NullProgressMonitor(), adtType);
    if (type != null) {
      return type.getTypeLabel();
    }
    return null;
  }

  /**
   * Retrieves the display name for the given ADT type
   *
   * @param adtType ADT Type (e.g. DDLS/DF)
   * @return the display name of the given type or {@code null}
   */
  public String getTypeDescription(final String adtType) {
    if (StringUtil.isEmpty(adtType)) {
      return null;
    }
    final IAdtObjectTypeInfoUi type = AbapCoreUi.getObjectTypeRegistry()
        .getObjectTypeByGlobalWorkbenchType(adtType);
    if (type != null) {
      return type.getDisplayName();
    }
    return null;
  }

  private AdtTypeUtil() {
  }

  /**
   * Retrieves an ADT object type proxy for the given adt type name or
   * <code>null</code>
   *
   * @param adtType the full name of a workbench type (e.g. CLASS/OC)
   * @return an ADT object type proxy for the given adt type name or
   *         <code>null</code>
   */
  public IAdtObjectTypeProxy getType(final String adtType) {
    if (StringUtil.isEmpty(adtType)) {
      return null;
    }
    final IAdtObjectTypeInfoUi type = AbapCoreUi.getObjectTypeRegistry()
        .getObjectTypeByGlobalWorkbenchType(adtType);
    if (type != null) {
      return new IAdtObjectTypeProxy() {
        @Override
        public Image getImage() {
          return type.getImage();
        }

        @Override
        public String getDescription() {
          return type.getDisplayName();
        }
      };
    }
    return null;
  }

}
