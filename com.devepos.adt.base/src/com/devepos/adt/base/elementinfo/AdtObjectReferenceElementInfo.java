package com.devepos.adt.base.elementinfo;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.destinations.IDestinationProvider;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Information about an ADT Object reference
 *
 * @author stockbal
 */
public class AdtObjectReferenceElementInfo extends ElementInfoBase implements IAdtObjectReferenceElementInfo {

    private IAdtObjectReference objectReference;
    private List<IElementInfo> children;
    private boolean lazyLoading = false;
    private IElementInfoProvider infoProvider;
    private LazyLoadingRefreshMode refreshMode;

    public AdtObjectReferenceElementInfo() {
        this(null);
    }

    public AdtObjectReferenceElementInfo(final String name) {
        this(name, name, null);
    }

    public AdtObjectReferenceElementInfo(final String name, final String displayName, final String description) {
        super(name, displayName, null, description);
    }

    @Override
    public IAdtObjectReference getAdtObjectReference() {
        return objectReference;
    }

    @Override
    public String getUri() {
        return objectReference != null ? objectReference.getUri() : "";
    }

    @Override
    public String getAdtType() {
        return objectReference != null ? objectReference.getType() : "";
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public void setAdtObjectReference(final IAdtObjectReference objectReference) {
        this.objectReference = objectReference;
    }

    @Override
    public List<IElementInfo> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    @Override
    public boolean hasChildren() {
        return children != null && !children.isEmpty();
    }

    @Override
    public boolean hasLazyLoadingSupport() {
        return lazyLoading;
    }

    @Override
    public void setLazyLoadingSupport(final boolean lazyLoading) {
        this.lazyLoading = lazyLoading;
    }

    @Override
    public IElementInfoProvider getElementInfoProvider() {
        return infoProvider;
    }

    @Override
    public void setElementInfoProvider(final IElementInfoProvider infoProvider) {
        this.infoProvider = infoProvider;
        lazyLoading = this.infoProvider != null;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdtObjectReferenceElementInfo)) {
            return false;
        }

        final AdtObjectReferenceElementInfo adtObjectInfo2 = (AdtObjectReferenceElementInfo) obj;
        if (name.equals(adtObjectInfo2.getName())) {
            // check destination
            return compareDestination(adtObjectInfo2.getAdtObjectReference());
        }
        return false;
    }

    @Override
    public void setContentRefreshMode(final LazyLoadingRefreshMode mode) {
        refreshMode = mode;
    }

    @Override
    public LazyLoadingRefreshMode getContentRefreshMode() {
        return refreshMode != null ? refreshMode : IAdtObjectReferenceElementInfo.super.getContentRefreshMode();
    }

    private boolean compareDestination(final IAdtObjectReference objRef) {
        String destinationId1 = null;
        String destinationId2 = null;
        if (objectReference instanceof IDestinationProvider) {
            destinationId1 = ((IDestinationProvider) objectReference).getDestinationId();
        }

        if (objRef instanceof IDestinationProvider) {
            destinationId2 = ((IDestinationProvider) objRef).getDestinationId();
        }
        if (destinationId1 == null && destinationId2 == null) {
            return true;
        }
        if (destinationId1 != null && destinationId2 != null) {
            return destinationId1.equals(destinationId2);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        if (objectReference instanceof IDestinationProvider) {
            final String destinationId = ((IDestinationProvider) objectReference).getDestinationId();
            result = 31 * result + (destinationId == null ? 0 : destinationId.hashCode());
        }
        return result;
    }

    @Override
    public <T> T getAdapter(final Class<T> adapter) {
        if (adapter != IDestinationProvider.class) {
            return super.getAdapter(adapter);
        }
        if (objectReference != null) {
            try {
                return adapter.cast(objectReference);
            } catch (final ClassCastException exc) {
            }
        }
        return null;
    }

    @Override
    public int size() {
        return children == null ? 0 : children.size();
    }

    @Override
    public IElementInfo getChild(final String name) {
        if (!hasChildren() || name == null) {
            return null;
        }
        return children.stream().filter(el -> name.equals(name)).findFirst().orElse(null);
    }

    @Override
    public boolean hasChild(final String name) {
        if (!hasChildren() || name == null) {
            return false;
        }
        return children.stream().anyMatch(el -> name.equals(el.getName()));
    }

}
