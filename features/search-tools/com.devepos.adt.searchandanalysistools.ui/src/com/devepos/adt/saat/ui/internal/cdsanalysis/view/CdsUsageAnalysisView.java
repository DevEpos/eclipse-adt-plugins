package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPageSite;

import com.devepos.adt.base.ui.ContextHelper;
import com.devepos.adt.base.ui.IGeneralCommandConstants;
import com.devepos.adt.base.ui.IGeneralContextConstants;
import com.devepos.adt.base.ui.IGeneralMenuConstants;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.controls.FilterableComposite;
import com.devepos.adt.base.ui.tree.FilterableTree;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.IFilterableView;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.cdsanalysis.ICdsEntityUsageInfo;
import com.devepos.adt.saat.ui.internal.ICommandConstants;
import com.devepos.adt.saat.ui.internal.IContextMenuConstants;
import com.devepos.adt.saat.ui.internal.TreeViewUiState;
import com.devepos.adt.saat.ui.internal.ViewUiState;
import com.devepos.adt.saat.ui.internal.help.HelpContextId;
import com.devepos.adt.saat.ui.internal.menu.SearchToolsMenuItemFactory;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.CommandPossibleChecker;

/**
 * Dependency usage analysis page of CDS Analysis page
 *
 * @see {@link CdsAnalyzerPage}
 * @author stockbal
 */
