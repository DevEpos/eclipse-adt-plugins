package com.devepos.adt.atm.ui.internal.tree;

import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagBase;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.util.StringUtil;

/**
 * Label Provider for Viewer which holds instances of type {@link ITagBase}
 *
 * @author stockbal
 */
public class TagLabelProvider extends LabelProvider implements IStyledLabelProvider {

  private final boolean noCounterText;
  private final boolean noDescription;
  private boolean markOwnSharedTags = false;

  /**
   * Creates new Label Provider for Viewer which holds instances of type
   * {@link ITagBase}
   */
  public TagLabelProvider() {
    this(false, true);
  }

  /**
   * Creates new Label Provider for Viewer which holds instances of type
   * {@link ITagBase}
   *
   * @param noCounterText prevents displaying the counter of objects that exist
   *                      for a given tag
   * @param noDescription prevents displaying the description of the tag
   */
  public TagLabelProvider(final boolean noCounterText, final boolean noDescription) {
    this.noCounterText = noCounterText;
    this.noDescription = noDescription;
  }

  /**
   * Enables/disables that own shared tags are specially decorated
   *
   * @param markOwnSharedTags
   */
  public void setMarkOwnSharedTags(final boolean markOwnSharedTags) {
    this.markOwnSharedTags = markOwnSharedTags;
  }

  @Override
  public Image getImage(final Object element) {
    if (element instanceof ITag) {
      return ImageUtil.getImageForTag((ITag) element, markOwnSharedTags);
    }
    return null;
  }

  @Override
  public StyledString getStyledText(final Object element) {
    final var text = new StyledString();
    final var tagNode = (ITag) element;

    appendTagName(tagNode, text);
    appendCounterText(tagNode, text);
    appendDescription(tagNode, text);

    return text;
  }

  @Override
  public String getText(final Object element) {
    final var node = (ITagBase) element;
    return node.getName();
  }

  protected void appendCounterText(final ITag tag, final StyledString text) {
    if (noCounterText) {
      return;
    }
    if (!StringUtil.isEmpty(tag.getId())) {
      text.append(" (" + tag.getTaggedObjectCount() + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
    }

  }

  protected void appendDescription(final ITag tagNode, final StyledString text) {
    if (noDescription) {
      return;
    }
    if (tagNode.getDescription() != null) {
      text.append("  " + tagNode.getDescription(),
          StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
    }
  }

  protected void appendTagName(final ITag tag, final StyledString text) {
    if (tag != null && tag.isChanged()) {
      text.append(tag.getName(), StylerFactory.ITALIC_STYLER);
    } else {
      text.append(tag.getName());
    }
  }
}