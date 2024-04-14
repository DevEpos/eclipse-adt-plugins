package com.devepos.adt.base.ui.internal.projectexplorer.virtualfolders;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.ui.projectexplorer.virtualfolders.IVirtualFolderNode;
import com.sap.adt.projectexplorer.ui.internal.virtualfolders.FacetFilter;
import com.sap.adt.projectexplorer.ui.internal.virtualfolders.VirtualFolderNode;
import com.sap.adt.projectexplorer.ui.internal.virtualfolders.VirtualTreeNode;
import com.sap.adt.ris.search.ui.virtualfolders.ILabel;

/**
 * Proxy class to access properties of a virtual folder node
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
@SuppressWarnings("restriction")
class VirtualFolderProxy implements IVirtualFolderNode {

  private static final String PACKAGE_FACET_FILTER = "package";
  private static final String CREATED_YEAR_FACET_FILTER = "created";
  private static final String CREATED_MONTH_FACET_FILTER = "month";
  private static final String CREATED_DATE_FACET_FILTER = "date";
  private static final String APPL_COMP_FACET_FILTER = "appl";
  private static final String TYPE_FACET_FILTER = "type";
  private static final String OWNER_FACET_FILTER = "user";

  private final VirtualFolderNode originalFolderNode;
  private final FacetFilter facetFilter;
  private List<String> tadirTypes;
  private String folderType;
  private String folderKey;

  public VirtualFolderProxy(final VirtualFolderNode node) {
    originalFolderNode = node;
    facetFilter = node.getFacetFilter();
    if (node.getParent() != null) {
      ILabel folderLabel = node.getFolder().getLabel();
      folderType = folderLabel.getFacet().getKey().toLowerCase();
      folderKey = folderLabel.getKey().toLowerCase();
    }
  }

  @Override
  public List<String> getApplicationComponentFilters() {
    return facetFilter.getValues(APPL_COMP_FACET_FILTER);
  }

  @Override
  public List<String> getCreatedDateFilters() {
    // return Arrays.asList("20220105");
    return facetFilter.getValues(CREATED_DATE_FACET_FILTER);
  }

  @Override
  public List<Integer> getCreatedMonthFilters() {
    return facetFilter.getValues(CREATED_MONTH_FACET_FILTER)
        .stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  @Override
  public List<Integer> getCreatedYearFilters() {
    return facetFilter.getValues(CREATED_YEAR_FACET_FILTER)
        .stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  @Override
  public String getFolderKey() {
    return folderKey;
  }

  @Override
  public String getFolderType() {
    return folderType;
  }

  @Override
  public List<String> getPackageFilters() {
    return facetFilter.getValues(PACKAGE_FACET_FILTER).stream().map(p -> {
      if (p.startsWith(".")) {
        return p.replace(".", "");
      }
      return p;
    }).collect(Collectors.toList());
  }

  @Override
  public IProject getProject() {
    return originalFolderNode.getProject();
  }

  @Override
  public String getSearchString() {
    return originalFolderNode.getSearchString();
  }

  @Override
  public List<String> getTypeFilters() {
    if (tadirTypes == null) {
      tadirTypes = facetFilter.getValues(TYPE_FACET_FILTER);
      if (tadirTypes.isEmpty() || tadirTypes.size() == 1 && tadirTypes.get(0).length() > 4) {
        Set<String> uniqueTadirTypes = new HashSet<>();
        Set<String> possibleObjectTypes = originalFolderNode.getPossibleContainedObjectTypes();
        if (possibleObjectTypes != null) {
          for (String adtType : possibleObjectTypes) {
            if (IAdtObjectTypeConstants.STRUCTURE.equals(adtType)) {
              uniqueTadirTypes.add(ITadirTypeConstants.STRUCTURE);
            } else if (IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE.equals(adtType)) {
              uniqueTadirTypes.add(ITadirTypeConstants.DATABASE_TABLE);
            } else {
              uniqueTadirTypes.add(adtType.substring(0, 4));
            }
          }
          tadirTypes.addAll(uniqueTadirTypes);
        }
      }
    }
    return tadirTypes;
  }

  @Override
  public List<String> getUserFilters() {
    return facetFilter.getValues(OWNER_FACET_FILTER);
  }

  @Override
  public boolean isTree() {
    return originalFolderNode instanceof VirtualTreeNode;
  }

}
