package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

public class StandardSourceCodeSearcher extends AbstractSourceCodeSearcher
    implements ISourceCodeSearcher {

  private boolean matchAll;

  public StandardSourceCodeSearcher(List<IPatternMatcher> matchers, ISourceCode sourceCode,
      boolean ignoreCommentLines, boolean matchAll) {
    super(matchers, sourceCode, ignoreCommentLines);
    this.matchAll = matchAll;
  }

  @Override
  public List<Match> search() {
    List<Match> matches = new ArrayList<>();
    for (var matcher : matchers) {
      var rawMatches = matcher.findMatches(sourceCode.content());

      if (rawMatches != null) {
        var enhancedMatches = enhanceMatches(rawMatches);

        if (!enhancedMatches.isEmpty()) {
          matches.addAll(enhancedMatches);
        } else if (matchAll) {
          return null;
        }
      }
    }
    return matches;
  }

}
