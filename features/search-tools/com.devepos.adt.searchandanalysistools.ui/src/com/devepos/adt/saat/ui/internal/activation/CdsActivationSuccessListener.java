package com.devepos.adt.saat.ui.internal.activation;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.jobs.Job;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.ui.util.IAdtObjectTypeProxy;
import com.devepos.adt.saat.activation.CdsActivationServiceFactory;
import com.sap.adt.activation.ui.IActivationSuccessListener;
import com.sap.adt.tools.core.IAdtObjectReference;

/**
 * Activation success listener to handle post activation activities for CDS views
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
@SuppressWarnings("restriction")
public class CdsActivationSuccessListener implements IActivationSuccessListener {

  @Override
  public void onActivationSuccess(final List<IAdtObjectReference> activatedObjectRefs,
      final IProject project) {
    String destinationId = DestinationUtil.getDestinationId(project);
    if (!CdsActivationServiceFactory.getService().testCdsPostActivationAvailable(project).isOK()) {
      return;
    }
    IAdtObjectTypeProxy ddlType = AdtTypeUtil.getInstance()
        .getType(IAdtObjectTypeConstants.DATA_DEFINITION);

    List<String> ddlNamesInActivationList = activatedObjectRefs.stream()
        .filter(objRef -> objRef.getUri().getPath().startsWith(ddlType.getAdtResourceUriPath()))
        .map(IAdtObjectReference::getName)
        .collect(Collectors.toList());

    if (ddlNamesInActivationList.isEmpty()) {
      return;
    }

    Job postActionationJob = createPostActivationJob(destinationId, ddlNamesInActivationList);
    postActionationJob.schedule();
  }

  private Job createPostActivationJob(final String destinationId,
      final List<String> ddlNamesInActivationList) {
    return Job.createSystem("Run CDS Post Activation", monitor -> { //$NON-NLS-1$
      CdsActivationServiceFactory.getService()
          .postActivateCdsViews(destinationId, ddlNamesInActivationList);
      monitor.done();
    });
  }

}
