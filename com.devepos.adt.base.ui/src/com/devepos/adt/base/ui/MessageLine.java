package com.devepos.adt.base.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.action.LegacyActionTools;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

/**
 * A message line displaying a status.
 */
public class MessageLine extends CLabel {

    /**
     * Creates a new message line as a child of the given parent.
     *
     * @param parent a widget which will be the parent of the new instance (cannot
     *               be null)
     */
    public MessageLine(final Composite parent) {
        this(parent, SWT.LEFT);
    }

    /**
     * Creates a new message line as a child of the parent and with the given SWT
     * stylebits.
     *
     * @param parent a widget which will be the parent of the new instance (cannot
     *               be null)
     * @param style  the style of widget to construct
     */
    public MessageLine(final Composite parent, final int style) {
        super(parent, style);
    }

    /**
     * Find an image associated with the status.
     *
     * @param status the status to find the image for
     * @return Image the image from {@link JFaceResources} associated with the
     *         status
     */
    private Image findImage(final IStatus status) {
        if (status.isOK()) {
            return null;
        }
        if (status.matches(IStatus.ERROR)) {
            return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_ERROR);
        }
        if (status.matches(IStatus.WARNING)) {
            return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_WARNING);
        }
        if (status.matches(IStatus.INFO)) {
            return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_INFO);
        }
        return null;
    }

    /**
     * Sets the message and image to the given status.
     *
     * @param status {@link IStatus} or <code>null</code>. <code>null</code> will
     *               set the empty text and no image.
     */
    public void setStatus(final IStatus status) {
        if (status != null && status.getSeverity() != IStatus.OK) {
            final String message = status.getMessage();
            if (message != null && message.length() > 0) {
                setText(LegacyActionTools.escapeMnemonics(message));
                setImage(findImage(status));
                return;
            }
        }
        setText(""); //$NON-NLS-1$
        setImage(null);
    }
}
