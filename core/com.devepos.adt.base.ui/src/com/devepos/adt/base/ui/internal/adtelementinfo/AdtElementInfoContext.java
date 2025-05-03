package com.devepos.adt.base.ui.internal.adtelementinfo;

import org.eclipse.core.resources.IProject;

import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class AdtElementInfoContext {
  private final IAdtObjectReference objectReference;
  private final IProject project;

  public AdtElementInfoContext(final IAdtObjectReference objectReference, final IProject project) {
    super();
    this.objectReference = objectReference;
    this.project = project;
  }

  public IAdtObjectReference getObjectReference() {
    return objectReference;
  }

  public IProject getProject() {
    return project;
  }

}
