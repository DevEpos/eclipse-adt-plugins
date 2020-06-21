package com.devepos.adt.tools.base.ui.dialogs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SearchPattern;

import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseStrings;
import com.devepos.adt.tools.base.internal.AdtToolsBasePlugin;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.util.StatusUtil;
import com.devepos.adt.tools.base.util.StringUtil;

/**
 * Extends the {@link FilteredItemsSelectionDialog} for reading objects from an
 * ADT Backend.
 * 
 * @author stockbal
 *
 * @param <R>
 */
public abstract class AdtFilteredItemsSelectionDialog<R> extends FilteredItemsSelectionDialog {
	private static final String DIALOG_SETTINGS_NAME = AdtFilteredItemsSelectionDialog.class.getCanonicalName();
	private Label searchStatusImageLabel;
	private Label searchStatusTextLabel;
	private long searchDelay = 800L;
	private SearchJob searchJob;
	private ILabelProvider delegatingLabelProvider;
	private String searchPattern;
	private long initialJobDelay = this.searchDelay;

	public AdtFilteredItemsSelectionDialog(final Shell shell, final boolean multi) {
		super(shell, multi);
		setListLabelProvider(new LabelProvider());
	}

	@Override
	public String getElementName(final Object item) {
		if (item instanceof IAdtObjRef) {
			return ((IAdtObjRef) item).getName();
		}
		return null;
	}

	@Override
	public Text getPatternControl() {
		return (Text) super.getPatternControl();
	}

	@Override
	public void setListLabelProvider(final ILabelProvider listLabelProvider) {
		this.delegatingLabelProvider = new DelegatingStyledLabelProvider(listLabelProvider);
		super.setListLabelProvider(this.delegatingLabelProvider);
	}

	@Override
	public void setDetailsLabelProvider(final ILabelProvider detailsLabelProvider) {
		final DelegatingStyledLabelProvider provider = new DelegatingStyledLabelProvider(detailsLabelProvider);
		super.setDetailsLabelProvider(provider);
	}

	@Override
	public void setInitialPattern(final String text) {
		super.setInitialPattern(text);
		setSearchPattern(text);
	}

	@Override
	public void setInitialPattern(final String text, final int selectionMode) {
		super.setInitialPattern(text, selectionMode);
		setSearchPattern(text);
	}

	/**
	 * Sets the initial search job delay. <br>
	 * Note: This is only relevant if a search pattern was set with
	 * {@link #setInitialPattern(String)}
	 * 
	 * @param delay the initial delay for the search job
	 */
	protected void setInitialJobDelay(final long delay) {
		this.initialJobDelay = delay;
	}

	/**
	 * Sets the delay time for the search job
	 * 
	 * @param delay the job delay time
	 */
	protected void setJobDelay(final long delay) {
		this.searchDelay = delay;
	}

	protected abstract SearchResultObject<R> performSearch(String pattern, IProgressMonitor monitor)
			throws CoreException;

	protected void triggerDialogUpdate() {
		updateButtonsEnableState(new Status(IStatus.ERROR, AdtToolsBasePlugin.PLUGIN_ID, ""));
		setSearchStatus(null);
		applyFilter();
	}

	@Override
	public R getFirstResult() {
		final Object rawResult = super.getFirstResult();
		if (rawResult != null && rawResult instanceof SearchResult<?>) {
			return (R) ((SearchResult<?>) rawResult).getResult();
		}
		return null;
	}

	public R[] getTypedResult() {
		final Object[] superResult = this.getResult();
		return createArray(superResult);
	}

	protected R[] getTypedSelectedItems() {
		final IStructuredSelection selectedItems = this.getSelectedItems();
		final Object[] array = selectedItems.toArray();
		return createArray(array);
	}

