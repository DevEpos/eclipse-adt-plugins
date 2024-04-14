package com.devepos.adt.base.elementinfo;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Provider for Retrieving element information
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface IElementInfoProvider {

  /**
   * Reads the elements considering the retrieval rules of this element
   * information provider
   * 
   * @param monitor progress monitor
   *
   * @return the found elements or {@code null}
   */
  List<IElementInfo> getElements(IProgressMonitor monitor) throws CoreException;

  /**
   * Returns a descriptive text for the element information provider
   *
   * @return a description for the provider (e.g. for job's)
   */
  String getProviderDescription();
}
