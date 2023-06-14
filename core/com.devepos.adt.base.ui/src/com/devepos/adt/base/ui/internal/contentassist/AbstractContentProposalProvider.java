package com.devepos.adt.base.ui.internal.contentassist;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.bindings.TriggerSequence;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.keys.IBindingService;

import com.devepos.adt.base.ui.contentassist.IContentAssist;
import com.devepos.adt.base.ui.internal.messages.Messages;

/**
 * Abstract Content proposal provider implementation
 *
 * @author Ludwig Stockbauer-Muhr
 */
abstract class AbstractContentProposalProvider implements IContentProposalProvider, IContentAssist {
  private static final KeyStroke DEFAULT_ACTIVATION_KEYSTROKE = KeyStroke.getInstance(isMacOS()
      ? SWT.MOD4
      : SWT.MOD1, SWT.SPACE);
  private final KeyStroke triggeringKeyStroke;
  private final ContentProposalAdapter contentProposalAdapter;

  public AbstractContentProposalProvider(final Control control) {
    triggeringKeyStroke = calculateActivationKeyStroke();
    contentProposalAdapter = addToControl(control);
  }

  /**
   * Retrieve the keystroke for content assist activation
   *
   * @return
   */
  public static KeyStroke getActivationKeyStroke() {
    return calculateActivationKeyStroke();
  }

  public static String getContentAssistDescription(final KeyStroke keyStroke) {
    return NLS.bind(Messages.ContentProposalProvider_contentAssistTooltip_xtol, keyStroke.format());
  }

  /**
   * Calculates the default key stroke for content assist activation
   *
   * @return
   */
  private static KeyStroke calculateActivationKeyStroke() {
    final KeyStroke stroke = getActivationKeyStrokeFromPreferences();
    if (stroke != null) {
      return stroke;
    }
    return DEFAULT_ACTIVATION_KEYSTROKE;
  }

  /**
   * Retrieve and return activation key stroke for content assist from preferences
   *
   * @return
   */
  private static KeyStroke getActivationKeyStrokeFromPreferences() {
    try {
      if (Platform.isRunning()) {
        final IBindingService service = PlatformUI.getWorkbench().getService(IBindingService.class);
        if (service != null) {
          final TriggerSequence binding = service.getBestActiveBindingFor(
              "org.eclipse.ui.edit.text.contentAssist.proposals");
          if (binding instanceof KeySequence) {
            final KeyStroke[] keyStrokes = ((KeySequence) binding).getKeyStrokes();
            if (keyStrokes.length == 1) {
              return keyStrokes[0];
            }
          }
        }
      }
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static boolean isMacOS() {
    return Platform.isRunning() && Platform.getOS().equals("macosx");
  }

  @Override
  public void dispose() {
    final ILabelProvider labelProvider = contentProposalAdapter.getLabelProvider();
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

  /**
   * Set the integer style that indicates how an accepted proposal affects the
   * control's content.<br>
   * The default value is <code>PROPOSAL_REPLACE</code>.
   *
   * @param acceptance a constant indicating how an accepted proposal should
   *                   affect the control's content. Should be one of
   *                   <code>PROPOSAL_INSERT</code>,
   *                   <code>PROPOSAL_REPLACE</code>, or
   *                   <code>PROPOSAL_IGNORE</code>
   *
   * @see {@link ContentProposalAdapter#PROPOSAL_IGNORE}
   * @see {@link ContentProposalAdapter#PROPOSAL_REPLACE}
   * @see {@link ContentProposalAdapter#PROPOSAL_INSERT}
   */
  public void setProposalAcceptanceStyle(final int acceptance) {
    contentProposalAdapter.setProposalAcceptanceStyle(acceptance);
  }

  protected ContentProposalAdapter addToControl(final Control control) {
    if (!(control instanceof Text)) {
      throw new IllegalArgumentException("Can only attach to Text controls, not to " + control);
    }

    final ControlDecoration dec = new ControlDecoration(control, SWT.TOP | SWT.LEFT);

    final String text = getContentAssistDecoratorText(triggeringKeyStroke);
    dec.setDescriptionText(text);
    if (Platform.isRunning()) {
      dec.setImage(FieldDecorationRegistry.getDefault()
          .getFieldDecoration("DEC_CONTENT_PROPOSAL")
          .getImage());
    }
    dec.setShowOnlyOnFocus(true);
    dec.setShowHover(true);

    IControlContentAdapter contentAdapter = new TextContentAdapter();
    ContentProposalAdapter contentProposalAdapter = new ContentProposalAdapter(control,
        contentAdapter, this, triggeringKeyStroke, null);
    return contentProposalAdapter;
  }

  protected String getContentAssistDecoratorText(final KeyStroke keyStroke) {
    return getContentAssistDescription(keyStroke);
  }

  /**
   * Retrieve the content proposal adapter
   *
   * @return
   */
  protected ContentProposalAdapter getContentProposalAdapter() {
    return contentProposalAdapter;
  }
}
