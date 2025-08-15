package com.devepos.adt.cst.ui.internal.codesearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.search.ICodeSearchScopeService;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;

public class ProjectDependentTypeAvailability {
  private static final List<String> EMPTY_LIST = Arrays.asList();
  private static boolean PREFER_CLIENT_SEARCH;
  private static final Map<IProject, List<String>> PROJECT_DEPENDENT_TYPES = new HashMap<>();

  static {
    var prefStore = CodeSearchUIPlugin.getDefault().getPreferenceStore();
    PREFER_CLIENT_SEARCH = prefStore.getBoolean(ICodeSearchPrefs.PREFER_CLIENT_BASED_SEARCH);
    prefStore.addPropertyChangeListener(l -> {
      if (ICodeSearchPrefs.PREFER_CLIENT_BASED_SEARCH.equals(l.getProperty())) {
        PREFER_CLIENT_SEARCH = (boolean) l.getNewValue();
        // clear the cache
        PROJECT_DEPENDENT_TYPES.clear();
      }
    });
  }

  public static List<String> getTypesForProject(final IProject project) {
    if (project == null) {
      return EMPTY_LIST;
    }
    return getTypesFromCache(project);
  }

  public static List<String> getAdtTypesForProject(final IProject project) {
    var types = getTypesForProject(project);
    return types.stream().map(t -> {
      if (t.equals(ITadirTypeConstants.DATABASE_TABLE)) {
        return IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE;
      }
      if (t.equals(ITadirTypeConstants.STRUCTURE)) {
        return IAdtObjectTypeConstants.STRUCTURE;
      }
      if (t.equals(ITadirTypeConstants.SERVICE_DEFINITION)) {
        return IAdtObjectTypeConstants.SERVICE_DEFINITION;
      }
      return t;
    }).toList();
  }

  public static boolean isTypeAvailable(final String type, final List<String> typesForProject) {
    if (!ITadirTypeConstants.DATABASE_TABLE.equals(type)
        && !ITadirTypeConstants.STRUCTURE.equals(type)
        && !ITadirTypeConstants.SERVICE_DEFINITION.equals(type)) {
      return true;
    }
    return typesForProject.contains(type);
  }

  private static List<String> getTypesFromCache(final IProject project) {
    var types = PROJECT_DEPENDENT_TYPES.get(project);
    if (types == null) {
      types = determineAvailableTypes(project);
      PROJECT_DEPENDENT_TYPES.put(project, types);
    }
    return types;
  }

  private static List<String> determineAvailableTypes(final IProject project) {
    List<String> types = new ArrayList<>();
    var scopeService = CodeSearchFactory.getSearchScopeService(project);
    IAdtPluginFeatures searchScopeFeatures = null;
    if (ProjectUtil.isCloudProject(project)) {
      searchScopeFeatures = scopeService.getClientFeatures();
    } else {
      if (PREFER_CLIENT_SEARCH) {
        searchScopeFeatures = scopeService.getClientFeatures();
        if (searchScopeFeatures == null) {
          searchScopeFeatures = scopeService.getBackendFeatures();
        }
      } else {
        searchScopeFeatures = scopeService.getBackendFeatures();
        if (searchScopeFeatures == null) {
          searchScopeFeatures = scopeService.getClientFeatures();
        }
      }
    }

    if (searchScopeFeatures.isFeatureEnabled(ICodeSearchScopeService.DB_TABLE_TYPE_FEATURE_ID)) {
      types.add(ITadirTypeConstants.DATABASE_TABLE);
    }

    if (searchScopeFeatures.isFeatureEnabled(ICodeSearchScopeService.STRUCTURE_TYPE_FEATURE_ID)) {
      types.add(ITadirTypeConstants.STRUCTURE);
    }

    if (searchScopeFeatures.isFeatureEnabled(ICodeSearchScopeService.SERVICE_DEF_TYPE_FEATURE_ID)) {
      types.add(ITadirTypeConstants.SERVICE_DEFINITION);
    }

    return types;
  }

}
