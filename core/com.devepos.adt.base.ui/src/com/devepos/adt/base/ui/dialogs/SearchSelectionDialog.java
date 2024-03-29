package com.devepos.adt.base.ui.dialogs;

import static org.eclipse.swt.events.KeyListener.keyPressedAdapter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.DialogResultPart;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IDialogFilterPart;
import com.devepos.adt.base.ui.MessageLine;
import com.devepos.adt.base.ui.StringFilterPart;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.util.SWTUtil;
import com.devepos.adt.base.ui.viewers.LabelViewer;

/**
 * Selection Dialog
 *
 * @author stockbal
 * @param <R> concrete result type
 * @param <F> concrete type of filter
 */
public abstract class SearchSelectionDialog<R, F> extends TrayDialog {

  private static final long DEFAULT_JOB_DELAY = 800L;
  private static final String DIALOG_BOUNDS_SETTINGS = "DialogBoundsSettings"; //$NON-NLS-1$
  private static final String DIALOG_HEIGHT = "DIALOG_HEIGHT"; //$NON-NLS-1$
  private static final String DIALOG_WIDTH = "DIALOG_WIDTH"; //$NON-NLS-1$
  private static final String EMPTY_STRING = ""; //$NON-NLS-1$

  private IStructuredContentProvider contentProvider;
  private MenuManager contextMenuManager;
  private int defaultDialogHeight = 500;
  private int defaultDialogWidth = 600;
  private IBaseLabelProvider detailsLabelProvider;
  private String filterLabel;
  private IDialogFilterPart<F> filterPart;
  private F initialFilter;
  private boolean startupSearchWithNullFilterDisabled;

  private long initialSearchJobDelay = DEFAULT_JOB_DELAY;

  private List<R> inititalSelections;

  private boolean multi;

  private final List<R> result = new ArrayList<>();

  private IBaseLabelProvider resultLabelProvider;

  private DialogResultPart resultViewPart;

  private SearchJob searchJob;
  private long searchJobDelay = DEFAULT_JOB_DELAY;
  private MessageLine statusLine;
  private String title;

  /**
   * Creates new instance of a Filtered selection dialog
   *
   * @param parent the parent shell
   * @param multi  if {@code true} multiple entries can be chosen
   */
  public SearchSelectionDialog(final Shell parent, final boolean multi) {
    super(parent);
    this.multi = multi;
  }

  /**
   * Creates new instance of a Filtered selection dialog
   *
   * @param parent     the parent shell
   * @param multi      if {@code true} multiple entries can be chosen
   * @param filterPart the filter part of the dialog
   * @param resultPart the result part of the dialog
   */
  public SearchSelectionDialog(final Shell parent, final boolean multi,
      final IDialogFilterPart<F> filterPart, final DialogResultPart resultPart) {
    this(parent, multi);
    setResultViewPart(resultPart);
    setFilterViewPart(filterPart);
  }

  public final class SearchResultObject {
    private final boolean resultComplete;
    private final List<R> resultObjects;

    public SearchResultObject(final List<R> resultObjects, final boolean resultComplete) {
      this.resultObjects = resultObjects == null ? new ArrayList<>() : resultObjects;
      this.resultComplete = resultComplete;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("is complete: "); //$NON-NLS-1$
      sb.append(isResultComplete());
      sb.append(", result: "); //$NON-NLS-1$
      sb.append(resultObjects);
      return sb.toString();
    }

    protected List<R> getResultObjects() {
      return resultObjects;
    }

    protected boolean isResultComplete() {
      return resultComplete;
    }
  }

  protected final class SearchResult {
    private final R result;

