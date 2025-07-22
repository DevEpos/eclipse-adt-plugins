package com.devepos.adt.cst.internal.search.client;

import java.util.List;
import java.util.Map;

import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;

public class ClientCodeSearchConfig implements IClientCodeSearchConfig {
  private boolean ignoreCaseCheck;
  private boolean ignoreCommentLines;
  private boolean matchAllPatterns;
  private boolean sequentialMatching;
  private boolean multilineSearchOption;
  private boolean expandProgIncludes;
  private boolean expandTableIncludes;
  private boolean singlePattern;
  private boolean useRegExp;

  private boolean readPackageHierarchy;

  private String objectName;
  private List<String> patterns;
  private Map<String, List<String>> facets;

  public ClientCodeSearchConfig() {
  }

  @Override
  public boolean isIgnoreCaseCheck() {
    return ignoreCaseCheck;
  }

  @Override
  public void setIgnoreCaseCheck(boolean ignoreCaseCheck) {
    this.ignoreCaseCheck = ignoreCaseCheck;
  }

  @Override
  public boolean isIgnoreCommentLines() {
    return ignoreCommentLines;
  }

  @Override
  public void setIgnoreCommentLines(boolean ignoreCommentLines) {
    this.ignoreCommentLines = ignoreCommentLines;
  }

  @Override
  public boolean isMatchAllPatterns() {
    return matchAllPatterns;
  }

  @Override
  public void setMatchAllPatterns(boolean matchAllPatterns) {
    this.matchAllPatterns = matchAllPatterns;
  }

  @Override
  public boolean isSequentialMatching() {
    return sequentialMatching;
  }

  @Override
  public void setSequentialMatching(boolean sequentialMatching) {
    this.sequentialMatching = sequentialMatching;
  }

  @Override
  public boolean isMultilineSearchOption() {
    return multilineSearchOption;
  }

  @Override
  public void setMultilineSearchOption(boolean multilineSearchOption) {
    this.multilineSearchOption = multilineSearchOption;
  }

  @Override
  public boolean isExpandProgIncludes() {
    return expandProgIncludes;
  }

  @Override
  public void setExpandProgIncludes(boolean expandProgIncludes) {
    this.expandProgIncludes = expandProgIncludes;
  }

  @Override
  public boolean isExpandTableIncludes() {
    return expandTableIncludes;
  }

  @Override
  public void setExpandTableIncludes(boolean expandTableIncludes) {
    this.expandTableIncludes = expandTableIncludes;
  }

  @Override
  public boolean isReadPackageHierarchy() {
    return readPackageHierarchy;
  }

  @Override
  public void setReadPackageHierarchy(boolean readPackageHierarchy) {
    this.readPackageHierarchy = readPackageHierarchy;
  }

  @Override
  public boolean isSinglePattern() {
    return singlePattern;
  }

  @Override
  public void setSinglePattern(boolean singlePattern) {
    this.singlePattern = singlePattern;
  }

  @Override
  public boolean isUseRegExp() {
    return useRegExp;
  }

  @Override
  public void setUseRegExp(boolean useRegExp) {
    this.useRegExp = useRegExp;
  }

  @Override
  public String getObjectName() {
    return objectName;
  }

  @Override
  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  @Override
  public Map<String, List<String>> getFacets() {
    return facets;
  }

  @Override
  public void setFacets(Map<String, List<String>> facets) {
    this.facets = facets;
  }

  @Override
  public List<String> getPatterns() {
    return patterns;
  }

  @Override
  public void setPatterns(List<String> patterns) {
    this.patterns = patterns;
  }

}
