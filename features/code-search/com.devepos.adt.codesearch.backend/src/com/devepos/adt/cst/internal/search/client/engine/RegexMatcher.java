package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RegexMatcher implements IPatternMatcher {

  private final Pattern pattern;
  private final int controlFlags;

  public RegexMatcher(final boolean ignoreCase, final String pattern) {
    this(ignoreCase, pattern, 0);
  }

  public RegexMatcher(final boolean ignoreCase, final String pattern, final int controlFlags) {
    this.controlFlags = controlFlags;
    this.pattern = Pattern.compile(pattern, ignoreCase ? Pattern.CASE_INSENSITIVE : 0);
  }

  @Override
  public int getControlFlags() {
    return controlFlags;
  }

  @Override
  public List<RawMatch> findMatches(final String[] source) {
    var matches = new ArrayList<RawMatch>();
    var index = 0;
    for (var line : source) {
      final var i = index;
      pattern.matcher(line).results().forEach(result -> {
        var start = result.start();
        matches.add(new RawMatch(i, start, result.end() - start));
      });
      index++;
    }
    return matches;
  }

  @Override
  public List<RawMatch> findMatchesInRange(final String[] source, final int startLine,
      final int offset, final int endLine, final int endOffset) {
    var matches = new ArrayList<RawMatch>();
    for (var i = startLine; i <= endLine; i++) {
      final var lineIndex = i;
      var line = source[i];
      pattern.matcher(line)
          .region(lineIndex == startLine ? offset : 0,
              lineIndex == endLine ? endOffset : line.length())
          .results()
          .forEach(result -> {
            var start = result.start();
            matches.add(new RawMatch(lineIndex, start, result.end() - start));
          });
    }
    return matches;
  }

  @Override
  public RawMatch findNextMatch(final String[] source, final int startLine, final int offset) {
    for (var i = startLine; i < source.length; i++) {
      var line = source[i];
      var matcher = pattern.matcher(line).region(startLine == i ? offset : 0, line.length());
      if (matcher.find()) {
        var start = matcher.start();
        return new RawMatch(i, i == startLine ? start + offset : start, matcher.end() - start);
      }
    }
    return null;
  }

}
