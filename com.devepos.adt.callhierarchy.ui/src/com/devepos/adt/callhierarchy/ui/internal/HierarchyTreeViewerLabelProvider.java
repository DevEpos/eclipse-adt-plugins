package com.devepos.adt.callhierarchy.ui.internal;

import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.tree.IStyledTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;

public class HierarchyTreeViewerLabelProvider extends LabelProvider implements
    DelegatingStyledCellLabelProvider.IStyledLabelProvider {

  private final CallHierarchyViewSettings settings;

  public HierarchyTreeViewerLabelProvider(final CallHierarchyViewSettings settings) {
    this.settings = settings;
  }

  @Override
  public Image getImage(final Object element) {
    if (!(element instanceof ITreeNode)) {
      return null;
    }
    ITreeNode node = (ITreeNode) element;

    IHierarchyResultEntry entry = node.getAdapter(IHierarchyResultEntry.class);
    if (entry != null) {
      return HierarchyElementImageHelper.getImageOfElement(entry);
    }
    return node.getImage();
  }

  @Override
  public StyledString getStyledText(final Object element) {
    StyledString text = null;
    final ITreeNode node = (ITreeNode) element;

    if (element instanceof IStyledTreeNode) {
      text = ((IStyledTreeNode) element).getStyledText();
    } else {
      text = new StyledString();
      if (element instanceof LoadingTreeItemsNode) {
        text.append(node.getDisplayName(), StylerFactory.ITALIC_STYLER);
      } else {
        text.append(node.getDisplayName());

        IHierarchyResultEntry hierarchyEntry = node.getAdapter(IHierarchyResultEntry.class);
        if (hierarchyEntry != null && hierarchyEntry.getEnclosedObjectDisplayName() != null) {
          text.append("  - " + hierarchyEntry.getEnclosedObjectDisplayName(), //$NON-NLS-1$
              StyledString.QUALIFIER_STYLER);
        }

        final String description = node.getDescription();
        if (settings.isShowObjectDescriptions() && description != null && !description.isEmpty()) {
          text.append("  " + description + "  ", //$NON-NLS-1$ //$NON-NLS-2$
              StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR,
                  null));
        }
      }

    }
    return text;
  }

}