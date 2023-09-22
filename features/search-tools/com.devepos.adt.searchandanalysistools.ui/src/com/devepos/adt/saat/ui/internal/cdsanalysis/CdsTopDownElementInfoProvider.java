package com.devepos.adt.saat.ui.internal.cdsanalysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.ElementInfoCollection;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisServiceFactory;
import com.devepos.adt.saat.cdsanalysis.ICdsTopDownSettings;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult;
import com.devepos.adt.saat.model.cdsanalysis.SqlRelation;
import com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType;
import com.devepos.adt.saat.ui.internal.CdsSourceType;
import com.devepos.adt.saat.ui.internal.ExtendedAdtObjectInfo;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;

public class CdsTopDownElementInfoProvider implements IElementInfoProvider {
  private final String cdsViewName;
  private final String destinationId;
  private final ICdsTopDownSettings settings;

  public CdsTopDownElementInfoProvider(final String destinationId, final String cdsViewName,
      final ICdsTopDownSettings settings) {
    this.cdsViewName = cdsViewName;
    this.destinationId = destinationId;
    this.settings = settings;
  }

  private static final class SqlRelationInfo extends ExtendedAdtObjectInfo implements
      ISqlRelationInfo {

    public String relation;
    public String type;
    public String aliasName;

    @Override
    public String getAliasName() {
      return aliasName;
    }

    @Override
    public String getRelation() {
      return relation;
    }

    @Override
    public String getType() {
      return type;
    }

  }

  @Override
  public List<IElementInfo> getElements() {
    var topDownResult = CdsAnalysisServiceFactory.getCdsAnalysisService()
        .loadTopDownAnalysis(cdsViewName, settings, destinationId);
    return topDownResult != null ? convertTopDownResult(topDownResult) : null;
  }

  @Override
  public String getProviderDescription() {
    return NLS.bind(Messages.CdsAnalysis_TopDownAnalysisProviderDescription_xmsg, cdsViewName);
  }

  private IElementInfo convertAbapEntry(ITopDownAnalysisEntry entry) {
    var entityRef = entry.getEntityRef();
    var adtObjRefElemInfo = new AdtObjectReferenceElementInfo(entityRef.getName(), entityRef
        .getDisplayName(), entityRef.getDescription());
    adtObjRefElemInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
        destinationId, entityRef));

    adtObjRefElemInfo.setLazyLoadingSupport(false);

    var sqlRelationInfo = new SqlRelationInfo();
    sqlRelationInfo.relation = getRelationText(entry.getSqlRelation());

    adtObjRefElemInfo.setAdditionalInfo(sqlRelationInfo);
    return adtObjRefElemInfo;
  }

  private IElementInfo convertCollectionEntry(final ITopDownAnalysisEntry entry) {
    String rawName = null;
    String imageId = null;
    switch (entry.getEntryType()) {
    case ASSOCIATIONS:
      rawName = Messages.CdsAnalysis_NodeNameAssociations;
      imageId = IImages.ASSOCIATION;
      break;
    case SELECT:
      rawName = Messages.CdsAnalysis_NodeNameSelect;
      imageId = IImages.SELECT_PART;
    case RESULT:
      rawName = Messages.CdsAnalysis_NodeNameResult;
      imageId = IImages.JOIN_RESULT_SOURCE;
      break;
    case UNION:
      rawName = Messages.CdsAnalysis_NodeNameUnionSelect;
      imageId = IImages.UNION;
      break;
    case UNION_ALL:
      rawName = Messages.CdsAnalysis_NodeNameUnionSelectAll;
      imageId = IImages.UNION;
      break;
    default:
      return null;
    }

    var folder = new ElementInfoCollection(rawName, rawName, SearchAndAnalysisPlugin.getDefault()
        .getImage(imageId), null);
    var sqlRelation = new SqlRelationInfo();
    sqlRelation.type = entry.getEntryType().getName();
    folder.setAdditionalInfo(sqlRelation);

    for (var childEntry : entry.getChildren()) {
      folder.getChildren().add(convertResultEntry(childEntry));
    }
    return folder;
  }

  private IElementInfo convertEntityEntry(final ITopDownAnalysisEntry entry) {
    var entityRef = entry.getEntityRef();
    var adtObjRefElemInfo = new AdtObjectReferenceElementInfo(entityRef.getName(), entityRef
        .getDisplayName(), entityRef.getDescription());
    adtObjRefElemInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
        destinationId, entityRef));

    if (!IAdtObjectTypeConstants.DATA_DEFINITION.equals(entityRef.getType())) {
      adtObjRefElemInfo.setLazyLoadingSupport(false);
    } else {
      adtObjRefElemInfo.setElementInfoProvider(new CdsTopDownElementInfoProvider(destinationId,
          entityRef.getName(), settings));
    }

    var sqlRelationInfo = new SqlRelationInfo();
    sqlRelationInfo.aliasName = entry.getAlias();
    sqlRelationInfo.relation = getRelationText(entry.getSqlRelation());

    var properties = entityRef.getProperties();
    var apiState = properties.get("API_STATE");
    if (apiState != null) {
      sqlRelationInfo.setApiState(apiState);
    }
    if (entityRef.getType() == IAdtObjectTypeConstants.DATA_DEFINITION) {
      sqlRelationInfo.setSourceType(CdsSourceType.getFromId(properties.get("SOURCE_TYPE")));
    }
    if (entry.getSqlRelation() == SqlRelation.ASSOCIATION) {
      var assocName = properties.get("ASSOCIATION_NAME");
      adtObjRefElemInfo.setDisplayName(String.format("%s (%s)", assocName, adtObjRefElemInfo
          .getDisplayName()));
    }
    adtObjRefElemInfo.setAdditionalInfo(sqlRelationInfo);
    return adtObjRefElemInfo;
  }

  private IElementInfo convertResultEntry(final ITopDownAnalysisEntry entry) {

    if (entry.getEntryType() == TopDownAnalysisEntryType.ENTITY) {
      return convertEntityEntry(entry);
    } else if (entry.getEntryType() == TopDownAnalysisEntryType.ABAP) {
      return convertAbapEntry(entry);
    }
    return convertCollectionEntry(entry);
  }

  private List<IElementInfo> convertTopDownResult(final ITopDownAnalysisResult topDownResult) {
    var elements = new ArrayList<IElementInfo>();
    for (var result : topDownResult.getEntries()) {
      var convertedEntry = convertResultEntry(result);
      if (convertedEntry != null) {
        elements.add(convertedEntry);
      }
    }
    return elements;
  }

  private String getRelationText(final SqlRelation sqlRelation) {
    switch (sqlRelation) {
    case ASSOCIATION:
      return Messages.CdsAnalysis_SqlRelationAssociation;
    case CROSS_JOIN:
      return Messages.CdsAnalysis_SqlRelationCrossJoin;
    case FROM:
      return Messages.CdsAnalysis_SqlRelationFrom;
    case FULL_OUTER_JOIN:
      return Messages.CdsAnalysis_SqlRelationFullOuterJoin;
    case INNER_JOIN:
      return Messages.CdsAnalysis_SqlRelationInnerJoin;
    case LEFT_OUTER_JOIN:
      return Messages.CdsAnalysis_SqlRelationLeftOuterJoin;
    case RIGHT_OUTER_JOIN:
      return Messages.CdsAnalysis_SqlRelationRightOuterJoin;
    case IMPLEMENTED_BY:
      return Messages.CdsAnalysis_SqlRelationImplementedBy;
    default:
      return null;
    }
  }
}
