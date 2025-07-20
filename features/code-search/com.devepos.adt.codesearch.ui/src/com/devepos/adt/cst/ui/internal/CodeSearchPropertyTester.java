package com.devepos.adt.cst.ui.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.projectexplorer.node.IAbapRepositoryFolderNode;
import com.devepos.adt.base.ui.projectexplorer.virtualfolders.IVirtualFolderNode;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchRelevantWbTypesUtil;
import com.devepos.adt.cst.ui.internal.codesearch.NamedItem;
import com.devepos.adt.cst.ui.internal.codesearch.ProjectDependentTypeAvailability;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;
import com.sap.adt.ris.search.ui.internal.contentassist.AdtRisObjectTypeRegistry;

/**
 * Property tester concerning the ABAP Code Search feature
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
@SuppressWarnings("restriction")
public class CodeSearchPropertyTester extends PropertyTester {
  private static final String IS_CODE_SEARCH_AVAILABLE_PROP = "isCodeSearchAvailable";
  private static final String IS_OBJECT_SEARCHABLE_PROP = "isObjectSearchable";
  private static final String IS_TRANSPORT_SEARCHABLE_PROP = "isTransportSearchAvailable";

  private static final List<String> VALID_VIRT_FOLDER_TYPES = Arrays.asList(
      IVirtualFolderNode.FOLDER_TYPE_APPL_COMP, IVirtualFolderNode.FOLDER_TYPE_CREATED,
      IVirtualFolderNode.FOLDER_TYPE_DATE, IVirtualFolderNode.FOLDER_TYPE_MONTH,
      IVirtualFolderNode.FOLDER_TYPE_PACKAGE, IVirtualFolderNode.FOLDER_TYPE_TYPE,
      IVirtualFolderNode.FOLDER_TYPE_GROUP, IVirtualFolderNode.FOLDER_TYPE_OWNER);

  private static final List<String> VALID_VIRT_FOLDER_TYPE_KEYS = new ArrayList<>();
  private static final List<String> VALID_ABAP_REPO_FOLDER_TYPE_KEYS = Arrays.asList(
      IAbapRepositoryFolderNode.CATEGORY_CORE_DATA_SERVICES,
      IAbapRepositoryFolderNode.CATEGORY_ACCESS_CONTROL_MGMT,
      IAbapRepositoryFolderNode.CATEGORY_DICTIONARY, IAbapRepositoryFolderNode.CATEGORY_SOURCE_LIB);

  static {
    VALID_VIRT_FOLDER_TYPE_KEYS.add(IVirtualFolderNode.FOLDER_KEY_CORE_DATA_SERVICES);
    VALID_VIRT_FOLDER_TYPE_KEYS.add(IVirtualFolderNode.FOLDER_KEY_DICTIONARY);
    VALID_VIRT_FOLDER_TYPE_KEYS.add(IVirtualFolderNode.FOLDER_KEY_TRANSFORMATIONS);
    VALID_VIRT_FOLDER_TYPE_KEYS.add(IVirtualFolderNode.FOLDER_KEY_SOURCE_LIBRARY);
  }

  public CodeSearchPropertyTester() {
  }

  @Override
  public boolean test(final Object receiver, final String property, final Object[] args,
      final Object expectedValue) {
    if (IS_CODE_SEARCH_AVAILABLE_PROP.equals(property)) {
      return isCodeSearchAvailable(receiver);
    }
    if (IS_TRANSPORT_SEARCHABLE_PROP.equals(property)) {
      return isTransportSearchAvailable(receiver);
    }
    if (IS_OBJECT_SEARCHABLE_PROP.equals(property)) {
      if (!(receiver instanceof IAdtObject)) {
        return false;
      }
      return isObjectSearchable((IAdtObject) receiver);
    }
    return false;
  }

  private boolean isTransportSearchAvailable(final Object receiver) {
    if (!(receiver instanceof IAdtObject)) {
      return false;
    }
    var project = ((IAdtObject) receiver).getProject();
    if (project == null) {
      return false;
    }
    return CodeSearchFactory.getCodeSearchFeatureUtil(project)
        .testNamedItemAvailabilityByProject(NamedItem.TRANSPORT_REQUEST.getDiscoveryTerm())
        .isOK();
  }

  private boolean isCodeSearchAvailable(final Object receiver) {
    IProject project = null;
    Supplier<Boolean> folderValidation = null;

    if (receiver instanceof IAdtObject) {
      project = ((IAdtObject) receiver).getProject();
    } else if (receiver instanceof IVirtualFolderNode) {
      IVirtualFolderNode virtualFolder = (IVirtualFolderNode) receiver;
      project = virtualFolder.getProject();
      folderValidation = () -> {
        if (virtualFolder.isTree()) {
          return true;
        }
        if (VALID_VIRT_FOLDER_TYPES.contains(virtualFolder.getFolderType())) {
          if (virtualFolder.getFolderType().equals(IVirtualFolderNode.FOLDER_TYPE_TYPE)
              || virtualFolder.getFolderType().equals(IVirtualFolderNode.FOLDER_TYPE_GROUP)) {
            return getVirtualFolderTypeKeys(virtualFolder.getProject())
                .contains(virtualFolder.getFolderKey());
          }
          return true;
        }
        return false;
      };
    } else if (receiver instanceof IAbapRepositoryFolderNode) {
      // should only be relevant for 7.40-7.50 as Repository Trees and therefore Virtual Folders
      // are available starting with 7.51
      final IAbapRepositoryFolderNode folder = (IAbapRepositoryFolderNode) receiver;
      project = folder.getProject();
      var projectDependentTypes = ProjectDependentTypeAvailability.getTypesForProject(project);
      String destinationId = DestinationUtil.getDestinationId(project);
      folderValidation = () -> {
        String category = folder.getCategory();
        if (category != null) {
          if (!VALID_ABAP_REPO_FOLDER_TYPE_KEYS.contains(category)) {
            return false;
          }
          // Verify that the category contains the type
          // - DICTIONARY (7.40) -> DDLS
          // - DICTIONARY (7.50) -> STRU
          // do not block the property test too much
          if (!IAbapRepositoryFolderNode.CATEGORY_DICTIONARY.equals(category)
              || !projectDependentTypes.isEmpty()) {
            return true;
          }
          if (!AdtRisObjectTypeRegistry.isLoaded(destinationId)) {
            return false;
          }
          return !AdtTypeUtil.getInstance().isCdsCategoryAvailable(destinationId);
        }
        String type = folder.getType();
        if (type != null) {
          return CodeSearchRelevantWbTypesUtil.getRelevantTypesForHandler(folder.getProject())
              .contains(type);
        }
        // no type and category means probably a package node
        return true;
      };
    }

    boolean isProjectValid = project != null
        ? CodeSearchFactory.getCodeSearchFeatureUtil(project)
            .testSearchAvailabilityByProject(CodeSearchUIPlugin.getDefault()
                .getPreferenceStore()
                .getBoolean(ICodeSearchPrefs.PREFER_CLIENT_BASED_SEARCH))
            .isOK()
        : false;

    return folderValidation != null ? folderValidation.get() && isProjectValid : isProjectValid;
  }

  private List<String> getVirtualFolderTypeKeys(final IProject project) {
    List<String> typeKeys = new ArrayList<>(VALID_VIRT_FOLDER_TYPE_KEYS);
    typeKeys.addAll(CodeSearchRelevantWbTypesUtil.getPossibleValuesForTypeFilter(project)
        .stream()
        .map(String::toLowerCase)
        .collect(Collectors.toList()));
    return typeKeys;
  }

  private boolean isObjectSearchable(final IAdtObject adtObj) {
    String adtType = adtObj.getReference().getType();
    if (adtType == null) {
      return false;
    }
    return CodeSearchRelevantWbTypesUtil.getRelevantTypesForHandler(adtObj.getProject())
        .stream()
        .anyMatch(type -> type.equalsIgnoreCase(adtType));
  }

}
