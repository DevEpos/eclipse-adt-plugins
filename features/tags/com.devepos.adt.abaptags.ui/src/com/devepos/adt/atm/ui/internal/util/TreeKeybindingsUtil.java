package com.devepos.adt.atm.ui.internal.util;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class TreeKeybindingsUtil {

  public static void registerDefaultKeybindings(TreeViewer viewer) {
    viewer.getTree().addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {
        if (e.keyCode == SWT.ARROW_RIGHT && e.stateMask == SWT.CTRL) {
          viewer.expandAll();
        } else if (e.keyCode == SWT.ARROW_LEFT && e.stateMask == SWT.CTRL) {
          viewer.collapseAll();
        }
      }
    });
  }
}
