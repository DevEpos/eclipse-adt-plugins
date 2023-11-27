package com.devepos.adt.base.ui.search.contentassist;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.util.StringUtil;

/**
 * Label provider input fields that have content assist support
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFilterLabelProvider extends LabelProvider implements IStyledLabelProvider {

  private boolean hideDescription;

  public SearchFilterLabelProvider() {
    this(false);
  }

  public SearchFilterLabelProvider(boolean hideDescription) {
    this.hideDescription = hideDescription;
  }

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
      final var proposal = (SearchFilterProposal) element;
      var label = proposal.getLabel();
      if (!hideDescription) {
        var shortDescription = proposal.getShortDescription();
        if (shortDescription != null) {
          label = String.format("%s (%s)", label, shortDescription);
        }
      }
      return label;
    }
    if (element instanceof SearchFilterValueProposal) {
      final var proposal = (SearchFilterValueProposal) element;
      String result = proposal.getLabel();
      if (!hideDescription) {
        final String shortText = proposal.getShortText();
        if (shortText != null && !shortText.isEmpty()) {
          result = String.valueOf(result) + " (" + shortText + ")";
        }
      }
      return result;
    }
    if (element instanceof IContentProposal) {
      final var proposal = (IContentProposal) element;
      return proposal.getLabel();
    }
    return null;
  }

  @Override
  public StyledString getStyledText(Object element) {
    if (element instanceof SearchFilterProposal) {
      var styledLabel = new StyledString();
      final var proposal = (SearchFilterProposal) element;
      styledLabel.append(proposal.getLabel());
      if (!hideDescription) {
        var shortDescription = proposal.getShortDescription();
        if (shortDescription != null) {
          styledLabel.append(" ");
          styledLabel.append(shortDescription, StylerFactory.DESCRIPTION_STYLER);
        }
      }
      return styledLabel;
    }
    if (element instanceof SearchFilterValueProposal) {
      var styledLabel = new StyledString();
      final var proposal = (SearchFilterValueProposal) element;
      styledLabel.append(proposal.getLabel());
      if (!hideDescription) {
        final String shortText = proposal.getShortText();
        if (!StringUtil.isEmpty(shortText)) {
          styledLabel.append(" ");
          styledLabel.append(shortText, StylerFactory.DESCRIPTION_STYLER);
        }
      }
      return styledLabel;
    }
    if (element instanceof IContentProposal) {
      var styledLabel = new StyledString();
      final IContentProposal proposal = (IContentProposal) element;
      styledLabel.append(proposal.getLabel());
      return styledLabel;
    }
    return null;
  }
}
