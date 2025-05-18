package com.devepos.adt.atm.ui.internal.wizard.importtags;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.atm.model.abaptags.IAbapTagsContent;
import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.tree.SelectTagSubtreeAction;
import com.devepos.adt.atm.ui.internal.tree.TagLabelProvider;
import com.devepos.adt.atm.ui.internal.tree.TagSelectionTree;
import com.devepos.adt.atm.ui.internal.tree.TagTreeContentProvider;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.controls.FilterableComposite;
import com.devepos.adt.base.ui.table.FilterableTable;
import com.devepos.adt.base.ui.wizard.AbstractBaseWizardPage;
import com.devepos.adt.base.util.EmfUtils;
import com.devepos.adt.base.util.StringUtil;

/**
 * Selection page for tags from source file or source project
 *
 * @see {@link ImportAbapTagsWizard}
 * @author stockbal
 */
public class TagContentSelectionWizardPage extends AbstractBaseWizardPage {
  public static final String PAGE_NAME = TagContentSelectionWizardPage.class.getCanonicalName();

  private static DecimalFormat SELECTION_FORMAT = new DecimalFormat("###,###");
  private static int OBJ_TABLE_MODE = 1;
  private static int PARENT_OBJ_TABLE_MODE = 2;

  private IAbapTagsContent contentForImport;
  private final List<CheckableTaggedObjectInfo> taggedObjects = new ArrayList<>();
  private String selectedTagId;
  private ITag selectedTag;
  private int tableMode = OBJ_TABLE_MODE;
  private final Map<ColumnViewerSpec, Integer> colWidths = new HashMap<>();
  private int objTableModeDefaultWidth;

  private TagSelectionTree tagTree;
  private FilterableTable tgobjTable;
  private CheckboxTableViewer tgobjTableViewer;
  private Combo tagTypeCombo;
  private ToolBar treeToolBar;
  private ToolBar tableToolBar;

  private Label treeSelectionInfo;
  private Label tgobjOfCurrentTagCheckInfo;
  private Label overallTgobjCheckInfo;

  private SelectTagSubtreeAction selectSubTreeAction;
  private Button includeSharedUserInfo;

  private TagTreeContentProvider treeContentProvider;
  private TreeViewerLabelProvider treeLabelProvider;

  public TagContentSelectionWizardPage() {
    super(PAGE_NAME);
    setTitle("Select Content for Import");
  }

  private class TreeViewerLabelProvider extends TagLabelProvider {
    public TreeViewerLabelProvider() {
      super(false, false);
    }

    @Override
    protected void appendCounterText(final ITag tag, final StyledString text) {
      if (tag.getTaggedObjectCount() == 0) {
        return;
      }
      super.appendCounterText(tag, text);
    }

    @Override
    protected void appendTagName(final ITag tag, final StyledString text) {
      super.appendTagName(tag, text);
    }

  }

  @Override
  public void createControl(final Composite parent) {
    final var root = new Composite(parent, SWT.NONE);

    // TODO: Help Context
    // HelpUtil.setHelp(root, HelpContexts.UNASSIGN_TAGS_WIZARD_TAG_SELECTION);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(root);

    createTagsTree(root);
    createTgobjTable(root);
    createViewerContextMenu();
    createSelectOptionsGroup(root);

    var treeActionsComposite = new Composite(tagTree.getFilterComposite(), SWT.NONE);
    GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).applyTo(treeActionsComposite);
    GridDataFactory.fillDefaults().applyTo(treeActionsComposite);

    createTagScopeCombo(treeActionsComposite);
    createTreeToolbar(treeActionsComposite);
    createTableToolbar(tgobjTable.getFilterComposite());
    createActions();

