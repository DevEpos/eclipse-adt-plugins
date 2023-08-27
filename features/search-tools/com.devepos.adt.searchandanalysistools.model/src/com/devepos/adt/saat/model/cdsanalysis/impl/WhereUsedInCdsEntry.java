/**
 */
package com.devepos.adt.saat.model.cdsanalysis.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Where Used In Cds Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.WhereUsedInCdsEntry#getUri
 * <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.WhereUsedInCdsEntry#getEntityName
 * <em>Entity Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.WhereUsedInCdsEntry#getDdlname
 * <em>Ddlname</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.WhereUsedInCdsEntry#getSourceType
 * <em>Source Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.WhereUsedInCdsEntry#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.WhereUsedInCdsEntry#getApiState <em>Api
 * State</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.WhereUsedInCdsEntry#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.WhereUsedInCdsEntry#getChildren
 * <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhereUsedInCdsEntry extends MinimalEObjectImpl.Container implements
    IWhereUsedInCdsEntry {
  /**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final String URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected String uri = URI_EDEFAULT;

  /**
   * The default value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntityName()
   * @generated
   * @ordered
   */
  protected static final String ENTITY_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntityName()
   * @generated
   * @ordered
   */
  protected String entityName = ENTITY_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getDdlname() <em>Ddlname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDdlname()
   * @generated
   * @ordered
   */
  protected static final String DDLNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDdlname() <em>Ddlname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDdlname()
   * @generated
   * @ordered
   */
  protected String ddlname = DDLNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSourceType()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSourceType()
   * @generated
   * @ordered
   */
  protected String sourceType = SOURCE_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getApiState() <em>Api State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getApiState()
   * @generated
   * @ordered
   */
  protected static final String API_STATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getApiState() <em>Api State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getApiState()
   * @generated
   * @ordered
   */
  protected String apiState = API_STATE_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getChildren()
   * @generated
   * @ordered
   */
  protected EList<IWhereUsedInCdsEntry> children;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected WhereUsedInCdsEntry() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ICdsAnalysisPackage.Literals.WHERE_USED_IN_CDS_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getUri() {
    return uri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setUri(final String newUri) {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__URI, oldUri, uri));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getEntityName() {
    return entityName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setEntityName(final String newEntityName) {
    String oldEntityName = entityName;
    entityName = newEntityName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__ENTITY_NAME, oldEntityName, entityName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getDdlname() {
    return ddlname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setDdlname(final String newDdlname) {
    String oldDdlname = ddlname;
    ddlname = newDdlname;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DDLNAME, oldDdlname, ddlname));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getSourceType() {
    return sourceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSourceType(final String newSourceType) {
    String oldSourceType = sourceType;
    sourceType = newSourceType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__SOURCE_TYPE, oldSourceType, sourceType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setType(final String newType) {
    String oldType = type;
    type = newType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__TYPE, oldType, type));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getApiState() {
    return apiState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setApiState(final String newApiState) {
    String oldApiState = apiState;
    apiState = newApiState;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__API_STATE, oldApiState, apiState));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setDescription(final String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DESCRIPTION, oldDescription, description));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IWhereUsedInCdsEntry> getChildren() {
    if (children == null) {
      children = new EObjectContainmentEList<>(IWhereUsedInCdsEntry.class, this,
          ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__CHILDREN);
    }
    return children;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__CHILDREN:
      return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__URI:
      return getUri();
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__ENTITY_NAME:
      return getEntityName();
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DDLNAME:
      return getDdlname();
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__SOURCE_TYPE:
      return getSourceType();
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__TYPE:
      return getType();
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__API_STATE:
      return getApiState();
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DESCRIPTION:
      return getDescription();
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__CHILDREN:
      return getChildren();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__URI:
      setUri((String) newValue);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__ENTITY_NAME:
      setEntityName((String) newValue);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DDLNAME:
      setDdlname((String) newValue);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__SOURCE_TYPE:
      setSourceType((String) newValue);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__TYPE:
      setType((String) newValue);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__API_STATE:
      setApiState((String) newValue);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DESCRIPTION:
      setDescription((String) newValue);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__CHILDREN:
      getChildren().clear();
      getChildren().addAll((Collection<? extends IWhereUsedInCdsEntry>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
    switch (featureID) {
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__URI:
      setUri(URI_EDEFAULT);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__ENTITY_NAME:
      setEntityName(ENTITY_NAME_EDEFAULT);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DDLNAME:
      setDdlname(DDLNAME_EDEFAULT);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__SOURCE_TYPE:
      setSourceType(SOURCE_TYPE_EDEFAULT);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__TYPE:
      setType(TYPE_EDEFAULT);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__API_STATE:
      setApiState(API_STATE_EDEFAULT);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
      return;
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__CHILDREN:
      getChildren().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__URI:
      return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__ENTITY_NAME:
      return ENTITY_NAME_EDEFAULT == null ? entityName != null
          : !ENTITY_NAME_EDEFAULT.equals(entityName);
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DDLNAME:
      return DDLNAME_EDEFAULT == null ? ddlname != null : !DDLNAME_EDEFAULT.equals(ddlname);
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__SOURCE_TYPE:
      return SOURCE_TYPE_EDEFAULT == null ? sourceType != null
          : !SOURCE_TYPE_EDEFAULT.equals(sourceType);
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__TYPE:
      return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__API_STATE:
      return API_STATE_EDEFAULT == null ? apiState != null : !API_STATE_EDEFAULT.equals(apiState);
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null
          : !DESCRIPTION_EDEFAULT.equals(description);
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY__CHILDREN:
      return children != null && !children.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (uri: ");
    result.append(uri);
    result.append(", entityName: ");
    result.append(entityName);
    result.append(", ddlname: ");
    result.append(ddlname);
    result.append(", sourceType: ");
    result.append(sourceType);
    result.append(", type: ");
    result.append(type);
    result.append(", apiState: ");
    result.append(apiState);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} // WhereUsedInCdsEntry
