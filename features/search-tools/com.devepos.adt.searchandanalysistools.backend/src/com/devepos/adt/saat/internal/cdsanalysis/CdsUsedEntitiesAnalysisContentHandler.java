package com.devepos.adt.saat.internal.cdsanalysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult;
import com.devepos.adt.saat.model.cdsanalysis.util.CdsAnalysisResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for CDS Used Entities analysis
 *
 * @author stockbal
 */
public class CdsUsedEntitiesAnalysisContentHandler
    extends AbstractEmfContentHandler<ICdsUsedEntitiesResult> {

  public CdsUsedEntitiesAnalysisContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".cdsusedentitiesresult");
  }

  @Override
  public Class<ICdsUsedEntitiesResult> getSupportedDataType() {
    return ICdsUsedEntitiesResult.class;
  }

  @Override
  protected Resource createResource() {
    return new CdsAnalysisResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ICdsUsedEntitiesResult getRootElement(final EObject rootElement) {
    return (ICdsUsedEntitiesResult) rootElement;
  }

}
