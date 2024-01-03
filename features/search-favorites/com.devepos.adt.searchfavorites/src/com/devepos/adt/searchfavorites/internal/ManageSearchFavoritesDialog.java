package com.devepos.adt.searchfavorites.internal;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.controls.FilterableComposite;
import com.devepos.adt.base.ui.table.FilterableTable;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.searchfavorites.internal.messages.Messages;
import com.devepos.adt.searchfavorites.internal.preferences.IPreferences;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

/**
 * This dialog is for managing object search favorites
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class ManageSearchFavoritesDialog extends SelectionDialog {

  private static final int IMPORT_ID = IDialogConstants.CLIENT_ID + 1;

  private static final int WIDTH_IN_CHARACTERS = 55;
  private static final int BUTTON_CHAR_WIDTH = 15;

  private IStructuredSelection dndSelection;

  private final List<ISearchFavorite> input;
  private final List<ISearchFavorite> newEntries = new ArrayList<>();
  private final List<ISearchFavorite> removedEntries = new ArrayList<>();
  private final Set<ISearchFavorite> hiddenFavorites = new HashSet<>();

  private FilterableTable favoritesTable;
  private CheckboxTableViewer viewer;
  private Button removeButton;
  private Button moveUpButton;
  private Button moveDownButton;
  private Button renameButton;
  private Label filteredInfo;
  private ViewerFilter visiblityFilter;

  private boolean orderChanged;
  private boolean visibilityChanged;
  private boolean favsRenamed;
  private boolean showHiddenFavs;
  private boolean makeNewFavsVisible;
  private boolean insertNewFavsAtBeginning;

  public ManageSearchFavoritesDialog(final Shell parent) {
    super(parent);
    setTitle(Messages.ManageSearchFavoritesDialog_Title_xtit);
    setMessage(Messages.ManageSearchFavoritesDialog_dialogIntro_xmsg);
    input = new ArrayList<>(Activator.getDefault().getSearchFavoriteManager().getFavorites());
    if (input != null && !input.isEmpty()) {
      setInitialSelections(input.get(0));
      input.stream().filter(ISearchFavorite::isHidden).forEach(hiddenFavorites::add);
    }
    setHelpAvailable(true);
    visiblityFilter = new ViewerFilter() {
      @Override
      public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
        if (showHiddenFavs) {
          return true;
        }
        return !hiddenFavorites.contains(element);
      }
    };
    showHiddenFavs = true;

    var prefStore = Activator.getDefault().getPreferenceStore();
    makeNewFavsVisible = prefStore.getBoolean(IPreferences.MAKE_NEW_FAVS_VISIBLE);
    insertNewFavsAtBeginning = prefStore.getBoolean(IPreferences.INSERT_NEW_FAVS_AT_START);
  }

  private final class FavoriteLabelProvider extends LabelProvider implements IStyledLabelProvider {

    private final Map<String, SearchFavoriteDescriptor> descriptors = Activator.getDefault()
        .getSearchFavoriteDescriptors();
    private final List<Image> images = new ArrayList<>();

    @Override
    public void dispose() {
      for (var image : images) {
        image.dispose();
      }
    }

    @Override
    public Image getImage(final Object element) {
      var favorite = (ISearchFavorite) element;
      var descriptor = descriptors.get(favorite.getSearchType());
      if (descriptor == null) {
        return PlatformUI.getWorkbench()
            .getSharedImages()
            .getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
      }

      var imageDescriptor = descriptor != null ? descriptor.getIcon() : null;
      if (imageDescriptor != null) {
        var image = imageDescriptor.createImage();
        images.add(image);
        return image;
      }
      return null;
    }

    @Override
    public String getText(final Object element) {
      var favorite = (ISearchFavorite) element;
      var descriptor = descriptors.get(favorite.getSearchType());
      if (descriptor == null) {
        return MessageFormat.format(
            Messages.SearchFavoritesMenuAction_MissingPluginForFavSearchType_xtit,
            favorite.getSearchType());
      }
      var displayName = SearchFavoritesUtil.getFavoriteDisplayName(favorite, descriptor);
      return displayName;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      var styledString = new StyledString();
      var text = getText(element);
      if (newEntries.contains(element)) {
        text = "*" + text; //$NON-NLS-1$
        styledString.append(text, StylerFactory.ITALIC_STYLER);
      } else {
        styledString.append(text);
      }

      return styledString;
    }

  }

  @Override
  public void create() {
    super.create();

    getShell().setImage(Activator.getDefault().getImage(IImages.MANAGE_SEARCH_FAVORITES));

    final var initialSelection = getInitialElementSelections();
    if (initialSelection != null) {
      viewer.setSelection(new StructuredSelection(initialSelection));
    }

    validateDialogState();
  }

  @Override
  protected void buttonPressed(final int buttonId) {
    if (buttonId == IMPORT_ID) {
      importFavorites();
      return;
    }
    if (buttonId == IDialogConstants.OPEN_ID) {
      var favList = viewer.getStructuredSelection().toList();
      var favorite = (ISearchFavorite) favList.get(0);
      if (Activator.getDefault()
          .getSearchFavoriteDescriptors()
          .get(favorite.getSearchType()) == null) {
        MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
            AdtBaseUIResources.getString(IAdtBaseStrings.Dialog_Error_xtit),
            MessageFormat.format(
                Messages.SearchFavoritesMenuAction_MissingPluginForFavSearchType_xtit,
                favorite.getSearchType()) + "\n\n" + //$NON-NLS-1$
                Messages.SearchFavoritesMenuAction_MissingPluginForFavSearchType_xmsg);
        return;
      }
      setResult(favList);
      okPressed();
      return;
    }
    super.buttonPressed(buttonId);
  }

  @Override
  protected void createButtonsForButtonBar(final Composite parent) {
    createButton(parent, IDialogConstants.OPEN_ID, IDialogConstants.OPEN_LABEL, true);
    createButton(parent, IMPORT_ID, Messages.FavoritesImporter_ImportFavoritesAction_xmit, false);
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, false);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  @Override
  protected Control createDialogArea(final Composite container) {
    final var ancestor = (Composite) super.createDialogArea(container);

    createMessageArea(ancestor);

    final var parent = new Composite(ancestor, SWT.NONE);

    GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(parent);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);

    HelpUtil.setHelp(ancestor, "manage_favorites"); //$NON-NLS-1$

    createFavoritesTable(parent);

    addSideButtons(parent);
    applyDialogFont(ancestor);

    filteredInfo = new Label(parent, SWT.NONE);
    GridDataFactory.fillDefaults().span(2, 1).applyTo(filteredInfo);

    updateFilterInfo();
    return ancestor;
  }

  private void createFavoritesTable(final Composite parent) {
    favoritesTable = new FilterableTable(parent, null, false, FilterableComposite.TEXT_NO_MARGIN) {
      @Override
      protected void filterJobCompleted() {
        updateCheckedElements();
        updateFilterInfo();
      }
    };
    viewer = CheckboxTableViewer.newCheckList(favoritesTable,
        SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);

    favoritesTable.setViewer(viewer);
    viewer.setContentProvider(new ArrayContentProvider());
    viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new FavoriteLabelProvider()));
    viewer.addSelectionChangedListener(event -> validateDialogState());

    final var table = viewer.getTable();
    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseDoubleClick(final MouseEvent e) {
        buttonPressed(IDialogConstants.OPEN_ID);
      }
    });
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(WIDTH_IN_CHARACTERS), convertHeightInCharsToPixels(15))
        .grab(true, true)
        .applyTo(table);

    viewer.addCheckStateListener(l -> {
      var favorite = (ISearchFavorite) l.getElement();
      if (l.getChecked()) {
        hiddenFavorites.remove(favorite);
      } else {
        hiddenFavorites.add(favorite);
      }
      visibilityChanged = true;
      if (!showHiddenFavs) {
        viewer.refresh();
      }
      updateFilterInfo();
    });
    viewer.addFilter(visiblityFilter);
    // set input & selections last, so all the widgets are created.
    viewer.setInput(input);
    updateCheckedElements();
    viewer.refresh();
    viewer.getTable().setFocus();

    // register Drag-n-Drop Support
    final var transfers = new Transfer[] { TextTransfer.getInstance() };
    viewer.addDragSupport(DND.DROP_MOVE, transfers, new DragSourceAdapter() {
      @Override
      public void dragSetData(final DragSourceEvent event) {
        final ISelection select = viewer.getSelection();
        if (select instanceof IStructuredSelection) {
          dndSelection = (IStructuredSelection) select;
          // save item to event.data
          event.data = "DATA"; //$NON-NLS-1$
        }
      }
    });
    viewer.addDropSupport(DND.DROP_MOVE, transfers, new DropTargetAdapter() {
      @Override
      public void drop(final DropTargetEvent event) {
        if (!TextTransfer.getInstance().isSupportedType(event.currentDataType)) {
          return;
        }
        final TableItem item = (TableItem) event.item;
        int targetIndex = -1;
        if (item != null) {
          final Table table = item.getParent();
          targetIndex = table.indexOf(item);
        }

        // add an item
        performDrop(targetIndex);
      }
    });
  }

  private void updateFilterInfo() {
    if (input.isEmpty()) {
      filteredInfo.setText(Messages.ManageSearchFavoritesDialog_NoFavoritesAvailable_xlbl);
    } else {
      filteredInfo
          .setText(String.format(Messages.ManageSearchFavoritesDialog_FilteredFavoritesInfo_xlbl,
              viewer.getTable().getItemCount(), input.size()));
    }
  }

  private void updateCheckedElements() {
    viewer.setCheckedElements(input.stream().filter(f -> !hiddenFavorites.contains(f)).toArray());
  }

  @Override
  protected Label createMessageArea(final Composite composite) {
    final var parent = new Composite(composite, SWT.NONE);
    GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(parent);
    GridDataFactory.fillDefaults().span(2, 1).applyTo(parent);

    final var label = new Label(parent, SWT.WRAP);
    label.setText(getMessage());
    GridDataFactory.fillDefaults().span(2, 1).applyTo(label);

    applyDialogFont(label);
    return label;
  }

  @Override
  protected IDialogSettings getDialogBoundsSettings() {
    return Activator.getDefault()
        .getDialogSettingsSection("DialogBounds_ManageSearchFavoritesDialog"); //$NON-NLS-1$
  }

  /*
   * Overrides method from Dialog
   */
  @Override
  protected void okPressed() {
    boolean favUpdateRequired = false;
    // remove history entries
    for (final var favoriteEntry : removedEntries) {
      Activator.getDefault().getSearchFavoriteManager().removeFavorite(favoriteEntry);
      favUpdateRequired = true;
    }
    if (!input.isEmpty()
        && (orderChanged || !newEntries.isEmpty() || visibilityChanged || favsRenamed)) {
      final var favorites = Activator.getDefault().getSearchFavoriteManager().getFavorites();
      favorites.clear();
      input.forEach(f -> {
        f.setHidden(hiddenFavorites.contains(f));
      });
      favorites.addAll(input);
      favUpdateRequired = true;
    }
    if (favUpdateRequired) {
      SearchFavoriteStorage.serialize();
    }
    super.okPressed();
  }

  protected final void validateDialogState() {
    final var sel = viewer.getStructuredSelection();
    final int elementsSelected = sel.toList().size();

    removeButton.setEnabled(elementsSelected > 0);
    renameButton.setEnabled(elementsSelected == 1);
    moveUpButton.setEnabled(elementsSelected > 0 && input.indexOf(sel.getFirstElement()) > 0);
    moveDownButton.setEnabled(elementsSelected > 0
        && Stream.of(sel.toArray()).allMatch(o -> input.indexOf(o) < input.size() - 1));

    final var openButton = getButton(IDialogConstants.OPEN_ID);
    if (openButton != null) {
      openButton.setEnabled(elementsSelected == 1);
    }
  }

  private void addSideButtons(final Composite parent) {
    var buttonContainer = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(buttonContainer);
    GridLayoutFactory.swtDefaults().margins(0, 0).applyTo(buttonContainer);

    removeButton = new Button(buttonContainer, SWT.PUSH);
    removeButton.setText(Messages.ManageSearchFavoritesDialog_removeFavorite_xbut);
    removeButton.addSelectionListener(widgetSelectedAdapter(e -> removeFavorite()));
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(removeButton);

    var sep = new Label(buttonContainer, SWT.SEPARATOR | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().hint(15, SWT.DEFAULT).applyTo(sep);

    renameButton = new Button(buttonContainer, SWT.PUSH);
    renameButton.setText(Messages.ManageSearchFavoritesDialog_RenameButton_xbtn);
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(renameButton);
    renameButton.addSelectionListener(widgetSelectedAdapter(e -> renameFavorite()));

    moveUpButton = new Button(buttonContainer, SWT.PUSH);
    moveUpButton.setText(Messages.ManageSearchFavoritesDialog_MovUp_xbtn);
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(moveUpButton);
    moveUpButton.addSelectionListener(widgetSelectedAdapter(e -> moveFavorite(-1)));

    moveDownButton = new Button(buttonContainer, SWT.PUSH);
    moveDownButton.setText(Messages.ManageSearchFavoritesDialog_MoveDown_xbtn);
    GridDataFactory.fillDefaults()
        .align(SWT.BEGINNING, SWT.BEGINNING)
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(moveDownButton);
    moveDownButton.addSelectionListener(widgetSelectedAdapter(e -> moveFavorite(1)));

    sep = new Label(buttonContainer, SWT.SEPARATOR | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().hint(15, SWT.DEFAULT).applyTo(sep);

    var selectAll = new Button(buttonContainer, SWT.PUSH);
    selectAll.setText(Messages.ManageSearchFavoritesDialog_ShowAll_xbtn);
    selectAll.addSelectionListener(widgetSelectedAdapter(e -> selectAll(true)));
    GridDataFactory.fillDefaults()
        .align(SWT.BEGINNING, SWT.BEGINNING)
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(selectAll);

    var unselectAll = new Button(buttonContainer, SWT.PUSH);
    unselectAll.setText(Messages.ManageSearchFavoritesDialog_HideAll);
    unselectAll.addSelectionListener(widgetSelectedAdapter(e -> selectAll(false)));
    GridDataFactory.fillDefaults()
        .align(SWT.BEGINNING, SWT.BEGINNING)
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(unselectAll);

    var showUncheckedFavsButton = new Button(buttonContainer, SWT.TOGGLE);
    showUncheckedFavsButton.setText(Messages.ManageSearchFavoritesDialog_ShowHidden_xbtn);
    showUncheckedFavsButton.setSelection(showHiddenFavs);
    showUncheckedFavsButton.addSelectionListener(widgetSelectedAdapter(e -> {
      showHiddenFavs = showUncheckedFavsButton.getSelection();
      viewer.refresh(false);
      updateFilterInfo();
    }));
    GridDataFactory.fillDefaults()
        .align(SWT.BEGINNING, SWT.BEGINNING)
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(showUncheckedFavsButton);
  }

  private void renameFavorite() {
    var selectedFavs = viewer.getStructuredSelection().toList();
    if (selectedFavs.isEmpty() || selectedFavs.size() != 1) {
      return;
    }

    var fav = (ISearchFavorite) selectedFavs.get(0);

    var invalidDescriptions = input.stream()
        .filter(f -> f != fav && fav.getSearchType().equals(fav.getSearchType()))
        .map(f -> f.getDescription().toLowerCase())
        .collect(Collectors.toList());

    var inputDialog = new InputDialog(getShell(),
        Messages.ManageSearchFavoritesDialog_RenameFavoriteDialog_xtit,
        Messages.ManageSearchFavoritesDialog_RenameFavoriteDialog_xlbl, fav.getDescription(),
        value -> {
          if (StringUtil.isEmpty(value)) {
            return Messages.ManageSearchFavoritesDialog_NoDescriptionEntered_xmsg;
          }
          if (invalidDescriptions.contains(value.toLowerCase())) {
            return Messages.ManageSearchFavoritesDialog_DuplicateFavoriteDescription_xmsg;
          }
          return null;
        });

    if (inputDialog.open() == Window.OK) {
      fav.setDescription(inputDialog.getValue());
      viewer.refresh(fav);
    }
  }

  private void selectAll(final boolean selectAll) {
    visibilityChanged = true;
    hiddenFavorites.clear();
    if (!selectAll) {
      hiddenFavorites.addAll(input);
    }
    viewer.refresh();
    viewer.setAllChecked(selectAll);

    updateFilterInfo();
  }

  private void importFavorites() {
    var importer = new FavoritesImporter(importedFavs -> {
      newEntries.addAll(importedFavs);
      if (!makeNewFavsVisible) {
        hiddenFavorites.addAll(importedFavs);
      }
      if (makeNewFavsVisible && insertNewFavsAtBeginning) {
        input.addAll(0, importedFavs);
      } else {
        input.addAll(importedFavs);
      }
      viewer.refresh();
      updateCheckedElements();
      updateFilterInfo();
    }, favToBeImported -> input.stream()
        .anyMatch(
            f -> SearchFavoritesUtil.matchesFavAttributes(f, favToBeImported.getDestinationId(),
                favToBeImported.getSearchType(), favToBeImported.getDescription())));
    importer.run();
  }

  private void moveFavorite(final int indexChange) {
    var selectedFavs = viewer.getStructuredSelection().toList();
    if (selectedFavs.isEmpty()) {
      return;
    }
    var movedFavs = new ISearchFavorite[input.size()];

    for (var fav : selectedFavs) {
      var currentIndex = input.indexOf(fav);
      movedFavs[currentIndex + indexChange] = (ISearchFavorite) fav;
    }

    input.removeAll(selectedFavs);

    for (int i = 0; i < movedFavs.length; i++) {
      var movedFav = movedFavs[i];
      if (movedFav != null) {
        input.add(i, movedFav);
      }
    }

    viewer.refresh();
    validateDialogState();
    orderChanged = true;
  }

  /*
   * Performs the drag operation
   */
  private void performDrop(final int targetIndex) {
    if (targetIndex >= 0) {
      int i = targetIndex + 1;
      for (final var selectedObj : dndSelection.toList()) {
        input.remove(selectedObj);
        if (input.size() - 1 < i) {
          input.add((ISearchFavorite) selectedObj);
          i = input.size() - 1;
        } else {
          input.add(i++, (ISearchFavorite) selectedObj);
        }
        orderChanged = true;
      }
    } else {
      for (final var selectedObj : dndSelection.toList()) {
        input.remove(selectedObj);
        input.add((ISearchFavorite) selectedObj);
        orderChanged = true;
      }
    }

    dndSelection = null;
    viewer.refresh();
    validateDialogState();
  }

  private void removeFavorite() {
    final var selection = viewer.getStructuredSelection();
    final var firstSelectedIndex = input.indexOf(selection.getFirstElement());
    final var favorites = selection.iterator();
    while (favorites.hasNext()) {
      final var curr = (ISearchFavorite) favorites.next();
      if (newEntries.isEmpty() || !newEntries.remove(curr)) {
        removedEntries.add(curr);
      }
      if (!hiddenFavorites.isEmpty()) {
        hiddenFavorites.remove(curr);
      }
      input.remove(curr);
      viewer.remove(curr);
    }

    updateFilterInfo();

    if (input.isEmpty()) {
      return;
    }

    var newSelectionIndex = 0;
    if (firstSelectedIndex == 0) {
      newSelectionIndex = 0;
    } else if (firstSelectedIndex >= input.size()) {
      newSelectionIndex = input.size() - 1;
    } else {
      newSelectionIndex = firstSelectedIndex;
    }

    viewer.setSelection(new StructuredSelection(input.get(newSelectionIndex)));
  }
}
