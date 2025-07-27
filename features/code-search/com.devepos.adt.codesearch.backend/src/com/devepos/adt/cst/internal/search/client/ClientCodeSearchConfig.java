package com.devepos.adt.cst.internal.search.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.devepos.adt.base.util.StringUtil;
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
  private int classIncludeFlags;
  private int fugrIncludeFlags;

  private boolean readPackageHierarchy;

  private String[] objectNames;
  private List<String> patterns;
  private Map<String, List<String>> facets;

  public ClientCodeSearchConfig() {
  }

  @Override
  public boolean isIgnoreCaseCheck() {
    return ignoreCaseCheck;
  }

  @Override
  public void setIgnoreCaseCheck(final boolean ignoreCaseCheck) {
    this.ignoreCaseCheck = ignoreCaseCheck;
  }

  @Override
  public boolean isIgnoreCommentLines() {
    return ignoreCommentLines;
  }

  @Override
  public void setIgnoreCommentLines(final boolean ignoreCommentLines) {
    this.ignoreCommentLines = ignoreCommentLines;
  }

  @Override
  public boolean isMatchAllPatterns() {
    return matchAllPatterns;
  }

  @Override
  public void setMatchAllPatterns(final boolean matchAllPatterns) {
    this.matchAllPatterns = matchAllPatterns;
  }

  @Override
  public boolean isSequentialMatching() {
    return sequentialMatching;
  }

  @Override
  public void setSequentialMatching(final boolean sequentialMatching) {
    this.sequentialMatching = sequentialMatching;
  }

  @Override
  public boolean isMultilineSearchOption() {
    return multilineSearchOption;
  }

  @Override
  public void setMultilineSearchOption(final boolean multilineSearchOption) {
    this.multilineSearchOption = multilineSearchOption;
  }

  @Override
  public boolean isExpandProgIncludes() {
    return expandProgIncludes;
  }

  @Override
  public void setExpandProgIncludes(final boolean expandProgIncludes) {
    this.expandProgIncludes = expandProgIncludes;
  }

  @Override
  public boolean isExpandTableIncludes() {
    return expandTableIncludes;
  }

  @Override
  public void setExpandTableIncludes(final boolean expandTableIncludes) {
    this.expandTableIncludes = expandTableIncludes;
  }

  @Override
  public boolean isReadPackageHierarchy() {
    return readPackageHierarchy;
  }

  @Override
  public void setReadPackageHierarchy(final boolean readPackageHierarchy) {
    this.readPackageHierarchy = readPackageHierarchy;
  }

  @Override
  public boolean isSinglePattern() {
    return singlePattern;
  }

  @Override
  public void setSinglePattern(final boolean singlePattern) {
    this.singlePattern = singlePattern;
  }

  @Override
  public boolean isUseRegExp() {
    return useRegExp;
  }

  @Override
  public void setUseRegExp(final boolean useRegExp) {
    this.useRegExp = useRegExp;
  }

  @Override
  public String getObjectName() {
    return objectNames.length == 1 ? objectNames[0] : null;
  }

  @Override
  public Map<String, List<String>> getFacets() {
    return facets;
  }

  @Override
  public void setFacets(final Map<String, List<String>> facets) {
    this.facets = facets;
  }

  @Override
  public List<String> getPatterns() {
    return patterns;
  }

  @Override
  public void setPatterns(final List<String> patterns) {
    this.patterns = new ArrayList<>();
    for (var p : patterns) {
      this.patterns.add(p.replaceAll("\r\n", "\n"));
    }
  }

  @Override
  public void setClassIncludeFlags(final int includeFlags) {
    classIncludeFlags = includeFlags;
  }

  @Override
  public int getClassIncludeFlags() {
    return classIncludeFlags;
  }

  @Override
  public void setFugrIncludeFlags(final int includeFlags) {
    fugrIncludeFlags = includeFlags;
  }

  @Override
  public int getFugrIncludeFlags() {
    return fugrIncludeFlags;
  }

  @Override
  public void setObjectNames(final String objectNames) {
    this.objectNames = !StringUtil.isBlank(objectNames) ? objectNames.split(" ") : new String[0];
  }

  @Override
  public String[] getObjectNames() {
    return objectNames;
  }
}
