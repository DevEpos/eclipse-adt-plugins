package com.devepos.adt.tools.base.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtObjectTypeConstants;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
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
	 * @param  adtType ADT type (e.g. DDLS/DF)
	 * @return         the found image or null
	 */
	public Image getTypeImage(final String adtType) {
		if (StringUtil.isEmpty(adtType)) {
			return null;
		}
		Image image = null;
		String adtWbType = adtType;
		if (adtType.startsWith("CLAS")) {
			adtWbType = IAdtObjectTypeConstants.CLASS_DEFINITION_TYPE;
		}
		final IAdtObjectTypeInfoUi type = AbapCoreUi.getObjectTypeRegistry().getObjectTypeByGlobalWorkbenchType(adtWbType);
		if (type != null) {
			image = type.getImage();
		} else {
			image = AdtToolsBaseResources.getImage(IAdtToolsBaseImages.SAP_GUI_OBJECT);
		}
		return image;
	}

	/**
	 * Retrieves the description of the given {@code adtType} by accessing the
	 * workbench type registry in the given project
	 *
	 * @param  adtType ADT type (e.g. DDLS/DF)
	 * @param  project project to access workbench type registry
	 * @return         the found type description or {@code null}
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
	 * @param  adtType ADT Type (e.g. DDLS/DF)
	 * @return         the display name of the given type or {@code null}
	 */
	public String getTypeDescription(final String adtType) {
		if (StringUtil.isEmpty(adtType)) {
			return null;
		}
		final IAdtObjectTypeInfoUi type = AbapCoreUi.getObjectTypeRegistry().getObjectTypeByGlobalWorkbenchType(adtType);
		if (type != null) {
			return type.getDisplayName();
		}
		return null;
	}

	private AdtTypeUtil() {
	}

}
