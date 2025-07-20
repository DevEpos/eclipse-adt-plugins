package com.devepos.adt.cst.ui.internal;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.ui.IWorkbenchPart;

import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.ui.internal.codesearch.NamedItem;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;

/**
 * Property Tester to check enablement of code search actions inside the ADT transport view
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class CodeSearchTmViewPropertyTester extends PropertyTester {

  public CodeSearchTmViewPropertyTester() {
  }

  @Override
  public boolean test(final Object receiver, final String property, final Object[] args,
      final Object expectedValue) {
    if (!(receiver instanceof IWorkbenchPart)) {
      return false;
    }
    try {
      if (TmViewAdapterHelper.isPartTmView((IWorkbenchPart) receiver)) {
        var project = TmViewAdapterHelper.getProjectFromTmView((IWorkbenchPart) receiver);
        if (project == null) {
          return false;
        }

        var featureUtil = CodeSearchFactory.getCodeSearchFeatureUtil(project);
        return featureUtil
            .testSearchAvailabilityByProject(CodeSearchUIPlugin.getDefault()
                .getPreferenceStore()
                .getBoolean(ICodeSearchPrefs.PREFER_CLIENT_BASED_SEARCH))
            .isOK()
            && featureUtil
                .testNamedItemAvailabilityByProject(NamedItem.TRANSPORT_REQUEST.getDiscoveryTerm())
                .isOK();
      }
    } catch (NullPointerException exc) {
    }
    return false;
  }

}
