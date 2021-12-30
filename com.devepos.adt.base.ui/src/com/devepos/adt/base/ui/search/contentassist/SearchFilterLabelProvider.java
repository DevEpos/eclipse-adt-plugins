package com.devepos.adt.base.ui.search.contentassist;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.IImageProvider;

/**
 * Label provider input fields that have content assist support
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFilterLabelProvider extends org.eclipse.jface.viewers.LabelProvider {

  @Override
  public Image getImage(final Object element) {
    if (element instanceof IImageProvider) {
      return ((IImageProvider) element).getImage();
    }
    return null;
  }

  @Override
  public String getText(final Object element) {
    if (element instanceof SearchFilterProposal) {
      final SearchFilterProposal proposal = (SearchFilterProposal) element;
      return proposal.getLabel();
    }
    if (element instanceof SearchFilterValueProposal) {
      final SearchFilterValueProposal proposal = (SearchFilterValueProposal) element;
      String result = proposal.getLabel();
      final String shortText = proposal.getShortText();
      if (shortText != null && !shortText.isEmpty()) {
        result = String.valueOf(result) + " (" + shortText + ")";
      }
      return result;
    }
    if (element instanceof IContentProposal) {
      final IContentProposal proposal = (IContentProposal) element;
      return proposal.getLabel();
    }
    return null;
  }
}
