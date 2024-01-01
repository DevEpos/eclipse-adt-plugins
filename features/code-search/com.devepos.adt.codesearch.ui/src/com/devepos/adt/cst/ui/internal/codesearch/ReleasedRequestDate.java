package com.devepos.adt.cst.ui.internal.codesearch;

import com.devepos.adt.cst.ui.internal.messages.Messages;

/**
 * Fixed Dates for predefined transport request/task filter in Search Scope
 *
 * @author Ludwig Stockbauer-Muhr
 */
public enum ReleasedRequestDate {
  FROM_TWO_WEEKS_AGO(Messages.ReleasedRequestDate_FromLastTwoWeeks_xlbl),
  FROM_FOUR_WEEKS_AGO(Messages.ReleasedRequestDate_FromLastFourWeeks_xlbl),
  SINCE_YESTERDAY(Messages.ReleasedRequestDate_SinceYesterday_xlbl),
  ALL(Messages.ReleasedRequestDate_All_xlbl);

  private final String label;

  ReleasedRequestDate(final String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }

}
