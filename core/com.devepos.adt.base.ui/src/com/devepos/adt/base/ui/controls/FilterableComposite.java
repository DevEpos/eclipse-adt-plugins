package com.devepos.adt.base.ui.controls;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.progress.UIJob;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.event.KeyEventUtil;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.base.util.StringUtil;

/**
 * Composite with a hideable filter text at the top and a {@link ColumnViewer}
 * which fills the rest of the space.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public abstract class FilterableComposite<V extends ColumnViewer, C extends Control>
    extends Composite {

  /**
   * Text Filter Control will not use the full width of the viewer, so a toolbar can be shown next
   * to the filter control.
   */
  public static final int TOOLBAR = 1 << 1;
  /**
   * The Filter Control will be created with a horizontal margin of <code>5</code>
   */
  public static final int TEXT_SMALL_H_MARGIN = 1 << 2;
  /**
   * The Filter Control will be created with no horizontal margin
   */
  public static final int TEXT_NO_MARGIN = 1 << 4;

  protected V viewer;
  protected C viewerControl;

  protected PatternFilter patternFilter;
  protected boolean isQuickSelection;
  private String filterPlaceHolderText;
  private UIJob filterJob;
  private long filterDelay = 200L;
  private boolean isFilterVisible;
  private IElementMatcher elementMatcher;
  private IWordMatcher wordMatcher;
  private Text filterText;
  private Composite filterComposite;
  private final ModifyListener filterChangedListener;
  private int mode;

  /**
   * Creates new Filtered composite.<br>
   * It is a composite control comprised of a {@link Text} and
   * {@link ColumnViewer} control
   *
   * @param parent             the parent
   * @param placeholderText    the placeholder text for the filter input. If {@code null} a default
   *                           filter text will be used
   * @param hideFilterControls if {@code true} the filter controls are initially
   *                           hidden
   */
  public FilterableComposite(final Composite parent, final String placeholderText,
      final boolean hideFilterControls) {
    this(parent, placeholderText, hideFilterControls, TEXT_NO_MARGIN);
  }

  /**
   * Creates new Filtered composite.<br>
   * It is a composite control comprised of a {@link Text} and
   * {@link ColumnViewer} control
   *
   * @param parent             the parent
   * @param placeholderText    the placeholder text for the filter input. If {@code null} a default
   *                           filter text will be used
   * @param hideFilterControls if {@code true} the filter controls are initially
   *                           hidden
   * @param mode               if {@code true} then the filter control will not occupy the full
   *                           width of the viewer
   */
  public FilterableComposite(final Composite parent, final String placeholderText,
      final boolean hideFilterControls, final int mode) {
    super(parent, SWT.NONE);

    filterChangedListener = e -> filterStringChanged();
    filterPlaceHolderText = placeholderText != null ? placeholderText
        : AdtBaseUIResources.getString(IAdtBaseStrings.FilterPlaceHolder_xmsg);
    filterJob = createFilterJob();
    this.mode = mode;
    createControl(parent);
    patternFilter = new PatternFilter();
    patternFilter.setIncludeLeadingWildcard(true);
    setFilterVisible(!hideFilterControls);

  }

  /**
   * Matcher for objects
   */
  @FunctionalInterface
  public interface IElementMatcher {
    /**
     * Returns {@code true} if the object matches the criteria of this matcher
     *
     * @return {@code true} if the object matches the criteria of this matcher
     */
    boolean matchesElement(Object element);
  }

  /**
   * Word matcher for {@link FilterableComposite}
   */
  @FunctionalInterface
  public interface IWordMatcher {
    /**
     * Returns {@code true} if the word matches
     *
     * @param word the word to be checked
     * @return {@code true} if the word matches
     */
    boolean matchesWord(String word);
  }

  private class PatternFilter extends org.eclipse.ui.dialogs.PatternFilter
      implements IWordMatcher, IElementMatcher {

    @Override
    public boolean matchesElement(final Object element) {
      return isLeafMatch(viewer, element);
    }

    @Override
    public boolean matchesWord(final String word) {
      return wordMatcher != null ? wordMatcher.matchesWord(word) : super.wordMatches(word);
    }

    @Override
    public void setPattern(String patternString) {
      if (patternString != null) {
        patternString = patternString.trim();
        if (patternString.endsWith("<")) { //$NON-NLS-1$
          patternString = patternString.substring(0, patternString.length() - 1) + ' '; // $NON-NLS-1$
        }
      }
      super.setPattern(patternString);
    }

    @Override
    protected boolean isParentMatch(final Viewer viewer, final Object element) {
      if (viewer instanceof AbstractTreeViewer && ((AbstractTreeViewer) viewer)
          .getContentProvider() instanceof LazyLoadingTreeContentProvider) {
        // prevent lazy loading if element is lazy loading node and content is not yet loaded
        if (element instanceof ILazyLoadingNode && !((ILazyLoadingNode) element).isLoaded()) {
          return false;
          // loading nodes always match otherwise the expand will not be performed
        }
        if (element instanceof LoadingTreeItemsNode) {
          return true;
        }
      }
      return super.isParentMatch(viewer, element);
    }

    @Override
    protected boolean isLeafMatch(final Viewer viewer, final Object element) {
      if (elementMatcher != null) {
        return elementMatcher.matchesElement(element);
      }
      // custom implementation to consider DelegatingStyledCellLabelProvider as well
      String text = null;
      var labelProvider = ((ContentViewer) viewer).getLabelProvider();
      if (labelProvider instanceof DelegatingStyledCellLabelProvider) {
        var innerlabelProvider = ((DelegatingStyledCellLabelProvider) labelProvider)
            .getStyledStringProvider();
        text = innerlabelProvider.getStyledText(element).getString();
      } else {
        text = ((ILabelProvider) labelProvider).getText(element);
      }
      if (text == null) {
        return false;
      }
      return matchesWord(text);
    }

    @Override
    protected boolean wordMatches(final String text) {
      return matchesWord(text);
    }

  }

  /**
   * Adds key listener to viewer control to set the focus on the filter field
   */
  public void addKeyListenerForFilterFocus() {
    if (viewerControl == null || viewerControl.isDisposed()) {
      return;
    }
    viewerControl.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {
        if (KeyEventUtil.isDefaultFindKeyStroke(e)) {
          setFocusToFilter();
        }
      }
    });
  }

  public Composite getFilterComposite() {
    return filterComposite;
  }

  /**
   * Returns the current string of the filter control
   *
   * @return the current string of the filter control
   */
  public String getFilterString() {
    return isFilterControlLive() ? filterText.getText() : null;
  }

  /**
   * Returns the current object matcher of the viewer
   *
   * @return the current object matcher of the viewer
   */
  public IElementMatcher getObjectMatcher() {
    return patternFilter;
  }

  /**
   * Returns the current viewer of this composite
   *
   * @return the current viewer of this composite
   */
  public V getViewer() {
    return viewer;
  }

  /**
   * Returns the current word matcher to determine if a given word of an element
   * matches the current filter
   *
   * @return the current word matcher
   */
  public IWordMatcher getWordMatcher() {
    return patternFilter;
  }

  /**
   * Returns {@code true} if the filter control is visible
   */
  public boolean isFilterVisible() {
    return isFilterVisible;
  }

  /**
   * Resets the filter text.<br>
   * The viewer filtering will be done inside a UI job, that is started with a delay
   */
  public void resetFilter() {
    resetFilter(true);
  }

  /**
   * Resets the filter text
   *
   * @param withJob if {@code true} the filter will be resetted inside an UI job
   */
  public void resetFilter(final boolean withJob) {
    if (isFilterControlLive() && !StringUtil.isEmpty(filterText.getText())) {
      if (withJob) {
        filterText.setText("");
      } else {
        filterText.removeModifyListener(filterChangedListener);
        filterText.setText("");
        filterText.addModifyListener(filterChangedListener);
      }
    }
  }

  /**
   * Sets new element matcher for determining if an element in the viewer matches
   * the entered pattern
   *
   * @param elementMatcher the element matcher to be used
   */
  public void setElementMatcher(final IElementMatcher elementMatcher) {
    this.elementMatcher = elementMatcher;
  }

  /**
   * Sets the job delay for the filter job
   *
   * @param delay the delay in milliseconds
   */
  public void setFilterDelay(final long delay) {
    filterDelay = delay;
  }

  /**
   * Sets a new text in the filter text control.<br>
   * The subsequent viewer filtering will be performed in a UI Job with the currently set delay.
   *
   * @param filter the text for the filter
   *
   * @see #setFilterDelay(long)
   *
   */
  public void setFilterText(final String filter) {
    setFilterText(filter, true);
  }

  /**
   * Sets a new text in the filter text control. If {@code withJob} is supplied with {@code false}
   * the caller has to take care to call {@link StructuredViewer#refresh()} so the filter will be
   * applied to the underlying viewer.
   *
   * @param filter  the new filter text
   * @param withJob if {@code true}, filtering the viewer will be performed inside a UI Job
   */
  public void setFilterText(final String filter, final boolean withJob) {
    if (isFilterControlLive() && filter != null) {
      if (withJob) {
        filterText.setText(filter);
      } else {
        filterText.removeModifyListener(filterChangedListener);
        filterText.setText(filter);
        patternFilter.setPattern(filter);
        filterText.addModifyListener(filterChangedListener);
      }
    }
  }

  /**
   * Shows/Hides filter controls
   *
   * @param visible if {@code true} the filter controls will be shown
   */
  public void setFilterVisible(final boolean visible) {
    if (!isFilterControlLive() || isFilterVisible == visible) {
      return;
    }
    isFilterVisible = visible;
    if (filterComposite.getChildren().length > 1) {
      GridData layoutData = (GridData) filterText.getLayoutData();
      layoutData.exclude = !visible;
      filterText.setVisible(visible);
      filterText.getParent().pack();
    } else {
      GridData layoutData = (GridData) filterComposite.getLayoutData();
      layoutData.exclude = !visible;
      filterComposite.setVisible(visible);
      filterComposite.getParent().pack();
    }
    getParent().layout();

    if (isFilterVisible) {
      if (!filterText.isFocusControl()) {
        filterText.setFocus();
      }
    } else if (viewerControl != null && !viewerControl.isFocusControl()) {
      viewerControl.setFocus();
    }
  }

  /**
   * Sets focus to the filter control - if it is visible
   */
  public void setFocusToFilter() {
    if (isFilterControlLive()) {
      filterText.setFocus();
    }
  }

  /**
   * Sets the value for the property {@code isQuickSelection}.<br>
   * If active the first matching element will be selected
   *
   * @param quickSelectionMode if {@code true} the first matching element will be
   *                           automatically selected
   */
  public void setIsQuickSelectionMode(final boolean quickSelectionMode) {
    isQuickSelection = quickSelectionMode;
  }

  /**
   * Enables the prefixing of the entered filter string with an "*" character
   *
   * @param leadingWildcardFiltering if {@code true} the entered filter value will
   *                                 be prefixed with an "*" character
   */
  public void setLeadingWildcardFiltering(final boolean leadingWildcardFiltering) {
    patternFilter.setIncludeLeadingWildcard(leadingWildcardFiltering);
  }

  /**
   * Sets the viewer of this filterable composite
   *
   * @param viewer the viewer
   */
  public void setViewer(final V viewer) {
    if (viewer == null || viewer.getControl().getParent() != this) {
      throw new IllegalArgumentException(
          "'viewer' must not be null and has to be instantiated with this composite as a parent"); //$NON-NLS-1$
    }
    this.viewer = viewer;
    viewerControl = getViewerControl();
    this.viewer.addFilter(patternFilter);
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.FILL)
        .grab(true, true)
        .applyTo(viewerControl);
  }

  /**
   * Sets the
   *
   * @param wordMatcher
   */
  public void setWordMatcher(final IWordMatcher wordMatcher) {
    this.wordMatcher = wordMatcher;
  }

  public void toggleFilterVisiblity() {
    setFilterVisible(!isFilterVisible);
    if (!isFilterVisible) {
      String filterString = getFilterString();
      if (filterString != null && filterString.trim().length() > 0) {
        resetFilter();
      }
    }
  }

  /**
   * Is called before the actual filter job is triggered.<br>
   * <strong>Note:</strong> subclasses should override
   */
  protected void beforeFilterJob() {
  }

  /**
   * Called right before the update of the viewer selection takes place. <br>
   * <strong>Note:</strong> Subclasses should override
   */
  protected void beforeUpdatingSelection() {
  }

  protected void filterJobCompleted() {
  }

  /**
   * Called after the filtertext was modified
   */
  protected void filterStringChanged() {
    filterJob.cancel();
    if (viewerControl != null && !viewerControl.isDisposed()) {
      filterJob.schedule(filterDelay);
    }
  }

  /**
   * Retrieves the control of the viewer
   *
   * @return the control of the viewer
   */
  protected abstract C getViewerControl();

  /**
   * Retrieves the current item count in the viewer
   *
   * @return the current item count in the viewer
   */
  protected abstract int getViewerItemsCount();

  /**
   * Returns {@code true} if the given {@code element} matches the pattern filter
   *
   * @param element the element to be checked
   * @return {@code true} if the given {@code element} matches the pattern filter
   */
  protected boolean isElementMatching(final Object element) {
    return patternFilter != null && patternFilter.matchesElement(element);
  }

  /**
   * Selects the first item in the viewer
   */
  protected abstract void selectFirstItem();

  /**
   * Updates the viewer selection
   *
   * @param setFocus if {@code true} the tree will get the focus
   */
  protected abstract void updateSelection(boolean setFocus);

  /**
   * Create the filtered tree's controls.
   *
   * @param parent the parent
   */
  private void createControl(final Composite parent) {
    setLayout(GridLayoutFactory.swtDefaults().margins(0, 0).create());
    setFont(parent.getFont());

    if (parent.getLayout() instanceof GridLayout) {
      setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }
    createFilterText(this);
    isFilterVisible = true;
  }

  private UIJob createFilterJob() {
    UIJob filterJob = new UIJob("Filtering viewer...") { //$NON-NLS-1$

      @Override
      public IStatus runInUIThread(final IProgressMonitor monitor) {
        if (viewerControl == null || viewerControl.isDisposed()) {
          monitor.done();
          return Status.OK_STATUS;
        }
        String filterString = getFilterString();
        patternFilter.setPattern(filterString);
        viewer.refresh(false);
        if (getViewerItemsCount() > 0 && filterString != null && filterString.trim().length() > 0) {
          beforeUpdatingSelection();
          if (isQuickSelection) {
            updateSelection(false);
          } else {
            selectFirstItem();
          }
        }
        filterJobCompleted();
        monitor.done();
        return Status.OK_STATUS;
      }
    };
    filterJob.setSystem(true);
    return filterJob;
  }

  /*
   * Creates the filter text
   */
  private void createFilterText(final Composite parent) {
    filterComposite = new Composite(parent, SWT.NONE);

    int hMargin = (mode & TEXT_SMALL_H_MARGIN) == TEXT_SMALL_H_MARGIN ? 5 : 0;
    boolean toolbarMode = (mode & TOOLBAR) == TOOLBAR;

    GridLayoutFactory.swtDefaults()
        .margins(hMargin, 0)
        .numColumns(toolbarMode ? 2 : 1)
        .applyTo(filterComposite);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(filterComposite);

    filterText = new Text(filterComposite, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
    if (toolbarMode) {
      GridDataFactory.fillDefaults().hint(250, SWT.DEFAULT).grab(true, false).applyTo(filterText);
    } else {
      GridDataFactory.fillDefaults().grab(true, false).applyTo(filterText);
    }
    filterText.setMessage(filterPlaceHolderText);

    filterText.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {
        // on a CR we want to transfer focus to the list
        final boolean hasItems = getViewerItemsCount() > 0;
        if (hasItems && e.keyCode == SWT.ARROW_DOWN) {
          viewerControl.setFocus();
        } else if (e.character == SWT.CR) {
        }
      }
    });
    // enter key set focus to tree
    filterText.addTraverseListener(e -> {
      if (isQuickSelection || getViewerItemsCount() == 0) {
        return;
      }
      if (e.detail == SWT.TRAVERSE_RETURN) {
        e.doit = false;
        updateSelection(true);
      }
    });
    filterText.addModifyListener(filterChangedListener);
  }

  private boolean isFilterControlLive() {
    return filterText != null && !filterText.isDisposed();
  }

}
