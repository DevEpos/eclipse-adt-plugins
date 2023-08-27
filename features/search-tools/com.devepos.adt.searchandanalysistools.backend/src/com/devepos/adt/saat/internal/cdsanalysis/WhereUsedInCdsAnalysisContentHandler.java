package com.devepos.adt.saat.internal.cdsanalysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsResult;
import com.devepos.adt.saat.model.cdsanalysis.util.CdsAnalysisResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for Where-Used in CDS Analysis
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class WhereUsedInCdsAnalysisContentHandler extends
    AbstractEmfContentHandler<IWhereUsedInCdsResult> {

  public WhereUsedInCdsAnalysisContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".whereusedincdsresult");
  }

  @Override
  public Class<IWhereUsedInCdsResult> getSupportedDataType() {
    return IWhereUsedInCdsResult.class;
  }

  @Override
  protected Resource createResource() {
    return new CdsAnalysisResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected IWhereUsedInCdsResult getRootElement(final EObject rootElement) {
    return (IWhereUsedInCdsResult) rootElement;
  }
}
