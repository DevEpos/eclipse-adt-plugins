package com.devepos.adt.atm.ui.internal.wizard.export;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.tagging.IAdtObjTaggingService;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.tags.IAbapTagsService;
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
import com.devepos.adt.base.ui.project.ProjectInput;
import com.devepos.adt.base.ui.wizard.AbstractBaseWizardPage;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.util.ui.swt.AdtSWTUtilFactory;

public class TagSelectionWizardPage extends AbstractBaseWizardPage {
  public static final String PAGE_NAME = TagSelectionWizardPage.class.getCanonicalName();

  private Job tagLoadingJob;

  private final IAbapTagsService tagsService;
  private final IAdtObjTaggingService taggingService;
  private ProjectInput projectInput;
  private boolean projectInvalid;

  private TagSelectionTree tagSelectionTree;
  private Text fileInput;
  private Combo tagTypeCombo;
  private ToolBar toolBar;
  private Label selectionInfo;

  private SelectTagSubtreeAction selectSubTreeAction;

  private TagTreeContentProvider treeContentProvider;
  private TreeViewerLabelProvider treeLabelProvider;

  private Button includeSharedUserInfo;
  private Button overwriteFileWithoutWarning;

  public TagSelectionWizardPage() {
    super(PAGE_NAME);
    setTitle(Messages.TagSelectionWizardPage_Title_xmsg);
    tagsService = AbapTagsServiceFactory.createTagsService();
    taggingService = AdtObjTaggingServiceFactory.createTaggingService();
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

  private enum ValidationSource {
    PROJECT,
    EXPORT_FILE,
    TAGS
  }

  @Override
  public void createControl(final Composite parent) {
    final var root = new Composite(parent, SWT.NONE);

    // TODO: Help Context
    // HelpUtil.setHelp(root, HelpContexts.UNASSIGN_TAGS_WIZARD_TAG_SELECTION);
    GridLayoutFactory.swtDefaults().applyTo(root);

    createProjectInput(root);
    createTagsCheckBoxTree(root);
    createViewerContextMenu();
    createSelectOptionsGroup(root);
    createTargetFileSection(root);

    var treeActionsComposite = new Composite(tagSelectionTree.getFilterComposite(), SWT.NONE);
    GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).applyTo(treeActionsComposite);
    GridDataFactory.fillDefaults().applyTo(treeActionsComposite);

    createTagScopeCombo(treeActionsComposite);
    createTreeToolbar(treeActionsComposite);
    createActions();

    setControl(root);
    setPageComplete(false);
  }

  @Override
  public void completePage() {
    if (!isDirty()) {
      return;
    }
    var wizard = getWizard();
    var exportRequest = wizard.getTagExportRequest();
    exportRequest.getTagIds().clear();
    exportRequest.getTagIds()
        .addAll(tagSelectionTree.getCheckedTags()
            .stream()
            .map(t -> t.getId())
            .collect(Collectors.toList()));
    exportRequest.setIncludeSharedTagsInfo(includeSharedUserInfo.getSelection());
    wizard.setOverwriteFileNoWarning(overwriteFileWithoutWarning.getSelection());
    wizard.setExportFileName(fileInput.getText());

    setDirty(false);
  }

  @Override
  public ExportAbapTagsWizard getWizard() {
    return (ExportAbapTagsWizard) super.getWizard();
  }

  @Override
  public void setVisible(final boolean visible) {
    if (visible && !isPageComplete()) {
      getWizard().completePreviousPage(this);
      refreshTags();
      validatePage(null, ValidationSource.TAGS);
      tagSelectionTree.setFocus();
    }
    super.setVisible(visible);
  }

  private void createActions() {
    selectSubTreeAction = new SelectTagSubtreeAction(tagSelectionTree);
    selectSubTreeAction.setPostRunHandler(() -> validatePage(null, ValidationSource.TAGS));
  }

