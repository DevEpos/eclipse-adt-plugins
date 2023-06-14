package com.devepos.adt.base.ui.internal.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;

import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;

/**
 * Essentially this is only a wrapper class around a given
 * {@link ITextQueryProposalProvider} to provide asynchronous content proposals
 * via the use of the {@link Job} class
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
class AsyncTextQueryProposalProvider implements ITextQueryProposalProvider {
  private final long jobDelay = 400L;
  private String pendingQuery;
  private boolean pendingResultsExist;
  private final List<IContentChangeListener> contentChangeListeners;
  private Job queryJob;
  private final List<IContentProposal> queryResults;
  private ITextQueryProposalProvider proposalProvider;

  /**
   * Creates a new proposal provider. <br>
   * The given {@code proposalProvider} will be called from inside a Job to
   * collect the proposals for a given query asynchronously
   *
   * @param proposalProvider the actual proposal provider
   */
  public AsyncTextQueryProposalProvider(final ITextQueryProposalProvider proposalProvider) {
    if (proposalProvider == null) {
      throw new IllegalArgumentException("Parameter 'proposalProvider' must not be null!");
    }
    this.proposalProvider = proposalProvider;
    contentChangeListeners = new ArrayList<>();
    queryResults = new ArrayList<>();
  }

  /**
   * Job to query for proposals
   *
   * @author stockbal
   *
   */
  private class QueryJob extends Job {

    private final String query;

    public QueryJob(final String query) {
      super(NLS.bind(Messages.AsyncTextQueryProposalProvider_loadingJob_xmsg, query));
      this.query = query;
    }

    @Override
    protected IStatus run(final IProgressMonitor monitor) {
      List<IContentProposal> proposals = null;
      try {

        proposals = proposalProvider.getProposalList(query);
        if (monitor.isCanceled()) {
          pendingResultsExist = false;
          return Status.CANCEL_STATUS;
        }
        pendingResultsExist = true;
      } catch (final OperationCanceledException e) {
        throw e;
      } catch (final Exception e2) {
        pendingResultsExist = false;
        return new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, e2.getLocalizedMessage(), e2);
      }

      addProposals(proposals);
      if (monitor.isCanceled()) {
        return Status.CANCEL_STATUS;
      }
      return Status.OK_STATUS;
    }

  }

  /**
   * Adds the given listener to the list of proposal listeners list
   *
   * @param l the content change listener to be registered
   */
  public void addContentChangeListener(final IContentChangeListener l) {
    contentChangeListeners.add(l);
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    final List<IContentProposal> result = new ArrayList<>();
    result.add(new ContentProposal("", Messages.SearchPatternProvider_loading_xmsg, null));
    if (pendingQuery != null) {
      if (pendingResultsExist && pendingQuery.equalsIgnoreCase(query)) {
        return queryResults;
      }
      if (isQueryJobRunning()) {
        if (pendingQuery.equalsIgnoreCase(query)) {
          return result;
        }
        cancelQueryJob();
      }
    }
    createAndStartQueryJob(query);
    return result;
  }

  /**
   * Removes the given listener from the proposal listeners list
   *
   * @param l the content change listener to be removed
   */
  public void removeContentChangeListener(final IContentChangeListener listener) {
    contentChangeListeners.remove(listener);
  }

  private synchronized void addProposals(final List<IContentProposal> proposals) {
    queryResults.clear();
    if (proposals != null && proposals.size() > 0) {
      queryResults.addAll(proposals);
    }
  }

  /**
   * Cancels the currently running query proposal job
   */
  private synchronized void cancelQueryJob() {
    if (isQueryJobRunning()) {
      queryJob.cancel();
    }
  }

  /**
   * Creates a new Query proposal job with the given query string
   *
   * @param query the String the job shall be created for
   */
  private synchronized void createAndStartQueryJob(final String query) {
    pendingQuery = query;
    pendingResultsExist = false;
    queryJob = new QueryJob(query);
    queryJob.addJobChangeListener(new JobChangeAdapter() {
      @Override
      public void done(final IJobChangeEvent event) {
        queryJob = null;
        final IStatus result = event.getResult();
        if (result != null && result.getSeverity() != IStatus.ERROR) {
          result.getSeverity();
        }
        if (pendingQuery != null) {
          pendingQuery = null;
          Display.getDefault().asyncExec(() -> {
            // notify proposal listeners of calculated result
            if (pendingResultsExist) {
              notfiyListenersOfProposalsLoaded();
            }
          });
        }
      }

    });
    queryJob.schedule(jobDelay);
  }

  /**
   * Checks if there currently is a query job running or not
   *
   * @return
   */
  private boolean isQueryJobRunning() {
    return queryJob != null;
  }

  private void notfiyListenersOfProposalsLoaded() {
    for (final IContentChangeListener listener : contentChangeListeners) {
      listener.notifyContentChange(queryResults);
    }
  }
}
