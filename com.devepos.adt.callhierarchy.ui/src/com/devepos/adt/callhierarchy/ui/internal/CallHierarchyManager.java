package com.devepos.adt.callhierarchy.ui.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.devepos.adt.callhierarchy.ui.internal.preferences.IPreferences;
import com.devepos.adt.callhierarchy.ui.internal.views.CallHierarchyView;
import com.devepos.adt.callhierarchy.ui.internal.views.CallHierarchyViewManager;

/**
 * Manages all results of ABAP call hierarchies
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CallHierarchyManager {
  private static CallHierarchyManager instance;
  private List<CallHierarchyInput> hierarchies;
  private final List<ICallHierarchyListener> listeners;

  /**
   * Creates new instance of the CDS hierarchy manager
   */
  private CallHierarchyManager() {
    hierarchies = new LinkedList<>();
    listeners = new ArrayList<>();
  }

  /**
   * Returns instance of the CDS hierarchies manager
   *
   * @return instance of the CDS hierarchies manager
   */
  public static CallHierarchyManager getInstance() {
    if (instance == null) {
      instance = new CallHierarchyManager();
    }
    return instance;
  }

  /**
   * Moves the given hierarchy to the top of the list
   *
   * @param hierarchy the CDS hierarchy that was LRU
   */
  public void activated(final CallHierarchyInput hierarchy) {
    synchronized (this) {
      if (hierarchies.contains(hierarchy)) {
        hierarchies.remove(hierarchy);
        hierarchies.add(0, hierarchy);
      }
    }
  }

  /**
   * Adds the given listener if not already included
   *
   * @param l the listener to be added
   */
  public void addCallHierarchyListener(final ICallHierarchyListener l) {
    synchronized (listeners) {
      listeners.add(l);
    }
  }

  /**
   * Adds the given CDS hierarchy result at the top of the list
   *
   * @param result the result to be added
   */
  public void addHierarchy(final CallHierarchyInput result) {
    establishHistoryLimit();
    synchronized (this) {
      hierarchies.add(0, result);
    }
  }

  public void fireRemoved(final CallHierarchyInput hierarchy) {
    final Set<ICallHierarchyListener> copiedListeners = new HashSet<>();
    synchronized (listeners) {
      copiedListeners.addAll(listeners);
    }
    final Iterator<ICallHierarchyListener> listeners = copiedListeners.iterator();
    while (listeners.hasNext()) {
      final ICallHierarchyListener l = listeners.next();
      l.hierarchyRemoved(hierarchy);
    }
  }

  /**
   * Returns a LRU list of call hierarchies
   *
   * @return
   */
  public CallHierarchyInput[] getHierarchies() {
    synchronized (this) {
      return hierarchies.toArray(new CallHierarchyInput[hierarchies.size()]);
    }
  }

  public int getSize() {
    synchronized (this) {
      return hierarchies.size();
    }
  }

  /**
   * Returns <code>true</code> if there are hierarchies in the history
   *
   * @return <code>true</code> if there are hierarchies in the history
   */
  public boolean hasHierarchies() {
    return !hierarchies.isEmpty();
  }

  public void removeAll() {
    synchronized (this) {
      final List<CallHierarchyInput> old = hierarchies;
      hierarchies = new LinkedList<>();
      final Iterator<CallHierarchyInput> iter = old.iterator();
      while (iter.hasNext()) {
        final CallHierarchyInput element = iter.next();
        fireRemoved(element);
      }
    }
  }

  /**
   * Removes the given listener if it was registered
   *
   * @param l the listener to be removed
   */
  public void removeCallHierarchyListener(final ICallHierarchyListener l) {
    synchronized (listeners) {
      listeners.remove(l);
    }
  }

  /**
   * Removes the given hierarchy result from the list
   *
   * @param hierarchy the hierarchy object to be removed
   */
  public void removeHierarchy(final CallHierarchyInput hierarchy) {
    synchronized (this) {
      hierarchies.remove(hierarchy);
    }
    fireRemoved(hierarchy);
  }

  /**
   * Shows the given hierarchy in the CDS Analyzer view
   *
   * @param hierarchy the hierarchy to be shown
   * @param openInNew if {@code true} the hierarchy will be opened in a new CDS Analyzer view
   */
  public void showHierarchy(final CallHierarchyInput hierarchy, final boolean openInNew) {
    final CallHierarchyView callHierarchyView = CallHierarchyViewManager.getInstance()
        .activateHierarchyView(openInNew);
    if (callHierarchyView != null) {
      callHierarchyView.setFocus();
      activated(hierarchy);
      callHierarchyView.showHierarchy(hierarchy);
    }
  }

  private void establishHistoryLimit() {
    final int historyLimit = Activator.getDefault()
        .getPreferenceStore()
        .getInt(IPreferences.MAX_HIERARCHY_HISTORY);
    if (historyLimit >= getSize()) {
      return;
    }
    int numberQueriesNotShown = 0;
    final CallHierarchyViewManager viewManager = CallHierarchyViewManager.getInstance();
    final CallHierarchyInput[] hierarchies = getHierarchies();
    for (final CallHierarchyInput hierarchy : hierarchies) {
      if (!viewManager.isHierarchyShown(hierarchy) && ++numberQueriesNotShown >= historyLimit) {
        removeHierarchy(hierarchy);
      }
    }
  }
}
