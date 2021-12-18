package com.devepos.adt.base.ui.tree;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Element which will be shown in tree viewer if an error occurred during the
 * loading of some child elements
 *
 * @author stockbal
 */
public class LoadingErrorNode extends TreeNodeBase {
  private final Throwable exception;

  /**
   * @param exception
   * @param message
   */
  public LoadingErrorNode(final ITreeNode parent, final String message, final Throwable exception) {
    super(null, message != null ? message : "Error during content loading occurred", null, parent);
    this.exception = exception;
  }

  public Throwable getException() {
    return exception;
  }

  @Override
  public Image getImage() {
    return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
  }

}