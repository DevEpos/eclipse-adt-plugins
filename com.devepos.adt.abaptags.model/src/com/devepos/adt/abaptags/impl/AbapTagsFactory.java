/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbapTagsFactory extends EFactoryImpl implements IAbapTagsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IAbapTagsFactory init() {
		try {
			IAbapTagsFactory theAbapTagsFactory = (IAbapTagsFactory)EPackage.Registry.INSTANCE.getEFactory(IAbapTagsPackage.eNS_URI);
			if (theAbapTagsFactory != null) {
				return theAbapTagsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AbapTagsFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbapTagsFactory() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IAbapTagsPackage.TAG: return createTag();
			case IAbapTagsPackage.ADT_OBJECT_TAG: return createAdtObjectTag();
			case IAbapTagsPackage.TAG_LIST: return createTagList();
			case IAbapTagsPackage.TAG_PREVIEW_INFO: return createTagPreviewInfo();
			case IAbapTagsPackage.TAGGED_OBJECT: return createTaggedObject();
			case IAbapTagsPackage.TAGGED_OBJECT_LIST: return createTaggedObjectList();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ITag createTag() {
		Tag tag = new Tag();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAdtObjectTag createAdtObjectTag() {
		AdtObjectTag adtObjectTag = new AdtObjectTag();
		return adtObjectTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ITagList createTagList() {
		TagList tagList = new TagList();
		return tagList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ITagPreviewInfo createTagPreviewInfo() {
		TagPreviewInfo tagPreviewInfo = new TagPreviewInfo();
		return tagPreviewInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ITaggedObject createTaggedObject() {
		TaggedObject taggedObject = new TaggedObject();
		return taggedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ITaggedObjectList createTaggedObjectList() {
		TaggedObjectList taggedObjectList = new TaggedObjectList();
		return taggedObjectList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAbapTagsPackage getAbapTagsPackage() {
		return (IAbapTagsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IAbapTagsPackage getPackage() {
		return IAbapTagsPackage.eINSTANCE;
	}

} //AbapTagsFactory