public class CdsUsageAnalysisView extends CdsAnalysisPage<CdsUsedEntitiesAnalysis> implements
    IFilterableView {

  private final List<Column> columns;
  private ContextHelper contextHelper;

  private SortListener sortListener;
  private FilterableTree resultTree;

  public CdsUsageAnalysisView(final CdsAnalysisView parentView) {
    super(parentView);
    columns = Arrays.asList(Column.values());
  }

  /**
   * Label provider for a single column in this TreeViewer
   *
   * @author stockbal
   */
  class ColumnLabelProvider extends CellLabelProvider implements
      DelegatingStyledCellLabelProvider.IStyledLabelProvider {

    private final Column column;

    public ColumnLabelProvider(final Column column) {
      this.column = column;
    }

    @Override
    public Image getImage(final Object element) {
      Image image = null;
      if (column == Column.OBJECT_NAME) {
        image = getTreeNodeImage(element);
      }
      return image;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      StyledString text = new StyledString();

      if (column == Column.OBJECT_NAME) {
        text = getTreeNodeLabel(element);
      } else {
        ICdsEntityUsageInfo usageInfo = null;
        if (element instanceof IAdaptable) {
          usageInfo = ((IAdaptable) element).getAdapter(ICdsEntityUsageInfo.class);
        }
        if (usageInfo != null) {
          switch (column) {
          case OCCURRENCES:
            text.append(String.valueOf(usageInfo.getOccurrence()));
            break;
          case USED_ENTITY_COUNT:
            text.append(String.valueOf(usageInfo.getUsedEntitiesCount()));
            break;
          case USED_JOIN_COUNT:
            text.append(String.valueOf(usageInfo.getUsedJoinCount()));
            break;
          case USED_UNION_COUNT:
            text.append(String.valueOf(usageInfo.getUsedUnionCount()));
            break;
          default:
            break;
          }
        }

      }
      return text;
    }

    @Override
    public void update(final ViewerCell cell) {
    }
  }

  private enum Column {
    OBJECT_NAME(400, Messages.CdsUsageAnalysisView_ObjectNameColumn_xfld),
    OCCURRENCES(80, Messages.CdsUsageAnalysisView_OccurrencesColumn_xfld),
    USED_ENTITY_COUNT(60, Messages.CdsUsageAnalysisView_EntitiesColumn_xfld,
        Messages.CdsUsageAnalysisView_EntitiesColumn_xtol),
    USED_JOIN_COUNT(60, Messages.CdsUsageAnalysisView_JoinsColumn_xfld,
        Messages.CdsUsageAnalysisView_JoinsColumn_xtol),
    USED_UNION_COUNT(60, Messages.CdsUsageAnalysisView_UnionsColumn_xfld,
        Messages.CdsUsageAnalysisView_UnionsColumn_xtol);

    private static final Map<Integer, Column> COLUMNS;

    static {
      COLUMNS = new HashMap<>();
      for (final Column col : Column.values()) {
        COLUMNS.put(col.ordinal(), col);
      }
    }

    public final int defaultWidth;

    public final String tooltip;

    public final String headerText;

    Column(final int width, final String headerText) {
      this(width, headerText, headerText);
    }

    Column(final int width, final String headerText, final String tooltip) {
      defaultWidth = width;
      this.headerText = headerText;
      this.tooltip = tooltip;
    }

    public static Column valueOf(final int ordinal) {
      return COLUMNS.get(ordinal);
    }

  }

  private class ContentProvider extends LazyLoadingTreeContentProvider {

    @Override
    public Object[] getElements(final Object inputElement) {
      final Object[] nodes = getChildren(inputElement);
      if (nodes != null) {
        return nodes;
      }
      return new Object[0];
    }

  }

  private static class TreeSorter extends ViewerComparator {

    @Override
    public int compare(final Viewer viewer, final Object e1, final Object e2) {
      final Tree tree = (Tree) viewer.getControl();
      final TreeColumn sortedColumn = tree.getSortColumn();
      final int direction = tree.getSortDirection();
      final int sortedColIdx = tree.indexOf(sortedColumn);

      final Column column = Column.valueOf(sortedColIdx);
      if (column == Column.OBJECT_NAME) {
        return compare(((ITreeNode) e1).getName(), ((ITreeNode) e2).getName(), direction);
      }
      final ICdsEntityUsageInfo info1 = ((IAdaptable) e1).getAdapter(ICdsEntityUsageInfo.class);
      final ICdsEntityUsageInfo info2 = ((IAdaptable) e2).getAdapter(ICdsEntityUsageInfo.class);
      if (info1 == null || info2 == null) {
        return 0;
      }
      switch (column) {
      case OCCURRENCES:
        return compare(info1.getOccurrence(), info2.getOccurrence(), direction);
      case USED_ENTITY_COUNT:
        return compare(info1.getUsedEntitiesCount(), info2.getUsedEntitiesCount(), direction);
      case USED_JOIN_COUNT:
        return compare(info1.getUsedJoinCount(), info2.getUsedJoinCount(), direction);
      case USED_UNION_COUNT:
        return compare(info1.getUsedUnionCount(), info2.getUsedUnionCount(), direction);
      default:
        break;
      }
      return 0;
    }

    private <T extends Comparable<T>> int compare(final T c1, final T c2, final int dir) {
      if (SWT.UP == dir) {
        if (c1 == null) {
          return 1;
        }
        if (c2 == null) {
          return -1;
        }
        return c1.compareTo(c2);
      }
      if (c2 == null) {
        return 1;
      }
      if (c1 == null) {
        return -1;
      }
      return c2.compareTo(c1);
    }

  }

  private class UiState extends TreeViewUiState {
    private String textFilterState;

    @Override
    public void applyToTreeViewer(final TreeViewer viewer) {
      super.applyToTreeViewer(viewer);
      if (!StringUtil.isEmpty(textFilterState)) {
        resultTree.setFilterText(textFilterState, false);
        resultTree.setFilterVisible(true);
      } else {
        resultTree.resetFilter(false);
        resultTree.setFilterVisible(false);
      }
    }

    @Override
    public void setFromTreeViewer(final TreeViewer viewer) {
      super.setFromTreeViewer(viewer);
      textFilterState = resultTree.getFilterString();
    }

  }

  @Override
  public void dispose() {
    super.dispose();
    if (contextHelper != null) {
      contextHelper.deactivateAllContexts();
    }
  }

  @Override
  public HelpContextId getHelpContextId() {
    return HelpContextId.CDS_ANALYZER_USED_ENTITIES_ANALYSIS;
  }

  @Override
  public void init(final IPageSite pageSite) {
    super.init(pageSite);
    contextHelper = ContextHelper.createForServiceLocator(getSite());
    contextHelper.activateContext(IGeneralContextConstants.FILTERABLE_VIEWS);
  }

  @Override
  public void setActionBars(final IActionBars actionBars) {
    super.setActionBars(actionBars);
    final var menu = actionBars.getMenuManager();
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, CommandFactory.createContribItemById(
        IGeneralCommandConstants.TOGGLE_VIEWER_TEXT_FILTER, false, null));
  }

  @Override
  public void toggleTextFilterVisibility() {
    if (resultTree != null && !resultTree.isDisposed()) {
      resultTree.toggleFilterVisiblity();
    }
  }

  @Override
  protected void clearViewerInput() {
    super.clearViewerInput();
    if (resultTree != null) {
      resultTree.resetFilter();
      resultTree.setFilterVisible(false);
    }
  }

  @Override
  protected void configureTreeViewer(final TreeViewer treeViewer) {
    sortListener = new SortListener(treeViewer, SWT.DOWN);
    final Tree tree = treeViewer.getTree();
    treeViewer.setComparator(new TreeSorter());
    treeViewer.setContentProvider(new ContentProvider());
    treeViewer.getTree().setHeaderVisible(true);
    treeViewer.setUseHashlookup(true);
    createColumns(treeViewer);

    tree.setSortColumn(tree.getColumn(Column.USED_ENTITY_COUNT.ordinal()));
    tree.setSortDirection(SWT.DOWN);
  }

  @Override
  protected TreeViewer createTreeViewer(final Composite parent) {
    resultTree = new FilterableTree(parent, null, true, FilterableComposite.TEXT_SMALL_H_MARGIN);
    var resultTreeViewer = new TreeViewer(resultTree, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    resultTree.setViewer(resultTreeViewer);

    resultTree.setElementMatcher(element -> {
      if (element instanceof IAdtObjectReferenceNode) {
        final var node = (IAdtObjectReferenceNode) element;
        return resultTree.getWordMatcher().matchesWord(node.getName()) || resultTree
            .getWordMatcher()
            .matchesWord(node.getDescription());
      }
      return false;
    });

    return resultTreeViewer;
  }

  @Override
  protected void fillContextMenu(final IMenuManager mgr,
      final CommandPossibleChecker commandPossibleChecker) {
    super.fillContextMenu(mgr, commandPossibleChecker);
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.CDS_TOP_DOWN_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.CDS_TOP_DOWN_ANALYSIS);
    }
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.WHERE_USED_IN_CDS_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.WHERE_USED_IN_CDS_ANALYSIS);
    }
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.USED_ENTITIES_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.USED_ENTITIES_ANALYSIS);
    }
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.FIELD_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.FIELD_ANALYSIS);
    }
  }

  @Override
  protected void fillToolbar(final IToolBarManager tbm) {
  }

  @Override
  protected ViewUiState getUiState() {
    final var uiState = new UiState();
    uiState.setFromTreeViewer((TreeViewer) getViewer());
    return uiState;
  }

  @Override
  protected void loadInput(final ViewUiState uiState) {
    final var viewer = (TreeViewer) getViewer();
    viewer.setInput(analysisResult.getResult());

    if (analysisResult.isResultLoaded()) {
      // update ui state
      if (uiState instanceof TreeViewUiState) {
        ((TreeViewUiState) uiState).applyToTreeViewer(viewer);
        viewer.refresh(false);
      }
    } else {
      resetFiltering();
      analysisResult.setResultLoaded(true);
    }
  }

  @Override
  protected void refreshAnalysis() {
    resetFiltering();
    ((ILazyLoadingNode) getViewer().getInput()).resetLoadedState();
    getViewer().refresh();
  }

  private void createColumn(final TreeViewer treeViewer, final Column column) {
    final TreeViewerColumn viewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
    viewerColumn.getColumn().setText(column.headerText);
    viewerColumn.getColumn().setToolTipText(column.tooltip);
    viewerColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnLabelProvider(
        column)));
    viewerColumn.getColumn().setWidth(column.defaultWidth);
    viewerColumn.getColumn().setMoveable(true);
    viewerColumn.getColumn().addListener(SWT.Selection, sortListener);
  }

  private void createColumns(final TreeViewer treeViewer) {
    for (final Column column : columns) {
      createColumn(treeViewer, column);
    }
  }

  private void resetFiltering() {
    resultTree.resetFilter();
    resultTree.setFilterVisible(false);
  }
}
