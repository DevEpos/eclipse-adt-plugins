package com.devepos.adt.base.ui.internal.propertytester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.devepos.adt.base.ui.internal.pages.DevEposProjectRootPropertyPage;

/**
 * Tests if there are any plugins that are providing property page extensions
 * with DevEpos as root category. <br>
 * As plugins are registered per eclipse installation it is not really necessary
 * to perform tests against the {@code receiver} parameter of the
 * {@link #test(Object, String, Object[], Object)} method.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class PropertyPageExistenceTester extends PropertyTester {

  private static final String ID_EXTENSION_POINT = "org.eclipse.ui.propertyPages";
  private static final String ATTRIB_CATEGORY = "category";
  private boolean subPropertyPagesAvailable;

  public PropertyPageExistenceTester() {
    final IConfigurationElement[] propertyExtensions = Platform.getExtensionRegistry()
        .getConfigurationElementsFor(ID_EXTENSION_POINT);
    for (IConfigurationElement extension : propertyExtensions) {
      if (DevEposProjectRootPropertyPage.PAGE_ID.equals(extension.getAttribute(ATTRIB_CATEGORY))) {
        subPropertyPagesAvailable = true;
        break;
      }
    }
  }

  @Override
  public boolean test(final Object receiver, final String property, final Object[] args,
      final Object expectedValue) {
    return subPropertyPagesAvailable;
  }

}
