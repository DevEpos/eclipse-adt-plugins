package com.devepos.adt.base.ui.internal.search;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.contentassist.AsyncContentAssist;
import com.devepos.adt.base.ui.search.contentassist.ISearchPatternAnalyzer;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterProposal;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterValueProposal;
import com.devepos.adt.base.util.Reflection;

/**
 * Adds asynchronous content assist support to a {@link Text} control for
 * complex search queries.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class SearchPatternContentAssist extends AsyncContentAssist {

  private static final int FILTER_PROPOSAL_POPUP_MIN_HEIGHT = 200;

  public SearchPatternContentAssist(final Text control,
      final ISearchPatternAnalyzer patternAnalyzer) {
    super(control, createQueryProposalProvider(patternAnalyzer));

    IContentProposalListener proposalListener = new IContentProposalListener() {

      @Override
      public void proposalAccepted(final IContentProposal proposal) {
        if (proposal instanceof SearchFilterProposal && ((SearchFilterProposal) proposal)
            .hasProposalSupport()) {
          // this call is needed, otherwise a new proposal pop up will not open,
          // regardless of the inserted ":" character
          Reflection.forObject(getContentProposalAdapter()).invoke("autoActivate");
        } else if (proposal instanceof SearchFilterValueProposal) {
          adjustMatch((SearchFilterValueProposal) proposal);
        }
      }

      /**
       * Adjusts the text input control depending on the inserted proposal.
       *
       * @param proposal
       */
      private void adjustMatch(final SearchFilterValueProposal proposal) {
        final String insertedText = proposal.getContent();
        if (proposal.getKey().equalsIgnoreCase(insertedText)) {
          final String queryAfterInsert = text.getText();
          final int caretPosition = text.getCaretPosition();
          final int caretBeforeLexem = caretPosition - insertedText.length() - proposal.getLexeme()
              .length();
          final String adjustedProposal = queryAfterInsert.substring(0, caretBeforeLexem)
              + insertedText;
          final String query = adjustedProposal + queryAfterInsert.substring(caretPosition);
          text.setText(query);
          text.setSelection(adjustedProposal.length());
        }
      }
    };

    setContentProposalListener(proposalListener);
    setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_INSERT);
    setAutoActivationCharacters(new char[] { ':', ',' });
    setAutoActivationDelay(500);
  }

  @Override
  protected Point calculatePopupSizeForProposals(final IContentProposal proposal,
      final PopupDialog popup, int height) {
    if (proposal instanceof SearchFilterValueProposal) {
      return super.calculatePopupSizeForProposals(proposal, popup, height);
    }
    if (proposal instanceof SearchFilterProposal) {
      height = text.getSize().y * queryResults.size() * 3;
      if (height > FILTER_PROPOSAL_POPUP_MIN_HEIGHT) {
        height = Math.min(POPUP_DEFAULT_HEIGHT, height);
      } else {
        height = FILTER_PROPOSAL_POPUP_MIN_HEIGHT;
      }
      return new Point(POPUP_DEFAULT_WIDTH, height);
    }
    return super.calculatePopupSizeForProposals(proposal, popup, height);
  }

  /*
   * Creates proposal provider by using the given pattern analyzer
   */
  private static ITextQueryProposalProvider createQueryProposalProvider(
      final ISearchPatternAnalyzer patternAnalyzer) {
    return query -> patternAnalyzer.getProposals(query);
  }

}
