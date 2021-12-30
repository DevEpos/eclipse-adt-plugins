package com.devepos.adt.base.ui.search.contentassist;

import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.project.IAbapProjectProvider;

public class ApplicationComponentSearchFilter extends NamedItemFilter {

  public static final String FILTER_NAME = "appl"; //$NON-NLS-1$
  private Image image;

  /**
   * Creates new search filter for ABAP Application Component
   *
   * @param projectProvider     provider for ABAP project
   * @param uriTemplateProvider URI template provider
   * @param namedItemType       the named item type for the search filter
   */
  public ApplicationComponentSearchFilter(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType) {
    super(projectProvider, uriTemplateProvider, namedItemType, FILTER_NAME, false, null);
    setProposalImageProvider(new ProposalImageProvider());
    setDescription(NLS.bind(Messages.SearchFilter_DescriptionApplCompSearchFilter_xmsg,
        new Object[] { getLabel(), "IS-TEST" })); //$NON-NLS-1$
  }

  @Override
  public Image getImage() {
    if (image == null) {
      image = AdtBaseUIResources.getImage(IAdtBaseImages.APPLICATION_COMPONENT);
    }
    return image;
  }

  private class ProposalImageProvider implements IImageProvider {

    @Override
    public Image getImage() {
      return ApplicationComponentSearchFilter.this.getImage();
    }

  }
}
