package com.devepos.adt.base.ui.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.sap.adt.tools.core.ui.dialogs.LinkToAdtPreferencePageBlock;
import com.sap.adt.tools.core.ui.dialogs.LinkToAdtPropertyPageBlock;

/**
 * Factory for creating {@link ILinkToAdtPageBlock}'s
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
@SuppressWarnings("restriction")
public class LinkToAdtPageBlocksFactory {

  private static class LinkToAdtPreferencePageBlockProxy implements ILinkToAdtPageBlock {

    private final LinkToAdtPreferencePageBlock linkPageBlock;

    public LinkToAdtPreferencePageBlockProxy(final String preferencePageId,
        final Object dataToPass) {
      linkPageBlock = new LinkToAdtPreferencePageBlock(preferencePageId, dataToPass);
    }

    @Override
    public Control createControl(final Composite parent, final Object layoutDataToSet) {
      return linkPageBlock.createControl(parent, layoutDataToSet);
    }

  }

  private static class LinkToAdtPropertyPageBlockProxy implements ILinkToAdtPageBlock {

    private final LinkToAdtPropertyPageBlock linkPageBlock;

    public LinkToAdtPropertyPageBlockProxy(final String preferencePageId, final Object dataToPass) {
      linkPageBlock = new LinkToAdtPropertyPageBlock(preferencePageId, dataToPass);
    }

    @Override
    public Control createControl(final Composite parent, final Object layoutDataToSet) {
      return linkPageBlock.createControl(parent, layoutDataToSet);
    }

  }

  public static ILinkToAdtPageBlock createLinkToPreferencePage(final String pageId,
      final Object dataToPass) {
    return new LinkToAdtPreferencePageBlockProxy(pageId, dataToPass);
  }

  public static ILinkToAdtPageBlock createLinkToPropertyPage(final String pageId,
      final Object dataToPass) {
    return new LinkToAdtPropertyPageBlockProxy(pageId, dataToPass);
  }
}
