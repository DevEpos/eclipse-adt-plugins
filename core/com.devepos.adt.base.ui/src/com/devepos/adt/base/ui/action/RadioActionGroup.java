package com.devepos.adt.base.ui.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionGroup;

/**
 * Describes a Set of Toggle Actions where only one Action can be active at a
 * time
 *
 * @author stockbal
 */
public class RadioActionGroup extends ActionGroup {
  private ToggleAction toggledAction;

  private final List<ToggleAction> actions;
  private final List<IRadioActionToggleListener> actionListener;

  public RadioActionGroup() {
    actions = new ArrayList<>();
    actionListener = new ArrayList<>();
  }

  /**
   * Listener which notifies the subscriber when an action in the Radio Action
   * Group was toggled
   *
   * @author stockbal
   */
  @FunctionalInterface
  public interface IRadioActionToggleListener {
    /**
     * This method will be called when the action with the id <code>actionId</code>
     * was toggled
     *
     * @param actionId id of the toggled Action
     */
    void toggled(String actionId);
  }

  private final class ToggleAction extends Action {
    private final String actionId;

    public ToggleAction(final String actionId, final String tooltip,
        final ImageDescriptor imageDescriptor) {
      super(tooltip, AS_RADIO_BUTTON);
      setImageDescriptor(imageDescriptor);
      this.actionId = actionId;
    }

    @Override
    public void run() {
      if (isChecked()) {
        toggleAction(actionId, false, true);
      }
    }
  }

  /**
   * Adds new action to the Radio Action Group
   *
   * @param actionId        the Id of the Action to be added to the group
   * @param tooltip         the tool tip of the action
   * @param imageDescriptor the image descriptor of the action
   * @param toggled         if <code>true</code> the created action will be
   *                        toggled
   */
  public void addAction(final String actionId, final String tooltip,
      final ImageDescriptor imageDescriptor, final boolean toggled) {
    final ToggleAction toggleAction = new ToggleAction(actionId, tooltip, imageDescriptor);
    toggleAction.setChecked(toggled);
    if (toggled) {
      toggledAction = toggleAction;
    }
    actions.add(toggleAction);
  }

  /**
   * Adds the given action toggled listener to this <code>RadioActionGroup</code>
   * <br>
   * Has no effect if the same listener was already added
   *
   * @param l the listener to be added
   */
  public void addActionToggledListener(final IRadioActionToggleListener l) {
    actionListener.add(l);
  }

  public void contributeToMenuManager(final IMenuManager menuManager) {
    actions.forEach(a -> menuManager.add(a));
  }

  /**
   * Adds the items of this Radio Action Group to the provided tool bar manager
   *
   * @param tbm tool bar manager where the radio actions should be added to
   */
  public void contributeToToolbar(final IToolBarManager tbm) {
    contributeToToolbar(tbm, null);
  }

  /**
   * Adds the items of this Radio Action Group to the provided tool bar manager at the specified
   * group
   *
   * @param tbm   tool bar manager where the radio actions should be added to
   * @param group name of the group where the action should be added
   */
  public void contributeToToolbar(final IToolBarManager tbm, final String group) {
    actions.forEach(a -> {
      if (group != null) {
        tbm.appendToGroup(group, a);
      } else {
        tbm.add(a);
      }
    });
  }

  /**
   * Enables/Disables the action with the given <code>actionId</code> in this
   * {@link RadioActionGroup}.
   *
   * @param actionId the Id of the action to be enabled/disabled
   * @param enable   if <code>true</code> the action will be enabled
   */
  public void enableAction(final String actionId, final boolean enable) {
    final ToggleAction actionToEnable = actions.stream()
        .filter(a -> a.actionId.equals(actionId))
        .findFirst()
        .orElse(null);
    if (actionToEnable != null) {
      actionToEnable.setEnabled(enable);
      if (!enable && actionToEnable.isChecked()) {
        actionToEnable.setChecked(false);
        // search for another action to be toggled
        final ToggleAction newToggleAction = actions.stream()
            .filter(a -> !a.actionId.equals(actionId))
            .findFirst()
            .orElse(null);
        if (newToggleAction != null) {
          newToggleAction.setChecked(true);
          toggledAction = newToggleAction;
        } else {
          toggledAction = null;
        }
      }
    }

  }

  @Override
  public void fillActionBars(final IActionBars actionBars) {
    contributeToToolbar(actionBars.getToolBarManager());
  }

  /**
   * Returns the Id of currently toggled action
   *
   * @return the Id of currently toggled action
   */
  public String getToggledActionId() {
    return toggledAction != null ? toggledAction.actionId : null;
  }

  /**
   * Returns <code>true</code> if the action with the given id
   * <code>actionId</code>
   *
   * @param actionId the action Id to be checked for the toggled state
   * @return <code>true</code> if the action with the given id
   *         <code>actionId</code>
   */
  public boolean isActionToggled(final String actionId) {
    final Action action = actions.stream()
        .filter(a -> a.actionId.equals(actionId))
        .findFirst()
        .orElse(null);
    if (action != null) {
      return action.isChecked();
    }
    return false;
  }

  /**
   * Removes the given action toggled listener from this
   * <code>RadioActionGroup</code> <br>
   * Has no effect if the same listener was already removed
   *
   * @param l the listener to be removed
   */
  public void removeActionToggledListener(final IRadioActionToggleListener l) {
    actionListener.remove(l);
  }

  /**
   * Sets the action with the given id to the isChecked state. <br>
   * It does not notfiy any listeners of the update
   *
   * @param actionId the id of an action in this group
   */
  public void setActionChecked(final String actionId) {
    for (ToggleAction action : actions) {
      if (actionId.equals(action.actionId)) {
        action.setChecked(true);
      } else {
        action.setChecked(false);
      }
    }
  }

  private void fireToggled(final String actionId) {
    for (final IRadioActionToggleListener l : actionListener) {
      l.toggled(actionId);
    }
  }

  private void toggleAction(final String actionId, final boolean setChecked,
      final boolean notifyListeners) {
    final ToggleAction action = actions.stream()
        .filter(a -> actionId.equals(a.actionId))
        .findFirst()
        .orElse(null);
    if (action == null) {
      return;
    }
    toggledAction = action;
    if (setChecked) {
      toggledAction.setChecked(true);
    }
    if (notifyListeners) {
      fireToggled(actionId);
    }
  }

}
