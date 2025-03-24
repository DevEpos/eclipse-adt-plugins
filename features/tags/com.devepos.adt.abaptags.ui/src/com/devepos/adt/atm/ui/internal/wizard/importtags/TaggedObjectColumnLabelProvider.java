package com.devepos.adt.atm.ui.internal.wizard.importtags;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.util.AdtObjectUtil;
import com.devepos.adt.atm.ui.internal.util.IColorConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.util.AdtTypeUtil;

class TaggedObjectColumnLabelProvider extends CellLabelProvider
    implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {

  protected final ColumnViewerSpec colSpec;
  private IProject project;

  public TaggedObjectColumnLabelProvider(final ColumnViewerSpec colSpec, IProject project) {
    this.colSpec = colSpec;
    this.project = project;
  }

  @Override
  public Image getImage(final Object element) {
    return fillNodeImage(((CheckableTaggedObjectInfo) element).tgObj);
  }

  @Override
  public StyledString getStyledText(final Object element) {
    var nodeText = new StyledString();
    fillNodeText(((CheckableTaggedObjectInfo) element).tgObj, nodeText);
    return nodeText;
  }

  @Override
  public void update(final ViewerCell cell) {
  }

  protected Image fillNodeImage(final ITaggedObjectInfo taggedObject) {
    Image image = null;
    switch (colSpec) {
    case OBJECT:
      image = getObjectImage(taggedObject);
      break;
    case PARENT_TAG:
      if (taggedObject.getParentTagId() != null && taggedObject.getParentObjectName() != null) {
        image = getTagImage(taggedObject);
      }
      break;
    case PARENT_OBJECT:
      image = ImageUtil.getAdtTypeImage(taggedObject.getParentObjectType());
      break;
    default:
      break;
    }
    return image;
  }

  protected void fillNodeText(final ITaggedObjectInfo taggedObject, final StyledString nodeText) {
    switch (colSpec) {
    case OBJECT:
      appendObjectName(taggedObject, nodeText);
      break;
    case OBJECT_TYPE:
      appendObjectType(taggedObject.getObjectType(), nodeText);
      break;
    case PARENT_TAG:
      if (taggedObject.getParentTagId() != null && taggedObject.getParentObjectName() != null) {
        nodeText.append(taggedObject.getParentTagName());
      }
      break;
    case PARENT_OBJECT:
      if (taggedObject.getParentObjectName() != null) {
        nodeText.append(taggedObject.getParentObjectName());
      }
      break;
    case PARENT_OBJ_TYPE:
      appendObjectType(taggedObject.getParentObjectType(), nodeText);
      break;
    default:
      break;
    }
  }

  private void appendObjectType(String objectType, StyledString nodeText) {
    if (objectType == null) {
      return;
    }
    var typeLabel = AdtObjectUtil.getTypeDescription(objectType);
    if (typeLabel == null) {
      typeLabel = AdtObjectUtil.getTypeDescriptionByProject(objectType, project);
    }
    if (typeLabel != null) {
      nodeText.append(typeLabel);
    }
  }

  private void appendObjectName(final ITaggedObjectInfo taggedObject, final StyledString text) {
    if (taggedObject.getComponentName() != null) {
      text.append(taggedObject.getComponentName());
      text.append(String.format(" [%s]", taggedObject.getObjectName()),
          StylerFactory.createCustomStyler(SWT.NORMAL, IColorConstants.COMP_PARENT_COLOR, null));
    } else {
      text.append(taggedObject.getObjectName());
    }
  }

  private Image getObjectImage(final ITaggedObjectInfo taggedObject) {
    if (taggedObject.getComponentType() != null) {
      var typeUtil = AdtTypeUtil.getInstance();
      return typeUtil.isLocalClassType(taggedObject.getComponentType())
          ? ImageUtil.getLocalClassImage()
          : ImageUtil.getLocalInterfaceImage();
    }
    return ImageUtil.getAdtTypeImage(taggedObject.getObjectType());
  }

  private Image getTagImage(final ITaggedObjectInfo element) {
    switch (element.getTagType()) {
    case GLOBAL:
      return AbapTagsUIPlugin.getDefault().getImage(IImages.TAG);
    case USER:
      return AbapTagsUIPlugin.getDefault().getImage(IImages.USER_TAG);
    case SHARED:
      return AbapTagsUIPlugin.getDefault().getImage(IImages.SHARED_TAG);
    }
    return null;
  }

}