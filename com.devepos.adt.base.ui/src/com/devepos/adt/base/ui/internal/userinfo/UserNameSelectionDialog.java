package com.devepos.adt.base.ui.internal.userinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

import com.devepos.adt.base.model.adtbase.IUser;
import com.devepos.adt.base.system.SystemServiceFactory;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.SplitResultSelectionViewer;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.dialogs.SearchSelectionDialog;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.util.StringUtil;

/**
 * Dialog for selecting one or several users
 *
 * @author stockbal
 *
 */
public class UserNameSelectionDialog extends SearchSelectionDialog<IUser, String> {

    private static final String DIALOG_SETTINGS_NAME = UserNameSelectionDialog.class.getCanonicalName();
    private List<IUser> users;
    private final String destination;
    private final List<String> excludedUsers;
    private SplitResultSelectionViewer splitResultViewer;

    public UserNameSelectionDialog(final Shell parent, final String title, final boolean multi,
        final List<com.devepos.adt.base.model.adtbase.IUser> selectedUsers, final List<String> excludedUsers,
        final String destination) {
        super(parent, multi);
        this.destination = destination;
        this.excludedUsers = excludedUsers;
        setTitle(title);
        setFilterLabel(Messages.UserNameSelectionDialog_FilterLabel);
        setInitialJobDelay(0L);
        setJobDelay(0L);
        setInitialDialogSize(360, 630);
        if (selectedUsers != null) {
            setInitialSelections(selectedUsers);
        }
        splitResultViewer = new SplitResultSelectionViewer();
        final IStyledLabelProvider resultLabelProvider = new ResultLabelProvider();
        splitResultViewer.setResultViewerFilter(new SelectedUsersFilter());
        splitResultViewer.setResultLabelProvider(new DelegatingStyledCellLabelProvider(resultLabelProvider));
        splitResultViewer.setDetailsLabelProvider(new DelegatingStyledCellLabelProvider(resultLabelProvider));
        setResultViewPart(splitResultViewer);
    }

    @Override
    protected IDialogSettings getDialogSettings() {
        return AdtBaseUIPlugin.getDefault().getDialogSettingsSection(DIALOG_SETTINGS_NAME);
    }

    @Override
    protected boolean matchesFilter(final IUser result, final String filter) {
        if (StringUtil.isBlank(filter)) {
            return true;
        }
        final String filterPattern = filter.replace("*", ".*").concat(".*");
        if (Pattern.matches(filterPattern, result.getName().toLowerCase())) {
            return true;
        }
        final String userName = result.getText();
        if (!StringUtil.isEmpty(userName)) {
            final List<String> userNameParts = Stream.of(userName.split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
            return userNameParts.stream().anyMatch(w -> Pattern.matches(filterPattern, w));
        }
        return false;
    }

    @Override
    protected SearchSelectionDialog<IUser, String>.SearchResultObject performSearch(final String filter,
        final IProgressMonitor monitor) throws CoreException {

        if (users == null) {
            users = SystemServiceFactory.createSystemService().getUsers(destination);
            if (excludedUsers != null && !excludedUsers.isEmpty()) {
                users.removeIf(u -> excludedUsers.contains(u.getName()));
            }
        }
        return new SearchResultObject(users, true);
    }

    private class SelectedUsersFilter extends ViewerFilter {

        private List<IUser> selectedUsers = new ArrayList<>();

        private void determineSelectedUsers() {
            selectedUsers.clear();
            IStructuredSelection sel = splitResultViewer.getSelection();
            for (Object selObj : sel.toArray()) {
                selectedUsers.add((IUser) selObj);
            }
        }

        @Override
        public Object[] filter(final Viewer viewer, final Object parent, final Object[] elements) {
            determineSelectedUsers();
            if (selectedUsers == null || selectedUsers.isEmpty()) {
                return elements;
            }
            return super.filter(viewer, parent, elements);
        }

        @Override
        public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
            if (element instanceof IUser) {
                IUser user = (IUser) element;
                return !selectedUsers.stream().anyMatch(u -> u.getName().equals(user.getName()));
            }
            return true;
        }

    }

    private class ResultLabelProvider extends LabelProvider implements
        DelegatingStyledCellLabelProvider.IStyledLabelProvider {

        @Override
        public Image getImage(final Object element) {
            if (element instanceof IUser) {
                return AdtBaseUIResources.getImage(IAdtBaseImages.USER);
            }
            return null;
        }

        @Override
        public StyledString getStyledText(final Object element) {
            final StyledString text = new StyledString();
            if (element instanceof IUser) {
                final IUser user = (IUser) element;
                text.append(user.getName());

                final String description = user.getText();
                if (!StringUtil.isEmpty(description)) {
                    text.append("  " + user.getText(), //$NON-NLS-1$
                        StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
                }
            }
            return text != null ? text : new StyledString();
        }

        @Override
        public String getText(final Object element) {
            if (element instanceof IUser) {
                final IUser user = (IUser) element;
                return user.getName();
            }
            return super.getText(element);
        }

    }
}
