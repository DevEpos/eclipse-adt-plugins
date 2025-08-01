package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class AbstractSourceCodeSearcher {

  private static final Map<String, Pattern> COMMENT_PATTERNS = Collections
      .synchronizedMap(new HashMap<>());
  protected final ISourceCode sourceCode;
  protected boolean ignoreCommentLines;
  private Pattern commentPattern;
  private Pattern rangeCommentPattern;

  protected AbstractSourceCodeSearcher(final ISourceCode sourceCode,
      final boolean ignoreCommentLines) {
    this.sourceCode = sourceCode;
    var commentRegex = sourceCode.commentRegex();
    if (ignoreCommentLines && commentRegex != null) {
      commentPattern = getCommentPattern(commentRegex);
      rangeCommentPattern = getCommentPattern(String.format(".*%s.*", commentRegex));
      this.ignoreCommentLines = true;
    }
  }

  protected boolean isCommentLine(final String codeLine) {
    return commentPattern.matcher(codeLine).find();
  }

  protected List<Match> enhanceMatches(final List<RawMatch> rawMatches) {
    List<Match> result = new ArrayList<>();
    for (var rawMatch : rawMatches) {
      Match enhancedMatch;
      if (!sourceCode.isSingleLineContent()) {
        enhancedMatch = getSingleLineMatch(rawMatch);
      } else {
        enhancedMatch = getMultiLineMatch(rawMatch);
      }
      if (enhancedMatch != null) {
        result.add(enhancedMatch);
      }
    }
    return result;
  }

  protected LineIndex getLineIndex(final int offset) {
    for (var i = 0; i < sourceCode.lineCount(); i++) {
      var lineIndex = sourceCode.indexes()[i];
      if (lineIndex.offset() > offset) {
        return sourceCode.indexes()[i - 1];
      }
    }
    // offset must be in the last row
    return sourceCode.indexes()[sourceCode.lineCount() - 1];
  }

  protected LineIndex getMatchEndLine(final LineIndex startLine, final int offset,
      final int length) {
    if (startLine.number() == sourceCode.lineCount()) {
      return startLine;
    }
    var matchEnd = offset + length;
    var nextLine = sourceCode.indexes()[startLine.number()];
    if (matchEnd <= nextLine.offset()) {
      return startLine;
    }
    return getLineIndex(matchEnd);
  }

  protected Match getSingleLineMatch(final RawMatch rawMatch) {
    var snippet = sourceCode.content()[rawMatch.line()];
    if (ignoreCommentLines && isCommentLine(snippet)) {
      return null;
    }
    return new Match(rawMatch.line(), rawMatch.offset(), rawMatch.line(),
        rawMatch.offset() + rawMatch.length(), snippet, null);
  }

  protected Match getMultiLineMatch(final RawMatch rawMatch) {
    var startLine = getLineIndex(rawMatch.offset());
    var endLine = getMatchEndLine(startLine, rawMatch.offset(), rawMatch.length());
    var startCol = rawMatch.offset() - startLine.offset();
    var endCol = rawMatch.offset() + rawMatch.length() - endLine.offset();

    if (ignoreCommentLines && rangeContainsCommentLine(startLine, endLine)) {
      return null;
    }

    var snippet = sourceCode.content()[0].substring(startLine.offset(),
        startLine.offset() + startLine.length());
    String longSnippet = null;
    if (endLine.number() > startLine.number()) {
      longSnippet = sourceCode.content()[0].substring(startLine.offset(),
          rawMatch.length() + rawMatch.offset());
    }

    return new Match(startLine.number(), startCol, endLine.number(), endCol, snippet, longSnippet);
  }

  protected boolean rangeContainsCommentLine(final LineIndex startLine, final LineIndex endLine) {
    var val = sourceCode.content()[0];
    var off = startLine.offset();
    var len = endLine.offset() + endLine.length() - startLine.offset();
    var range = val.substring(off, off + len);
    // REVISIT: use .region() to restrict matcher instead of creating a substring
    return rangeCommentPattern.matcher(range).matches();
  }

  private Pattern getCommentPattern(final String commentRegex) {
    if (commentRegex == null) {
      return null;
    }
    var pattern = COMMENT_PATTERNS.get(commentRegex);
    if (pattern == null) {
      pattern = Pattern.compile(commentRegex);
      COMMENT_PATTERNS.put(commentRegex, commentPattern);
    }
    return pattern;
  }
}