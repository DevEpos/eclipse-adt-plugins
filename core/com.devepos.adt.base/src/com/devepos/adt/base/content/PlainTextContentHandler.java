package com.devepos.adt.base.content;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.sap.adt.communication.content.AdtMediaType;
import com.sap.adt.communication.content.IContentHandler;
import com.sap.adt.communication.message.ByteArrayMessageBody;
import com.sap.adt.communication.message.IMessageBody;

/**
 * Content Handler for plain text (i.e. text/plain)
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class PlainTextContentHandler implements IContentHandler<String> {

  @Override
  public String deserialize(final IMessageBody body, final Class<? extends String> clazz) {
    try {
      final InputStream is = body.getContent();
      final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      final StringBuilder out = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        out.append(line);
      }
      reader.close();
      return out.toString();
    } catch (final IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public String getSupportedContentType() {
    return AdtMediaType.TEXT_PLAIN;
  }

  @Override
  public Class<String> getSupportedDataType() {
    return String.class;
  }

  @Override
  public IMessageBody serialize(final String dataObject, final Charset charset) {
    return new ByteArrayMessageBody(AdtMediaType.TEXT_PLAIN, charset != null ? dataObject.getBytes(
        charset) : dataObject.getBytes(StandardCharsets.UTF_8));
  }

}