  private void createProjectInput(final Composite parent) {
    projectInput = new ProjectInput(true);

    var projectComposite = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(projectComposite);
    GridLayoutFactory.swtDefaults().applyTo(projectComposite);
    projectInput.createControl(projectComposite);

    projectInput.addProjectValidator(project -> {
      var tagFeatureStatus = tagsService.testTagsFeatureAvailability(project);
      return tagFeatureStatus.isOK() ? taggingService.testTagsExportFeatureAvailability(project)
          : tagFeatureStatus;
    });
    projectInput.addStatusChangeListener(status -> {
      projectInvalid = !status.isOK();
      if (status.isOK()) {
        var wizard = getWizard();
        final var newProject = projectInput.getProjectProvider().getProject();
        final var oldProject = wizard.getProject();
        wizard.setProject(newProject);
        if (newProject != oldProject
            || tagSelectionTree != null && !tagSelectionTree.hasViewerInput()) {
          tagSelectionTree.uncheckAll();
          refreshTags();
        }
      }
      validatePage(status, ValidationSource.PROJECT);
    });
    var currentProject = getWizard().getProject();
    if (currentProject != null) {
      projectInput.setProjectName(currentProject.getName());
    } else {
      projectInput.setProjectName(null);
      projectInput.setFocus();
    }
  }

  private void createTargetFileSection(final Composite parent) {
    var group = new Group(parent, SWT.NONE);
    group.setText(Messages.TagSelectionWizardPage_Target_xgrp);
    GridLayoutFactory.swtDefaults().numColumns(3).applyTo(group);
    GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(group);

    var label = new Label(group, SWT.NONE);
    label.setText(Messages.TagSelectionWizardPage_TargetFile_xlbl);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(label);

    fileInput = new Text(group, SWT.BORDER | SWT.READ_ONLY);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(fileInput);

    var browseButton = new Button(group, SWT.PUSH);
    browseButton.setText(
        StringUtil.setMnemonic(AdtBaseUIResources.getString(IAdtBaseStrings.Browse_xbtn), "w") + //$NON-NLS-1$
            "..."); //$NON-NLS-1$
    browseButton.addSelectionListener(widgetSelectedAdapter(l -> {
      var fileDialog = new FileDialog(getShell(), SWT.SAVE);
      if (!StringUtil.isEmpty(fileInput.getText())) {
        var file = new File(fileInput.getText());
        fileDialog.setFileName(file.getName());
      } else {
        fileDialog.setFileName(String.format("ABAP-Tags_%s_%s", //$NON-NLS-1$
            DestinationUtil.getSystemId(DestinationUtil.getDestinationId(getWizard().getProject())),
            LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))); //$NON-NLS-1$
      }
      fileDialog.setFilterExtensions(new String[] { "*.xml" }); //$NON-NLS-1$
      var fileName = fileDialog.open();
      if (fileName != null) {
        fileInput.setText(fileName);
      } else {
        fileInput.setText(""); //$NON-NLS-1$
      }
      validatePage(null, ValidationSource.EXPORT_FILE);
    }));
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(browseButton);
    AdtSWTUtilFactory.getOrCreateSWTUtil().setButtonWidthHint(browseButton);

