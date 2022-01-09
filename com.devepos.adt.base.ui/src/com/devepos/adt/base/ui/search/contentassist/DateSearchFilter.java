package com.devepos.adt.base.ui.search.contentassist;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.util.IStringConverter;
import com.devepos.adt.base.util.IValidator;
import com.devepos.adt.base.util.StringUtil;

/**
 * Search filter that allows the input of
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class DateSearchFilter implements ISearchFilter, ITextQueryProposalProvider, IImageProvider,
    IAdaptable {

  private static final String NUMERIC_DATE_PART_SEPARATOR = "\\.";
  private static final String RANGE_SEPARATOR = "...";
  private static final String RANGE_SEPARATOR_PATTERN = "\\.{3}";
  private static final String DATE_COMPARISON_OPERATORS_PATTERN = "(<=|>=|>|<)";
  private static final String RELATIVE_FIXED_DATE_PATTERN = "(to|yester)day|last-(week|month|year)";
  private static final String RELATIVE_DATE_PATTERN = "([1-9](\\d*))?-(days|weeks|months|years)-ago";
  private static final String NUMERIC_FULL_DATE_PATTERN = String.join(NUMERIC_DATE_PART_SEPARATOR,
      "[1-9]\\d?", "(1[0-2]|[1-9])", "[1-9]\\d{3}");
  private static final String NUMERIC_DAY_MONTH_PATTERN = String.join(NUMERIC_DATE_PART_SEPARATOR,
      "[1-9]\\d?", "(1[0-2]|[1-9])");
  private static final String NUMERIC_MONTH_YEAR_PATTERN = String.join(NUMERIC_DATE_PART_SEPARATOR,
      "(1[0-2]|[1-9])", "\\d{4}");

  /**
   * RegEx Group pattern consisting of all possible date patterns
   */
  private static final String COMBINED_DATE_REGEX_GROUP = "(" + String.join("|",
      RELATIVE_FIXED_DATE_PATTERN, RELATIVE_DATE_PATTERN, NUMERIC_FULL_DATE_PATTERN,
      NUMERIC_DAY_MONTH_PATTERN, NUMERIC_MONTH_YEAR_PATTERN) + ")";

  /**
   * RegEx pattern which will match any valid date pattern.
   */
  private static final String DATE_VALIDATION_PATTERN = "^" + COMBINED_DATE_REGEX_GROUP + "$";

  private static final Pattern DATE_OPERATORS_PATTERN = Pattern.compile(String.format("^%s",
      DATE_COMPARISON_OPERATORS_PATTERN));

  /**
   * Pattern for ABAP internal Date representation
   */
  private static final String ABAP_DATE_PATTERN = "yyyyMMdd";

  /**
   * Formatter which uses the ABAP internal date representation
   */
  private static final DateTimeFormatter ABAP_DATE_FORMATTER = DateTimeFormatter.ofPattern(
      ABAP_DATE_PATTERN);

  private ExternalDateConverter converter;
  private String description;
  private Image image;
  private IValidator validator;
  private List<String> dateProposals = new ArrayList<>();
  private String label;

  public DateSearchFilter(String label) {
    this.label = label;
  }

  private static class AbapDateRange {
    public Option option;
    public Sign sign;
    public String low;
    public String high;

    public AbapDateRange(Sign sign) {
      this(sign, Option.EQUALS, "", "");
    }

    public AbapDateRange(Sign sign, Option option, String low, String high) {
      this.sign = sign;
      this.option = option;
      this.low = low;
      this.high = high;
    }

    @Override
    public String toString() {
      StringBuffer buffer = new StringBuffer();
      buffer.append(sign);
      buffer.append(option);
      buffer.append(low);
      if (option == Option.BETWEEN) {
        buffer.append(high);
      }
      return buffer.toString();
    }
  }

  /**
   * The validation will be a list of regex patterns that the passed possible date
   * pattern is validated against.
   * 
   * <p>
   * 1) relative dates <br>
   * a) fixed values <br>
   * - today <br>
   * - yesterday (- 1 day) <br>
   * - last-week (- 7 days) <br>
   * - last-month (- 30 days) <br>
   * - last-year (- 365 days) <br>
   * </p>
   * <p>
   * 2) relative dates mixed with numeric values <br>
   * e.g. 15-days-ago, 2-years-ago
   * </p>
   * <p>
   * 3) numeric dates <br>
   * a) full date <br>
   * e.g. 20.12.2021, 1.12.1987 <br>
   * <br>
   * b) day and month <br>
   * e.g. 16.12, 1.1 <br>
   * <br>
   * c) month and year <br>
   * e.g. 12.2021, 9.1987<br>
   * </p>
   */
  private class DateValidator implements IValidator {

    private ExternalDateConverter converter;

    public DateValidator(ExternalDateConverter converter) {
      this.converter = converter;
    }

    @Override
    public void validate(final Object value) throws CoreException {
      if (!(value instanceof String)) {
        new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
            Messages.DateSearchFilter_NoStringType_xmsg));
      }

      converter.convertToSeloptRange((String) value);
    }
  }

  /**
   * Converts date patterns into ABAP date ranges. <br>
   * The class operates under the assumption that a passed date string was already
   * properly validated with {@link DateValidator}.
   * 
   * @author Ludwig Stockbauer-Muhr
   *
   */
  private static class ExternalDateConverter implements IStringConverter {
    @Override
    public String convert(final Object value) {
      if (value instanceof String) {
        try {
          return convertToSeloptRange((String) value);
        } catch (CoreException e) {
          return "";
        }
      } else {
        // dummy toString conversion of the given value
        return String.valueOf(value);
      }
    }

    /**
     * Converts the given date pattern into a condensed version of a ABAP date type
     * range
     * 
     * @param datePattern a string containing a date pattern
     * @return
     * @throws CoreException
     */
    public String convertToSeloptRange(String datePattern) throws CoreException {
      datePattern = datePattern.toLowerCase();
      boolean isNegated = StringUtil.startsWithNegationCharacter(datePattern);
      datePattern = StringUtil.removeNegationCharacter(datePattern);
      boolean isRange = datePattern.contains(RANGE_SEPARATOR);

      AbapDateRange abapDateRange = new AbapDateRange(isNegated ? Sign.EXCLUDING : Sign.INCLUDING);
      if (isRange) {
        abapDateRange.option = Option.BETWEEN;
        String[] rangeParts = datePattern.split(RANGE_SEPARATOR_PATTERN);
        if (rangeParts != null && rangeParts.length == 2) {
          LocalDate startDate = convertDateString(rangeParts[0]).start;
          LocalDate endDate = convertDateString(rangeParts[1]).end;
          // range is only valid if start date is lesser or equal the end date
          if (startDate.compareTo(endDate) > 0) {
            throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, NLS.bind(
                Messages.DateSearchFilter_LowerLimitGreaterThanUpperLimit_xmsg, datePattern)));
          }
          abapDateRange.low = startDate.format(ABAP_DATE_FORMATTER);
          abapDateRange.high = endDate.format(ABAP_DATE_FORMATTER);
        } else {
          throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, NLS.bind(
              Messages.DateSearchFilter_MissingUpperLimitInRange_xmsg, datePattern)));
        }
      } else {
        Option option = getOptionFromPattern(datePattern);
        if (option != null) {
          // remove option from pattern
          datePattern = datePattern.substring(option.getExternalSymbol().length());
          abapDateRange.option = option;
        }
        LocalDateRange dateRange = convertDateString(datePattern);
        abapDateRange.low = dateRange.start.format(ABAP_DATE_FORMATTER);
        if (dateRange.start != dateRange.end) {
          abapDateRange.high = dateRange.end.format(ABAP_DATE_FORMATTER);
          abapDateRange.option = Option.BETWEEN;
        }
      }

      return abapDateRange.toString();
    }

    private LocalDateRange convertDateString(String datePattern) throws CoreException {
      if (!datePattern.matches(DATE_VALIDATION_PATTERN)) {
        throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, NLS.bind(
            Messages.DateSearchFilter_NotAValidDatePattern_xmsg, datePattern)));
      }
      // first check for some fix relative dates
      switch (datePattern) {
      case "today":
        return new LocalDateRange(LocalDate.now(), true);
      case "yesterday":
        return new LocalDateRange(LocalDate.now().minusDays(1), true);
      case "last-week":
        return new LocalDateRange(LocalDate.now().minusWeeks(1), true);
      case "last-month":
        return new LocalDateRange(LocalDate.now().minusMonths(1), true);
      case "last-year":
        return new LocalDateRange(LocalDate.now().minusYears(1), true);
      }

      // check if it is a fixed relative date
      Matcher relativeDatePattern = Pattern.compile(String.format("^%s$", RELATIVE_DATE_PATTERN))
          .matcher(datePattern);
      if (relativeDatePattern.find()) {
        int numberOfTemporalUnit = Integer.valueOf(relativeDatePattern.group(1));
        String temporalUnit = relativeDatePattern.group(3);

        LocalDate relativeDate = LocalDate.now();
        switch (temporalUnit) {
        case "days":
          return new LocalDateRange(relativeDate.minusDays(numberOfTemporalUnit), true);
        case "weeks":
          return new LocalDateRange(relativeDate.minusWeeks(numberOfTemporalUnit), true);
        case "months":
          return new LocalDateRange(relativeDate.minusMonths(numberOfTemporalUnit), true);
        case "years":
          return new LocalDateRange(relativeDate.minusYears(numberOfTemporalUnit), true);
        }
      }
      // now it can only be a numeric date
      String[] dateParts = datePattern.split(NUMERIC_DATE_PART_SEPARATOR);
      NumericDatePatternType numericPatternType = getNumericDatePatternType(dateParts);
      if (numericPatternType != null) {
        LocalDate date = convertNumericDatePatternToDate(datePattern);
        LocalDateRange dateRange = new LocalDateRange(date, true);
        if (numericPatternType == NumericDatePatternType.MONTH_YEAR) {
          dateRange.end = date.withDayOfMonth(date.lengthOfMonth());
        }
        return dateRange;
      }
      return null;
    }

    /*
     * Converts array of date parts into a local date
     */
    private LocalDate convertNumericDatePartsToDate(String[] dateParts,
        NumericDatePatternType numericDatePatternType) throws DateTimeException {
      switch (numericDatePatternType) {
      case FULL:
        return LocalDate.of(Integer.valueOf(dateParts[2]), Integer.valueOf(dateParts[1]), Integer
            .valueOf(dateParts[0]));
      case DAY_MONTH:
        return LocalDate.of(LocalDate.now().getYear(), Integer.valueOf(dateParts[1]), Integer
            .valueOf(dateParts[0]));
      case MONTH_YEAR:
        return LocalDate.of(Integer.valueOf(dateParts[1]), Integer.valueOf(dateParts[0]), 1);
      default:
        return null;
      }
    }

    /*
     * Converts a numeric date pattern into a {@link LocalDate} instance or throws
     * an exception if that is not possible.<br> <p> The method can handle the
     * following pattern types
     */
    private LocalDate convertNumericDatePatternToDate(String datePattern) throws CoreException {
      String[] dateParts = datePattern.split(NUMERIC_DATE_PART_SEPARATOR);
      NumericDatePatternType patternType = getNumericDatePatternType(dateParts);
      if (patternType == null) {
        throw new CoreException(createErrorStatus(NLS.bind(
            Messages.DateSearchFilter_NotAValidDate_xmsg, datePattern)));
      }
      try {
        return convertNumericDatePartsToDate(dateParts, patternType);
      } catch (DateTimeException exc) {
        throw new CoreException(createErrorStatus(NLS.bind(
            Messages.DateSearchFilter_NotAValidDate_xmsg, datePattern)));
      }
    }

    private IStatus createErrorStatus(String message) throws CoreException {
      return new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, message);
    }

    private NumericDatePatternType getNumericDatePatternType(String[] dateParts) {
      if (dateParts.length == 3) {
        return NumericDatePatternType.FULL;
      } else if (dateParts.length == 2) {
        if (dateParts[1].length() == 4) {
          return NumericDatePatternType.MONTH_YEAR;
        } else {
          return NumericDatePatternType.DAY_MONTH;
        }
      }
      return null;
    }

    private Option getOptionFromPattern(String datePattern) {
      Matcher operatorsMatcher = DATE_OPERATORS_PATTERN.matcher(datePattern);
      if (operatorsMatcher.find()) {
        return Option.fromExternalSymbol(operatorsMatcher.group());
      }
      return null;
    }
  }

  private static class LocalDateRange {
    LocalDate start;
    LocalDate end;

    LocalDateRange(LocalDate date, boolean isStartEnd) {
      start = date;
      if (isStartEnd) {
        end = date;
      }
    }
  }

  private enum NumericDatePatternType {
    DAY_MONTH,
    MONTH_YEAR,
    FULL;
  }

  private enum Option {
    EQUALS("EQ", "="),
    GREATER_THAN("GT", ">"),
    GREATER_EQUAL("GE", ">="),
    LESSER_THAN("LT", "<"),
    LESSER_EQUAL("LE", "<="),
    BETWEEN("BT", "...");

    private String symbol;
    private String externalSymbol;

    private Option(String symbol, String externalSymbol) {
      this.symbol = symbol;
      this.externalSymbol = externalSymbol;
    }

    public static Option fromExternalSymbol(String externalSymbol) {
      return Stream.of(Option.values())
          .filter(option -> option.externalSymbol.equals(externalSymbol))
          .findFirst()
          .orElse(null);
    }

    public String getExternalSymbol() {
      return externalSymbol;
    }

    @Override
    public String toString() {
      return this.symbol;
    }
  }

  private enum Sign {
    INCLUDING("I"),
    EXCLUDING("E");

    private String symbol;

    private Sign(String symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return this.symbol;
    }
  }

  @Override
  public <T> T getAdapter(final Class<T> adapter) {
    if (IStringConverter.class.equals(adapter)) {
      return adapter.cast(getConverter());
    }
    if (IValidator.class.equals(adapter)) {
      if (validator == null) {
        validator = new DateValidator(getConverter());
      }
      return adapter.cast(validator);
    }
    return null;
  }

  @Override
  public String getDescription() {
    if (description == null) {
      description = NLS.bind(Messages.SearchFilter_DescriptionDateSearchFilter_xmsg, new Object[] {
          label, "8.2021, today, 1.4.2021...yesterday" });
    }
    return description;
  }

  @Override
  public Image getImage() {
    if (image == null) {
      image = AdtBaseUIResources.getImage(IAdtBaseImages.CALENDAR);
    }
    return image;
  }

  @Override
  public String getLabel() {
    return label;
  }

  @Override
  public List<IContentProposal> getProposalList(String query) throws CoreException {
    if (dateProposals.isEmpty()) {
      initRelativeDates();
    }

    Predicate<String> queryPattern = StringUtil.getPatternForQuery(query).asPredicate();

    return dateProposals.stream()
        .filter(queryPattern)
        .map(datePattern -> new SearchFilterValueProposal(datePattern, this, null, query,
            getImage()))
        .collect(Collectors.toList());
  }

  @Override
  public boolean isBuffered() {
    return false;
  }

  @Override
  public boolean supportsMultipleValues() {
    return true;
  }

  @Override
  public boolean supportsNegatedValues() {
    return true;
  }

  @Override
  public boolean supportsPatternValues() {
    return false;
  }

  private ExternalDateConverter getConverter() {
    if (converter == null) {
      converter = new ExternalDateConverter();
    }
    return converter;
  }

  private void initRelativeDates() {
    Stream.of("today", "yesterday", "last-week", "last-month", "last-year")
        .forEach(dateProposals::add);
  }

}
