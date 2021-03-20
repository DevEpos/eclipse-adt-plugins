package com.devepos.adt.base.ui;

import org.eclipse.jface.action.LegacyActionTools;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.devepos.adt.base.util.StringUtil;

/**
 * Composite for a Label in a View which holds some descriptive Text
 *
 * @author stockbal
 */
public class ViewDescriptionLabel {

    private Composite descriptionComposite;
    private Label description;
    private Label image;
    private final Composite parent;

    public ViewDescriptionLabel(final Composite parent) {
        this.parent = parent;
    }

    /**
     * Updates the label input
     */
    public void updateLabel(final String text) {
        updateLabel(text, null);
    }

    /**
     * Updates the label text
     */
    public void updateLabel(final String text, final Image image) {
        final String label = StringUtil.isEmpty(text) ? "" : LegacyActionTools.escapeMnemonics(text);
        if (parent.isDisposed()) {
            return;
        }
        if (label.length() == 0) {
            disposeDescription();
        } else {
            createDescription();
            description.setText(label);
            this.image.setImage(image);
            this.image.setVisible(image != null);
            ((GridData) this.image.getLayoutData()).exclude = image == null;
            parent.layout();
        }
    }

    private void createDescription() {
        if (descriptionComposite != null) {
            return;
        }
        descriptionComposite = new Composite(parent, SWT.NONE);
        descriptionComposite.moveAbove(null);

        GridLayoutFactory.fillDefaults()
                .spacing(-1, 2)
                .margins(0, 0)
                .extendedMargins(2, 0, 4, 0)
                .numColumns(2)
                .applyTo(descriptionComposite);
        GridDataFactory.fillDefaults().grab(true, false).applyTo(descriptionComposite);

        image = new Label(descriptionComposite, SWT.NONE);
        GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(image);

        description = new Label(descriptionComposite, SWT.LEAD | SWT.TOP | SWT.WRAP);
        GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(description);

        final Label separator = new Label(descriptionComposite, SWT.SEPARATOR | SWT.HORIZONTAL);
        GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(separator);
    }

    private void disposeDescription() {
        if (descriptionComposite != null) {
            descriptionComposite.dispose();
            descriptionComposite = null;
            parent.layout();
        }
    }

}
