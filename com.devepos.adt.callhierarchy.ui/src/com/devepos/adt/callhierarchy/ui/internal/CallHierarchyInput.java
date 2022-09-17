package com.devepos.adt.callhierarchy.ui.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.ErrorElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoCollection;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.ui.tree.ILazyLoadingListener;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.base.ui.tree.LazyLoadingFolderNode;
import com.devepos.adt.base.ui.util.AdtUIUtil;
import com.devepos.adt.callhierarchy.backend.CallHierarchyServiceFactory;
import com.devepos.adt.callhierarchy.backend.HierarchyQueryParams;
import com.devepos.adt.callhierarchy.backend.ICallHierarchyService;
import com.devepos.adt.callhierarchy.backend.PathType;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;
import com.devepos.adt.callhierarchy.ui.internal.preferences.IPreferences;

/**
 * Input Object for a call hierarchy for an ABAP element
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CallHierarchyInput {

  private IHierarchyResult result;
  private final ILazyLoadingNode treeResult;
  private final IProject project;
  private final ICallHierarchyService hierarchyService;
  private final String destinationId;
  private ImageDescriptor entryImgDescr;
  private Image entryImg;

  private boolean resultLoaded;
  private boolean resultHasError;
  private final IPreferenceStore prefStore;

  public CallHierarchyInput(final IProject project, final String elementUri) {
    this.project = project;
    prefStore = Activator.getDefault().getPreferenceStore();
    destinationId = DestinationUtil.getDestinationId(project);
    hierarchyService = CallHierarchyServiceFactory.getHierarchyService();
    NextLevelHierarchyElementLoader rootHierarchyLoader = new NextLevelHierarchyElementLoader(
        elementUri, null, false);
    treeResult = new LazyLoadingFolderNode("", rootHierarchyLoader, null, null);

    treeResult.addLazyLoadingListener(l -> {
      resultLoaded = true;
      result = rootHierarchyLoader.getHierarchyResult();
      resultHasError = rootHierarchyLoader.hasError;
      setImageDescr();
    });
  }

  /**
   * Element loader for a one-level call tree of an ABAP element specified either by URI or ABAP
   * fullname
   * 
   * @author Ludwig Stockbauer-Muhr
   *
   */
  private class NextLevelHierarchyElementLoader implements IElementInfoProvider {

    private final String uri;
    private final boolean ignoreRootNode;
    private IHierarchyResult hierarchyResult;
    private String hierarchyObjectIdentifier;
    private boolean hasError;

    public NextLevelHierarchyElementLoader(final String uri, final String objectIdentifier,
        final boolean ignoreRootNode) {
      this.uri = uri;
      hierarchyObjectIdentifier = objectIdentifier;
      this.ignoreRootNode = ignoreRootNode;
    }

    @Override
    public List<IElementInfo> getElements() {
      try {
        getCallHierarchy();
      } catch (Exception e) {
        e.printStackTrace();
        hasError = true;
        return Arrays.asList(new ErrorElementInfo(NLS.bind(
            "Error during loading the call hierarchy at ''{0}''", new Object[] { uri }), e));
      }

      if (hierarchyResult == null || hierarchyResult.getEntries().isEmpty()) {
        return null;
      }
      List<IElementInfo> childElements = new ArrayList<>();
      IElementInfoCollection rootNode = null;

      for (IHierarchyResultEntry entry : hierarchyResult.getEntries()) {
        if (entry.getParentUri() == null && ignoreRootNode) {
          continue;
        }
        AdtObjectReferenceElementInfo wrapperInfo = new AdtObjectReferenceElementInfo(entry
            .getName(), entry.getName(), entry.getDescription());
        wrapperInfo.setAdditionalInfo(entry);
        wrapperInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
            destinationId, entry.getName(), entry.getType(), entry.getUri()));

        if (entry.getParentUri() == null) {
          rootNode = wrapperInfo;
          childElements.add(rootNode);
          continue;
        }
        wrapperInfo.setElementInfoProvider(new NextLevelHierarchyElementLoader(entry.getUri(), entry
            .getObjectIdentifier(), true));

        if (entry.getParentUri() != null && rootNode != null) {
          rootNode.getChildren().add(wrapperInfo);
        } else {
          childElements.add(wrapperInfo);
        }
      }

      return childElements;
    }

    public IHierarchyResult getHierarchyResult() {
      return hierarchyResult;
    }

    @Override
    public String getProviderDescription() {
      return "Loading Call Hierarchy...";
    }

    private void getCallHierarchy() {
      Map<String, Object> queryParams = new HashMap<>();
      if (hierarchyObjectIdentifier != null) {
        queryParams.put(HierarchyQueryParams.PATH_TYPE.getLiteral(), PathType.FULL_NAME
            .getLiteral());
        queryParams.put(HierarchyQueryParams.PATH.getLiteral(), hierarchyObjectIdentifier);
      } else {
        queryParams.put(HierarchyQueryParams.PATH_TYPE.getLiteral(), PathType.URI.getLiteral());
        queryParams.put(HierarchyQueryParams.PATH.getLiteral(), uri);
      }

      if (prefStore.getString(IPreferences.CALL_HIERARCHY_INTF_METHOD_RESOLUTION)
          .equals(InterfaceMethodResolution.FIND_FIRST_IMPLEMENTER.name())) {
        queryParams.put(HierarchyQueryParams.AUTO_RESOLVE_INTF_METHOD.getLiteral(), "true");
      }
      hierarchyResult = hierarchyService.getCallHierarchy(destinationId, queryParams);

      if (hierarchyResult != null && hierarchyObjectIdentifier == null) {
        hierarchyObjectIdentifier = hierarchyResult.getOriginObjectIdentifier();
      }
    }
  }

  /**
   * Adds listener which will be notified when the result is loaded
   *
   * @param l the listener to add
   */
  public void addResultLoadedListener(final ILazyLoadingListener l) {
    if (treeResult != null) {
      treeResult.addLazyLoadingListener(l);
    }
  }

  /**
   *
   * @return the image for the root entry
   */
  public Image getImage() {
    return entryImg;
  }

  /**
   * @return the image descriptor for the root entry of the result
   */
  public ImageDescriptor getImageDescr() {
    if (entryImg != null && entryImgDescr == null) {
      entryImgDescr = ImageDescriptor.createFromImage(entryImg);
    }
    return entryImgDescr;
  }

  /**
   * @return label for content description of the Hierarchy View
   */
  public String getLabel() {
    if (result == null) {
      return getNoResultLabel();
    }
    String originType = result.getOriginType();
    if (IAdtObjectTypeConstants.FUNCTION_MODULE.equals(originType)
        || IAdtObjectTypeConstants.PROGRAM_SUBROUTINE.equals(originType)) {
      return NLS.bind("Calls from ''{0}'' in {1}", new Object[] { result.getOriginObjectName(),
          project.getName() });
    }
    return NLS.bind("Calls from ''{0}->{1}'' in {2}", new Object[] { result
        .getOriginEnclObjectName(), result.getOriginObjectName(), project.getName() });
  }

  /**
   * @return label for history dropdown
   */
  public String getLabelForHistory() {
    if (result == null) {
      return getNoResultLabel();
    }
    String originType = result.getOriginType();
    if (IAdtObjectTypeConstants.FUNCTION_MODULE.equals(originType)
        || IAdtObjectTypeConstants.PROGRAM_SUBROUTINE.equals(originType)) {
      return String.format("%s [%s]", result.getOriginObjectName(), project.getName());
    }
    return String.format("%s - %s [%s]", result.getOriginObjectName(), result
        .getOriginEnclObjectName(), project.getName());
  }

  public Object getResult() {
    return treeResult;
  }

  public boolean isResultLoaded() {
    return resultLoaded;
  }

  /**
   * Navigate to the source position of the given call position reference
   *
   * @param callPosition call position in call hierarchy
   */
  public void navigateToCallPosition(final ICallPosition callPosition) {
    AdtUIUtil.navigateWithObjectReference(AdtObjectReferenceModelFactory.createReference(
        destinationId, "", "", callPosition.getUri()), project);
  }

  public void refresh() {
    if (treeResult == null) {
      return;
    }

    result = null;
    resultLoaded = false;
    treeResult.resetLoadedState();
  }

  /**
   * Removes the listener for result loaded notifications
   *
   * @param l the listener to remove
   */
  public void removeResultLoadedListener(final ILazyLoadingListener l) {
    if (treeResult != null) {
      treeResult.removeLazyLoadingListener(l);
    }
  }

  private String getNoResultLabel() {
    if (resultLoaded) {
      return resultHasError ? "Loading of Call Hierarchy failed" : "No Call Hierarchy possible";
    }
    return "Loading Call Hierarchy...";
  }

  private void setImageDescr() {
    if (result == null) {
      entryImgDescr = null;
      entryImg = null;
    } else {
      entryImg = HierarchyElementImageHelper.getImageOfHierResult(result);
    }
  }
}
