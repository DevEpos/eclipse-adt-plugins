package com.devepos.adt.tools.base.adtobject;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.tools.base.ObjectType;
import com.devepos.adt.tools.base.util.AdtTypeUtil;
import com.devepos.adt.tools.base.util.ObjectUtil;
import com.devepos.adt.tools.base.util.StringUtil;
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
		return this.project;
	}

	@Override
	public Image getImage() {
		if (this.reference == null || StringUtil.isEmpty(this.reference.getType())) {
			return null;
		}
		return AdtTypeUtil.getInstance().getTypeImage(this.reference.getType());
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public ObjectType getObjectType() {
		return this.objectType;
	}

	@Override
	public IAdtObjectReference getReference() {
		return this.reference;
	}

	@Override
	public boolean supportsDataPreview() {
		return this.objectType != null ? this.objectType.supportsDataPreview() : false;
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
		if (this.reference == null && other.reference == null) {
			return true;
		} else if (this.reference == null || other.reference == null) {
			return false;
		} else {
			if (!StringUtil.isEmpty(this.reference.getType()) && !StringUtil.isEmpty(this.reference.getName())) {
				return StringUtil.equals(this.reference.getType(), other.reference.getType())
					&& StringUtil.equals(this.reference.getName(), other.reference.getName());
			}
			return ObjectUtil.equals(this.reference.getUri(), other.reference.getUri());
		}
	}
}