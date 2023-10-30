package com.devepos.adt.base.internal.plugin.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;
import com.devepos.adt.base.model.adtbase.util.AdtBaseResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

public class AdtPluginFeaturesContentHandler
    extends AbstractEmfContentHandler<IAdtPluginFeatureList> {

  public AdtPluginFeaturesContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".pluginFeatures");
  }

  @Override
  public Class<IAdtPluginFeatureList> getSupportedDataType() {
    return IAdtPluginFeatureList.class;
  }

  @Override
  protected Resource createResource() {
    return new AdtBaseResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected IAdtPluginFeatureList getRootElement(final EObject rootElement) {
    return (IAdtPluginFeatureList) rootElement;
  }

}
