package com.devepos.adt.saat.ui.internal.handlers;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsAnalysis;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsUsedEntitiesAnalysis;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.FeatureTester;

public class PerformCdsUsedEntitiesAnalysisHandler extends OpenInCdsAnalyzerHandler {

  public PerformCdsUsedEntitiesAnalysisHandler() {
    super(CdsAnalysisType.DEPENDENCY_TREE_USAGES);
  }

  @Override
  protected boolean isFeatureAvailable(final IProject project) {
    return FeatureTester.isCdsUsedEntitiesAnalysisAvailable(project);
  }

  @Override
  protected String getFeatureUnavailableMessage() {
    return Messages.CdsAnalysis_UsedEntitiesFeatureNotAvailable;
  }

  @Override
  protected CdsAnalysis createTypedAnalysis(final IAdtObjectReferenceElementInfo objectRefInfo) {
    return new CdsUsedEntitiesAnalysis(objectRefInfo);
  }
}
