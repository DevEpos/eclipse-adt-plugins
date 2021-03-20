package com.devepos.adt.base.ui.tree;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;

/**
 * Simple folder node that supports lazy loading
 *
 * @author stockbal
 */
public class LazyLoadingFolderNode extends FolderTreeNode implements ILazyLoadingNode {
    private boolean isLoading;
    private boolean isLoaded;
    private LazyLoadingRefreshMode refreshMode;
    private IElementInfoProvider provider;
    private final List<ILazyLoadingListener> lazyLoadingListeners = new ArrayList<>();

    public LazyLoadingFolderNode(final String name, final IElementInfoProvider elementInfoProvider,
            final ITreeNode parent, final Image image) {
        this(name, name, elementInfoProvider, image, null, parent);
    }

    public LazyLoadingFolderNode(final String name, final String displayName,
            final IElementInfoProvider elementInfoProvider, final Image image, final String description,
            final ITreeNode parent) {

        super(name, displayName, description, parent, image, null);
        Assert.isNotNull(elementInfoProvider);
        provider = elementInfoProvider;
    }

    @Override
    public String getSizeAsString() {
        if (isLoading || !isLoaded) {
            return "?";
        }
        if (children != null) {
            return new DecimalFormat("###,###").format(children.size());
        } else {
            return "0";
        }
    }

    @Override
    public boolean hasChildren() {
        return true;
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
    public void setElementInfoProvider(final IElementInfoProvider provider) {
        this.provider = provider;
    }

    @Override
    public String getLazyLoadingJobName() {
        return provider != null ? provider.getProviderDescription() : null;
    }

    @Override
    public void loadChildren() {
        isLoading = true;
        final List<IElementInfo> elementInfos = provider.getElements();

        if (elementInfos != null) {
            // create the sub nodes
            new TreeNodeCreator(this).createSubNodes(elementInfos);
        }
        isLoading = false;
        isLoaded = true;
        for (final ILazyLoadingListener l : lazyLoadingListeners) {
            l.loadingFinished(children.size());
        }
    }

    @Override
    public void addLazyLoadingListener(final ILazyLoadingListener l) {
        lazyLoadingListeners.add(l);
    }

    @Override
    public void removeLazyLoadingListener(final ILazyLoadingListener l) {
        lazyLoadingListeners.remove(l);

    }

    @Override
    public void setContentRefreshMode(final LazyLoadingRefreshMode mode) {
        refreshMode = mode;
    }

    @Override
    public LazyLoadingRefreshMode getContentRefreshMode() {
        if (refreshMode != null) {
            return refreshMode;
        }
        return ILazyLoadingNode.super.getContentRefreshMode();
    }

}
