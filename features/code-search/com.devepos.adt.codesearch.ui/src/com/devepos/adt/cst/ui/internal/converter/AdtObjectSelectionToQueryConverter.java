package com.devepos.adt.cst.ui.internal.converter;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.cst.ui.internal.IFilterConstants;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuery;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuerySpecification;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchRelevantWbTypesUtil;
import com.devepos.adt.cst.ui.internal.codesearch.FilterName;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class AdtObjectSelectionToQueryConverter {
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
    var project = adtObjects.get(0).getProject();

    collectObjectInformation(project);

    var filterString = new StringBuilder();

    querySpecs.setIgnoreCaseCheck(true);
    if (!objectNames.isEmpty()) {
      querySpecs.setObjectNames(String.join(" ", objectNames));
    }
    if (!packages.isEmpty() && objectNames.isEmpty()) {
      filterString.append(String.format(IFilterConstants.FILTER_VALUES_PATTERN,
          FilterName.PACKAGE.getContentAssistName(),
          String.join(IFilterConstants.FILTER_VALUE_DELIMITER, packages)));
    }
    if (!objectTypes.isEmpty()) {
      if (filterString.length() > 0) {
        filterString.append(" ");
      }
      filterString.append(String.format(IFilterConstants.FILTER_VALUES_PATTERN,
          FilterName.OBJECT_TYPE.getContentAssistName(),
          String.join(IFilterConstants.FILTER_VALUE_DELIMITER, objectTypes)));
    }
    if (!transportRequests.isEmpty()) {
      if (filterString.length() > 0) {
        filterString.append(" ");
      }
      filterString.append(String.format(IFilterConstants.FILTER_VALUES_PATTERN,
          FilterName.TRANSPORT_REQUEST.getContentAssistName(),
          String.join(IFilterConstants.FILTER_VALUE_DELIMITER, transportRequests)));
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
      var adtObjRef = adtObj.getReference();
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
      var mainAdtType = adtObjRef.getType().substring(0, 4);
      objectTypes.add(mainAdtType.toLowerCase());
    }

    if (IAdtObjectTypeConstants.FUNCTION_INCLUDE.equals(adtObjRef.getType())
        || IAdtObjectTypeConstants.FUNCTION_MODULE.equals(adtObjRef.getType())) {
      var parentUri = adtObjRef.getParentUri();
      if (parentUri != null) {
        var parentName = URLDecoder.decode(parentUri.substring(parentUri.lastIndexOf("/") + 1),
            Charset.defaultCharset());
        objectNames.add(parentName + IFilterConstants.EXACT_NAME_MODIFIER);
      }
    } else {
      objectNames.add(adtObjRef.getName().toLowerCase() + IFilterConstants.EXACT_NAME_MODIFIER);
    }
  }
}