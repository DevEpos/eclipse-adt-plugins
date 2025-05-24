package com.devepos.adt.atm.ui.internal.wizard.importtags;

import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.base.util.StringUtil;

class CheckableTaggedObjectInfo {

  /**
   * Information about tagged Object
   */
  private ITaggedObjectInfo tgobj;

  /**
   * Holds the checked state of the tagged object
   */
  private boolean checked;

  private CheckableTaggedObjectInfo parent;
  private List<CheckableTaggedObjectInfo> children;

  public CheckableTaggedObjectInfo(ITaggedObjectInfo tgobj) {
    this.tgobj = tgobj;
  }

  public ITaggedObjectInfo getTgobj() {
    return tgobj;
  }

  public boolean isChecked() {
    return checked;
  }

  public String getTagId() {
    return tgobj.getTagId();
  }

  public void setChecked(boolean checked) {
    setChecked(checked, true);
  }

  public void setChecked(boolean checked, boolean forceCheckParent) {
    this.checked = checked;
    if (checked) {
      if (hasParentObject() && forceCheckParent) {
        setParentChecked();
      }
    } else {
      if (children != null) {
        setChildrenChecked(false);
      }
    }
  }

  public String getKey() {
    return String.format("%s_%s_%s", tgobj.getTagId(), tgobj.getObjectName(),
        tgobj.getObjectType());
  }

  public String getParentKey() {
    return String.format("%s_%s_%s", tgobj.getParentTagId(), tgobj.getParentObjectName(),
        tgobj.getParentObjectType());
  }

  public boolean hasParentObject() {
    return !StringUtil.isEmpty(tgobj.getParentObjectName());
  }

  public void setParent(CheckableTaggedObjectInfo parent) {
    this.parent = parent;
  }

  public void addChild(CheckableTaggedObjectInfo obj) {
    if (children == null) {
      children = new ArrayList<CheckableTaggedObjectInfo>();
    }
    children.add(obj);
  }

  public void setParentChecked() {
    if (parent != null) {
      parent.checked = true;
    }
  }

  public void setChildrenChecked(boolean checked) {
    if (children != null) {
      children.stream().forEach(c -> c.checked = checked);
    }
  }
}