package com.devepos.adt.atm.ui.internal.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.StyledString;

import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.sap.adt.project.IProjectProvider;

public class AdtObjectUtil {

  /**
   * Appends type description to the given styled string
   *
   * @param objRefNode Object reference Node
   * @param text       styled string for display in a Viewer
   */
  public static void appendAdtTypeDescription(final IAdtObjectReferenceNode objRefNode,
      final StyledString text) {
    var type = objRefNode.getAdtObjectType();
    if (type == null) {
      return;
    }
    var typeLabel = getTypeDescription(type);
    if (typeLabel == null) {
      var projectProvider = objRefNode.getAdapter(IProjectProvider.class);
      if (projectProvider != null) {
        typeLabel = getTypeDescriptionByProject(type, projectProvider.getProject());
      }
    }
    if (typeLabel != null) {
      text.append(String.format(" (%s)", typeLabel), StyledString.QUALIFIER_STYLER);
    }
  }

  /**
   * Retrieves type description for the given ADT type
   * 
   * @param type    type to retrieve description for
   * @param project project for getting project dependent type description as fallback
   */
  public static String getTypeDescription(String type) {
    if (type == null) {
      return null;
    }
    AdtTypeUtil typeUtil = AdtTypeUtil.getInstance();
    String typeLabel = null;
    if (typeUtil.isLocalClassType(type)) {
      typeLabel = Messages.TypeLabels_LocalClass_xlbl;
    } else if (typeUtil.isLocalInterfaceType(type)) {
      typeLabel = Messages.TypeLabels_LocalInterface_xlbl;
    } else {
      if (type.equals(IAdtObjectTypeConstants.DATA_DEFINITION)) {
        type = IAdtObjectTypeConstants.CDS_VIEW;
      }
      typeLabel = typeUtil.getTypeDescription(type);
    }
    return typeLabel;
  }

  /**
   * Retrieves type description for the given ADT type by using the given project to access the
   * project type registry.
   * 
   * @param type    type to retrieve description for
   * @param project project for getting project dependent type description
   */
  public static String getTypeDescriptionByProject(String type, IProject project) {
    if (project == null) {
      return null;
    }
    var typeUtil = AdtTypeUtil.getInstance();
    var typeLabel = typeUtil.getTypeDescriptionByProject(type, project);
    if (typeLabel == null) {
      // finally try to read the type of the TADIR type
      typeLabel = typeUtil.getTypeDescriptionByProject(type.substring(0, 4), project);
    }
    return typeLabel;
  }
}
