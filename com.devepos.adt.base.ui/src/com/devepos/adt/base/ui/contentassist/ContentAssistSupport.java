package com.devepos.adt.base.ui.contentassist;

import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItem;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.internal.contentassist.AsyncContentAssist;
import com.devepos.adt.base.ui.internal.contentassist.ContentAssist;
import com.devepos.adt.base.ui.internal.contentassist.ProposalContentStyle;
import com.devepos.adt.base.ui.internal.nameditem.NamedItemProposalProvider;
import com.devepos.adt.base.ui.internal.search.SearchPatternContentAssist;
import com.devepos.adt.base.ui.search.contentassist.ISearchPatternAnalyzer;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterLabelProvider;

/**
 * Provides static methods for creating/adding content assist to {@link Text}
 * controls.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public final class ContentAssistSupport {

  private ContentAssistSupport() {
    // prevent object creation
  }

  /**
   * Creates content assist for text controls that allow the input of complex
   * search patterns
   *
   * @param textControl     the text control to be used
   * @param patternAnalyzer the pattern analyzer
   * @return the added content assist instance to the {@code textControl}
   */
  public static IContentAssist createSearchFilterContentAssist(final Text textControl,
      final ISearchPatternAnalyzer patternAnalyzer) {
    IContentAssist contentAssist = new SearchPatternContentAssist(textControl, patternAnalyzer);
    contentAssist.setLabelProvider(new SearchFilterLabelProvider());
    return contentAssist;
  }

  /**
   * Creates content assist for the given text control.<br>
   * If it is expected that the proposal determination will take a long time, it
   * will be better to use
   * {@link #createAsyncContentAssist(Text, ITextQueryProposalProvider)} to
   * prevent unnecessary blocking of the UI thread.
   *
   * @param textControl      the text control to be used
   * @param proposalProvider provides the proposals to be shown in the content
   *                         assist popup
   * @return the added content assist instance to the {@code textControl}
   */
  public static IContentAssist createContentAssist(final Text textControl,
      final ITextQueryProposalProvider proposalProvider) {
    return new ContentAssist(textControl, proposalProvider);
  }

  /**
   * Creates content assist for the given text control.<br>
   * The proposals will be retrieved via the given
   * {@link ITextQueryProposalProvider} in a background job.
   *
   * @param textControl      the text control to be used
   * @param proposalProvider provides the proposals to be shown in the content
   *                         assist popup
   * @return the added content assist instance to the {@code textControl}
   */
  public static IContentAssist createAsyncContentAssist(final Text textControl,
      final ITextQueryProposalProvider proposalProvider) {
    return new AsyncContentAssist(textControl, proposalProvider);
  }

  /**
   * Creates content assist for the given text control.<br>
   *
   *
   * @param text                the control which needs content assist
   * @param projectProvider     provides ABAP project
   * @param uriTemplateProvider provides URI templates needed to determine
   *                            {@link INamedItem}s
   * @param namedItemType       the type definition to know which
   *                            {@link INamedItem}s should be retrieved
   * @param initialQuery
   * @return
   */
  public static IContentAssist createNamedItemContentAssist(final Text text,
      final IAbapProjectProvider projectProvider, final IAdtUriTemplateProvider uriTemplateProvider,
      final INamedItemType namedItemType, final String initialQuery) {

    NamedItemProposalProvider textQueryProvider = new NamedItemProposalProvider(text,
        projectProvider, uriTemplateProvider, namedItemType, initialQuery);
    textQueryProvider.setProposalContentStyle(ProposalContentStyle.REPLACE);

    AsyncContentAssist contentAssist = new AsyncContentAssist(text, textQueryProvider);
    contentAssist.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
    return contentAssist;
  }
}
