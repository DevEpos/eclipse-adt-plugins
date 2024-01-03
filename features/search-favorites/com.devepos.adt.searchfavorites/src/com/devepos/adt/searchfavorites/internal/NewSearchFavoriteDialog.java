package com.devepos.adt.searchfavorites.internal;

import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.contentassist.ContentAssistSupport;
import com.devepos.adt.base.ui.contentassist.TextContentProposal;
import com.devepos.adt.base.ui.search.IAbapProjectSearchQuery;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.searchfavorites.internal.messages.Messages;
import com.devepos.adt.searchfavorites.internal.preferences.IPreferences;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesFactory;

/**
 * Dialog for creating an executed search as a favorite
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class NewSearchFavoriteDialog extends StatusDialog {

  private static final int LABEL_WIDTH = 12;

  private Button createButton;
  private String favoriteDescription;
  private boolean isProjectIndependent;
  private final IAbapProjectSearchQuery searchQuery;
  private final String searchType;

  private final SearchFavoriteDescriptor descriptor;

  public NewSearchFavoriteDialog(final Shell parent, final String searchType,
      final IAbapProjectSearchQuery searchQuery) {
    super(parent);
    setTitle(Messages.NewSearchFavoriteDialog_Title_xtit);
    setHelpAvailable(false);
    this.searchQuery = searchQuery;
    this.searchType = searchType;
    descriptor = Activator.getDefault().getSearchFavoriteDescriptors().get(searchType);
    validateDialogState();
  }

  @Override
  protected void buttonPressed(final int buttonId) {
    if (buttonId == IDialogConstants.OK_ID) {
      validateDialogState();
    }
    super.buttonPressed(buttonId);
  }

  @Override
  protected void createButtonsForButtonBar(final Composite parent) {
    createButton = createButton(parent, IDialogConstants.OK_ID,
        Messages.NewSearchFavoriteDialog_CreateFavorite_xbut, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  /*
   * Overrides method from Dialog
   */
  @Override
  protected Control createDialogArea(final Composite container) {
    final var ancestor = (Composite) super.createDialogArea(container);

    setImage(AdtBaseUIResources.getImage(IAdtBaseImages.FAVORITES));

    createSearchParametersGroup(ancestor);
    createFavoriteParameters(ancestor);

    return ancestor;
  }

  @Override
  protected IDialogSettings getDialogBoundsSettings() {
    return Activator.getDefault().getDialogSettingsSection("DialogBounds_NewSearchFavoritesDialog"); //$NON-NLS-1$
  }

  @Override
  protected int getDialogBoundsStrategy() {
    return DIALOG_PERSISTSIZE;
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  @Override
  protected void okPressed() {
    final var newFavorite = ISearchFavoritesFactory.eINSTANCE.createSearchFavorite();
    newFavorite.setDescription(favoriteDescription);
    newFavorite.setSearchType(searchType);
    newFavorite.setProjectIndependent(isProjectIndependent);
    if (!isProjectIndependent) {
      newFavorite.setDestinationId(searchQuery.getDestinationId());
    }

    descriptor.getConnector().populateFavoriteFromQuery(newFavorite.getAttributes(), searchQuery);

    if (newFavorite.getAttributes().isEmpty()) {
      // TODO: show message??
      return;
    }

    var favManager = Activator.getDefault().getSearchFavoriteManager();
    if (favManager.contains(newFavorite.getDestinationId(), newFavorite.getSearchType(),
        newFavorite.getDescription())) {
      // Overwrite?
      if (!MessageDialog.openQuestion(getShell(),
          Messages.NewSearchFavoriteDialog_FavAlreadyExists_xtit,
          String.format(Messages.NewSearchFavoriteDialog_FavAlreadyExists_xmsg, favoriteDescription,
              descriptor.getTypeLabel()))) {
        return;
      }
      favManager.removeMatchingEntries(newFavorite.getDestinationId(), newFavorite.getSearchType(),
          newFavorite.getDescription());
    }
    var prefStore = Activator.getDefault().getPreferenceStore();

    var appendNewEntry = true;
    if (!prefStore.getBoolean(IPreferences.MAKE_NEW_FAVS_VISIBLE)) {
      newFavorite.setHidden(true);
    } else if (prefStore.getBoolean(IPreferences.INSERT_NEW_FAVS_AT_START)) {
      appendNewEntry = false;
    }

    if (appendNewEntry) {
      favManager.addFavorite(newFavorite);
    } else {
      favManager.addFavorite(newFavorite, 0);
    }

    SearchFavoriteStorage.serialize();
    super.okPressed();
  }

  @Override
  protected void updateButtonsEnableState(final IStatus status) {
    if (createButton != null && !createButton.isDisposed()) {
      createButton.setEnabled(status == null || !status.matches(IStatus.ERROR));
    }
  }

  @Override
  protected void updateStatus(final IStatus status) {
    super.updateStatus(status);
    final IStatus currentStatus = getStatus();
    if (currentStatus != null && currentStatus.matches(IStatus.ERROR | IStatus.WARNING)) {
      final Shell shell = getShell();
      if (shell == null) {
        return;
      }
      shell.pack(true);
      shell.layout(true);
    }
  }

  protected final boolean validateDialogState() {
    IStatus status = null;
    if (favoriteDescription == null || favoriteDescription.isEmpty()) {
      status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR,
          Messages.NewSearchFavoriteDialog_NoDescriptionError_xmsg, null);
    }
    updateStatus(status);
    return status == null || !status.matches(IStatus.ERROR);
  }

  /*
   * Creates group for holding favorite specific parameters used, to identify the
   * search favorite
   */
  private void createFavoriteParameters(final Composite ancestor) {
    final var group = new Group(ancestor, SWT.NONE);
    group.setText(Messages.NewSearchFavoriteDialog_FavoriteSettings_xgrp);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(group);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(group);

    // description for the favorite
    final var favoriteDescriptionLabel = new Label(group, SWT.NONE);
    favoriteDescriptionLabel.setText(Messages.NewSearchFavoriteDialog_Description_xfld);
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(LABEL_WIDTH), SWT.DEFAULT)
        .applyTo(favoriteDescriptionLabel);

    final var favoriteDescription = new Text(group, SWT.BORDER);
    favoriteDescription.addModifyListener(e -> {
      NewSearchFavoriteDialog.this.favoriteDescription = favoriteDescription.getText();
      validateDialogState();
    });
    ContentAssistSupport.createContentAssist(favoriteDescription, query -> {
      return Activator.getDefault()
          .getSearchFavoriteManager()
          .getFavorites()
          .stream()
          .filter(f -> searchType.equals(f.getSearchType()))
          .map(f -> f.getDescription())
          .filter(StringUtil.getPatternForQuery(query).asMatchPredicate())
          .map(d -> new TextContentProposal(d, query, true))
          .collect(Collectors.toList());
    });
    GridDataFactory.fillDefaults().grab(true, false).applyTo(favoriteDescription);

    // flag "is project independent"
    final var isProjectIndependentCheckBox = new Button(group, SWT.CHECK);
    isProjectIndependentCheckBox
        .setText(Messages.NewSearchFavoriteDialog_ProjectIndependentSetting_xckl);
    isProjectIndependentCheckBox.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        isProjectIndependent = isProjectIndependentCheckBox.getSelection();
      }
    });
    GridDataFactory.fillDefaults()
        .span(2, 1)
        .hint(convertWidthInCharsToPixels(60), SWT.DEFAULT)
        .applyTo(isProjectIndependentCheckBox);

    favoriteDescription.setFocus();
  }

  private void createReadOnlyTextWithLabel(final String label, final String content,
      final Composite parent) {
    final var labelControl = new Label(parent, SWT.NONE);
    labelControl.setText(label);
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(LABEL_WIDTH), SWT.DEFAULT)
        .applyTo(labelControl);

    final var textControl = new Text(parent, SWT.READ_ONLY | SWT.BORDER | SWT.NO_FOCUS);
    textControl.setText(content);
    textControl.setToolTipText(content);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(textControl);
  }

  /*
   * Creates group for holding the parameters of the search query
   */
  private void createSearchParametersGroup(final Composite ancestor) {
    final var group = new Group(ancestor, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(group);
    group.setText(Messages.NewSearchFavoriteDialog_SearchParameters_xgrp);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(group);

    createReadOnlyTextWithLabel(Messages.NewSearchFavoriteDialog_Project_xfld,
        searchQuery.getDestinationId(), group);
    createReadOnlyTextWithLabel(Messages.NewSearchFavoriteDialog_SearchType_xfld,
        descriptor.getTypeLabel(), group);
  }

}
