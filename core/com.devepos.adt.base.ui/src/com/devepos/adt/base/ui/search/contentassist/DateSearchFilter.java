package com.devepos.adt.base.ui.search.contentassist;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
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
 */
public class DateSearchFilter implements ISearchFilter, ITextQueryProposalProvider, IImageProvider,
    IAdaptable {

  private static final String NUMERIC_DATE_PART_SEPARATOR = "\\."; //$NON-NLS-1$
  private static final String RANGE_SEPARATOR = "..."; //$NON-NLS-1$
  private static final String RANGE_SEPARATOR_PATTERN = "\\.{3}"; //$NON-NLS-1$
  private static final String DATE_COMPARISON_OPERATORS_PATTERN = "(<=|>=|>|<)"; //$NON-NLS-1$
  private static final String RELATIVE_FIXED_DATE_PATTERN = "(to|yester)day|last-(week|month|year)"; //$NON-NLS-1$
  private static final String RELATIVE_DATE_PATTERN = "([1-9](\\d*))-(days|weeks|months|years)-ago"; //$NON-NLS-1$
  private static final String NUMERIC_YEAR_PATTERN = "\\d{4}"; //$NON-NLS-1$
  private static final String NUMERIC_FULL_DATE_PATTERN = String.join(NUMERIC_DATE_PART_SEPARATOR,
      "[1-9]\\d?", "(1[0-2]|[1-9])", "[1-9]\\d{3}"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  private static final String NUMERIC_DAY_MONTH_PATTERN = String.join(NUMERIC_DATE_PART_SEPARATOR,
      "[1-9]\\d?", "(1[0-2]|[1-9])"); //$NON-NLS-1$ //$NON-NLS-2$
  private static final String NUMERIC_MONTH_YEAR_PATTERN = String.join(NUMERIC_DATE_PART_SEPARATOR,
      "(1[0-2]|[1-9])", "\\d{4}"); //$NON-NLS-1$ //$NON-NLS-2$

  /**
   * RegEx Group pattern consisting of all possible date patterns
   */
  private static final String COMBINED_DATE_REGEX_GROUP = "(" + String.join("|", //$NON-NLS-1$ //$NON-NLS-2$
      RELATIVE_FIXED_DATE_PATTERN, RELATIVE_DATE_PATTERN, NUMERIC_FULL_DATE_PATTERN,
      NUMERIC_DAY_MONTH_PATTERN, NUMERIC_MONTH_YEAR_PATTERN, NUMERIC_YEAR_PATTERN) + ")"; //$NON-NLS-1$

  /**
   * RegEx pattern which will match any valid date pattern.
   */
  private static final String DATE_VALIDATION_PATTERN = "^" + COMBINED_DATE_REGEX_GROUP + "$"; //$NON-NLS-1$ //$NON-NLS-2$

  private static final Pattern DATE_OPERATORS_PATTERN = Pattern.compile(String.format("^%s", //$NON-NLS-1$
      DATE_COMPARISON_OPERATORS_PATTERN));

  /**
   * Pattern for ABAP internal Date representation
   */
  private static final String ABAP_DATE_PATTERN = "yyyyMMdd"; //$NON-NLS-1$

  /**
   * Formatter which uses the ABAP internal date representation
   */
  private static final DateTimeFormatter ABAP_DATE_FORMATTER = DateTimeFormatter.ofPattern(
      ABAP_DATE_PATTERN);

  private ExternalDateConverter converter;

  private String longDescription;
  private final String description;
  private Image image;
  private IValidator validator;
  private List<String> dateProposals;
  private final String label;
  private final String descriptionIntro;
  private List<String> relativeNumericDates;

  /**
   * Creates new date search filter with the given label.<br>
   * The description and image are preconfigured
   *
   * @param label           the name of the filter (e.g. {@code created}
   * @param description     the short description of the filter
   * @param longDescription the description to be prefixed to the explanation of the date filter
   *                        features
   * @param image           the image to be shown besided the filter name
   *
   */
  public DateSearchFilter(final String label, final String description,
      final String longDescription, final Image image) {
    if (StringUtil.isEmpty(longDescription)) {
      throw new IllegalArgumentException("'longDescription' must not be null or an empty String"); //$NON-NLS-1$
    }
    this.label = label;
    descriptionIntro = longDescription;
    this.description = description;
    this.image = image;
  }

  private static class AbapDateRange {
    public Option option;
    public Sign sign;
    public String low;
    public String high;

    public AbapDateRange(final Sign sign) {
      this(sign, Option.EQUALS, "", "");
    }

    public AbapDateRange(final Sign sign, final Option option, final String low,
        final String high) {
      this.sign = sign;
      this.option = option;
      this.low = low;
      this.high = high;
    }

    @Override
    public String toString() {
      StringBuilder buffer = new StringBuilder();
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
  private static class DateValidator implements IValidator {

    private final ExternalDateConverter converter;

    public DateValidator(final ExternalDateConverter converter) {
      this.converter = converter;
    }

    @Override
    public void validate(final Object value) throws CoreException {
      if (!(value instanceof String)) {
        throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
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
   */
  private static class ExternalDateConverter implements IStringConverter {
    @Override
    public String convert(final Object value) {
      if (!(value instanceof String)) {
        // dummy toString conversion of the given value
        return String.valueOf(value);
      }
      try {
        return convertToSeloptRange((String) value);
      } catch (CoreException e) {
        return "";
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
        if (rangeParts == null || rangeParts.length != 2) {
          throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, NLS.bind(
              Messages.DateSearchFilter_MissingUpperLimitInRange_xmsg, datePattern)));
        }
        if (getOptionFromPattern(rangeParts[0]) != null || getOptionFromPattern(
            rangeParts[1]) != null) {
          throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
              Messages.DateSearchFilter_OperatorsNotAllowedInRanges_xmsg));
        }

        LocalDate startDate = convertDateString(rangeParts[0], null).start;
        LocalDate endDate = convertDateString(rangeParts[1], null).end;

        // range is only valid if start date is lesser or equal the end date
        if (startDate.compareTo(endDate) > 0) {
          throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, NLS.bind(
              Messages.DateSearchFilter_LowerLimitGreaterThanUpperLimit_xmsg, datePattern)));
        }
        abapDateRange.low = startDate.format(ABAP_DATE_FORMATTER);
        abapDateRange.high = endDate.format(ABAP_DATE_FORMATTER);
      } else {
        Option option = getOptionFromPattern(datePattern);
        if (option != null) {
          // remove option from pattern
          datePattern = datePattern.substring(option.getExternalSymbol().length());
          abapDateRange.option = option;
        }
        LocalDateRange dateRange = convertDateString(datePattern, option);
        abapDateRange.low = dateRange.start.format(ABAP_DATE_FORMATTER);

        if (dateRange.start != dateRange.end) {
          abapDateRange.high = dateRange.end.format(ABAP_DATE_FORMATTER);
          abapDateRange.option = Option.BETWEEN;
        }
      }

      return abapDateRange.toString();
    }

    private LocalDateRange convertDateString(final String datePattern, final Option option)
        throws CoreException {
      if (!datePattern.matches(DATE_VALIDATION_PATTERN)) {
        throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, NLS.bind(
            Messages.DateSearchFilter_NotAValidDatePattern_xmsg, datePattern)));
      }
      // first check for some fix relative dates
      switch (datePattern) {
      case "today": //$NON-NLS-1$
        return new LocalDateRange(LocalDate.now(), true);
      case "yesterday": //$NON-NLS-1$
        return new LocalDateRange(LocalDate.now().minusDays(1), true);
      case "last-week": //$NON-NLS-1$
        return new LocalDateRange(LocalDate.now().minusWeeks(1), true);
      case "last-month": //$NON-NLS-1$
        return new LocalDateRange(LocalDate.now().minusMonths(1), true);
      case "last-year": //$NON-NLS-1$
        return new LocalDateRange(LocalDate.now().minusYears(1), true);
      }

      // check if it is a fixed relative date
      Matcher relativeDatePattern = Pattern.compile(String.format("^%s$", RELATIVE_DATE_PATTERN)) //$NON-NLS-1$
          .matcher(datePattern);
      if (relativeDatePattern.find()) {
        int numberOfTemporalUnit = Integer.parseInt(relativeDatePattern.group(1));
        String temporalUnit = relativeDatePattern.group(3);

        LocalDate relativeDate = LocalDate.now();
        switch (temporalUnit) {
        case "days": //$NON-NLS-1$
          return new LocalDateRange(relativeDate.minusDays(numberOfTemporalUnit), true);
        case "weeks": //$NON-NLS-1$
          return new LocalDateRange(relativeDate.minusWeeks(numberOfTemporalUnit), true);
        case "months": //$NON-NLS-1$
          return new LocalDateRange(relativeDate.minusMonths(numberOfTemporalUnit), true);
        case "years": //$NON-NLS-1$
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
          if (option == null) {
            dateRange.end = date.withDayOfMonth(date.lengthOfMonth());
          } else if (option == Option.GREATER_THAN || option == Option.GREATER_EQUAL) {
            dateRange.start = date.withDayOfMonth(date.lengthOfMonth());
            dateRange.end = dateRange.start;
          }
        } else if (numericPatternType == NumericDatePatternType.YEAR) {
          if (option == null) {
            dateRange.end = date.withMonth(12).withDayOfMonth(date.lengthOfMonth());
          } else if (option == Option.GREATER_EQUAL || option == Option.GREATER_THAN) {
            dateRange.start = date.withMonth(12).withDayOfMonth(date.lengthOfMonth());
            dateRange.end = dateRange.start;
          }
        }
        return dateRange;
      }
      return null;
    }

    /*
     * Converts array of date parts into a local date
     */
    private LocalDate convertNumericDatePartsToDate(final String[] dateParts,
        final NumericDatePatternType numericDatePatternType) throws DateTimeException {
      switch (numericDatePatternType) {
      case FULL:
        return LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer
            .parseInt(dateParts[0]));
      case DAY_MONTH:
        return LocalDate.of(LocalDate.now().getYear(), Integer.parseInt(dateParts[1]), Integer
            .parseInt(dateParts[0]));
      case MONTH_YEAR:
        return LocalDate.of(Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]), 1);
      case YEAR:
        return LocalDate.of(Integer.parseInt(dateParts[0]), 1, 1);
      default:
        return null;
      }
    }

    /*
     * Converts a numeric date pattern into a {@link LocalDate} instance or throws
     * an exception if that is not possible.<br> <p> The method can handle the
     * following pattern types
     */
    private LocalDate convertNumericDatePatternToDate(final String datePattern)
        throws CoreException {
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

    private IStatus createErrorStatus(final String message) throws CoreException {
      return new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, message);
    }

    private NumericDatePatternType getNumericDatePatternType(final String[] dateParts) {
      if (dateParts.length == 3) {
        return NumericDatePatternType.FULL;
      }
      if (dateParts.length == 2) {
        if (dateParts[1].length() == 4) {
          return NumericDatePatternType.MONTH_YEAR;
        }
        return NumericDatePatternType.DAY_MONTH;
      }
      if (dateParts.length == 1) {
        return NumericDatePatternType.YEAR;
      }
      return null;
    }

    private Option getOptionFromPattern(final String datePattern) {
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

    LocalDateRange(final LocalDate date, final boolean isStartEnd) {
      start = date;
      if (isStartEnd) {
        end = date;
      }
    }
  }

  private enum NumericDatePatternType {
    DAY_MONTH,
    MONTH_YEAR,
    FULL,
    YEAR;
  }

  private enum Option {
    EQUALS("EQ", "="), //$NON-NLS-1$ //$NON-NLS-2$
    GREATER_THAN("GT", ">"), //$NON-NLS-1$ //$NON-NLS-2$
    GREATER_EQUAL("GE", ">="), //$NON-NLS-1$ //$NON-NLS-2$
    LESSER_THAN("LT", "<"), //$NON-NLS-1$ //$NON-NLS-2$
    LESSER_EQUAL("LE", "<="), //$NON-NLS-1$ //$NON-NLS-2$
    BETWEEN("BT", "..."); //$NON-NLS-1$ //$NON-NLS-2$

    private final String symbol;
    private final String externalSymbol;

    Option(final String symbol, final String externalSymbol) {
      this.symbol = symbol;
      this.externalSymbol = externalSymbol;
    }

    public static Option fromExternalSymbol(final String externalSymbol) {
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
      return symbol;
    }
  }

  private enum Sign {
    INCLUDING("I"), //$NON-NLS-1$
    EXCLUDING("E"); //$NON-NLS-1$

    private final String symbol;

    Sign(final String symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return symbol;
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
  public String getLongDescription() {
    if (longDescription == null) {
      longDescription = NLS.bind(Messages.SearchFilter_DescriptionDateSearchFilter_xmsg,
          new Object[] { descriptionIntro, label, });
    }
    return longDescription;
  }

  @Override
  public List<IContentProposal> getProposalList(String query) throws CoreException {
    if (dateProposals == null) {
      initRelativeDates();
    }

    // check if query is after range
    var rangeSeparatorIndex = query.indexOf(RANGE_SEPARATOR);
    if (rangeSeparatorIndex != -1) {
      query = query.substring(rangeSeparatorIndex + 3);
    }

    // check if query starts with comparator
    var comparisonMatcher = DATE_OPERATORS_PATTERN.matcher(query);
    if (comparisonMatcher.find()) {
      query = query.substring(comparisonMatcher.group(1).length());
    }

    final var atomicQuery = new AtomicReference<>(query);
    Predicate<String> queryPattern = StringUtil.getPatternForQuery(query).asMatchPredicate();

    Pattern numericRelativePattern = Pattern.compile("^(\\d{1,3})-?"); //$NON-NLS-1$
    Matcher numericRelativeMatcher = numericRelativePattern.matcher(query);
    if (numericRelativeMatcher.find()) {
      String numericValue = numericRelativeMatcher.group(1);
      return relativeNumericDates.stream()
          .map(relative -> numericValue + relative)
          .filter(queryPattern)
          .map(datePattern -> new SearchFilterValueProposal(datePattern, this, null, atomicQuery
              .get(), getImage()))
          .collect(Collectors.toList());
    }
    return dateProposals.stream()
        .filter(queryPattern)
        .map(datePattern -> new SearchFilterValueProposal(datePattern, this, null, atomicQuery
            .get(), getImage()))
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
    dateProposals = Arrays.asList("today", "yesterday", "last-week", "last-month", "last-year"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
    relativeNumericDates = Arrays.asList("-days-ago", "-weeks-ago", "-months-ago", "-years-ago"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  }

}
