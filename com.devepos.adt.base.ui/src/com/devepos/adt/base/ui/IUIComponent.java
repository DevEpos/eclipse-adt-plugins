package com.devepos.adt.base.ui;

import org.eclipse.swt.widgets.Composite;

/**
 * Component within a User Interface part
 *
 * @author stockbal
 */
public interface IUIComponent {

    /**
     * Creates the UI of the component
     * 
     * @param parent the parent composite
     */
    void createUI(Composite parent);
}
