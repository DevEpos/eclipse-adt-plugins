package com.devepos.adt.base.ui.contentassist;

import org.eclipse.jface.fieldassist.IContentProposal;

import com.devepos.adt.base.ui.internal.contentassist.ContentProposalUtil;

/**
 * Simple implementation of {@link IContentProposal} for a text proposal
 * 
 * @author Ludwig Stockbauer-Muhr
 */
public class TextContentProposal implements IContentProposal {

  private final String content;
  private final String query;
  private final boolean caseSensitive;

  /**
   * Creates new text proposal with the given content and the triggering query
   *
   * @param content       the proposal content
   * @param query         the query that matches the proposal
   * @param caseSensitive if {@code false} the content will converted to lower case
   */
  public TextContentProposal(final String content, final String query,
      final boolean caseSensitive) {
    this.content = content;
    this.query = query;
    this.caseSensitive = caseSensitive;
  }

  @Override
  public String getContent() {
    return ContentProposalUtil.getProposalContent(content, query, caseSensitive);
  }

  @Override
  public int getCursorPosition() {
    return getContent().length();
  }

  @Override
  public String getLabel() {
    return content;
  }

  @Override
  public String getDescription() {
    return null;
  }

}
