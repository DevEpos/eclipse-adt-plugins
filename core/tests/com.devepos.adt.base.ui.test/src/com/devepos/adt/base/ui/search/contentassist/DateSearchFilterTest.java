package com.devepos.adt.base.ui.search.contentassist;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    cut = new DateSearchFilter("dummyLabel", "dummyDescription", null);
  }

  @Test
  void testInvalidPatterns() {
    IValidator validator = cut.getAdapter(IValidator.class);
    assertNotNull(validator);

    Stream.of("31.11", "asdf", "<=yesterday...today", "15.13", "16.1.20", "last_week", "15.1...1.1",
        "1.1...<today").forEach(pattern -> {
          assertThrows(null, CoreException.class, () -> validator.validate(pattern));
        });
  }

  @Test
  void testValidDatePattern() {
    IValidator validator = cut.getAdapter(IValidator.class);
    assertNotNull(validator);

    Stream.of("1.1", "15.12", "<=yesterday", "!28.2", "16.12.1987", "8.2020...1.1.2021",
        "last-month", "3-months-ago").forEach(pattern -> {
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
    assertEquals(converter.convert("<today"), String.format("ILT%s%s%s", now.getYear(), month,
        day));
    assertEquals(converter.convert("!>=28.2.2020"), "EGE20200228");
    String toYear = String.valueOf(LocalDate.now().getYear() + 1);
    assertEquals(converter.convert("1.1...5." + toYear), "IBT" + LocalDate.now().getYear() + "0101"
        + toYear + "0531");
  }
}
