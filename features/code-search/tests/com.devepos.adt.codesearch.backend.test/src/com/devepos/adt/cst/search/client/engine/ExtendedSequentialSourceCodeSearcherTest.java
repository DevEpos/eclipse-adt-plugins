package com.devepos.adt.cst.search.client.engine;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.devepos.adt.cst.internal.search.client.engine.ExtendedSequentialSourceCodeSearcher;
import com.devepos.adt.cst.internal.search.client.engine.IPatternMatcher;
import com.devepos.adt.cst.internal.search.client.engine.ISourceCodeReader;
import com.devepos.adt.cst.internal.search.client.engine.PatternUtil;
import com.devepos.adt.cst.internal.search.client.engine.PatternUtil.StaticError;
import com.devepos.adt.cst.internal.search.client.engine.RegexMatcher;
import com.devepos.adt.cst.internal.search.client.engine.SourceCode;
import com.devepos.adt.cst.internal.search.client.engine.SubstringMatcher;

public class ExtendedSequentialSourceCodeSearcherTest {
  private ExtendedSequentialSourceCodeSearcher cut;

  @Test
  void testExclude1() throws StaticError {
    List<IPatternMatcher> matchers = PatternUtil
        .parsePatternSequence(Arrays.asList("(#b-start) loop ", "(#exclude) loop ",
            "(#match) select ", "(#b-end) endloop."))
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
        "    ENDLOOP.";
    // @formatter:on

    var code = new SourceCode(sourceCode.split("\r\n"), null,
        ISourceCodeReader.DEFAULT_COMMENT_REGEX);

    cut = new ExtendedSequentialSourceCodeSearcher(matchers, code, true);

    var matches = cut.search();

    assertTrue(matches.isEmpty());
  }

  @Test
  void testExclude2() throws Exception {
    List<IPatternMatcher> matchers = PatternUtil
        .parsePatternSequence(Arrays.asList("(#b-start)^\\s+if\\s", "(#exclude)^\\s+if\\s",
            "\\s+call\\smethod\\s", "(#b-end)\\sendif\\."))
        .stream()
        .map(p -> new RegexMatcher(true, p.pattern(), p.flags()))
        .collect(Collectors.toList());

    // @formatter:off
    var sourceCode = 
        "      IF method_exists_in_interface-method_exists = abap_false.\r\n" + 
        "*        method_exists_in_interface-interface_name = 'if_xco_gen_bdef_s_form'.\r\n" + 
        "        method_exists_in_interface-method_name    = 'SET_STRICT'.\r\n" + 
        "        IF xco_api->method_exists_in_interface(\r\n" + 
        "             interface_name = method_exists_in_interface-interface_name\r\n" + 
        "             method_name    = method_exists_in_interface-method_name\r\n" + 
        "           ).\r\n" + 
        "          CALL METHOD lo_specification->(method_exists_in_interface-method_name).\r\n" + 
        "          APPEND 'SET_STRICT' TO call_method_succeeded_list.\r\n" + 
        "          method_exists_in_interface-method_exists = abap_true.\r\n" + 
        "        ELSE.\r\n" + 
        "          method_exists_in_interface-method_exists = abap_false.\r\n" + 
        "        ENDIF.";
    // @formatter:on

    var code = new SourceCode(sourceCode.split("\r\n"), null,
        ISourceCodeReader.DEFAULT_COMMENT_REGEX);

    cut = new ExtendedSequentialSourceCodeSearcher(matchers, code, true);

    var matches = cut.search();

    assertTrue(matches.isEmpty());
  }

