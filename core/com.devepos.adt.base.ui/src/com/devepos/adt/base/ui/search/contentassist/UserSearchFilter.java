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
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.AbapCore;
import com.sap.adt.tools.core.system.IAbapSystemInfo;
import com.sap.adt.tools.core.system.IUser;

/**
 * Search filter for User (e.g. owner or changedby)
 *
 * @author Ludwig Stockbauer-Muhr
 */
@SuppressWarnings("restriction")
public class UserSearchFilter implements ISearchFilter, ITextQueryProposalProvider {

  public static final String LOGGED_ON_USER = "ME";

  private final IAbapProjectProvider projectProvider;
  private Image image;
  private Image proposalImage;
  private final String filterLabel;
  private final String description;
  private String longDescription;
  private final boolean includeMeValue;

  public UserSearchFilter(final IAbapProjectProvider projectProvider, final String filterLabel) {
    this(projectProvider, filterLabel, null, null, true);
  }

  public UserSearchFilter(final IAbapProjectProvider projectProvider, final String filterLabel,
      final String description, final String longDescription) {
    this(projectProvider, filterLabel, description, longDescription, true);
  }

  public UserSearchFilter(final IAbapProjectProvider projectProvider, final String filterLabel,
      final String description, final String longDescription, final boolean includeMeValue) {
    this.projectProvider = projectProvider;
    this.filterLabel = filterLabel;
    this.description = description;
    this.longDescription = longDescription;
    this.includeMeValue = includeMeValue;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public Image getImage() {
    if (image == null) {
      image = AdtBaseUIResources.getImage(IAdtBaseImages.USER);
    }
    return image;
  }

  @Override
  public String getLabel() {
    return filterLabel;
  }

  @Override
  public String getLongDescription() {
    if (longDescription == null) {
      longDescription = NLS.bind(Messages.SearchFilter_DescriptionUserFilter_xmsg,
          new Object[] { filterLabel, "smith" }); //$NON-NLS-1$
    }
    return longDescription;
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    final List<IContentProposal> proposals = new ArrayList<>();

    var proposalImage = getProposalImage();

    // add additional user 'me' which represents the currently logged on user
    if (includeMeValue
        && StringUtil.getPatternForQuery(query, false).matcher(LOGGED_ON_USER).matches()) {
      proposals.add(new SearchFilterValueProposal(LOGGED_ON_USER, this,
          Messages.UserSearchFilter_CurrentlyLoggedOnUser_xlbl, query, proposalImage));
    }

    try {
      final var users = getUsers(query);

      if (users != null) {
        for (final var user : users) {
          proposals.add(new SearchFilterValueProposal(user.getId(), this, user.getText(), query,
              proposalImage));
          if (proposals.size() > 50) {
            break;
          }
        }
      }
    } catch (final Exception e) {
      final var status = new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, e.getMessage());
      throw new CoreException(status);
    }
    return proposals;
  }

  @Override
  public boolean isBuffered() {
    return true;
  }

  @Override
  public boolean isBufferedValidationActive() {
    return false;
  }

  public void setImage(final Image image) {
    this.image = image;
  }

  public void setProposalImage(final Image image) {
    proposalImage = image;
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

  private Image getProposalImage() {
    if (proposalImage == null) {
      proposalImage = AdtBaseUIResources.getImage(IAdtBaseImages.USER_PROPS);
    }
    return proposalImage;
  }

  private List<IUser> getUsers(final String query) throws CoreException {
    List<IUser> users = null;
    try {
      final String destination = projectProvider.getDestinationId();
      if (destination != null && projectProvider.ensureLoggedOn()) {
        final IAbapSystemInfo systemInfo = AbapCore.getInstance().getAbapSystemInfo(destination);
        users = systemInfo.getUsers(new NullProgressMonitor(), String.valueOf(query) + "*", 50); //$NON-NLS-1$
      }
    } catch (final OperationCanceledException ex) {
    }
    return users;
  }
}
