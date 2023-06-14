package com.devepos.adt.callhierarchy.ui.internal;

import org.eclipse.jface.viewers.StyledString;

/**
 * Type of the hierarchy viewer in the Call Hierarchy View
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public enum HierarchyViewerType {
  /**
   * Simple tree which used {@link StyledString} to differentiate the different values
   */
  TREE("Show as Tree", "Tree"),
  /**
   * Tree Table to better separate different hierarchy entry values
   */
  TREE_TABLE("Show as Tree Table", "Tree Table");

  private String actionLabel;
  private String prefLabel;

  HierarchyViewerType(String actionLabel, String prefLabel) {
    this.actionLabel = actionLabel;
    this.prefLabel = prefLabel;
  }

  public String getActionLabel() {
    return actionLabel;
  }

  public String getPrefLabel() {
    return prefLabel;
  }

}
