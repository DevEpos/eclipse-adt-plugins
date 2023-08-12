package com.devepos.adt.saat.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.saat.elementinfo.ElementInfoRetrievalServiceFactory;
import com.devepos.adt.saat.ui.internal.cdsanalysis.AdtObjRefToElemInfoConverter;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsAnalysis;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsAnalysisKey;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsAnalysisManager;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsTopDownAnalysis;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsUsedEntitiesAnalysis;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.FieldAnalysis;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.RunNewCdsAnalysisDialog;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.WhereUsedInCdsAnalysis;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Command handler to run a new CDS analysis via dialog
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class RunCdsAnalysisHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    RunNewCdsAnalysisDialog dialog = new RunNewCdsAnalysisDialog(HandlerUtil.getActiveShell(event));
    if (dialog.open() == Window.OK) {
      IAdtObjectReference objectRef = dialog.getSelectedObject();
      IProject project = dialog.getProject();
      String destinationId = DestinationUtil.getDestinationId(project);
      CdsAnalysisManager analysisManager = CdsAnalysisManager.getInstance();
      CdsAnalysisKey analysisKey = new CdsAnalysisKey(dialog.getSelectedAnalysisType(), objectRef
          .getUri(), destinationId);
      CdsAnalysis existing = analysisManager.getExistingAnalysis(analysisKey);
      if (existing == null) {
        // determine ADT information about CDS view
        Job adtObjectRetrievalJob = Job.create(Messages.CdsAnalysis_LoadAdtObjectJobName_xmsg,
            (ICoreRunnable) monitor -> {
              // check if search is possible in selected project
              var adtObjRef = ElementInfoRetrievalServiceFactory.createService()
                  .retrieveBasicElementInformation(destinationId, objectRef.getUri());
              if (adtObjRef != null) {
                final CdsAnalysis newAnalysis = createAnalysisForType(AdtObjRefToElemInfoConverter
                    .convert(destinationId, adtObjRef), dialog.getSelectedAnalysisType());
                PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
                  analysisManager.addAnalysis(newAnalysis);
                  analysisManager.registerAnalysis(analysisKey, newAnalysis);
                  analysisManager.showAnalysis(newAnalysis, dialog.isRunInNew());
                });
              }
            });
        adtObjectRetrievalJob.schedule();

      } else {
        analysisManager.showAnalysis(existing, dialog.isRunInNew());
      }
    }
    return null;
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
