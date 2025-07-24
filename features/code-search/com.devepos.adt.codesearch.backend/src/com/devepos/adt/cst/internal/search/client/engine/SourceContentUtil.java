package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

public class SourceContentUtil {
  private static final String LINE_FEED = "\n";

  public static String adjustLineEndings(final String text) {
    return text.replaceAll("\r\n", "\n");
  }

  public static LineIndex[] determineLineIndexes(final String source) {
    List<LineIndex> result = new ArrayList<>();
    if (source == null || source.isEmpty()) {
      return new LineIndex[0];
    }
    var lineFeedLength = LINE_FEED.length();
    var offset = 0;
    var lineNumber = 0;
    var pos = 0;
    while (pos < source.length()) {
      var next = source.indexOf(LINE_FEED, pos);
      if (next == -1) {
        // Last line
        var length = source.length() - offset;
        result.add(new LineIndex(lineNumber, offset, length));
        break;
      }
      var length = next - offset;
      result.add(new LineIndex(lineNumber, offset, length));
      offset = next + lineFeedLength;
      pos = offset;
      lineNumber++;
    }
    return result.toArray(new LineIndex[result.size()]);
  }
}
