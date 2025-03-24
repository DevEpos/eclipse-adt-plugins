package com.devepos.adt.atm.ui.internal.wizard.importtags;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;

class CheckableTaggedObjectInfo {
  /**
   * Information about tagged Object
   */
  ITaggedObjectInfo tgObj;
  /**
   * Holds the checked state of the tagged object
   */
  boolean checked;
}