package com.devepos.adt.cst.internal.search.client.engine;

public class SourceCode implements ISourceCode {

  private final LineIndex[] indexes;
  private final boolean singleLineContent;
  private final String commentRegex;
  private final String[] content;
  private final int lineCount;

  public SourceCode(final String[] content, final LineIndex[] indexes, final String commentRegex) {
    this.content = content;
    this.indexes = indexes == null ? new LineIndex[0] : indexes;
    singleLineContent = indexes != null;
    this.commentRegex = commentRegex;
    lineCount = indexes != null ? indexes.length : content.length;
  }

  @Override
  public LineIndex[] indexes() {
    return indexes;
  }

  @Override
  public boolean isSingleLineContent() {
    return singleLineContent;
  }

  @Override
  public int lineCount() {
    return lineCount;
  }

  @Override
  public String commentRegex() {
    return commentRegex;
  }

  @Override
  public String[] content() {
    return content;
  }

}
