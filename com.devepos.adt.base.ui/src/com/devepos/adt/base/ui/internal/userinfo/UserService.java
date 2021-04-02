package com.devepos.adt.base.ui.internal.userinfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.devepos.adt.base.ui.userinfo.IUserService;
import com.sap.adt.tools.core.system.IUser;

/**
 * Implementation of User Service
 *
 * @author stockbal
 */
@SuppressWarnings("restriction")
public class UserService implements IUserService {

    @Override
    public List<String> showUserSelectionDialog(final Shell parent, final String title, final boolean multi,
        final List<String> initialUsers, final String destinationId) {
        final UserNameSelectionDialog userDialog = new UserNameSelectionDialog(parent, title, multi, initialUsers,
            destinationId);
        if (userDialog.open() == Window.OK) {
            if (multi) {
                return userDialog.getResult().stream().map(IUser::getId).collect(Collectors.toList());
            }
            return Arrays.asList(userDialog.getFirstResult().getId());
        }
        return null;
    }

}
