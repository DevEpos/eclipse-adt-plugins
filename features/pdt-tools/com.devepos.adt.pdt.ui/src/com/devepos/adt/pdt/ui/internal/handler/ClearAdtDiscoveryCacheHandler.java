package com.devepos.adt.pdt.ui.internal.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;

import com.sap.adt.compatibility.internal.discovery.DiscoveryCache;
import com.sap.adt.tools.core.project.AdtProjectServiceFactory;
import com.sap.adt.tools.core.project.IAbapProject;

/**
 * Command handler to clear the ADT Discovery cache
 *
 * @author stockbal
 */
@SuppressWarnings("restriction")
public class ClearAdtDiscoveryCacheHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final IProject[] projects = AdtProjectServiceFactory.createProjectService()
        .getAvailableAbapProjects();
    if (projects != null && projects.length > 0) {
      final DiscoveryCache cache = DiscoveryCache.getDefault();
      for (final IProject project : projects) {
        final IAbapProject abapProject = project.getAdapter(IAbapProject.class);
        if (abapProject == null) {
          continue;
        }
        cache.removeEntry(abapProject.getDestinationId());
      }
    }
    return null;
  }

}
