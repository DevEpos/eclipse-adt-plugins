/**
 */
package com.devepos.adt.base.model.adtbase;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Adt Obj
 * Ref</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 *
 * Base class for ADT object references. It
 * encapsulates the data that
 * clients may want to access
 * without loading
 * the actual resource - e.g.
 * in order to display the name and
 * an icon.
 *
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getAlternativeName <em>Alternative
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getPackageName <em>Package
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getTadirType <em>Tadir Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getUri <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getParentUri <em>Parent Uri</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getParentName <em>Parent Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getOwner <em>Owner</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getCreatedOn <em>Created On</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getChangedBy <em>Changed By</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getChangedOn <em>Changed On</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef()
 * @model extendedMetaData="name='adtObjRef' kind='elementOnly'"
 * @generated
 */
public interface IAdtObjRef extends EObject {
  /**
   * Returns the value of the '<em><b>Alternative Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Alternative Name</em>' attribute.
   * @see #setAlternativeName(String)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_AlternativeName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='alternativeName' namespace='##targetNamespace'"
   * @generated
   */
  String getAlternativeName();

  /**
   * Returns the value of the '<em><b>Changed By</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Changed By</em>' attribute.
   * @see #setChangedBy(String)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_ChangedBy()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='changedBy' namespace='##targetNamespace'"
   * @generated
   */
  String getChangedBy();

  /**
   * Returns the value of the '<em><b>Changed On</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Changed On</em>' attribute.
   * @see #setChangedOn(XMLGregorianCalendar)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_ChangedOn()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Date"
   *        extendedMetaData="kind='attribute' name='changedOn' namespace='##targetNamespace'"
   * @generated
   */
  XMLGregorianCalendar getChangedOn();

  /**
   * Returns the value of the '<em><b>Created On</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Created On</em>' attribute.
   * @see #setCreatedOn(XMLGregorianCalendar)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_CreatedOn()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Date"
   *        extendedMetaData="kind='attribute' name='createdOn' namespace='##targetNamespace'"
   * @generated
   */
  XMLGregorianCalendar getCreatedOn();

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Retrieves display name<br>
   *
   * Prio
   * <ol>
   * <li>Alternative Display Name</li>
   *
   * <li>Name</li>
   *
   * </ol>
   * <!-- end-model-doc -->
   *
   * @model kind="operation" dataType="org.eclipse.emf.ecore.xml.type.String"
   * @generated
   */
  String getDisplayName();

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
   * Returns the value of the '<em><b>Parent Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   *
   * The logical name of the corresponding development
   * object.
   *
   * <!-- end-model-doc -->
   *
   * @return the value of the '<em>Parent Name</em>' attribute.
   * @see #setParentName(String)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_ParentName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='parentName' namespace='##targetNamespace'"
   * @generated
   */
  String getParentName();

  /**
   * Returns the value of the '<em><b>Parent Uri</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The URI of
   * the parent ADT object. This attribute may be null at time. <!-- end-model-doc
   * -->
   *
   * @return the value of the '<em>Parent Uri</em>' attribute.
   * @see #setParentUri(String)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_ParentUri()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
   *        extendedMetaData="kind='attribute' name='parentUri'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getParentUri();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.String},
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Properties</em>' map.
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRef_Properties()
   * @model mapType="com.devepos.adt.base.model.adtbase.StringToStringMapEntry&lt;org.eclipse.emf.ecore.EString,
   *        org.eclipse.emf.ecore.EString&gt;"
   *        extendedMetaData="kind='element' namespace='##targetNamespace' name='property'"
   * @generated
   */
  EMap<String, String> getProperties();

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
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getAlternativeName
   * <em>Alternative Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Alternative Name</em>' attribute.
   * @see #getAlternativeName()
   * @generated
   */
  void setAlternativeName(String value);

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getChangedBy
   * <em>Changed By</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Changed By</em>' attribute.
   * @see #getChangedBy()
   * @generated
   */
  void setChangedBy(String value);

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getChangedOn
   * <em>Changed On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Changed On</em>' attribute.
   * @see #getChangedOn()
   * @generated
   */
  void setChangedOn(XMLGregorianCalendar value);

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getCreatedOn
   * <em>Created On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Created On</em>' attribute.
   * @see #getCreatedOn()
   * @generated
   */
  void setCreatedOn(XMLGregorianCalendar value);

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
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getName
   * <em>Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getOwner
   * <em>Owner</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Owner</em>' attribute.
   * @see #getOwner()
   * @generated
   */
  void setOwner(String value);

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
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getParentName
   * <em>Parent Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Name</em>' attribute.
   * @see #getParentName()
   * @generated
   */
  void setParentName(String value);

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getParentUri
   * <em>Parent Uri</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Uri</em>' attribute.
   * @see #getParentUri()
   * @generated
   */
  void setParentUri(String value);

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getTadirType
   * <em>Tadir Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Tadir Type</em>' attribute.
   * @see #getTadirType()
   * @generated
   */
  void setTadirType(String value);

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getType
   * <em>Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getUri
   * <em>Uri</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

} // IAdtObjRef
