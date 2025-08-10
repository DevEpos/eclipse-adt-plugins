package com.devepos.adt.cst.ui.internal.converter;

import java.util.Arrays;
import java.util.List;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.ui.projectexplorer.node.IAbapRepositoryFolderNode;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.ui.internal.IFilterConstants;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuery;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuerySpecification;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchRelevantWbTypesUtil;
import com.devepos.adt.cst.ui.internal.codesearch.FilterName;
import com.devepos.adt.cst.ui.internal.codesearch.ProjectDependentTypeAvailability;

public class AbapRepositoryFolderToQueryConverter {
  private final IAbapRepositoryFolderNode node;

  private final StringBuffer filterBuffer;
  private final CodeSearchQuerySpecification querySpecs;

  public AbapRepositoryFolderToQueryConverter(final IAbapRepositoryFolderNode node) {
    this.node = node;
    filterBuffer = new StringBuffer();
    querySpecs = new CodeSearchQuerySpecification();
  }

  public CodeSearchQuery convert() {
    addFiltersToFilterString(node.getUser(), FilterName.OWNER.getContentAssistName());
    addFiltersToFilterString(node.getPackages(), FilterName.PACKAGE.getContentAssistName());
    addTypeFilters(FilterName.OBJECT_TYPE.getContentAssistName());

    querySpecs.setIgnoreCaseCheck(true);
    querySpecs.setObjectScopeFilters(null, filterBuffer.toString());

    return new CodeSearchQuery(querySpecs);
  }

  private void addFiltersToFilterString(final List<String> filters, final String filterQualifier) {
    if (filters == null || filters.isEmpty()) {
      return;
    }
    addFiltersToFilterString(String.join(IFilterConstants.FILTER_VALUE_DELIMITER, filters),
        filterQualifier);
  }

  private void addFiltersToFilterString(final String filter, final String filterQualifier) {
    if (StringUtil.isEmpty(filter)) {
      return;
    }
    if (filterBuffer.length() > 0) {
      filterBuffer.append(" ");
    }
    filterBuffer.append(String.format(IFilterConstants.FILTER_VALUES_PATTERN, filterQualifier,
        filter.toLowerCase()));
  }

  private void addTypeFilterByCategory(final String filterQualifier, final String category) {
    switch (category) {
    case IAbapRepositoryFolderNode.CATEGORY_DICTIONARY:
      // Are DDL available in dictionary category?
      if (!AdtTypeUtil.getInstance().isCdsCategoryAvailable(node.getProject())) {
        addFiltersToFilterString(ITadirTypeConstants.DATA_DEFINITION, filterQualifier);
      }
      for (var type : ProjectDependentTypeAvailability.getTypesForProject(node.getProject())) {
        addFiltersToFilterString(type, filterQualifier);
      }

      break;
    case IAbapRepositoryFolderNode.CATEGORY_SOURCE_LIB:
      addFiltersToFilterString(CodeSearchRelevantWbTypesUtil.getSourceCodeLibraryTypeFilters(),
          filterQualifier);
      break;
    case IAbapRepositoryFolderNode.CATEGORY_ACCESS_CONTROL_MGMT:
      addFiltersToFilterString(ITadirTypeConstants.ACCESS_CONTROL, filterQualifier);
      break;
    case IAbapRepositoryFolderNode.CATEGORY_CORE_DATA_SERVICES:
      addFiltersToFilterString(
          Arrays.asList(ITadirTypeConstants.DATA_DEFINITION, ITadirTypeConstants.ACCESS_CONTROL),
          filterQualifier);
      break;
    }
  }

  private void addTypeFilterByType(final String filterQualifier, final String type) {
    switch (type) {
    case IAdtObjectTypeConstants.DATA_DEFINITION:
    case IAdtObjectTypeConstants.ACCESS_CONTROL:
    case IAdtObjectTypeConstants.CLASS:
    case IAdtObjectTypeConstants.INTERFACE:
    case IAdtObjectTypeConstants.FUNCTION_GROUP:
    case IAdtObjectTypeConstants.PROGRAM:
    case IAdtObjectTypeConstants.PROGRAM_INCLUDE:
    case IAdtObjectTypeConstants.SIMPLE_TRANSFORMATION:
      addFiltersToFilterString(type.substring(0, 4), filterQualifier);
      break;
    case IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE:
      addFiltersToFilterString(ITadirTypeConstants.DATABASE_TABLE, filterQualifier);
      break;
    case IAdtObjectTypeConstants.STRUCTURE:
      addFiltersToFilterString(ITadirTypeConstants.STRUCTURE, filterQualifier);
      break;
    }
  }

  private void addTypeFilters(final String filterQualifier) {
    var category = node.getCategory();
    if (!StringUtil.isEmpty(category)) {
      addTypeFilterByCategory(filterQualifier, category);
      return;
    }
    var type = node.getType();
    if (!StringUtil.isEmpty(type)) {
      addTypeFilterByType(filterQualifier, type);
    }
  }
}