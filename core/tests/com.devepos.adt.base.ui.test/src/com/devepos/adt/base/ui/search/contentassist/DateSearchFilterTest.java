package com.devepos.adt.base.ui.search.contentassist;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devepos.adt.base.util.IStringConverter;
import com.devepos.adt.base.util.IValidator;

public class DateSearchFilterTest {
  private DateSearchFilter cut;

  @BeforeEach
  public void setUp() throws Exception {
    cut = new DateSearchFilter("dummyLabel", "dummyShortDescription", "dummyDescription", null);
  }

  @Test
  void testInvalidPatterns() {
    IValidator validator = cut.getAdapter(IValidator.class);
    assertNotNull(validator);

    Stream.of("31.11", "asdf", "<=yesterday...today", "15.13", "16.1.20", "last_week", "15.1...1.1",
        "1.1...<today", "last-month...yesterday...today", "<2020...today", "last-month...>=today")
        .forEach(pattern -> {
          assertThrows(CoreException.class, () -> validator.validate(pattern));
        });
  }

  @Test
  void testInvalidValidationType() {
    var validator = cut.getAdapter(IValidator.class);
    assertThrows(CoreException.class, () -> validator.validate(Integer.valueOf(1)));
  }

  @Test
  void testValidDatePattern() {
    IValidator validator = cut.getAdapter(IValidator.class);
    assertNotNull(validator);

    Stream
        .of("1.1", "15.12", "<=yesterday", "!28.2", "16.12.1987", "8.2020...1.1.2021", "2023",
            "3-months-ago", "last-year", "last-month", "last-week", "2-weeks-ago", "2-years-ago",
            "2-months-ago", "2-days-ago")
        .forEach(pattern -> {
          assertDoesNotThrow(() -> validator.validate(pattern));
        });
  }

  @Test
  void testPatternConversion() {
    IStringConverter converter = cut.getAdapter(IStringConverter.class);
    assertNotNull(converter);

    /*
     * relative dates cannot really be tested without changing the outcome all the
     * time
     *
     * assertEquals(converter.convert(">=last-week"), "IGE20211231");
     * assertEquals(converter.convert("2-weeks-ago"), "IEQ20211224");
     */
    LocalDate now = LocalDate.now();
    String month = String.valueOf(now.getMonthValue());
    if (month.length() == 1) {
      month = "0" + month;
    }
    String day = String.valueOf(now.getDayOfMonth());
    if (day.length() == 1) {
      day = "0" + day;
    }
    assertEquals(String.format("ILT%s%s%s", now.getYear(), month, day),
        converter.convert("<today"));
    assertEquals("EGE20200228", converter.convert("!>=28.2.2020"));

    String toYear = String.valueOf(LocalDate.now().getYear() + 1);
    assertEquals("IBT" + LocalDate.now().getYear() + "0101" + toYear + "0531",
        converter.convert("1.1...5." + toYear));
  }

  @Test
  void testMonthYearPatterns() {
    IStringConverter converter = cut.getAdapter(IStringConverter.class);
    assertNotNull(converter);

    assertEquals("ILT20210501", converter.convert("<5.2021"));
    assertEquals("IGT20220630", converter.convert(">6.2022"));
    assertEquals("IBT2020020120200229", converter.convert("2.2020"));
  }

  @Test
  void testYearPatterns() {
    IStringConverter converter = cut.getAdapter(IStringConverter.class);
    assertNotNull(converter);

    assertEquals("ILT20210101", converter.convert("<2021"));
    assertEquals("IGT20231231", converter.convert(">2023"));
    assertEquals("IBT2020010120201231", converter.convert("2020"));

  }

  @Test
  void testProposalsWithRelativeNumericalQuery() {
    Exception exc = null;
    try {
      var results = cut.getProposalList("2-*");
      assertEquals(4, results.size());
    } catch (CoreException e) {
      exc = e;
    }

    assertNull(exc);
  }

  @Test
  void testProposalsWithRange() {
    Exception exc = null;
    try {
      var results = cut.getProposalList("2-months-ago...t");
      assertEquals(1, results.size());
    } catch (CoreException e) {
      exc = e;
    }
    assertNull(exc);
  }

  @Test
  void testProposalsWithComparator() {
    Exception exc = null;
    try {
      var results = cut.getProposalList(">=2-");
      assertEquals(4, results.size());
    } catch (CoreException e) {
      exc = e;
    }
    assertNull(exc);
  }

  @Test
  void testProposalsWith() {
    Exception exc = null;
    try {
      var results = cut.getProposalList("last-*");
      assertEquals(3, results.size());
    } catch (CoreException e) {
      exc = e;
    }
    assertNull(exc);
  }

  @Test
  void testFilterGetter() {
    assertFalse(cut.isBuffered());
    assertTrue(cut.supportsMultipleValues());
    assertTrue(cut.supportsNegatedValues());
    assertFalse(cut.supportsPatternValues());
    assertNotNull(cut.getLongDescription());
    assertNotNull(cut.getLabel());
    assertNotNull(cut.getDescription());
  }
}
