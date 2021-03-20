package com.devepos.adt.base.elementinfo;

import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Element information that signals an error
 *
 * @author stockbal
 */
public class ErrorElementInfo extends ElementInfoBase {

    private final Throwable exception;

    /**
     * @param exception
     * @param message
     */
    public ErrorElementInfo(final String message, final Throwable exception) {
        super(message != null ? message : "Error during content loading occurred", PlatformUI.getWorkbench()
                .getSharedImages()
                .getImage(ISharedImages.IMG_OBJS_ERROR_TSK));
        this.exception = exception;
    }

    public Throwable getException() {
        return exception;
    }
}
