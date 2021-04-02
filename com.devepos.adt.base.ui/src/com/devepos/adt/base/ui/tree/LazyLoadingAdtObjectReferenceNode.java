package com.devepos.adt.base.ui.tree;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * ADT Object Reference node, which supports the lazy loading of its children.
 *
 * @author stockbal
 */
public class LazyLoadingAdtObjectReferenceNode extends AdtObjectReferenceNode implements ILazyLoadingNode {
    private boolean isLoading;
    private boolean isLoaded;
    private IElementInfoProvider provider;
    private LazyLoadingRefreshMode refreshMode;
    private final List<ILazyLoadingListener> lazyLoadingListeners = new ArrayList<>();

    public LazyLoadingAdtObjectReferenceNode(final ITreeNode parent) {
        this("", "", "", null, parent);
    }

    public LazyLoadingAdtObjectReferenceNode(final String name, final String displayName, final String description,
        final IAdtObjectReference objectReference, final ITreeNode parent) {
        super(name, displayName, description, objectReference, parent);
    }

    @Override
    public String getSizeAsString() {
        if (isLoading || !isLoaded) {
            return "?";
        }
        if (children != null) {
            return new DecimalFormat("###,###").format(children.size());
        }
        return "0";
    }

    @Override
    public void resetLoadedState() {
        isLoaded = false;
        if (children != null) {
            children.clear();
        }
        children = null;
    }

    @Override
    public boolean isLoading() {
        return isLoading;
    }

    @Override
    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public void loadChildren() {
        isLoading = true;
        loadChildrenInternal();
        isLoading = false;
        isLoaded = true;
        for (final ILazyLoadingListener l : lazyLoadingListeners) {
            l.loadingFinished(children != null ? children.size() : 0);
        }
    }

    @Override
    public void setContentRefreshMode(final LazyLoadingRefreshMode mode) {
        refreshMode = mode;
    }

    @Override
    public LazyLoadingRefreshMode getContentRefreshMode() {
        return refreshMode != null ? refreshMode : ILazyLoadingNode.super.getContentRefreshMode();
    }

    @Override
    public void setElementInfoProvider(final IElementInfoProvider provider) {
        this.provider = provider;
    }

    @Override
    public String getLazyLoadingJobName() {
        return provider != null ? provider.getProviderDescription() : null;
    }

    /**
     * Internal logic for loading the child nodes of this tree node
     */
    protected void loadChildrenInternal() {
        if (provider == null) {
            return;
        }
        final List<IElementInfo> elements = provider.getElements();
        if (elements == null || elements.isEmpty()) {
            return;
        }

        // create the sub nodes
        new TreeNodeCreator(this).createSubNodes(elements);
    }

    @Override
    public void addLazyLoadingListener(final ILazyLoadingListener l) {
        if (l == null) {
            throw new IllegalArgumentException();
        }
        lazyLoadingListeners.add(l);
    }

    @Override
    public void removeLazyLoadingListener(final ILazyLoadingListener l) {
        lazyLoadingListeners.remove(l);

    }
}
