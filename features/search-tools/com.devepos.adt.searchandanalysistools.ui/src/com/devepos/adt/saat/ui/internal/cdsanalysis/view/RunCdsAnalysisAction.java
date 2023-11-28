package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.saat.elementinfo.ElementInfoRetrievalServiceFactory;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.cdsanalysis.AdtObjRefToElemInfoConverter;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Action to run new CDS Analysis for a given object reference
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class RunCdsAnalysisAction extends Action {

  private final IProject project;
  private final IAdtObjectReference objectRef;
  private final IAdtObjectReferenceElementInfo objectRefElemInfo;
  private final CdsAnalysisType analysisType;
  private final CdsAnalysisView cdsAnalysisView;
  private boolean openInNew;

  public RunCdsAnalysisAction(final CdsAnalysisView cdsAnalysisView,
      final CdsAnalysisType analysisType, final IAdtObjectReferenceElementInfo objectRefElemInfo,
      final IProject project) {
    this(cdsAnalysisView, analysisType, objectRefElemInfo, null, project, false);
  }

  public RunCdsAnalysisAction(final CdsAnalysisView cdsAnalysisView,
      final CdsAnalysisType analysisType, final IAdtObjectReference objectRef,
      final IProject project, boolean openInNew) {
    this(cdsAnalysisView, analysisType, null, objectRef, project, openInNew);
  }

  protected RunCdsAnalysisAction(final CdsAnalysisView cdsAnalysisView,
      final CdsAnalysisType analysisType, final IAdtObjectReferenceElementInfo objectRefElemInfo,
      final IAdtObjectReference objectRef, final IProject project, boolean openInNew) {
    this.cdsAnalysisView = cdsAnalysisView;
    this.openInNew = openInNew;
    this.analysisType = analysisType;
    this.objectRef = objectRef;
    this.objectRefElemInfo = objectRefElemInfo;
    this.project = project;
    setText(analysisType.toString());
    setActionImage();
  }

  @Override
  public void run() {
    var destinationId = DestinationUtil.getDestinationId(project);
    var analysisManager = CdsAnalysisManager.getInstance();
    var analysisKey = new CdsAnalysisKey(analysisType,
        objectRef != null ? objectRef.getUri() : objectRefElemInfo.getUri(), destinationId);
    var existing = analysisManager.getExistingAnalysis(analysisKey);
    if (existing == null) {
      if (objectRefElemInfo != null) {
        final var newAnalysis = createAnalysisForType(objectRefElemInfo, analysisType);
        analysisManager.addAnalysis(newAnalysis);
        analysisManager.registerAnalysis(analysisKey, newAnalysis);
        analysisManager.showAnalysis(cdsAnalysisView, newAnalysis, openInNew);
      } else {

        // determine ADT information about CDS view
        var adtObjectRetrievalJob = Job.create(Messages.CdsAnalysis_LoadAdtObjectJobName_xmsg,
            (ICoreRunnable) monitor -> {
              // check if search is possible in selected project
              var adtObjRef = ElementInfoRetrievalServiceFactory.createService()
                  .retrieveBasicElementInformation(destinationId, objectRef.getUri());
              if (adtObjRef != null) {
                final var newAnalysis = createAnalysisForType(
                    AdtObjRefToElemInfoConverter.convert(destinationId, adtObjRef), analysisType);
                PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
                  analysisManager.addAnalysis(newAnalysis);
                  analysisManager.registerAnalysis(analysisKey, newAnalysis);
                  analysisManager.showAnalysis(cdsAnalysisView, newAnalysis, openInNew);
                });
              }
            });
        adtObjectRetrievalJob.schedule();
      }
    } else {
      analysisManager.showAnalysis(cdsAnalysisView, existing, openInNew);
    }
  }

  private void setActionImage() {
    String imageKey = null;
    switch (analysisType) {
    case TOP_DOWN:
      imageKey = IImages.TOP_DOWN;
      break;
    case WHERE_USED:
      imageKey = IImages.WHERE_USED_IN;
      break;
    case FIELD_ANALYSIS:
      imageKey = IImages.FIELD_ANALYSIS;
      break;
    case DEPENDENCY_TREE_USAGES:
      imageKey = IImages.USAGE_ANALYZER;
      break;
    }

    if (imageKey != null) {
      setImageDescriptor(SearchAndAnalysisPlugin.getDefault().getImageDescriptor(imageKey));
    }
  }

  private CdsAnalysis createAnalysisForType(final IAdtObjectReferenceElementInfo adtObjRef,
      final CdsAnalysisType type) {
    switch (type) {
    case DEPENDENCY_TREE_USAGES:
      return new CdsUsedEntitiesAnalysis(adtObjRef);
    case FIELD_ANALYSIS:
      return new FieldAnalysis(adtObjRef);
    case TOP_DOWN:
      return new CdsTopDownAnalysis(adtObjRef);
    case WHERE_USED:
      return new WhereUsedInCdsAnalysis(adtObjRef);
    default:
      throw new UnsupportedOperationException(String.format("CDS Analysis type %s is not supported", //$NON-NLS-1$
          type));
    }
  }
}
