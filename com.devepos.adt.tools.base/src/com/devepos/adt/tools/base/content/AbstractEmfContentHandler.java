package com.devepos.adt.tools.base.content;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.xml.sax.SAXParseException;

import com.sap.adt.communication.content.ContentHandlerException;
import com.sap.adt.communication.content.IContentHandler;
import com.sap.adt.communication.message.AbstractMessageBody;
import com.sap.adt.communication.message.IMessageBody;
import com.sap.adt.communication.util.FileUtils;

/**
 * Abstract Content Handler which can be used to serialize/deserialize Resources
 * generated from an EMF Model
 *
 * @author     stockbal
 * @param  <T>
 */
public abstract class AbstractEmfContentHandler<T extends EObject> implements IContentHandler<T> {
	private static final String SAVING_ERROR = "Error during saving the object"; //$NON-NLS-1$
	private static final String LOADING_ERROR = "Error during loading the object"; //$NON-NLS-1$
	private static final String INVALID_XML_CONTENT = "Invalid XML content - root model entity not found"; //$NON-NLS-1$
	private final String contentType;
	private final String fileExtension;

	public AbstractEmfContentHandler(final String contentType, final String fileExtension) {
		this.contentType = contentType;
		this.fileExtension = fileExtension;
	}

	@Override
	public IMessageBody serialize(final T dataObject, final Charset charset) {
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(4096);
		try {
			Resource resource = createResource();
			if (((EObject) dataObject).eContainer() == null) {
				final Resource tempResource = ((EObject) dataObject).eResource();
				if (tempResource == null) {
					resource.getContents().add(dataObject);
				} else {
					resource = tempResource;
				}
			} else {
				final EObject documentRoot = ((EObject) dataObject).eContainer();
				resource.getContents().add(documentRoot);
			}
//			if (resource == null) {
//				throw new IllegalArgumentException("DocumentRoot object not found"); //$NON-NLS-1$
//			}
			resource.save(outputStream, null);
		} catch (final IOException e) {
			throw new ContentHandlerException(SAVING_ERROR, e);
		}
		return new MessageBody(outputStream, this.contentType);
	}

	@Override
	public T deserialize(final IMessageBody body, final Class<? extends T> dataType) {
		try {
			final InputStream content = getInputStream(body);
			final Resource resource = createResource();
			resource.load(content, null);
			return loadEmf(resource);
		} catch (final Resource.IOWrappedException e) {
			final Throwable cause = e.getCause();
			if (cause instanceof SAXParseException) {
				try {
					final Resource resource = createResource();
					final String escaped = FileUtils.escapeSpecialChars(FileUtils.toString(getInputStream(body)));
					resource.load(new ByteArrayInputStream(escaped.getBytes("UTF-8")), null);
					return loadEmf(resource);
				} catch (final IOException e1) {
					throw new ContentHandlerException(LOADING_ERROR, e1);
				}
			}
			throw new ContentHandlerException(LOADING_ERROR, e);
		} catch (final IOException e) {
			throw new ContentHandlerException(LOADING_ERROR, e);
		}
	}

	/**
	 * Retrieves the input stream from the given message body
	 *
	 * @param  body        the message body from the client response
	 * @return
	 * @throws IOException
	 */
	protected InputStream getInputStream(final IMessageBody body) throws IOException {
		return body.getContent();
	}

	@Override
	public String getSupportedContentType() {
		return this.contentType;
	}

	/**
	 * Loads EMF object from the given resource
	 *
	 * @param  resource resource with EMF content
	 * @return
	 */
	public T loadEmf(final Resource resource) {
		final EList<EObject> contents = resource.getContents();
		final EObject eObject = contents.get(0);
		if (eObject != null) {
			return getRootElement(eObject);
		}
		throw new IllegalArgumentException(INVALID_XML_CONTENT);
	}

	/**
	 * Creates resource to hold EMF content
	 *
	 * @return
	 */
	protected abstract Resource createResource();

	/**
	 * Retrieves the root element from the given {@link EObject}
	 *
	 * @param  rootElement root element returned from the deserialized emf resource
	 * @return
	 */
	protected abstract T getRootElement(EObject rootElement);

	/**
	 * Retrieves the virtual resource uri
	 *
	 * @return
	 */
	protected URI getVirtualResourceUri() {
		return URI.createURI("resource." + this.fileExtension);
	}

	private static class MessageBody extends AbstractMessageBody {
		ByteArrayInputStream stream = null;

		protected MessageBody(final ByteArrayOutputStream outputStream, final String contentType) {
			super(contentType);
			this.stream = new ByteArrayInputStream(outputStream.toByteArray(), 0, outputStream.size());
		}

		@Override
		public InputStream getContent() throws IOException {
			return this.stream;
		}
	}
}