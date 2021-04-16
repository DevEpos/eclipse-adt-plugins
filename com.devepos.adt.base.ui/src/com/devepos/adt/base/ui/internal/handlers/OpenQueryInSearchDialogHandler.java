package com.devepos.adt.base.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.ISearchPageListener;
import com.devepos.adt.base.ui.search.ISearchResultPageExtension;
import com.devepos.adt.base.ui.search.SearchPageUtil;

/**
 * Command handler for opening an {@link ISearchPage} in the eclipse search
 * dialog. <br/>
 * After the page is opened it is filled with the values of the current
 * {@link ISearchQuery}
 *
 * @author stockbal
 *
 */
public class OpenQueryInSearchDialogHandler extends AbstractHandler implements IHandler, ISearchPageListener {
    public static final String PAGE_ID_PARAM = "com.devepos.adt.base.ui.command.openQueryInSearchDialog.pageId"; //$NON-NLS-1$

    private ISearchResultPageExtension<?> resultPageExt;

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        ISearchResultViewPart resultViewPart = NewSearchUI.getSearchResultView();
        if (resultViewPart == null) {
            return null;
        }
        if (!(resultViewPart.getActivePage() instanceof ISearchResultPageExtension<?>)) {
            return null;
        }
        resultPageExt = (ISearchResultPageExtension<?>) resultViewPart.getActivePage();
        final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        SearchPageUtil.addSearchPageOpenListener(this);
        NewSearchUI.openSearchDialog(window, resultPageExt.getSearchPageId());

        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void pageOpened(final ISearchPage searchPage) {
        if (searchPage instanceof IChangeableSearchPage) {
            ((IChangeableSearchPage) searchPage).setInputFromSearchQuery(resultPageExt.getSearchQuery());
        }
    }

}
