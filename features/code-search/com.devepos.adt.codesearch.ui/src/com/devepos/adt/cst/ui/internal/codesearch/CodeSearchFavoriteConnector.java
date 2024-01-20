package com.devepos.adt.cst.ui.internal.codesearch;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.project.AbapProjectProxy;
import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.ISearchPageListener;
import com.devepos.adt.base.ui.search.SearchPageUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.searchfavorites.ISearchFavoriteConnector;
import com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IIntAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.ILongStringAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesFactory;
import com.devepos.adt.searchfavorites.model.searchfavorites.IStringAttribute;

public class CodeSearchFavoriteConnector implements ISearchFavoriteConnector, ISearchPageListener {
  private static final String SCOPE_FILTERS_STRING = "scopeFiltersString";
  private static final String SCOPE_FILTERS = "scopeFilters";
  private static final String EXTENSION_FILTERS = "extensionFilters";
  private static final String OBJECT_NAMES = "objectNames";
  private static final String QUERY_INPUT = "queryInput";
  private static final String CLASS_INCL_FLAGS = "classIncludeFlags";
  private static final String FUGR_INCL_FLAGS = "fugrIncludeFlags";
  private static final String CLASS_INCL_FLAGS_ALL = "classIncludeAll";
  private static final String FUGR_INCL_FLAGS_ALL = "fugrIncludeAll";

  private static final String IGNORE_CASE_CHECK = "ignoreCaseCheck";
  private static final String IGNORE_COMMENT_LINES = "ignoreCommentLines";
  private static final String MATCH_ALL_PATTERNS = "matchAllPattners";
  private static final String SEQUENTIAL_MATCHING = "sequentialMatching";
  private static final String MULTI_LINE_SEARCH = "multilineSearch";
  private static final String EXPAND_PROG_INCLUDES = "expandProgIncludes";
  private static final String SINGLE_PATTERN = "singlePattern";
  private static final String USE_REGEX = "useRegex";

  private CodeSearchQuery currentQuery;

