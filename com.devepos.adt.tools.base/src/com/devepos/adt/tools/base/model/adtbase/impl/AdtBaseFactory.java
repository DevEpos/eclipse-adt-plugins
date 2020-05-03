/**
 */
package com.devepos.adt.tools.base.model.adtbase.impl;

import com.devepos.adt.tools.base.model.adtbase.*;

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
public class AdtBaseFactory extends EFactoryImpl implements IAdtBaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IAdtBaseFactory init() {
		try {
			IAdtBaseFactory theAdtBaseFactory = (IAdtBaseFactory)EPackage.Registry.INSTANCE.getEFactory(IAdtBasePackage.eNS_URI);
			if (theAdtBaseFactory != null) {
				return theAdtBaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AdtBaseFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdtBaseFactory() {
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
			case IAdtBasePackage.ADT_OBJ_REF: return createAdtObjRef();
			case IAdtBasePackage.ADT_OBJ_REF_LIST: return createAdtObjRefList();
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
	public IAdtObjRef createAdtObjRef() {
		AdtObjRef adtObjRef = new AdtObjRef();
		return adtObjRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAdtObjRefList createAdtObjRefList() {
		AdtObjRefList adtObjRefList = new AdtObjRefList();
		return adtObjRefList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAdtBasePackage getAdtBasePackage() {
		return (IAdtBasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IAdtBasePackage getPackage() {
		return IAdtBasePackage.eINSTANCE;
	}

} //AdtBaseFactory
