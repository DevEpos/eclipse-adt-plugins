package com.devepos.adt.cst.internal.search.client.engine;

import java.net.URI;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.content.PlainTextContentHandler;
import com.sap.adt.communication.message.HeadersFactory;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.IStatelessSystemSession;

public class SourceCodeReaderFactory {

  public static ISourceCodeReader getReader(final String type,
      final IStatelessSystemSession session, final IProgressMonitor m, final boolean multiLine) {
    return uri -> {
      var contentResource = URI.create(uri);
      var resource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(contentResource, session);
      resource.addContentHandler(new PlainTextContentHandler());
      var headerField = HeadersFactory.newField("Accept", new String[] { "text/plain" });
      var requestHeaders = HeadersFactory.newHeaders();
      requestHeaders.addField(headerField);
      var source = resource.get(m, requestHeaders, String.class);

      // remove any CRLF line breaks in favor of LF
      source = SourceContentUtil.adjustLineEndings(source);

      String commentRegex = null;
      switch (type) {
      case IAdtObjectTypeConstants.BEHAVIOR_DEFINITION:
        commentRegex = ISourceCodeReader.BDEF_COMMENT_REGEX;
        break;
      case IAdtObjectTypeConstants.DATA_DEFINITION:
      case IAdtObjectTypeConstants.METADATA_EXTENSION:
      case IAdtObjectTypeConstants.ACCESS_CONTROL:
        commentRegex = ISourceCodeReader.CDS_COMMENT_REGEX;
        break;
      default:
        commentRegex = ISourceCodeReader.DEFAULT_COMMENT_REGEX;
      }

      String[] sourceLines = null;
      LineIndex[] indexes = null;
      if (multiLine) {
        indexes = SourceContentUtil.determineLineIndexes(source);
        sourceLines = new String[] { source };
      } else {
        sourceLines = source.split("\n");
      }
      return new SourceCode(sourceLines, indexes, commentRegex);
    };
  }
}
