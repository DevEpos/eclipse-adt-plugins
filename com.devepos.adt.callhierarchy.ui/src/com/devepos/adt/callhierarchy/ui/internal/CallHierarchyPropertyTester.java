package com.devepos.adt.callhierarchy.ui.internal;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.callhierarchy.backend.CallHierarchyServiceFactory;

public class CallHierarchyPropertyTester extends PropertyTester {
  private static final String IS_CALL_HIERARCHY_AVAILABLE = "isCallHierarchyAvailable";
  private static final String IS_OBJECT_SEARCHABLE_PROP = "isObjectRelevant";

  private static final List<String> RELEVANT_TYPES = Arrays.asList(IAdtObjectTypeConstants.CLASS,
      IAdtObjectTypeConstants.CLASS_INCLUDE, IAdtObjectTypeConstants.INTERFACE,
      IAdtObjectTypeConstants.FUNCTION_GROUP, IAdtObjectTypeConstants.FUNCTION_INCLUDE,
      IAdtObjectTypeConstants.FUNCTION_MODULE, IAdtObjectTypeConstants.PROGRAM,
      IAdtObjectTypeConstants.PROGRAM_INCLUDE);

  public CallHierarchyPropertyTester() {
  }

  @Override
  public boolean test(final Object receiver, final String property, final Object[] args,
      final Object expectedValue) {
    if (IS_CALL_HIERARCHY_AVAILABLE.equals(property)) {
      return isCallHierarchyAvailable(receiver);
    }
    if (IS_OBJECT_SEARCHABLE_PROP.equals(property)) {
      if (!(receiver instanceof IAdtObject)) {
        return false;
      }
      return isObjectRelevant((IAdtObject) receiver);
    }
    return false;
  }

  private boolean isCallHierarchyAvailable(final Object receiver) {
    IProject project = null;
    if (receiver instanceof IAdtObject) {
      project = ((IAdtObject) receiver).getProject();
      // } else if (receiver instanceof IVirtualFolderNode) {
      // project = ((IVirtualFolderNode) receiver).getProject();
    }

    return project != null ? CallHierarchyServiceFactory.getHierarchyService()
        .testCallHierarchyFeatureAvailability(project)
        .isOK() : false;
  }

  private boolean isObjectRelevant(final IAdtObject adtObj) {
    String adtType = adtObj.getReference().getType();
    if (adtType == null) {
      return false;
    }
    return RELEVANT_TYPES.stream().anyMatch(type -> type.equalsIgnoreCase(adtType));
  }

}
