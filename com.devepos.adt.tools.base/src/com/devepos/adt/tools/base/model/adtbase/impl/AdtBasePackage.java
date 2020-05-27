/**
 */
package com.devepos.adt.tools.base.model.adtbase.impl;

import com.devepos.adt.tools.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.tools.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AdtBasePackage extends EPackageImpl implements IAdtBasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adtObjRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adtObjRefListEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.devepos.adt.tools.base.model.adtbase.IAdtBasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AdtBasePackage() {
		super(eNS_URI, IAdtBaseFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link IAdtBasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IAdtBasePackage init() {
		if (isInited) return (IAdtBasePackage)EPackage.Registry.INSTANCE.getEPackage(IAdtBasePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAdtBasePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AdtBasePackage theAdtBasePackage = registeredAdtBasePackage instanceof AdtBasePackage ? (AdtBasePackage)registeredAdtBasePackage : new AdtBasePackage();

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAdtBasePackage.createPackageContents();

		// Initialize created meta-data
		theAdtBasePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAdtBasePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IAdtBasePackage.eNS_URI, theAdtBasePackage);
		return theAdtBasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAdtObjRef() {
		return adtObjRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjRef_Description() {
		return (EAttribute)adtObjRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjRef_Name() {
		return (EAttribute)adtObjRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjRef_PackageName() {
		return (EAttribute)adtObjRefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjRef_Type() {
		return (EAttribute)adtObjRefEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjRef_Uri() {
		return (EAttribute)adtObjRefEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjRef_Owner() {
		return (EAttribute)adtObjRefEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjRef_TadirType() {
		return (EAttribute)adtObjRefEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAdtObjRefList() {
		return adtObjRefListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAdtObjRefList_ObjectReferences() {
		return (EReference)adtObjRefListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAdtBaseFactory getAdtBaseFactory() {
		return (IAdtBaseFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		adtObjRefEClass = createEClass(ADT_OBJ_REF);
		createEAttribute(adtObjRefEClass, ADT_OBJ_REF__DESCRIPTION);
		createEAttribute(adtObjRefEClass, ADT_OBJ_REF__NAME);
		createEAttribute(adtObjRefEClass, ADT_OBJ_REF__PACKAGE_NAME);
		createEAttribute(adtObjRefEClass, ADT_OBJ_REF__TYPE);
		createEAttribute(adtObjRefEClass, ADT_OBJ_REF__URI);
		createEAttribute(adtObjRefEClass, ADT_OBJ_REF__OWNER);
		createEAttribute(adtObjRefEClass, ADT_OBJ_REF__TADIR_TYPE);

		adtObjRefListEClass = createEClass(ADT_OBJ_REF_LIST);
		createEReference(adtObjRefListEClass, ADT_OBJ_REF_LIST__OBJECT_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(adtObjRefEClass, IAdtObjRef.class, "AdtObjRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdtObjRef_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdtObjRef_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdtObjRef_PackageName(), theXMLTypePackage.getString(), "packageName", null, 0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdtObjRef_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdtObjRef_Uri(), theXMLTypePackage.getAnyURI(), "uri", null, 0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdtObjRef_Owner(), theXMLTypePackage.getString(), "owner", null, 0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdtObjRef_TadirType(), theXMLTypePackage.getString(), "tadirType", null, 0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adtObjRefListEClass, IAdtObjRefList.class, "AdtObjRefList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdtObjRefList_ObjectReferences(), this.getAdtObjRef(), null, "objectReferences", null, 1, -1, IAdtObjRefList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (adtObjRefEClass,
		   source,
		   new String[] {
			   "name", "adtObjRef",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getAdtObjRef_Description(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "description",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAdtObjRef_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAdtObjRef_PackageName(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "packageName",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAdtObjRef_Type(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "type",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAdtObjRef_Uri(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "uri",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAdtObjRef_Owner(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "owner",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAdtObjRef_TadirType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "tadirType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (adtObjRefListEClass,
		   source,
		   new String[] {
			   "name", "adtObjRefs",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getAdtObjRefList_ObjectReferences(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "adtObjRef",
			   "namespace", "##targetNamespace"
		   });
	}

} //AdtBasePackage
