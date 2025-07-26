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
    if (IAdtObjectTypeConstants.CLASS.equals(type)) {
      return new AbapClassSourceCodeReader(session, m, multiLine);
    }
    return new StandardSourceCodeReader(type, session, m, multiLine);
  }

  static class StandardSourceCodeReader extends AbstractSourceCodeReader
      implements ISourceCodeReader {

    private final boolean multiLine;
    private final String type;

    public StandardSourceCodeReader(final String type, final IStatelessSystemSession session,
        final IProgressMonitor m, final boolean multiLine) {
      super(session, m);
      this.type = type;
      this.multiLine = multiLine;
    }

    @Override
    public ISourceCode getSourceCode(final String uri) {
      var source = readSource(uri);

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
    }

  }

  private static class AbapClassSourceCodeReader extends AbstractSourceCodeReader
      implements ISourceCodeReader {
    private final boolean multiLine;

    public AbapClassSourceCodeReader(final IStatelessSystemSession session,
        final IProgressMonitor m, final boolean multiLine) {
      super(session, m);
      this.multiLine = multiLine;
    }

    @Override
    public ISourceCode getSourceCode(final String uri) {
      var source = readSource(uri);
      source = SourceContentUtil.adjustLineEndings(source);
      if (uri.endsWith("/source/main")) {
        return new SourceCode(new String[] { source },
            SourceContentUtil.determineLineIndexes(source),
            ISourceCodeReader.DEFAULT_COMMENT_REGEX);
      }
      // no further modifications after creation required
      return new SourceCode(multiLine ? new String[] { source } : source.split("\n"),
          multiLine ? SourceContentUtil.determineLineIndexes(source) : null,
          ISourceCodeReader.DEFAULT_COMMENT_REGEX);
    }

  }

  private static class AbstractSourceCodeReader {
    private final IStatelessSystemSession session;
    private final IProgressMonitor m;

    protected AbstractSourceCodeReader(final IStatelessSystemSession session,
        final IProgressMonitor m) {
      this.session = session;
      this.m = m;
    }

    protected String readSource(final String uri) {
      var contentResource = URI.create(uri);
      var resource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(contentResource, session);
      resource.addContentHandler(new PlainTextContentHandler());
      var headerField = HeadersFactory.newField("Accept", new String[] { "text/plain" });
      var requestHeaders = HeadersFactory.newHeaders();
      requestHeaders.addField(headerField);
      var source = resource.get(m, requestHeaders, String.class);
      return source;
    }

  }
}
