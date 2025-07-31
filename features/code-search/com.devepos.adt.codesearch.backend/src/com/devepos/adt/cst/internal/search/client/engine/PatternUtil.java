package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devepos.adt.base.util.StringUtil;

/**
 * Utility class for handling pattern sequences and their control flags.
 * Converted from ABAP class `zcl_adcoset_pattern_util`.
 */
public final class PatternUtil {

  private static final Set<Integer> POSSIBLE_CTRL_SEQ_RANGE = new HashSet<>();
  private static final Map<String, PatternCtrlSequence> PATTERN_MAP = Stream
      .of(PatternCtrlSequence.values())
      .collect(Collectors.toMap(PatternCtrlSequence::toString, Function.identity()));

  private static Pattern CTRL_SEQ_PATTERN;
  private static Pattern ANY_VALID_CTRL_SEQ_PATTERN;
  private static Pattern ANY_CTRL_SEQ_PATTERN = Pattern.compile("^(\\(#[^\s)]+\\))+");

  /**
   * Initializes control flag to sequence map and regex patterns.
   */
  static {
    POSSIBLE_CTRL_SEQ_RANGE.add(
        PatternCtrlSequence.MATCH_START.getFlag() | PatternCtrlSequence.BOUNDARY_START.getFlag());
    POSSIBLE_CTRL_SEQ_RANGE
        .add(PatternCtrlSequence.MATCH_END.getFlag() | PatternCtrlSequence.BOUNDARY_END.getFlag());

    var ctrlSequencesRegex = Stream.of(PatternCtrlSequence.values())
        .map(p -> p.toString().replace("(", "\\(").replace(")", "\\)"))
        .collect(Collectors.joining("|"));

    ANY_VALID_CTRL_SEQ_PATTERN = Pattern.compile("(" + ctrlSequencesRegex + ")");
    CTRL_SEQ_PATTERN = Pattern.compile("^(" + ctrlSequencesRegex + ")+");
  }

  /**
   * Parses a full pattern sequence.
   */
  public static List<SequentialPattern> parsePatternSequence(final List<String> patterns)
      throws StaticError {
    var parsedPatterns = parsePatterns(patterns);
    validateSequence(parsedPatterns);
    return parsedPatterns;
  }

  /**
   * Parses a list of patterns.
   */
  private static List<SequentialPattern> parsePatterns(final List<String> patterns)
      throws StaticError {
    var result = new ArrayList<SequentialPattern>();
    var isSequenceFound = false;

    for (var pattern : patterns) {
      var seqPattern = parsePattern(pattern);
      result.add(seqPattern);

      if (!isSequenceFound && seqPattern.flags() != 0) {
        isSequenceFound = true;
      }
    }

    if (!isSequenceFound) {
      return result;
    }

    validateSequence(result);

    return result;
  }

  /**
   * Parses a single pattern to detect and assign control flags.
   */
  private static SequentialPattern parsePattern(final String pattern) throws StaticError {
    var matcher = CTRL_SEQ_PATTERN.matcher(pattern);
    if (!matcher.find()) {
      // check if pattern has invalid control sequence
      var invalidSeqMatcher = ANY_CTRL_SEQ_PATTERN.matcher(pattern);
      if (invalidSeqMatcher.find()) {
        throw new StaticError(
            String.format("Invalid control sequence in pattern '%s' detected", pattern));
      }
      return new SequentialPattern(pattern, 0);
    }

    var ctrlSequence = pattern.substring(0, matcher.end());
    var patternWithoutSeq = pattern.substring(matcher.end());

    var count = ANY_VALID_CTRL_SEQ_PATTERN.matcher(ctrlSequence).results().count();
    var flags = 0;
    if (count > 1) {
      flags = parseSequences(ctrlSequence);
    } else {
      flags = PATTERN_MAP.get(ctrlSequence).getFlag();
    }

    if (StringUtil.isEmpty(patternWithoutSeq)) {
      throw new StaticError(
          String.format("Control sequence %s without a pattern is not possible", ctrlSequence));
    }
    return new SequentialPattern(patternWithoutSeq, flags);
  }

  /**
   * Validates the structure and rules of a pattern sequence.
   */
  private static void validateSequence(final List<SequentialPattern> patterns) throws StaticError {
    var excludesCount = 0;
    var boundaryStartIndex = 0;
    var matchStartIndex = 0;
    var matchFound = false;
    var singleMatchSeqFound = false;

    for (var i = 0; i < patterns.size(); i++) {
      var pattern = patterns.get(i);
      var flags = pattern.flags();

      if ((flags & PatternCtrlSequence.BOUNDARY_START.getFlag()) != 0) {
        if (boundaryStartIndex > 0) {
          throw new StaticError(String.format("Previous boundary sequence not closed with '%s'",
              PatternCtrlSequence.BOUNDARY_END));
        }
        boundaryStartIndex = i + 1;
      } else if ((flags & PatternCtrlSequence.EXCLUDE.getFlag()) != 0) {
        excludesCount++;
      } else if ((flags & PatternCtrlSequence.BOUNDARY_END.getFlag()) != 0) {
        if (boundaryStartIndex == 0) {
          throw new StaticError(
              "No boundary sequence started with '" + PatternCtrlSequence.BOUNDARY_START + "'");
        }
        boundaryStartIndex = 0;
      } else if ((flags & PatternCtrlSequence.MATCH.getFlag()) != 0) {
        if (matchFound || singleMatchSeqFound) {
          throw new StaticError(
              "MATCH and MATCH_START/MATCH_END are exclusive and can not occur together");
        }
        singleMatchSeqFound = true;
      }

      if ((flags & PatternCtrlSequence.MATCH_START.getFlag()) != 0) {
        if (matchFound || singleMatchSeqFound) {
          throw new StaticError(
              "MATCH and MATCH_START/MATCH_END are exclusive and can not occur together");
        }
        matchStartIndex = i + 1;
        matchFound = true;
      } else if ((flags & PatternCtrlSequence.MATCH_END.getFlag()) != 0) {
        if (!matchFound) {
          throw new StaticError(String.format("No match sequence started with '%s'",
              PatternCtrlSequence.MATCH_START));
        }
        matchStartIndex = 0;
      }
    }

    if (matchFound && matchStartIndex > 0) {
      throw new StaticError(
          "Match sequence not closed with '" + PatternCtrlSequence.MATCH_END + "'");
    }
    if (patterns.size() == excludesCount) {
      throw new StaticError("The sequence can not contain only excludes");
    }
    if (boundaryStartIndex > 0) {
      throw new StaticError(String.format("Boundary sequence not closed with '%s'",
          PatternCtrlSequence.BOUNDARY_END));
    }
  }

  /**
   * Parses multiple control flags from a combined control sequence.
   */
  private static int parseSequences(final String ctrlSequence) throws StaticError {
    var result = 0;
    var rest = ctrlSequence;

    while (!rest.isEmpty()) {
      var index = rest.indexOf(')') + 1;
      if (index <= 0) {
        break;
      }
      var sequence = rest.substring(0, index);
      result |= PATTERN_MAP.get(sequence).getFlag();
      rest = rest.substring(index);
    }

    if (!POSSIBLE_CTRL_SEQ_RANGE.contains(result)) {
      throw new StaticError("Invalid control sequence combination in " + ctrlSequence);
    }

    return result;
  }

  public static class StaticError extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public StaticError(final String message) {
      super(message);
    }
  }
}