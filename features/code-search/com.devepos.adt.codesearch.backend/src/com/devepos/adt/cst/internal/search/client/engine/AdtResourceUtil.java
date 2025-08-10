package com.devepos.adt.cst.internal.search.client.engine;

import java.io.IOException;

import com.devepos.adt.cst.search.NetworkException;
import com.sap.adt.communication.exceptions.CommunicationException;
import com.sap.conn.jco.JCoException;

public class AdtResourceUtil {

  public static void handleNetworkError(final Throwable exc) {
    if (exc instanceof CommunicationException
        && (exc.getCause() instanceof JCoException || exc.getCause() instanceof IOException)) {
      throw new NetworkException("Network connection interrupted", exc.getCause());
    }
  }
}
