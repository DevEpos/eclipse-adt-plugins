package com.devepos.adt.base.ui.tree;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.util.IPropertyBag;

/**
 * Base Tree node which holds some general information about how a specific node
 * shall be displayed in the tree.<br>
 * e.g. <br>
 * <ul>
 * <li>Which Image should be shown</li>
 * </ul>
 *
 * @author stockbal
 */
public interface ITreeNode extends IPropertyBag, IAdaptable {
  /**
   * Property key to hold destination id to ABAP project
   */
  String PROP_KEY__ABAP_PROJECT_DESTINATION = "ABAP_PROJECT_DESTINATION";

  /**
   * @return the description for the node
   */
  String getDescription();

  /**
   * @return the display name of the node
   */
  String getDisplayName();

  /**
   * @return the image id of the node
   */
  Image getImage();

  /**
   * @return the internal name of the node
   */
  String getName();

  /**
   * Retrieves the arbitrary object of the node that was set with {@link #setNodeValue(Object)}
   *
   * @return the arbitrary object of the node or <code>null</code>
   */
  Object getNodeValue();

  /**
   * @return the parent node of this node
   */
  ICollectionTreeNode getParent();

  /**
   * Finds and returns the root node of this tree node. The root node is a node
   * which has no parent node. If this node has no parent than it automatically is
   * the root node
   *
   * @return
   */
  ITreeNode getRoot();

  /**
   * Sets the description of the new
   *
   * @param description
   */
  void setDescription(String description);

  /**
   * Sets the display name of the node
   *
   * @param displayName
   */
  void setDisplayName(String displayName);

  /**
   * Sets the name of the node
   *
   * @param name
   */
  void setName(String name);

  /**
   * Sets arbitrary object which can be retrieved via
   * {@link IAdaptable#getAdapter(Class)}
   *
   * @param value an arbitrary object value for the node
   */
  void setNodeValue(Object value);

  /**
   * Sets the parent of this node
   *
   * @param parent the parent node
   */
  void setParent(ICollectionTreeNode parent);

}
