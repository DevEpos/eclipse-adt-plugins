package com.devepos.adt.tools.base.ui.tree;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.tools.base.AdtToolsBasePlugin;
import com.devepos.adt.tools.base.IGeneralWorkbenchImages;
import com.devepos.adt.tools.base.internal.messages.Messages;

public class LoadingTreeItemsNode extends TreeNodeBase {
	public static LoadingTreeItemsNode INSTANCE;
	private final Image image;

	static {
		INSTANCE = new LoadingTreeItemsNode();
	}

	private LoadingTreeItemsNode() {
		super(Messages.LazyLoadingTreeContentProvider_LoadingContent_xmsg, null);
		this.image = AdtToolsBasePlugin.getDefault().getImage(IGeneralWorkbenchImages.WAITING_INDICATOR);
	}

	@Override
	public Image getImage() {
		return this.image;
	}

}
