package com.devepos.adt.base.ui.adtobject;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ObjectType;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.util.ObjectUtil;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public final class AdtObject implements IAdtObject {
    private final String name;
    private final ObjectType objectType;
    private final IProject project;
    private final IAdtObjectReference reference;

    public AdtObject(final String name, final IAdtObjectReference reference, final ObjectType objectType) {
        this(name, reference, objectType, null);
    }

    public AdtObject(final String name, final IAdtObjectReference reference, final ObjectType objectType,
        final IProject project) {
        this.objectType = objectType;
        this.name = name;
        this.project = project;
        this.reference = reference;
    }

    @Override
    public IProject getProject() {
        return project;
    }

    @Override
    public Image getImage() {
        if (reference == null || StringUtil.isEmpty(reference.getType())) {
            return null;
        }
        return AdtTypeUtil.getInstance().getTypeImage(reference.getType());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }

    @Override
    public IAdtObjectReference getReference() {
        return reference;
    }

    @Override
    public boolean supportsDataPreview() {
        return objectType != null ? objectType.supportsDataPreview() : false;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdtObject)) {
            return super.equals(obj);
        }
        final AdtObject other = (AdtObject) obj;
        if (reference == null && other.reference == null) {
            return true;
        }
        if (reference == null || other.reference == null) {
            return false;
        }
        if (!StringUtil.isEmpty(reference.getType()) && !StringUtil.isEmpty(reference.getName())) {
            return StringUtil.equals(reference.getType(), other.reference.getType()) && StringUtil.equals(reference
                .getName(), other.reference.getName());
        }
        return ObjectUtil.equals(reference.getUri(), other.reference.getUri());
    }
}