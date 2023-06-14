package com.devepos.adt.base.nameditem;

import java.util.function.Function;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.util.IPropertyChangeListener;
import com.devepos.adt.base.util.IUriDiscovery;
import com.devepos.adt.base.util.PropertyChangeEvent;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * URI template provider for named items
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
class NamedItemUriTemplateProvider implements IAdtUriTemplateProvider, IPropertyChangeListener {

  private IAbapProjectProvider projectProvider;
  private IUriDiscovery uriDiscovery;
  private Function<String, IUriDiscovery> uriDiscoveryCreator;

  public NamedItemUriTemplateProvider(final IAbapProjectProvider projectProvider,
      Function<String, IUriDiscovery> uriDiscoveryCreator) {
    this.projectProvider = projectProvider;
    this.projectProvider.addPropertyChangeListener(this);
    this.uriDiscoveryCreator = uriDiscoveryCreator;
  }

  @Override
  public IAdtUriTemplate getTemplateByDiscoveryTerm(final String discoveryTerm) {
    initUriDiscovery();
    return uriDiscovery != null ? uriDiscovery.getNamedItemTemplate(discoveryTerm) : null;
  }

  @Override
  public void propertyChanged(final PropertyChangeEvent event) {
    if (!event.getProperty().equals(IAbapProjectProvider.PROPERTY_PROJECT)) {
      return;
    }
    // upon project change the URI discovery needs to be reset
    if (event.getNewValue() == null || event.getNewValue() != event.getOldValue()) {
      uriDiscovery = null;
    }
  }

  private void initUriDiscovery() {
    if (uriDiscovery != null || !projectProvider.hasProject()) {
      return;
    }
    uriDiscovery = this.uriDiscoveryCreator.apply(projectProvider.getDestinationId());
  }

}