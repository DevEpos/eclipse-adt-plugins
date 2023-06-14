package com.devepos.adt.base.ui;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;

/**
 * Access to resources of ADT Tools Base Plugin
 *
 * @author stockbal
 */
public class AdtBaseUIResources {

  /**
   * The JFace resource bundle; eagerly initialized.
   */
  private static final ResourceBundle bundle = ResourceBundle.getBundle(
      "com.devepos.adt.base.ui.messages"); //$NON-NLS-1$

  /**
   * Gets the image descriptor for the given key from the image registry
   *
   * @param key the identifier of the image to get
   * @return the found image descriptor or <code>null</code>
   */
  public static ImageDescriptor getImageDescriptor(final String key) {
    return AdtBaseUIPlugin.getDefault().getImageDescriptor(key);
  }

  /**
   * Gets the image descriptor for the given key from the image registry
   *
   * @param key          the identifier of the image to get
   * @param useGrayScale if <code>true</code> a grayscale version of the image is
   *                     returned
   * @return the found image descriptor or <code>null</code>
   */
  public static ImageDescriptor getImageDescriptor(final String key, final boolean useGrayScale) {
    return AdtBaseUIPlugin.getDefault().getImageDescriptor(key, useGrayScale);
  }

  /**
   * Gets the image for the given key from the image registry
   *
   * @param key          the identifier of the image to get
   * @param useGrayScale if <code>true</code> a grayscale version of the image is
   *                     returned
   * @return the found image descriptor or <code>null</code>
   */
  public static Image getImage(final String key, final boolean useGrayScale) {
    return AdtBaseUIPlugin.getDefault().getImage(key, useGrayScale);
  }

  /**
   * Retrieves Image from registry
   *
   * @param key the identifier of the image to retrieve
   * @return the found image
   */
  public static Image getImage(final String key) {
    return AdtBaseUIPlugin.getDefault().getImage(key);
  }

  /**
   * Returns the resource object with the given key in ADT Tools Base's resource
   * bundle. If there isn't any value under the given key, the key is returned.
   *
   * @param key the resource name
   * @return the string
   */
  public static String getString(final String key) {
    try {
      return bundle.getString(key);
    } catch (final MissingResourceException e) {
      return key;
    }
  }

  /**
   * Returns the formatted message for the given key in ADT Tools Base's resource
   * bundle.
   *
   * @param key  the resource name
   * @param args the message arguments
   * @return the string
   */
  public static String format(final String key, final Object... args) {
    return MessageFormat.format(getString(key), args);
  }
}
