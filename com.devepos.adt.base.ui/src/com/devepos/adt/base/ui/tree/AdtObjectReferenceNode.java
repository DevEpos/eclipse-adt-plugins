package com.devepos.adt.base.ui.tree;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ObjectType;
import com.devepos.adt.base.adtobject.AdtObjectReferenceAdapterFactory;
import com.devepos.adt.base.destinations.IDestinationProvider;
import com.devepos.adt.base.ui.project.ProjectProviderAdapterFactory;
import com.sap.adt.project.IProjectProvider;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Represents a node in a tree which holds a reference to an
 * {@link IAdtObjectReference}
 *
 * @author stockbal
 */
public class AdtObjectReferenceNode extends TreeNodeBase implements IAdtObjectReferenceNode {

  protected IAdtObjectReference objectReference = null;
  protected List<ITreeNode> children = new ArrayList<>();
  protected String destinationId;

  public AdtObjectReferenceNode(final ICollectionTreeNode parent) {
    super("", parent);
  }

  public AdtObjectReferenceNode(final String name, final String displayName,
      final String description, final IAdtObjectReference objectReference) {
    this(name, displayName, description, objectReference, null);
  }

  public AdtObjectReferenceNode(final String name, final String displayName,
      final String description, final IAdtObjectReference objectReference,
      final ICollectionTreeNode parent) {
    super(name, displayName, description, parent);
    this.objectReference = objectReference;
  }

  @Override
  public void addChild(final ITreeNode child) {
    if (children == null) {
      children = new ArrayList<>();
    }
    if (child.getParent() != this) {
      child.setParent(this);
    }
    children.add(child);
  }

  @Override
  public <T> T getAdapter(final Class<T> adapter) {
    final T adapted = super.getAdapter(adapter);
    if (adapted != null) {
      return adapted;
    }
    if (objectReference == null) {
      return null;
    }
    if (adapter == IProjectProvider.class) {
      try {
        return adapter.cast(ProjectProviderAdapterFactory.adaptToProjectProvider(objectReference));
      } catch (final ClassCastException exc) {
      }
    } else if (adapter == com.sap.adt.tools.core.IAdtObjectReference.class) {
      try {
        return adapter.cast(AdtObjectReferenceAdapterFactory.adaptToNonEmfAdtObjectRef(
            objectReference));
      } catch (final ClassCastException exc) {
      }
    } else if (adapter == IAdtObjectReference.class) {
      return adapter.cast(objectReference);
    } else if (adapter == IDestinationProvider.class) {
      try {
        return adapter.cast(objectReference);
      } catch (final ClassCastException exc) {
      }
    }
    return null;
  }

  @Override
  public String getAdtObjectType() {
    return objectReference != null ? objectReference.getType() : null;
  }

  @Override
  public List<ITreeNode> getChildren() {
    return children;
  }

  @Override
  public Image getImage() {
    return null;
  }

  @Override
  public IAdtObjectReference getObjectReference() {
    return objectReference;
  }

  @Override
  public ObjectType getObjectType() {
    if (objectReference != null) {
      return ObjectType.getFromAdtType(objectReference.getType());
    }
    return null;
  }

  @Override
  public String getSizeAsString() {
    return children != null ? new DecimalFormat("###,###").format(children.size()) : "0";
  }

  @Override
  public boolean hasChildren() {
    return children != null && !children.isEmpty();
  }

  @Override
  public void removeAllChildren() {
    if (children != null) {
      children.clear();
    }
  }

  @Override
  public void removeChild(final ITreeNode child) {
    if (children != null && children.remove(child)) {
      child.setParent(null);
    }
  }

  @Override
  public void setChildren(final List<ITreeNode> children) {
    this.children = children;
  }

  @Override
  public void setObjectReference(final IAdtObjectReference objectReference) {
    this.objectReference = objectReference;

  }

  @Override
  public int size() {
    return children != null ? children.size() : 0;
  }

  @Override
  public boolean supportsDataPreview() {
    final ObjectType objectType = getObjectType();
    return objectType != null ? objectType.supportsDataPreview() : false;
  }
}
