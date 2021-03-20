/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBaseFactory
 * @model kind="package"
 * @generated
 */
public interface IAdtBasePackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "adtbase";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://www.devepos.com/adt/base";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "adtbase";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    IAdtBasePackage eINSTANCE = com.devepos.adt.base.model.adtbase.impl.AdtBasePackage.init();

    /**
     * The meta object id for the
     * '{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef <em>Adt Obj
     * Ref</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.AdtObjRef
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtObjRef()
     * @generated
     */
    int ADT_OBJ_REF = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF__DESCRIPTION = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF__NAME = 1;

    /**
     * The feature id for the '<em><b>Package Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF__PACKAGE_NAME = 2;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF__TYPE = 3;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF__URI = 4;

    /**
     * The feature id for the '<em><b>Owner</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF__OWNER = 5;

    /**
     * The feature id for the '<em><b>Tadir Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF__TADIR_TYPE = 6;

    /**
     * The number of structural features of the '<em>Adt Obj Ref</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Adt Obj Ref</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF_OPERATION_COUNT = 0;

    /**
     * The meta object id for the
     * '{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRefList <em>Adt Obj Ref
     * List</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.AdtObjRefList
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtObjRefList()
     * @generated
     */
    int ADT_OBJ_REF_LIST = 1;

    /**
     * The feature id for the '<em><b>Object References</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF_LIST__OBJECT_REFERENCES = 0;

    /**
     * The number of structural features of the '<em>Adt Obj Ref List</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF_LIST_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Adt Obj Ref List</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADT_OBJ_REF_LIST_OPERATION_COUNT = 0;

    /**
     * The meta object id for the
     * '{@link com.devepos.adt.base.model.adtbase.impl.User <em>User</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.User
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getUser()
     * @generated
     */
    int USER = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USER__NAME = 0;

    /**
     * The number of structural features of the '<em>User</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USER_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>User</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int USER_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef <em>Adt Obj Ref</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Adt Obj Ref</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRef
     * @generated
     */
    EClass getAdtObjRef();

    /**
     * Returns the meta object for the attribute
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getDescription
     * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getDescription()
     * @see #getAdtObjRef()
     * @generated
     */
    EAttribute getAdtObjRef_Description();

    /**
     * Returns the meta object for the attribute
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getName
     * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getName()
     * @see #getAdtObjRef()
     * @generated
     */
    EAttribute getAdtObjRef_Name();

    /**
     * Returns the meta object for the attribute
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getPackageName
     * <em>Package Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Package Name</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getPackageName()
     * @see #getAdtObjRef()
     * @generated
     */
    EAttribute getAdtObjRef_PackageName();

    /**
     * Returns the meta object for the attribute
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getType
     * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getType()
     * @see #getAdtObjRef()
     * @generated
     */
    EAttribute getAdtObjRef_Type();

    /**
     * Returns the meta object for the attribute
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getUri()
     * @see #getAdtObjRef()
     * @generated
     */
    EAttribute getAdtObjRef_Uri();

    /**
     * Returns the meta object for the attribute
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getOwner
     * <em>Owner</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Owner</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getOwner()
     * @see #getAdtObjRef()
     * @generated
     */
    EAttribute getAdtObjRef_Owner();

    /**
     * Returns the meta object for the attribute
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getTadirType <em>Tadir
     * Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Tadir Type</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getTadirType()
     * @see #getAdtObjRef()
     * @generated
     */
    EAttribute getAdtObjRef_TadirType();

    /**
     * Returns the meta object for class
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRefList <em>Adt Obj Ref
     * List</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Adt Obj Ref List</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRefList
     * @generated
     */
    EClass getAdtObjRefList();

    /**
     * Returns the meta object for the containment reference list
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRefList#getObjectReferences
     * <em>Object References</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Object
     *         References</em>'.
     * @see com.devepos.adt.base.model.adtbase.IAdtObjRefList#getObjectReferences()
     * @see #getAdtObjRefList()
     * @generated
     */
    EReference getAdtObjRefList_ObjectReferences();

    /**
     * Returns the meta object for class
     * '{@link com.devepos.adt.base.model.adtbase.IUser <em>User</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>User</em>'.
     * @see com.devepos.adt.base.model.adtbase.IUser
     * @generated
     */
    EClass getUser();

    /**
     * Returns the meta object for the attribute
     * '{@link com.devepos.adt.base.model.adtbase.IUser#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.devepos.adt.base.model.adtbase.IUser#getName()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_Name();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    IAdtBaseFactory getAdtBaseFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each operation of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     *
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the
         * '{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef <em>Adt Obj
         * Ref</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see com.devepos.adt.base.model.adtbase.impl.AdtObjRef
         * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtObjRef()
         * @generated
         */
        EClass ADT_OBJ_REF = eINSTANCE.getAdtObjRef();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ADT_OBJ_REF__DESCRIPTION = eINSTANCE.getAdtObjRef_Description();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ADT_OBJ_REF__NAME = eINSTANCE.getAdtObjRef_Name();

        /**
         * The meta object literal for the '<em><b>Package Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ADT_OBJ_REF__PACKAGE_NAME = eINSTANCE.getAdtObjRef_PackageName();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ADT_OBJ_REF__TYPE = eINSTANCE.getAdtObjRef_Type();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ADT_OBJ_REF__URI = eINSTANCE.getAdtObjRef_Uri();

        /**
         * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ADT_OBJ_REF__OWNER = eINSTANCE.getAdtObjRef_Owner();

        /**
         * The meta object literal for the '<em><b>Tadir Type</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ADT_OBJ_REF__TADIR_TYPE = eINSTANCE.getAdtObjRef_TadirType();

        /**
         * The meta object literal for the
         * '{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRefList <em>Adt Obj Ref
         * List</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see com.devepos.adt.base.model.adtbase.impl.AdtObjRefList
         * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtObjRefList()
         * @generated
         */
        EClass ADT_OBJ_REF_LIST = eINSTANCE.getAdtObjRefList();

        /**
         * The meta object literal for the '<em><b>Object References</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @generated
         */
        EReference ADT_OBJ_REF_LIST__OBJECT_REFERENCES = eINSTANCE.getAdtObjRefList_ObjectReferences();

        /**
         * The meta object literal for the
         * '{@link com.devepos.adt.base.model.adtbase.impl.User <em>User</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see com.devepos.adt.base.model.adtbase.impl.User
         * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getUser()
         * @generated
         */
        EClass USER = eINSTANCE.getUser();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute USER__NAME = eINSTANCE.getUser_Name();

    }

} // IAdtBasePackage
