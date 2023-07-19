package com.devepos.adt.saat.internal.navtargets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets;
import com.devepos.adt.saat.model.cdsanalysis.util.CdsAnalysisResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content handler for deserializing a list of Navigation targets for a given
 * ADT object
 *
 * @author stockbal
 */
public class NavigationTargetsContentHandler extends
    AbstractEmfContentHandler<ICdsQueryNavTargets> {

  public NavigationTargetsContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".cdsquerynavtargets");
  }

  @Override
  public Class<ICdsQueryNavTargets> getSupportedDataType() {
    return ICdsQueryNavTargets.class;
  }

  @Override
  protected Resource createResource() {
    return new CdsAnalysisResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ICdsQueryNavTargets getRootElement(final EObject rootElement) {
    return (ICdsQueryNavTargets) rootElement;
  }

}