	@Override
	protected Control createExtendedContentArea(final Composite parent) {
		final Composite status = new Composite(parent, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(status);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(status);
		this.searchStatusImageLabel = new Label(status, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.CENTER).applyTo(this.searchStatusImageLabel);
		this.searchStatusTextLabel = new Label(status, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.searchStatusTextLabel);
		return status;
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Control dialogArea = super.createDialogArea(parent);
		final Text textControl = getPatternControl();
		// remove any existing modify listeners from the pattern control
		final Listener[] arrlistener = textControl.getListeners(SWT.Modify);
		for (final Listener l : arrlistener) {
			textControl.removeListener(SWT.Modify, l);
		}
		textControl.addModifyListener(e -> {
			final Text patternControl = (Text) e.widget;
			setSearchPattern(patternControl.getText());
			triggerDialogUpdate();
		});
		applyDialogFont(dialogArea);
		return dialogArea;
	}

	protected void setSearchPattern(String pattern) {
		if (pattern == null) {
			pattern = "";
		}
		this.searchPattern = pattern.trim();
	}

	protected String getSearchPattern() {
		return this.searchPattern;
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		return AdtToolsBasePlugin.getDefault().getDialogSettingsSection(DIALOG_SETTINGS_NAME);
	}

	@Override
	protected IStatus validateItem(final Object item) {
		return Status.OK_STATUS;
	}

	protected boolean matchLocally(final String pattern, final R item) {
		final String elementName = this.delegatingLabelProvider.getText(item);
		final SearchPattern searchPattern = new SearchPattern();
		searchPattern.setPattern(pattern.toLowerCase(Locale.ENGLISH));
		return searchPattern.matches(elementName.toLowerCase(Locale.ENGLISH));
	}

	@Override
	protected AdtItemsFilter createFilter() {
		final Control patternControl = getPatternControl();
		if (patternControl == null || patternControl.isDisposed()) {
			return null;
		}
		final AdtItemsFilter filter = new AdtItemsFilter(new SearchPattern());
		filter.setPattern(this.searchPattern);
		return filter;
	}

	@Override
	protected Comparator<SearchResult<R>> getItemsComparator() {
		return (o1, o2) -> {
			final String text1 = AdtFilteredItemsSelectionDialog.this.delegatingLabelProvider.getText(o1);
			final String text2 = AdtFilteredItemsSelectionDialog.this.delegatingLabelProvider.getText(o2);
			return text1.compareTo(text2);
		};
	}

	@Override
	protected void fillContentProvider(final AbstractContentProvider contentProvider, final ItemsFilter itemsFilter,
			final IProgressMonitor progressMonitor) throws CoreException {

		progressMonitor.worked(1);
		final SearchJob newSearchJob = new SearchJob(getSearchPattern());
		if (this.searchJob != null && !newSearchJob.equals(this.searchJob) && !this.searchJob.isResultValid()) {
			this.searchJob.cancel();
			this.searchJob = null;
			setSearchStatus(null);
		}
		if (this.searchJob != null) {
			final Exception resultException = this.searchJob.getResultException();
			if (resultException != null) {
				IStatus status = null;
				if (resultException instanceof CoreException) {
					status = ((CoreException) resultException).getStatus();
				} else {
					status = new Status(IStatus.ERROR, AdtToolsBasePlugin.PLUGIN_ID,
							resultException.getLocalizedMessage());
				}
				setSearchStatus(status);
			} else {

				final SearchResultObject<R> searchResult = this.searchJob.getSearchResult();

				if (searchResult != null) {
					int validResults = 0;
					for (final R result : searchResult.getResultObjects()) {
						contentProvider.add(new SearchResult<>(result), itemsFilter);
						++validResults;
					}
					if (validResults == 0) {
						setSearchStatus(new Status(IStatus.INFO, AdtToolsBasePlugin.PLUGIN_ID,
								AdtToolsBaseResources.getString(IAdtToolsBaseStrings.SearchUI_NoResults_xmsg)));
					} else if (!searchResult.isResultComplete()) {
						setSearchStatus(new Status(IStatus.WARNING, AdtToolsBasePlugin.PLUGIN_ID, AdtToolsBaseResources
								.format(IAdtToolsBaseStrings.SearchUI_ResultsExceedMaximum_xmsg, validResults)));
					} else if (validResults == 1) {
						setSearchStatus(new Status(IStatus.INFO, AdtToolsBasePlugin.PLUGIN_ID,
								AdtToolsBaseResources.getString(IAdtToolsBaseStrings.SearchUI_OneResult_xmsg)));
					} else {
						setSearchStatus(new Status(IStatus.INFO, AdtToolsBasePlugin.PLUGIN_ID, AdtToolsBaseResources
								.format(IAdtToolsBaseStrings.SearchUI_SpecificResults_xmsg, validResults)));
					}
				}
			}
		} else {
			setSearchStatus(new Status(IStatus.OK, AdtToolsBasePlugin.PLUGIN_ID,
					AdtToolsBaseResources.getString(IAdtToolsBaseStrings.SearchUI_Searching_xmsg)));
			this.searchJob = newSearchJob;
			long delay = this.searchDelay;
			if (this.initialJobDelay != delay) {
				delay = this.initialJobDelay;
				this.initialJobDelay = this.searchDelay;
			}
			this.searchJob.schedule(delay);
		}
		Display.getDefault().asyncExec(() -> {
			if (!getPatternControl().isDisposed() && StringUtil.isEmpty(getSearchPattern())) {
				setSearchStatus(null);
			}
		});
		progressMonitor.done();
	}

	private void setSearchStatus(final IStatus status) {
		Display.getDefault().asyncExec(() -> {
			if (status == null) {
				this.searchStatusImageLabel.setImage(null);
				this.searchStatusTextLabel.setText("");
			} else {
				if (StringUtil.isEmpty(status.getMessage())) {
					this.searchStatusImageLabel.setImage(null);
					this.searchStatusTextLabel.setText("");
				} else {
					this.searchStatusImageLabel.setImage(StatusUtil.getImageForStatus(status.getSeverity()));
					this.searchStatusTextLabel.setText(status.getMessage());
				}
			}
			this.searchStatusTextLabel.pack(true);
			this.searchStatusImageLabel.getParent().layout(true);
			updateButtonsEnableState(status == null ? Status.OK_STATUS : status);
		});
	}

	private R[] createArray(final Object[] raw) {
		if (raw != null && raw.length > 0) {
			final Class<?> resultClass = ((SearchResult) raw[0]).getResult().getClass();
			final R[] result = (R[]) Array.newInstance(resultClass, raw.length);
			int i = 0;
			while (i < raw.length) {
				result[i] = ((SearchResult<R>) raw[i]).getResult();
				++i;
			}
			return result;
		}
		return null;
	}

	static class DelegatingStyledLabelProvider extends LabelProvider
			implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {
		protected final ILabelProvider innerLabelProvider;

		public DelegatingStyledLabelProvider(final ILabelProvider innerLabelProvider) {
			this.innerLabelProvider = innerLabelProvider;
		}

		@Override
		public String getText(final Object element) {
			if (element instanceof SearchResult) {
				final Object result = ((SearchResult<?>) element).getResult();
				return this.innerLabelProvider.getText(result);
			}
			return this.innerLabelProvider.getText(element);
		}

		@Override
		public Image getImage(final Object element) {
			if (element instanceof SearchResult) {
				final Object result = ((SearchResult<?>) element).getResult();
				return this.innerLabelProvider.getImage(result);
			}
			return this.innerLabelProvider.getImage(element);
		}

		@Override
		public StyledString getStyledText(final Object element) {
			if (this.innerLabelProvider instanceof DelegatingStyledCellLabelProvider.IStyledLabelProvider) {
				if (element instanceof SearchResult) {
					final Object result = ((SearchResult<?>) element).getResult();
					return ((DelegatingStyledCellLabelProvider.IStyledLabelProvider) this.innerLabelProvider)
							.getStyledText(result);
				}
				return ((DelegatingStyledCellLabelProvider.IStyledLabelProvider) this.innerLabelProvider)
						.getStyledText(element);
			}
			return new StyledString(this.getText(element));
		}
	}

	private final class AdtItemsFilter extends ItemsFilter {

		public AdtItemsFilter(final SearchPattern searchPattern) {
			super(searchPattern);
		}

		public void setPattern(final String pattern) {
			this.patternMatcher.setPattern(pattern);
		}

		@Override
		public boolean matchItem(final Object item) {
			if (item instanceof SearchResult) {
				final R result = ((SearchResult<R>) item).getResult();
				return matchLocally(getSearchPattern(), result);
			}
			return false;
		}

		@Override
		public boolean isConsistentItem(final Object item) {
			return true;
		}

		@Override
		public boolean equalsFilter(final ItemsFilter filter) {
			return false;
		}

		@Override
		public boolean isSubFilter(final ItemsFilter filter) {
			return false;
		}
	}

	private final class SearchJob extends Job {
		private SearchResultObject<R> searchResult;
		private final String searchPattern;
		private boolean isResultComplete;
		private Exception searchJobException;

		public SearchJob(final String searchPattern) {
			super(AdtToolsBaseResources.getString(IAdtToolsBaseStrings.SearchUI_Searching_xmsg));
			setSystem(true);
			this.searchPattern = searchPattern;
		}

		/**
		 * @return the result
		 */
		public SearchResultObject<R> getSearchResult() {
			return this.searchResult;
		}

		@Override
		public boolean equals(final Object obj) {
			if (obj == null || !(obj instanceof AdtFilteredItemsSelectionDialog<?>.SearchJob)) {
				return false;
			}
			return ((SearchJob) obj).searchPattern.equals(this.searchPattern);
		}

		public boolean isResultValid() {
			if (this.searchResult == null) {
				return false;
			}
			if (!this.isResultComplete) {
				return false;
			}
			return true;
		}

		public Exception getResultException() {
			return this.searchJobException;
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			try {
				this.searchResult = performSearch(this.searchPattern, monitor);
			} catch (final CoreException e) {
				this.searchJobException = e;
			}
			Display.getDefault().asyncExec(() -> {
				triggerDialogUpdate();
			});
			return this.searchJobException != null ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}
	}

	protected static final class SearchResult<R> {
		private final R result;

		public SearchResult(final R result) {
			this.result = result;
		}

		public R getResult() {
			return this.result;
		}

		@Override
		public boolean equals(final Object o) {
			if (this == o) {
				return true;
			}
			if (!(o instanceof SearchResult)) {
				return false;
			}
			final SearchResult<?> other = (SearchResult<?>) o;
			if (this.result == null && other.result == null) {
				return true;
			} else if (this.result == null || other.result == null) {
				return false;
			}
			return other.result.equals(this.result);
		}

		@Override
		public int hashCode() {
			return this.result == null ? 0 : this.result.hashCode();
		}
	}

	public final class SearchResultObject<T> {
		private final List<T> resultObjects;
		private final boolean resultComplete;

		public SearchResultObject(final List<T> resultObjects, final boolean resultComplete) {
			this.resultObjects = resultObjects == null ? new ArrayList<>() : resultObjects;
			this.resultComplete = resultComplete;
		}

		protected List<T> getResultObjects() {
			return this.resultObjects;
		}

		protected boolean isResultComplete() {
			return this.resultComplete;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("is complete: ");
			sb.append(isResultComplete());
			sb.append(", result: ");
			sb.append(this.resultObjects);
			return sb.toString();
		}
	}
}
