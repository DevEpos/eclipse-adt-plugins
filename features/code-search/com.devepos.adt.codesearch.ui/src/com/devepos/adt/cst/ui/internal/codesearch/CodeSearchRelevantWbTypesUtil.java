package com.devepos.adt.cst.ui.internal.codesearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;

public class CodeSearchRelevantWbTypesUtil {

  private static List<String> RELEVANT_TYPES;
  private static List<String> POSSIBLE_TYPE_FILTERS;
  private static List<String> SRC_CODE_TYPE_FILTERS;
  private static List<String> SEARCHABLE_ADT_TYPES;

  /**
   * Extracts valid type filters by checking against the valid filters for the Code Search
   *
   * @param types list of types
   * @return a valid List of type filters
   */
  public static List<String> extractValidTypeFilters(final IProject project,
      final List<String> types) {
    if (types == null || types.isEmpty()) {
      return null;
    }
    List<String> validTypes = new ArrayList<>();
    List<String> possibleTypes = CodeSearchRelevantWbTypesUtil
        .getPossibleValuesForTypeFilter(project);

    for (String filter : types) {
      if (possibleTypes.stream().anyMatch(f -> f.equalsIgnoreCase(filter))) {
        if (filter.equals(ITadirTypeConstants.EXECUTABLE_REPORT)
            || filter.equals(ITadirTypeConstants.INCLUDE)) {
          validTypes.add(ITadirTypeConstants.PROGRAM);
        } else {
          validTypes.add(filter);
        }
      }
    }
    return validTypes;
  }

  /**
   * Returns a list of types of ADT objects that can be searched by the ABAP Code search
   *
   * @return list of ADT types
   */
  public static List<String> getCodeSearchableAdtTypes(final IProject project) {
    if (SEARCHABLE_ADT_TYPES == null) {
      SEARCHABLE_ADT_TYPES = Arrays.asList(IAdtObjectTypeConstants.INTERFACE,
          IAdtObjectTypeConstants.CLASS, IAdtObjectTypeConstants.PROGRAM,
          IAdtObjectTypeConstants.PROGRAM_INCLUDE, IAdtObjectTypeConstants.TYPE_GROUP,
          IAdtObjectTypeConstants.DATA_DEFINITION, IAdtObjectTypeConstants.METADATA_EXTENSION,
          IAdtObjectTypeConstants.ACCESS_CONTROL, IAdtObjectTypeConstants.BEHAVIOR_DEFINITION,
          IAdtObjectTypeConstants.SIMPLE_TRANSFORMATION, IAdtObjectTypeConstants.FUNCTION_GROUP);
    }

    var types = new ArrayList<>(SEARCHABLE_ADT_TYPES);
    types.addAll(ProjectDependentTypeAvailability.getAdtTypesForProject(project));

    return types;
  }

  /**
   * Retrieves list of all possible values for the "type" filter in the Code Search Dialog
   *
   * @return list of possible filter values
   */
  public static List<String> getPossibleValuesForTypeFilter(final IProject project) {
    if (POSSIBLE_TYPE_FILTERS == null) {
      POSSIBLE_TYPE_FILTERS = Arrays.asList(ITadirTypeConstants.CLASS,
          ITadirTypeConstants.INTERFACE, ITadirTypeConstants.PROGRAM,
          ITadirTypeConstants.EXECUTABLE_REPORT, ITadirTypeConstants.INCLUDE,
          ITadirTypeConstants.TYPE_GROUP, ITadirTypeConstants.DATA_DEFINITION,
          ITadirTypeConstants.METADATA_EXTENSION, ITadirTypeConstants.ACCESS_CONTROL,
          ITadirTypeConstants.BEHAVIOR_DEFINITION, ITadirTypeConstants.SIMPLE_TRANSFORMATION,
          ITadirTypeConstants.FUNCTION_GROUP);
    }

    var types = new ArrayList<>(POSSIBLE_TYPE_FILTERS);
    types.addAll(ProjectDependentTypeAvailability.getTypesForProject(project));

    return types;
  }

  /**
   * Retrieves list of ADT workbench types that are relevant for the Code Search Handler
   *
   * @return list of ADT workbench types
   */
  public static List<String> getRelevantTypesForHandler(final IProject project) {
    if (RELEVANT_TYPES == null) {
      RELEVANT_TYPES = Arrays.asList(IAdtObjectTypeConstants.CLASS,
          IAdtObjectTypeConstants.CLASS_INCLUDE, IAdtObjectTypeConstants.INTERFACE,
          IAdtObjectTypeConstants.TYPE_GROUP, IAdtObjectTypeConstants.FUNCTION_GROUP,
          IAdtObjectTypeConstants.FUNCTION_INCLUDE, IAdtObjectTypeConstants.FUNCTION_MODULE,
          IAdtObjectTypeConstants.SIMPLE_TRANSFORMATION, IAdtObjectTypeConstants.PROGRAM,
          IAdtObjectTypeConstants.PROGRAM_INCLUDE, IAdtObjectTypeConstants.BEHAVIOR_DEFINITION,
          IAdtObjectTypeConstants.ACCESS_CONTROL, IAdtObjectTypeConstants.DATA_DEFINITION,
          IAdtObjectTypeConstants.METADATA_EXTENSION);
    }

    var types = new ArrayList<>(RELEVANT_TYPES);
    types.addAll(ProjectDependentTypeAvailability.getAdtTypesForProject(project));

    return types;
  }

  /**
   * Retrieves list of all types for category "Source Code Library"
   *
   * @return list of types
   */
  public static List<String> getSourceCodeLibraryTypeFilters() {
    if (SRC_CODE_TYPE_FILTERS == null) {
      SRC_CODE_TYPE_FILTERS = Arrays.asList(ITadirTypeConstants.CLASS,
          ITadirTypeConstants.INTERFACE, ITadirTypeConstants.PROGRAM,
          ITadirTypeConstants.FUNCTION_GROUP);
    }
    return SRC_CODE_TYPE_FILTERS;
  }
}
