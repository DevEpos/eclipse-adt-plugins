/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.saat.model.objectsearch.FilterType;
import com.devepos.adt.saat.model.objectsearch.IContentAssist;
import com.devepos.adt.saat.model.objectsearch.IImageInfo;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Filter Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#getDataType <em>Data
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#getMaxLength <em>Max
 * Length</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#isMultiple
 * <em>Multiple</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#isNegatable
 * <em>Negatable</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#isKeyValuePair <em>Key
 * Value Pair</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#getLongDescription
 * <em>Long Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#isInternal
 * <em>Internal</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#isWildcardsAllowed
 * <em>Wildcards Allowed</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#isRangeAllowed
 * <em>Range Allowed</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#getContentAssist
 * <em>Content Assist</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig#getImageInfo <em>Image
 * Info</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchFilterConfig extends MinimalEObjectImpl.Container
    implements ISearchFilterConfig {
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDataType()
   * @generated
   * @ordered
   */
  protected static final FilterType DATA_TYPE_EDEFAULT = FilterType.DEFAULT;

  /**
   * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDataType()
   * @generated
   * @ordered
   */
  protected FilterType dataType = DATA_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMaxLength()
   * @generated
   * @ordered
   */
  protected static final int MAX_LENGTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMaxLength()
   * @generated
   * @ordered
   */
  protected int maxLength = MAX_LENGTH_EDEFAULT;

  /**
   * The default value of the '{@link #isMultiple() <em>Multiple</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isMultiple()
   * @generated
   * @ordered
   */
  protected static final boolean MULTIPLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMultiple() <em>Multiple</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isMultiple()
   * @generated
   * @ordered
   */
  protected boolean multiple = MULTIPLE_EDEFAULT;

  /**
   * The default value of the '{@link #isNegatable() <em>Negatable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isNegatable()
   * @generated
   * @ordered
   */
  protected static final boolean NEGATABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNegatable() <em>Negatable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isNegatable()
   * @generated
   * @ordered
   */
  protected boolean negatable = NEGATABLE_EDEFAULT;

  /**
   * The default value of the '{@link #isKeyValuePair() <em>Key Value Pair</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isKeyValuePair()
   * @generated
   * @ordered
   */
  protected static final boolean KEY_VALUE_PAIR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isKeyValuePair() <em>Key Value Pair</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isKeyValuePair()
   * @generated
   * @ordered
   */
  protected boolean keyValuePair = KEY_VALUE_PAIR_EDEFAULT;

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
   * The default value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLongDescription()
   * @generated
   * @ordered
   */
  protected static final String LONG_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLongDescription()
   * @generated
   * @ordered
   */
  protected String longDescription = LONG_DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #isInternal() <em>Internal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isInternal()
   * @generated
   * @ordered
   */
  protected static final boolean INTERNAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInternal() <em>Internal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isInternal()
   * @generated
   * @ordered
   */
  protected boolean internal = INTERNAL_EDEFAULT;

  /**
   * The default value of the '{@link #isWildcardsAllowed() <em>Wildcards Allowed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isWildcardsAllowed()
   * @generated
   * @ordered
   */
  protected static final boolean WILDCARDS_ALLOWED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWildcardsAllowed() <em>Wildcards Allowed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isWildcardsAllowed()
   * @generated
   * @ordered
   */
  protected boolean wildcardsAllowed = WILDCARDS_ALLOWED_EDEFAULT;

  /**
   * The default value of the '{@link #isRangeAllowed() <em>Range Allowed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isRangeAllowed()
   * @generated
   * @ordered
   */
  protected static final boolean RANGE_ALLOWED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRangeAllowed() <em>Range Allowed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isRangeAllowed()
   * @generated
   * @ordered
   */
  protected boolean rangeAllowed = RANGE_ALLOWED_EDEFAULT;

  /**
   * The cached value of the '{@link #getContentAssist() <em>Content Assist</em>}' containment
   * reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getContentAssist()
   * @generated
   * @ordered
   */
  protected IContentAssist contentAssist;

  /**
   * The cached value of the '{@link #getImageInfo() <em>Image Info</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImageInfo()
   * @generated
   * @ordered
   */
  protected IImageInfo imageInfo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchFilterConfig() {
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
    return IObjectSearchPackage.Literals.SEARCH_FILTER_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setName(final String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__NAME, oldName, name));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public FilterType getDataType() {
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setDataType(final FilterType newDataType) {
    FilterType oldDataType = dataType;
    dataType = newDataType == null ? DATA_TYPE_EDEFAULT : newDataType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__DATA_TYPE, oldDataType, dataType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getMaxLength() {
    return maxLength;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setMaxLength(final int newMaxLength) {
    int oldMaxLength = maxLength;
    maxLength = newMaxLength;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__MAX_LENGTH, oldMaxLength, maxLength));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isMultiple() {
    return multiple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setMultiple(final boolean newMultiple) {
    boolean oldMultiple = multiple;
    multiple = newMultiple;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__MULTIPLE, oldMultiple, multiple));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isNegatable() {
    return negatable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setNegatable(final boolean newNegatable) {
    boolean oldNegatable = negatable;
    negatable = newNegatable;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__NEGATABLE, oldNegatable, negatable));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isKeyValuePair() {
    return keyValuePair;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setKeyValuePair(final boolean newKeyValuePair) {
    boolean oldKeyValuePair = keyValuePair;
    keyValuePair = newKeyValuePair;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__KEY_VALUE_PAIR, oldKeyValuePair,
          keyValuePair));
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
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__DESCRIPTION, oldDescription, description));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLongDescription() {
    return longDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setLongDescription(final String newLongDescription) {
    String oldLongDescription = longDescription;
    longDescription = newLongDescription;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__LONG_DESCRIPTION, oldLongDescription,
          longDescription));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isInternal() {
    return internal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setInternal(final boolean newInternal) {
    boolean oldInternal = internal;
    internal = newInternal;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__INTERNAL, oldInternal, internal));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isWildcardsAllowed() {
    return wildcardsAllowed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setWildcardsAllowed(final boolean newWildcardsAllowed) {
    boolean oldWildcardsAllowed = wildcardsAllowed;
    wildcardsAllowed = newWildcardsAllowed;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__WILDCARDS_ALLOWED, oldWildcardsAllowed,
          wildcardsAllowed));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isRangeAllowed() {
    return rangeAllowed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setRangeAllowed(final boolean newRangeAllowed) {
    boolean oldRangeAllowed = rangeAllowed;
    rangeAllowed = newRangeAllowed;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__RANGE_ALLOWED, oldRangeAllowed, rangeAllowed));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IContentAssist getContentAssist() {
    return contentAssist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public NotificationChain basicSetContentAssist(final IContentAssist newContentAssist,
      NotificationChain msgs) {
    IContentAssist oldContentAssist = contentAssist;
    contentAssist = newContentAssist;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__CONTENT_ASSIST, oldContentAssist,
          newContentAssist);
      if (msgs == null) {
        msgs = notification;
      } else {
        msgs.add(notification);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setContentAssist(final IContentAssist newContentAssist) {
    if (newContentAssist != contentAssist) {
      NotificationChain msgs = null;
      if (contentAssist != null) {
        msgs = ((InternalEObject) contentAssist).eInverseRemove(this,
            EOPPOSITE_FEATURE_BASE - IObjectSearchPackage.SEARCH_FILTER_CONFIG__CONTENT_ASSIST,
            null, msgs);
      }
      if (newContentAssist != null) {
        msgs = ((InternalEObject) newContentAssist).eInverseAdd(this,
            EOPPOSITE_FEATURE_BASE - IObjectSearchPackage.SEARCH_FILTER_CONFIG__CONTENT_ASSIST,
            null, msgs);
      }
      msgs = basicSetContentAssist(newContentAssist, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    } else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__CONTENT_ASSIST, newContentAssist,
          newContentAssist));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IImageInfo getImageInfo() {
    if (imageInfo != null && imageInfo.eIsProxy()) {
      InternalEObject oldImageInfo = (InternalEObject) imageInfo;
      imageInfo = (IImageInfo) eResolveProxy(oldImageInfo);
      if (imageInfo != oldImageInfo && eNotificationRequired()) {
        eNotify(new ENotificationImpl(this, Notification.RESOLVE,
            IObjectSearchPackage.SEARCH_FILTER_CONFIG__IMAGE_INFO, oldImageInfo, imageInfo));
      }
    }
    return imageInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public IImageInfo basicGetImageInfo() {
    return imageInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setImageInfo(final IImageInfo newImageInfo) {
    IImageInfo oldImageInfo = imageInfo;
    imageInfo = newImageInfo;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_FILTER_CONFIG__IMAGE_INFO, oldImageInfo, imageInfo));
    }
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
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__CONTENT_ASSIST:
      return basicSetContentAssist(null, msgs);
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
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__NAME:
      return getName();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__DATA_TYPE:
      return getDataType();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__MAX_LENGTH:
      return getMaxLength();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__MULTIPLE:
      return isMultiple();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__NEGATABLE:
      return isNegatable();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__KEY_VALUE_PAIR:
      return isKeyValuePair();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__DESCRIPTION:
      return getDescription();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__LONG_DESCRIPTION:
      return getLongDescription();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__INTERNAL:
      return isInternal();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__WILDCARDS_ALLOWED:
      return isWildcardsAllowed();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__RANGE_ALLOWED:
      return isRangeAllowed();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__CONTENT_ASSIST:
      return getContentAssist();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__IMAGE_INFO:
      if (resolve) {
        return getImageInfo();
      }
      return basicGetImageInfo();
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
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__NAME:
      setName((String) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__DATA_TYPE:
      setDataType((FilterType) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__MAX_LENGTH:
      setMaxLength((Integer) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__MULTIPLE:
      setMultiple((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__NEGATABLE:
      setNegatable((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__KEY_VALUE_PAIR:
      setKeyValuePair((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__DESCRIPTION:
      setDescription((String) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__LONG_DESCRIPTION:
      setLongDescription((String) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__INTERNAL:
      setInternal((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__WILDCARDS_ALLOWED:
      setWildcardsAllowed((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__RANGE_ALLOWED:
      setRangeAllowed((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__CONTENT_ASSIST:
      setContentAssist((IContentAssist) newValue);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__IMAGE_INFO:
      setImageInfo((IImageInfo) newValue);
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
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__NAME:
      setName(NAME_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__DATA_TYPE:
      setDataType(DATA_TYPE_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__MAX_LENGTH:
      setMaxLength(MAX_LENGTH_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__MULTIPLE:
      setMultiple(MULTIPLE_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__NEGATABLE:
      setNegatable(NEGATABLE_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__KEY_VALUE_PAIR:
      setKeyValuePair(KEY_VALUE_PAIR_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__LONG_DESCRIPTION:
      setLongDescription(LONG_DESCRIPTION_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__INTERNAL:
      setInternal(INTERNAL_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__WILDCARDS_ALLOWED:
      setWildcardsAllowed(WILDCARDS_ALLOWED_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__RANGE_ALLOWED:
      setRangeAllowed(RANGE_ALLOWED_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__CONTENT_ASSIST:
      setContentAssist((IContentAssist) null);
      return;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__IMAGE_INFO:
      setImageInfo((IImageInfo) null);
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
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__DATA_TYPE:
      return dataType != DATA_TYPE_EDEFAULT;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__MAX_LENGTH:
      return maxLength != MAX_LENGTH_EDEFAULT;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__MULTIPLE:
      return multiple != MULTIPLE_EDEFAULT;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__NEGATABLE:
      return negatable != NEGATABLE_EDEFAULT;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__KEY_VALUE_PAIR:
      return keyValuePair != KEY_VALUE_PAIR_EDEFAULT;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null
          : !DESCRIPTION_EDEFAULT.equals(description);
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__LONG_DESCRIPTION:
      return LONG_DESCRIPTION_EDEFAULT == null ? longDescription != null
          : !LONG_DESCRIPTION_EDEFAULT.equals(longDescription);
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__INTERNAL:
      return internal != INTERNAL_EDEFAULT;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__WILDCARDS_ALLOWED:
      return wildcardsAllowed != WILDCARDS_ALLOWED_EDEFAULT;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__RANGE_ALLOWED:
      return rangeAllowed != RANGE_ALLOWED_EDEFAULT;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__CONTENT_ASSIST:
      return contentAssist != null;
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG__IMAGE_INFO:
      return imageInfo != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", dataType: ");
    result.append(dataType);
    result.append(", maxLength: ");
    result.append(maxLength);
    result.append(", multiple: ");
    result.append(multiple);
    result.append(", negatable: ");
    result.append(negatable);
    result.append(", keyValuePair: ");
    result.append(keyValuePair);
    result.append(", description: ");
    result.append(description);
    result.append(", longDescription: ");
    result.append(longDescription);
    result.append(", internal: ");
    result.append(internal);
    result.append(", wildcardsAllowed: ");
    result.append(wildcardsAllowed);
    result.append(", rangeAllowed: ");
    result.append(rangeAllowed);
    result.append(')');
    return result.toString();
  }

} // SearchFilterConfig
