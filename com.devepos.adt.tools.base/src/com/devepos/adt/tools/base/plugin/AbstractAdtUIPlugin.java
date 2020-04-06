package com.devepos.adt.tools.base.plugin;

import java.net.URL;
import java.util.stream.Stream;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

/**
 * Abstract UI Plugin for ADT contributing plugins
 *
 * @author stockbal
 */
public abstract class AbstractAdtUIPlugin extends AbstractUIPlugin {
	private final String pluginId;

	/**
	 * Creates new wrapper around the given image registry
	 *
	 * @param registry existing image registry
	 * @param pluginId id of the plugin where the image registry exists
	 */
	protected AbstractAdtUIPlugin(final String pluginId) {
		this.pluginId = pluginId;
	}

	/**
	 * Retrieves the dialog settings for the given name
	 *
	 * @param  name the name of the dialog settings to retrieve
	 * @return      the found dialog settings
	 */
	public IDialogSettings getDialogSettingsSection(final String name) {
		final IDialogSettings dialogSettings = getDialogSettings();
		IDialogSettings section = dialogSettings.getSection(name);
		if (section == null) {
			section = dialogSettings.addNewSection(name);
		}
		return section;
	}

	/**
	 * Gets the image descriptor for the given key from the image registry
	 *
	 * @param  key the identifier of the image to get
	 * @return     the found image descriptor or <code>null</code>
	 */
	public ImageDescriptor getImageDescriptor(final String key) {
		return getImageDescriptor(key, false);
	}

	/**
	 * Gets the image descriptor for the given key from the image registry
	 *
	 * @param  key          the identifier of the image to get
	 * @param  useGrayScale if <code>true</code> a grayscale version of the image is
	 *                      returned
	 * @return              the found image descriptor or <code>null</code>
	 */
	public ImageDescriptor getImageDescriptor(final String key, final boolean useGrayScale) {
		String fullImageKey = key;
		if (useGrayScale) {
			fullImageKey += "_GrayScale"; //$NON-NLS-1$
		}
		ImageDescriptor descr = getImageRegistry().getDescriptor(fullImageKey);
		if (useGrayScale && descr == null) {
			descr = getImageRegistry().getDescriptor(key);
			descr = registerGrayScaleImageDescr(fullImageKey, descr);
		}
		return descr;
	}

	/**
	 * Gets the image for the given key from the image registry
	 *
	 * @param  key          the identifier of the image to get
	 * @param  useGrayScale if <code>true</code> a grayscale version of the image is
	 *                      returned
	 * @return              the found image descriptor or <code>null</code>
	 */
	public Image getImage(final String key, final boolean useGrayScale) {
		String fullImageKey = key;
		if (useGrayScale) {
			fullImageKey += "_GrayScale"; //$NON-NLS-1$
		}
		final ImageRegistry registry = getImageRegistry();
		final Image image = registry.get(fullImageKey);
		if (image == null) {
			final ImageDescriptor imgDescrOriginal = registry.getDescriptor(key);
			registerGrayScaleImageDescr(fullImageKey, imgDescrOriginal);
		}
		return registry.get(fullImageKey);
	}

	/**
	 * Retrieves Image from registry
	 *
	 * @param  key the identifier of the image to retrieve
	 * @return     the found image
	 */
	public Image getImage(final String key) {
		return getImageRegistry().get(key);
	}

	/**
	 * Returns a decorated {@link Image} with the <code>image</code> as the source
	 * image, the <code>decoratorKey</code> as the key for the overlay image and the
	 * <code>decorationPosition</code> as the
	 *
	 * @param  image              the image to be decorated
	 * @param  overlayImageKey    the id for the overlay image
	 * @param  decorationPosition the position where the overlay image should be
	 *                            placed
	 * @return
	 */
	public Image overlayImage(final Image image, final String[] overlayImageIds) {
		if (overlayImageIds == null || overlayImageIds.length > IDecoration.UNDERLAY) {
			return image;
		}
		if (!Stream.of(overlayImageIds).anyMatch(id -> id != null)) {
			return image;
		}
		final StringBuffer overlayImageKeyBuffer = new StringBuffer(image.toString());
		for (int i = 0; i < overlayImageIds.length; i++) {
			final String imageId = overlayImageIds[i];
			if (imageId == null) {
				continue;
			}
			overlayImageKeyBuffer.append(String.valueOf(i)).append("_").append(imageId);
		}
		final String overlayImageKey = overlayImageKeyBuffer.toString();

		Image decoratedImage = getImageRegistry().get(overlayImageKey.toString());
		if (decoratedImage == null) {
			final ImageDescriptor[] overlays = new ImageDescriptor[overlayImageIds.length];
			for (int i = 0; i < overlays.length; i++) {
				final String imageId = overlayImageIds[i];
				if (imageId != null) {
					overlays[i] = getImageDescriptor(imageId);
				} else {
					overlays[i] = null;
				}
			}
			final DecorationOverlayIcon doi = new DecorationOverlayIcon(image, overlays); // , new Point(18, 16));
			decoratedImage = doi.createImage();
			getImageRegistry().put(overlayImageKey, decoratedImage);
		}
		return decoratedImage;
	}

