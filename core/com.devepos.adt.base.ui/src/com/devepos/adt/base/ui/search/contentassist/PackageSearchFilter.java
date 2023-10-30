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

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.sap.adt.ris.search.AdtRisQuickSearchFactory;
import com.sap.adt.ris.search.IAdtRisQuickSearch;
import com.sap.adt.ris.search.RisQuickSearchNotSupportedException;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Search filter for "package"
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class PackageSearchFilter implements ISearchFilter, ITextQueryProposalProvider {

  public static final String FILTER_NAME = "package";
  private final Image image;
  private String destinationId;
  private IAdtRisQuickSearch packageProvider;
  private final IAbapProjectProvider projectProvider;
  private Image proposalImage;

  public PackageSearchFilter(final IAbapProjectProvider projectProvider) {
    this.projectProvider = projectProvider;
    image = AdtBaseUIResources.getImage(IAdtBaseImages.PACKAGE);
  }

  @Override
  public String getDescription() {
    return Messages.PackageSearchFilter_filterName_xlbl;
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public String getLabel() {
    return FILTER_NAME;
  }

  @Override
  public String getLongDescription() {
    return NLS.bind(Messages.SearchFilter_DescriptionPackageFilter_xmsg,
        new Object[] { FILTER_NAME, "test" });
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    final List<IContentProposal> result = new ArrayList<>();
    try {
      getPackageProvider();
      if (packageProvider != null) {
        List<IAdtObjectReference> packageList = new ArrayList<>();
        packageList = packageProvider.execute(String.valueOf(query) + "*", 50, false, true,
            IAdtObjectTypeConstants.PACKAGE);
        if (packageList != null) {
          for (final IAdtObjectReference objRef : packageList) {
            result.add(new SearchFilterValueProposal(objRef.getName(), this,
                objRef.getDescription(), query, getProposalImage()));
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
  public boolean isBuffered() {
    return false;
  }

  @Override
  public boolean supportsMultipleValues() {
    return true;
  }

  @Override
  public boolean supportsNegatedValues() {
    return true;
  }

  @Override
  public boolean supportsPatternValues() {
    return true;
  }

  /**
   * Retrieve provider for retrieving packages via QuickSearch service
   */
  private void getPackageProvider() {
    final String currentDestinationId = projectProvider.getDestinationId();
    if (destinationId == null || destinationId != currentDestinationId) {
      if (!projectProvider.ensureLoggedOn()) {
        destinationId = null;
        return;
      }
      destinationId = currentDestinationId;
      try {
        packageProvider = AdtRisQuickSearchFactory.createQuickSearch(destinationId,
            new NullProgressMonitor());
      } catch (final RisQuickSearchNotSupportedException ex) {
      }
    }
  }

  private Image getProposalImage() {
    if (proposalImage == null) {
      proposalImage = AdtBaseUIResources.getImage(IAdtBaseImages.PACKAGE);
    }
    return proposalImage;
  }

}
