package com.devepos.adt.base.ui.internal.adtelementinfo;

import java.util.Set;

import org.eclipse.jface.viewers.IStructuredSelection;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.destinations.IDestinationProvider;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.util.SelectionUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class AdtElementInfoContextBuilder {
  private IStructuredSelection selection;

  /**
   * Set of ADT sub types that require manual building of the object reference to be ready for
   * Element Information
   * 
   * e.g.:
   * <ul>
   * <li>{@code CL_CLASS.METHOD}</li>
   * <li>{@code I_SomeView.Field1}</li>
   * </ul>
   */
  private static Set<String> relevantSubTypes = Set.of(
      IAdtObjectTypeConstants.METHOD_IMPLEMENTATION, IAdtObjectTypeConstants.INTERFACE_METHOD,
      IAdtObjectTypeConstants.CDS_VIEW_FIELD_TYPE, IAdtObjectTypeConstants.TABLE_FIELD_TYPE);

  public static AdtElementInfoContext buildFrom(final IStructuredSelection selection) {
    var builder = new AdtElementInfoContextBuilder();
    builder.selection = selection;
    return builder.build();
  }

  public static AdtElementInfoContext buildFromCurrentSelection() {
    var builder = new AdtElementInfoContextBuilder();
    return builder.build();
  }

  private AdtElementInfoContextBuilder() {
  }

  private AdtElementInfoContext build() {
    var selectedNode = getSelectedNode();
    if (selectedNode == null) {
      return null;
    }

    if (selectedNode instanceof IAdtObjectReferenceNode) {
      var project = ProjectUtil.adaptAsProject(selectedNode);
      if (project == null) {
        return null;
      }
      var adtObjRef = getObjectRefForElementInfo((IAdtObjectReferenceNode) selectedNode);

      if (adtObjRef != null) {
        return new AdtElementInfoContext(adtObjRef, project);
      }
    } else if (selectedNode instanceof ITreeNode) {
      var possibleObjectRef = selectedNode.getAdapter(IAdtObjectReference.class);
      if (possibleObjectRef != null) {
        var project = ProjectUtil.adaptAsProject(possibleObjectRef);
        if (project != null) {
          return new AdtElementInfoContext(possibleObjectRef, project);
        }
      }
    }
    return null;
  }

  private IAdtObjectReference createSubTypeObjRef(final IAdtObjectReferenceNode subTypeNode,
      final IAdtObjectReference objRef) {

    var parent = subTypeNode.getParent();
    if (parent == null || !(parent instanceof IAdtObjectReferenceNode)) {
      return null;
    }
    var parentObjRef = ((IAdtObjectReferenceNode) parent).getObjectReference();
    if (parentObjRef == null) {
      return null;
    }

    return AdtObjectReferenceModelFactory.createReference(
        objRef instanceof IDestinationProvider ? ((IDestinationProvider) objRef).getDestinationId()
            : null,
        parentObjRef.getName() + "." + objRef.getName(), objRef.getType(), objRef.getUri());
  }

  private IAdtObjectReference getObjectRefForElementInfo(final IAdtObjectReferenceNode objRefNode) {
    var objRef = objRefNode.getObjectReference();
    if (relevantSubTypes.contains(objRef.getType())) {
      return createSubTypeObjRef(objRefNode, objRef);
    }
    return objRef;
  }

  private ITreeNode getSelectedNode() {
    if (selection == null) {
      var currentSelection = SelectionUtil.getSelection();

      if (!(currentSelection instanceof IStructuredSelection)) {
        return null;
      }
      selection = (IStructuredSelection) currentSelection;
    }

    if (selection == null) {
      return null;
    }

    var structSel = selection;
    if (structSel.size() == 1) {
      var selObj = structSel.getFirstElement();
      return selObj instanceof ITreeNode ? (ITreeNode) selObj : null;
    }
    return null;
  }

}
