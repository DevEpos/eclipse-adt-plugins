package com.devepos.adt.base.ui.search.ext;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.util.StringUtil;

/**
 * Registry for search page extensions
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class SearchPageExtensionsRegistry {

  private static final String SEARCH_PAGE_EXTENSIONS_EXT_POINT = "searchPageExtensions";

  private static final String PARAMETER_SECTION_ELEMENT = "parameterSection";

  private static final String PARAMETER_ID_ATTRIBUTE = "parameterId";
  private static final String CLASS_ATTRIBUTE = "class";
  private static final String PAGE_ID_ATTRIBUTE = "pageId";

  /**
   * Retrieves all registered parameter sections for a given search page
   *
   * @param pageId id that uniquely identifies a search page
   * @return list of registered parameter sections for the given page
   * @throws CoreException
   */
  public static List<ISearchPageParameterSection> getParameterSections(final String pageId)
      throws CoreException {
    if (StringUtil.isEmpty(pageId)) {
      throw new IllegalArgumentException("Parameter 'pageId' must be a valid String");
    }

    IConfigurationElement[] elements = Platform.getExtensionRegistry()
        .getConfigurationElementsFor(AdtBaseUIPlugin.PLUGIN_ID, SEARCH_PAGE_EXTENSIONS_EXT_POINT);

    List<ISearchPageParameterSection> parameterSections = new ArrayList<>();

    for (IConfigurationElement element : elements) {
      if (!PARAMETER_SECTION_ELEMENT.equals(element.getName()) && !pageId.equals(element
          .getAttribute(PAGE_ID_ATTRIBUTE))) {
        continue;
      }
      ISearchPageParameterSection paramSection = (ISearchPageParameterSection) element
          .createExecutableExtension(CLASS_ATTRIBUTE);
      paramSection.setParameterId(element.getAttribute(PARAMETER_ID_ATTRIBUTE));
      parameterSections.add(paramSection);
    }
    return parameterSections;
  }
}
