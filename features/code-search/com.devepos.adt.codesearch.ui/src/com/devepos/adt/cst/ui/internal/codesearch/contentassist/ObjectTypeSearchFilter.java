package com.devepos.adt.cst.ui.internal.codesearch.contentassist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.dialogs.SearchPattern;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterValueProposal;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.ui.util.IAdtObjectTypeProxy;
import com.devepos.adt.cst.ui.internal.codesearch.FilterName;
import com.devepos.adt.cst.ui.internal.codesearch.ProjectDependentTypeAvailability;
import com.devepos.adt.cst.ui.internal.messages.Messages;

/**
 * Search filter for object type
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class ObjectTypeSearchFilter implements ISearchFilter, ITextQueryProposalProvider {

  private static final String WILDCARD = "*"; //$NON-NLS-1$
  private final Map<String, IAdtObjectTypeProxy> adtTypeMap = new TreeMap<>();
  private String description;
  private Image image;
  private final IAbapProjectProvider projectProvider;
  private final boolean negation;

  public ObjectTypeSearchFilter(final IAbapProjectProvider projectProvider,
      final boolean negation) {
    this.projectProvider = projectProvider;
    this.negation = negation;

  }

  @Override
  public String getDescription() {
    return Messages.ObjectTypeSearchFilter_filterShortDescription_xmsg;
  }

  @Override
  public Image getImage() {
    if (image == null) {
      image = AdtBaseUIResources.getImage(IAdtBaseImages.WB_OBJECT_TYPE);
    }
    return image;
  }

  @Override
  public String getLabel() {
    return FilterName.OBJECT_TYPE.getContentAssistName();
  }

  @Override
  public String getLongDescription() {
    if (description == null) {
      description = NLS.bind(Messages.SearchFilters_objectTypeFilterDescription_xmsg, new Object[] {
          FilterName.OBJECT_TYPE.getContentAssistName(), ITadirTypeConstants.CLASS.toLowerCase() });
    }
    return description;
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    if (adtTypeMap.isEmpty()) {
      initAdtTypes();
    }
    List<IContentProposal> proposals = new ArrayList<>();

    var typesForProject = ProjectDependentTypeAvailability
        .getTypesForProject(projectProvider.getProject());

    if (query == null || query.isEmpty()) {
      adtTypeMap.forEach((key, value) -> {
        if (!ProjectDependentTypeAvailability.isTypeAvailable(key, typesForProject)) {
          return;
        }
        proposals.add(new SearchFilterValueProposal(key, this, value.getDescription(), "", value //$NON-NLS-1$
            .getImage()));
      });
    } else {
      var searchPattern = createPattern(query.toLowerCase());
      for (String typeName : adtTypeMap.keySet()) {
        if (searchPattern.matches(typeName)) {
          if (!ProjectDependentTypeAvailability.isTypeAvailable(typeName, typesForProject)) {
            continue;
          }
          var adtType = adtTypeMap.get(typeName);
          proposals.add(new SearchFilterValueProposal(typeName, this, adtType.getDescription(),
              query, adtType.getImage()));
        }
      }
    }

    return proposals;
  }

  @Override
  public boolean isBuffered() {
    return true;
  }

  @Override
  public boolean supportsMultipleValues() {
    return true;
  }

  @Override
  public boolean supportsNegatedValues() {
    return negation;
  }

  @Override
  public boolean supportsPatternValues() {
    return false;
  }

  private SearchPattern createPattern(final String query) {
    String patternString = null;
    if (query == null) {
      patternString = WILDCARD;
    } else if (!query.endsWith(WILDCARD)) {
      patternString = String.valueOf(query) + WILDCARD;
    } else {
      patternString = query;
    }
    var pattern = new SearchPattern();
    pattern.setPattern(patternString);
    return pattern;
  }

  private void initAdtTypes() {
    var typeUtil = AdtTypeUtil.getInstance();
    adtTypeMap.put(ITadirTypeConstants.CLASS, typeUtil.getType(IAdtObjectTypeConstants.CLASS));
    adtTypeMap.put(ITadirTypeConstants.INTERFACE,
        typeUtil.getType(IAdtObjectTypeConstants.INTERFACE));
    adtTypeMap.put(ITadirTypeConstants.PROGRAM, typeUtil.getType(IAdtObjectTypeConstants.PROGRAM));
    adtTypeMap.put(ITadirTypeConstants.TYPE_GROUP,
        typeUtil.getType(IAdtObjectTypeConstants.TYPE_GROUP));
    adtTypeMap.put(ITadirTypeConstants.DATA_DEFINITION,
        typeUtil.getType(IAdtObjectTypeConstants.DATA_DEFINITION));
    adtTypeMap.put(ITadirTypeConstants.METADATA_EXTENSION,
        typeUtil.getType(IAdtObjectTypeConstants.METADATA_EXTENSION));
    adtTypeMap.put(ITadirTypeConstants.ACCESS_CONTROL,
        typeUtil.getType(IAdtObjectTypeConstants.ACCESS_CONTROL));
    adtTypeMap.put(ITadirTypeConstants.BEHAVIOR_DEFINITION,
        typeUtil.getType(IAdtObjectTypeConstants.BEHAVIOR_DEFINITION));
    adtTypeMap.put(ITadirTypeConstants.SIMPLE_TRANSFORMATION,
        typeUtil.getType(IAdtObjectTypeConstants.SIMPLE_TRANSFORMATION));
    adtTypeMap.put(ITadirTypeConstants.FUNCTION_GROUP,
        typeUtil.getType(IAdtObjectTypeConstants.FUNCTION_GROUP));
    adtTypeMap.put(ITadirTypeConstants.DATABASE_TABLE,
        typeUtil.getType(IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE));
    adtTypeMap.put(ITadirTypeConstants.STRUCTURE,
        typeUtil.getType(IAdtObjectTypeConstants.STRUCTURE));
    adtTypeMap.put(ITadirTypeConstants.SERVICE_DEFINITION,
        typeUtil.getType(IAdtObjectTypeConstants.SERVICE_DEFINITION));
  }
}
