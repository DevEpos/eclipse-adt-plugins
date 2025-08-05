package com.devepos.adt.cst.search.client.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.devepos.adt.cst.internal.search.client.engine.IPatternMatcher;
import com.devepos.adt.cst.internal.search.client.engine.ISourceCodeReader;
import com.devepos.adt.cst.internal.search.client.engine.PatternUtil;
import com.devepos.adt.cst.internal.search.client.engine.PatternUtil.PatternParseException;
import com.devepos.adt.cst.internal.search.client.engine.SequentialSourceCodeSearcher;
import com.devepos.adt.cst.internal.search.client.engine.SourceCode;
import com.devepos.adt.cst.internal.search.client.engine.SubstringMatcher;

public class SequentialSourceCodeSearcherTest {
  private SequentialSourceCodeSearcher cut;

  @Test
  void testExclude1() throws PatternParseException {
    List<IPatternMatcher> matchers = PatternUtil
        .parsePatternSequence(Arrays.asList("loop at", "loop at", "select ", "endloop."))
        .stream()
        .map(p -> new SubstringMatcher(true, p.pattern(), p.flags()))
        .collect(Collectors.toList());

    // @formatter:off
    var sourceCode = 
        "    LOOP AT matchers ASSIGNING FIELD-SYMBOL(<matcher>).\r\n" +
        "      LOOP at others INTO DATA(other).\r\n" +
        "        SELECT SINGLE * FROM zif_adcoset_pattern_matcher\r\n" +
        "          WHERE pattern = <matcher>-pattern\r\n" +
        "          AND control_flags = <matcher>-control_flags\r\n" +
        "          INTO @DATA(existing_matcher).\r\n" + 
        "      ENDLOOP.\r\n" + 
        "    ENDLOOP.\r\n" + 
        "\r\n" +
        "    LOOP AT others ASSIGNING FIELD-SYMBOL(<matcher>).\r\n" +
        "      LOOP at matches INTO DATA(other).\r\n" +
        "        SELECT SINGLE * FROM MARA INTO DATA(result).\r\n" +
        "      ENDLOOP.\r\n" + 
        "    ENDLOOP.\r\n";
    // @formatter:on

    var code = new SourceCode(sourceCode.split("\r\n"), null,
        ISourceCodeReader.DEFAULT_COMMENT_REGEX);

    cut = new SequentialSourceCodeSearcher(matchers, code, true);

    var matches = cut.search();

    assertEquals(2, matches.size());
  }
}
