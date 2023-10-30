package com.devepos.adt.saat.ui.internal.cdsanalysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.SimpleElementInfo;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisServiceFactory;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;

public class CdsFieldTopDownElementInfoProvider implements IElementInfoProvider {

  private final String cdsViewName;
  private final String field;
  private final String destinationId;

  public CdsFieldTopDownElementInfoProvider(final String destinationId, final String cdsViewName,
      final String field) {
    this.cdsViewName = cdsViewName;
    this.field = field;
    this.destinationId = destinationId;
  }

  @Override
  public List<IElementInfo> getElements() {
    var topDownResult = CdsAnalysisServiceFactory.getCdsAnalysisService()
        .loadTopDownFieldAnalysis(cdsViewName, field, destinationId);
    if (topDownResult != null) {
      if (topDownResult.getFieldInfos().isEmpty() && topDownResult.getSourceFieldInfo() != null
          && topDownResult.getSourceFieldInfo().isCalculated()) {
        var elementInfos = new ArrayList<IElementInfo>();
        elementInfos
            .add(new SimpleElementInfo(Messages.FieldAnalysisContentHandler_CalculatedField_xmsg,
                SearchAndAnalysisPlugin.getDefault().getImage(IImages.FUNCTION)));
        return elementInfos;
      }
      return convertToElemInfoList(topDownResult.getFieldInfos());
    }
    return null;
  }

  @Override
  public String getProviderDescription() {
    return NLS.bind(Messages.CdsFieldTopDownElementInfoProvider_ProviderDescription_xmsg,
        cdsViewName, field);
  }

  private List<IElementInfo> convertToElemInfoList(final List<IEntityFieldInfo> topDownResult) {
    var elementInfos = new ArrayList<IElementInfo>();
    for (var fieldInfo : topDownResult) {
      var objRefElemInfo = new AdtObjectReferenceElementInfo(fieldInfo.getEntityName(),
          fieldInfo.getAltEntityName() == null ? fieldInfo.getEntityName()
              : fieldInfo.getAltEntityName(),
          null);
      objRefElemInfo.setAdditionalInfo(fieldInfo);
      objRefElemInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
          destinationId, fieldInfo.getEntityName(), fieldInfo.getType(), fieldInfo.getUri()));
      elementInfos.add(objRefElemInfo);

      if (!fieldInfo.getChildren().isEmpty()) {
        var childElements = convertToElemInfoList(fieldInfo.getChildren());
        childElements.forEach(c -> objRefElemInfo.getChildren().add(c));
      }
    }
    return elementInfos;
  }

}
