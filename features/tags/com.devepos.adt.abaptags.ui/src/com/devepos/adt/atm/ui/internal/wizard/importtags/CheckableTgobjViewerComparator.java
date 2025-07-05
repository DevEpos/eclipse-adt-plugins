package com.devepos.adt.atm.ui.internal.wizard.importtags;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

import com.devepos.adt.base.util.StringUtil;

public class CheckableTgobjViewerComparator extends ViewerComparator {
  private CheckableTgobjColumnSpec col;
  private boolean isDescendingSort = false;

  @Override
  public int compare(final Viewer viewer, final Object e1, final Object e2) {
    var obj1 = ((CheckableTaggedObjectInfo) e1).getTgobj();
    var obj2 = ((CheckableTaggedObjectInfo) e2).getTgobj();

    if (col != null) {
      switch (col) {
      case OBJECT_TYPE:
        return compareStrings(obj1.getObjectType(), obj2.getObjectType());
      case OBJECT:
        return compareStrings(
            String.join("", StringUtil.getOrEmpty(obj1.getComponentType()),
                StringUtil.getOrEmpty(obj1.getComponentName()), obj1.getObjectName()),
            String.join("", StringUtil.getOrEmpty(obj2.getComponentType()),
                StringUtil.getOrEmpty(obj2.getComponentName()), obj2.getObjectName()));
      case PARENT_TAG:
        return compareStrings(
            StringUtil.isEmpty(obj1.getParentObjectName()) ? null : obj1.getParentTagName(),
            StringUtil.isEmpty(obj2.getParentObjectName()) ? null : obj2.getParentTagName());
      case PARENT_OBJECT:
        return compareStrings(StringUtil.getOrEmpty(obj1.getParentObjectName()),
            StringUtil.getOrEmpty(obj2.getParentObjectName()));
      case PARENT_OBJ_TYPE:
        return compareStrings(StringUtil.getOrEmpty(obj1.getParentObjectType()),
            StringUtil.getOrEmpty(obj2.getParentObjectType()));
      }
    }

    return 0;
  }

  public int getDirection() {
    return isDescendingSort ? SWT.DOWN : SWT.UP;
  }

  public void setColumn(final CheckableTgobjColumnSpec col) {
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
