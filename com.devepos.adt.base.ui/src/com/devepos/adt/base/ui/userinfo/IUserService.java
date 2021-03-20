package com.devepos.adt.base.ui.userinfo;

import java.util.List;

import org.eclipse.swt.widgets.Shell;

/**
 * User Service
 *
 * @author stockbal
 */
public interface IUserService {

    /**
     * Shows dialog for selecting users. If {@code multi} is set to {@code true} a
     * split result viewer is used to collect and display the currently selected
     * users.
     * 
     * @param parent        the parent shell
     * @param title         title for the dialog
     * @param initialUsers  contains list of user id's that should be selected
     *                      initially
     * @param destinationId the destination of an ABAP project
     * @param multi         if {@code true} multi selection of users is possible
     * @return a list of selected users
     */
    List<String> showUserSelectionDialog(Shell parent, String title, boolean multi, List<String> initialUsers,
            String destinationId);
}
