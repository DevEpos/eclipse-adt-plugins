package com.devepos.adt.cst.ui.internal.codesearch.contentassist;

import java.text.MessageFormat;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.search.contentassist.NamedItemFilter;
import com.devepos.adt.cst.ui.internal.codesearch.FilterName;
import com.devepos.adt.cst.ui.internal.messages.Messages;

/**
 * Search filter for transport request/task
 * 
 * @author Ludwig Stockbauer-Muhr
 */
public class TransportRequestSearchFilter extends NamedItemFilter {

  public TransportRequestSearchFilter(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType) {
    super(projectProvider, uriTemplateProvider, namedItemType,
        FilterName.TRANSPORT_REQUEST.getContentAssistName(), (String) null);
    setProposalImageProvider(this::getImage);
    setDescription(Messages.SearchFilters_transportRequestFilterShortDescription_xmsg);
    setLongDescription(
        MessageFormat.format(Messages.SearchFilters_transportRequestFilterDescription_xmsg,
            FilterName.TRANSPORT_REQUEST.getContentAssistName(), "a4hk903065")); //$NON-NLS-1$
    setSupportsMultipleValues(true);
    setSupportsPatternValues(true);
  }
}