    public SearchResult(final R result) {
      this.result = result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof SearchSelectionDialog.SearchResult)) {
        return false;
      }
      final SearchSelectionDialog<R, F>.SearchResult other = (SearchSelectionDialog<R, F>.SearchResult) o;
      if (result == null && other.result == null) {
        return true;
      }
      if (result == null || other.result == null) {
        return false;
      }
      return other.result.equals(result);
    }

    public R getResult() {
      return result;
    }

    @Override
    public int hashCode() {
      return result == null ? 0 : result.hashCode();
    }
  }

  private class ResultView extends DialogResultPart {

    private LabelViewer details;
    private Label listLabel;
    private final boolean multi;
    private TableViewer tableViewer;

    public ResultView(final boolean multi) {
      this.multi = multi;
      setDetailsLabelProvider(getDetailsLabelProvider());
      setResultLabelProvider(getResultLabelProvider());
    }

    @Override
    public ContentViewer getDetailViewer() {
      return details;
    }

    @Override
    public StructuredViewer getResultViewer() {
      return tableViewer;
    }

    @Override
    protected void createContent(final Composite parent) {
      createLabels(parent);
      createViewer(parent);
      createStatusLine(parent);
      details = new LabelViewer(parent, SWT.BORDER | SWT.FLAT);
      if (initialSelections != null) {
        tableViewer.setSelection(new StructuredSelection(initialSelections));
      }

      SWTUtil.setLabelForControl(listLabel, tableViewer.getControl());
    }

    @Override
    protected int getSelectedElementCount() {
      if (tableViewer == null || tableViewer.getTable().isDisposed()) {
        return 0;
      }
      return tableViewer.getStructuredSelection().size();
    }

    private void createLabels(final Composite parent) {
      final Composite labels = new Composite(parent, SWT.NONE);

      GridLayoutFactory.fillDefaults().numColumns(2).applyTo(labels);

      listLabel = new Label(labels, SWT.NONE);
      listLabel.setText(Messages.SearchSelectionDialog_ResultItemsLabel);

      GridDataFactory.fillDefaults().grab(true, false).applyTo(listLabel);
      GridDataFactory.fillDefaults().grab(true, false).applyTo(labels);
    }

    private void createViewer(final Composite parent) {
      tableViewer = new TableViewer(parent,
          (multi ? SWT.MULTI : SWT.SINGLE) | SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION);
      GridDataFactory.fillDefaults()
          .grab(true, true)
          .hint(SWT.DEFAULT, tableViewer.getTable().getItemHeight() * 15)
          .applyTo(tableViewer.getTable());

      tableViewer.addSelectionChangedListener(event -> {
        handleSelected((StructuredSelection) event.getSelection());
        fireSelectedElementsChanged();
      });
      tableViewer.setContentProvider(getResultContentProvider());
      tableViewer.addDoubleClickListener(event -> okPressed());
      configureDefaultResultViewer(tableViewer);
    }

  }

  private final class SearchJob extends Job {
    private final F filter;
    private boolean isResultComplete;
    private Exception searchJobException;
    private SearchResultObject searchResult;

    public SearchJob(final F filter) {
      super(AdtBaseUIResources.getString(IAdtBaseStrings.SearchUI_Searching_xmsg));
      setSystem(true);
      this.filter = filter;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(final Object obj) {
      if (obj == null || !(obj instanceof SearchSelectionDialog.SearchJob)) {
        return false;
      }
      return ((SearchSelectionDialog<R, F>.SearchJob) obj).filter.equals(filter);
    }

    public F getFilter() {
      return filter;
    }

    public Exception getResultException() {
      return searchJobException;
    }

    /**
     * @return the search result
     */
    public SearchResultObject getSearchResult() {
      return searchResult;
    }

    public boolean isResultValid() {
      if (searchResult == null || !isResultComplete) {
        return false;
      }
      return true;
    }

    @Override
    protected IStatus run(final IProgressMonitor monitor) {
      try {
        searchResult = performSearch(filter, monitor);
      } catch (final CoreException e) {
        searchJobException = e;
      }
      return searchJobException != null ? Status.CANCEL_STATUS : Status.OK_STATUS;
    }
  }

  @Override
  public boolean close() {
    if (contextMenuManager != null) {
      contextMenuManager.dispose();
    }
    storeDialog(getDialogSettings());
    return super.close();
  }

  public R getFirstResult() {
    return result != null && result.size() > 0 ? result.get(0) : null;
  }

  /**
   * Sets flag to control whether a search should be triggered upon opening the dialog even when no
   * filter value was provided
   * 
   * @param startupSearchWithNullFilterDisabled if {@code true}, no search will be executed upon
   *                                            opening
   *                                            the dialog if no initial filter was set
   */
  public void setStartupSearchWithNullFilterDisabled(boolean startupSearchWithNullFilterDisabled) {
    this.startupSearchWithNullFilterDisabled = startupSearchWithNullFilterDisabled;
  }

  /**
   * Returns the ok button.
   *
   * @return the ok button or <code>null</code> if the button is not created yet.
   */
  public Button getOkButton() {
    return getButton(IDialogConstants.OK_ID);
  }

  public List<R> getResult() {
    return result;
  }

  /**
   * Sets the title for this dialog.
   *
   * @param title the title
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  protected void computeResult() {
    setResult(getSelectedItems());
  }

  /**
   * Configures of default table viewer.<br>
   * Default implementation does nothing. Subclasses may override. <br>
   * <br>
   *
   * <strong>Note</strong>: if a custom result part was set this method will not be called
   *
   * @param tableViewer the table viewer of the result part
   */
  protected void configureDefaultResultViewer(final TableViewer tableViewer) {
  }

  @Override
  protected void configureShell(final Shell shell) {
    super.configureShell(shell);
    if (title != null) {
      shell.setText(title);
    }
  }

  @Override
  protected Control createContents(final Composite parent) {
    final Control contents = super.createContents(parent);
    if (!getResultViewPart().getSelection().isEmpty()) {
      updateButtonsEnableState(null);
    } else {
      updateButtonsEnableState(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, EMPTY_STRING));
    }
    if (initialFilter != null) {
      filterPart.setFilter(initialFilter);
    } else if (!startupSearchWithNullFilterDisabled) {
      applyFilter();
    }

    filterPart.setFocus(true);
    return contents;
  }

  @Override
  protected Control createDialogArea(final Composite parent) {
    Objects.requireNonNull(getFilterViewPart(), "filterPart must be bound"); //$NON-NLS-1$
    Objects.requireNonNull(getResultViewPart(), "resultPart must be bound"); //$NON-NLS-1$

    final Composite dialogArea = (Composite) super.createDialogArea(parent);

    final Composite content = new Composite(dialogArea, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(content);
    GridLayoutFactory.fillDefaults().applyTo(content);

    filterPart.createUI(content);

    resultViewPart.setInitialSelections(inititalSelections);
    resultViewPart.createDialogPart(content);
    resultViewPart.addPropertyChangeListener(l -> {
      if (l.getProperty().equals(DialogResultPart.SELECTED_ELEMENTS_PROPERTY)) {
        final int selectedElements = (int) l.getNewValue();
        updateButtonsEnableState(
            selectedElements <= 0 ? new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, "") //$NON-NLS-1$
                : null);
      }
    });

    handleFilterControls();

    createContentsBeforeStatusLine(content);

    /*
     * if status line was net not created it will be positioned under the result
     * part
     */
    if (statusLine == null) {
      createStatusLine(content);
    }
    GridDataFactory.fillDefaults().grab(true, false).applyTo(statusLine);

    applyDialogFont(content);

    restoreDialog(getDialogSettings());

    return dialogArea;
  }

  /**
   * Will be called before the creation of the status line control.<br>
   * Default Implementation does nothing, sub classes may override.
   * 
   * @param parent the parent container
   */
  protected void createContentsBeforeStatusLine(Composite parent) {
  };

  protected final void createStatusLine(final Composite parent) {
    statusLine = new MessageLine(parent);
  }

  /**
   * Hook that allows to add actions to the context menu.
   * <p>
   * Subclasses may override in order to add other actions.
   * </p>
   *
   * @param menuManager the context menu manager
   */
  protected void fillContextMenu(final IMenuManager menuManager) {
    // no base implementation
  }

  @Override
  protected IDialogSettings getDialogBoundsSettings() {
    final IDialogSettings settings = getDialogSettings();
    IDialogSettings section = settings.getSection(DIALOG_BOUNDS_SETTINGS);
    if (section == null) {
      section = settings.addNewSection(DIALOG_BOUNDS_SETTINGS);
      section.put(DIALOG_HEIGHT, defaultDialogHeight);
      section.put(DIALOG_WIDTH, defaultDialogWidth);
    }
    return section;
  }

  /**
   * Returns the dialog settings. Returned object can't be null.
   *
   * @return return dialog settings for this dialog
   */
  protected abstract IDialogSettings getDialogSettings();

  /**
   * Returns the current filter
   *
   * @return the current filter
   */
  protected F getFilter() {
    return filterPart != null ? filterPart.getFilter() : null;
  }

  /**
   * Returns the result part of the dialog
   *
   * @return the result part of the dialog
   */
  protected DialogResultPart getResultViewPart() {
    if (resultViewPart == null) {
      resultViewPart = new ResultView(multi);
    }
    return resultViewPart;
  }

  /**
   * Returns the current selection.
   *
   * @return the current selection
   */
  @SuppressWarnings("unchecked")
  protected List<R> getSelectedItems() {
    final IStructuredSelection selection = resultViewPart.getSelection();
    if (selection == null || selection.isEmpty()) {
      return null;
    }
    final List<R> selectedItems = new ArrayList<>();
    for (final Object selectedItem : selection.toArray()) {
      selectedItems.add((R) selectedItem);
    }
    return selectedItems;
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  /**
   * Returns {@code true} if the result item matches the filter
   *
   * @param result the result item
   * @param filter the current filter
   * @return {@code true} if the result item matches the filter
   */
  protected abstract boolean matchesFilter(R result, F filter);

  @Override
  protected void okPressed() {
    computeResult();
    super.okPressed();
  }

  /**
   * Performs the actual search with the given search pattern
   *
   * @param filter  the currently entered filter
   * @param monitor the progress monitor of the underlying search job
   */
  protected abstract SearchResultObject performSearch(F filter, IProgressMonitor monitor)
      throws CoreException;

  protected void restoreDialog(final IDialogSettings dialogSettings) {
    // TODO Auto-generated method stub
  }

  /**
   * Sets the label provider for the detail viewer which highlights the currently
   * selected result item
   *
   * @param labelProvider the label provider for the detail viewer which
   *                      highlights the currently selected result item
   */
  protected final void setDetailsLabelProvider(final IBaseLabelProvider labelProvider) {
    detailsLabelProvider = labelProvider;
  }

  /**
   * Allows overwriting the label of the default filter part {@link StringFilterPart}.
   *
   * @param filterLabel the filter label
   */
  protected void setFilterLabel(final String filterLabel) {
    this.filterLabel = filterLabel;
  }

  /**
   * Sets the view part which holds controls for filtering the results
   *
   * @param filterView the part which holds the filter controls
   */
  protected void setFilterViewPart(final IDialogFilterPart<F> filterView) {
    filterPart = filterView;
  }

  /**
   * Sets the initial dialog size.
   *
   * @param width  the initial dialog width or -1 if the preferred width should be
   *               used
   * @param height the initial dialog height or -1 if the preferred height should
   *               be used
   */
  protected void setInitialDialogSize(final int width, final int height) {
    defaultDialogWidth = width;
    defaultDialogHeight = height;
  }

  /**
   * Sets the initial filter
   *
   * @param filter the initial filter
   */
  protected final void setInitialFilter(final F filter) {
    initialFilter = filter;
  }

  /**
   * Sets the initial job delay
   *
   * @param jobDelay the initial job delay
   */
  protected final void setInitialJobDelay(final long jobDelay) {
    initialSearchJobDelay = jobDelay;
  }

  /**
   * Sets the given list as initial selection in the result viewer
   *
   * @param initialSelections list of initial selection
   */
  protected void setInitialSelections(final List<R> initialSelections) {
    inititalSelections = initialSelections;
  }

  /**
   * Sets the delay which is to be used for the search job
   *
   * @param jobDelay the delay for the search job
   */
  protected final void setJobDelay(final long jobDelay) {
    searchJobDelay = jobDelay;
  }

  /**
   * Sets new result from the given list
   *
   * @param newResult the new result list
   */
  protected void setResult(final List<R> newResult) {
    if (newResult != null) {
      result.clear();
      result.addAll(newResult);
    }
  }

  /**
   * Sets the content provider for the result viewer
   *
   * @param contentProvider content provider for the result viewer
   */
  protected final void setResultContentProvider(final IStructuredContentProvider contentProvider) {
    this.contentProvider = contentProvider;
  }

  /**
   * Sets the label provider for the result viewer
   *
   * @param labelProvider the label provider for the result viewer
   */
  protected final void setResultLabelProvider(final IBaseLabelProvider labelProvider) {
    resultLabelProvider = labelProvider;
  }

  /**
   * Sets the view part which is responsible for holding the filtered results.<br>
   * <strong>Note:</strong> If a custom implementation of {@link DialogResultPart}
   * is used, using the methods
   * <ul>
   * <li>{@link #setResultContentProvider(IStructuredContentProvider)}</li>
   * <li>{@link #setResultLabelProvider(IBaseLabelProvider)}</li>
   * <li>{@link #setDetailsLabelProvider(IBaseLabelProvider)}</li>
   * </ul>
   * will have no effect
   *
   * @param resultViewPart the part which holds the results
   */
  protected final void setResultViewPart(final DialogResultPart resultViewPart) {
    this.resultViewPart = resultViewPart;
  }

  protected void storeDialog(final IDialogSettings settings) {
  }

  /**
   * Update the status of the ok button to reflect the given status. Subclasses
   * may override this method to update additional buttons.
   *
   * @param status
   */
  protected void updateButtonsEnableState(final IStatus status) {
    final Button okButton = getOkButton();
    if (okButton != null && !okButton.isDisposed()) {
      okButton.setEnabled(status == null || !status.matches(IStatus.ERROR));
    }
  }

  private void applyFilter() {
    // clear old results
    resultViewPart.updateResults(null);

    final F currentFilter = filterPart.getFilter();
    final SearchJob newSearchJob = new SearchJob(currentFilter);
    if (searchJob != null && !newSearchJob.equals(searchJob) && !searchJob.isResultValid()) {
      searchJob.cancel();
      searchJob = null;
      setSearchStatus(null);
    }
    if (searchJob == null) {
      setSearchStatus(new Status(IStatus.INFO, AdtBaseUIPlugin.PLUGIN_ID,
          AdtBaseUIResources.getString(IAdtBaseStrings.SearchUI_Searching_xmsg)));
      searchJob = newSearchJob;
      searchJob.addJobChangeListener(new JobChangeAdapter() {
        @Override
        public void done(final IJobChangeEvent event) {
          handleSearchJobDone();
        }
      });
      long delay = searchJobDelay;
      if (initialSearchJobDelay != delay) {
        delay = initialSearchJobDelay;
        initialSearchJobDelay = searchJobDelay;
      }
      searchJob.schedule(delay);
    }
    // TODO: determine what to do at empty filter
    if (filterPart.isFilterEmpty()) {
      setSearchStatus(null);
    }
  }

  private IBaseLabelProvider getDetailsLabelProvider() {
    if (detailsLabelProvider == null) {
      detailsLabelProvider = new LabelProvider();
    }
    return detailsLabelProvider;
  }

  @SuppressWarnings("unchecked")
  private IDialogFilterPart<F> getFilterViewPart() {
    if (filterPart == null) {
      filterPart = (IDialogFilterPart<F>) new StringFilterPart(filterLabel);
    }
    return filterPart;
  }

  private IStructuredContentProvider getResultContentProvider() {
    if (contentProvider == null) {
      contentProvider = ArrayContentProvider.getInstance();
    }
    return contentProvider;
  }

  private IBaseLabelProvider getResultLabelProvider() {
    if (resultLabelProvider == null) {
      resultLabelProvider = new LabelProvider();
    }
    return resultLabelProvider;
  }

  private void handleFilterControls() {
    final Control[] filterControls = filterPart.getFilterControls();
    if (filterControls == null || filterControls.length == 0) {
      return;
    }
    if (filterControls.length == 1) {
      final Control lastFilterControl = filterControls[0];
      if (lastFilterControl instanceof Text) {
        lastFilterControl.addKeyListener(keyPressedAdapter(e -> {
          if (e.keyCode == SWT.ARROW_DOWN) {
            final StructuredViewer resultViewer = resultViewPart.getResultViewer();
            if (resultViewer instanceof TableViewer) {
              final Table table = ((TableViewer) resultViewer).getTable();
              if (table.getItemCount() > 0) {
                table.setFocus();
              }
            } else if (resultViewer instanceof TreeViewer) {
              final Tree tree = ((TreeViewer) resultViewer).getTree();
              if (tree.getItemCount() > 0) {
                tree.setFocus();
              }
            }
          }
        }));
      }
    }
    for (final Control filterControl : filterControls) {
      if (filterControl instanceof Text) {
        ((Text) filterControl).addModifyListener(e -> {
          applyFilter();
        });
      } else if (filterControl instanceof Combo) {
        ((Combo) filterControl).addModifyListener(e -> {
          applyFilter();
        });
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void handleSearchJobDone() {
    final Exception resultException = searchJob.getResultException();
    if (resultException != null) {
      IStatus status = null;
      if (resultException instanceof CoreException) {
        status = ((CoreException) resultException).getStatus();
      } else {
        status = new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
            resultException.getLocalizedMessage());
      }
      setSearchStatus(status);
    } else {
      final F filter = searchJob.getFilter();
      final SearchResultObject searchResult = searchJob.getSearchResult();
      final List<R> validResults = new ArrayList<>();
      if (searchResult != null) {
        int validResultsCount = 0;
        for (final R result : searchResult.getResultObjects()) {
          if (matchesFilter(result, filter)) {
            validResults.add(result);
            ++validResultsCount;
          }
        }
        if (validResultsCount == 0) {
          setSearchStatus(new Status(IStatus.INFO, AdtBaseUIPlugin.PLUGIN_ID,
              AdtBaseUIResources.getString(IAdtBaseStrings.SearchUI_NoResults_xmsg)));
        } else if (!searchResult.isResultComplete()) {
          setSearchStatus(new Status(IStatus.WARNING, AdtBaseUIPlugin.PLUGIN_ID, AdtBaseUIResources
              .format(IAdtBaseStrings.SearchUI_ResultsExceedMaximum_xmsg, validResultsCount)));
        } else if (validResultsCount == 1) {
          setSearchStatus(new Status(IStatus.INFO, AdtBaseUIPlugin.PLUGIN_ID,
              AdtBaseUIResources.getString(IAdtBaseStrings.SearchUI_OneResult_xmsg)));
        } else {
          setSearchStatus(new Status(IStatus.INFO, AdtBaseUIPlugin.PLUGIN_ID, AdtBaseUIResources
              .format(IAdtBaseStrings.SearchUI_SpecificResults_xmsg, validResultsCount)));
        }
      }
      Display.getDefault().asyncExec(() -> {
        resultViewPart.updateResults((List<Object>) validResults);
      });
    }
  }

  private void handleSelected(final IStructuredSelection selection) {
    updateDetails(selection);
  }

  private void setSearchStatus(final IStatus status) {
    Display.getDefault().asyncExec(() -> {
      if (statusLine != null && !statusLine.isDisposed()) {
        statusLine.setStatus(status);
      }
    });
  }

  private void updateDetails(final IStructuredSelection selection) {
    final ContentViewer detailViewer = resultViewPart.getDetailViewer();
    if (detailViewer == null) {
      return;
    }
    if (selection == null || selection.isEmpty()) {
      detailViewer.setInput(null);
    } else {
      detailViewer.setInput(selection);
      if (selection.size() > 1) {
        detailViewer.setInput(
            MessageFormat.format(Messages.SearchSelectionDialog_ItemsSelected, selection.size()));
      } else {
        detailViewer.setInput(selection.getFirstElement());
      }
    }
  }
}
