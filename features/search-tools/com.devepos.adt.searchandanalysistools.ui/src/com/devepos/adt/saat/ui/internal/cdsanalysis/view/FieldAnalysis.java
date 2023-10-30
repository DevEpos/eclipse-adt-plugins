package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.destinations.IDestinationProvider;
import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.SimpleElementInfo;
import com.devepos.adt.base.ui.tree.LazyLoadingAdtObjectReferenceNode;
import com.devepos.adt.saat.cdsanalysis.ICdsFieldAnalysisSettings;
import com.devepos.adt.saat.ddicaccess.DdicRepositoryAccessFactory;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * Result for CDS Field Analysis
 *
 * @author stockbal
 */
public class FieldAnalysis extends CdsAnalysis {
  private ICdsFieldAnalysisSettings settings;
  private LazyLoadingAdtObjectReferenceNode node;

  public FieldAnalysis(final IAdtObjectReferenceElementInfo adtObjectInfo) {
    super(adtObjectInfo);
    node = new LazyLoadingAdtObjectReferenceNode(adtObjectInfo.getName(),
        adtObjectInfo.getDisplayName(), adtObjectInfo.getDescription(),
        adtObjectInfo.getAdtObjectReference(), null);
    final IDestinationProvider destProvider = adtObjectInfo.getAdapter(IDestinationProvider.class);
    node.setElementInfoProvider(new IElementInfoProvider() {
      @Override
      public List<IElementInfo> getElements() {
        return enrichColumnInfo(destProvider.getDestinationId(),
            DdicRepositoryAccessFactory.getDdicAccess()
                .getColumnInformation(destProvider.getDestinationId(), adtObjectInfo.getUri()));
      }

      @Override
      public String getProviderDescription() {
        return NLS.bind(Messages.FieldAnalysisView_FieldLoadingProviderDesc_xmsg,
            adtObjectInfo.getDisplayName());
      }
    });
    settings = CdsAnalysisSettingsFactory.createFieldAnalysisSettings();
  }

  @Override
  public Image getImage() {
    return SearchAndAnalysisPlugin.getDefault().getImage(IImages.FIELD_ANALYSIS);
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return SearchAndAnalysisPlugin.getDefault().getImageDescriptor(IImages.FIELD_ANALYSIS);
  }

  @Override
  public Object getResult() {
    return new Object[] { node };
  }

  /**
   * @return the settings for the current analysis
   */
  public ICdsFieldAnalysisSettings getSettings() {
    return settings;
  }

  @Override
  public CdsAnalysisType getType() {
    return CdsAnalysisType.FIELD_ANALYSIS;
  }

  @Override
  public void refreshAnalysis() {
    node.resetLoadedState();
  }

  @Override
  protected String getLabelPrefix() {
    return Messages.FieldAnalysisView_ViewLabel_xfld;
  }

  private List<IElementInfo> enrichColumnInfo(final String destinationId,
      final List<IEntityFieldInfo> objRefList) {
    if (objRefList == null || objRefList.isEmpty()) {
      return null;
    }
    List<IElementInfo> columnElemList = new ArrayList<>();

    for (var columnInfo : objRefList) {
      var columnElemInfo = new SimpleElementInfo(columnInfo.getFieldName().toLowerCase(),
          columnInfo.getFieldName(), null, columnInfo.getDescription());
      if (columnInfo.isKey()) {
        columnElemInfo.setImage(SearchAndAnalysisPlugin.getDefault().getImage(IImages.KEY_COLUMN));
      } else {
        columnElemInfo.setImage(SearchAndAnalysisPlugin.getDefault().getImage(IImages.COLUMN));
      }
      columnElemList.add(columnElemInfo);
    }
    return columnElemList;
  }

}
