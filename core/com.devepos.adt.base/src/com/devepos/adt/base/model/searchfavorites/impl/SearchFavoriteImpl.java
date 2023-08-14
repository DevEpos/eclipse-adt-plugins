/**
 */
package com.devepos.adt.base.model.searchfavorites.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.base.model.searchfavorites.IBaseAttribute;
import com.devepos.adt.base.model.searchfavorites.IBooleanAttribute;
import com.devepos.adt.base.model.searchfavorites.IIntAttribute;
import com.devepos.adt.base.model.searchfavorites.IListAttribute;
import com.devepos.adt.base.model.searchfavorites.IMapAttribute;
import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage;
import com.devepos.adt.base.model.searchfavorites.IStringAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Favorite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.impl.SearchFavoriteImpl#getSearchType
 * <em>Search Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.impl.SearchFavoriteImpl#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.impl.SearchFavoriteImpl#getDestinationId
 * <em>Destination Id</em>}</li>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.impl.SearchFavoriteImpl#isProjectIndependent
 * <em>Project Independent</em>}</li>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.impl.SearchFavoriteImpl#getAttributes
 * <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchFavoriteImpl extends MinimalEObjectImpl.Container implements ISearchFavorite {
  private static final EMap<String, String> DEFAULT_MAP_ATTR_VALUE = new BasicEMap<>();
  private static final List<String> DEFAULT_LIST_ATTR_VALUE = new ArrayList<>();
  /**
   * The default value of the '{@link #getSearchType() <em>Search Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSearchType()
   * @generated
   * @ordered
   */
  protected static final String SEARCH_TYPE_EDEFAULT = null;

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
   * The default value of the '{@link #getDestinationId() <em>Destination Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDestinationId()
   * @generated
   * @ordered
   */
  protected static final String DESTINATION_ID_EDEFAULT = null;

  /**
   * The default value of the '{@link #isProjectIndependent() <em>Project Independent</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isProjectIndependent()
   * @generated
   * @ordered
   */
  protected static final boolean PROJECT_INDEPENDENT_EDEFAULT = false;
  /**
   * The cached value of the '{@link #getSearchType() <em>Search Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSearchType()
   * @generated
   * @ordered
   */
  protected String searchType = SEARCH_TYPE_EDEFAULT;

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
   * The cached value of the '{@link #getDestinationId() <em>Destination Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDestinationId()
   * @generated
   * @ordered
   */
  protected String destinationId = DESTINATION_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #isProjectIndependent() <em>Project Independent</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isProjectIndependent()
   * @generated
   * @ordered
   */
  protected boolean projectIndependent = PROJECT_INDEPENDENT_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<IBaseAttribute> attributes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchFavoriteImpl() {
    super();
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
    case ISearchFavoritesPackage.SEARCH_FAVORITE__SEARCH_TYPE:
      return getSearchType();
    case ISearchFavoritesPackage.SEARCH_FAVORITE__DESCRIPTION:
      return getDescription();
    case ISearchFavoritesPackage.SEARCH_FAVORITE__DESTINATION_ID:
      return getDestinationId();
    case ISearchFavoritesPackage.SEARCH_FAVORITE__PROJECT_INDEPENDENT:
      return isProjectIndependent();
    case ISearchFavoritesPackage.SEARCH_FAVORITE__ATTRIBUTES:
      return getAttributes();
    }
    return super.eGet(featureID, resolve, coreType);
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
    case ISearchFavoritesPackage.SEARCH_FAVORITE__ATTRIBUTES:
      return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
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
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case ISearchFavoritesPackage.SEARCH_FAVORITE__SEARCH_TYPE:
      return SEARCH_TYPE_EDEFAULT == null ? searchType != null
          : !SEARCH_TYPE_EDEFAULT.equals(searchType);
    case ISearchFavoritesPackage.SEARCH_FAVORITE__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null
          : !DESCRIPTION_EDEFAULT.equals(description);
    case ISearchFavoritesPackage.SEARCH_FAVORITE__DESTINATION_ID:
      return DESTINATION_ID_EDEFAULT == null ? destinationId != null
          : !DESTINATION_ID_EDEFAULT.equals(destinationId);
    case ISearchFavoritesPackage.SEARCH_FAVORITE__PROJECT_INDEPENDENT:
      return projectIndependent != PROJECT_INDEPENDENT_EDEFAULT;
    case ISearchFavoritesPackage.SEARCH_FAVORITE__ATTRIBUTES:
      return attributes != null && !attributes.isEmpty();
    }
    return super.eIsSet(featureID);
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
    case ISearchFavoritesPackage.SEARCH_FAVORITE__SEARCH_TYPE:
      setSearchType((String) newValue);
      return;
    case ISearchFavoritesPackage.SEARCH_FAVORITE__DESCRIPTION:
      setDescription((String) newValue);
      return;
    case ISearchFavoritesPackage.SEARCH_FAVORITE__DESTINATION_ID:
      setDestinationId((String) newValue);
      return;
    case ISearchFavoritesPackage.SEARCH_FAVORITE__PROJECT_INDEPENDENT:
      setProjectIndependent((Boolean) newValue);
      return;
    case ISearchFavoritesPackage.SEARCH_FAVORITE__ATTRIBUTES:
      getAttributes().clear();
      getAttributes().addAll((Collection<? extends IBaseAttribute>) newValue);
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
    case ISearchFavoritesPackage.SEARCH_FAVORITE__SEARCH_TYPE:
      setSearchType(SEARCH_TYPE_EDEFAULT);
      return;
    case ISearchFavoritesPackage.SEARCH_FAVORITE__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
      return;
    case ISearchFavoritesPackage.SEARCH_FAVORITE__DESTINATION_ID:
      setDestinationId(DESTINATION_ID_EDEFAULT);
      return;
    case ISearchFavoritesPackage.SEARCH_FAVORITE__PROJECT_INDEPENDENT:
      setProjectIndependent(PROJECT_INDEPENDENT_EDEFAULT);
      return;
    case ISearchFavoritesPackage.SEARCH_FAVORITE__ATTRIBUTES:
      getAttributes().clear();
      return;
    }
    super.eUnset(featureID);
  }

  @Override
  public boolean getAttribute(final String name, final boolean defaultValue) {
    var attribute = findAttribute(name);
    if (attribute == null || !(attribute instanceof IBooleanAttribute)) {
      return defaultValue;
    }
    return ((IBooleanAttribute) attribute).isValue();
  }

  @Override
  public int getAttribute(final String name, final int defaultValue) {
    var attribute = findAttribute(name);
    if (attribute == null || !(attribute instanceof IStringAttribute)) {
      return defaultValue;
    }
    return ((IIntAttribute) attribute).getValue();
  }

  @Override
  public String getAttribute(final String name, final String defaultValue) {
    var attribute = findAttribute(name);
    if (attribute == null || !(attribute instanceof IStringAttribute)) {
      return defaultValue;
    }
    return ((IStringAttribute) attribute).getValue();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<IBaseAttribute> getAttributes() {
    if (attributes == null) {
      attributes = new EObjectContainmentEList<>(IBaseAttribute.class, this,
          ISearchFavoritesPackage.SEARCH_FAVORITE__ATTRIBUTES);
    }
    return attributes;
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
  public String getDestinationId() {
    return destinationId;
  }

  @Override
  public List<String> getListAttribute(final String name) {
    var attribute = findAttribute(name);
    if (attribute == null || !(attribute instanceof IListAttribute)) {
      return DEFAULT_LIST_ATTR_VALUE;
    }
    return ((IListAttribute) attribute).getValues();
  }

  @Override
  public EMap<String, String> getMapAttribute(final String name) {
    var attribute = findAttribute(name);
    if (attribute == null || !(attribute instanceof IMapAttribute)) {
      return DEFAULT_MAP_ATTR_VALUE;
    }
    return ((IMapAttribute) attribute).getEntries();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getSearchType() {
    return searchType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isProjectIndependent() {
    return projectIndependent;
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
          ISearchFavoritesPackage.SEARCH_FAVORITE__DESCRIPTION, oldDescription, description));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setDestinationId(final String newDestinationId) {
    String oldDestinationId = destinationId;
    destinationId = newDestinationId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ISearchFavoritesPackage.SEARCH_FAVORITE__DESTINATION_ID, oldDestinationId,
          destinationId));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setProjectIndependent(final boolean newProjectIndependent) {
    boolean oldProjectIndependent = projectIndependent;
    projectIndependent = newProjectIndependent;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ISearchFavoritesPackage.SEARCH_FAVORITE__PROJECT_INDEPENDENT, oldProjectIndependent,
          projectIndependent));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSearchType(final String newSearchType) {
    String oldSearchType = searchType;
    searchType = newSearchType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ISearchFavoritesPackage.SEARCH_FAVORITE__SEARCH_TYPE, oldSearchType, searchType));
    }
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
    result.append(" (searchType: ");
    result.append(searchType);
    result.append(", description: ");
    result.append(description);
    result.append(", destinationId: ");
    result.append(destinationId);
    result.append(", projectIndependent: ");
    result.append(projectIndependent);
    result.append(')');
    return result.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ISearchFavoritesPackage.Literals.SEARCH_FAVORITE;
  }

  private IBaseAttribute findAttribute(final String name) {
    for (var attribute : getAttributes()) {
      if (name.equals(attribute.getName())) {
        return attribute;
      }
    }
    return null;
  }

} // SearchFavoriteImpl
