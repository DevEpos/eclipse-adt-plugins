package com.devepos.adt.callhierarchy.ui.internal;

/**
 * Listens to changes of a hierarchy
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface ICallHierarchyListener {

  void hierarchyRemoved(CallHierarchyInput hierarchy);
}
