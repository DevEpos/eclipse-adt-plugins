package com.devepos.adt.saat.ui.internal.cdsanalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.LazyLoadingElementInfo;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisServiceFactory;
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry;
import com.devepos.adt.saat.ui.internal.CdsSourceType;
import com.devepos.adt.saat.ui.internal.ExtendedAdtObjectInfo;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * Provider for reading usages of a given ADT object in Select/Association
 * clauses of CDS views
 *
 * @author stockbal
 */
public class WhereUsedInCdsElementInfoProvider implements IElementInfoProvider {
  private final String destinationId;
  private final String adtObjectName;
  private Boolean isSelectFrom;
  private final IWhereUsedInCdsSettings settings;

  /**
   * Creates a new Where Used in CDS view Element info provider
   *
   * @param destinationId      the id of the backend destination
   * @param adtObjectName      the name of the ADT object (can be Database table,
   *                           Database view or a CDS view)
   * @param searchSelectFrom   if <code>true</code> the query searches for uses of
   *                           <code>cdsViewName</code> in Select parts of CDS
   *                           views
   * @param searchAssociations if <code>true</code> the query searches for uses of
   *                           <code>cdsViewName</code> in Associations of CDS
   *                           views
   */
  public WhereUsedInCdsElementInfoProvider(final String destinationId, final String adtObjectName,
      final IWhereUsedInCdsSettings settings) {
    this(destinationId, adtObjectName, settings, null);
  }

  /**
   * Creates a new Where Used in CDS view Element info provider
   *
   * @param destinationId      the id of the backend destination
   * @param adtObjectName      the name of the ADT object (can be Database table,
   *                           Database view or a CDS view)
   * @param searchSelectFrom   if <code>true</code> the query searches for uses of
   *                           <code>cdsViewName</code> in Select parts of CDS
   *                           views
   * @param searchAssociations if <code>true</code> the query searches for uses of
   *                           <code>cdsViewName</code> in Associations of CDS
   *                           views
   * @param searchParameter    the concrete parameter value for a where used
   *                           search
   */
  private WhereUsedInCdsElementInfoProvider(final String destinationId, final String adtObjectName,
      final IWhereUsedInCdsSettings settings, final Boolean selectFrom) {
    Assert.isNotNull(settings);
    this.destinationId = destinationId;
    this.adtObjectName = adtObjectName;
    this.settings = settings;
    updateSearchParameters(selectFrom);
  }

  @Override
  public List<IElementInfo> getElements() {
    if (settings.isSearchAssociations() && settings.isSearchFromPart() && isSelectFrom == null) {
      return Arrays.asList(createLazyWhereUsedProviderElement(true),
          createLazyWhereUsedProviderElement(false));
    }
    var elementInfoResult = new ArrayList<IElementInfo>();
    var result = CdsAnalysisServiceFactory.getCdsAnalysisService()
        .getWhereUsedInResultsForEntity(destinationId, adtObjectName, isSelectFrom, settings
            .isLocalAssociationsOnly(), settings.isReleasedUsagesOnly(), settings
                .isSearchRecursively() && !settings.isSearchAssociations());
    if (result != null && !result.getEntries().isEmpty()) {
      for (var resultObj : result.getEntries()) {
        var objectRefElemInfo = convertToObjRefElemInfo(destinationId, resultObj);
        if (!settings.isSearchRecursively() || settings.isSearchAssociations()) {
          objectRefElemInfo.setElementInfoProvider(new WhereUsedInCdsElementInfoProvider(
              destinationId, objectRefElemInfo.getName(), settings));
        }
        elementInfoResult.add(objectRefElemInfo);
      }
    }
    return elementInfoResult;
  }

  @Override
  public String getProviderDescription() {
    return NLS.bind(Messages.CdsAnalysis_WhereUsedProviderDescription_xmsg, adtObjectName);
  }

  /**
   * Updates the search parameters for the Where-Used provider
   */
  public void updateSearchParameters() {
    updateSearchParameters(null);
  }

  private IAdtObjectReferenceElementInfo convertToObjRefElemInfo(String destinationId,
      IWhereUsedInCdsEntry whereUsedEntry) {
    if (whereUsedEntry == null) {
      return null;
    }
    var elementInfo = new AdtObjectReferenceElementInfo(whereUsedEntry.getDdlname(), whereUsedEntry
        .getEntityName(), whereUsedEntry.getDescription());
    elementInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(destinationId,
        whereUsedEntry.getDdlname(), whereUsedEntry.getType(), whereUsedEntry.getUri()));

    // handle custom properties
    if (whereUsedEntry.getApiState() != null || whereUsedEntry.getSourceType() != null) {
      var extendedAdtObjInfo = new ExtendedAdtObjectInfo();
      extendedAdtObjInfo.setApiState(whereUsedEntry.getApiState());
      extendedAdtObjInfo.setSourceType(CdsSourceType.getFromId(whereUsedEntry.getSourceType()));
      elementInfo.setAdditionalInfo(extendedAdtObjInfo);
    }

    // handle child nodes
    for (var child : whereUsedEntry.getChildren()) {
      elementInfo.getChildren().add(convertToObjRefElemInfo(destinationId, child));
    }
    return elementInfo;
  }

  private IElementInfo createLazyWhereUsedProviderElement(final boolean searchFrom) {
    String imageId = null;
    String name = null;
    if (searchFrom) {
      imageId = IImages.DATA_SOURCE;
      name = Messages.CdsAnalysis_UsesInSelectTreeNode_xfld;
    } else {
      imageId = IImages.ASSOCIATION;
      name = Messages.CdsAnalysis_UsesInAssociationsTreeNode_xlfd;
    }
    final WhereUsedInCdsElementInfoProvider provider = new WhereUsedInCdsElementInfoProvider(
        destinationId, adtObjectName, settings, searchFrom);
    return new LazyLoadingElementInfo(name, name, SearchAndAnalysisPlugin.getDefault()
        .getImage(imageId), provider);
  }

  /**
   * Updates the search parameters for the Where-Used provider
   *
   * @param searchParameter the concrete parameter value for a where used
   *                        search
   */
  private void updateSearchParameters(final Boolean isSelectFrom) {
    Assert.isTrue(settings.isSearchAssociations() || settings.isSearchFromPart());
    if (isSelectFrom == null) {
      if (!settings.isSearchAssociations() || !settings.isSearchFromPart()) {
        if (settings.isSearchFromPart()) {
          this.isSelectFrom = true;
        } else {
          this.isSelectFrom = false;
        }
      } else {
        this.isSelectFrom = null;
      }
    } else {
      this.isSelectFrom = isSelectFrom;
    }
  }

}
