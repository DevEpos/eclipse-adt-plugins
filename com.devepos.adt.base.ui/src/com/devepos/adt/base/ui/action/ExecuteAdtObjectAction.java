package com.devepos.adt.base.ui.action;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.adtobject.AdtObjectExecutor;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Action for opening the ADT data preview for a list of ADT object references
 *
 * @author stockbal
 */
public class ExecuteAdtObjectAction extends Action {
	/**
	 *
	 */
	private final List<IAdtObjectReference> adtObjectReferences;
	private final IProject project;

	public ExecuteAdtObjectAction(final IProject project, final List<IAdtObjectReference> adtObjectReferences,
		final boolean isDataPreviewMode) {
		super();
		if (isDataPreviewMode) {
			setText(Messages.Actions_OpenWithADTDataPreview_xmit);
			setImageDescriptor(AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.DATA_PREVIEW));
		} else {
			setText(Messages.Actions_ExecuteAdtObject_xmit);
			setImageDescriptor(AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.RUN_OBJECT));
		}
		this.adtObjectReferences = adtObjectReferences;
		this.project = project;
	}

	@Override
	public void run() {
		for (final IAdtObjectReference objRef : this.adtObjectReferences) {
			AdtObjectExecutor.executeObject(this.project, objRef);
		}
	}

}