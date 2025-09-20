package com.devepos.adt.cst.internal.search.client.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.content.PlainTextContentHandler;
import com.devepos.adt.cst.internal.CodeSearchPlugin;
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
    private static final String CACHE_BASE_PATH = Platform
        .getStateLocation(CodeSearchPlugin.getDefault().getBundle())
        .addTrailingSeparator()
        .append("cache")
        .addTrailingSeparator()
        .toOSString();

    protected AbstractSourceCodeReader(final IStatelessSystemSession session,
        final IProgressMonitor m) {
      this.session = session;
      this.m = m;
    }

    protected String readSource(final String uri) {
      var filePath = uriToFilePath(uri);
      if (isSourceCached(filePath)) {
        return getCodeFromFile(filePath);
      }
      var contentResource = URI.create(uri);
      var resource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(contentResource, session);
      resource.addContentHandler(new PlainTextContentHandler());
      var headerField = HeadersFactory.newField("Accept", new String[] { "text/plain" });
      var requestHeaders = HeadersFactory.newHeaders();
      requestHeaders.addField(headerField);
      var source = resource.get(m, requestHeaders, String.class);
      writeCodeToFile(source, filePath);
      return source;
    }

    private void writeCodeToFile(String source, String filePath) {
      try {
        Files.createDirectories(Paths.get(filePath).getParent());
        var fos = new FileOutputStream(filePath);
        var gzipOS = new GZIPOutputStream(fos);
        gzipOS.write(source.getBytes());
        gzipOS.close();
        fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }

    private String getCodeFromFile(String filePath) {
      try {
        var gzipInputStream = new GZIPInputStream(new FileInputStream(filePath));
        var compressedContent = gzipInputStream.readAllBytes();
        gzipInputStream.close();
        return new String(compressedContent);
      } catch (IOException e) {

      }
      return null;
    }

    private boolean isSourceCached(String filePath) {
      return new File(filePath).exists();
    }

    private String uriToFilePath(String uri) {
      var relativeFilePath = uri.substring("/sap/bc/adt/".length());
      var mainSourceIndex = relativeFilePath.indexOf("/source/main");
      if (mainSourceIndex != -1) {
        relativeFilePath = relativeFilePath.substring(0, mainSourceIndex);
      } else {
        // check include name
        var includesIndex = relativeFilePath.indexOf("/includes/");
        if (includesIndex != -1) {
          relativeFilePath = relativeFilePath.substring(0, includesIndex) + "." +
              relativeFilePath.substring(includesIndex + "/includes/".length());
        }
      }
      return CACHE_BASE_PATH + relativeFilePath + ".abap";
    }
  }
}
