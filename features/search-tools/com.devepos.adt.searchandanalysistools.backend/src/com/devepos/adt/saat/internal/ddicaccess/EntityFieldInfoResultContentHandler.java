package com.devepos.adt.saat.internal.ddicaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult;
import com.devepos.adt.saat.model.cdsanalysis.util.CdsAnalysisResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

public class EntityFieldInfoResultContentHandler
    extends AbstractEmfContentHandler<IEntityFieldInfoResult> {

  public EntityFieldInfoResultContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".entityfieldresult");
  }

  @Override
  public Class<IEntityFieldInfoResult> getSupportedDataType() {
    return IEntityFieldInfoResult.class;
  }

  @Override
  protected Resource createResource() {
    return new CdsAnalysisResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected IEntityFieldInfoResult getRootElement(final EObject rootElement) {
    return (IEntityFieldInfoResult) rootElement;
  }

}
