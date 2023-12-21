package com.devepos.adt.cst.ui.internal.codesearch.contentassist;

import java.text.MessageFormat;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.search.contentassist.NamedItemFilter;

public class TransportRequestSearchFilter extends NamedItemFilter {
  private static final String FILTER_NAME = "corr";

  public TransportRequestSearchFilter(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType) {
    super(projectProvider, uriTemplateProvider, namedItemType, FILTER_NAME, (String) null);
    this.setProposalImageProvider(() -> this.getImage());
    this.setDescription("Transport task/request");
    this.setLongDescription(MessageFormat.format(
        "Use ''{0}'' to restrict the search query to objects contained in a specific transport request or task.\n\nExample:\n   {0} : a4hk903065",
        "corr"));
    this.setSupportsMultipleValues(true);
    this.setSupportsPatternValues(true);
  }
}