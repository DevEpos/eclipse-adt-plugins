package com.devepos.adt.saat.ui.internal.handlers;

import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsAnalysis;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.WhereUsedInCdsAnalysis;

public class PerformWhereUsedInCdsAnalysisHandler extends OpenInCdsAnalyzerHandler {

  public PerformWhereUsedInCdsAnalysisHandler() {
    super(CdsAnalysisType.WHERE_USED);
  }

  @Override
  protected boolean canExecute(final IAdtObject selectedObject) {
    return true;
  }

  @Override
  protected CdsAnalysis createTypedAnalysis(final IAdtObjectReferenceElementInfo objectRefInfo) {
    return new WhereUsedInCdsAnalysis(objectRefInfo);
  }

}
