package com.devepos.adt.saat.ui.internal.search.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryField;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryInput;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.messages.Messages;

/**
 * Represents the search fields in the Object Search Dialog
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class ObjectSearchFields {

  private final List<SearchInputField> fields = new ArrayList<>();
  private final Map<String, ICustomSearchOptionControl> customOptionControls = new HashMap<>();
  private final Composite container;
  private final IAbapProjectProvider projectProvider;
  private ISearchTypeConfig currentSearchType;
  private final ISearchPageStatusUpdater status;
  private final IPageLayoutUpdater layoutUpdater;
  private final Composite optionsContainer;

  public ObjectSearchFields(final Composite container, final Composite optionsContainer,
      final IAbapProjectProvider projectProvider, final ISearchPageStatusUpdater status,
      final IPageLayoutUpdater layoutUpdater) {
    this.status = status;
    this.container = container;
    this.optionsContainer = optionsContainer;
    this.projectProvider = projectProvider;
    this.layoutUpdater = layoutUpdater;
  }

  public void fillCustomOptionFromQuery(
      final Map<? extends String, ? extends String> customOptions) {
    for (var key : customOptions.keySet()) {
      var optionControl = customOptionControls.get(key);
      if (optionControl != null) {
        var value = customOptions.get(key);
        optionControl.setOptionValue(value);
      }
    }
  }

  /**
   * Fill field input from list of query fields
   *
   * @param queryFields list of query fields
   */
  public void fillInputFromQueryFields(final List<ISearchQueryField> queryFields) {
    if (queryFields == null) {
      return;
    }
    for (var queryField : queryFields) {
      for (var field : fields) {
        if (field.getFieldName().equals(queryField.getName())) {
          field.setText(queryField.getRawInput());
          break;
        }
      }
    }
  }

  public Map<? extends String, ? extends String> getCustomOptions() {
    var optionMap = new HashMap<String, String>();
    for (var optionKey : customOptionControls.keySet()) {
      var optionControl = customOptionControls.get(optionKey);
      var currentValue = optionControl.getOptionValue();
      if (currentValue != null) {
        optionMap.put(optionKey, currentValue);
      }
    }
    return optionMap;
  }

  /**
   * @return {@code true} if there is at least one search field with input
   */
  public boolean hasInput() {
    return fields.stream().anyMatch(f -> !f.isEmpty());
  }

  public void initialize() {
    projectProvider.addPropertyChangeListener(l -> {
      if (l.getNewValue() != null) {
        enableControls(true);
      } else {
        enableControls(false);
      }
    });
  }

  public void setFocus() {
    if (fields.isEmpty()) {
      return;
    }
    var firstField = fields.get(0);
    firstField.setFocus();
  }

  public void setSelection(final boolean doSetCursorToEnd) {
    for (var field : fields) {
      field.setSelection(doSetCursorToEnd);
    }
  }

  public void setTextInFirstInput(final String selectedText) {
    if (fields.isEmpty()) {
      return;
    }
    var firstField = fields.get(0);
    firstField.setText(selectedText);
  }

  /**
   * Converts the input of the search fields to the structure of search query fields
   *
   * @see {@link ISearchQueryInput}
   * @return
   */
  public List<ISearchQueryField> toSearchQueryFields() {
    var queryFields = new ArrayList<ISearchQueryField>();
    for (var field : fields) {
      var queryField = field.toSearchQueryField();
      if (!queryField.getValues().isEmpty() || !queryField.getFilters().isEmpty()) {
        queryFields.add(queryField);
      }
    }
    return queryFields;
  }

  public void updateControls(final ISearchTypeConfig selectedSearchType) {
    currentSearchType = selectedSearchType;
    if (currentSearchType == null) {
      return;
    }

    if (currentSearchType == null) {
      status.validateAndSetStatus(new Status(IStatus.ERROR, SearchAndAnalysisPlugin.PLUGIN_ID, NLS
          .bind(Messages.ObjectSearch_SearchTypeNotSupported_xmsg, currentSearchType.getLabel(),
              projectProvider.getProjectName()), null),
          ObjectSearchDialogValidationSource.SEARCH_TYPE.name());
      status.updateOKStatus();
      return;
    }

    var previousInputs = disposeCurrentFields();
    boolean filtersValid = true;
    for (var inputConfig : currentSearchType.getInputs()) {
      var inputField = new SearchInputField(container, projectProvider, status, inputConfig);
      fields.add(inputField);
      status.addStatusSource(inputField.getFieldName());
      inputField.createControls();
      inputField.setText(previousInputs.get(inputConfig.getName()));
      inputField.initializeContentAssist();
      inputField.registerModificationListener();
      var fieldStatus = inputField.validateField();
      if (filtersValid && !fieldStatus.isOK()) {
        status.validateAndSetStatus(fieldStatus, inputConfig.getName());
        status.updateOKStatus();
        filtersValid = false;
      }
    }

    updateCustomOptions();

    if (filtersValid) {
      status.validateAndSetStatus(Status.OK_STATUS, ObjectSearchDialogValidationSource.SEARCH_TYPE
          .name());
      status.updateOKStatus();
    }

    layoutUpdater.updatePageLayout();
  }

  private Map<String, String> disposeCurrentFields() {
    var lastInputs = new HashMap<String, String>();
    for (var fieldInfo : fields) {
      status.removeStatusSource(fieldInfo.getFieldName());
      lastInputs.put(fieldInfo.getFieldName(), fieldInfo.getCurrentInput());
      fieldInfo.dispose();
    }
    fields.clear();
    return lastInputs;
  }

  private void enableControls(final boolean enable) {
    container.setEnabled(enable);
    for (var field : fields) {
      field.setEnabled(enable);
    }
  }

  private void updateCustomOptions() {
    for (var child : optionsContainer.getChildren()) {
      child.dispose();
    }

    customOptionControls.clear();

    for (var option : currentSearchType.getCustomOptions()) {
      var optionControl = CustomSearchOptionControlCreator.create(option);
      if (optionControl == null) {
        SearchAndAnalysisPlugin.getDefault()
            .getLog()
            .log(new Status(IStatus.WARNING, SearchAndAnalysisPlugin.PLUGIN_ID, String.format(
                "Custom option '%s' for search type '%s' could not be created", option.getLabel(),
                currentSearchType.getLabel())));
      } else {
        optionControl.createControl(optionsContainer);
        customOptionControls.put(option.getKey(), optionControl);
      }
    }

    optionsContainer.layout();
    optionsContainer.getParent().layout(true);
  }
}
