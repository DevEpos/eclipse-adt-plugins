package com.devepos.adt.abaptags.internal.tagging.service;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.tools.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for {@link ITagPreviewInfo}
 *
 * @author stockbal
 */
public class TagPreviewInfoContentHandler extends AbstractEmfContentHandler<ITagPreviewInfo> {

	public TagPreviewInfoContentHandler() {
		super(AdtMediaType.APPLICATION_XML, ".abaptagprevinfo");
	}

	@Override
	public Class<ITagPreviewInfo> getSupportedDataType() {
		return ITagPreviewInfo.class;
	}

	@Override
	protected Resource createResource() {
		return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
	}

	@Override
	protected ITagPreviewInfo getRootElement(final EObject rootElement) {
		return (ITagPreviewInfo) rootElement;
	}

}