	/**
	 * Returns a decorated {@link Image} with the <code>image</code> as the source
	 * image, the <code>decoratorKey</code> as the key for the overlay image and the
	 * <code>decorationPosition</code> as the
	 *
	 * @param  image           the image to be decorated with overlays
	 * @param  overlayImageIds an array of exactly 5 id of Images
	 * @see                    IImages
	 * @return
	 */
	public Image overlayImage(final Image image, final String overlayImageKey, final int decorationPosition) {
		if (overlayImageKey == null) {
			return image;
		}
		final String decoratedImageKey = String.valueOf(image.toString()) + overlayImageKey;
		Image decoratedImage = getImageRegistry().get(decoratedImageKey);
		if (decoratedImage == null) {
			final ImageDescriptor[] overlays = new ImageDescriptor[4];
			final ImageDescriptor overlay = getImageDescriptor(overlayImageKey);
			if (overlay == null) {
				return image;
			}
			switch (decorationPosition) {
			case IDecoration.TOP_LEFT:
				overlays[0] = overlay;
				break;
			case IDecoration.TOP_RIGHT:
				overlays[1] = overlay;
				break;
			case IDecoration.BOTTOM_LEFT:
				overlays[2] = overlay;
				break;
			case IDecoration.BOTTOM_RIGHT:
				overlays[3] = overlay;
				break;
			}
			final DecorationOverlayIcon doi = new DecorationOverlayIcon(image, overlays, new Point(21, 16));
			decoratedImage = doi.createImage();
			getImageRegistry().put(decoratedImageKey, decoratedImage);
		}
		return decoratedImage;
	}

	/**
	 * Registers an image with the given id
	 *
	 * @param registry image registry
	 * @param imageId  id of an image in the current plugin
	 * @param fileName name of the image file to be registered
	 */
	protected void registerImage(final ImageRegistry registry, final String imageId, final String fileName,
		final String pluginId) {
		final Bundle bundle = Platform.getBundle(pluginId);
		if (bundle == null) {
			return;
		}
		final IPath path = new Path(fileName);
		final URL url = FileLocator.find(bundle, path, null);
		if (url == null) {
			return;
		}
		final ImageDescriptor desc = ImageDescriptor.createFromURL(url);

		if (registry.get(imageId) != null) {
			throw new IllegalStateException("duplicate imageId in image registry.");
		}
		registry.put(imageId, desc);
	}

	/**
	 * Registers an image with the given id
	 *
	 * @param registry image registry
	 * @param imageId  id of an image in the given bundle
	 * @param fileName name of the image file
	 * @param pluginId id of a bundle where the image exists
	 */
	protected void registerImage(final ImageRegistry registry, final String imageId, final String fileName) {
		registerImage(registry, imageId, fileName, this.pluginId);
	}

	/**
	 * Registers the given image descriptor with a gray scale filter under the given
	 * image key in the image registry
	 *
	 * @param  fullImageKey full key of the image
	 * @param  descr        the image descriptor to be registered
	 * @return              the image descriptor of the registered gray scale image
	 */
	protected ImageDescriptor registerGrayScaleImageDescr(final String fullImageKey, final ImageDescriptor descr) {
		if (descr == null) {
			return null;
		}
		final ImageDescriptor grayScaled = ImageDescriptor.createWithFlags(descr, SWT.IMAGE_GRAY);
		if (grayScaled != null) {
			getImageRegistry().put(fullImageKey, grayScaled);
			return grayScaled;
		}
		return null;
	}
}
