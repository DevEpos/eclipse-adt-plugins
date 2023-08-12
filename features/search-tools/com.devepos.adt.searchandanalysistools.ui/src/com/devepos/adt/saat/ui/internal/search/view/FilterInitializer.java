package com.devepos.adt.saat.ui.internal.search.view;

import java.util.stream.Collectors;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.nameditem.INamedItem;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.SearchFilter;
import com.devepos.adt.base.ui.search.contentassist.BooleanSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.DateSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.FixedNamedItemSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.KeyValueNamedItemFilter;
import com.devepos.adt.base.ui.search.contentassist.NamedItemFilter;
import com.devepos.adt.base.ui.search.contentassist.RisQuickSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.UserSearchFilter;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.saat.model.objectsearch.IContentAssist;
import com.devepos.adt.saat.model.objectsearch.IFixedValuesContentAssist;
import com.devepos.adt.saat.model.objectsearch.IImageInfo;
import com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist;
import com.devepos.adt.saat.model.objectsearch.IRisContentAssist;
import com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig;
import com.devepos.adt.saat.model.objectsearch.IUserContentAssist;
import com.devepos.adt.saat.model.objectsearch.ImageRegistryId;
import com.devepos.adt.saat.model.objectsearch.ProposalImageSource;
import com.devepos.adt.saat.search.ObjectSearchServiceFactory;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;

