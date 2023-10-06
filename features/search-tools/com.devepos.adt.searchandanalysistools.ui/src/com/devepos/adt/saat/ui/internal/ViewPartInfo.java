package com.devepos.adt.saat.ui.internal;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Composite that can be used to display some information about e.g. Views
 *
 * @author stockbal
 */
public abstract class ViewPartInfo extends ScrolledComposite {
  private static final String HELP_LINK = "showHelp"; //$NON-NLS-1$
  protected static final int BINDING_TEXT_LEFT_MARGIN = 10;
  protected static final int BULLET_LINE_INDENT = 10;
  private FormToolkit toolkit;
  private FormText partInfoText;

  /**
   * Creates new info text composite with the given title
   *
   * @param parent the parent composite
   */
  public ViewPartInfo(final Composite parent) {
    super(parent, SWT.V_SCROLL);
    /*
     * hack to fix background problem of StyledText in Dark mode (see
     * com.sap.adt.util.ui.controls.AdtViewTextPage)
     */
    // setData("org.eclipse.e4.ui.css.id", "AdtViewTextPage");
    init();
    createInformationText();
  }

  @Override
  public boolean setFocus() {
    return partInfoText.forceFocus();
  }

  protected void createInformationText() {
    toolkit = new FormToolkit(Display.getDefault());
    toolkit.adapt(this);

    setLayout(new GridLayout(1, true));
    GridDataFactory.fillDefaults().grab(true, true).applyTo(this);

    var content = toolkit.createComposite(this, SWT.NONE);
    content.setLayout(new GridLayout(1, true));
    GridDataFactory.fillDefaults().grab(true, true).applyTo(content);

    partInfoText = toolkit.createFormText(content, true);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(partInfoText);

    createContent();
    setAdditionalInfo();
    setExpandHorizontal(true);
    setExpandVertical(true);
    setMinSize(50, 50);
    setContent(content);
    addControlListener(new ControlAdapter() {
      @Override
      public void controlResized(final ControlEvent e) {
        final var area = ViewPartInfo.this.getClientArea();
        ViewPartInfo.this.setMinSize(content.computeSize(area.width, -1));
      }
    });
  }

  protected abstract String getAdditionalText();

  /**
   * The help context id to be used during calling the help. If it is not supplied
   * the workbench will call the help dynamically from the current UI context
   *
   * @return the help context id or <code>null</code>
   */
  protected String getHelpContextId() {
    return null;
  }

  /**
   * The text to be used for the help link. <br>
   * <strong>Note</strong>: Subclasses must override if a help link is to be shown
   *
   * @return the text for the help link or <code>null</code> if no help link
   *         should be shown
   */
  protected String getHelpLinkText() {
    return null;
  }

  protected abstract String getTitle();

  /**
   * Some initialization before the information content is created. <br>
   * Subclasses may override
   */
  protected void init() {
  }

  /**
   * Sets additional info for the part info
   * Subclass may override
   */
  protected void setAdditionalInfo() {
  }

  /**
   * Sets image for an {@code img} tag
   *
   * @param hrefId href of the {@code img} tag
   * @param image  the image to set
   */
  protected void setImage(final String hrefId, final Image image) {
    partInfoText.setImage(hrefId, image);
  }

  protected void addHyperlinkListener(final IHyperlinkListener l) {
    partInfoText.addHyperlinkListener(l);
  }

  /*
   * Adds help link
   */
  private void addHelpLink(final StringBuffer body) {
    final String helpLinkText = getHelpLinkText();
    if (helpLinkText == null) {
      return;
    }
    body.append(String.format("<p><a href=\"%s\">%s %s</a></p>", ViewPartInfo.HELP_LINK, //$NON-NLS-1$
        "Learn more about", helpLinkText));
  }

  /**
   * Subclasses must override to create the actual content.
   */
  private void createContent() {
    var body = new StringBuffer();

    body.append("<form>");//$NON-NLS-1$
    body.append("<p><b>");//$NON-NLS-1$
    body.append(getTitle());
    body.append("</b></p>");//$NON-NLS-1$
    body.append(getAdditionalText());

    addHelpLink(body);

    body.append("</form>"); //$NON-NLS-1$

    partInfoText.setText(body.toString(), true, false);

    partInfoText.addHyperlinkListener(IHyperlinkListener.linkActivatedAdapter(t -> {
      if (t.getHref().equals(HELP_LINK)) {
        displayHelp();
      }
    }));
  }

  private void displayDynamicHelp() {
    PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
  }

  private void displayHelp() {
    final String helpContextId = getHelpContextId();
    if (helpContextId == null) {
      displayDynamicHelp();
    } else {
      this.displayHelp(helpContextId);
    }
  }

  private void displayHelp(final String helpContextId) {
    PlatformUI.getWorkbench().getHelpSystem().displayHelp(helpContextId);
  }
}
