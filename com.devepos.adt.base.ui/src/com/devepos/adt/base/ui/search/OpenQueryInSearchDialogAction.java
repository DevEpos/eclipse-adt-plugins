package com.devepos.adt.base.ui.search;

import org.eclipse.jface.action.Action;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.util.StringUtil;

/**
 * Action for opening an {@link ISearchPage} in the eclipse search dialog. <br/>
 * After the page is opened it is filled with the values of the current
 * {@link ISearchQuery}
 *
 * @author stockbal
 *
 */
public class OpenQueryInSearchDialogAction extends Action implements ISearchPageListener {

    private ISearchResultPageExtension<?> resultPageExt;
    private String pageId;

    public OpenQueryInSearchDialogAction(final String pageId) {
        super(Messages.Actions_OpenQueryInSearchDialog_xmit, AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.SEARCH));
        this.pageId = pageId;
    }

    @Override
    public void run() {
        if (StringUtil.isEmpty(pageId)) {
            return;
        }
        ISearchResultViewPart resultViewPart = NewSearchUI.getSearchResultView();
        if (resultViewPart == null) {
            return;
        }
        if (!(resultViewPart.getActivePage() instanceof ISearchResultPageExtension<?>)) {
            return;
        }
        resultPageExt = (ISearchResultPageExtension<?>) resultViewPart.getActivePage();
        final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        SearchPageUtil.addSearchPageOpenListener(this);
        NewSearchUI.openSearchDialog(window, pageId);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void pageOpened(final ISearchPage searchPage) {
        if (searchPage instanceof IChangeableSearchPage) {
            ((IChangeableSearchPage) searchPage).setInputFromSearchQuery(resultPageExt.getSearchQuery());
        }
    }
}
