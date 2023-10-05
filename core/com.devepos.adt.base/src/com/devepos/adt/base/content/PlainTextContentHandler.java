package com.devepos.adt.base.content;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.sap.adt.communication.content.AdtMediaType;
import com.sap.adt.communication.content.ContentHandlerException;
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
      var bos = new ByteArrayOutputStream((int) body.getContentLength());
      body.writeTo(bos);

      return (String) clazz.getConstructor(byte[].class, Charset.class)
          .newInstance(bos.toByteArray(), StandardCharsets.UTF_8);
    } catch (final Exception e) {
      throw new ContentHandlerException(e.getMessage());
    }
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
