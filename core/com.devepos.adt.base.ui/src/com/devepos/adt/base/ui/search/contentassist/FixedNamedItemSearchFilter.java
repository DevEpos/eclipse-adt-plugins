package com.devepos.adt.base.ui.search.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.nameditem.INamedItem;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.util.StringUtil;

/**
 * Search filter with a fixed list of named items that are returned as content proposals.
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class FixedNamedItemSearchFilter implements ISearchFilter, ITextQueryProposalProvider {

  private final Image image;
  private final String label;
  private final String description;
  private final List<INamedItem> proposalItems;
  private final boolean multiple;
  private final boolean negatable;
  private IImageProvider proposalImageProvider;
  private final String longDescription;

  public FixedNamedItemSearchFilter(final String label, final String description,
      final String longDescription, final Image image, final boolean multiple,
      final boolean negatable, final List<INamedItem> proposalItems) {
    this.label = label;
    this.description = description;
    this.longDescription = longDescription;
    this.image = image;
    this.multiple = multiple;
    this.negatable = negatable;
    this.proposalItems = proposalItems;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public String getLabel() {
    return label;
  }

  @Override
  public String getLongDescription() {
    return longDescription;
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    var pattern = StringUtil.getPatternForQuery(query, false);
    var resultIterator = proposalItems.stream()
        .filter(i -> pattern.matcher(i.getName()).matches()
            || (i.getDescription() != null && pattern.matcher(i.getDescription()).matches()))
        .iterator();

    if (resultIterator.hasNext()) {
      var results = new ArrayList<IContentProposal>();
      while (resultIterator.hasNext()) {
        var foundItem = resultIterator.next();
        var proposal = new SearchFilterValueProposal(foundItem.getName(), this,
            foundItem.getDescription(), NamedItemFilter.getDescriptionFromItem(foundItem.getData()),
            query, null, proposalImageProvider);
        proposal.setData(foundItem);
        results.add(proposal);
      }
      return results;
    }
    return null;
  }

  @Override
  public boolean isBuffered() {
    return true;
  }

  /**
   * Sets the image provider to be used for new proposals
   *
   * @param imageProvider an image provider
   */
  public final void setProposalImageProvider(final IImageProvider imageProvider) {
    proposalImageProvider = imageProvider;
  }

  @Override
  public boolean supportsMultipleValues() {
    return multiple;
  }

  @Override
  public boolean supportsNegatedValues() {
    return negatable;
  }

  @Override
  public boolean supportsPatternValues() {
    return false;
  }
}