/**
 * Initializer for content assist filter
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class FilterInitializer {

  private final ISearchFilterConfig filterConfig;
  private final IAbapProjectProvider projectProvider;

  public FilterInitializer(final ISearchFilterConfig filterConfig,
      final IAbapProjectProvider projectProvider) {
    this.filterConfig = filterConfig;
    this.projectProvider = projectProvider;
  }

  public ISearchFilter createFilter() {
    // 1) first check the data type to narrow down the necessary search filter class
    switch (filterConfig.getDataType()) {
    case BOOLEAN:
      return new BooleanSearchFilter(filterConfig.getName(), filterConfig.getDescription(),
          filterConfig.getLongDescription(), getFilterImage());
    case DATE:
      return new DateSearchFilter(filterConfig.getName(), filterConfig.getDescription(),
          filterConfig.getLongDescription(), getFilterImage());
    case DEFAULT:
      break;
    }

    // 2) Now we consider the content assist instance (if available) to create an appropriate filter
    var contentAssist = filterConfig.getContentAssist();
    if (contentAssist instanceof IUserContentAssist) {
      return createUserFilter((IUserContentAssist) contentAssist);
    }
    if (contentAssist instanceof IRisContentAssist) {
      return createRisQuickFilter((IRisContentAssist) contentAssist);
    }
    if (contentAssist instanceof INamedItemContentAssist) {
      return createNamedItemFilter((INamedItemContentAssist) contentAssist);
    }
    if (contentAssist instanceof IFixedValuesContentAssist) {
      return createFixedNamedItemFilter((IFixedValuesContentAssist) contentAssist);
    }
    // 3) Still no search filter created means a standard text search filter without any proposal
    // support
    return new SearchFilter(filterConfig.getName(), filterConfig.getDescription(), filterConfig
        .getLongDescription(), getFilterImage(), filterConfig.isWildcardsAllowed(), filterConfig
            .isMultiple(), filterConfig.isNegatable());
  }

  private ISearchFilter createFixedNamedItemFilter(final IFixedValuesContentAssist contentAssist) {
    if (contentAssist.getProposals().isEmpty()) {
      throw new IllegalArgumentException(
          "A Fixed Values Search filter cannot have an empty proposals list!");
    }
    var filter = new FixedNamedItemSearchFilter(filterConfig.getName(), filterConfig
        .getDescription(), filterConfig.getLongDescription(), getFilterImage(), filterConfig
            .isMultiple(), filterConfig.isNegatable(), contentAssist.getProposals()
                .stream()
                .map(p -> INamedItem.createNamedItem(p.getName(), p.getDescription(), null))
                .collect(Collectors.toList()));
    filter.setProposalImageProvider(createImageProvider(contentAssist));
    return filter;
  }

  private IImageProvider createImageProvider(final IContentAssist contentAssist) {
    var source = contentAssist.getProposalImageSource();
    if (source == ProposalImageSource.SAME_AS_FILTER) {
      return new ProposalImageProvider(null, getFilterImage());
    }
    if (source == ProposalImageSource.PROPOSAL) {
      if (contentAssist.getProposalImageRegistryId() != ImageRegistryId.CALLING_PLUGIN) {
        return new ProposalImageProvider(contentAssist.getProposalImageRegistryId());
      }
      if (!contentAssist.getProposalImages().isEmpty()) {
        for (var image : contentAssist.getProposalImages()) {
          registerImage(image);
        }
        return new ProposalImageProvider(contentAssist.getProposalImageRegistryId());
      }
    } else if (source == ProposalImageSource.FIXED && contentAssist.getProposalImages()
        .size() == 1) {
      return new ProposalImageProvider(registerImage(contentAssist.getProposalImages().get(0)));
    }
    return null;
  }

  private ISearchFilter createNamedItemFilter(final INamedItemContentAssist contentAssist) {
    NamedItemFilter filter = null;
    if (filterConfig.isKeyValuePair() && contentAssist.getSecondaryCategoryTerm() != null) {
      filter = new KeyValueNamedItemFilter(projectProvider, ObjectSearchServiceFactory
          .getSearchService()
          .getNamedItemUriTemplateProvider(projectProvider), INamedItemType.create(contentAssist
              .getCategoryTerm(), false, contentAssist.isCachingPossible()), INamedItemType.create(
                  contentAssist.getSecondaryCategoryTerm(), false, false), filterConfig.getName(),
          null);
    } else {
      filter = new NamedItemFilter(projectProvider, ObjectSearchServiceFactory.getSearchService()
          .getNamedItemUriTemplateProvider(projectProvider), INamedItemType.create(contentAssist
              .getCategoryTerm(), false, contentAssist.isCachingPossible()), filterConfig.getName(),
          null);
    }
    filter.setDescription(filterConfig.getDescription());
    filter.setLongDescription(filterConfig.getLongDescription());
    filter.setProposalImageProvider(createImageProvider(contentAssist));
    filter.setImage(getFilterImage());
    filter.setSupportsPatternValues(filterConfig.isWildcardsAllowed());
    filter.setSupportsNegatedValues(filterConfig.isNegatable());
    filter.setSupportsMultipleValues(filterConfig.isMultiple());
    return filter;
  }

  private ISearchFilter createRisQuickFilter(final IRisContentAssist contentAssist) {
    var risFilter = new RisQuickSearchFilter(projectProvider, filterConfig.getName(),
        getFilterImage(), contentAssist.getObjectTypes().toArray(new String[0]));
    risFilter.setDescription(filterConfig.getDescription());
    risFilter.setLongDescription(filterConfig.getLongDescription());
    risFilter.setSupportsNegatedValues(filterConfig.isNegatable());
    risFilter.setSupportsPatternValues(filterConfig.isWildcardsAllowed());
    risFilter.setSupportsMultipleValues(filterConfig.isMultiple());
    return risFilter;
  }

  private ISearchFilter createUserFilter(final IUserContentAssist contentAssist) {
    var userFilter = new UserSearchFilter(projectProvider, filterConfig.getName(), filterConfig
        .getDescription(), filterConfig.getLongDescription());
    var filterImage = getFilterImage();
    if (filterImage != null) {
      userFilter.setImage(filterImage);
    }
    return userFilter;
  }

  private Image getFilterImage() {
    return registerImage(filterConfig.getImageInfo());
  }

  private Image registerImage(final IImageInfo imageInfo) {
    if (imageInfo.getImageId() == null && imageInfo.getImageEncoded() == null) {
      return null;
    }
    var plugin = SearchAndAnalysisPlugin.getDefault();

    if (imageInfo.getImageRegistryId() != null) {
      var registryId = imageInfo.getImageRegistryId();
      if (registryId == ImageRegistryId.ADT_OBJECT_TYPE) {
        return AdtTypeUtil.getInstance().getTypeImage(imageInfo.getImageId());
      }
    }

    Image image = plugin.getImage(imageInfo.getImageId());
    if (image == null) {
      image = plugin.registerEncodedImage(imageInfo.getImageId(), imageInfo.getImageEncoded());
      // clear encoded image from buffer to reduce memory
      imageInfo.setImageEncoded(null);
    }
    return image;

  }

}