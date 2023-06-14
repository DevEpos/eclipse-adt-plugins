package com.devepos.adt.base.ui.internal.userinfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.devepos.adt.base.model.adtbase.IUser;
import com.devepos.adt.base.ui.userinfo.IUserServiceUI;

/**
 * Implementation of User Service
 *
 * @author stockbal
 */
public class UserServiceUI implements IUserServiceUI {

  @Override
  public List<String> showUserSelectionDialog(final Shell parent, final String title,
      final boolean multi, final List<IUser> initialUsers, final List<String> excludedUsers,
      final String destinationId) {
    final UserNameSelectionDialog userDialog = new UserNameSelectionDialog(parent, title, multi,
        initialUsers, excludedUsers, destinationId);
    if (userDialog.open() == Window.OK) {
      if (multi) {
        return userDialog.getResult().stream().map(IUser::getName).collect(Collectors.toList());
      }
      return Arrays.asList(userDialog.getFirstResult().getName());
    }
    return null;
  }

}
