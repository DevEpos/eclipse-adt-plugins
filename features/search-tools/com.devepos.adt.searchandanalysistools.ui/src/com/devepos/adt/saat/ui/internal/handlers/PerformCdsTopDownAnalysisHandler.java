package com.devepos.adt.saat.ui.internal.handlers;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsAnalysis;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsTopDownAnalysis;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.FeatureTester;

public class PerformCdsTopDownAnalysisHandler extends OpenInCdsAnalyzerHandler {

  public PerformCdsTopDownAnalysisHandler() {
    super(CdsAnalysisType.TOP_DOWN);
  }

  @Override
  protected boolean isFeatureAvailable(final IProject project) {
    return FeatureTester.isCdsTopDownAnalysisAvailable(project);
  }

  @Override
  protected String getFeatureUnavailableMessage() {
    return Messages.CdsAnalysis_TopDownAnalsysisFeatureNotAvailable;
  }

  @Override
  protected CdsAnalysis createTypedAnalysis(final IAdtObjectReferenceElementInfo objectRefInfo) {
    return new CdsTopDownAnalysis(objectRefInfo);
  }
}
