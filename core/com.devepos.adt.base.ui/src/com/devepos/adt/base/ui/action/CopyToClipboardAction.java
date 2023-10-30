package com.devepos.adt.base.ui.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.tree.ITreeNode;

public class CopyToClipboardAction extends Action {

  private final List<Text> textControls = new ArrayList<>();
  private final List<StructuredViewer> viewers = new ArrayList<>();
  private final List<IAdaptable> viewerAdapters = new ArrayList<>();

  public CopyToClipboardAction() {
    super();
    setText(Messages.General_Copy_xtol);
    setToolTipText(Messages.General_Copy_xtol);
    final ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
    setDisabledImageDescriptor(
        workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
    setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
    setHoverImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
  }

  private static String getText(final IBaseLabelProvider labelProvider, final Object object) {
    if (object instanceof ITreeNode) {
      return ((ITreeNode) object).getDisplayName();
    }
    if (labelProvider instanceof ILabelProvider) {
      return ((ILabelProvider) labelProvider).getText(object);
    }
    if (labelProvider instanceof DelegatingStyledCellLabelProvider) {
      return ((DelegatingStyledCellLabelProvider) labelProvider).getStyledStringProvider()
          .getStyledText(object)
          .toString();
    }
    return object.toString();
  }

  /**
   * Registers the given control to the clipboard action. The control that
   * currently has the focus will be the primary control and its content will be
   * copied to the clipboard
   *
   * @param text
   */
  public void registerTextControl(final Text text) {
    if (!textControls.contains(text)) {
      textControls.add(text);
    }
  }

  /**
   * Adds the given viewer to this clipboard action
   *
   * @param viewer The viewer to set.
   */
  public void registerViewer(final StructuredViewer viewer) {
    if (!viewers.contains(viewer)) {
      viewers.add(viewer);
    }
  }

  public void registerViewerAdapter(final IAdaptable viewerAdapter) {
    if (!viewerAdapters.contains(viewerAdapter)) {
      viewerAdapters.add(viewerAdapter);
    }
  }

  @Override
  public void run() {
    final var focusedObject = getFocused();
    if (focusedObject == null) {
      return;
    }
    if (focusedObject instanceof StructuredViewer) {
      copyFromStructuredViewer((StructuredViewer) focusedObject);
    } else {
      copyFromTextControl((Text) focusedObject);
    }
  }

  public void unregisterViewerAdapter(final IAdaptable viewerAdapter) {
    viewerAdapters.remove(viewerAdapter);
  }

  private void copyFromStructuredViewer(final StructuredViewer viewer) {
    final var shell = viewer.getControl().getShell();
    if (shell == null) {
      return;
    }

    final var labelProvider = viewer.getLabelProvider();
    final String lineDelim = System.getProperty("line.separator"); //$NON-NLS-1$
    final var buf = new StringBuilder();
    final var iter = getSelection(viewer);
    while (iter.hasNext()) {
      if (buf.length() > 0) {
        buf.append(lineDelim);
      }
      buf.append(getText(labelProvider, iter.next()));
    }

    if (buf.length() > 0) {
      copyToClipboard(buf.toString(), shell);
    }

  }

  private void copyFromTextControl(final Text textControl) {
    final var shell = textControl.getShell();
    if (shell == null) {
      return;
    }

    copyToClipboard(textControl.getSelectionText(), shell);
  }

  private void copyToClipboard(final Clipboard clipboard, final String str, final Shell shell) {
    try {
      clipboard.setContents(new String[] { str }, new Transfer[] { TextTransfer.getInstance() });
    } catch (final SWTError ex) {
      if (ex.code != DND.ERROR_CANNOT_SET_CLIPBOARD) {
        throw ex;
      }
      if (MessageDialog.openQuestion(shell, Messages.CopyToClipboardAction_ErrorMessageTitle_xmsg,
          Messages.CopyToClipboardAction_ErrorMessageBody_xmsg)) {
        copyToClipboard(clipboard, str, shell);
      }
    }
  }

  private void copyToClipboard(String text, final Shell shell) {
    text = TextProcessor.deprocess(text);
    final var clipboard = new Clipboard(shell.getDisplay());
    try {
      copyToClipboard(clipboard, text, shell);
    } finally {
      clipboard.dispose();
    }
  }

  private Object getFocused() {
    for (final var textControl : textControls) {
      if (textControl.isFocusControl()) {
        return textControl;
      }
    }
    for (final var viewer : viewers) {
      if (viewer.getControl().isFocusControl()) {
        return viewer;
      }
    }
    for (final var viewerAdapter : viewerAdapters) {
      var viewer = viewerAdapter.getAdapter(StructuredViewer.class);
      if (viewer != null && viewer.getControl().isFocusControl()) {
        return viewer;
      }
    }
    return null;
  }

  private Iterator<?> getSelection(final StructuredViewer viewer) {
    final var s = viewer.getSelection();
    if (s instanceof IStructuredSelection) {
      return ((IStructuredSelection) s).iterator();
    }
    return Collections.emptyList().iterator();
  }
}