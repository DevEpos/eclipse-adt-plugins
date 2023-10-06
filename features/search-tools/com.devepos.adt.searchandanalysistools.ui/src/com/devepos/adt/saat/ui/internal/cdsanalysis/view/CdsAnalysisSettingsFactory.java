package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import com.devepos.adt.saat.cdsanalysis.ICdsFieldAnalysisSettings;
import com.devepos.adt.saat.ui.internal.cdsanalysis.IWhereUsedInCdsSettings;

public class CdsAnalysisSettingsFactory {

  private static class CdsFieldAnalysisSettings implements ICdsFieldAnalysisSettings {
    private boolean topDown;
    private boolean searchInDbViews;
    private boolean searchInCalcFields;

    @Override
    public boolean isSearchInCalcFields() {
      return searchInCalcFields;
    }

    @Override
    public boolean isSearchInDatabaseViews() {
      return searchInDbViews;
    }

    @Override
    public boolean isTopDown() {
      return topDown;
    }

    @Override
    public void setSearchInCalcFields(final boolean searchInCalcFields) {
      this.searchInCalcFields = searchInCalcFields;
    }

    @Override
    public void setSearchInDatabaseViews(final boolean searchInDbViews) {
      this.searchInDbViews = searchInDbViews;
    }

    @Override
    public void setTopDown(final boolean topDown) {
      this.topDown = topDown;
    }

  }

  private static class CdsTopDownSettings implements ICdsTopDownSettingsUi {
    private boolean loadAssociations;
    private boolean showDescriptions;
    private boolean showAliasNames;

    @Override
    public Object clone() {
      try {
        return super.clone();
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
      return null;
    }

    @Override
    public boolean isLoadAssociations() {
      return loadAssociations;
    }

    @Override
    public boolean isShowAliasNames() {
      return showAliasNames;
    }

    @Override
    public boolean isShowDescriptions() {
      return showDescriptions;
    }

    @Override
    public void setLoadAssociations(final boolean loadAssociations) {
      this.loadAssociations = loadAssociations;
    }

    @Override
    public void setShowAliasNames(final boolean showAliasNames) {
      this.showAliasNames = showAliasNames;
    }

    @Override
    public void setShowDescriptions(final boolean showDescriptions) {
      this.showDescriptions = showDescriptions;
    }

  }

  private static class WhereUsedInCdsSettings implements IWhereUsedInCdsSettings {
    private boolean searchFrom;
    private boolean searchAssociations;
    private boolean localAssociationsOnly;
    private boolean releasedUsagesOnly;
    private boolean searchRecursively;

    @Override
    public boolean isLocalAssociationsOnly() {
      return localAssociationsOnly;
    }

    @Override
    public boolean isReleasedUsagesOnly() {
      return releasedUsagesOnly;
    }

    @Override
    public boolean isSearchAssociations() {
      return searchAssociations;
    }

    @Override
    public boolean isSearchFromPart() {
      return searchFrom;
    }

    @Override
    public boolean isSearchRecursively() {
      return searchRecursively;
    }

    @Override
    public void setLocalAssociationsOnly(final boolean localAssociationsOnly) {
      this.localAssociationsOnly = localAssociationsOnly;
    }

    @Override
    public void setReleasedUsagesOnly(final boolean releasedUsagesOnly) {
      this.releasedUsagesOnly = releasedUsagesOnly;
    }

    @Override
    public void setSearchAssociation(final boolean searchAssociations) {
      this.searchAssociations = searchAssociations;
    }

    @Override
    public void setSearchFromPart(final boolean searchFrom) {
      this.searchFrom = searchFrom;
    }

    @Override
    public void setSearchRecursively(final boolean searchRecursively) {
      this.searchRecursively = searchRecursively;
    }
  }

  /**
   * Creates new instance of settings for CDS Top-Down analysis
   */
  public static ICdsTopDownSettingsUi createCdsTopDownSettings() {
    return new CdsTopDownSettings();
  }

  /**
   * Creates new instance of settings for CDS Field Analysis
   */
  public static ICdsFieldAnalysisSettings createFieldAnalysisSettings() {
    return new CdsFieldAnalysisSettings();
  }

  /**
   * Creates new instance of settings for Where-Used in CDS Analysis
   */
  public static IWhereUsedInCdsSettings createWhereUsedInCdsSettings() {
    return new WhereUsedInCdsSettings();
  }
}