    overwriteFileWithoutWarning = new Button(group, SWT.CHECK);
    overwriteFileWithoutWarning.setText(Messages.TagSelectionWizardPage_OverwriteExisting_xchk);
    GridDataFactory.fillDefaults().span(3, 1).applyTo(overwriteFileWithoutWarning);
  }

  private void createSelectionInfo(final Composite parent) {
    selectionInfo = new Label(parent, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(selectionInfo);
  }

  private void createTagsCheckBoxTree(final Composite parent) {
    var group = new Group(parent, SWT.NONE);
    group.setText(Messages.TagSelectionWizardPage_TagsTreeGroup_xtit);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(group);
    GridLayoutFactory.swtDefaults().applyTo(group);

    tagSelectionTree = new TagSelectionTree() {
      @Override
      protected void applyTreeLayoutData(final Tree tree) {
        GridDataFactory.fillDefaults()
            .align(SWT.FILL, SWT.FILL)
            .grab(true, true)
            .minSize(250, 200)
            .hint(SWT.DEFAULT, tree.getItemHeight() * 12)
            .applyTo(tree);
      }
    };

    treeLabelProvider = new TreeViewerLabelProvider();
    treeLabelProvider.setMarkOwnSharedTags(true);
    treeContentProvider = new TagTreeContentProvider();
    tagSelectionTree.setContentProvider(treeContentProvider);
    tagSelectionTree.setLabelProvider(treeLabelProvider);
    tagSelectionTree.addCheckStateListener(l -> {
      if (l != null) {
        var tag = (ITag) l.getElement();
        if (l.getChecked()) {
          tagSelectionTree.setParentTagsChecked(tag, true);
        } else {
          tagSelectionTree.setTagChildrenCheckedRecursive(tag, false);
        }
        tagSelectionTree.setCheckedElementsInTree();
        tagSelectionTree.refresh();
      }
      validatePage(null, ValidationSource.TAGS);
    });
    tagSelectionTree.createControl(group);
    tagSelectionTree.addKeyListenerForFilterFocus();

    createSelectionInfo(group);
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
      var selectedScopeId = tagTypeCombo.getItem(tagTypeCombo.getSelectionIndex());
      var selectedScope = TagSearchScope.getByName(selectedScopeId.toUpperCase());
      treeContentProvider.setVisbleTagScope(selectedScope);
      tagSelectionTree.setTagSearchScope(selectedScope);
      tagSelectionTree.refresh();
      tagSelectionTree.setCheckedElementsInTree();
    });
  }

  private void createTreeToolbar(final Composite parent) {
    toolBar = new ToolBar(parent, SWT.FLAT | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().align(SWT.END, SWT.END).applyTo(toolBar);

    new ToolItem(toolBar, SWT.SEPARATOR);

    var expandAll = new ToolItem(toolBar, SWT.PUSH);
    expandAll.setToolTipText(Messages.TagSelectionWizardPage_ExpandAll_xbut);
    expandAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.EXPAND_ALL));
    expandAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagSelectionTree.expandAll();
    }));

    final var collapseAll = new ToolItem(toolBar, SWT.PUSH);
    collapseAll.setToolTipText(Messages.TagSelectionWizardPage_CollapseAll_xbut);
    collapseAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.COLLAPSE_ALL));
    collapseAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagSelectionTree.collapseAll();
    }));

    new ToolItem(toolBar, SWT.SEPARATOR);

    final var checkAll = new ToolItem(toolBar, SWT.PUSH);
    checkAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.SelectAll_xlbl));

    checkAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.CHECK_ALL));
    checkAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagSelectionTree.checkAll();
      validatePage(null, ValidationSource.TAGS);
    }));

    final var uncheckAll = new ToolItem(toolBar, SWT.PUSH);
    uncheckAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.DeselectAll_xlbl));

    uncheckAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.UNCHECK_ALL));
    uncheckAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagSelectionTree.uncheckAll();
      validatePage(null, ValidationSource.TAGS);
    }));

    setToolbarEnabled(false);
  }

  private void createSelectOptionsGroup(final Composite root) {
    var group = new Group(root, SWT.NONE);
    group.setText(Messages.TagSelectionWizardPage_SelectionOptions_xgrp);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(group);
    GridLayoutFactory.swtDefaults().applyTo(group);

    includeSharedUserInfo = new Button(group, SWT.CHECK);
    GridDataFactory.fillDefaults().applyTo(includeSharedUserInfo);
    includeSharedUserInfo.setText(Messages.TagSelectionWizardPage_IncludeSharedUserInfo_xchk);

  }

  private void createViewerContextMenu() {
    final var menuMgr = new MenuManager();
    menuMgr.setRemoveAllWhenShown(true);

    menuMgr.addMenuListener(menu -> {
      fillContextMenu(menu);
    });
    tagSelectionTree.hookContextMenu(menuMgr);
  }

  private void fillContextMenu(final IMenuManager menu) {
    if (selectSubTreeAction.hasTreeValidSelectionForAction()) {
      menu.add(selectSubTreeAction);
    }
  }

  private void refreshTags() {
    if (projectInvalid) {
      return;
    }
    final var project = getWizard().getProject();
    if (project == null) {
      return;
    }
    if (tagLoadingJob != null && tagLoadingJob.getResult() == null) {
      tagLoadingJob.cancel();
    }
    tagLoadingJob = Job.create(Messages.TagSelectionWizardPage_RetrieveTagsContentJob_xmsg,
        monitor -> {
          final var tagList = tagsService.readTags(DestinationUtil.getDestinationId(project),
              List.of(TagSearchScope.USER, TagSearchScope.GLOBAL), true);

          Display.getDefault().asyncExec(() -> {
            tagSelectionTree.setTags(tagList.getTags(), true);
            tagSelectionTree.expandAll();
            tagSelectionTree.refresh();
            tagSelectionTree.selectFirstItem();
            tagSelectionTree.setFocus();

            setToolbarEnabled(tagSelectionTree.hasViewerInput());
          });
          monitor.done();
        });
    tagLoadingJob.schedule();
  }

  private void updateCheckedLabel() {
    if (selectionInfo == null) {
      return;
    }
    var checkedCount = tagSelectionTree.getCheckedTags().size();

    selectionInfo.setText(String.format(Messages.TagSelectionWizardPage_TagSelectionFormat_xmsg,
        checkedCount == 0 ? Messages.General_No_xlbl : String.valueOf(checkedCount),
        checkedCount == 1 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$
        Messages.DeleteTagsWizardPage_Selected_xlbl));

    getWizard().setCanFinish(checkedCount > 0 && !StringUtil.isEmpty(fileInput.getText()));
  }

  private void validatePage(final IStatus status, final ValidationSource source) {
    setDirty(true);
    getWizard().setCanFinish(false);

    IStatus pageStatus = status;
    boolean validateTags = false;
    boolean validateFile = false;

    if (source == ValidationSource.PROJECT) {
      if (!pageStatus.isOK()) {
        if (tagSelectionTree != null && tagSelectionTree.hasViewerInput()) {
          tagSelectionTree.setTags(null, false);
        }
        setToolbarEnabled(false);
      } else {
        setToolbarEnabled(true);
        // if project validation is successful continue with Tags validation
        validateTags = true;
      }
    } else if (source == ValidationSource.TAGS) {
      if (projectInvalid) {
        return;
      }
      validateTags = true;
    } else if (source == ValidationSource.EXPORT_FILE) {
      if (projectInvalid) {
        return;
      }
      validateFile = true;
    }

    if (validateTags) {
      var selectedTags = tagSelectionTree != null ? tagSelectionTree.getCheckedTags() : null;
      if (selectedTags == null || selectedTags.isEmpty()) {
        pageStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.INFO,
            Messages.TagSelectionWizardPage_NoTagsSelectedInfo_xmsg, null);
      } else {
        pageStatus = Status.OK_STATUS;
        validateFile = true;
      }
    }
    if (validateFile) {
      if (StringUtil.isEmpty(fileInput.getText())) {
        pageStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.INFO,
            Messages.TagSelectionWizardPage_SelectFileInfo_xmsg, null);
      } else {
        pageStatus = Status.OK_STATUS;
      }
    }

    updateCheckedLabel();
    updatePageCompletedStatus(pageStatus);
  }

  private void setToolbarEnabled(final boolean enabled) {
    if (toolBar == null) {
      return;
    }
    Stream.of(toolBar.getItems()).forEach(i -> i.setEnabled(enabled));
  }
}
