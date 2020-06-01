package com.devepos.adt.tools.base.ui.action;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;

import com.devepos.adt.tools.base.internal.messages.Messages;
import com.devepos.adt.tools.base.util.AdtUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Action for opening a list of ADT Objects
 *
 * @author stockbal
 */
public class OpenAdtObjectAction extends Action {
	private final List<IAdtObjectReference> adtObjectReferences;
	private final IProject project;

	public OpenAdtObjectAction(final IProject project, final List<IAdtObjectReference> adtObjectReferences) {
		super(Messages.Actions_OpenAdtObject_xmit);
		this.adtObjectReferences = adtObjectReferences;
		this.project = project;
	}

	@Override
	public void run() {
		for (final IAdtObjectReference objectRef : this.adtObjectReferences) {
			AdtUtil.navigateWithObjectReference(objectRef, this.project);
		}
	}

}