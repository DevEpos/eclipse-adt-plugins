package com.devepos.adt.cst.ui.internal.codesearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;

public class ProjectDependentTypeAvailability {
  private static final String DB_TABLE_TYPE_FEATURE_ID = "parameters.type.dbTable";
  private static final String STRUCTURE_TYPE_FEATURE_ID = "parameters.type.structure";

  private static final QualifiedName TABLE_TYPES_SESSION_PROP = new QualifiedName(
      CodeSearchUIPlugin.PLUGIN_ID, "taggedObjectTrees"); //$NON-NLS-1$
  private static final List<String> EMPTY_LIST = Arrays.asList();

  public static List<String> getTypesForProject(final IProject project) {
    if (project == null) {
      return EMPTY_LIST;
    }
    return getTypesFromSessionVar(project);
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
      return t;
    }).collect(Collectors.toList());
  }

  public static boolean isStructureTypeAvailable(final IProject project) {
    if (project == null) {
      return false;
    }
    return getTypesFromSessionVar(project).contains(ITadirTypeConstants.STRUCTURE);
  }

  public static boolean isDbTableTypeAvailable(final IProject project) {
    if (project == null) {
      return false;
    }
    return getTypesFromSessionVar(project).contains(ITadirTypeConstants.DATABASE_TABLE);
  }

  public static boolean isTypeAvailable(final String type, final List<String> typesForProject) {
    if (!ITadirTypeConstants.DATABASE_TABLE.equals(type)
        && !ITadirTypeConstants.STRUCTURE.equals(type)) {
      return true;
    }
    return typesForProject.contains(type);
  }

  @SuppressWarnings("unchecked")
  private static List<String> getTypesFromSessionVar(final IProject project) {
    try {
      var typesProperty = project.getSessionProperty(TABLE_TYPES_SESSION_PROP);
      if (!(typesProperty instanceof List<?>)) {
        typesProperty = determineAvailableTypes(project);
        project.setSessionProperty(TABLE_TYPES_SESSION_PROP, typesProperty);
      }

      return (List<String>) typesProperty;
    } catch (CoreException e) {
      e.printStackTrace();
    }

    return null;
  }

  private static List<String> determineAvailableTypes(final IProject project) {
    List<String> types = new ArrayList<>();
    var searchScopeFeatures = CodeSearchFactory.getSearchScopeService(project)
        .getFeaturesByProject();

    if (searchScopeFeatures.isFeatureEnabled(DB_TABLE_TYPE_FEATURE_ID)) {
      types.add(ITadirTypeConstants.DATABASE_TABLE);
    }

    if (searchScopeFeatures.isFeatureEnabled(STRUCTURE_TYPE_FEATURE_ID)) {
      types.add(ITadirTypeConstants.STRUCTURE);
    }

    return types;
  }

}
