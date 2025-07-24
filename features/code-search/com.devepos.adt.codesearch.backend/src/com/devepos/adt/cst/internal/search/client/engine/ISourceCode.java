package com.devepos.adt.cst.internal.search.client.engine;

public interface ISourceCode {
  String[] content();

  LineIndex[] indexes();

  boolean isSingleLineContent();

  int lineCount();

  String commentRegex();
}
