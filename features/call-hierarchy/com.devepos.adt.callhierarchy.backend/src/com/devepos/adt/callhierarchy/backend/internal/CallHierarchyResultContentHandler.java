package com.devepos.adt.callhierarchy.backend.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;
import com.devepos.adt.callhierarchy.model.callhierarchy.util.CallhierarchyResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

public class CallHierarchyResultContentHandler extends AbstractEmfContentHandler<IHierarchyResult> {

  public CallHierarchyResultContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".callhierarchyresult");
  }

  @Override
  public Class<IHierarchyResult> getSupportedDataType() {
    return IHierarchyResult.class;
  }

  @Override
  protected Resource createResource() {
    return new CallhierarchyResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected IHierarchyResult getRootElement(final EObject rootElement) {
    return (IHierarchyResult) rootElement;
  }

}
