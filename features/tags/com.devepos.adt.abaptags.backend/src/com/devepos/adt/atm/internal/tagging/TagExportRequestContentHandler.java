package com.devepos.adt.atm.internal.tagging;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITagExportRequest;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for {@link ITagExportRequest}
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TagExportRequestContentHandler extends AbstractEmfContentHandler<ITagExportRequest> {

  public TagExportRequestContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".tagExportRequest");
  }

  @Override
  public Class<ITagExportRequest> getSupportedDataType() {
    return ITagExportRequest.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITagExportRequest getRootElement(final EObject rootElement) {
    return (ITagExportRequest) rootElement;
  }

}
