package com.devepos.adt.base.ui.search.contentassist;

import java.util.Locale;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.IImageProvider;

/**
 * Describes a proposal of a value for a specific search filter <br>
 * e.g.: <strong>owner:smith</strong>
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFilterValueProposal implements IContentProposal, IImageProvider {
  private final String key;
  private final String filterName;
  private final String description;
  private final String wordToComplete;
  private final String longText;
  private Image image;
  private IImageProvider imageProvider;

  /**
   * Creates new search filter value proposal with the given name and description
   *
   * @param key            the key of the proposal
   * @param filterName     the filter name for the filter proposal e.g.
   *                       <strong>owner</strong>
   * @param description    the description of the proposal
   * @param wordToComplete the prefix that triggered the proposal
   * @param image          the image to be displayed for the proposal
   */
  public SearchFilterValueProposal(final String key, final String filterName,
      final String description, final String wordToComplete, final Image image) {
    this(key, filterName, description, null, wordToComplete, image, null);
  }

  /**
   * Creates new search filter value proposal with the given name and description
   *
   * @param key            the key of the proposal
   * @param filterName     the filter name for the filter proposal e.g.
   *                       <strong>owner</strong>
   * @param description    the description of the proposal
   * @param wordToComplete the prefix that triggered the proposal
   * @param imageProvider  the provider to be queried for an image of the proposal
   */
  public SearchFilterValueProposal(final String key, final String filterName,
      final String description, final String wordToComplete, final IImageProvider imageProvider) {
    this(key, filterName, description, null, wordToComplete, null, imageProvider);
  }

  /**
   * Creates new search filter value proposal with the given name and description
   *
   * @param key            the key of the proposal
   * @param filterName     the filter name for the filter proposal e.g.
   *                       <strong>owner</strong>
   * @param description    the description of the proposal
   * @param wordToComplete the prefix that triggered the proposal
   */
  public SearchFilterValueProposal(final String key, final String filterName,
      final String description, final String wordToComplete) {
    this(key, filterName, description, null, wordToComplete, null, null);
  }

  /**
   * Creates new search filter value proposal with the given name and description
   *
   * @param key            the key of the proposal
   * @param filterName     the filter name for the filter proposal e.g.
   *                       <strong>owner</strong>
   * @param description    the description of the proposal
   * @param longText       the long text of the filter proposal
   * @param wordToComplete the prefix that triggered the proposal
   * @param image          the image for the proposal
   * @param imageProvider  the provider to be queried for an image of the proposal
   */
  public SearchFilterValueProposal(final String key, final String filterName,
      final String description, final String longText, final String wordToComplete,
      final Image image, final IImageProvider imageProvider) {
    this.key = key;
    this.filterName = filterName;
    this.longText = longText;
    this.description = description;
    this.wordToComplete = wordToComplete;
    this.image = image;
    this.imageProvider = imageProvider;
  }

  @Override
  public String getContent() {
    String content = String.valueOf(key.toLowerCase(Locale.ENGLISH));
    if (wordToComplete != null && !wordToComplete.isEmpty() && content.startsWith(wordToComplete
        .toLowerCase())) {
      content = content.substring(wordToComplete.length());
    }
    return content;
  }

  /**
   * Sets an proxy image provider
   *
   * @param imageProvider the image provider to be used
   */
  public final void setImageProvider(final IImageProvider imageProvider) {
    this.imageProvider = imageProvider;
  }

  /**
   * Retrieve the lexeme which triggered the proposals
   *
   * @return
   */
  public String getLexeme() {
    return wordToComplete;
  }

  @Override
  public int getCursorPosition() {
    return getContent().length();
  }

  @Override
  public String getLabel() {
    return key;
  }

  /**
   * Retrieve the key String of the proposal
   *
   * @return
   */
  public String getKey() {
    return key;
  }

  /**
   * Retrieve a short description of the proposal
   *
   * @return
   */
  public String getShortText() {
    return description;
  }

  @Override
  public String getDescription() {
    return longText;
  }

  /**
   * Returns the name of the search filter this proposal was fetch for
   *
   * @return the search filter name
   */
  public String getFilterName() {
    return filterName;
  }

  @Override
  public Image getImage() {
    if (image != null) {
      return image;
    }
    if (imageProvider != null) {
      return imageProvider.getImage();
    }
    return null;
  }
}
