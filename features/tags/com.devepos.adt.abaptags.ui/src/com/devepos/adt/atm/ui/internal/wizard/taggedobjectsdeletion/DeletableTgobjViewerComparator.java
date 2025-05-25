package com.devepos.adt.atm.ui.internal.wizard.taggedobjectsdeletion;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

import com.devepos.adt.base.util.StringUtil;

public class DeletableTgobjViewerComparator extends ViewerComparator {
  private ColumnViewerSpec col;
  private boolean isDescendingSort = false;

  @Override
  public int compare(final Viewer viewer, final Object e1, final Object e2) {
    var obj1 = (DeletableTaggedObject) e1;
    var obj2 = (DeletableTaggedObject) e2;

    if (col != null) {
      switch (col) {
      case TAG:
        return compareStrings(String.join("", obj1.getTagType().toString(), obj1.getTagName()),
            String.join("", obj2.getTagType().toString(), obj2.getTagName()));
      case OBJECT:
        return compareStrings(
            String.join("", StringUtil.getOrEmpty(obj1.getComponentType()),
                StringUtil.getOrEmpty(obj1.getComponentName()),
                StringUtil.getOrEmpty(obj1.getObjectType()),
                StringUtil.getOrEmpty(obj1.getObjectName())),
            String.join("", StringUtil.getOrEmpty(obj2.getComponentType()),
                StringUtil.getOrEmpty(obj2.getComponentName()),
                StringUtil.getOrEmpty(obj2.getObjectType()),
                StringUtil.getOrEmpty(obj2.getObjectName())));
      case PARENT_TAG:
        var parentTag1 = obj1.getParentTagName();
        var parentTag2 = obj2.getParentTagName();
        parentTag1 = parentTag1 != null
            ? String.join("", obj1.getTagType().toString(), StringUtil.getOrEmpty(parentTag1))
            : null;
        parentTag2 = parentTag2 != null
            ? String.join("", obj2.getTagType().toString(), StringUtil.getOrEmpty(parentTag2))
            : null;
        return compareStrings(parentTag1, parentTag2);
      case PARENT_OBJECT:
        return compareStrings(
            String.join("", StringUtil.getOrEmpty(obj1.getParentObjectType()),
                StringUtil.getOrEmpty(obj1.getParentObjectName())),
            String.join("", StringUtil.getOrEmpty(obj2.getParentObjectType()),
                StringUtil.getOrEmpty(obj2.getParentObjectName())));
      case ISSUES:
        return compareStrings(obj1.getMessage(), obj2.getMessage());
      }
    }

    return 0;
  }

  public int getDirection() {
    return isDescendingSort ? SWT.DOWN : SWT.UP;
  }

  public void setColumn(final ColumnViewerSpec col) {
    if (this.col == col) {
      isDescendingSort = !isDescendingSort;
    } else {
      isDescendingSort = false;
    }
    this.col = col;
  }

  private int compareStrings(final String s1, final String s2) {
    var rc = StringUtil.getOrEmpty(s1).compareTo(StringUtil.getOrEmpty(s2));
    return isDescendingSort ? -rc : rc;
  }
}