package com.devepos.adt.base.elementinfo;

import org.eclipse.swt.graphics.Image;

/**
 * Information of an element that supports lazy loading. The loading of the
 * elements is done via the passed {@link IElementInfoProvider}
 *
 * @author stockbal
 */
public class LazyLoadingElementInfo extends ElementInfoBase implements ILazyLoadingElementInfo {

    private IElementInfoProvider provider;
    private LazyLoadingRefreshMode refreshMode;

    public LazyLoadingElementInfo(final String name, final Image image, final IElementInfoProvider provider) {
        this(name, name, image, provider);
    }

    public LazyLoadingElementInfo(final String name, final String displayName, final Image image,
            final IElementInfoProvider provider) {
        super(name, displayName, image, null);
        this.provider = provider;
    }

    @Override
    public IElementInfoProvider getElementInfoProvider() {
        return provider;
    }

    @Override
    public void setElementInfoProvider(final IElementInfoProvider infoProvider) {
        provider = infoProvider;
    }

    @Override
    public void setContentRefreshMode(final LazyLoadingRefreshMode mode) {
        refreshMode = mode;
    }

    @Override
    public LazyLoadingRefreshMode getContentRefreshMode() {
        return refreshMode;
    }

}
