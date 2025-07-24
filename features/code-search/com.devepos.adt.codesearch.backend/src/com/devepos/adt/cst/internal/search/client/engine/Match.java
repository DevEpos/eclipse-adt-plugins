package com.devepos.adt.cst.internal.search.client.engine;

public record Match(int line, int offset, int endLine, int endOffset, String snippet,
    String longSnippet) {

}
