package com.devepos.adt.searchfavorites.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.osgi.util.NLS;
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
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;

import com.devepos.adt.searchfavorites.internal.messages.Messages;
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
  private final List<ISearchFavorite> removedEntries;

  private TableViewer viewer;
  private Button removeButton;
  private boolean orderChanged;
  private boolean newFavsImported;

  private Button moveUpButton;

  private Button moveDownButton;

  public ManageSearchFavoritesDialog(final Shell parent) {
    super(parent);
    setTitle(Messages.ManageSearchFavoritesDialog_Title_xtit);
    setMessage(Messages.ManageSearchFavoritesDialog_dialogIntro_xmsg);
    input = new ArrayList<>(Activator.getDefault().getSearchFavoriteManager().getFavorites());
    if (input != null && !input.isEmpty()) {
      setInitialSelections(input.get(0));
    }
    removedEntries = new ArrayList<>();
    setHelpAvailable(false);
  }

  private static final class FavoriteLabelProvider extends LabelProvider {

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
      return SearchFavoritesUtil.getFavoriteDisplayName(favorite, descriptors.get(favorite
          .getSearchType()));
    }

  }

  @Override
  public void create() {
    super.create();

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
      // Build a list of selected children.
      final ISelection selection = viewer.getSelection();
      if (selection instanceof IStructuredSelection) {
        setResult(viewer.getStructuredSelection().toList());
      }
      okPressed();
      return;
    }
    super.buttonPressed(buttonId);
  }

  @Override
  protected void createButtonsForButtonBar(final Composite parent) {
    createButton(parent, IDialogConstants.OPEN_ID, IDialogConstants.OPEN_LABEL, true);
    createButton(parent, IMPORT_ID, Messages.ImportFavoritesAction_ImportFavoritesAction_xmit,
        false);
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, false);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  /*
   * Overrides method from Dialog
   */
  @Override
  protected Control createDialogArea(final Composite container) {
    final var ancestor = (Composite) super.createDialogArea(container);

    createMessageArea(ancestor);

    final var parent = new Composite(ancestor, SWT.NONE);

    GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(parent);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);

    viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER
        | SWT.FULL_SELECTION);
    viewer.setContentProvider(new ArrayContentProvider());
    viewer.setLabelProvider(new FavoriteLabelProvider());
    viewer.addSelectionChangedListener(event -> validateDialogState());

    final var table = viewer.getTable();
    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseDoubleClick(final MouseEvent e) {
        buttonPressed(IDialogConstants.OPEN_ID);
      }
    });
    GridDataFactory.fillDefaults()
        // .span(1, 2)
        .hint(convertWidthInCharsToPixels(WIDTH_IN_CHARACTERS), convertHeightInCharsToPixels(15))
        .grab(true, true)
        .applyTo(table);

    addSideButtons(parent);

    applyDialogFont(ancestor);

    // set input & selections last, so all the widgets are created.
    viewer.setInput(input);
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
    return ancestor;
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

  @Override
  protected int getDialogBoundsStrategy() {
    return DIALOG_PERSISTSIZE;
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
    if (!input.isEmpty() && (orderChanged || newFavsImported)) {
      final var favorites = Activator.getDefault().getSearchFavoriteManager().getFavorites();
      favorites.clear();
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
    moveUpButton.setEnabled(elementsSelected > 0 && input.indexOf(sel.getFirstElement()) > 0);
    moveDownButton.setEnabled(elementsSelected > 0 && Stream.of(sel.toArray())
        .allMatch(o -> input.indexOf(o) < input.size() - 1));

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
    removeButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(
        e -> removeFavorite()));
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(removeButton);

    var sep = new Label(buttonContainer, SWT.SEPARATOR | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().hint(15, SWT.DEFAULT).applyTo(sep);

    moveUpButton = new Button(buttonContainer, SWT.PUSH);
    moveUpButton.setText("Move &Up");
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(moveUpButton);
    moveUpButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> moveFavorite(
        -1)));

    moveDownButton = new Button(buttonContainer, SWT.PUSH);
    moveDownButton.setText("Move &Down");
    GridDataFactory.fillDefaults()
        .align(SWT.BEGINNING, SWT.BEGINNING)
        .hint(convertWidthInCharsToPixels(BUTTON_CHAR_WIDTH), SWT.DEFAULT)
        .applyTo(moveDownButton);
    moveDownButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> moveFavorite(
        1)));
  }

  private void importFavorites() {
    final var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    final var dialog = new FileDialog(shell, SWT.OPEN);
    dialog.setFilterNames(new String[] { "XML (*.xml)", //$NON-NLS-1$
        Messages.ImportFavoritesAction_AllFilesFileType_xmit });
    dialog.setFilterExtensions(new String[] { "*.xml", "*.*" }); //$NON-NLS-1$ //$NON-NLS-2$
    dialog.setFileName("favorites.xml"); //$NON-NLS-1$

    final var importFileName = dialog.open();
    if ("".equals(importFileName)) { //$NON-NLS-1$
      return;
    }

    final var importedFavorites = new SearchFavorites();
    SearchFavoriteStorage.deserialize(importedFavorites, importFileName);

    if (!importedFavorites.hasEntries()) {
      return;
    }

    var favoritesInFile = importedFavorites.getFavorites().size();
    var importCount = 0;
    for (var newFav : importedFavorites.getFavorites()) {
      if (input.stream()
          .anyMatch(f -> SearchFavoritesUtil.matchesFavAttributes(f, newFav.getDestinationId(),
              newFav.getSearchType(), newFav.getDescription()))) {
        continue;
      }
      input.add(newFav);
      importCount++;
    }

    if (importCount > 0) {
      viewer.refresh();
      newFavsImported = true;
      MessageDialog.openInformation(shell, Messages.ImportFavoritesAction_ImportSuccess_xtit, NLS
          .bind(Messages.ImportFavoritesAction_ImportSuccess_xmsg, importCount, favoritesInFile));
    } else {
      MessageDialog.openInformation(shell, Messages.ImportFavoritesAction_ImportSuccess_xtit,
          Messages.ImportFavoritesAction_NoFavoritesImported_xmsg);
    }
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
    final var favorites = selection.iterator();
    while (favorites.hasNext()) {
      final var curr = (ISearchFavorite) favorites.next();
      removedEntries.add(curr);
      input.remove(curr);
      viewer.remove(curr);
    }
    if (viewer.getSelection().isEmpty() && !input.isEmpty()) {
      viewer.setSelection(new StructuredSelection(input.get(0)));
    }
  }
}
