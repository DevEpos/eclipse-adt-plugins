package com.devepos.adt.tools.base.adtobject;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.util.StringUtil;
import com.sap.adt.tools.core.ui.AbapCoreUi;
import com.sap.adt.tools.core.ui.IAdtObjectTypeInfoUi;
import com.sap.adt.tools.core.ui.IAdtObjectTypeLabelProvider;
import com.sap.adt.tools.core.ui.IAdtObjectTypeRegistryUi;

/**
 * Utility for accessing {@link IAdtObjectTypeRegistryUi}
 *
 * @author stockbal
 */
@SuppressWarnings("restriction")
public class AdtTypeUtil {

	private static AdtTypeUtil INSTANCE;
	private final IAdtObjectTypeRegistryUi typeRegistryUi;

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
		final IAdtObjectTypeInfoUi type = this.typeRegistryUi.getObjectTypeByGlobalWorkbenchType(adtType);
		if (type != null) {
			image = type.getImage();
		} else {
			image = AdtToolsBaseResources.getImage(IAdtToolsBaseImages.SAP_GUI_OBJECT);
		}
		return image;
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
		final IAdtObjectTypeInfoUi type = this.typeRegistryUi.getObjectTypeByGlobalWorkbenchType(adtType);
		if (type != null) {
			final IAdtObjectTypeLabelProvider labelProvider = type.getLabelProvider();
			if (labelProvider != null) {
				return labelProvider.getRegisteredDisplayName();
			} else {
				return type.getDisplayName();
			}
		}
		return null;
	}

	private AdtTypeUtil() {
		this.typeRegistryUi = AbapCoreUi.getObjectTypeRegistry();
	}

}
