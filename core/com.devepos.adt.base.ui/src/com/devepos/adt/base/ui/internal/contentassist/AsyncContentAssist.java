package com.devepos.adt.base.ui.internal.contentassist;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.util.Reflection;

/**
 * Adds asynchronous content assist support to a {@link Text} control.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class AsyncContentAssist extends ContentAssist {

  protected static final String EMPTY_STRING = "";
  protected static final int POPUP_DEFAULT_HEIGHT = 300;
  protected static final int POPUP_DEFAULT_WIDTH = 300;
  protected AsyncTextQueryProposalProvider contentProvider;
  protected final List<IContentProposal> queryResults = new ArrayList<>();
  private IContentChangeListener contentChangeListener;
  private IContentProposalListener proposalListener;

  public AsyncContentAssist(final Text text,
      final ITextQueryProposalProvider queryProposalProvider) {
    super(text);

    contentChangeListener = resultList -> {
      showProposals(resultList);
    };
    contentProvider = new AsyncTextQueryProposalProvider(queryProposalProvider);
    contentProvider.addContentChangeListener(contentChangeListener);

    // use the content provider as the query proposal proposal provider
    setQueryProposalProvider(contentProvider);
  }

  /**
   * Disposes of allocated resources
   */
  @Override
  public void dispose() {
    super.dispose();
    if (contentChangeListener != null && contentProvider != null) {
      contentProvider.removeContentChangeListener(contentChangeListener);
    }
    removeProposalListener();
  }

  /**
   * Calculates the size of popup by analyzing the current proposals. <br>
   * Subclasses may override
   *
   * @param popup  the popup dialog to show the proposals
   * @param height the height
   * @return the new size for the popup
   */
  protected Point calculatePopupSizeForProposals(final IContentProposal proposal,
      final PopupDialog popup, final int height) {
    return new Point(calculatePopupWidthForProposals(popup), height);
  }

  @Override
  protected List<IContentProposal> computeProposals(final String query) {
    List<IContentProposal> proposals = super.computeProposals(query);
    queryResults.clear();
    if (proposals != null) {
      queryResults.addAll(proposals);
    }
    return proposals;
  }

  /**
   * Sets a content proposal listener. <br>
   * A previously set listener will be removed beforehand
   *
   * @param l the listener to be set
   */
  protected void setContentProposalListener(final IContentProposalListener l) {
    removeProposalListener();
    proposalListener = l;
    getContentProposalAdapter().addContentProposalListener(proposalListener);
  }

  private Point calculatePopupSize(final PopupDialog popup) {
    Point size = calculatePopupSizeForProposals(queryResults.get(0), popup, POPUP_DEFAULT_HEIGHT);
    return size != null ? size : new Point(POPUP_DEFAULT_WIDTH, POPUP_DEFAULT_HEIGHT);
  }

  private int calculatePopupWidthForProposals(final PopupDialog popup) {
    int width = (int) Math.max(300L, Math.round(text.getSize().x * 0.5));
    final GC gc = new GC(popup.getShell().getParent());
    final Font font = popup.getShell().getChildren()[0].getFont();
    gc.setFont(font);

    final ILabelProvider labelProvider = getContentProposalAdapter().getLabelProvider();

    for (final IContentProposal proposal : queryResults) {
      int proposalWidth = gc.stringExtent(getString(proposal, labelProvider)).x + 26;
      final Image image = labelProvider != null ? labelProvider.getImage(proposal) : null;
      if (image != null) {
        proposalWidth += image.getImageData().width + 16;
      }
      if (proposalWidth > width) {
        width = proposalWidth;
      }
    }
    gc.dispose();
    return width;

  }

  /**
   * Retrieves the pop up dialog of the content proposal adapter
   *
   * @return the PopupDialog instance
   */
  private PopupDialog getProposalsPopup() {
    final ContentProposalAdapter proposalAdapter = getContentProposalAdapter();
    return (PopupDialog) Reflection.forObject(proposalAdapter)
        .getFieldValue("popup", proposalAdapter.getClass());
  }

  /*
   * Get the string for the specified proposal. Always return a String of some
   * kind.
   */
  private String getString(final IContentProposal proposal, final ILabelProvider labelProvider) {
    if (proposal == null) {
      return EMPTY_STRING;
    }
    if (labelProvider == null) {
      return proposal.getLabel() == null ? proposal.getContent() : proposal.getLabel();
    }
    return labelProvider.getText(proposal);
  }

  private void removeProposalListener() {
    if (proposalListener != null) {
      getContentProposalAdapter().removeContentProposalListener(proposalListener);
    }
  }

  private void resizePopupDeferred(final PopupDialog popup) throws NoSuchMethodException,
      IllegalAccessException, InvocationTargetException {
    if (queryResults == null || queryResults.size() == 0) {
      popup.close();
      return;
    }
    final Point popupSize = calculatePopupSize(popup);
    getContentProposalAdapter().setPopupSize(popupSize);
    Reflection.forObject(popup).invoke("adjustBounds");
  }

  /**
   * Shows the given list of content proposals in the proposal popup
   *
   * @param newProposals list of new content proposals to be displayed
   */
  private void showProposals(final List<IContentProposal> newProposals) {
    queryResults.clear();
    queryResults.addAll(newProposals);

    final IContentProposal[] proposals = newProposals.toArray(new IContentProposal[newProposals
        .size()]);

    final PopupDialog popup = getProposalsPopup();
    if (popup != null) {
      if (proposals.length == 0) {
        popup.close();
      } else {
        Reflection.forObject(popup)
            .invoke("setProposals", new Class[] { IContentProposal[].class }, new Object[] {
                proposals });
        try {
          resizePopupDeferred(popup);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
