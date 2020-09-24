package com.devepos.adt.tools.base.ui.tree;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.tools.base.ui.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.ui.internal.AdtToolsBaseUIPlugin;
import com.devepos.adt.tools.base.ui.internal.messages.Messages;

public class LoadingTreeItemsNode extends TreeNodeBase {
	public static LoadingTreeItemsNode INSTANCE;
	private final Image image;

	static {
		INSTANCE = new LoadingTreeItemsNode();
	}

	private LoadingTreeItemsNode() {
		super(Messages.LazyLoadingTreeContentProvider_LoadingContent_xmsg, null);
		this.image = AdtToolsBaseUIPlugin.getDefault().getImage(IAdtToolsBaseImages.WAITING_INDICATOR);
	}

	@Override
	public Image getImage() {
		return this.image;
	}

}
