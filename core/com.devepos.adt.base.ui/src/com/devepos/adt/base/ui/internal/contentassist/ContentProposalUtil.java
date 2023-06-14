package com.devepos.adt.base.ui.internal.contentassist;

import java.util.Locale;

public class ContentProposalUtil {

  /**
   * Returns proposal content for a given value and the triggering query which
   * computed the value
   *
   * @param proposalValue  the value of the content proposal
   * @param wordToComplete the query which computed the proposal value
   * @param caseSensitive  flag to indicate if the case of the proposal value is
   *                       important
   * @return the content which should be added to a content assist enabled text
   *         control
   */
  public static String getProposalContent(final String proposalValue, final String wordToComplete,
      final boolean caseSensitive) {
    return getProposalContent(proposalValue, wordToComplete, ProposalContentStyle.REPLACE,
        caseSensitive);
  }

  /**
   * Returns proposal content for a given value and the triggering query which
   * computed the value
   *
   * @param proposalValue        the value of the content proposal
   * @param wordToComplete       the query which computed the proposal value
   * @param proposalContentStyle determines the style of the proposal content
   * @param caseSensitive        flag to indicate if the case of the proposal
   *                             value is important
   * @return the content which should be added to a content assist enabled text
   *         control
   */
  public static String getProposalContent(final String proposalValue, final String wordToComplete,
      final ProposalContentStyle proposalContentStyle, final boolean caseSensitive) {
    String content = String.valueOf(caseSensitive ? proposalValue
        : proposalValue.toLowerCase(Locale.ENGLISH));

    if (proposalContentStyle == ProposalContentStyle.INSERT && wordToComplete != null
        && !wordToComplete.isEmpty() && content.startsWith(caseSensitive ? wordToComplete
            : wordToComplete.toLowerCase())) {
      content = content.substring(wordToComplete.length());
    }
    return content;
  }
}
