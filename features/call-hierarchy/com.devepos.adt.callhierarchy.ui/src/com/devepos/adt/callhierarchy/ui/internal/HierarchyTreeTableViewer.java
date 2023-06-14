package com.devepos.adt.callhierarchy.ui.internal;

import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;

public class HierarchyTreeTableViewer extends TreeViewer {

  private CallHierarchyViewSettings settings;

  public HierarchyTreeTableViewer(Composite parent, CallHierarchyViewSettings settings) {
    super(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
    this.settings = settings;
    getTree().setHeaderVisible(true);
    createColumns();
  }

  private enum Column {
    OBJECT_NAME(350, "Object Name"),
    ENCLOSING_OBJECT_NAME(200, "Enclosing Object");

    public final int defaultWidth;
    public final String headerText;

    Column(final int width, final String headerText) {
      defaultWidth = width;
      this.headerText = headerText;
    }

  }

  private void createColumn(final TreeViewer treeViewer, final Column column) {
    final TreeViewerColumn viewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
    viewerColumn.getColumn().setText(column.headerText);
    viewerColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnLabelProvider(
        column)));
    switch (column) {
    case OBJECT_NAME:
      viewerColumn.getColumn().setWidth(350);
      break;
    case ENCLOSING_OBJECT_NAME:
      viewerColumn.getColumn().setWidth(200);
      break;
    }
    // viewerColumn.getColumn().setWidth(column.defaultWidth);
    viewerColumn.getColumn().setMoveable(true);
  }

  private void createColumns() {
    for (final Column column : Column.values()) {
      createColumn(this, column);
    }
  }

  class ColumnLabelProvider extends CellLabelProvider implements
      DelegatingStyledCellLabelProvider.IStyledLabelProvider {

    private Column column;

    public ColumnLabelProvider(Column column) {
      this.column = column;
    }

    @Override
    public Image getImage(final Object element) {
      if (column == Column.OBJECT_NAME) {
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
      return null;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      StyledString text = new StyledString();

      switch (column) {
      case OBJECT_NAME:
        if (element instanceof LoadingTreeItemsNode) {
          text.append(((ITreeNode) element).getDisplayName(), StylerFactory.ITALIC_STYLER);
        } else {
          ITreeNode node = (ITreeNode) element;
          text.append(node.getDisplayName());

          // IHierarchyResultEntry hierarchyEntry = node.getAdapter(IHierarchyResultEntry.class);
          // if (hierarchyEntry != null && hierarchyEntry.getEnclosedObjectDisplayName() != null) {
          // text.append(" - " + hierarchyEntry.getEnclosedObjectDisplayName(), //$NON-NLS-1$
          // StyledString.QUALIFIER_STYLER);
          // }

          final String description = node.getDescription();
          if (settings.isShowObjectDescriptions() && description != null && !description
              .isEmpty()) {
            text.append("  " + description + "  ", //$NON-NLS-1$ //$NON-NLS-2$
                StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR,
                    null));
          }
        }
        break;
      case ENCLOSING_OBJECT_NAME:
        ITreeNode node = (ITreeNode) element;
        IHierarchyResultEntry hierarchyEntry = node.getAdapter(IHierarchyResultEntry.class);
        if (hierarchyEntry != null && hierarchyEntry.getEnclosedObjectDisplayName() != null) {
          text.append(hierarchyEntry.getEnclosedObjectDisplayName());
        }
        break;
      }

      return text;
    }

    @Override
    public void update(ViewerCell cell) {
    }
  }
}