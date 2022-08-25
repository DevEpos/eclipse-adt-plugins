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
import com.sap.adt.tools.core.AbapCore;
import com.sap.adt.tools.core.system.IAbapSystemInfo;
import com.sap.adt.tools.core.system.IUser;

/**
 * Search filter for "owner"
 *
 * @author stockbal
 */
@SuppressWarnings("restriction")
public class UserSearchFilter implements ISearchFilter, ITextQueryProposalProvider {

  private final IAbapProjectProvider projectProvider;
  private final Image image;
  private Image proposalImage;
  private String filterLabel;

  public UserSearchFilter(final IAbapProjectProvider projectProvider, final String filterLabel) {
    this.projectProvider = projectProvider;
    this.filterLabel = filterLabel;
    image = AdtBaseUIResources.getImage(IAdtBaseImages.USER);
  }

  @Override
  public String getDescription() {
    return NLS.bind(Messages.SearchFilter_DescriptionUserFilter_xmsg, new Object[] { filterLabel,
        "smith" });
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public String getLabel() {
    return filterLabel;
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    final List<IContentProposal> proposals = new ArrayList<>();
    try {
      final List<IUser> users = getUsers(query);
      if (users != null) {
        for (final IUser user : users) {
          proposals.add(new SearchFilterValueProposal(user.getId(), this, user.getText(), query,
              getProposalImage()));
          if (proposals.size() >= 50) {
            break;
          }
        }
      }
    } catch (final Exception e) {
      final IStatus status = new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, e.getMessage());
      throw new CoreException(status);
    }
    return proposals;
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
        users = systemInfo.getUsers(new NullProgressMonitor(), String.valueOf(query) + "*", 50);
      }
    } catch (final OperationCanceledException ex) {
    }
    return users;
  }
}
