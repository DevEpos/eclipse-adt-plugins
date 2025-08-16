package com.devepos.adt.base.ui.search.contentassist;

import java.text.MessageFormat;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.internal.messages.Messages;

public class APIStateSearchFilter extends NamedItemFilter {

  public static final String FILTER_NAME = "api"; //$NON-NLS-1$

  /**
   * Creates new search filter for API State
   *
   * @param projectProvider     provider for ABAP project
   * @param uriTemplateProvider URI template provider
   * @param namedItemType       the named item type for the search filter
   */
  public APIStateSearchFilter(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType) {
    super(projectProvider, uriTemplateProvider, namedItemType, FILTER_NAME, null);
    setProposalImageProvider(new ProposalImageProvider());
    setDescription(Messages.APIStateSearchFilter_Description_xlbl);
    setLongDescription(
        MessageFormat.format(Messages.SearchFilter_DescriptionRisQuickSearchFilter_xmsg, getLabel(),
            Messages.APIStateSearchFilter_Description_xlbl, "released")); //$NON-NLS-1$
    setSupportsNegatedValues(true);
    setSupportsPatternValues(false);
  }

  private class ProposalImageProvider implements IImageProvider {

    @Override
    public Image getImage() {
      return APIStateSearchFilter.this.getImage();
    }

  }
}