  private static CodeSearchQuerySpecification createQuerySpecsFromFavorite(
      final ISearchFavorite favorite) {
    final var specs = new CodeSearchQuerySpecification();
    for (var favAttribute : favorite.getAttributes()) {
      switch (favAttribute.getName()) {
      case IGNORE_CASE_CHECK:
        specs.setIgnoreCaseCheck(((IBooleanAttribute) favAttribute).isValue());
        break;
      case IGNORE_COMMENT_LINES:
        specs.setIgnoreCaseCheck(((IBooleanAttribute) favAttribute).isValue());
        break;
      case MATCH_ALL_PATTERNS:
        specs.setMatchAllPatterns(((IBooleanAttribute) favAttribute).isValue());
        break;
      case SEQUENTIAL_MATCHING:
        specs.setSequentialMatching(((IBooleanAttribute) favAttribute).isValue());
        break;
      case MULTI_LINE_SEARCH:
        specs.setMultilineSearchOption(((IBooleanAttribute) favAttribute).isValue());
        break;
      case EXPAND_PROG_INCLUDES:
        specs.setExpandProgramIncludes(((IBooleanAttribute) favAttribute).isValue());
        break;
      case SINGLE_PATTERN:
        specs.setSinglePattern(((IBooleanAttribute) favAttribute).isValue());
        break;
      case USE_REGEX:
        specs.setUseRegExp(((IBooleanAttribute) favAttribute).isValue());
        break;
      case QUERY_INPUT:
        specs.setPatterns(((ILongStringAttribute) favAttribute).getValue());
        break;
      case OBJECT_NAMES:
        specs.setObjectNames(((IStringAttribute) favAttribute).getValue());
        break;
      case CLASS_INCL_FLAGS:
        specs.getClassIncludesParam().setIncludeFlags(((IIntAttribute) favAttribute).getValue());
        break;
      case CLASS_INCL_FLAGS_ALL:
        specs.getClassIncludesParam().setAllIncludes(((IBooleanAttribute) favAttribute).isValue());
        break;
      case FUGR_INCL_FLAGS:
        specs.getFugrIncludesParam().setIncludeFlags(((IIntAttribute) favAttribute).getValue());
        break;
      case FUGR_INCL_FLAGS_ALL:
        specs.getFugrIncludesParam().setAllIncludes(((IBooleanAttribute) favAttribute).isValue());
        break;
      }
    }
    specs.setObjectScopeFilters(
        favorite.getMapAttribute(SCOPE_FILTERS)
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue)),
        favorite.getAttribute(SCOPE_FILTERS_STRING, ""));
    favorite.getMapAttribute(EXTENSION_FILTERS)
        .stream()
        .forEach(f -> specs.getExtensionObjectScopeFilters().put(f.getKey(), f.getValue()));

    specs.setDestinationId(favorite.getDestinationId());
    return specs;
  }

  @Override
  public void openFavoriteInSearchDialog(final ISearchFavorite favorite) {
    final var specs = createQuerySpecsFromFavorite(favorite);
    specs.setProjectProvider(new AbapProjectProxy(null));

    SearchPageUtil.addSearchPageOpenListener(this);
    currentQuery = new CodeSearchQuery(specs);
    NewSearchUI.openSearchDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
        CodeSearchDialog.PAGE_ID);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void pageOpened(final ISearchPage searchPage) {
    if (currentQuery != null && searchPage instanceof IChangeableSearchPage) {
      ((IChangeableSearchPage) searchPage).setInputFromSearchQuery(currentQuery);
    }
    currentQuery = null;
  }

  @Override
  public void populateFavoriteFromQuery(final List<IBaseAttribute> attributes,
      final ISearchQuery searchQuery) {
    if (!(searchQuery instanceof CodeSearchQuery)) {
      return;
    }

    var codeSearchQuery = (CodeSearchQuery) searchQuery;
    var querySpecs = codeSearchQuery.getQuerySpecs();

    addFavAttribute(attributes, QUERY_INPUT, querySpecs.getPatterns(), true);
    addFavAttribute(attributes, SCOPE_FILTERS_STRING, querySpecs.getObjectScopeFiltersString());
    addFavAttribute(attributes, SCOPE_FILTERS,
        querySpecs.getObjectScopeFilters()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Entry::getKey, f -> (String) f.getValue())));
    addFavAttribute(attributes, EXTENSION_FILTERS,
        querySpecs.getExtensionObjectScopeFilters()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Entry::getKey, f -> (String) f.getValue())));
    addFavAttribute(attributes, OBJECT_NAMES, querySpecs.getObjectNames());

    var classIncludes = querySpecs.getClassIncludesParam();
    addFavAttribute(attributes, CLASS_INCL_FLAGS, classIncludes.getIncludeFlags());
    addFavAttribute(attributes, CLASS_INCL_FLAGS_ALL, classIncludes.isAllIncludes(), true);

    var fugrIncludes = querySpecs.getFugrIncludesParam();
    addFavAttribute(attributes, FUGR_INCL_FLAGS, fugrIncludes.getIncludeFlags());
    addFavAttribute(attributes, FUGR_INCL_FLAGS_ALL, fugrIncludes.isAllIncludes(), true);

    addFavAttribute(attributes, IGNORE_CASE_CHECK, querySpecs.isIgnoreCaseCheck());
    addFavAttribute(attributes, IGNORE_COMMENT_LINES, querySpecs.isIgnoreCommentLines());
    addFavAttribute(attributes, MATCH_ALL_PATTERNS, querySpecs.isMatchAllPatterns());
    addFavAttribute(attributes, SEQUENTIAL_MATCHING, querySpecs.isSequentialMatching());
    addFavAttribute(attributes, MULTI_LINE_SEARCH, querySpecs.isMultilineSearchOption());
    addFavAttribute(attributes, EXPAND_PROG_INCLUDES, querySpecs.isExpandProgramIncludes());
    addFavAttribute(attributes, SINGLE_PATTERN, querySpecs.isSinglePattern());
    addFavAttribute(attributes, USE_REGEX, querySpecs.isUseRegExp());
  }

  @Override
  public void runSearchFromFavorite(final ISearchFavorite favorite) {
    IAbapProjectProvider projectProvider = null;
    var destination = favorite.getDestinationId();
    if (destination == null) {
      projectProvider = AbapProjectProviderAccessor.getProviderFromSelection();
    } else {
      projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destination);
    }
    if (projectProvider == null || !projectProvider.hasProject()) {
      if (destination == null) {
        MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
            AdtBaseUIResources.getString(IAdtBaseStrings.Dialog_Error_xtit),
            MessageFormat.format("No Project found for destination ''{0}''", destination));
      }
      openFavoriteInSearchDialog(favorite);
    } else {
      final var specs = createQuerySpecsFromFavorite(favorite);
      specs.setProjectProvider(projectProvider);

      if (!projectProvider.ensureLoggedOn()) {
        return;
      }

      NewSearchUI.runQueryInBackground(new CodeSearchQuery(specs));
    }

  }

  private void addFavAttribute(final List<IBaseAttribute> attributes, final String name,
      final boolean value) {
    addFavAttribute(attributes, name, value, false);
  }

  private void addFavAttribute(final List<IBaseAttribute> attributes, final String name,
      final boolean value, final boolean forceSet) {
    if (!value && !forceSet) {
      return;
    }
    var booleanAttribute = ISearchFavoritesFactory.eINSTANCE.createBooleanAttribute();
    booleanAttribute.setName(name);
    booleanAttribute.setValue(value);
    attributes.add(booleanAttribute);
  }

  private void addFavAttribute(final List<IBaseAttribute> attributes, final String name,
      final int value) {
    if (value <= 0) {
      return;
    }
    var intAttribute = ISearchFavoritesFactory.eINSTANCE.createIntAttribute();
    intAttribute.setName(name);
    intAttribute.setValue(value);
    attributes.add(intAttribute);
  }

  private void addFavAttribute(final List<IBaseAttribute> attributes, final String name,
      final Map<String, String> entries) {
    if (entries == null || entries.isEmpty()) {
      return;
    }
    var mapAttribute = ISearchFavoritesFactory.eINSTANCE.createMapAttribute();
    mapAttribute.setName(name);
    mapAttribute.getEntries().putAll(entries);
    attributes.add(mapAttribute);
  }

  private void addFavAttribute(final List<IBaseAttribute> attributes, final String name,
      final String value) {
    addFavAttribute(attributes, name, value, false);
  }

  private void addFavAttribute(final List<IBaseAttribute> attributes, final String name,
      final String value, final boolean longValue) {
    if (StringUtil.isEmpty(value)) {
      return;
    }
    if (longValue) {
      var stringAttribute = ISearchFavoritesFactory.eINSTANCE.createLongStringAttribute();
      stringAttribute.setName(name);
      stringAttribute.setValue(value);
      attributes.add(stringAttribute);
    } else {
      var stringAttribute = ISearchFavoritesFactory.eINSTANCE.createStringAttribute();
      stringAttribute.setName(name);
      stringAttribute.setValue(value);
      attributes.add(stringAttribute);
    }
  }
}
