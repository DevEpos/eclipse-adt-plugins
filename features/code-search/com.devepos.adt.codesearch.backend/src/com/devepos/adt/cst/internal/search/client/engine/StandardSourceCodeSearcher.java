package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

public class StandardSourceCodeSearcher extends AbstractSourceCodeSearcher
    implements ISourceCodeSearcher {

  private final boolean matchAll;

  public StandardSourceCodeSearcher(final List<IPatternMatcher> matchers,
      final ISourceCode sourceCode, final boolean ignoreCommentLines, final boolean matchAll) {
    super(matchers, sourceCode, ignoreCommentLines);
    this.matchAll = matchAll;
  }

  @Override
  public List<Match> search() {
    List<Match> matches = new ArrayList<>();
    for (var matcher : matchers) {
      var rawMatches = matcher.findMatches(sourceCode.content());

      if (rawMatches != null && !rawMatches.isEmpty()) {
        var enhancedMatches = enhanceMatches(rawMatches);

        if (!enhancedMatches.isEmpty()) {
          matches.addAll(enhancedMatches);
          continue;
        }
      }

      if (matchAll) {
        return null;
      }
    }
    return matches;
  }

}
