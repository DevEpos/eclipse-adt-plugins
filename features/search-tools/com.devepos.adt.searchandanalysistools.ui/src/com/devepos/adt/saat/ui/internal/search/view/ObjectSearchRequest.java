package com.devepos.adt.saat.ui.internal.search.view;

import java.util.HashMap;
import java.util.Map;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchFactory;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryInput;
import com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig;
import com.sap.adt.destinations.model.IDestinationData;

/**
 * Search request for an Object Search. <br>
 * Holds all the data used in the object search query
 *
 * @author stockbal
 */
public class ObjectSearchRequest {
  private final String query;
  private String destinationId;
  private String parametersString;
  private Map<String, Object> parameters;
  private IAbapProjectProvider projectProvider;
  private final ISearchQueryInput queryInput;
  private ISearchResultOutputConfig outputConfig;

  public ObjectSearchRequest() {
    query = null;
    destinationId = null;
    queryInput = IObjectSearchFactory.eINSTANCE.createSearchQueryInput();
  }

  @Override
  public boolean equals(final Object object) {
    if (!(object instanceof ObjectSearchRequest)) {
      return super.equals(object);
    }
    final ObjectSearchRequest otherEntry = (ObjectSearchRequest) object;
    return query.equalsIgnoreCase(otherEntry.getQuery()) && destinationId.equalsIgnoreCase(
        otherEntry.getDestinationId()) && queryInput.isCombineFiltersWithAnd() == otherEntry
            .isAndSearchActive();
  }

  public String getDestinationId() {
    return projectProvider != null ? projectProvider.getDestinationId()
        : destinationId != null ? destinationId : "";
  }

  public int getMaxResults() {
    return queryInput.getMaxRows();
  }

  public ISearchResultOutputConfig getOutputConfig() {
    return outputConfig;
  }

  public Map<String, Object> getParameters() {
    return parameters != null ? parameters : new HashMap<>();
  }

  public String getParametersString() {
    return parametersString != null ? parametersString : "";
  }

  public IAbapProjectProvider getProjectProvider() {
    return projectProvider;
  }

  public String getQuery() {
    var queryTextBuffer = new StringBuffer();
    for (var field : queryInput.getFields()) {
      if (queryTextBuffer.length() != 0) {
        queryTextBuffer.append("; ");
      }
      queryTextBuffer.append(String.format("%s: %s", field.getLabel().replaceAll("&", ""), field
          .getRawInput()));
    }
    return queryTextBuffer.toString();
  }

  public ISearchQueryInput getQueryInput() {
    return queryInput;
  }

  public String getSearchType() {
    return queryInput.getType();
  }

  public boolean isAndSearchActive() {
    return queryInput.isCombineFiltersWithAnd();
  }

  public void setAndSearchActive(final boolean andSearchActive) {
    queryInput.setCombineFiltersWithAnd(andSearchActive);
  }

  public void setDestinationId(final String destinationId) {
    this.destinationId = destinationId;
  }

  public void setMaxResults(final int maxResults) {
    queryInput.setMaxRows(maxResults);
  }

  public void setOutputConfig(final ISearchResultOutputConfig outputConfig) {
    this.outputConfig = outputConfig;
  }

  public void setProjectProvider(final IAbapProjectProvider projectProvider) {
    this.projectProvider = projectProvider;
  }

  public void setReadAllEntries(final boolean readAllEntries) {
    queryInput.setRowLimitDisabled(readAllEntries);
  }

  public void setReadApiState(final boolean readApiState) {
    queryInput.setWithApiState(readApiState);
  }

  public void setSearchType(final String searchType) {
    queryInput.setType(searchType);
  }

  public boolean shouldReadAllEntries() {
    return queryInput.isRowLimitDisabled();
  }

  public boolean shouldReadApiState() {
    return queryInput.isWithApiState();
  }

  @Override
  public String toString() {
    final String destinationInfo = getDestinationInfo();
    if (destinationInfo.isEmpty()) {
      return String.format("%s Search: '%s'", queryInput.getTypeLabel(), getQuery());
    }
    return String.format("[%s] %s Search: '%s'", destinationInfo, queryInput.getTypeLabel(),
        getQuery());
  }

  private String getDestinationInfo() {
    if (projectProvider == null || !projectProvider.hasProject()) {
      return "";
    }
    final IDestinationData destData = projectProvider.getDestinationData();
    return String.format("%s", destData.getSystemConfiguration().getSystemId());
  }
}
