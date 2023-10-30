package com.devepos.adt.saat.internal.search;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchResult;
import com.devepos.adt.saat.model.objectsearch.util.ObjectSearchResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

public class ObjectSearchResultContentHandler
    extends AbstractEmfContentHandler<IObjectSearchResult> {

  public ObjectSearchResultContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".objectsearchresult");
  }

  @Override
  public Class<IObjectSearchResult> getSupportedDataType() {
    return IObjectSearchResult.class;
  }

  @Override
  protected Resource createResource() {
    return new ObjectSearchResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected IObjectSearchResult getRootElement(final EObject rootElement) {
    return (IObjectSearchResult) rootElement;
  }

}
