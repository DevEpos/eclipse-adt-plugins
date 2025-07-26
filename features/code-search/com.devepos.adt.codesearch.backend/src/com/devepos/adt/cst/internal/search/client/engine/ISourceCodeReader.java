package com.devepos.adt.cst.internal.search.client.engine;

public interface ISourceCodeReader {
  String CDS_COMMENT_REGEX = "^\\s*(//|/\\*|--)";
  String BDEF_COMMENT_REGEX = "^\\s*(//|/\\*)";
  String DEFAULT_COMMENT_REGEX = "^(\\*|\\s*\")";

  String MAIN_SOURCE_PATH = "/source/main";

  ISourceCode getSourceCode(String uri);
}
