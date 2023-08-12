package com.devepos.adt.saat.ui.internal.cdsanalysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.SimpleElementInfo;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisServiceFactory;
import com.devepos.adt.saat.cdsanalysis.ICdsFieldAnalysisSettings;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo;
import com.devepos.adt.saat.ui.internal.messages.Messages;

/**
 * Element info provider which reads a Where-Used list for a given database
 * entity field
 *
 * @author stockbal
 */
public class FieldWhereUsedInCdsElementInfoProvider implements IElementInfoProvider {

  private final String objectName;
  private final String field;
  private final String destinationId;
  private final ICdsFieldAnalysisSettings settings;
  private boolean isRoot;

  public FieldWhereUsedInCdsElementInfoProvider(final String destinationId, final String objectName,
      final String field) {
    this(destinationId, objectName, field, null);
  }

  public FieldWhereUsedInCdsElementInfoProvider(final String destinationId, final String objectName,
      final String field, final ICdsFieldAnalysisSettings settings) {
    this.objectName = objectName;
    this.settings = settings;
    this.field = field;
    this.destinationId = destinationId;
  }

  @Override
  public List<IElementInfo> getElements() {
    var whereUsedResult = CdsAnalysisServiceFactory.getCdsAnalysisService()
        .loadWhereUsedFieldAnalysis(objectName, field, settings, destinationId);
    if (whereUsedResult != null && !whereUsedResult.getFieldInfos().isEmpty()) {
      return convertToElemInfoList(whereUsedResult.getFieldInfos());
    }
    if (isRoot) {
      var elementInfos = new ArrayList<IElementInfo>();
      elementInfos.add(new SimpleElementInfo(
          Messages.FieldWhereUsedInCdsElementInfoProvider_noFieldUsageFound_xmsg, PlatformUI
              .getWorkbench()
              .getSharedImages()
              .getImage(ISharedImages.IMG_OBJS_INFO_TSK)));
      return elementInfos;
    }
    return null;
  }

  @Override
  public String getProviderDescription() {
    return NLS.bind(Messages.FieldWhereUsedInCdsElementInfoProvider_ProviderDescription_xmsg,
        objectName, field);
  }

  public void setRoot(final boolean isRoot) {
    this.isRoot = isRoot;
  }

  private List<IElementInfo> convertToElemInfoList(final List<IEntityFieldInfo> fieldInfos) {
    var elementInfos = new ArrayList<IElementInfo>();
    for (var fieldInfo : fieldInfos) {
      var objRefElemInfo = new AdtObjectReferenceElementInfo(fieldInfo.getEntityName(), fieldInfo
          .getAltEntityName() == null ? fieldInfo.getEntityName() : fieldInfo.getAltEntityName(),
          null);
      objRefElemInfo.setAdditionalInfo(fieldInfo);
      objRefElemInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
          destinationId, fieldInfo.getEntityName(), fieldInfo.getType(), fieldInfo.getUri()));
      objRefElemInfo.setElementInfoProvider(new FieldWhereUsedInCdsElementInfoProvider(
          destinationId, fieldInfo.getEntityName(), fieldInfo.getFieldName(), settings));
      elementInfos.add(objRefElemInfo);
    }
    return elementInfos;
  }
}
