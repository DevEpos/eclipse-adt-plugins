package com.devepos.adt.atm.ui.internal.util;

import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.atm.model.abaptags.ITag;

/**
 * Class for collecting parents of Tags
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class TagParentCollector {

  public static List<String> collectParentTagIds(final ITag startingTag) {
    var parent = startingTag;
    List<String> parentTagIds = new ArrayList<>();

    while (parent != null) {
      if (!parent.isTransient()) {
        parentTagIds.add(parent.getId());
      }

      var container = parent.eContainer();
      if (container == null || !(container instanceof ITag)) {
        break;
      }
      parent = (ITag) container;
    }
    return parentTagIds;
  }
}
