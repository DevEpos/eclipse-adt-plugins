package com.devepos.adt.base.ui;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;

/**
 * Custom styler for JFace Viewers
 *
 * @author stockbal
 */
class CustomStyler extends Styler {
    private final int style;
    private final String foregroundColorName;
    private final String backgroundColorName;
    private Font font;

    public CustomStyler(final int style) {
        this(style, null, null);
    }

    public CustomStyler(final int style, final boolean preventDispose) {
        this(style, null, null);
    }

    public CustomStyler(final int style, final String foregroundColorName, final String backgroundColorName) {
        this.style = style;
        this.foregroundColorName = foregroundColorName;
        this.backgroundColorName = backgroundColorName;
    }

    @Override
    public void applyStyles(final TextStyle textStyle) {
        if (font == null) {
            final FontDescriptor fontDescriptor = JFaceResources.getDefaultFontDescriptor().setStyle(style);
            font = fontDescriptor.createFont(Display.getCurrent());
        }

        textStyle.font = font;

        final ColorRegistry colorRegistry = JFaceResources.getColorRegistry();

        if (foregroundColorName != null) {
            textStyle.foreground = colorRegistry.get(foregroundColorName);
        }
        if (backgroundColorName != null) {
            textStyle.background = colorRegistry.get(backgroundColorName);
        }
    }

    /**
     * Disposes allocated resources
     */
    void dispose() {
        if (font != null && !font.isDisposed()) {
            font.dispose();
            font = null;
        }
    }
}
