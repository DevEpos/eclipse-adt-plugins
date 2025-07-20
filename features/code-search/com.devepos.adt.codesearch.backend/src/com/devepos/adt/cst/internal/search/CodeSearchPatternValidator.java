package com.devepos.adt.cst.internal.search;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.internal.CodeSearchPlugin;
import com.devepos.adt.cst.internal.search.backend.CodeSearchUriDiscovery;
import com.devepos.adt.cst.search.ICodeSearchPatternValidator;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IQueryParameter;
import com.sap.adt.communication.resources.QueryParameter;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.communication.session.ISystemSession;

public class CodeSearchPatternValidator implements ICodeSearchPatternValidator {

  private final String destinationId;
  private boolean isCloudProject;

  public CodeSearchPatternValidator(final IProject project) {
    destinationId = DestinationUtil.getDestinationId(project);
    isCloudProject = ProjectUtil.isCloudProject(project);
  }

  @Override
  public IStatus validatePatternsByProject(final String patterns,
      final Map<String, String> uriParameters) {
    return isCloudProject ? validatePatternsForClient(patterns, uriParameters)
        : validatePatternsForBackend(patterns, uriParameters);
  }

  @Override
  public IStatus validatePatternsForClient(String patterns, Map<String, String> uriParameters) {
    // TODO Auto-generated method stub
    return Status.OK_STATUS;
  }

  @Override
  public IStatus validatePatternsForBackend(String patterns, Map<String, String> uriParameters) {
    if (patterns == null || StringUtil.isBlank(patterns)) {
      throw new IllegalArgumentException("Parameter 'patterns' must not be empty or null");
    }
    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    var settingsUri = uriDiscovery.getPatternValidationUri();
    if (settingsUri == null) {
      return null;
    }
    final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(settingsUri, session);
    try {
      restResource.post(new NullProgressMonitor(), String.class, patterns,
          uriParameters.keySet()
              .stream()
              .map(k -> new QueryParameter(k, uriParameters.get(k)))
              .toArray(IQueryParameter[]::new));
      return Status.OK_STATUS;
    } catch (final ResourceException exc) {
      exc.printStackTrace();
      return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, exc.getMessage());
    }
  }
}
