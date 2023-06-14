package com.devepos.adt.base.ui.internal.contentassist;

/**
 * Determines how the content of a proposal should be determined
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public enum ProposalContentStyle {
  /**
   * The proposal will replace the existing content of the control
   */
  REPLACE,
  /**
   * The proposal content will be inserted at the current cursor position. <br>
   * <strong>WARNING:</strong> Additional adjustments may need to be done after
   * insertion
   */
  INSERT;
}
