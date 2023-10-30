package com.devepos.adt.saat.internal.cdsanalysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult;
import com.devepos.adt.saat.model.cdsanalysis.util.CdsAnalysisResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for CDS Top Down Analysis
 *
 * @author stockbal
 */
public class CdsTopDownAnalysisContentHandler
    extends AbstractEmfContentHandler<ITopDownAnalysisResult> {

  public CdsTopDownAnalysisContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".cdstopdownresult");
  }

  @Override
  public Class<ITopDownAnalysisResult> getSupportedDataType() {
    return ITopDownAnalysisResult.class;
  }

  @Override
  protected Resource createResource() {
    return new CdsAnalysisResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITopDownAnalysisResult getRootElement(final EObject rootElement) {
    return (ITopDownAnalysisResult) rootElement;
  }
}
