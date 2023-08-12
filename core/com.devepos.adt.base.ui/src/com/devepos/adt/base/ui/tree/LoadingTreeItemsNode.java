package com.devepos.adt.base.ui.tree;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;

public class LoadingTreeItemsNode extends TreeNodeBase {
  public static LoadingTreeItemsNode INSTANCE;
  static {
    INSTANCE = new LoadingTreeItemsNode();
  }

  private final Image image;

  private LoadingTreeItemsNode() {
    super(Messages.LazyLoadingTreeContentProvider_LoadingContent_xmsg, null);
    image = AdtBaseUIPlugin.getDefault().getImage(IAdtBaseImages.WAITING_INDICATOR);
  }

  @Override
  public Image getImage() {
    return image;
  }

}
