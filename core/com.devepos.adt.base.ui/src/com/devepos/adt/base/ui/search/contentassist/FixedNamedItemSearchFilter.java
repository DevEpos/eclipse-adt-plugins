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

  private Image image;
  private String label;
  private String description;
  private List<INamedItem> proposalItems;
  private boolean multiple;
  private boolean negatable;
  private IImageProvider proposalImageProvider;

  public FixedNamedItemSearchFilter(String label, String description, Image image, boolean multiple,
      boolean negatable, List<INamedItem> proposalItems) {
    this.label = label;
    this.description = description;
    this.image = image;
    this.multiple = multiple;
    this.negatable = negatable;
    this.proposalItems = proposalItems;
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
  public String getDescription() {
    return description;
  }

  @Override
  public boolean supportsPatternValues() {
    return false;
  }

  @Override
  public boolean isBuffered() {
    return true;
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
  public List<IContentProposal> getProposalList(String query) throws CoreException {
    var resultIterator = proposalItems.stream()
        .filter(i -> StringUtil.getPatternForQuery(query, false).matcher(i.getName()).matches())
        .iterator();

    if (resultIterator.hasNext()) {
      var results = new ArrayList<IContentProposal>();
      while (resultIterator.hasNext()) {
        var foundItem = resultIterator.next();
        var proposal = new SearchFilterValueProposal(foundItem.getName(), this, foundItem
            .getDescription(), null, query, null, proposalImageProvider);
        proposal.setData(foundItem);
        results.add(proposal);
      }
      return results;
    }
    return null;
  }

  /**
   * Sets the image provider to be used for new proposals
   *
   * @param imageProvider an image provider
   */
  public final void setProposalImageProvider(final IImageProvider imageProvider) {
    proposalImageProvider = imageProvider;
  }
}