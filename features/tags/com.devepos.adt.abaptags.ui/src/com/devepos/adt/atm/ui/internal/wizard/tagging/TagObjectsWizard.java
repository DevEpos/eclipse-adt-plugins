package com.devepos.adt.atm.ui.internal.wizard.tagging;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.ui.wizard.AbstractWizardBase;
import com.devepos.adt.base.ui.wizard.IBaseWizardPage;
import com.devepos.adt.base.util.StringUtil;

/**
 * Wizard for managing the tags of one or several ADT Objects
 *
 * @author stockbal
 */
/**
 *
 */
public class TagObjectsWizard extends AbstractWizardBase {

  private final ITaggedObjectList taggedObjectList = IAbapTagsFactory.eINSTANCE
      .createTaggedObjectList();
  private IAdtObjRefList selectedAdtObjRefList = IAdtBaseFactory.eINSTANCE.createAdtObjRefList();
  private ITagPreviewInfo tagPreviewInfo = IAbapTagsFactory.eINSTANCE.createTagPreviewInfo();
  private final boolean skipObjectSelection;
  private List<ITag> selectedTags;
  private boolean success;
  private Map<ITag, List<IAdtObjectTag>> transientTag2ObjTags;
  private boolean newTagsViaClientEnabled;

  public TagObjectsWizard() {
    this(false);
  }

