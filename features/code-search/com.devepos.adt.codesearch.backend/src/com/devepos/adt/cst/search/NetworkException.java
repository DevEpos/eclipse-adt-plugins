package com.devepos.adt.cst.search;

public class NetworkException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NetworkException() {
    super();
  }

  public NetworkException(String message) {
    super(message);
  }

  public NetworkException(String message, Throwable cause) {
    super(message, cause);
  }

}
