package com.devepos.adt.atm.ui.internal.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.ui.internal.util.TreeKeybindingsUtil;
import com.devepos.adt.base.ui.controls.FilterableComposite;
import com.devepos.adt.base.ui.tree.FilterableTree;
import com.devepos.adt.base.util.StringUtil;

/**
 * Tree control for loading, displaying and selecting ABAP Tags that exist in a certain ABAP project
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class TagSelectionTree {
  private IContentProvider contentProvider;
  private IStyledLabelProvider labelProvider;
  /**
   * If set, sub trees are unchecked as well if the parent node is unchecked, even they are
   * currently not visible
   */
  private boolean uncheckHiddenSubtrees;

  private CheckboxTreeViewer viewer;
  private FilterableTree tree;

  private final List<ITag> tagList = new ArrayList<>();
  private Set<ITag> previouslyCheckedTags = new HashSet<>();
  private boolean rememberCheckedstate;
  private boolean allCheckStatesChanged;

  private final Set<ITag> checkedTags;
  private final List<String> checkedTagIds = new ArrayList<>();
  private final Set<ICheckStateListener> checkedStateListener = new HashSet<>();
  private TagSearchScope searchScope = TagSearchScope.ALL;

  public TagSelectionTree() {
    checkedTags = new HashSet<>();
  }

  /**
   * Returns {@code true} if the check state of all tags in the tree have been changed during the
   * last check state operation
   */
  public boolean isAllCheckStatesChanged() {
    return allCheckStatesChanged;
  }

  public void setRememberCheckedState(boolean value) {
    rememberCheckedstate = value;
  }

  public void addCheckStateListener(final ICheckStateListener l) {
    checkedStateListener.add(l);
  }

  public void setUncheckHiddenSubtrees(boolean state) {
    uncheckHiddenSubtrees = state;
  }

  /**
   * @see {@link FilterableComposite#addKeyListenerForFilterFocus()
   */
  public void addKeyListenerForFilterFocus() {
    tree.addKeyListenerForFilterFocus();
  }

  public void collapseAll() {
    if (isTreeOnline()) {
      viewer.collapseAll();
    }
  }

  public void createControl(final Composite parent) {
    tree = new FilterableTree(parent, null, false, FilterableComposite.TOOLBAR) {
      @Override
      protected void filterJobCompleted(final boolean hasFilter) {
        super.filterJobCompleted(hasFilter);
        setCheckedElementsInTree();
        if (!hasFilter) {
          viewer.collapseAll();
        }
      }
    };
    tree.setElementMatcher(element -> {
      if (element instanceof ITag) {
        final var tag = (ITag) element;
        return tree.getWordMatcher().matchesWord(tag.getName())
            || tree.getWordMatcher().matchesWord(tag.getDescription());
      }
      return false;
    });
    viewer = new CheckboxTreeViewer(tree, SWT.V_SCROLL | SWT.SINGLE | SWT.BORDER);
    tree.setViewer(viewer);
    applyTreeLayoutData(viewer.getTree());
    tree.setExpandOnEmptyFilter(false);

    viewer.setContentProvider(
        contentProvider != null ? contentProvider : new TagTreeContentProvider());
    viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
        labelProvider != null ? labelProvider : new TagLabelProvider(true, false)));
    viewer.setInput(tagList);
    tree.setBackgroundMode(SWT.INHERIT_DEFAULT);

    viewer.addCheckStateListener(e -> {
      allCheckStatesChanged = false;
      previouslyCheckedTags.clear();
      if (rememberCheckedstate) {
        previouslyCheckedTags.addAll(checkedTags);
      }
      if (e.getChecked()) {
        checkedTags.add((ITag) e.getElement());
      } else {
        checkedTags.remove(e.getElement());
      }
      fireCheckedStateChanged(e);
    });
    TreeKeybindingsUtil.registerDefaultKeybindings(viewer);
  }

  public void expandAll() {
    if (isTreeOnline()) {
      viewer.expandAll();
    }
  }

  public Set<ITag> getCheckedTags() {
    return checkedTags;
  }

  public Composite getFilterComposite() {
    if (!isTreeOnline()) {
      throw new IllegalStateException("Tree is not online yet!");
    }
    return tree.getFilterComposite();
  }

  public IStructuredSelection getSelection() {
    if (isTreeOnline()) {
      return viewer.getStructuredSelection();
    }
    return StructuredSelection.EMPTY;
  }

  public boolean hasCheckedTags() {
    return !checkedTags.isEmpty();
  }

  public boolean hasViewerInput() {
    return isTreeOnline() && !tagList.isEmpty() && viewer.getInput() != null;
  }

  public void hookContextMenu(final MenuManager menuMgr) {
    if (!isTreeOnline()) {
      return;
    }
    var tree = viewer.getTree();
    var menu = menuMgr.createContextMenu(tree);
    tree.setMenu(menu);
  }

  public void refresh() {
    if (tree != null && !tree.isDisposed()) {
      viewer.refresh();
    }
  }

  public void removeCheckedStateListener(final ICheckStateListener l) {
    checkedStateListener.remove(l);
  }

  public void addSelectionChangedListener(final ISelectionChangedListener l) {
    viewer.addSelectionChangedListener(l);
  }

  public void removeSelectionChangedListener(final ISelectionChangedListener l) {
    viewer.removeSelectionChangedListener(l);
  }

  public void reset() {
    tagList.clear();
    viewer.refresh();
  }

  public void resetFilter() {
    tree.resetFilter();
  }

  public void selectItem(final ITag tag) {
    viewer.setSelection(new StructuredSelection(tag), true);
  }

  public void selectFirstItem() {
    if (!isTreeOnline() || viewer.getInput() == null) {
      return;
    }
    var tree = viewer.getTree();
    if (tree.getItemCount() > 0) {
      tree.select(tree.getItem(0));
    }
  }

  public void setCheckedElementsInTree() {
    if (checkedTags.isEmpty()) {
      return;
    }
    viewer.getTree().setRedraw(false);
    var expandedElements = viewer.getExpandedElements();
    viewer.expandAll();
    setCheckedElementsRecursive(viewer.getTree().getItems());
    viewer.setExpandedElements(expandedElements);
    viewer.getTree().setRedraw(true);
  }

  public void setCheckedElementsRecursive(TreeItem[] items) {

    for (var item : items) {
      if (checkedTags.contains(item.getData())) {
        item.setChecked(true);
      } else {
        // TODO: if parent is not checked, then children can't be checked either - in certain
        // situations
      }
      setCheckedElementsRecursive(item.getItems());
    }
  }

  public void checkAll() {
    previouslyCheckedTags.clear();
    if (!StringUtil.isEmpty(tree.getFilterString()) || searchScope != TagSearchScope.ALL) {
      allCheckStatesChanged = false;
      if (rememberCheckedstate) {
        previouslyCheckedTags.addAll(checkedTags);
      }
      setVisibleItemsCheckedState(viewer.getTree().getItems(), true);
    } else {
      allCheckStatesChanged = true;
      checkedTags.clear();
      for (var rootTag : tagList) {
        viewer.setSubtreeChecked(rootTag, true);
        checkedTags.add(rootTag);
        checkedTags.addAll(rootTag.getDeepChildTags());
      }
    }
  }

  public void setCheckedTagIds(final List<String> tagIds) {
    checkedTagIds.clear();
    if (tagIds != null) {
      checkedTagIds.addAll(tagIds);
    }
  }

  /**
   * Retrieves all newly checked tags.
   * <br>
   * <strong>Note</strong>:
   * If {@link #rememberCheckedstate} is not set, then this method will return only all currently
   * checked tags
   */
  public Set<ITag> getNewCheckedTags() {
    var difference = new HashSet<ITag>(checkedTags);
    difference.removeAll(previouslyCheckedTags);
    return difference;
  }

  /**
   * Retrieves all newly unchecked tags.
   * <br>
   * <strong>Note</strong>:
   * If {@link #rememberCheckedstate} is not set, then this method will return an empty set
   */
  public Set<ITag> getNewUncheckedTags() {
    var difference = new HashSet<ITag>(previouslyCheckedTags);
    difference.removeAll(checkedTags);
    return difference;
  }

  public void uncheckAll() {
    previouslyCheckedTags.clear();
    if (!StringUtil.isEmpty(tree.getFilterString()) || searchScope != TagSearchScope.ALL) {
      allCheckStatesChanged = false;
      if (rememberCheckedstate) {
        previouslyCheckedTags.addAll(checkedTags);
      }
      setVisibleItemsCheckedState(viewer.getTree().getItems(), false);
    } else {
      allCheckStatesChanged = true;
      checkedTags.clear();
      for (var rootTag : tagList) {
        viewer.setSubtreeChecked(rootTag, false);
      }
    }
  }

  /**
   * Sets a custom content provider for the tree viewer
   *
   * @param contentProvider content provider for the tree viewer
   */
  public void setContentProvider(final IContentProvider contentProvider) {
    this.contentProvider = contentProvider;
  }

  public void setFocus() {
    if (!isTreeOnline()) {
      return;
    }
    viewer.getControl().setFocus();
  }

  /**
   * Sets a custom label provider for the tree viewer
   *
   * @param labelProvider label provider for the tree viewer
   */
  public void setLabelProvider(final IStyledLabelProvider labelProvider) {
    this.labelProvider = labelProvider;
  }

  public void setTagChecked(final ITag tag, final boolean checked, final boolean includeChildren) {
    if (tag == null) {
      return;
    }

    if (checked) {
      checkedTags.add(tag);
    } else {
      checkedTags.remove(tag);
      viewer.setChecked(tag, false);
    }
    if (includeChildren) {
      viewer.setSubtreeChecked(tag, true);
      checkedTags.addAll(tag.getDeepChildTags());
    }

    // update Tree
    refresh();
  }

  public void setParentTagsCheckedFromSel() {
    for (var selObj : viewer.getStructuredSelection()) {
      setParentTagsChecked((ITag) selObj, true);
    }
  }

  public void setParentTagsChecked(final ITag tag, final boolean checked) {
    var parentTag = tag;

    do {
      var container = parentTag.eContainer();
      if (container instanceof ITag) {
        parentTag = (ITag) container;

        if (checked) {
          checkedTags.add(parentTag);
        } else {
          checkedTags.remove(parentTag);
        }
        viewer.setChecked(parentTag, checked);
      } else {
        parentTag = null;
      }

    } while (parentTag != null);
  }

  public void setTagChildrenCheckedRecursive(final ITag tag, final boolean checked) {
    var allChildren = tag.getDeepChildTags();
    if (checked) {
      checkedTags.addAll(allChildren);
    } else {
      checkedTags.removeAll(allChildren);
    }
    viewer.setSubtreeChecked(tag, checked);
  }

  /**
   * Updates the input of tree. <br>
   * Has only effect if the tree control has already been created
   *
   * @param tags        a list of tags
   * @param asyncUpdate if {@code true} the update of the tree update will be performed
   *                    asynchronously
   */
  public void setTags(final List<ITag> tags, final boolean asyncUpdate) {
    if (isTreeOnline()) {
      tagList.clear();
      checkedTags.clear();
      if (tags != null) {
        tagList.addAll(tags);
      }
      if (asyncUpdate) {
        Display.getDefault().asyncExec(() -> {
          viewer.refresh();
          updateCheckedTagsFromTagIdList();
        });
      } else {
        viewer.refresh();
        updateCheckedTagsFromTagIdList();
      }
    }
  }

  public void setTagSearchScope(final TagSearchScope searchScope) {
    this.searchScope = searchScope;
  }

  protected void applyTreeLayoutData(final Tree tree) {
    GridDataFactory.fillDefaults().grab(true, true).hint(300, 350).applyTo(tree);
  }

  private void setVisibleItemsCheckedState(final TreeItem[] items, final boolean state) {
    for (var item : items) {
      var tag = (ITag) item.getData();
      if (state) {
        checkedTags.add(tag);
      } else {
        checkedTags.remove(tag);
      }
      item.setChecked(state);
      if (state) {
        setVisibleItemsCheckedState(item.getItems(), true);
      } else {
        if (uncheckHiddenSubtrees) {
          setTagChildrenCheckedRecursive(tag, false);
        } else {
          setVisibleItemsCheckedState(item.getItems(), false);
        }
      }
    }
  }

  private void findAndSetTagAsChecked(final ITag tag) {
    if (checkedTagIds.contains(tag.getId())) {
      checkedTags.add(tag);
    }
    for (final ITag childTag : tag.getChildTags()) {
      findAndSetTagAsChecked(childTag);
    }
  }

  private void fireCheckedStateChanged(final CheckStateChangedEvent e) {
    for (var l : checkedStateListener) {
      l.checkStateChanged(e);
    }
  }

  private boolean isTreeOnline() {
    return viewer != null && viewer.getTree() != null && !viewer.getTree().isDisposed();
  }

  private void updateCheckedTagsFromTagIdList() {
    if (checkedTagIds.isEmpty()) {
      return;
    }
    if (tagList != null && !tagList.isEmpty()) {
      tagList.stream().forEach(this::findAndSetTagAsChecked);
      if (!checkedTags.isEmpty()) {
        setCheckedElementsInTree();
        viewer.refresh();
        fireCheckedStateChanged(null);
      }
    }
    checkedTagIds.clear();
  }
}
