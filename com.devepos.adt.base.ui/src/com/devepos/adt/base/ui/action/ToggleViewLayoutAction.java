package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.action.RadioActionGroup.IRadioActionToggleListener;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.util.StringUtil;

/**
 * Menu with actions to toggle the layout of a view. <br>
 * This action makes only sense if a view has a {@link SashForm} control as its
 * main control
 *
 * @see ViewLayoutOrientation
 * @author stockbal
 */
public class ToggleViewLayoutAction extends MenuManager implements IRadioActionToggleListener {

  private final RadioActionGroup orientationActionGroup;
  private final SashForm sashForm;
  private ControlListener resizeListener;
  private final Control resizedControl;
  private IToggleViewLayoutActionSettings settings;

  /**
   * Creates action to toggle the view layout.
   * 
   * @param sashForm       splitter control
   * @param resizedControl the control which will be resized
   */
  ToggleViewLayoutAction(final SashForm sashForm, final Control resizedControl) {
    this(sashForm, resizedControl, ViewLayoutActionFactory.getInstance().createDefaultSettings());
  }

  /**
   * Creates action to toggle the view layout. The visible layout buttons are dependent on the
   * passed flags.
   * 
   * @param sashForm       splitter control
   * @param resizedControl the control which will be resized
   * @param settings       instance to settings for action
   * @see ViewLayoutOrientation
   */
  ToggleViewLayoutAction(final SashForm sashForm, final Control resizedControl,
      IToggleViewLayoutActionSettings settings) {
    super(Messages.ToggleViewLayoutAction_TopLevelMenu_xmit);

    this.settings = settings;
    this.sashForm = sashForm;
    this.resizedControl = resizedControl;
    orientationActionGroup = createActionGroup();

    ViewLayoutOrientation initialOrientation = getInitialOrientation();
    orientationActionGroup.setActionChecked(initialOrientation.name());
    executeLayoutChange(initialOrientation);
    orientationActionGroup.contributeToMenuManager(this);
    orientationActionGroup.addActionToggledListener(this);

    if (settings.isAutomaticEnabled()) {
      resizeListener = new ControlAdapter() {
        @Override
        public void controlResized(final ControlEvent e) {
          executeLayoutChange(ViewLayoutOrientation.AUTOMATIC);
        }
      };
      resizedControl.addDisposeListener(e -> resizedControl.removeControlListener(resizeListener));

      if (initialOrientation == ViewLayoutOrientation.AUTOMATIC) {
        resizedControl.addControlListener(resizeListener);
      }
    }
  }

  @Override
  public void toggled(final String actionId) {
    final ViewLayoutOrientation orientation = ViewLayoutOrientation.valueOf(actionId);
    if (orientation == null) {
      return;
    }
    if (orientation == ViewLayoutOrientation.AUTOMATIC) {
      resizedControl.addControlListener(resizeListener);
    } else {
      resizedControl.removeControlListener(resizeListener);
    }
    executeLayoutChange(orientation);
    updatePreference(actionId);
  }

  private RadioActionGroup createActionGroup() {
    final RadioActionGroup actionGroup = new RadioActionGroup();

    // horizontal and vertical are always enabled, otherwise the action is the wrong choice
    actionGroup.addAction(ViewLayoutOrientation.HORIZONTAL.name(),
        Messages.ToggleViewLayoutAction_HorizontalOrientation_xmit, AdtBaseUIResources
            .getImageDescriptor(IAdtBaseImages.HORIZONTAL_LAYOUT), false);
    actionGroup.addAction(ViewLayoutOrientation.VERTICAL.name(),
        Messages.ToggleViewLayoutAction_VerticalOrientation_xmit, AdtBaseUIResources
            .getImageDescriptor(IAdtBaseImages.VERTICAL_LAYOUT), false);

    if (settings.isAutomaticEnabled()) {
      actionGroup.addAction(ViewLayoutOrientation.AUTOMATIC.name(),
          Messages.ToggleViewLayoutAction_AutomaticOrientation_xmit, AdtBaseUIResources
              .getImageDescriptor(IAdtBaseImages.AUTOMATIC_LAYOUT), false);
    }

    if (settings.isSingleEnabled()) {
      String actionLabel = settings.getSingleActionLabel();
      actionGroup.addAction(ViewLayoutOrientation.SINGLE.name(), !StringUtil.isEmpty(actionLabel)
          ? actionLabel
          : Messages.ToggleViewLayoutAction_SingleOrientation_xmit, AdtBaseUIResources
              .getImageDescriptor(IAdtBaseImages.SINGLE_LAYOUT), false);
    }
    return actionGroup;
  }

  private void executeLayoutChange(final ViewLayoutOrientation orientation) {
    if (orientation != ViewLayoutOrientation.SINGLE) {
      sashForm.setMaximizedControl(null);
    }
    if (orientation == ViewLayoutOrientation.AUTOMATIC) {
      final Point size = resizedControl.getSize();
      if (size.x != 0 && size.y != 0) {
        if (size.x > size.y) {
          setOrientation(ViewLayoutOrientation.HORIZONTAL);
        } else {
          setOrientation(ViewLayoutOrientation.VERTICAL);
        }
      }
    } else if (orientation == ViewLayoutOrientation.SINGLE) {
      Control[] sashControls = sashForm.getChildren();
      if (sashControls != null && sashControls.length > 0) {
        sashForm.setMaximizedControl(sashControls[0]);
      }
    } else {
      setOrientation(orientation);
    }
  }

  private ViewLayoutOrientation getInitialOrientation() {
    IPreferenceStore prefStore = settings.getPrefStore();
    String prefKey = settings.getPrefKey();
    if (prefStore != null && !StringUtil.isEmpty(prefKey)) {
      try {
        return ViewLayoutOrientation.valueOf(prefStore.getString(prefKey));
      } catch (final IllegalArgumentException exc) {
        return settings.isAutomaticEnabled() ? ViewLayoutOrientation.AUTOMATIC
            : ViewLayoutOrientation.VERTICAL;
      }
    } else {
      return settings.isAutomaticEnabled() ? ViewLayoutOrientation.AUTOMATIC
          : ViewLayoutOrientation.VERTICAL;
    }
  }

  private void setOrientation(final ViewLayoutOrientation orientation) {
    if (sashForm == null || sashForm.isDisposed()) {
      return;
    }
    sashForm.setOrientation(orientation.getSwtOrientation());
  }

  private void updatePreference(String actionId) {
    IPreferenceStore prefStore = settings.getPrefStore();
    if (prefStore == null) {
      return;
    }
    String prefKey = settings.getPrefKey();
    prefStore.setValue(prefKey, actionId);
  }
}
