package com.devepos.adt.cst.internal.search;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.internal.CodeSearchPlugin;
import com.devepos.adt.cst.internal.search.backend.CodeSearchUriDiscovery;
import com.devepos.adt.cst.internal.search.client.engine.PatternUtil;
import com.devepos.adt.cst.internal.search.client.engine.PatternUtil.StaticError;
import com.devepos.adt.cst.search.ICodeSearchPatternValidator;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IQueryParameter;
import com.sap.adt.communication.resources.QueryParameter;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

public class CodeSearchPatternValidator implements ICodeSearchPatternValidator {

  private final String destinationId;
  private final boolean isCloudProject;

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
  public IStatus validatePatternsForClient(final String patterns,
      final Map<String, String> uriParameters) {
    var isSeqMatching = uriParameters.containsKey("seqMatching");
    var useRegex = uriParameters.containsKey("useRegex");

    if (!useRegex && !isSeqMatching) {
      return Status.OK_STATUS;
    }

    var patternList = patterns.split(patterns.contains("\r\n") ? "\r\n" : "\n");
    if (isSeqMatching) {
      try {
        var sequentialPatterns = PatternUtil.parsePatternSequence(List.of(patternList));
        if (useRegex) {
          for (var p : sequentialPatterns) {
            try {
              Pattern.compile(p.pattern());
            } catch (PatternSyntaxException e) {
              throw new StaticError(
                  String.format("Invalid pattern '%s': %s", p.pattern(), e.getMessage()));
            }
          }
        }
      } catch (StaticError e) {
        return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, e.getMessage(), e);
      }
    } else {
      for (var p : patternList) {
        try {
          Pattern.compile(p);
        } catch (PatternSyntaxException e) {
          return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID,
              String.format("Invalid pattern '%s': %s", p, e.getMessage()));
        }
      }

    }
    return Status.OK_STATUS;
  }

  @Override
  public IStatus validatePatternsForBackend(final String patterns,
      final Map<String, String> uriParameters) {
    if (patterns == null || StringUtil.isBlank(patterns)) {
      throw new IllegalArgumentException("Parameter 'patterns' must not be empty or null");
    }
    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    var settingsUri = uriDiscovery.getPatternValidationUri();
    if (settingsUri == null) {
      return null;
    }
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
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
