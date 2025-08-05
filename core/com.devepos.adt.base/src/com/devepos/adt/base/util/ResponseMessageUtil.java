package com.devepos.adt.base.util;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.internal.messages.Messages;
import com.devepos.adt.base.model.adtbase.IResponseMessage;

public class ResponseMessageUtil {

  /**
   * Converts the given list of messages into multi status containing status entries for each of the
   * messages.
   * Returns {@code null} if no messages have been provided
   * 
   * @param pluginId the plugin id to use for the status entries
   * @param message  the message for the multi status
   * @param messages list of message to be added/converted into child status entries
   */
  public static IStatus toStatus(final String pluginId, final String message,
      final List<IResponseMessage> messages) {
    if (messages == null || messages.size() <= 0) {
      return null;
    }
    return new MultiStatus(pluginId, 0, messages.stream().map(m -> {
      var occurrenceIndicator = "";
      if (m.getOccurrences() > 1) {
        occurrenceIndicator = String.format(Messages.ResponseMessageList_MessageMultiplierText_xmsg,
            m.getOccurrences());
      }
      return new Status(m.getStatusType(), pluginId, m.getContent() + occurrenceIndicator,
          m.getExeption());
    }).toArray(IStatus[]::new), message, null);
  }
}