  @Test
  void testBoundaries() throws StaticError {
    List<IPatternMatcher> matchers = PatternUtil
        .parsePatternSequence(
            Arrays.asList("(#b-start) loop ", "(#match) data(lv", "(#b-end) endloop."))
        .stream()
        .map(p -> new SubstringMatcher(true, p.pattern(), p.flags()))
        .collect(Collectors.toList());

    // @formatter:off
    var sourceCode = 
        "    TRY.\r\n" +
        "*        write: / |Process { lines( it_fields ) } Fields in View { is_cds_view-entityid }|.\r\n" +
        "        LOOP AT it_fields INTO DATA(ls_field).\r\n" +
        "          lo_visitor->mv_current_field = ls_field-field.\r\n" +
        "          DATA(lo_expression) = lo_select_list->get_expression( name = ls_field-field ).\r\n" +
        "          CHECK lo_expression IS BOUND.\r\n" +
        "          lo_expression->accept( lo_visitor ).\r\n" + 
        "        ENDLOOP.\r\n" +
        "        DATA(lt_fields) = lo_visitor->get_found_fields( ).\r\n" 
        + "\r\n" +
        "        IF lt_fields IS NOT INITIAL.\r\n" 
        + "\r\n" +
        "          \" Select raw field names\r\n" + 
        "          SELECT fieldname,\r\n" +
        "                 rawfieldname\r\n" + 
        "            FROM zsat_i_cdsviewfield\r\n" +
        "            FOR ALL ENTRIES IN @lt_fields\r\n" +
        "            WHERE entityid  = @is_cds_view-entityid\r\n" +
        "              AND fieldname = @lt_fields-table_line\r\n" +
        "            INTO TABLE @DATA(lt_field_names).\r\n" + 
        "        ENDIF.\r\n" + "\r\n" +
        "        LOOP AT lt_fields INTO DATA(lv_field).\r\n" +
        "          DATA(ls_field_usage) = VALUE zif_sat_ty_adt_types=>ty_s_field_usage(\r\n" +
        "              entityid      = is_cds_view-rawentityid\r\n" +
        "              ddlname       = is_cds_view-ddlname\r\n" +
        "              fieldname     = VALUE #( lt_field_names[ fieldname = lv_field ]-rawfieldname DEFAULT lv_field )\r\n" +
        "              sourcetype    = is_cds_view-sourcetype\r\n" +
        "              is_calculated = abap_true ).\r\n" +
        "          mt_usages = VALUE #( BASE mt_usages ( ls_field_usage ) ).\r\n" +
        "        ENDLOOP.\r\n" + "\r\n" + "      CATCH cx_ddl_visitor_exception.\r\n" +
        "    ENDTRY.";
    // @formatter:on

    var code = new SourceCode(sourceCode.split("\r\n"), null,
        ISourceCodeReader.DEFAULT_COMMENT_REGEX);

    cut = new ExtendedSequentialSourceCodeSearcher(matchers, code, true);

    var matches = cut.search();

    assertEquals(1, matches.size());
    var match = matches.get(0);

    assertEquals(22, match.line());
    assertEquals(30, match.offset());
    assertEquals(22, match.endLine());
    assertEquals(38, match.endOffset());
  }

  @Test
  void testLookAheadExclusion() throws Exception {
    List<IPatternMatcher> matchers = PatternUtil
        .parsePatternSequence(
            Arrays.asList("(#b-start) loop ", " select ", "(#b-end) endloop", "(#exclude) loop "))
        .stream()
        .map(p -> new SubstringMatcher(true, p.pattern(), p.flags()))
        .collect(Collectors.toList());

    // @formatter:off
    var sourceCode = 
        "    DATA materials TYPE TABLE OF mara.\r\n" + 
        "    DATA plants TYPE TABLE OF marc.\r\n" + 
        "    data plant type marc.\r\n" + 
        "    data material like line of materials.\r\n" + 
        "    data excl_result type mara.\r\n" + 
        "    data uuid_x16 type sysuuid_x16.\r\n" + 
        "\r\n" + 
        "    LOOP AT materials INTO material.\r\n" + 
        "\r\n" + 
        "        loop at materials into material.\r\n" + 
        "        endLOOP.\r\n" + 
        "\r\n" + 
        "        select single * from marc into @plant.\r\n" + 
        "\r\n" + 
        "    enDLOOP.\r\n" + 
        "\r\n" + 
        "\r\n" + 
        "    LOOP AT materials INTO material.\r\n" + 
        "    ENDLOOP.\r\n" + 
        "\r\n" + 
        "\r\n" + 
        "    LOOP AT materials INTO material.\r\n" + 
        "      \" do some other processing\r\n" + 
        "\r\n" + 
        "      CALL FUNCTION 'NUMBER_GET_NEXT'.\r\n" + 
        "\r\n" + 
        "      \" now we do a SELECT :-O\r\n" + 
        "      SELECT SINGLE * FROM mara\r\n" + 
        "        WHERE matnr = @plant-matnr\r\n" + 
        "        INTO @excl_result.\r\n" + 
        "\r\n" + 
        "      CALL METHOD cl_system_uuid=>convert_uuid_c22_static\r\n" + 
        "        EXPORTING\r\n" + 
        "          uuid     = ''\r\n" + 
        "        IMPORTING\r\n" + 
        "          uuid_x16 = uuid_x16\r\n" + 
        "*         uuid_c32 =\r\n" + 
        "*         uuid_c26 =\r\n" + 
        "*         uuid_c36 =\r\n" + 
        "        .\r\n" + 
        "    ENDLOOP.";
    // @formatter:on

    var code = new SourceCode(sourceCode.split("\r\n"), null,
        ISourceCodeReader.DEFAULT_COMMENT_REGEX);

    cut = new ExtendedSequentialSourceCodeSearcher(matchers, code, true);

    var matches = cut.search();

    assertEquals(1, matches.size());
    var match = matches.get(0);

    assertEquals(21, match.line());
    assertEquals(3, match.offset());
    assertEquals(40, match.endLine());
    assertEquals(11, match.endOffset());
  }
}
