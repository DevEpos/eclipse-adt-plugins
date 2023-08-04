package com.devepos.adt.base.ui.search.contentassist;

import java.util.Locale;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.IImageProvider;

/**
 * Filter proposal like <strong>owner</strong>
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class SearchFilterProposal implements IContentProposal, IImageProvider {
  private final String name;
  private final Image image;
  private final String description;
  private final String longDescription;
  private final String wordToComplete;
  private final boolean hasProposalSupport;

  /**
   * Creates new search filter proposal with the given name and description
   *
   * @param name               the name of filter
   * @param image              the image to be displayed for the proposal
   * @param description        the description of the filter
   * @param longDescription    the long description of the filter
   * @param wordToComplete     the query String of the current proposal request
   * @param hasProposalSupport <code>true</code> if the filter filter support
   *                           automatic proposals
   */
  public SearchFilterProposal(final String name, final Image image, final String description,
      final String longDescription, final String wordToComplete, final boolean hasProposalSupport) {
    this.name = name;
    this.image = image;
    this.description = description;
    this.longDescription = longDescription;
    this.wordToComplete = wordToComplete;
    this.hasProposalSupport = hasProposalSupport;
  }

  @Override
  public String getContent() {
    String content = String.valueOf(name.toLowerCase(Locale.ENGLISH));
    if (wordToComplete != null && !wordToComplete.isEmpty()) {
      content = content.substring(wordToComplete.length());
    }
    final String proposalContent = content + ":";
    return proposalContent;
  }

  @Override
  public int getCursorPosition() {
    return getContent().length();
  }

  @Override
  public String getDescription() {
    return longDescription;
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public String getLabel() {
    return name;
  }

  public String getShortDescription() {
    return description;
  }

  public boolean hasProposalSupport() {
    return hasProposalSupport;
  }

}
