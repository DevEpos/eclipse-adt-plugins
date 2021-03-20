/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Adt Obj
 * Ref</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 *
 * Base class for ADT object references. It encapsulates the data that clients
 * may want to access without loading the actual resource - e.g. in order to
 * display the name and an icon.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getPackageName
 * <em>Package Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getUri
 * <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getOwner
 * <em>Owner</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getTadirType
 * <em>Tadir Type</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef()
 * @model extendedMetaData="name='adtObjRef' kind='elementOnly'"
 * @generated
 */
public interface IAdtObjRef extends EObject {
    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * The language dependent description text.
     * 
     * <!-- end-model-doc -->
     *
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_Description()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='description'
     *        namespace='##targetNamespace'"
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getDescription
     * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * The logical name of the corresponding development object.
     * 
     * <!-- end-model-doc -->
     *
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'
     *        namespace='##targetNamespace'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Package Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * The unique package the object is contained in.
     * 
     * <!-- end-model-doc -->
     *
     * @return the value of the '<em>Package Name</em>' attribute.
     * @see #setPackageName(String)
     * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_PackageName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='packageName'
     *        namespace='##targetNamespace'"
     * @generated
     */
    String getPackageName();

    /**
     * Sets the value of the
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getPackageName
     * <em>Package Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value the new value of the '<em>Package Name</em>' attribute.
     * @see #getPackageName()
     * @generated
     */
    void setPackageName(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * The type of of the corresponding development object.
     * 
     * <!-- end-model-doc -->
     *
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_Type()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='type'
     *        namespace='##targetNamespace'"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getType <em>Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Uri</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * The ADT URI of the corresponding <em>AdtObject</em> instance. The value
     * represents a relative path to the resource containing the <em>AdtObject</em>
     * instance and has to be resolved based on the URI of the enclosing resource.
     * <p>
     * Note: Although the attribute has been defined as optional it is guaranteed
     * that it will always be set for data retrieved from the backend.
     * </p>
     * 
     * <!-- end-model-doc -->
     *
     * @return the value of the '<em>Uri</em>' attribute.
     * @see #setUri(String)
     * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_Uri()
     * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
     *        extendedMetaData="kind='attribute' name='uri'
     *        namespace='##targetNamespace'"
     * @generated
     */
    String getUri();

    /**
     * Sets the value of the
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getUri <em>Uri</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Uri</em>' attribute.
     * @see #getUri()
     * @generated
     */
    void setUri(String value);

    /**
     * Returns the value of the '<em><b>Owner</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * The logical name of the corresponding development object.
     * 
     * <!-- end-model-doc -->
     *
     * @return the value of the '<em>Owner</em>' attribute.
     * @see #setOwner(String)
     * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_Owner()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='owner'
     *        namespace='##targetNamespace'"
     * @generated
     */
    String getOwner();

    /**
     * Sets the value of the
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getOwner
     * <em>Owner</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Owner</em>' attribute.
     * @see #getOwner()
     * @generated
     */
    void setOwner(String value);

    /**
     * Returns the value of the '<em><b>Tadir Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * The TADIR type of of the corresponding development object.
     * 
     * <!-- end-model-doc -->
     *
     * @return the value of the '<em>Tadir Type</em>' attribute.
     * @see #setTadirType(String)
     * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_TadirType()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='tadirType'
     *        namespace='##targetNamespace'"
     * @generated
     */
    String getTadirType();

    /**
     * Sets the value of the
     * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getTadirType <em>Tadir
     * Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Tadir Type</em>' attribute.
     * @see #getTadirType()
     * @generated
     */
    void setTadirType(String value);

} // IAdtObjRef
