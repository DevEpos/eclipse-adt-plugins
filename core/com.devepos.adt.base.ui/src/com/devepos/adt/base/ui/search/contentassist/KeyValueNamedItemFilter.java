package com.devepos.adt.base.ui.search.contentassist;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItemService;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.contentassist.ProposalContentStyle;
import com.devepos.adt.base.ui.internal.nameditem.InternalNamedItemProposalProvider;
import com.devepos.adt.base.util.IValidator;
import com.devepos.adt.base.util.StringUtil;

/**
 * Named item filter that supports
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class KeyValueNamedItemFilter extends NamedItemFilter implements IValidator {

  private static final String KEY_VAL_SEPARATOR = "="; //$NON-NLS-1$
  private InternalNamedItemProposalProvider valuePartProposalProvider;

  /**
   * Creates a search filter instance that uses the {@link INamedItemService} to
   * retrieve proposals. <br>
   * The default implementation of this filter supports <em>multiple values</em>,
   * <em>negated values</em> and <em>pattern values</em>. <br>
   * Additionally this filter
   *
   * @param projectProvider     provides project/destination for named item
   *                            queries
   * @param uriTemplateProvider provides URI templates to be used for accessing
   *                            the named item service
   * @param filterName          the filter name to be used for the found named
   *                            items
   * @param namedItemType       the main named item part for the proposals
   * @param valuePartItemType   the named item type for the value part (i.e
   *                            &lt;key&gt;=&lt;value&gt;)
   * @param initialQuery        initial query String, used to get proposals. <br>
   *                            Has no effect if <code>isBuffered</code> is
   *                            <code>false</code>
   */
  public KeyValueNamedItemFilter(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType,
      final INamedItemType valuePartItemType, final String filterName, final String initialQuery) {
    super(projectProvider, uriTemplateProvider, namedItemType, filterName, initialQuery);

    valuePartProposalProvider = new InternalNamedItemProposalProvider(projectProvider,
        uriTemplateProvider, valuePartItemType, null);
    valuePartProposalProvider.setNamedItemConverter((item, query) -> {
      var proposal = new SearchFilterValueProposal(item.getName(), this, item.getDescription(),
          query, proposalImageProvider);
      proposal.setData(item);
      return proposal;
    });
    valuePartProposalProvider.setProposalContentStyle(ProposalContentStyle.INSERT);
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    // check if key/value separator is included in query
    if (query != null && query.contains(KEY_VAL_SEPARATOR)) {
      final String queryToAnalyze = query + "%"; //$NON-NLS-1$
      final String[] queryParts = queryToAnalyze.split(KEY_VAL_SEPARATOR);
      if (queryParts.length != 2) {
        return null;
      }
      final String valueQuery = StringUtil.removeNegationCharacter(queryParts[1].replaceAll("%", //$NON-NLS-1$
          "")); //$NON-NLS-1$
      return valuePartProposalProvider.getProposals(valueQuery, StringUtil.removeNegationCharacter(
          queryParts[0]));
    }
    return super.getProposalList(query);
  }

  @Override
  public void validate(final Object value) throws CoreException {
    final String annoFilterValue = (String) value;
    if (annoFilterValue.contains(KEY_VAL_SEPARATOR)) {
      final String[] queryParts = annoFilterValue.split(KEY_VAL_SEPARATOR);
      if (queryParts.length != 2) {
        return;
      }

      final String annoKey = queryParts[0];

      if (StringUtil.startsWithNegationCharacter(annoKey)) {
        throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, NLS.bind(
            "Value Part is not allowed as Key Part of ''{0}'' is already negated", getLabel())));
      }

    }

  }

}
