package com.devepos.adt.cst.search.client;

import java.util.List;
import java.util.Map;

public interface IClientCodeSearchConfig {

  List<String> getPatterns();

  void setPatterns(List<String> patterns);

  boolean isIgnoreCaseCheck();

  void setIgnoreCaseCheck(boolean ignoreCaseCheck);

  boolean isIgnoreCommentLines();

  void setIgnoreCommentLines(boolean ignoreCommentLines);

  boolean isMatchAllPatterns();

  void setMatchAllPatterns(boolean matchAllPatterns);

  boolean isSequentialMatching();

  void setSequentialMatching(boolean sequentialMatching);

  boolean isMultilineSearchOption();

  void setMultilineSearchOption(boolean multilineSearchOption);

  boolean isExpandProgIncludes();

  void setExpandProgIncludes(boolean expandProgIncludes);

  boolean isExpandTableIncludes();

  void setExpandTableIncludes(boolean expandTableIncludes);

  boolean isReadPackageHierarchy();

  void setReadPackageHierarchy(boolean readPackageHierarchy);

  boolean isSinglePattern();

  void setSinglePattern(boolean singlePattern);

  boolean isUseRegExp();

  void setUseRegExp(boolean useRegExp);

  String getObjectName();

  void setObjectName(String objectName);

  Map<String, List<String>> getFacets();

  void setFacets(Map<String, List<String>> facets);

  void setClassIncludeFlags(int includeFlags);

  void setFugrIncludeFlags(int includeFlags);

  int getFugrIncludeFlags();

  int getClassIncludeFlags();

}