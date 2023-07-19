package com.devepos.adt.saat.internal.search;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.saat.model.objectsearch.ISearchConfig;
import com.devepos.adt.saat.model.objectsearch.util.ObjectSearchResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

public class ObjectSearchConfigContentHandler extends AbstractEmfContentHandler<ISearchConfig> {

  public ObjectSearchConfigContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".objectsearchconfig");
  }

  @Override
  public Class<ISearchConfig> getSupportedDataType() {
    return ISearchConfig.class;
  }

  @Override
  protected Resource createResource() {
    return new ObjectSearchResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ISearchConfig getRootElement(final EObject rootElement) {
    return (ISearchConfig) rootElement;
  }

}
