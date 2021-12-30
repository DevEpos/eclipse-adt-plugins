package com.devepos.adt.base.ui.search.contentassist;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItemService;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.ui.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;

/**
 * Simple implementation of a search filter which retrieves its proposals via
 * the {@link INamedItemService}
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class NamedItemFilter extends NamedItemProposalProvider implements ISearchFilter,
    ISearchProposalProvider {
  private String description;
  private Image image;
  private final String initialQuery;

  /**
   * Creates a search filter instance that uses the {@link INamedItemService} to
   * retrieve proposals. <br>
   * The default implementation of this filter supports <em>multiple values</em>,
   * <em>negated values</em> and <em>pattern values</em>. <br>
   * To customize this behavior sub classes should override the appropriate
   * methods from {@link ISearchFilter}
   *
   * @param projectProvider     provides project/destination for named item
   *                            queries
   * @param uriTemplateProvider provides URI templates to be used for accessing
   *                            the named item service
   * @param filterName          the filter name to be used for the found named
   *                            items
   * @param namedItemType       the type of named item to look for
   * @param initialQuery        initial query String, used to get proposals. <br>
   *                            Has no effect if <code>isBuffered</code> is
   *                            <code>false</code>
   */
  public NamedItemFilter(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType,
      final String filterName, final boolean isBuffered, final String initialQuery) {
    super(projectProvider, uriTemplateProvider, filterName, namedItemType, isBuffered);
    this.initialQuery = initialQuery;
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    if (isCachingActive && initialQuery != null) {
      return getProposals(initialQuery, query);
    }
    return getProposals(query);
  }

  @Override
  public Image getImage() {
    return image;
  }

  /**
   * Sets the image for the filter
   *
   * @param image the image to set
   */
  public void setImage(final Image image) {
    this.image = image;
  }

  @Override
  public String getLabel() {
    return filterName;
  }

  @Override
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description for the filter
   *
   * @param description the description to set
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  @Override
  public boolean supportsPatternValues() {
    return true;
  }

  @Override
  public final boolean isBuffered() {
    return isCachingActive;
  }

  @Override
  public boolean supportsMultipleValues() {
    return true;
  }

  @Override
  public boolean supportsNegatedValues() {
    return false;
  }
}
