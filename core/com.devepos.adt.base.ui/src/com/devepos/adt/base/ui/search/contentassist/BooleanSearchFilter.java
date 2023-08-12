package com.devepos.adt.base.ui.search.contentassist;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;

/**
 * Search filter for providing boolean values, i.e. only {@code true} and {@code false} are allowed
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class BooleanSearchFilter implements ISearchFilter, ITextQueryProposalProvider {

  private final String label;
  private final String longDescription;
  private final String description;
  private final Image image;

  public BooleanSearchFilter(final String label, final String description,
      final String longDescription, final Image image) {
    this.label = label;
    this.description = description;
    this.longDescription = longDescription;
    this.image = image;
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
    return Arrays.asList(new SearchFilterValueProposal(Boolean.TRUE.toString(), this, null, null),
        new SearchFilterValueProposal(Boolean.FALSE.toString(), this, null, null));
  }

  @Override
  public boolean isBuffered() {
    return true;
  }

  @Override
  public boolean supportsMultipleValues() {
    return false;
  }

  @Override
  public boolean supportsNegatedValues() {
    return false;
  }

  @Override
  public boolean supportsPatternValues() {
    return false;
  }

}