    setControl(root);
    setPageComplete(false);
  }

  @Override
  public void completePage() {
    if (!isDirty()) {
      return;
    }

    getWizard().getSelectedTags().clear();
    getWizard().getSelectedTags()
        .putAll(tagTree.getCheckedTags()
            .stream()
            .collect(Collectors.toMap(ITag::getId, Function.identity())));

    var importRequest = IAbapTagsFactory.eINSTANCE.createTagImportRequest();
    var checkedTags = tagTree.getCheckedTags();
    var checkedUserTagIds = new HashSet<String>();
    var includeShared = includeSharedUserInfo.getSelection();

    contentForImport.getTags().stream().filter(t -> checkedTags.contains(t)).forEach(t -> {
      if (!StringUtil.isEmpty(t.getOwner())) {
        checkedUserTagIds.add(t.getId());
      }
      importRequest.getTags().add(cloneTagWithChkChildren(t, checkedTags, includeShared));
    });
    taggedObjects.stream().filter(t -> t.checked).forEach(tgobj -> {
      importRequest.getTaggedObjectInfos().add(tgobj.tgObj);
    });

    // REVISIT: filter out users not contained in the target project
    // final var systemInfo = AbapCore.getInstance()
    // .getAbapSystemInfo(DestinationUtil.getDestinationId(getWizard().getProject()));
    // var users = systemInfo.getUsers(new NullProgressMonitor(), "*", 50); //$NON-NLS-1$
    if (includeShared) {
      importRequest.getSharedTags()
          .addAll(contentForImport.getSharedTags()
              .stream()
              .filter(t -> checkedUserTagIds.contains(t.getId()))
              .collect(Collectors.toList()));
    }
    getWizard().setTagsContentForImport(importRequest);

    setDirty(false);
  }

  @Override
  public ImportAbapTagsWizard getWizard() {
    return (ImportAbapTagsWizard) super.getWizard();
  }

  @Override
  public void setVisible(final boolean visible) {
    final var previousPageIsDirty = getWizard().isPreviousPageDirty(this);
    if (visible && (!isPageComplete() || previousPageIsDirty)) {
      if (previousPageIsDirty) {
        contentForImport = null;
        tagTree.resetFilter();
        tgobjTable.resetFilter();
        tagTree.setTags(null, false);
        taggedObjects.clear();
      }
      getWizard().completePreviousPage(this);
      if (taggedObjects.isEmpty()) {
        loadTagsContentFromSource();
      }
      tagTree.setFocus();
    } else {
      validatePage(null);
    }
    super.setVisible(visible);

    if (visible && !taggedObjects.isEmpty()) {
      setShellSizeForTable(OBJ_TABLE_MODE);
      getWizard().updateShellSize();
    }

  }

  private ITag cloneTagWithChkChildren(final ITag t, final Set<ITag> checkedTags,
      final boolean includeShared) {
    var tag = IAbapTagsFactory.eINSTANCE.createTag();
    tag.setId(t.getId());
    tag.setName(t.getName());
    tag.setParentTagId(t.getParentTagId());
    tag.setCreatedBy(t.getCreatedBy());
    tag.setCreatedDateTime(t.getCreatedDateTime());
    tag.setChangedBy(t.getChangedBy());
    tag.setChangedDateTime(t.getChangedDateTime());
    tag.setOwner(t.getOwner());
    tag.setDescription(t.getDescription());
    if (t.isShared() && includeShared) {
      tag.setShared(true);
    }
    t.getChildTags()
        .stream()
        .filter(c -> checkedTags.contains(c))
        .forEach(c -> tag.getChildTags().add(cloneTagWithChkChildren(c, checkedTags, false)));
    return tag;
  }

  private void loadTagsContentFromSource() {
    var wizard = getWizard();
    if (wizard.getSourceFile() != null) {
      loadTagsContentFromFile(wizard.getSourceFile());
    } else {
      loadTagsFromProject(wizard.getSourceProject());
    }

    taggedObjects.clear();
    taggedObjects.addAll(contentForImport.getTaggedObjectInfos().stream().map(tgobj -> {
      var checkableTgobj = new CheckableTaggedObjectInfo();
      checkableTgobj.tgObj = tgobj;
      return checkableTgobj;
    }).sorted((el1, el2) -> {
      var obj1 = el1.tgObj;
      var obj2 = el2.tgObj;

      var result = obj1.getObjectType().compareTo(obj2.getObjectType());
      if (result != 0) {
        return result;
      }
      return obj1.getObjectName().compareTo(obj2.getObjectName());
    }).collect(Collectors.toList()));
  }

  /**
   * Exports the ABAP Tags content from the specified source content and
   * displays the tags with tagged objects counts in the tree
   */
  private void loadTagsFromProject(final IProject project) {
    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask("Retrieving ABAP Tags content from source project", -1);
        var taggingSrv = AdtObjTaggingServiceFactory.createTaggingService();
        var tagExportRequest = IAbapTagsFactory.eINSTANCE.createTagExportRequest();
        var response = taggingSrv.exportTags(DestinationUtil.getDestinationId(project),
            tagExportRequest);

        contentForImport = IAbapTagsFactory.eINSTANCE.createAbapTagsContent();
        contentForImport.getSharedTags().addAll(response.getSharedTags());
        contentForImport.getTags().addAll(response.getTags());
        contentForImport.getTaggedObjectInfos().addAll(response.getTaggedObjectInfos());

        Display.getDefault().asyncExec(() -> {
          setTreeInput();
          validatePage(null);
        });
      });
    } catch (final InvocationTargetException e) {
      if (e.getTargetException() instanceof RuntimeException) {
        throw (RuntimeException) e.getTargetException();
      }
    } catch (final InterruptedException e) {

    }
  }

  @SuppressWarnings("restriction")
  private void loadTagsContentFromFile(final String filePath) {
    final var factory = new AbapTagsResourceFactory();
    final var resource = factory.createResource(URI.createFileURI(filePath));

    try {
      resource.load(EmfUtils.createEmfResourceOptions());
      final var resourceContents = resource.getContents();
      // List of favorites is the root
      if (resourceContents != null && resourceContents.size() == 1) {
        final var root = resourceContents.get(0);
        if (!(root instanceof IAbapTagsContent)) {
          setErrorMessage("Content in the imported file is not valid ABAP Tags content");
        } else {
          contentForImport = (IAbapTagsContent) root;
          var destinationOwner = DestinationUtil.getDestinationOwner(getWizard().getProject());
          contentForImport.getTags()
              .removeAll(contentForImport.getTags()
                  .stream()
                  .filter(t -> !StringUtil.isEmpty(t.getOwner())
                      && !destinationOwner.equals(t.getOwner()))
                  .collect(Collectors.toList()));
          setTreeInput();
          validatePage(null);
        }
      }
      setToolbarEnabled(tagTree.hasViewerInput());
    } catch (IOException e) {
      setErrorMessage(MessageFormat.format("Source file could not be loaded from {0}", filePath));
      e.printStackTrace();
    }
  }

  private void onTagSelectionChanged() {
    setTgobjInput();
    tgobjTable.resetFilter();

    updateTagTreeCheckedLabel();
    updateTgobjTableCheckedLabel();
  }

  private void setTgobjInput() {
    // REVISIT: cache the already filtered objects
    var input = taggedObjects.stream()
        .filter(o -> o.tgObj.getTagId().equals(selectedTagId))
        .collect(Collectors.toList());

    var newTableMode = OBJ_TABLE_MODE;
    if (input.stream().anyMatch(obj -> obj.tgObj.getParentObjectName() != null)) {
      newTableMode = PARENT_OBJ_TABLE_MODE;
    }

    cacheTableColumnWidths();
    if (newTableMode != tableMode) {
      disposeColumns();
    }

    tableMode = newTableMode;
    createColumns(tableMode);
    setShellSizeForTable(tableMode);

    tgobjTableViewer.setInput(input);

    // update checked state
    tgobjTableViewer.setCheckedElements(
        input.stream().filter(el -> el.checked).collect(Collectors.toList()).toArray());

  }

  @SuppressWarnings("unchecked")
  private void setTgobjAllChecked(final boolean checked) {
    if (selectedTagId == null) {
      return;
    }
    tgobjTableViewer.setAllChecked(checked);
    ((List<CheckableTaggedObjectInfo>) tgobjTableViewer.getInput())
        .forEach(el -> el.checked = checked);

    if (checked && !tagTree.getCheckedTags().contains(selectedTag)) {
      tagTree.setTagChecked(selectedTag, true, false);
      propagateTagCheckedStateToParents(selectedTag, true);
    }
  }

  private void onTgobjCheckStateChanged(final CheckableTaggedObjectInfo checkableTgobj,
      final boolean state) {
    checkableTgobj.checked = state;

    // check if current tag is checked in the tree
    if (!tagTree.getCheckedTags().contains(selectedTag)) {
      tagTree.setTagChecked(selectedTag, true, false);
      propagateTagCheckedStateToParents(selectedTag, true);
      validatePage(null);
    } else {
      // we only need to update the checked label
      updateTgobjTableCheckedLabel();
    }
  }

  private void propagateTagCheckedStateToParents(final ITag tag, final boolean state) {
    if (state) {
      tagTree.setParentTagsChecked(tag, true);
    } else {
      tagTree.setTagChildrenCheckedRecursive(tag, false);
    }
    // adds the checked
    tagTree.setCheckedElementsInTree();
    tagTree.refresh();
  }

  private void onTagCheckStateChanged(final ITag tag, final boolean state) {
    propagateTagCheckedStateToParents(tag, state);

    syncTagCheckedStateToTgObj();
    tgobjTableViewer.setAllChecked(state);

    validatePage(null);
  }

  @SuppressWarnings("unchecked")
  private void syncCurrentTgobjCheckedStateToViewer() {
    var currentInput = (List<CheckableTaggedObjectInfo>) tgobjTableViewer.getInput();
    if (currentInput == null) {
      return;
    }

    tgobjTableViewer.setCheckedElements(
        currentInput.stream().filter(el -> el.checked).collect(Collectors.toList()).toArray());
  }

  private void syncTagCheckedStateToTgObj() {
    var checkedTags = tagTree.getCheckedTags()
        .stream()
        .map(ITag::getId)
        .collect(Collectors.toSet());
    taggedObjects.forEach(el -> el.checked = checkedTags.contains(el.tgObj.getTagId()));
  }

  private void validatePage(final IStatus status) {
    setDirty(true);
    getWizard().setCanFinish(false);

    var pageStatus = status;

    var selectedTags = tagTree != null ? tagTree.getCheckedTags() : null;
    if (selectedTags == null || selectedTags.isEmpty()) {
      pageStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.INFO,
          Messages.TagSelectionWizardPage_NoTagsSelectedInfo_xmsg, null);
    } else {
      pageStatus = Status.OK_STATUS;
    }

    updateTagTreeCheckedLabel();
    updateTgobjTableCheckedLabel();
    getWizard().setCanFinish(pageStatus == null || pageStatus.isOK());
    updatePageCompletedStatus(pageStatus);
  }

  private void setTreeInput() {
    tagTree.setTags(contentForImport.getTags(), false);
    setToolbarEnabled(tagTree.hasViewerInput());
    tagTree.expandAll();
    tagTree.refresh();
    tagTree.selectFirstItem();
    tagTree.setFocus();

  }

  private void createActions() {
    selectSubTreeAction = new SelectTagSubtreeAction(tagTree);
    selectSubTreeAction.setPostRunHandler(() -> validatePage(null));
  }

  private void createTagsCheckedInfoSection(final Composite parent) {
    treeSelectionInfo = new Label(parent, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(treeSelectionInfo);
  }

  private void createTgobjCheckedInfoSection(final Composite parent) {
    var labelComp = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(labelComp);
    GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).equalWidth(true).applyTo(labelComp);
    tgobjOfCurrentTagCheckInfo = new Label(labelComp, SWT.NONE);
    GridDataFactory.fillDefaults()
        .align(SWT.BEGINNING, SWT.CENTER)
        .applyTo(tgobjOfCurrentTagCheckInfo);

    overallTgobjCheckInfo = new Label(labelComp, SWT.NONE);
    GridDataFactory.fillDefaults()
        .align(SWT.END, SWT.CENTER)
        .grab(true, false)
        .applyTo(overallTgobjCheckInfo);
  }

  private void createTagsTree(final Composite parent) {
    var group = new Group(parent, SWT.NONE);
    group.setText(Messages.TagSelectionWizardPage_TagsTreeGroup_xtit);
    GridDataFactory.fillDefaults()
        .grab(false, true)
        .minSize(430, SWT.DEFAULT)
        .hint(430, SWT.DEFAULT)
        .applyTo(group);
    GridLayoutFactory.swtDefaults().applyTo(group);

    tagTree = new TagSelectionTree() {
      @Override
      protected void applyTreeLayoutData(final Tree tree) {
        GridDataFactory.fillDefaults()
            .align(SWT.FILL, SWT.FILL)
            .grab(false, true)
            .minSize(410, 200)
            .hint(SWT.DEFAULT, tree.getItemHeight() * 15)
            .applyTo(tree);
      }
    };

    treeLabelProvider = new TreeViewerLabelProvider();
    treeContentProvider = new TagTreeContentProvider();
    tagTree.setContentProvider(treeContentProvider);
    tagTree.setLabelProvider(treeLabelProvider);

    tagTree.createControl(group);

    tagTree
        .addCheckStateListener(e -> onTagCheckStateChanged((ITag) e.getElement(), e.getChecked()));
    tagTree.addSelectionChangedListener(event -> {
      var selObj = tagTree.getSelection().getFirstElement();
      if (selObj != null) {
        var tag = (ITag) selObj;
        selectedTag = tag;
        selectedTagId = tag.getId();
      } else {
        selectedTag = null;
        selectedTagId = null;
      }
      onTagSelectionChanged();
    });
    tagTree.addKeyListenerForFilterFocus();

    createTagsCheckedInfoSection(group);
  }

  private void createTgobjTable(final Composite parent) {
    var group = new Group(parent, SWT.NONE);
    group.setText("Tagged &Objects");
    GridDataFactory.fillDefaults().grab(true, true).minSize(200, SWT.DEFAULT).applyTo(group);
    GridLayoutFactory.swtDefaults().applyTo(group);

    tgobjTable = new FilterableTable(group, null, false, FilterableComposite.TOOLBAR) {
      @Override
      protected void filterJobCompleted(final boolean hasFilter) {
        super.filterJobCompleted(hasFilter);
        syncCurrentTgobjCheckedStateToViewer();
      }

    };
    tgobjTable.setElementMatcher(el -> {
      var wordMatcher = tgobjTable.getWordMatcher();
      var tgobjInfo = ((CheckableTaggedObjectInfo) el).tgObj;
      return wordMatcher.matchesWord(tgobjInfo.getObjectName())
          || wordMatcher.matchesWord(tgobjInfo.getComponentName())
          || wordMatcher.matchesWord(tgobjInfo.getTagName())
          || wordMatcher.matchesWord(tgobjInfo.getParentObjectName())
          || wordMatcher.matchesWord(tgobjInfo.getParentTagName());
    });

    tgobjTableViewer = CheckboxTableViewer.newCheckList(tgobjTable,
        SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);

    tgobjTable.setViewer(tgobjTableViewer);

    objTableModeDefaultWidth = getTgobjTableWidth(OBJ_TABLE_MODE);

    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.FILL)
        .grab(true, true)
        .minSize(200, 200)
        // start with a fixed hint
        .hint(objTableModeDefaultWidth, tgobjTableViewer.getTable().getItemHeight() * 15)
        .applyTo(tgobjTableViewer.getTable());

    tgobjTableViewer.getTable().setHeaderVisible(true);

    tgobjTableViewer.setContentProvider(new ArrayContentProvider());
    tgobjTable.addKeyListenerForFilterFocus();
    tgobjTableViewer.addCheckStateListener(
        e -> onTgobjCheckStateChanged((CheckableTaggedObjectInfo) e.getElement(), e.getChecked()));

    createTgobjCheckedInfoSection(group);
  }

  private int getTgobjTableWidth(final int mode) {
    return Stream.of(ColumnViewerSpec.values())
        .filter(c -> mode == OBJ_TABLE_MODE ? !c.parentTagMode : true)
        .map(c -> {
          var colWidth = colWidths.getOrDefault(c, c.defaultWidth);
          return colWidth < c.defaultWidth ? c.defaultWidth : colWidth;
        })
        .reduce(0, Integer::sum);
  }

  private void disposeColumns() {
    Stream.of(tgobjTableViewer.getTable().getColumns()).forEach(TableColumn::dispose);
  }

  private void cacheTableColumnWidths() {
    Stream.of(tgobjTableViewer.getTable().getColumns())
        .forEach(c -> colWidths.put((ColumnViewerSpec) c.getData(), c.getWidth()));
  }

  private void createColumns(final int tableMode) {
    if (tgobjTableViewer.getTable().getColumnCount() > 0) {
      return;
    }

    for (var colSpec : ColumnViewerSpec.values()) {
      if (tableMode == OBJ_TABLE_MODE && colSpec.parentTagMode) {
        continue;
      }
      var tableColumn = new TableViewerColumn(tgobjTableViewer, SWT.NONE);
      var column = tableColumn.getColumn();
      column.setText(colSpec.headerText);

      var width = colWidths.getOrDefault(colSpec, colSpec.defaultWidth);
      column.setWidth(width < colSpec.defaultWidth ? colSpec.defaultWidth : width);
      column.setMoveable(false);
      column.setData(colSpec);
      tableColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(
          new TaggedObjectColumnLabelProvider(colSpec, getWizard().getProject())));
    }
  }

  private void createTagScopeCombo(final Composite parent) {
    final var tagScopeContainer = new Composite(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(tagScopeContainer);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(tagScopeContainer);
    final var tagScopeLabel = new Label(tagScopeContainer, SWT.NONE);
    tagScopeLabel.setText(Messages.TagSelectionWizardPage_TagScope_xlbl);
    tagTypeCombo = new Combo(tagScopeContainer, SWT.READ_ONLY);
    tagTypeCombo.setItems(Stream.of(TagSearchScope.values())
        .filter(s -> !s.equals(TagSearchScope.SHARED))
        .map(scope -> {
          switch (scope) {
          case ALL:
            return Messages.TagSelectionWizardPage_TagScopeAll_xlbl;
          case GLOBAL:
            return Messages.TagSelectionWizardPage_TagScopeGlobal_xlbl;
          case USER:
            return Messages.TagSelectionWizardPage_TagScopeUser_xlbl;
          default:
            return ""; //$NON-NLS-1$
          }
        })
        .toArray(String[]::new));
    tagTypeCombo.select(0);
    tagTypeCombo.addModifyListener(e -> {
      var selectedScope = tagTypeCombo.getItem(tagTypeCombo.getSelectionIndex());
      treeContentProvider.setVisbleTagScope(TagSearchScope.getByName(selectedScope.toUpperCase()));
      tagTree.refresh();
      tagTree.setCheckedElementsInTree();
    });
  }

  private void createTreeToolbar(final Composite parent) {
    treeToolBar = new ToolBar(parent, SWT.FLAT | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().align(SWT.END, SWT.END).applyTo(treeToolBar);

    new ToolItem(treeToolBar, SWT.SEPARATOR);

    var expandAll = new ToolItem(treeToolBar, SWT.PUSH);
    expandAll.setToolTipText(Messages.TagSelectionWizardPage_ExpandAll_xbut);
    expandAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.EXPAND_ALL));
    expandAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagTree.expandAll();
    }));

    final var collapseAll = new ToolItem(treeToolBar, SWT.PUSH);
    collapseAll.setToolTipText(Messages.TagSelectionWizardPage_CollapseAll_xbut);
    collapseAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.COLLAPSE_ALL));
    collapseAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagTree.collapseAll();
    }));

    new ToolItem(treeToolBar, SWT.SEPARATOR);

    final var checkAll = new ToolItem(treeToolBar, SWT.PUSH);
    checkAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.SelectAll_xlbl));

    checkAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.CHECK_ALL));
    checkAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagTree.checkAll();
      syncTagCheckedStateToTgObj();
      tgobjTableViewer.setAllChecked(true);
      validatePage(null);
    }));

    final var uncheckAll = new ToolItem(treeToolBar, SWT.PUSH);
    uncheckAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.DeselectAll_xlbl));

    uncheckAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.UNCHECK_ALL));
    uncheckAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagTree.setCheckedTags(null);
      syncTagCheckedStateToTgObj();
      tgobjTableViewer.setAllChecked(false);
      validatePage(null);
    }));

    setToolbarEnabled(false);
  }

  private void createTableToolbar(final Composite parent) {
    tableToolBar = new ToolBar(parent, SWT.FLAT | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().align(SWT.END, SWT.END).applyTo(treeToolBar);

    final var checkAll = new ToolItem(tableToolBar, SWT.PUSH);
    checkAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.SelectAll_xlbl));

    checkAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.CHECK_ALL));
    checkAll.addSelectionListener(widgetSelectedAdapter(l -> {
      setTgobjAllChecked(true);

      validatePage(null);
    }));

    final var uncheckAll = new ToolItem(tableToolBar, SWT.PUSH);
    uncheckAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.DeselectAll_xlbl));

    uncheckAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.UNCHECK_ALL));
    uncheckAll.addSelectionListener(widgetSelectedAdapter(l -> {
      setTgobjAllChecked(false);
      validatePage(null);
    }));

    setToolbarEnabled(false);
  }

  private void createSelectOptionsGroup(final Composite root) {
    var group = new Group(root, SWT.NONE);
    group.setText(Messages.TagSelectionWizardPage_SelectionOptions_xgrp);
    GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(group);
    GridLayoutFactory.swtDefaults().applyTo(group);

    includeSharedUserInfo = new Button(group, SWT.CHECK);
    GridDataFactory.fillDefaults().applyTo(includeSharedUserInfo);
    includeSharedUserInfo.setText("&Include information about shared tags");
  }

  private void createViewerContextMenu() {
    final var menuMgr = new MenuManager();
    menuMgr.setRemoveAllWhenShown(true);

    menuMgr.addMenuListener(menu -> {
      fillContextMenu(menu);
    });
    tagTree.hookContextMenu(menuMgr);
  }

  private void fillContextMenu(final IMenuManager menu) {
    if (selectSubTreeAction.hasTreeValidSelectionForAction()) {
      menu.add(selectSubTreeAction);
    }
  }

  private void setShellSizeForTable(final int tableMode) {
    var tableLayoutData = (GridData) tgobjTableViewer.getTable().getLayoutData();
    if (tableMode == PARENT_OBJ_TABLE_MODE) {
      tableLayoutData.widthHint = SWT.DEFAULT;
      getWizard().updateShellSize();
    } else {
      var userTableAdjustmentWidth = getTgobjTableWidth(OBJ_TABLE_MODE) - objTableModeDefaultWidth;
      var smallTableDialogWidth = getPreferredShellSize().width + userTableAdjustmentWidth;
      if (smallTableDialogWidth > 0) {
        getShell().setSize(smallTableDialogWidth, getShell().getSize().y);
      }
    }
  }

  private void updateTagTreeCheckedLabel() {
    if (treeSelectionInfo == null) {
      return;
    }
    var checkedCount = tagTree.getCheckedTags().size();

    treeSelectionInfo.setText(String.format(Messages.TagSelectionWizardPage_TagSelectionFormat_xmsg,
        checkedCount == 0 ? Messages.General_No_xlbl : String.valueOf(checkedCount),
        checkedCount == 1 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$
        Messages.DeleteTagsWizardPage_Selected_xlbl));
  }

  private void updateTgobjTableCheckedLabel() {
    if (tgobjOfCurrentTagCheckInfo == null) {
      return;
    }
    var checkedCount = tgobjTableViewer.getCheckedElements().length;

    tgobjOfCurrentTagCheckInfo.setText(String.format("%s Object%s %s",
        checkedCount == 0 ? Messages.General_No_xlbl : SELECTION_FORMAT.format(checkedCount),
        checkedCount == 1 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$
        Messages.DeleteTagsWizardPage_Selected_xlbl));

    var overallCheckedCount = taggedObjects.stream().filter(o -> o.checked).count();
    overallTgobjCheckInfo.setText(String.format("(%s Object%s %s overall)",
        overallCheckedCount == 0 ? Messages.General_No_xlbl
            : SELECTION_FORMAT.format(overallCheckedCount),
        overallCheckedCount == 1 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$
        Messages.DeleteTagsWizardPage_Selected_xlbl));

    tgobjOfCurrentTagCheckInfo.getParent().layout();
  }

  private void setToolbarEnabled(final boolean enabled) {
    if (treeToolBar == null) {
      return;
    }
    Stream.of(treeToolBar.getItems()).forEach(i -> i.setEnabled(enabled));
  }
}
