package com.devepos.adt.saat.internal.search;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryInput;
import com.devepos.adt.saat.model.objectsearch.util.ObjectSearchResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

public class ObjectSearchInputContentHandler extends AbstractEmfContentHandler<ISearchQueryInput> {

  public ObjectSearchInputContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".objectsearchinput");
  }

  @Override
  public Class<ISearchQueryInput> getSupportedDataType() {
    return ISearchQueryInput.class;
  }

  @Override
  protected Resource createResource() {
    return new ObjectSearchResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ISearchQueryInput getRootElement(final EObject rootElement) {
    return (ISearchQueryInput) rootElement;
  }

}
