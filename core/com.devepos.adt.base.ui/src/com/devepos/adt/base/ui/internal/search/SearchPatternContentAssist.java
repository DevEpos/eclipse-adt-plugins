package com.devepos.adt.base.ui.internal.search;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.SWTKeySupport;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.contentassist.AsyncContentAssist;
import com.devepos.adt.base.ui.search.contentassist.BooleanSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.DateSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.ISearchPatternAnalyzer;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterProposal;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterValueProposal;
import com.devepos.adt.base.ui.util.SWTUtil;
import com.devepos.adt.base.util.Reflection;
import com.devepos.adt.base.util.StringUtil;

/**
 * Adds asynchronous content assist support to a {@link Text} control for
 * complex search queries.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class SearchPatternContentAssist extends AsyncContentAssist {

  private static final int FILTER_PROPOSAL_POPUP_MIN_HEIGHT = 200;
  private static final KeyStroke DEFAULT_VH_DIALOG_KEYSTROKE = KeyStroke.getInstance(SWT.F4);
  private KeyStroke vhDialogTriggerKeyStroke;

  public SearchPatternContentAssist(final Text control,
      final ISearchPatternAnalyzer patternAnalyzer) {
    super(control, createQueryProposalProvider(patternAnalyzer));

    var proposalListener = new IContentProposalListener() {

      @Override
      public void proposalAccepted(final IContentProposal proposal) {
        if (proposal instanceof SearchFilterProposal
            && ((SearchFilterProposal) proposal).hasProposalSupport()) {
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
          final int caretBeforeLexem = caretPosition - insertedText.length()
              - proposal.getLexeme().length();
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

    addValueHelpTriggerListener(control, patternAnalyzer);
    vhDialogTriggerKeyStroke = SWTUtil.getKeyStrokeForCommandId(
        "com.devepos.adt.base.ui.filter.openValueHelp", //$NON-NLS-1$
        DEFAULT_VH_DIALOG_KEYSTROKE);
  }

  private void addValueHelpTriggerListener(final Text control,
      final ISearchPatternAnalyzer patternAnalyzer) {
    control.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {
        if (SWTKeySupport.convertKeyStrokeToAccelerator(vhDialogTriggerKeyStroke) != SWTKeySupport
            .convertEventToUnmodifiedAccelerator(e)) {
          return;
        }
        var cursorPosition = control.getCaretPosition();
        var content = control.getText().substring(0, cursorPosition);

        if (!patternAnalyzer.isFilterProposal(content)) {
          return;
        }
        var searchFilter = patternAnalyzer.getFilterFromQuery(content);
        if (searchFilter == null || searchFilter instanceof BooleanSearchFilter
            || searchFilter instanceof DateSearchFilter) {
          return;
        }
        var queryForProposals = patternAnalyzer
            .getCurrentFilterProposalQuery(searchFilter.getLabel(), content);
        var dialog = new SearchFilterValueSelectionDialog(control.getShell(), true,
            queryForProposals, searchFilter, (ITextQueryProposalProvider) searchFilter);
        if (dialog.open() == Window.OK) {
          var buffer = new StringBuilder(
              content.substring(0, content.length() - queryForProposals.length()));

          var index = 0;
          for (var selectedElement : dialog.getResult()) {
            if (index++ > 0) {
              buffer.append(",");
            }
            if (dialog.isNegated()) {
              buffer.append(StringUtil.NEGATION1);
            }
            buffer.append(selectedElement.getContent());
          }
          var newCursorPosition = buffer.length();
          // append the rest of the input
          buffer.append(control.getText().substring(cursorPosition));

          control.setText(buffer.toString());
          control.setSelection(newCursorPosition);
        }
      }
    });
  }

  /*
   * Creates proposal provider by using the given pattern analyzer
   */
  private static ITextQueryProposalProvider createQueryProposalProvider(
      final ISearchPatternAnalyzer patternAnalyzer) {
    return query -> patternAnalyzer.getProposals(query);
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

}
