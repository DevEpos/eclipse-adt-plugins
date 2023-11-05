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
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation;
import com.devepos.adt.saat.ui.internal.CdsSourceType;
import com.devepos.adt.saat.ui.internal.ExtendedAdtObjectInfo;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.cdsanalysis.ICdsEntityUsageEntry;
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
    node = new LazyLoadingAdtObjectReferenceNode(cdsViewAdtObj.getName(),
        cdsViewAdtObj.getDisplayName(), cdsViewAdtObj.getDescription(),
        cdsViewAdtObj.getAdtObjectReference(), null);
    final IDestinationProvider destProvider = cdsViewAdtObj.getAdapter(IDestinationProvider.class);
    node.setElementInfoProvider(new IElementInfoProvider() {
      @Override
      public List<IElementInfo> getElements() {
        if (destProvider == null) {
          return null;
        }
        var usedEntitiesResult = CdsAnalysisServiceFactory.getCdsAnalysisService()
            .loadUsedEntitiesAnalysis(cdsViewAdtObj.getName(), destProvider.getDestinationId());
        return usedEntitiesResult != null
            ? convertToElementInfoList(destProvider.getDestinationId(), usedEntitiesResult)
            : null;
      }

      @Override
      public String getProviderDescription() {
        return NLS.bind(Messages.CdsAnalysis_UsageAnalysisProviderDescription_xmsg,
            cdsViewAdtObj.getDisplayName());
      }

    });
  }

  private static final class CdsEntityUsageEntry extends ExtendedAdtObjectInfo
      implements ICdsEntityUsageEntry {

    private ICdsUsedEntityInformation usageInfo;

    public CdsEntityUsageEntry(ICdsUsedEntityInformation usageInfo) {
      this.usageInfo = usageInfo;
    }

    @Override
    public ICdsUsedEntityInformation getUsageInfo() {
      return usageInfo;
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

  }

  private List<IElementInfo> convertToElementInfoList(final String destinationId,
      final ICdsUsedEntitiesResult usedEntitiesResult) {
    var elements = new ArrayList<IElementInfo>();
    for (var entry : usedEntitiesResult.getUsedEntities()) {
      var entityRef = entry.getEntityRef();
      var adtObjRefElemInfo = new AdtObjectReferenceElementInfo(entityRef.getName(),
          entityRef.getDisplayName(), entityRef.getDescription());
      adtObjRefElemInfo.setAdtObjectReference(
          AdtObjectReferenceModelFactory.createReference(destinationId, entityRef));
      var usageEntry = new CdsEntityUsageEntry(entry.getUsageInformation());

      var properties = entityRef.getProperties();
      var apiState = properties.get("API_STATE");
      if (apiState != null) {
        usageEntry.setApiState(apiState);
      }
      if (IAdtObjectTypeConstants.DATA_DEFINITION.equals(entityRef.getType())) {
        usageEntry.setSourceType(CdsSourceType.getFromId(properties.get("SOURCE_TYPE")));
      }
      adtObjRefElemInfo.setAdditionalInfo(usageEntry);
      elements.add(adtObjRefElemInfo);
    }
    return elements;
  }
}
