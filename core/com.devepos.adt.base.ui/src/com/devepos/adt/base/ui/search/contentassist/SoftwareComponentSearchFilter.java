package com.devepos.adt.base.ui.search.contentassist;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.internal.messages.Messages;

public class SoftwareComponentSearchFilter extends NamedItemFilter {

  public static final String FILTER_NAME = "comp"; //$NON-NLS-1$

  /**
   * Creates new search filter for Software Component
   *
   * @param projectProvider     provider for ABAP project
   * @param uriTemplateProvider URI template provider
   * @param namedItemType       the named item type for the search filter
   */
  public SoftwareComponentSearchFilter(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType) {
    super(projectProvider, uriTemplateProvider, namedItemType, FILTER_NAME, null);
    setProposalImageProvider(new ProposalImageProvider());
    setDescription(Messages.SoftwareComponentSearchFilter_Description_xlbl);
    setLongDescription(Messages.SearchFilter_DescriptionSoftwareCompSearchFilter_xmsg);
    setSupportsNegatedValues(true);
    setSupportsPatternValues(false);
  }

  private class ProposalImageProvider implements IImageProvider {

    @Override
    public Image getImage() {
      return SoftwareComponentSearchFilter.this.getImage();
    }

  }
}
