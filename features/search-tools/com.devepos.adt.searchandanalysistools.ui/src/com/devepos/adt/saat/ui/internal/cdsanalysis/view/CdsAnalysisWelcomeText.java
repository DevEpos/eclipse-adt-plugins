package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.Arrays;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.handlers.IHandlerService;

import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.ViewPartInfo;
import com.devepos.adt.saat.ui.internal.handlers.RunCdsAnalysisHandler;
import com.devepos.adt.saat.ui.internal.help.HelpContextId;
import com.devepos.adt.saat.ui.internal.help.HelpUtil;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * Info text for CDS Analysis View
 *
 * @author stockbal
 */
public class CdsAnalysisWelcomeText extends ViewPartInfo {
  private static final String RUN_NEW_ANALYSIS_HREF = "RUN_ANALYSIS"; //$NON-NLS-1$

  public CdsAnalysisWelcomeText(final Composite parent) {
    super(parent);
  }

  @Override
  protected String getAdditionalText() {
    var additional = new StringBuffer();

    addRunAnalysisActionLink(Messages.CdsAnalysisWelcome_Option1_xmsg, additional);
    addRunAnalysisActionLink(Messages.CdsAnalysisWelcome_Option2_xmsg, additional);

    for (var option : Arrays.asList(Messages.CdsAnalysisWelcome_Option3_xmsg,
        Messages.CdsAnalysisWelcome_Option4_xmsg, Messages.CdsAnalysisWelcome_Option5_xmsg)) {
      additional.append("<li>"); //$NON-NLS-1$
      additional.append(option);
      additional.append("</li>"); //$NON-NLS-1$
    }
    return additional.toString();
  }

  @Override
  protected String getHelpContextId() {
    return HelpUtil.getFullyQualifiedContextId(HelpContextId.CDS_ANALYZER);
  }

  @Override
  protected String getHelpLinkText() {
    return Messages.CdsAnalysisWelcome_HelpSuffix_xlnk;
  }

  @Override
  protected String getTitle() {
    return Messages.CdsAnalysis_NoOpenCdsAnalysis_xmsg;
  }

  @Override
  protected void setAdditionalInfo() {
    setImage(RUN_NEW_ANALYSIS_HREF,
        SearchAndAnalysisPlugin.getDefault().getImage(IImages.RUN_NEW_ANALYSIS));
    addHyperlinkListener(IHyperlinkListener.linkActivatedAdapter(t -> {
      if (t.getHref().equals(RUN_NEW_ANALYSIS_HREF)) {
        IEvaluationContext context = PlatformUI.getWorkbench()
            .<IHandlerService>getService(IHandlerService.class)
            .getCurrentState();
        try {
          new RunCdsAnalysisHandler()
              .execute(new ExecutionEvent(null, Collections.emptyMap(), null, context));
        } catch (ExecutionException x) {
          x.printStackTrace();
        }
      }
    }));
  }

  private void addRunAnalysisActionLink(final String textBeforeActionLink,
      final StringBuffer buffer) {
    buffer.append(String.format("<li>%s <img align=\"middle\" href=\"%s\"/> <a href=\"%s\">", //$NON-NLS-1$
        textBeforeActionLink, RUN_NEW_ANALYSIS_HREF, RUN_NEW_ANALYSIS_HREF));
    buffer.append(Messages.CdsAnalysisWelcomeText_runNewCdsAnalysisCommand_xlbl);
    buffer.append("</a></li>"); //$NON-NLS-1$
  }
}
