package com.devepos.adt.base.ui.search.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.sap.adt.ris.search.AdtRisQuickSearchFactory;
import com.sap.adt.ris.search.IAdtRisQuickSearch;
import com.sap.adt.ris.search.RisQuickSearchNotSupportedException;

/**
 * Generic Search filter
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class RisQuickSearchFilter implements ISearchFilter, ITextQueryProposalProvider {

  private final Image image;
  private final String filterName;
  private String destinationId;
  private IAdtRisQuickSearch searchProvider;
  private final IAbapProjectProvider projectProvider;
  private String description;
  private boolean supportsMultipleValues = true;
  private boolean supportsNegatedValues = false;
  private boolean supportsPatternValues = true;
  private final String[] objectTypes;
  private String longDescription;

  public RisQuickSearchFilter(final IAbapProjectProvider projectProvider, final String filterName,
      final Image filterImage, final String... objectTypes) {
    this.projectProvider = projectProvider;
    image = filterImage;
    this.filterName = filterName;
    this.objectTypes = objectTypes;
  }

  @Override
  public String getLongDescription() {
    return longDescription != null ? longDescription
        : NLS.bind(Messages.SearchFilter_DescriptionRisQuickSearchFilter_xmsg, new Object[] {
            filterName, "test" });
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
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    final List<IContentProposal> result = new ArrayList<>();
    try {
      getSearchProvider();
      if (searchProvider != null) {
        var searchResult = searchProvider.execute(String.valueOf(query) + "*", 50, false, true,
            objectTypes);
        if (searchResult != null) {
          for (final var objRef : searchResult) {
            result.add(new SearchFilterValueProposal(objRef.getName(), this, objRef
                .getDescription(), query, AdtTypeUtil.getInstance()
                    .getTypeImage(objRef.getType())));
          }
        }
      }
    } catch (final OperationCanceledException ex) {
    } catch (final Exception e) {
      final IStatus status = new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, e.getMessage());
      throw new CoreException(status);
    }

    return result;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public boolean isBuffered() {
    return false;
  }

  /**
   * Sets long description for the filter
   */
  public void setLongDescription(final String description) {
    longDescription = description;
  }

  /**
   * Sets short description of the filter
   */
  public void setDescription(final String description) {
    this.description = description;
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
  public boolean supportsMultipleValues() {
    return supportsMultipleValues;
  }

  @Override
  public boolean supportsNegatedValues() {
    return supportsNegatedValues;
  }

  @Override
  public boolean supportsPatternValues() {
    return supportsPatternValues;
  }

  /**
   * Retrieve provider for retrieving packages via QuickSearch service
   */
  private void getSearchProvider() {
    final String currentDestinationId = projectProvider.getDestinationId();
    if (destinationId == null || destinationId != currentDestinationId) {
      if (!projectProvider.ensureLoggedOn()) {
        destinationId = null;
        return;
      }
      destinationId = currentDestinationId;
      try {
        searchProvider = AdtRisQuickSearchFactory.createQuickSearch(destinationId,
            new NullProgressMonitor());
      } catch (final RisQuickSearchNotSupportedException ex) {
      }
    }
  }

}
