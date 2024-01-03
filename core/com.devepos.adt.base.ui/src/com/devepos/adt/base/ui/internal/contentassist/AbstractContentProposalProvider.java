package com.devepos.adt.base.ui.internal.contentassist;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.SWTKeySupport;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.contentassist.IContentAssist;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.util.SWTUtil;

/**
 * Abstract Content proposal provider implementation
 *
 * @author Ludwig Stockbauer-Muhr
 */
abstract class AbstractContentProposalProvider implements IContentProposalProvider, IContentAssist {
  private static final KeyStroke DEFAULT_ACTIVATION_KEYSTROKE = KeyStroke
      .getInstance(isMacOS() ? SWT.MOD4 : SWT.MOD1, SWT.SPACE);
  private final KeyStroke triggeringKeyStroke;
  private final ContentProposalAdapter contentProposalAdapter;

  public AbstractContentProposalProvider(final Control control) {
    triggeringKeyStroke = SWTUtil.getKeyStrokeForCommandId(
        "org.eclipse.ui.edit.text.contentAssist.proposals", //$NON-NLS-1$
        DEFAULT_ACTIVATION_KEYSTROKE);
    contentProposalAdapter = addToControl(control);
  }

  public static String getContentAssistDescription(final KeyStroke keyStroke) {
    return NLS.bind(Messages.ContentProposalProvider_contentAssistTooltip_xtol, keyStroke.format());
  }

  private static boolean isMacOS() {
    return Platform.isRunning() && Platform.getOS().equals("macosx"); //$NON-NLS-1$
  }

  @Override
  public void dispose() {
    final var labelProvider = contentProposalAdapter.getLabelProvider();
    if (labelProvider != null) {
      contentProposalAdapter.setLabelProvider(null);
      // labelProvider.dispose();
    }
  }

  /**
   * Set the array of characters that will trigger autoactivation of the popup.
   *
   * @param autoActivationCharacters An array of characters that trigger
   *                                 auto-activation of content proposal.
   *
   */
  public void setAutoActivationCharacters(final char[] autoActivationCharacters) {
    contentProposalAdapter.setAutoActivationCharacters(autoActivationCharacters);
  }

  /**
   * Set the delay, in milliseconds, used before autoactivation is triggered.
   *
   * @param delay the time in milliseconds that will pass before a popup is
   *              automatically opened
   */
  public void setAutoActivationDelay(final int delay) {
    contentProposalAdapter.setAutoActivationDelay(delay);
  }

  @Override
  public void setLabelProvider(final ILabelProvider labelProvider) {
    contentProposalAdapter.setLabelProvider(labelProvider);
  }

  @Override
  public void setProposalAcceptanceStyle(final int acceptance) {
    contentProposalAdapter.setProposalAcceptanceStyle(acceptance);
  }

  protected ContentProposalAdapter addToControl(final Control control) {
    if (!(control instanceof Text)) {
      throw new IllegalArgumentException("Can only attach to Text controls, not to " + control); //$NON-NLS-1$
    }

    final var dec = new ControlDecoration(control, SWT.TOP | SWT.LEFT);

    final String text = getContentAssistDecoratorText(triggeringKeyStroke);
    dec.setDescriptionText(text);
    if (Platform.isRunning()) {
      dec.setImage(FieldDecorationRegistry.getDefault()
          .getFieldDecoration("DEC_CONTENT_PROPOSAL") //$NON-NLS-1$
          .getImage());
    }
    dec.setShowOnlyOnFocus(true);
    dec.setShowHover(true);

    addFallbackContentAssistListener(control);

    return new ContentProposalAdapter(control, new TextContentAdapter(), this, triggeringKeyStroke,
        null);
  }

  protected String getContentAssistDecoratorText(final KeyStroke keyStroke) {
    return getContentAssistDescription(keyStroke);
  }

  /**
   * @return the keystroke that triggers the content assist
   */
  protected KeyStroke getActivationKeyStroke() {
    return triggeringKeyStroke;
  }

  /**
   * Retrieve the content proposal adapter
   *
   * @return
   */
  protected ContentProposalAdapter getContentProposalAdapter() {
    return contentProposalAdapter;
  }

  /*
   * There is a bug in Eclipse that does not react on content assist shortcuts that contain a
   * letter, so this additional key listener is added to open the proposal popup manually in such
   * situations
   */
  private void addFallbackContentAssistListener(final Control control) {
    if (triggeringKeyStroke.equals(DEFAULT_ACTIVATION_KEYSTROKE)) {
      return;
    }
    control.addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(final KeyEvent e) {
        var proposalAdapter = getContentProposalAdapter();
        if (SWTKeySupport.convertKeyStrokeToAccelerator(triggeringKeyStroke) == SWTKeySupport
            .convertEventToUnmodifiedAccelerator(e) && !proposalAdapter.isProposalPopupOpen()) {
          proposalAdapter.openProposalPopup();
          e.doit = false;
        }
      }
    });
  }
}
