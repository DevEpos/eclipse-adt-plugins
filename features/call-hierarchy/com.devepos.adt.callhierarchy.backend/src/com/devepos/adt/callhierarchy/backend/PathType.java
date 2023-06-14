package com.devepos.adt.callhierarchy.backend;

/**
 * Type for the path that is used to resolve an ABAP element
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public enum PathType {
  URI("uri"),
  FULL_NAME("fullName");

  private String literal;

  PathType(final String literal) {
    this.literal = literal;
  }

  public String getLiteral() {
    return literal;
  }

}
