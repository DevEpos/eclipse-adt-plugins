package com.devepos.adt.saat.ui.internal.handlers;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsAnalysis;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.FieldAnalysis;
import com.devepos.adt.saat.ui.internal.util.FeatureTester;

/**
 * Handler for performing a field analy
 *
 * @author stockbal
 */
public class PerformFieldAnalysisHandler extends OpenInCdsAnalyzerHandler {

  public PerformFieldAnalysisHandler() {
    super(CdsAnalysisType.FIELD_ANALYSIS);
  }

  @Override
  protected boolean canExecute(final IAdtObject selectedObject) {
    /*
     * At least the "Where-Used" field analysis can be executed for every ADT Object
     * that was successfully adapted from the current selection
     */
    return true;
  }

  @Override
  protected boolean isFeatureAvailable(final IProject project) {
    return FeatureTester.isFieldAnalysisAvailable(project);
  }

  @Override
  protected CdsAnalysis createTypedAnalysis(final IAdtObjectReferenceElementInfo objectRefInfo) {
    return new FieldAnalysis(objectRefInfo);
  }
}
