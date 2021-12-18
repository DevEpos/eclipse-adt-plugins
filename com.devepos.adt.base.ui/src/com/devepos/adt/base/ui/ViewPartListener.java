package com.devepos.adt.base.ui;

import java.util.function.Consumer;

import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;

/**
 * Implementation of {@link IPartListener2} which allows for easy registration
 * of listener methods via {@link Consumer}s. <br>
 * <br>
 * Currently the following methods can be registered:
 * <ul>
 * <li>{@link #partActivated(IWorkbenchPartReference)}</li>
 * <li>{@link #partVisible(IWorkbenchPartReference)}</li>
 * </ul>
 *
 * @author stockbal
 */
public class ViewPartListener implements IPartListener2 {
  private Consumer<IWorkbenchPartReference> partActivatedConsumer;
  private Consumer<IWorkbenchPartReference> partVisibleConsumer;

  /**
   * Registers consumer for the method
   * {@link #partActivated(IWorkbenchPartReference)}
   *
   * @param partActivatedConsumer consumer for
   *                              {@link #partActivated(IWorkbenchPartReference)}
   */
  public void setPartActivatedConsumer(
      final Consumer<IWorkbenchPartReference> partActivatedConsumer) {
    this.partActivatedConsumer = partActivatedConsumer;
  }

  /**
   * Registers consumer for the method
   * {@link #partVisible(IWorkbenchPartReference)}
   *
   * @param partVisibleConsumer consumer for
   *                            {@link #partVisible(IWorkbenchPartReference)}
   */
  public void setPartVisibleConsumer(final Consumer<IWorkbenchPartReference> partVisibleConsumer) {
    this.partVisibleConsumer = partVisibleConsumer;
  }

  @Override
  public void partActivated(final IWorkbenchPartReference partRef) {
    if (partActivatedConsumer == null) {
      return;
    }
    partActivatedConsumer.accept(partRef);
  }

  @Override
  public void partVisible(final IWorkbenchPartReference partRef) {
    if (partVisibleConsumer == null) {
      return;
    }
    partVisibleConsumer.accept(partRef);
  }

  @Override
  public void partBroughtToTop(final IWorkbenchPartReference partRef) {
  }

  @Override
  public void partClosed(final IWorkbenchPartReference partRef) {
  }

  @Override
  public void partDeactivated(final IWorkbenchPartReference partRef) {
  }

  @Override
  public void partOpened(final IWorkbenchPartReference partRef) {
  }

  @Override
  public void partHidden(final IWorkbenchPartReference partRef) {
  }

  @Override
  public void partInputChanged(final IWorkbenchPartReference partRef) {
  }

}
