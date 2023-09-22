package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.destinations.IDestinationProvider;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.ui.tree.LazyLoadingAdtObjectReferenceNode;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisServiceFactory;
import com.devepos.adt.saat.cdsanalysis.ICdsEntityUsageInfo;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult;
import com.devepos.adt.saat.ui.internal.CdsSourceType;
import com.devepos.adt.saat.ui.internal.ExtendedAdtObjectInfo;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * Aggregated analysis of Dependency tree result of a CDS view
 *
 * @author stockbal
 */
public class CdsUsedEntitiesAnalysis extends CdsAnalysis {

  private LazyLoadingAdtObjectReferenceNode node;

  public CdsUsedEntitiesAnalysis(final IAdtObjectReferenceElementInfo cdsViewAdtObj) {
    super(cdsViewAdtObj);
    node = new LazyLoadingAdtObjectReferenceNode(cdsViewAdtObj.getName(), cdsViewAdtObj
        .getDisplayName(), cdsViewAdtObj.getDescription(), cdsViewAdtObj.getAdtObjectReference(),
        null);
    final IDestinationProvider destProvider = cdsViewAdtObj.getAdapter(IDestinationProvider.class);
    node.setElementInfoProvider(new IElementInfoProvider() {
      @Override
      public List<IElementInfo> getElements() {
        if (destProvider == null) {
          return null;
        }
        var usedEntitiesResult = CdsAnalysisServiceFactory.getCdsAnalysisService()
            .loadUsedEntitiesAnalysis(cdsViewAdtObj.getName(), destProvider.getDestinationId());
        return usedEntitiesResult != null ? convertToElementInfoList(destProvider
            .getDestinationId(), usedEntitiesResult) : null;
      }

      @Override
      public String getProviderDescription() {
        return NLS.bind(Messages.CdsAnalysis_UsageAnalysisProviderDescription_xmsg, cdsViewAdtObj
            .getDisplayName());
      }

    });
  }

  private static final class CdsEntityUsageInfo extends ExtendedAdtObjectInfo implements
      ICdsEntityUsageInfo {
    public int occurrence;
    public int usedEntitiesCount;
    public int usedJoinCount;
    public int usedUnionCount;

    @Override
    public int getOccurrence() {
      return occurrence;
    }

    @Override
    public int getUsedEntitiesCount() {
      return usedEntitiesCount;
    }

    @Override
    public int getUsedJoinCount() {
      return usedJoinCount;
    }

    @Override
    public int getUsedUnionCount() {
      return usedUnionCount;
    }

  }

  @Override
  public Image getImage() {
    return SearchAndAnalysisPlugin.getDefault().getImage(IImages.USAGE_ANALYZER);
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return SearchAndAnalysisPlugin.getDefault().getImageDescriptor(IImages.USAGE_ANALYZER);
  }

  @Override
  public String getLabelPrefix() {
    return Messages.CdsUsageAnalysisView_ViewLabel_xfld;
  }

  @Override
  public Object getResult() {
    return node;
  }

  @Override
  public CdsAnalysisType getType() {
    return CdsAnalysisType.DEPENDENCY_TREE_USAGES;
  }

  @Override
  public void refreshAnalysis() {
    // TODO Auto-generated method stub

  }

  private List<IElementInfo> convertToElementInfoList(final String destinationId,
      final ICdsUsedEntitiesResult usedEntitiesResult) {
    var elements = new ArrayList<IElementInfo>();
    for (var entry : usedEntitiesResult.getUsedEntities()) {
      var entityRef = entry.getEntityRef();
      var adtObjRefElemInfo = new AdtObjectReferenceElementInfo(entityRef.getName(), entityRef
          .getDisplayName(), entityRef.getDescription());
      adtObjRefElemInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
          destinationId, entityRef));
      var usageInfo = new CdsEntityUsageInfo();
      var usageInfoModel = entry.getUsageInformation();
      usageInfo.occurrence = usageInfoModel.getOccurrence();
      usageInfo.usedEntitiesCount = usageInfoModel.getEntityCount();
      usageInfo.usedJoinCount = usageInfoModel.getJoinCount();
      usageInfo.usedUnionCount = usageInfoModel.getUnionCount();

      var properties = entityRef.getProperties();
      var apiState = properties.get("API_STATE");
      if (apiState != null) {
        usageInfo.setApiState(apiState);
      }
      if (IAdtObjectTypeConstants.DATA_DEFINITION.equals(entityRef.getType())) {
        usageInfo.setSourceType(CdsSourceType.getFromId(properties.get("SOURCE_TYPE")));
      }
      adtObjRefElemInfo.setAdditionalInfo(usageInfo);
      elements.add(adtObjRefElemInfo);
    }
    return elements;
  }
}