  public TagObjectsWizard(final boolean skipObjectSelection) {
    setDefaultPageImageDescriptor(
        AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.TAGS_WIZBAN_DEFAULT));
    setWindowTitle(Messages.TagObjectsWizard_WizardTitle_xtit);
    setNeedsProgressMonitor(true);
    this.skipObjectSelection = skipObjectSelection;
  }

  @Override
  public void addPages() {
    if (!skipObjectSelection) {
      addPage(new TaggableObjectSelectionWizardPage());
    }
    addPage(new TagSelectionWizardPage());
    addPage(new TagParentObjectSelectionWizardPage());
  }

  public void clearTaggedObjects() {
    taggedObjectList.getTaggedObjects().clear();
  }

  public void setTransientTag2ObjTags(final Map<ITag, List<IAdtObjectTag>> transientTag2ObjTags) {
    this.transientTag2ObjTags = transientTag2ObjTags;
  }

  @Override
  public void createPageControls(final Composite pageContainer) {
    /*
     * page controls will be initialized on demand. This ensures that the wizard
     * dialog will not be unnecessarily big at initial open due to some pages
     * needing more space
     */
  }

  public ITagPreviewInfo getCurrentTagPreviewInfo() {
    return tagPreviewInfo;
  }

  public IAdtObjRefList getSelectedObjects() {
    return selectedAdtObjRefList;
  }

  public List<ITag> getSelectedTags() {
    if (selectedTags == null) {
      selectedTags = new ArrayList<>();
    }
    return selectedTags;
  }

  public ITaggedObjectList getTaggedObjectList() {
    return taggedObjectList;
  }

  @Override
  public boolean performFinish() {
    var project = getProject();
    if (project == null) {
      return false;
    }
    // complete current page
    final var currentPage = getContainer().getCurrentPage();
    if (currentPage instanceof IBaseWizardPage) {
      ((IBaseWizardPage) currentPage).completePage();
    }
    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask(Messages.TagObjectsWizard_AddTagsToObjectsJob_xmsg, -1);
        try {
          persistChanges(project);
          success = true;
        } catch (final CoreException e) {
          throw new InvocationTargetException(e);
        }
      });
    } catch (final InvocationTargetException e) {
      Display.getDefault().asyncExec(() -> {
        final var message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        MessageDialog.openError(getShell(), Messages.AbapTagManagerView_ErrorMessageTitle_xtit,
            message);
      });
      return false;
    } catch (final InterruptedException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public void setCurrentTagPreviewInfo(final ITagPreviewInfo tagPreviewInfo) {
    if (tagPreviewInfo != null) {
      this.tagPreviewInfo = tagPreviewInfo;
    } else {
      this.tagPreviewInfo.getTags().clear();
      this.tagPreviewInfo.getAdtObjectRefs().clear();
    }
  }

  public void setSelectedObjects(final IAdtObjRefList selectedObjects) {
    if (selectedObjects == null) {
      selectedAdtObjRefList.getObjectReferences().clear();
    } else {
      selectedAdtObjRefList = selectedObjects;
    }
  }

  @Override
  public void setProject(final IProject project) {
    super.setProject(project);
    var features = AbapTagsServiceFactory.createTagsService()
        .getTaggingFeatures(DestinationUtil.getDestinationId(getProject()));
    newTagsViaClientEnabled = features != null
        && features.isFeatureEnabled("createUpdateHasResponse");
  }

  public boolean isNewTagsViaClientEnabled() {
    return newTagsViaClientEnabled;
  }

  public void setSelectedTags(final List<ITag> tags) {
    selectedTags = tags;

  }

  /**
   * Returns {@code true} if the tagging wizard completed with success
   *
   * @return {@code true} if the tagging wizard completed with success
   */
  public boolean wasSuccessful() {
    return success;
  }

  private void persistChanges(final IProject project) throws CoreException {
    if (transientTag2ObjTags != null && !transientTag2ObjTags.isEmpty()) {
      persistTransientTags(project);
    }
    AdtObjTaggingServiceFactory.createTaggingService()
        .saveTaggedObjects(DestinationUtil.getDestinationId(project), taggedObjectList);
  }

  private void persistTransientTags(final IProject project) throws CoreException {
    var sortedTags = getSortedTransientTags();
    for (var transientTag : sortedTags) {
      var updateList = IAbapTagsFactory.eINSTANCE.createTagList();
      var updateTag = IAbapTagsFactory.eINSTANCE.createTag();
      updateTag.setName(transientTag.getName());
      updateTag.setOwner(transientTag.getOwner());
      updateTag.setParentTagId(transientTag.getParentTagId());
      updateList.getTags().add(updateTag);
      var updatedTagsList = AbapTagsServiceFactory.createTagsService()
          .updateTags(updateList, DestinationUtil.getDestinationId(project),
              StringUtil.isEmpty(transientTag.getOwner()) ? TagSearchScope.GLOBAL
                  : TagSearchScope.USER);
      var updatedTag = updatedTagsList.getTags().get(0);
      // update the IAdtObjectTags with the new tag ID
      var objectTags = transientTag2ObjTags.get(transientTag);
      if (objectTags != null) {
        objectTags.forEach(objTag -> objTag.setId(updatedTag.getId()));
      }
      // update child tags' parentTagId and their objectTags' parentTagId
      transientTag2ObjTags.keySet()
          .stream()
          .filter(childTag -> childTag.eContainer() == transientTag)
          .forEach(childTag -> {
            childTag.setParentTagId(updatedTag.getId());
            transientTag2ObjTags.get(childTag).forEach(objTag -> {
              if (objTag.getParentTagId().equals(transientTag.getId())) {
                objTag.setParentTagId(updatedTag.getId());
              }
            });
          });
    }
  }

  private List<ITag> getSortedTransientTags() {
    List<ITag> sortedTags = new ArrayList<>();
    List<ITag> unsortedTags = new ArrayList<>(transientTag2ObjTags.keySet());
    while (!unsortedTags.isEmpty()) {
      var tag = unsortedTags.get(0);
      if (!sortedTags.contains(tag)) {
        addTransientParentTags(tag,
            tag.eContainer() instanceof ITag ? (ITag) tag.eContainer() : null, sortedTags);
        sortedTags.add(tag);
      }
      unsortedTags.remove(0);
    }
    return sortedTags;
  }

  private void addTransientParentTags(final ITag tag, final ITag parent,
      final List<ITag> sortedTags) {
    if (parent == null || !parent.isTransient() || sortedTags.contains(parent)) {
      return;
    }
    var grandParent = parent.eContainer() instanceof ITag ? (ITag) parent.eContainer() : null;
    addTransientParentTags(parent, grandParent, sortedTags);
    sortedTags.add(parent);
    if (!transientTag2ObjTags.containsKey(parent)) {
      transientTag2ObjTags.put(parent, new ArrayList<>());
    }
  }
}
