package com.devepos.adt.base.ui.internal.nameditem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItem;
import com.devepos.adt.base.nameditem.INamedItemService;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.nameditem.NamedItemServiceFactory;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.contentassist.ContentProposalUtil;
import com.devepos.adt.base.ui.internal.contentassist.ProposalContentStyle;
import com.devepos.adt.base.util.StringUtil;

/**
 * Internal Proposal provider which uses the Named item service for data
 * retrieval.
 * <p>
 * The type of named item that should be read can be controlled by passing the
 * specific {@link INamedItemType} to the constructor.
 * </p>
 * <p>
 * If the named item type supports it this provider also implements a caching
 * mechanism to reduce the number of server calls via the named item service
 * </p>
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class InternalNamedItemProposalProvider {
  private static final int MAX_ITEMS = 50;
  private static final String WILDCARD = "*";
  protected String destinationId;
  protected final INamedItemType namedItemType;
  protected final IAbapProjectProvider projectProvider;
  private INamedItemConverter namedItemConverter;
  private INamedItemResultFilter namedItemResultFilter;
  private INamedItemService namedItemService;
  private ProposalContentStyle proposalContentStyle = ProposalContentStyle.INSERT;
  private Image proposalImage;
  private final IAdtUriTemplateProvider uriTemplateProvider;
  private final String initialQuery;

  /**
   * Create instance of the named item proposal provider
   *
   * @param projectProvider     provides project/destination for named item
   *                            queries
   * @param uriTemplateProvider provides URI templates to be used for accessing
   *                            the named item service
   * @param namedItemType       the type of named item to look for
   * @param initialQuery        the query to be used to fetch items from the
   *                            server - in case the named item type is buffered
   */
  public InternalNamedItemProposalProvider(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType,
      final String initialQuery) {
    this.projectProvider = projectProvider;
    this.namedItemType = namedItemType;
    this.uriTemplateProvider = uriTemplateProvider;
    this.initialQuery = initialQuery;

    /*
     * collect image from named item type to be used as the default image for
     * proposals
     */
    if (namedItemType instanceof IImageProvider) {
      proposalImage = ((IImageProvider) namedItemType).getImage();
    }
  }

  @FunctionalInterface
  public interface INamedItemConverter {
    /**
     * Converts the given named item to a content proposal
     *
     * @param namedItem the named item to convert
     * @param query     the query which computed the named item
     * @return the created content proposal
     */
    IContentProposal convert(INamedItem namedItem, String query);
  }

  @FunctionalInterface
  public interface INamedItemResultFilter {
    /**
     * Determines if a given named item should be kept or not.
     *
     * @param namedItem the named item to be checked
     * @param query     the query that computed the named item
     * @return {@code true} if the named item should be kept in the result
     */
    boolean filter(INamedItem namedItem, String query);
  }

  private class NamedItemContentProposal implements IContentProposal, IImageProvider {

    private String content;
    private final INamedItem namedItem;
    private final String wordToComplete;

    public NamedItemContentProposal(final INamedItem namedItem, final String wordToComplete) {
      this.namedItem = namedItem;
      this.wordToComplete = wordToComplete;
    }

    @Override
    public String getContent() {
      if (content == null) {
        content = ContentProposalUtil.getProposalContent(namedItem.getName(), wordToComplete,
            proposalContentStyle, namedItemType.isCaseSensitive());
      }
      return content;
    }

    @Override
    public int getCursorPosition() {
      return getContent().length();
    }

    @Override
    public String getDescription() {
      String description = namedItem.getDescription();
      return description != null && !description.isBlank() ? description : null;
    }

    @Override
    public Image getImage() {
      return proposalImage;
    }

    @Override
    public String getLabel() {
      return namedItem.getName();
    }

  }

  /**
   * Gets a list of named items which match the given query string.<br>
   * If the query string is empty a maximum of 50 named items will be
   * retrieved.<br>
   * If caching is enabled in the {@link INamedItemType}, the
   * <code>initialQuery</code> which was passed in the Constructor of the
   * Provider, will be used to fetch the named items from the server. The passed
   * <code>query</code> will then be used to filter the received results.
   *
   * @param query      optional query to restrict results
   * @param dataFilter optional filter to restrict results to NamedItems which a
   *                   certain <code>data</code> value
   * @return the list of named items converted into {@link IContentProposal}s
   * @throws CoreException
   */
  public List<IContentProposal> getProposals(final String query) throws CoreException {
    return getProposals(query, null);
  }

  /**
   * Gets a list of named items which match the given query string.
   * <p>
   * If the query string is empty a maximum of 50 named items will be retrieved.
   * </p>
   * <p>
   * If caching is enabled in the {@link INamedItemType}, the
   * <code>initialQuery</code> which was passed in the Constructor of the
   * Provider, will be used to fetch the named items from the server. The passed
   * <code>query</code> will then be used to filter the received results.
   * </p>
   *
   * @param query      optional query to restrict results
   * @param dataFilter optional filter to restrict results to NamedItems which a
   *                   certain <code>data</code> value
   * @return the list of named items converted into {@link IContentProposal}s
   * @throws CoreException
   */
  public List<IContentProposal> getProposals(final String query, final String dataFilter)
      throws CoreException {
    final List<IContentProposal> result = new ArrayList<>();

    try {
      if (getNamedItemService()) {
        var namedItemResult = namedItemService.getNamedItems(namedItemType, MAX_ITEMS,
            getQueryString(query), null, dataFilter, initialQuery);

        if (namedItemResult != null) {
          if (namedItemType.isBuffered()) {
            namedItemResult = namedItemResult.stream()
                .filter(namedItem -> filterResult(namedItem, query))
                .collect(Collectors.toList());
          }

          for (final INamedItem item : namedItemResult) {
            result.add(createProposalFromNamedItem(item, query));
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

  /**
   * Sets a converter which is to be used to convert a {@link INamedItem} to a
   * {@link IContentProposal}.
   *
   * @param converter the converter instance
   */
  public void setNamedItemConverter(final INamedItemConverter converter) {
    namedItemConverter = converter;
  }

  /**
   * Sets a result filter which can be used to filter
   *
   * @param resultFilter
   */
  public void setNamedItemResultFilter(final INamedItemResultFilter resultFilter) {
    namedItemResultFilter = resultFilter;
  }

  /**
   * Sets the proposal content style that will be used inside the default
   * {@link IContentProposal} implementation for a {@link INamedItem}. <br>
   * <strong>Note:</strong> Has no effect if a custom named item converter was set
   * via {@link #setNamedItemConverter(INamedItemConverter)}
   *
   * @param proposalContentStyle the style for the content of a proposal
   */
  public void setProposalContentStyle(final ProposalContentStyle proposalContentStyle) {
    this.proposalContentStyle = proposalContentStyle;
  }

  /**
   * Filters the given named item. If it should be included in the final result
   * the value <code>true</code> should be returned. The default implementation
   * considers only the <em>Name</em> attribute in the comparison. Clients should
   * override this method, if a more comprehensive filtering is needed
   *
   * @param namedItem the named item to be included/excluded
   * @return <code>true</code> if the named item should be included in the result
   */
  protected boolean filterResult(final INamedItem namedItem, final String query) {
    if (namedItemResultFilter != null) {
      return namedItemResultFilter.filter(namedItem, query);
    }
    if (query == null || query.isEmpty()) {
      return true;
    }
    return StringUtil.getPatternForQuery(query, namedItemType.isCaseSensitive())
        .matcher(namedItem.getName())
        .matches();
  }

  /**
   * Creates new content proposal from the given named item
   *
   * @param item  the found named item
   * @param query query which was used to find the named item
   * @return the created content proposal
   */
  private IContentProposal createProposalFromNamedItem(final INamedItem item, final String query) {
    if (namedItemConverter != null) {
      return namedItemConverter.convert(item, query);
    }
    return new NamedItemContentProposal(item, query);
  }

  /**
   * Retrieve named item service for current project destination
   */
  private boolean getNamedItemService() {
    final String currentDestinationId = projectProvider.getDestinationId();
    if (destinationId == null || destinationId != currentDestinationId) {
      if (!projectProvider.ensureLoggedOn()) {
        destinationId = null;
        namedItemService = null;
        return false;
      }
      destinationId = currentDestinationId;
      namedItemService = NamedItemServiceFactory.createService(destinationId, uriTemplateProvider);
    }
    return namedItemService != null;
  }

  private String getQueryString(final String query) {
    String queryString = query;
    if (queryString == null) {
      return WILDCARD;
    }
    if (!queryString.endsWith(WILDCARD)) {
      queryString += WILDCARD;
    }
    return queryString;
  }
}
