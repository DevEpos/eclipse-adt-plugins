package com.devepos.adt.base.ui.search.contentassist;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.internal.contentassist.ContentProposalUtil;
import com.devepos.adt.base.ui.search.ISearchFilter;

/**
 * Describes a proposal of a value for a specific search filter <br>
 * e.g.: <strong>owner:smith</strong>
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFilterValueProposal implements IContentProposal, IImageProvider {
  private final String key;
  private final ISearchFilter filter;
  private final String description;
  private final String wordToComplete;
  private final String longText;
  private final Image image;
  private Object data;
  private IImageProvider imageProvider;

  /**
   * Creates new search filter value proposal with the given name and description
   *
   * @param key            the key of the proposal
   * @param filter         the filter for this filter value
   * @param description    the description of the proposal
   * @param wordToComplete the prefix that triggered the proposal
   */
  public SearchFilterValueProposal(final String key, final ISearchFilter filter,
      final String description, final String wordToComplete) {
    this(key, filter, description, null, wordToComplete, null, null);
  }

  /**
   * Creates new search filter value proposal with the given name and description
   *
   * @param key            the key of the proposal
   * @param filter         the filter for this filter value
   * @param description    the description of the proposal
   * @param wordToComplete the prefix that triggered the proposal
   * @param imageProvider  the provider to be queried for an image of the proposal
   */
  public SearchFilterValueProposal(final String key, final ISearchFilter filter,
      final String description, final String wordToComplete, final IImageProvider imageProvider) {
    this(key, filter, description, null, wordToComplete, null, imageProvider);
  }

  /**
   * Creates new search filter value proposal with the given name and description
   *
   * @param key            the key of the proposal
   * @param filter         the filter for this filter value
   * @param description    the description of the proposal
   * @param wordToComplete the prefix that triggered the proposal
   * @param image          the image to be displayed for the proposal
   */
  public SearchFilterValueProposal(final String key, final ISearchFilter filter,
      final String description, final String wordToComplete, final Image image) {
    this(key, filter, description, null, wordToComplete, image, null);
  }

  /**
   * Creates new search filter value proposal with the given name and description
   *
   * @param key            the key of the proposal
   * @param filter         the filter for this filter value
   * @param description    the description of the proposal
   * @param longText       the long text of the filter proposal
   * @param wordToComplete the prefix that triggered the proposal
   * @param image          the image for the proposal
   * @param imageProvider  the provider to be queried for an image of the proposal
   */
  public SearchFilterValueProposal(final String key, final ISearchFilter filter,
      final String description, final String longText, final String wordToComplete,
      final Image image, final IImageProvider imageProvider) {
    this.key = key;
    this.filter = filter;
    this.longText = longText;
    this.description = description;
    this.wordToComplete = wordToComplete;
    this.image = image;
    this.imageProvider = imageProvider;
  }

  @Override
  public String getContent() {
    return ContentProposalUtil.getProposalContent(key, wordToComplete, filter.isCaseSensitive());
  }

  @Override
  public int getCursorPosition() {
    return getContent().length();
  }

  /**
   * Retrieves arbitrary data that was set on this proposal entry
   */
  public Object getData() {
    return data;
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
    return filter.getLabel();
  }

  @Override
  public Image getImage() {
    if (image != null) {
      return image;
    }
    if (imageProvider != null) {
      if (data != null) {
        return imageProvider.getImage(data);
      }
      return imageProvider.getImage();
    }
    return null;
  }

  /**
   * Retrieve the key String of the proposal
   *
   * @return
   */
  public String getKey() {
    return key;
  }

  @Override
  public String getLabel() {
    return key;
  }

  /**
   * Retrieve the lexeme which triggered the proposals
   *
   * @return
   */
  public String getLexeme() {
    return wordToComplete;
  }

  /**
   * Retrieve a short description of the proposal
   *
   * @return
   */
  public String getShortText() {
    return description;
  }

  /**
   * Sets arbitrary data on this proposal entry
   * 
   * @param data data to be set
   */
  public void setData(final Object data) {
    this.data = data;
  }

  /**
   * Sets an proxy image provider
   *
   * @param imageProvider the image provider to be used
   */
  public final void setImageProvider(final IImageProvider imageProvider) {
    this.imageProvider = imageProvider;
  }
}
