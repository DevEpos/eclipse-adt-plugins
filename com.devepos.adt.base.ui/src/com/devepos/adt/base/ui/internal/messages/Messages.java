package com.devepos.adt.base.ui.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "com.devepos.adt.base.ui.internal.messages.messages"; //$NON-NLS-1$
    public static String ChooseOtherAdtObjectAction_ActionText_xtol;
    public static String CopyToClipboardAction_ErrorMessageTitle_xmsg;
    public static String CopyToClipboardAction_ErrorMessageBody_xmsg;
    public static String General_Copy_xtol;
    public static String Actions_OpenWithADTDataPreview_xmit;
    public static String Actions_OpenAdtObject_xmit;
    public static String Actions_OpenQueryInSearchDialog_xmit;
    public static String Actions_ExecuteAdtObject_xmit;
    public static String Actions_ExpandAll_xmit;
    public static String Actions_CollapseNode_xtol;
    public static String Actions_ToggleViewerTextFilter_xmit;
    public static String Actions_CollapseAllNodes_xmit;
    public static String LazyLoadingTreeContentProvider_LoadingChildNodes_xmsg;
    public static String LazyLoadingTreeContentProvider_LoadingContent_xmsg;
    public static String LazyLoadingTreeContentProvider_UpdatingTreeContent_xmsg;
    public static String Project_LogonToProjectFailed_xmsg;
    public static String ProjectInput_BrowseProjects_xbut;
    public static String ProjectInput_NoProjectEntered_xmsg;
    public static String ProjectInput_Project_xfld;
    public static String ProjectInput_ProjectDoesNotExist_xmsg;
    public static String SearchSelectionDialog_FilterLabel;
    public static String SearchSelectionDialog_ItemsSelected;
    public static String SearchSelectionDialog_ResultItemsLabel;
    public static String SplitResultSelectionViewer_AddItemButton;
    public static String SplitResultSelectionViewer_RemoveItemButton;
    public static String ToggleViewLayoutAction_AutomaticOrientation_xmit;
    public static String ToggleViewLayoutAction_HorizontalOrientation_xmit;
    public static String ToggleViewLayoutAction_TopLevelMenu_xmit;
    public static String ToggleViewLayoutAction_VerticalOrientation_xmit;
    public static String UserNameSelectionDialog_FilterLabel;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
