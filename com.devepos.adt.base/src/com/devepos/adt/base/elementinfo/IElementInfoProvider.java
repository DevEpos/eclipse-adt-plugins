package com.devepos.adt.base.elementinfo;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

/**
 * Provider for Retrieving element information
 *
 * @author stockbal
 */
public interface IElementInfoProvider {

  /**
   * Reads the elements considering the retrieval rules of this element
   * information provider
   *
   * @return
   */
  List<IElementInfo> getElements() throws CoreException;

  /**
   * Returns a descriptive text for the element information provider
   *
   * @return
   */
  String getProviderDescription();
}
