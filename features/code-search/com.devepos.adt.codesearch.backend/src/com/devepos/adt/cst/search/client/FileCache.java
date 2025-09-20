package com.devepos.adt.cst.search.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.eclipse.core.runtime.Platform;

import com.devepos.adt.cst.internal.CodeSearchPlugin;

public class FileCache {
  private int maxCacheSize = 0;
  private AtomicLong currentCacheSize = new AtomicLong(0);

  private static final String CACHE_BASE_PATH = Platform
      .getStateLocation(CodeSearchPlugin.getDefault().getBundle())
      .addTrailingSeparator()
      .append(".cache")
      .addTrailingSeparator()
      .toString();

  public void setMaxCacheSize(int maxCacheSize) {
    this.maxCacheSize = maxCacheSize;
  }

  public void writeCodeToFile(String source, String filePath) {
    try {
      Files.createDirectories(Paths.get(filePath).getParent());
      var fos = new ProxyOutputStream(new FileOutputStream(filePath));
      var gzipOS = new GZIPOutputStream(fos);
      gzipOS.write(source.getBytes());
      gzipOS.close();
      fos.close();
      currentCacheSize.getAndAdd(fos.getWrittenBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getCodeFromFile(String filePath) {
    try {
      var gzipInputStream = new GZIPInputStream(new FileInputStream(filePath));
      var compressedContent = gzipInputStream.readAllBytes();
      gzipInputStream.close();
      return new String(compressedContent);
    } catch (IOException e) {

    }
    return null;
  }

  public boolean isSourceCached(String filePath) {
    return new File(filePath).exists();
  }

  public String uriToFilePath(String uri) {
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

  private static class ProxyOutputStream extends FilterOutputStream {
    private long written = 0;

    public ProxyOutputStream(OutputStream out) {
      super(out);
    }

    @Override
    public void write(int b) throws IOException {
      super.write(b);
      written++;
    }

    @Override
    public void write(byte[] b) throws IOException {
      super.write(b);
      written += b.length;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
      super.write(b, off, len);
      written += len;
    }

    public long getWrittenBytes() {
      return written;
    }
  }
}