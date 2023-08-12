package com.devepos.adt.base.ui.search.contentassist;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItemService;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.contentassist.ProposalContentStyle;
import com.devepos.adt.base.ui.internal.nameditem.InternalNamedItemProposalProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;

/**
 * Simple implementation of a search filter which retrieves its proposals via
 * the {@link INamedItemService}
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class NamedItemFilter implements ISearchFilter, ITextQueryProposalProvider {
  protected IImageProvider proposalImageProvider;
  private final INamedItemType namedItemType;
  private InternalNamedItemProposalProvider namedItemProposalProvider;
  /**
   * Indicates if the filter supports pattern values. The default value is
   * <code>true</code>
   */
  private boolean supportsPatternValues = true;
  /**
   * Indicates if the filter supports negated values. The default value is
   * <code>false</code>
   */
  private boolean supportsNegatedValues = false;
  /**
   * Indicates if the filter supports multiple values. The default value is
   * <code>true</code>
   */
  private boolean supportsMultipleValues = true;

  /**
   * The description of the filter, to be displayed in a side tooltip box in a
   * proposal popup
   */
  private String longDescription;

  /**
   * Short description, displayed in parenthesis next to the filter label
   */
  private String description;

  /**
   * The name of the filter
   */
  private final String filterName;

  /**
   * Image to be displayed alongside the filter in a proposal popup
   */
  private Image image;

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
      final String filterName, final String initialQuery) {
    this.namedItemType = namedItemType;
    this.filterName = filterName;

    initProposalProvider(projectProvider, uriTemplateProvider, initialQuery);

    if (namedItemType instanceof IImageProvider) {
      image = ((IImageProvider) namedItemType).getImage();
    }
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
    return filterName;
  }

  @Override
  public String getLongDescription() {
    return longDescription;
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    return namedItemProposalProvider.getProposals(query);
  }

  @Override
  public final boolean isBuffered() {
    return namedItemType.isBuffered();
  }

  @Override
  public final boolean isCaseSensitive() {
    return namedItemType.isCaseSensitive();
  }

  /**
   * Sets the short description for the filter
   *
   * @param description the description to set
   */
  public final void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the image for the filter
   *
   * @param image the image to set
   */
  public void setImage(final Image image) {
    this.image = image;
  }

  /**
   * Sets the long description for the filter
   *
   * @param description the description to set
   */
  public final void setLongDescription(final String description) {
    longDescription = description;
  }

  /**
   * Sets the image provider to be used for new proposals
   *
   * @param imageProvider an image provider
   */
  public final void setProposalImageProvider(final IImageProvider imageProvider) {
    proposalImageProvider = imageProvider;
  }

  /**
   * Sets the value for the <code>supportsMultipleValues</code> attribute.
   *
   * @param supportsMultipleValues if <code>true</code> the filter will support
   *                               multiple values
   */
  public final void setSupportsMultipleValues(final boolean supportsMultipleValues) {
    this.supportsMultipleValues = supportsMultipleValues;
  }

  /**
   * Sets the value for the <code>supportsNegatedValues</code> attribute.
   *
   * @param supportsNegatedValues if <code>true</code> the filter will support
   *                              negated values
   */
  public final void setSupportsNegatedValues(final boolean supportsNegatedValues) {
    this.supportsNegatedValues = supportsNegatedValues;
  }

  /**
   * Sets the value for the <code>supportsPatternValues</code> attribute.
   *
   * @param supportsPatternValues if <code>true</code> the filter will support
   *                              pattern values
   */
  public final void setSupportsPatternValues(final boolean supportsPatternValues) {
    this.supportsPatternValues = supportsPatternValues;
  }

  @Override
  public final boolean supportsMultipleValues() {
    return supportsMultipleValues;
  }

  @Override
  public final boolean supportsNegatedValues() {
    return supportsNegatedValues;
  }

  @Override
  public final boolean supportsPatternValues() {
    return supportsPatternValues;
  }

  /*
   * Retrieve long text information from description
   */
  private String getDescriptionFromItem(final String description) {
    if (description == null || description.isEmpty()) {
      return null;
    }
    final String[] itemDescrComponents = description.split("@@##@@"); //$NON-NLS-1$
    if (itemDescrComponents.length < 2) {
      return null;
    }

    final String longText = itemDescrComponents[1];
    final String[] longTextParts = longText.split("="); //$NON-NLS-1$
    if (longTextParts == null || longTextParts.length < 2) {
      return null;
    }
    return longTextParts[1];
  }

  private void initProposalProvider(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final String initialQuery) {
    namedItemProposalProvider = new InternalNamedItemProposalProvider(projectProvider,
        uriTemplateProvider, namedItemType, initialQuery);
    namedItemProposalProvider.setNamedItemConverter((item, query) -> {
      var proposal = new SearchFilterValueProposal(item.getName(), this, item.getDescription(),
          getDescriptionFromItem(item.getData()), query, null, proposalImageProvider);
      proposal.setData(item);
      return proposal;
    });
    namedItemProposalProvider.setProposalContentStyle(ProposalContentStyle.INSERT);
  }

}
