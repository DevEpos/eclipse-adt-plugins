package com.devepos.adt.cst.ui.internal.handlers;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.adtobject.AdtObjectFactory;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.projectexplorer.node.IAbapRepositoryFolderNode;
import com.devepos.adt.base.ui.projectexplorer.virtualfolders.IVirtualFolderNode;
import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.ISearchPageListener;
import com.devepos.adt.base.ui.search.SearchPageUtil;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.ui.util.AdtUIUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.ui.internal.TmViewAdapterHelper;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchDialog;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuery;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuerySpecification;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchRelevantWbTypesUtil;
import com.devepos.adt.cst.ui.internal.codesearch.FilterName;
import com.devepos.adt.cst.ui.internal.codesearch.ProjectDependentTypeAvailability;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Handler implementation for code search command
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchHandler extends AbstractHandler implements ISearchPageListener {

  private static final String EXACT_NAME_MODIFIER = "<";
  private static final String FILTER_VALUE_DELIMITER = ",";
  private static final String FILTER_VALUES_PATTERN = "%s:%s";

  private CodeSearchQuery searchQuery;

  private static class AbapRepositoryFolderToQueryConverter {
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

    private void addFiltersToFilterString(final List<String> filters,
        final String filterQualifier) {
      if (filters == null || filters.isEmpty()) {
        return;
      }
      addFiltersToFilterString(String.join(FILTER_VALUE_DELIMITER, filters), filterQualifier);
    }

    private void addFiltersToFilterString(final String filter, final String filterQualifier) {
      if (StringUtil.isEmpty(filter)) {
        return;
      }
      if (filterBuffer.length() > 0) {
        filterBuffer.append(" ");
      }
      filterBuffer
          .append(String.format(FILTER_VALUES_PATTERN, filterQualifier, filter.toLowerCase()));
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
      String category = node.getCategory();
      if (!StringUtil.isEmpty(category)) {
        addTypeFilterByCategory(filterQualifier, category);
        return;
      }
      String type = node.getType();
      if (!StringUtil.isEmpty(type)) {
        addTypeFilterByType(filterQualifier, type);
      }
    }
  }

  private static class AdtObjectSelectionToQueryConverter {
    private final CodeSearchQuerySpecification querySpecs;
    private final List<IAdtObject> adtObjects;
    private List<String> packages;
    private List<String> objectNames;
    private Set<String> transportRequests;
    private Set<String> objectTypes;

    public AdtObjectSelectionToQueryConverter(final List<IAdtObject> adtObjects) {
      this.adtObjects = adtObjects;
      querySpecs = new CodeSearchQuerySpecification();
    }

    public CodeSearchQuery convert() {
      objectNames = new ArrayList<>();
      packages = new ArrayList<>();
      objectTypes = new HashSet<>();
      transportRequests = new HashSet<>();
      IProject project = adtObjects.get(0).getProject();

      collectObjectInformation(project);

      StringBuilder filterString = new StringBuilder();

      querySpecs.setIgnoreCaseCheck(true);
      if (!objectNames.isEmpty()) {
        querySpecs.setObjectNames(String.join(" ", objectNames));
      }
      if (!packages.isEmpty() && objectNames.isEmpty()) {
        filterString
            .append(String.format(FILTER_VALUES_PATTERN, FilterName.PACKAGE.getContentAssistName(),
                String.join(FILTER_VALUE_DELIMITER, packages)));
      }
      if (!objectTypes.isEmpty()) {
        if (filterString.length() > 0) {
          filterString.append(" ");
        }
        filterString.append(
            String.format(FILTER_VALUES_PATTERN, FilterName.OBJECT_TYPE.getContentAssistName(),
                String.join(FILTER_VALUE_DELIMITER, objectTypes)));
      }
      if (!transportRequests.isEmpty()) {
        if (filterString.length() > 0) {
          filterString.append(" ");
        }
        filterString.append(String.format(FILTER_VALUES_PATTERN,
            FilterName.TRANSPORT_REQUEST.getContentAssistName(),
            String.join(FILTER_VALUE_DELIMITER, transportRequests)));
      }
      querySpecs.setObjectScopeFilters(null, filterString.toString());

      if (project != null) {
        querySpecs.setProjectProvider(AbapProjectProviderAccessor
            .getProviderForDestination(DestinationUtil.getDestinationId(project)));
      }
      return new CodeSearchQuery(querySpecs);
    }

    private void collectObjectInformation(final IProject project) {
      var relevantWbTypes = CodeSearchRelevantWbTypesUtil.getRelevantTypesForHandler(project);

      for (IAdtObject adtObj : adtObjects) {
        IAdtObjectReference adtObjRef = adtObj.getReference();
        if (IAdtObjectTypeConstants.PACKAGE.equals(adtObjRef.getType())) {
          if (objectNames.isEmpty()) {
            packages.add(adtObjRef.getName().toLowerCase());
          }
        } else if ("RQRQ".equals(adtObjRef.getType())) {
          transportRequests.add(adtObjRef.getName().toLowerCase());
        } else if (relevantWbTypes.stream().anyMatch(t -> t.equals(adtObjRef.getType()))) {
          collectObjectName(adtObjRef, project);
        }
      }
    }

    private void collectObjectName(final IAdtObjectReference adtObjRef, final IProject project) {
      if (IAdtObjectTypeConstants.STRUCTURE.equals(adtObjRef.getType())) {
        objectTypes.add(ITadirTypeConstants.STRUCTURE.toLowerCase());
      } else if (IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE.equals(adtObjRef.getType())) {
        objectTypes.add(ITadirTypeConstants.DATABASE_TABLE.toLowerCase());
      } else {
        String mainAdtType = adtObjRef.getType().substring(0, 4);
        objectTypes.add(mainAdtType.toLowerCase());
      }

      if (IAdtObjectTypeConstants.FUNCTION_INCLUDE.equals(adtObjRef.getType())
          || IAdtObjectTypeConstants.FUNCTION_MODULE.equals(adtObjRef.getType())) {
        String parentUri = adtObjRef.getParentUri();
        if (parentUri != null) {
          String parentName = URLDecoder.decode(parentUri.substring(parentUri.lastIndexOf("/") + 1),
              Charset.defaultCharset());
          objectNames.add(parentName + EXACT_NAME_MODIFIER);
        }
      } else {
        objectNames.add(adtObjRef.getName().toLowerCase() + EXACT_NAME_MODIFIER);
      }
    }
  }

  private static class VirtualFolderToQueryConverter {
    private static final String YEAR_DATE_PATTERN = "1.%d...12.%d";
    private static final String MONTH_YEAR_DATE_PATTERN = "%d.%d";
    private static final String FULL_DATE_PATTERN = "%s.%d.%d";

    private final IVirtualFolderNode node;

    private final StringBuffer filterBuffer;
    private final CodeSearchQuerySpecification querySpecs;

    public VirtualFolderToQueryConverter(final IVirtualFolderNode node) {
      this.node = node;
      filterBuffer = new StringBuffer();
      querySpecs = new CodeSearchQuerySpecification();
    }

    public CodeSearchQuery convert() {
      addFiltersToFilterString(node.getUserFilters(), FilterName.OWNER.getContentAssistName());
      addFiltersToFilterString(node.getPackageFilters(), FilterName.PACKAGE.getContentAssistName());
      addFiltersToFilterString(node.getApplicationComponentFilters(),
          FilterName.APPLICATION_COMPONENT.getContentAssistName());
      addTypeFilters();
      addCreatedFilters();

      querySpecs.setIgnoreCaseCheck(true);
      querySpecs.setObjectScopeFilters(null, filterBuffer.toString());
      querySpecs.setObjectNames(node.getSearchString());

      return new CodeSearchQuery(querySpecs);
    }

    private void addCreatedFilters() {
      List<String> createdDatePatterns = new ArrayList<>();

      List<String> dateFilters = node.getCreatedDateFilters();
      if (!dateFilters.isEmpty()) {
        for (String date : dateFilters) {
          createdDatePatterns
              .add(String.format(FULL_DATE_PATTERN, Integer.parseInt(date.substring(6, 8)),
                  Integer.parseInt(date.substring(4, 6)), Integer.parseInt(date.substring(0, 4))));
        }
      } else {
        List<Integer> createdYearFilters = node.getCreatedYearFilters();
        List<Integer> createdMonthFilters = node.getCreatedMonthFilters();
        if (createdYearFilters.isEmpty() && createdMonthFilters.isEmpty()) {
          return;
        }

        if (createdMonthFilters.isEmpty()) {
          for (int createdDate : createdYearFilters) {
            createdDatePatterns.add(String.format(YEAR_DATE_PATTERN, createdDate, createdDate));
          }
        } else {
          createdYearFilters = createdYearFilters.isEmpty()
              ? Arrays.asList(LocalDate.now().getYear())
              : createdYearFilters;

          for (int year : createdYearFilters) {
            for (int month : createdMonthFilters) {
              createdDatePatterns.add(String.format(MONTH_YEAR_DATE_PATTERN, month, year));
            }
          }
        }
      }

      addFiltersToFilterString(createdDatePatterns, FilterName.CREATED_DATE.getContentAssistName());
    }

    private void addFiltersToFilterString(final List<String> filters,
        final String filterQualifier) {
      if (filters == null || filters.isEmpty()) {
        return;
      }
      if (filterBuffer.length() > 0) {
        filterBuffer.append(" ");
      }
      filterBuffer.append(String.format(FILTER_VALUES_PATTERN, filterQualifier,
          String.join(FILTER_VALUE_DELIMITER, filters).toLowerCase()));
    }

    private void addTypeFilters() {
      addFiltersToFilterString(CodeSearchRelevantWbTypesUtil.extractValidTypeFilters(
          node.getProject(), node.getTypeFilters()), FilterName.OBJECT_TYPE.getContentAssistName());
    }
  }

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    searchQuery = null;
    ISelection selection = HandlerUtil.getCurrentSelection(event);
    if (selection == null) {
      return null;
    }

    if (selection instanceof IStructuredSelection) {
      IStructuredSelection structSelection = (IStructuredSelection) selection;
      if (structSelection.size() > 1) {
        List<IAdtObject> selectedObjects = null;
        var activePart = HandlerUtil.getActivePart(event);
        // special handling for ADT transport view, as the project is not
        if (TmViewAdapterHelper.isPartTmView(activePart)) {
          selectedObjects = getSelectedTransportObjects((IStructuredSelection) selection,
              activePart);
        } else {
          selectedObjects = AdtUIUtil.getAdtObjectsFromSelection(false, selection);
        }
        createQueryFromAdtObjects(selectedObjects, selection);
      } else {
        Object selectedObject = structSelection.getFirstElement();
        IVirtualFolderNode virtualFolderNode = Adapters.adapt(selectedObject,
            IVirtualFolderNode.class);
        if (virtualFolderNode != null) {
          searchQuery = new VirtualFolderToQueryConverter(virtualFolderNode).convert();
        } else {
          IAbapRepositoryFolderNode repositoryFolder = Adapters.adapt(selectedObject,
              IAbapRepositoryFolderNode.class);
          if (repositoryFolder != null) {
            searchQuery = new AbapRepositoryFolderToQueryConverter(repositoryFolder).convert();
          } else {
            IAdtObject adtObject = Adapters.adapt(selectedObject, IAdtObject.class);
            createQueryFromAdtObjects(adtObject == null ? null : Arrays.asList(adtObject),
                selection);
          }
        }
      }
    } else {
      createQueryFromAdtObjects(AdtUIUtil.getAdtObjectsFromSelection(false, selection), selection);
    }

    if (searchQuery == null) {
      return null;
    }

    SearchPageUtil.addSearchPageOpenListener(this);
    NewSearchUI.openSearchDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
        CodeSearchDialog.PAGE_ID);
    return null;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void pageOpened(final ISearchPage searchPage) {
    if (searchPage instanceof IChangeableSearchPage) {
      ((IChangeableSearchPage) searchPage).setInputFromSearchQuery(searchQuery);
    }
  }

  private List<IAdtObject> getSelectedTransportObjects(final IStructuredSelection selection,
      final IWorkbenchPart activePart) {
    var project = TmViewAdapterHelper.getProjectFromTmView(activePart);
    if (project != null) {
      List<IAdtObject> selectedTranportObjects = new ArrayList<>();
      for (var selObj : selection) {
        var trObject = Adapters.adapt(selObj, IAdtObjectReference.class);
        if (trObject != null) {
          selectedTranportObjects.add(AdtObjectFactory.create(trObject, project));
        }
      }
      return selectedTranportObjects;
    }
    // fallback: maybe the method was renamed or removed or did not return a project
    // for some reason
    return AdtUIUtil.getAdtObjectsFromSelection(false, selection);
  }

  private void createQueryFromAdtObjects(final List<IAdtObject> selectedObjects,
      final ISelection selection) {

    if (selectedObjects == null || selectedObjects.isEmpty()) {
      return;
    }
    searchQuery = new AdtObjectSelectionToQueryConverter(selectedObjects).convert();
    if (selection instanceof ITextSelection) {
      searchQuery.getQuerySpecs().setPatterns(((ITextSelection) selection).getText());
    }
  }

}
