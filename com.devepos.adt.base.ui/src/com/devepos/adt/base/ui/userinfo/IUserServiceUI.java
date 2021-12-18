package com.devepos.adt.base.ui.userinfo;

import java.util.List;

import org.eclipse.swt.widgets.Shell;

import com.devepos.adt.base.model.adtbase.IUser;

/**
 * User Service UI
 *
 * @author stockbal
 */
public interface IUserServiceUI {

  /**
   * Shows dialog for selecting users. If {@code multi} is set to {@code true} a
   * split result viewer is used to collect and display the currently selected
   * users.
   *
   * @param parent        the parent shell
   * @param title         title for the dialog
   * @param initialUsers  contains list of users that should be selected initially
   * @param excludedUsers list of user id's that should not be filtered out
   * @param destinationId the destination of an ABAP project
   * @param multi         if {@code true} multi selection of users is possible
   * @return a list of selected users
   */
  List<String> showUserSelectionDialog(Shell parent, String title, boolean multi,
      List<IUser> initialUsers, List<String> excludedUsers, String destinationId);
}
