package com.devepos.adt.saat.ui.internal.search.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.ISearchFilterProvider;
import com.devepos.adt.base.ui.search.SearchFilterHandler;
import com.devepos.adt.base.ui.util.TextControlUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchFactory;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryField;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.sap.adt.util.ui.swt.AdtSWTUtilFactory;

class SearchInputField implements ISearchFilterProvider {
  private Text input;
  private Label label;
  private final ISearchTypeInputFieldConfig fieldConfig;
  private SearchFilterHandler filterHandler;
  private final List<ISearchFilter> configuredFilters = new ArrayList<>();
  private final Composite parent;
  private final IAbapProjectProvider projectProvider;
  private final ISearchPageStatusUpdater pageStatus;

  public SearchInputField(final Composite parent, final IAbapProjectProvider projectProvider,
      final ISearchPageStatusUpdater pageStatus,
      final ISearchTypeInputFieldConfig inputFieldConfig) {
    fieldConfig = inputFieldConfig;
    this.parent = parent;
    this.pageStatus = pageStatus;
    this.projectProvider = projectProvider;
  }

  public void createControls() {
    label = new Label(parent, SWT.NONE);
    label.setText(fieldConfig.getLabel() + ":");
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(label);

    input = new Text(parent, SWT.BORDER);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(input);

    TextControlUtil.addWordSupport(input);
    AdtSWTUtilFactory.getOrCreateSWTUtil().addTextEditMenu(input);
  }

  public void dispose() {
    if (label != null && !label.isDisposed()) {
      label.dispose();
      label = null;
    }
    if (input != null && !input.isDisposed()) {
      input.dispose();
      input = null;
    }

    if (filterHandler != null) {
      filterHandler.dispose();
    }
    configuredFilters.clear();
  }

  public String getCurrentInput() {
    return input != null && !input.isDisposed() ? input.getText() : "";
  }

  public String getFieldName() {
    return fieldConfig.getName();
  }

  @Override
  public List<ISearchFilter> getFilters() {
    return configuredFilters;
  }

  public void initializeContentAssist() {
    var filterConfigs = fieldConfig.getFilters();
    if (filterConfigs.isEmpty()) {
      return;
    }

    for (var filterConfig : filterConfigs) {
      if (filterConfig.isInternal()) {
        continue;
      }
      var searchFilter = new FilterInitializer(filterConfig, projectProvider).createFilter();
      configuredFilters.add(searchFilter);
    }

    if (configuredFilters.isEmpty()) {
      return;
    }

    filterHandler = new SearchFilterHandler(this);
    filterHandler.addContentAssist(input);
    filterHandler.enableSearchTermInput(fieldConfig.isMixed());
  }

  public boolean isEmpty() {
    return isOnline() ? StringUtil.isEmpty(input.getText()) : true;
  }

  public void registerModificationListener() {
    input.addModifyListener(event -> {
      pageStatus.validateAndSetStatus(validateField(), getFieldName());
      pageStatus.updateOKStatus();
    });
  }

  public void setEnabled(final boolean enable) {
    if (isOnline()) {
      input.setEnabled(enable);
    }
  }

  public void setFocus() {
    if (isOnline()) {
      input.setFocus();
    }
  }

  public void setSelection(final boolean setCursorToEnd) {
    if (!isOnline()) {
      return;
    }
    if (setCursorToEnd) {
      var content = input.getText();
      if (!StringUtil.isEmpty(content)) {
        input.setSelection(content.length());
      }
    } else {
      input.selectAll();
    }
  }

  public void setText(final String text) {
    if (isOnline()) {
      input.setText(text != null ? text : "");
    }
  }

  @SuppressWarnings("unchecked")
  public ISearchQueryField toSearchQueryField() {
    var queryField = IObjectSearchFactory.eINSTANCE.createSearchQueryField();
    queryField.setName(getFieldName());
    queryField.setLabel(fieldConfig.getLabel());

    if (filterHandler != null) {
      var filterValMap = filterHandler.getSearchFiltersAsListMap(input.getText(), null);
      for (var key : filterValMap.keySet()) {
        var queryFieldFilter = IObjectSearchFactory.eINSTANCE.createSearchQueryFilter();
        queryFieldFilter.setName(key);
        var values = (List<String>) filterValMap.get(key);
        for (var val : values) {
          queryFieldFilter.getValues().add(val);
        }
        queryField.getFilters().add(queryFieldFilter);
      }
    } else {
      var content = input.getText();
      if (!StringUtil.isBlank(content)) {
        queryField.getValues().addAll(Arrays.asList(content.trim().split(" ")));
      }
    }
    queryField.setRawInput(input.getText());
    return queryField;
  }

  public IStatus validateField() {
    if (filterHandler == null || isEmpty()) {
      return Status.OK_STATUS;
    }
    try {
      filterHandler.checkSearchFiltersComplete(input.getText());
    } catch (CoreException e) {
      return new Status(IStatus.ERROR, SearchAndAnalysisPlugin.PLUGIN_ID, e.getMessage(), e);
    }
    return Status.OK_STATUS;
  }

  private boolean isOnline() {
    return input != null && !input.isDisposed();
  }
}