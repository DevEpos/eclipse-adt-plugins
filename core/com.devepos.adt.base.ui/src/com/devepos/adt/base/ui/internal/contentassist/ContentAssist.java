package com.devepos.adt.base.ui.internal.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;

/**
 * Base class for adding content support to a {@link Text} control
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class ContentAssist extends AbstractContentProposalProvider {

  protected final static List<IContentProposal> EMPTY_PROPOSALS = new ArrayList<>();
  protected ITextQueryProposalProvider queryProposalProvider;
  protected final Text text;

  public ContentAssist(final Text text) {
    this(text, null);
  }

  public ContentAssist(final Text text, final ITextQueryProposalProvider queryProposalProvider) {
    super(text);

    this.text = text;
    this.queryProposalProvider = queryProposalProvider;

    text.addDisposeListener(l -> {
      dispose();
    });
    disableActivationKeyStrokeAsTextInput();
  }

  @Override
  public IContentProposal[] getProposals(final String contents, final int position) {
    if (!isTextFieldInputPossible()) {
      return new IContentProposal[0];
    }

    final String query = contents.substring(0, position);
    List<IContentProposal> result = computeProposals(query);

    return result.toArray(new IContentProposal[result.size()]);
  }

  public void setQueryProposalProvider(final ITextQueryProposalProvider queryProposalProvider) {
    this.queryProposalProvider = queryProposalProvider;
  }

  /**
   * Computes proposals using the {@link IContentProvider} of this class.<br>
   * Subclasses may extend the functionality
   *
   * @param query the query that triggered the content assist
   * @return the found proposals for the query
   */
  protected List<IContentProposal> computeProposals(final String query) {
    Assert.isNotNull(queryProposalProvider, "'queryProposalProvider' was not set!");
    try {
      return queryProposalProvider.getProposalList(query);
    } catch (CoreException e) {
      e.printStackTrace();
      return EMPTY_PROPOSALS;
    }
  }

  /**
   * Checks if the proposal popup is visible
   *
   * @return {@code true} if the proposal popup is open
   */
  protected final boolean isProposalPopupOpen() {
    ContentProposalAdapter proposalAdapter = getContentProposalAdapter();
    if (proposalAdapter != null) {
      return proposalAdapter.isProposalPopupOpen();
    }
    return false;
  }

  /**
   * Checks if it is possible to enter text into the text field
   *
   * @return {@code true} if the text field is editable
   */
  protected final boolean isTextFieldInputPossible() {
    boolean result = false;
    if (text != null && !text.isDisposed()) {
      result = text.isEnabled() && text.getEditable();
    }
    return result;
  }

  private void disableActivationKeyStrokeAsTextInput() {
    // disable keys of the activation key stroke to be sent to the text control
    text.addVerifyListener(e -> {
      final boolean popupActive = isProposalPopupOpen();
      if (popupActive) {
        final KeyStroke keyStroke = getActivationKeyStroke();

        if (e.keyCode == keyStroke.getNaturalKey() && e.stateMask == keyStroke.getModifierKeys()) {
          e.doit = false;
        }
      }
    });
  }
}
