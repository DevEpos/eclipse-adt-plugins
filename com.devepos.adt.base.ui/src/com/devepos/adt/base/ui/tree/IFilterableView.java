package com.devepos.adt.base.ui.tree;

import org.eclipse.ui.part.ViewPart;

/**
 * Describes a {@link ViewPart} which holds a viewer that is filterable
 * 
 * @author stockbal
 *
 */
public interface IFilterableView {

    /**
     * Toggles an inline filter of viewer
     */
    void toggleInlineFilter();
}
