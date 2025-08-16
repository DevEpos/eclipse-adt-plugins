package com.devepos.adt.cst.ui.internal.converter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.ui.projectexplorer.virtualfolders.IVirtualFolderNode;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.search.ICodeSearchFeatureUtil;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.IFilterConstants;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuery;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuerySpecification;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchRelevantWbTypesUtil;
import com.devepos.adt.cst.ui.internal.codesearch.FilterName;
import com.devepos.adt.cst.ui.internal.codesearch.NamedItem;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;

public class VirtualFolderToQueryConverter {
  private static final String FULL_DATE_PATTERN = "%s.%d.%d";
  private static final String VFS_NEGATION_SIGN = "-";

  private final IVirtualFolderNode node;

  private final StringBuffer filterBuffer;
  private final CodeSearchQuerySpecification querySpecs;
  private final boolean targetIsClient;

  public VirtualFolderToQueryConverter(final IVirtualFolderNode node) {
    this.node = node;
    filterBuffer = new StringBuffer();
    querySpecs = new CodeSearchQuerySpecification();
    var featureUtil = CodeSearchFactory.getCodeSearchFeatureUtil(node.getProject());
    var codeSearchStatus = featureUtil
        .testSearchAvailabilityByProject(CodeSearchUIPlugin.getDefault()
            .getPreferenceStore()
            .getBoolean(ICodeSearchPrefs.PREFER_CLIENT_BASED_SEARCH));
    targetIsClient = codeSearchStatus.getCode() == ICodeSearchFeatureUtil.SEARCH_TARGET_CLIENT;
  }

  public CodeSearchQuery convert() {
    addFiltersToFilterString(node.getUserFilters(), FilterName.OWNER.getContentAssistName());
    addFiltersToFilterString(node.getPackageFilters(), FilterName.PACKAGE.getContentAssistName());
    addFiltersToFilterString(node.getApplicationComponentFilters(),
        FilterName.APPLICATION_COMPONENT.getContentAssistName());
    if (targetIsClient) {
      addFiltersToFilterString(node.getSoftwareComponentFilters(),
          FilterName.SOFTWARE_COMPONENT.getContentAssistName());
      addFiltersToFilterString(node.getCreatedYearFilters(),
          FilterName.CREATED_FACET_YEAR.getContentAssistName());
      addFiltersToFilterString(node.getCreatedMonthFilters(),
          FilterName.CREATED_FACET_MONTH.getContentAssistName());
      addFiltersToFilterString(node.getCreatedDateFilters(),
          FilterName.CREATED_FACET_DATE.getContentAssistName());
      addFiltersToFilterString(node.getApiStateFilters(),
          FilterName.API_STATE.getContentAssistName());
    } else {
      var uriTemplateProvider = CodeSearchFactory
          .getNamedItemUriTemplateProvider(node.getProject());
      if (uriTemplateProvider
          .getTemplateByDiscoveryTerm(NamedItem.SOFTWARE_COMPONENT.getDiscoveryTerm()) != null) {
        addFiltersToFilterString(node.getSoftwareComponentFilters(),
            FilterName.SOFTWARE_COMPONENT.getContentAssistName());
      }
      if (uriTemplateProvider
          .getTemplateByDiscoveryTerm(NamedItem.API_STATE.getDiscoveryTerm()) != null) {
        addFiltersToFilterString(node.getApiStateFilters(),
            FilterName.API_STATE.getContentAssistName());
      }
      addCreatedFilters();
    }
    addTypeFilters();

    querySpecs.setIgnoreCaseCheck(true);
    querySpecs.setObjectScopeFilters(null, filterBuffer.toString());
    querySpecs.setObjectNames(node.getSearchString());

    return new CodeSearchQuery(querySpecs);
  }

  private void addCreatedFilters() {
    List<String> createdDatePatterns = new ArrayList<>();

    var dateFilters = node.getCreatedDateFilters();
    for (String date : dateFilters) {
      var negatedSign = date.startsWith(VFS_NEGATION_SIGN) ? StringUtil.NEGATION1 : "";
      date = StringUtil.removeNegationCharacter(date, VFS_NEGATION_SIGN);
      createdDatePatterns.add(
          negatedSign + String.format(FULL_DATE_PATTERN, Integer.parseInt(date.substring(6, 8)),
              Integer.parseInt(date.substring(4, 6)), Integer.parseInt(date.substring(0, 4))));
    }

    var createdYearFilters = node.getCreatedYearFilters();
    for (var year : createdYearFilters) {
      var negatedSign = year.startsWith(VFS_NEGATION_SIGN) ? StringUtil.NEGATION1 : "";
      year = StringUtil.removeNegationCharacter(year, VFS_NEGATION_SIGN);
      createdDatePatterns.add(negatedSign + year);
    }

    addFiltersToFilterString(createdDatePatterns, FilterName.CREATED_DATE.getContentAssistName());
  }

  private void addFiltersToFilterString(final List<String> filters, final String filterQualifier) {
    if (filters == null || filters.isEmpty()) {
      return;
    }
    if (filterBuffer.length() > 0) {
      filterBuffer.append(" ");
    }
    var adjustedFilters = new ArrayList<String>();
    for (var filter : filters) {
      if (filter.startsWith(VFS_NEGATION_SIGN)) {
        adjustedFilters.add(
            StringUtil.NEGATION1 + StringUtil.removeNegationCharacter(filter, VFS_NEGATION_SIGN));
      } else {
        adjustedFilters.add(filter);
      }
    }
    filterBuffer.append(String.format(IFilterConstants.FILTER_VALUES_PATTERN, filterQualifier,
        String.join(IFilterConstants.FILTER_VALUE_DELIMITER, adjustedFilters).toLowerCase()));
  }

  private void addTypeFilters() {
    addFiltersToFilterString(extractValidTypeFilters(node.getProject(), node.getTypeFilters()),
        FilterName.OBJECT_TYPE.getContentAssistName());
  }

  /**
   * Extracts valid type filters by checking against the valid filters for the Code Search
   *
   * @param types list of types
   * @return a valid List of type filters
   */
  private List<String> extractValidTypeFilters(final IProject project, final List<String> types) {
    if (types == null || types.isEmpty()) {
      return null;
    }
    List<String> validTypes = new ArrayList<>();
    List<String> possibleTypes = CodeSearchRelevantWbTypesUtil
        .getPossibleValuesForTypeFilter(project);

    for (String type : types) {
      var negatedSign = type.startsWith(VFS_NEGATION_SIGN) ? StringUtil.NEGATION1 : "";
      var typeNoNegation = StringUtil.removeNegationCharacter(type, VFS_NEGATION_SIGN);

      if (possibleTypes.stream().anyMatch(f -> f.equalsIgnoreCase(typeNoNegation))) {
        if (typeNoNegation.equalsIgnoreCase(ITadirTypeConstants.EXECUTABLE_REPORT)
            || typeNoNegation.equalsIgnoreCase(ITadirTypeConstants.INCLUDE)) {
          validTypes.add(negatedSign + ITadirTypeConstants.PROGRAM);
        } else {
          validTypes.add(negatedSign + typeNoNegation);
        }
      }
    }
    return validTypes;
  }

}