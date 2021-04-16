package com.devepos.adt.base.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;

/**
 * Helper for easy context activation/ deactivation
 *
 * @author stockbal
 *
 */
public class ContextHelper {

    private IContextActivation abapContext;
    private Map<String, IContextActivation> activeContextsMap;
    private IContextService contextService;

    private ContextHelper(final IWorkbenchPart part) {
        contextService = part.getSite().getService(IContextService.class);
        activeContextsMap = new HashMap<>();
    }

    /**
     * Creates new helper for activating/deactivating eclipse contexts.
     *
     * @param part the part for the {@link IContextService}
     * @return the created helper
     */
    public static ContextHelper createForPart(final IWorkbenchPart part) {
        ContextHelper helper = new ContextHelper(part);
        return helper;
    }

    /**
     * Activates the ABAP context
     */
    public void activateAbapContext() {
        contextService.activateContext(IAdtBaseUIContextConstants.ABAP);
    }

    /**
     * Deactivates the ABAP context
     */
    public void deactivateAbapContext() {
        if (abapContext != null) {
            contextService.deactivateContext(abapContext);
        }
    }

    /**
     * Activates the context for the given {@code contextId}
     *
     * @param contextId the unique identifier of an eclipse context
     */
    public void activateContext(final String contextId) {
        if (activeContextsMap.containsKey(contextId)) {
            return;
        }
        activeContextsMap.put(contextId, contextService.activateContext(contextId));
    }

    /**
     * Deactivates the context for the given {@code contextId}
     *
     * @param contextId the unique identifier of an eclipse context
     */
    public void deactivateContext(final String contextId) {
        if (activeContextsMap.containsKey(contextId)) {
            contextService.deactivateContext(activeContextsMap.remove(contextId));
        }
    }

    /**
     * Deactivates all registered contexts via this helper
     */
    public void deactivateAllContexts() {
        if (!activeContextsMap.isEmpty()) {
            contextService.deactivateContexts(activeContextsMap.values());
            activeContextsMap.clear();
        }
        deactivateAbapContext();
    }

}
