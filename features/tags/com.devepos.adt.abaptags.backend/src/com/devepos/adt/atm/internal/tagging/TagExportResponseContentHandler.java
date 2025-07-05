package com.devepos.adt.atm.internal.tagging;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITagExportResponse;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for {@link ITagData}
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TagExportResponseContentHandler extends AbstractEmfContentHandler<ITagExportResponse> {

  public TagExportResponseContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".tagExportResponse");
  }

  @Override
  public Class<ITagExportResponse> getSupportedDataType() {
    return ITagExportResponse.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITagExportResponse getRootElement(final EObject rootElement) {
    return (ITagExportResponse) rootElement;
  }

}
