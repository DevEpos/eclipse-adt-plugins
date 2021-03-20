package com.devepos.adt.base.elementinfo;

import org.eclipse.swt.graphics.Image;

/**
 * Simple representation of an elements' information
 *
 * @author stockbal
 */
public class SimpleElementInfo extends ElementInfoBase {
    public SimpleElementInfo() {
        super("", "", null, null);
    }

    public SimpleElementInfo(final String name) {
        super(name, name, null, null);
    }

    public SimpleElementInfo(final String name, final Image image) {
        super(name, name, image, null);
    }

    public SimpleElementInfo(final String name, final String displayName, final Image image, final String description) {
        super(name, displayName, image, description);
    }
}
