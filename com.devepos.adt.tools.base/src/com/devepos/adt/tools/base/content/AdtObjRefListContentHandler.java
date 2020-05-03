package com.devepos.adt.tools.base.content;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.tools.base.model.adtbase.util.AdtBaseResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for {@link IAdtObjRefList}
 *
 * @author stockbal
 */
public class AdtObjRefListContentHandler extends AbstractEmfContentHandler<IAdtObjRefList> {

	public AdtObjRefListContentHandler() {
		super(AdtMediaType.APPLICATION_XML, ".adtobjreflist");
	}

	@Override
	public Class<IAdtObjRefList> getSupportedDataType() {
		return IAdtObjRefList.class;
	}

	@Override
	protected Resource createResource() {
		return new AdtBaseResourceFactory().createResource(getVirtualResourceUri());
	}

	@Override
	protected IAdtObjRefList getRootElement(final EObject root) {
		return (IAdtObjRefList) root;
	}

}