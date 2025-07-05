package com.devepos.adt.atm.internal.tagging;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITagImportRequest;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TagImportRequestContentHandler extends AbstractEmfContentHandler<ITagImportRequest> {

  public TagImportRequestContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".tagExportRequest");
  }

  @Override
  public Class<ITagImportRequest> getSupportedDataType() {
    return ITagImportRequest.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITagImportRequest getRootElement(final EObject rootElement) {
    return (ITagImportRequest) rootElement;
  }

}
