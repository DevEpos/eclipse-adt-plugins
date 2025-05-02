package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbenchPartSite;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ObjectType;
import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.adtelementinfo.IAdtElementInfoConstants;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo;
import com.devepos.adt.saat.ui.internal.CdsSourceType;
import com.devepos.adt.saat.ui.internal.IExtendedAdtObjectInfo;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * Tree Viewer for displaying Top-Down hierarchy of a database field or the
 * where used tree of the same
 *
 * @author stockbal
 */
public class FieldHierarchyViewer extends TreeViewer {

  private FieldHierarchyViewerInput input;

  public FieldHierarchyViewer(final Composite parent) {
    super(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);

    createColumns();
    setContentProvider(new FieldHierarchyViewerContentProvider());
    getTree().setHeaderVisible(true);
    getTree().addListener(SWT.MeasureItem, event -> {
      // dummy listener to prevent expand event where it is not wanted
    });
  }

  /**
   * Label provider for a single column in this TreeViewer
   *
   * @author stockbal
   */
  static class FieldHierarchyViewerCellLabelProvider extends StyledCellLabelProvider
      implements IStyledLabelProvider {

    private final int columnIndex;

    public FieldHierarchyViewerCellLabelProvider(final int columnIndex) {
      this.columnIndex = columnIndex;
    }

    @Override
    public Image getImage(final Object element) {
      IAdtObjectReferenceNode adtObjectRefNode = null;
      IEntityFieldInfo fieldInfo = null;
      if (element instanceof IAdtObjectReferenceNode) {
        adtObjectRefNode = (IAdtObjectReferenceNode) element;
        fieldInfo = adtObjectRefNode.getAdapter(IEntityFieldInfo.class);
      }
      switch (columnIndex) {
      case 0:
        final ITreeNode node = (ITreeNode) element;
        Image image = node.getImage();
        if (image == null && adtObjectRefNode != null) {
          image = AdtTypeUtil.getInstance()
              .getTypeImage(adtObjectRefNode.getObjectType() == ObjectType.DATA_DEFINITION
                  ? IAdtObjectTypeConstants.CDS_VIEW
                  : adtObjectRefNode.getAdtObjectType());
        }
        if (image == null) {
          return null;
        }
        // check if image should have overlay
        if (fieldInfo != null) {
          final String[] overlayImageIds = new String[4];
          var apiState = fieldInfo.getApiState();
          if (apiState != null) {
            var isReleased = apiState.contains(IExtendedAdtObjectInfo.API_STATE_RELEASED);
            var isDeprecated = apiState.contains(IExtendedAdtObjectInfo.API_STATE_DEPRECATED);
            if (isReleased && isDeprecated) {
              overlayImageIds[IDecoration.TOP_RIGHT] = IImages.RELEASED_API_OVR;
              overlayImageIds[IDecoration.TOP_LEFT] = IImages.DEPRECATED_API_OVR;
            } else if (isDeprecated) {
              overlayImageIds[IDecoration.TOP_RIGHT] = IImages.DEPRECATED_API_OVR;
            } else if (isReleased) {
              overlayImageIds[IDecoration.TOP_RIGHT] = IImages.RELEASED_API_OVR;
            }
          }
          var sourceType = fieldInfo.getSourceType() != null
              ? CdsSourceType.getFromId(fieldInfo.getSourceType())
              : null;
          if (sourceType != null) {
            overlayImageIds[IDecoration.BOTTOM_RIGHT] = sourceType.getImageId();
          }
          image = SearchAndAnalysisPlugin.getDefault().overlayImage(image, overlayImageIds);
        }
        return image;

      case 1:
        if (adtObjectRefNode != null && fieldInfo != null && fieldInfo.isCalculated()) {
          return SearchAndAnalysisPlugin.getDefault().getImage(IImages.FUNCTION);
        }
        return null;
      }
      return null;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      final StyledString styledString = new StyledString();
      final ITreeNode node = (ITreeNode) element;
      switch (columnIndex) {
      case 0:
        if (node instanceof LoadingTreeItemsNode) {
          styledString.append(node.getDisplayName(), StylerFactory.ITALIC_STYLER);
        } else {
          final String name = node.getDisplayName() != null ? node.getDisplayName()
              : node.getName();
          styledString.append(name);
        }
        break;
      case 1:
        if (!(node instanceof LoadingTreeItemsNode)) {
          var fieldInfo = node.getAdapter(IEntityFieldInfo.class);
          if (fieldInfo != null && !StringUtil.isEmpty(fieldInfo.getFieldName())) {
            if (fieldInfo.isCalculated()) {
              styledString.append(fieldInfo.getFieldName(), StylerFactory.BOLD_STYLER);
            } else {
              styledString.append(fieldInfo.getFieldName());
            }

          }
        }
        break;
      }
      return styledString;
    }
  }

  class FieldHierarchyViewerContentProvider extends LazyLoadingTreeContentProvider {
    public FieldHierarchyViewerContentProvider() {
      super(LazyLoadingRefreshMode.ROOT_AND_NON_LAZY_CHILDREN, AbstractTreeViewer.ALL_LEVELS);
    }

    @Override
    public Object[] getElements(final Object inputElement) {
      final Object[] nodes = getChildren(inputElement);
      if (nodes != null) {
        return nodes;
      }
      return new Object[0];
    }
  }

  public void dispose() {
  }

  /**
   * Attaches a Context Menu listener to the tree
   *
   * @param menuListener the menu listener
   * @param popupId      the popup id
   * @param viewSite     the view site or <code>null</code>
   */
  public void initContextMenu(final IMenuListener menuListener, final String popupId,
      final IWorkbenchPartSite viewSite) {
    final MenuManager menuMgr = new MenuManager(popupId);
    menuMgr.setRemoveAllWhenShown(true);
    menuMgr.addMenuListener(menuListener);
    final Menu menu = menuMgr.createContextMenu(getTree());
    getTree().setMenu(menu);
    menu.setData(IAdtElementInfoConstants.MENU_CONTROL_ID_FOR_CMD, getTree());
    if (viewSite != null) {
      viewSite.registerContextMenu(popupId, menuMgr, this);
    }
  }

  /**
   * Reloads the input of the viewer
   *
   * @param topDown if <code>true</code> the top-down analysis should be
   *                refreshed, otherwise the where-used analysis will be refreshed
   */
  public void reloadInput(final boolean topDown) {
    if (input == null) {
      return;
    }
    input.refresh(topDown);
  }

  public boolean setInput(final FieldHierarchyViewerInput input, final boolean topDown) {
    if (this.input == input) {
      return false;
    }
    if (this.input != null) {
      this.input.cacheCurrentNodeState();
    }
    this.input = input;
    this.input.setViewerInput(topDown);
    return true;
  }

  /**
   * Updates the input of Viewer
   *
   * @param topDown
   */
  public void updateInput(final boolean topDown) {
    input.setViewerInput(topDown);
  }

  private void createColumn(final int columnIndex, final String headerText, final int width) {
    final TreeViewerColumn viewerColumn = new TreeViewerColumn(this, SWT.NONE);
    final TreeColumn column = viewerColumn.getColumn();
    column.setText(headerText);
    viewerColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(
        new FieldHierarchyViewerCellLabelProvider(columnIndex)));
    column.setWidth(width);
    column.setMoveable(true);
  }

  /*
   * Creates the columns of the viewer
   */
  private void createColumns() {
    int i = 0;
    createColumn(i++, Messages.FieldHierarchyViewer_EntityColumn_xcol, 300);
    createColumn(i++, Messages.FieldHierarchyViewer_FieldColumn_xcol, 300);
  }

}
