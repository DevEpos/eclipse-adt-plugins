package com.devepos.adt.cst.ui.internal;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.ui.IWorkbenchPart;

import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.ui.internal.codesearch.NamedItem;

/**
 * Property Tester to check enablement of code search actions inside the ADT transport view
 * 
 * @author Ludwig Stockbauer-Muhr
 */
public class CodeSearchTmViewPropertyTester extends PropertyTester {

  public CodeSearchTmViewPropertyTester() {
  }

  @Override
  public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
    if (!(receiver instanceof IWorkbenchPart)) {
      return false;
    }
    try {
      if (TmViewAdapterHelper.isPartTmView((IWorkbenchPart) receiver)) {
        var project = TmViewAdapterHelper.getProjectFromTmView((IWorkbenchPart) receiver);
        if (project == null) {
          return false;
        }

        var codeSearchService = CodeSearchFactory.getCodeSearchService();
        return codeSearchService.testCodeSearchFeatureAvailability(project).isOK()
            && codeSearchService
                .testCodeSearchNamedItemAvailability(project,
                    NamedItem.TRANSPORT_REQUEST.getDiscoveryTerm())
                .isOK();
      }
    } catch (NullPointerException exc) {
    }
    return false;
  }

}
