package com.devepos.adt.base.content;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.model.adtbase.util.AdtBaseResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for {@link IAdtObjRef}
 *
 * @author stockbal
 */
public class AdtObjRefContentHandler extends AbstractEmfContentHandler<IAdtObjRef> {

  public AdtObjRefContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".adtobjreflist");
  }

  @Override
  public Class<IAdtObjRef> getSupportedDataType() {
    return IAdtObjRef.class;
  }

  @Override
  protected Resource createResource() {
    return new AdtBaseResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected IAdtObjRef getRootElement(final EObject root) {
    return (IAdtObjRef) root;
  }

}