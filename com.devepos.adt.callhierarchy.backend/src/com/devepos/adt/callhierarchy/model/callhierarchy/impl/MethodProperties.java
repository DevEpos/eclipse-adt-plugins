/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage;
import com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties;
import com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties#isFinal
 * <em>Final</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties#isAbstract
 * <em>Abstract</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties#isRedefined
 * <em>Redefined</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties#isHandler
 * <em>Handler</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties#isConstructor
 * <em>Constructor</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties#isStatic
 * <em>Static</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties#getVisibility
 * <em>Visibility</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties#isTestMethod
 * <em>Test Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodProperties extends MinimalEObjectImpl.Container implements IMethodProperties {
  /**
   * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected static final boolean FINAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected boolean final_ = FINAL_EDEFAULT;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The default value of the '{@link #isRedefined() <em>Redefined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isRedefined()
   * @generated
   * @ordered
   */
  protected static final boolean REDEFINED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRedefined() <em>Redefined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isRedefined()
   * @generated
   * @ordered
   */
  protected boolean redefined = REDEFINED_EDEFAULT;

  /**
   * The default value of the '{@link #isHandler() <em>Handler</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isHandler()
   * @generated
   * @ordered
   */
  protected static final boolean HANDLER_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHandler() <em>Handler</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isHandler()
   * @generated
   * @ordered
   */
  protected boolean handler = HANDLER_EDEFAULT;

  /**
   * The default value of the '{@link #isConstructor() <em>Constructor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isConstructor()
   * @generated
   * @ordered
   */
  protected static final boolean CONSTRUCTOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isConstructor() <em>Constructor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isConstructor()
   * @generated
   * @ordered
   */
  protected boolean constructor = CONSTRUCTOR_EDEFAULT;

  /**
   * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected static final boolean STATIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected boolean static_ = STATIC_EDEFAULT;

  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final MethodVisibility VISIBILITY_EDEFAULT = MethodVisibility.PRIVATE;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected MethodVisibility visibility = VISIBILITY_EDEFAULT;

  /**
   * The default value of the '{@link #isTestMethod() <em>Test Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isTestMethod()
   * @generated
   * @ordered
   */
  protected static final boolean TEST_METHOD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTestMethod() <em>Test Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isTestMethod()
   * @generated
   * @ordered
   */
  protected boolean testMethod = TEST_METHOD_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected MethodProperties() {
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
    return ICallhierarchyPackage.Literals.METHOD_PROPERTIES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isFinal() {
    return final_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setFinal(final boolean newFinal) {
    boolean oldFinal = final_;
    final_ = newFinal;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.METHOD_PROPERTIES__FINAL, oldFinal, final_));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isAbstract() {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setAbstract(final boolean newAbstract) {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.METHOD_PROPERTIES__ABSTRACT, oldAbstract, abstract_));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isRedefined() {
    return redefined;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setRedefined(final boolean newRedefined) {
    boolean oldRedefined = redefined;
    redefined = newRedefined;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.METHOD_PROPERTIES__REDEFINED, oldRedefined, redefined));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isHandler() {
    return handler;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setHandler(final boolean newHandler) {
    boolean oldHandler = handler;
    handler = newHandler;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.METHOD_PROPERTIES__HANDLER, oldHandler, handler));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isConstructor() {
    return constructor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setConstructor(final boolean newConstructor) {
    boolean oldConstructor = constructor;
    constructor = newConstructor;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.METHOD_PROPERTIES__CONSTRUCTOR, oldConstructor, constructor));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isStatic() {
    return static_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setStatic(final boolean newStatic) {
    boolean oldStatic = static_;
    static_ = newStatic;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.METHOD_PROPERTIES__STATIC, oldStatic, static_));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public MethodVisibility getVisibility() {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setVisibility(final MethodVisibility newVisibility) {
    MethodVisibility oldVisibility = visibility;
    visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.METHOD_PROPERTIES__VISIBILITY, oldVisibility, visibility));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isTestMethod() {
    return testMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setTestMethod(final boolean newTestMethod) {
    boolean oldTestMethod = testMethod;
    testMethod = newTestMethod;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.METHOD_PROPERTIES__TEST_METHOD, oldTestMethod, testMethod));
    }
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
    case ICallhierarchyPackage.METHOD_PROPERTIES__FINAL:
      return isFinal();
    case ICallhierarchyPackage.METHOD_PROPERTIES__ABSTRACT:
      return isAbstract();
    case ICallhierarchyPackage.METHOD_PROPERTIES__REDEFINED:
      return isRedefined();
    case ICallhierarchyPackage.METHOD_PROPERTIES__HANDLER:
      return isHandler();
    case ICallhierarchyPackage.METHOD_PROPERTIES__CONSTRUCTOR:
      return isConstructor();
    case ICallhierarchyPackage.METHOD_PROPERTIES__STATIC:
      return isStatic();
    case ICallhierarchyPackage.METHOD_PROPERTIES__VISIBILITY:
      return getVisibility();
    case ICallhierarchyPackage.METHOD_PROPERTIES__TEST_METHOD:
      return isTestMethod();
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
    case ICallhierarchyPackage.METHOD_PROPERTIES__FINAL:
      setFinal((Boolean) newValue);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__ABSTRACT:
      setAbstract((Boolean) newValue);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__REDEFINED:
      setRedefined((Boolean) newValue);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__HANDLER:
      setHandler((Boolean) newValue);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__CONSTRUCTOR:
      setConstructor((Boolean) newValue);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__STATIC:
      setStatic((Boolean) newValue);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__VISIBILITY:
      setVisibility((MethodVisibility) newValue);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__TEST_METHOD:
      setTestMethod((Boolean) newValue);
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
    case ICallhierarchyPackage.METHOD_PROPERTIES__FINAL:
      setFinal(FINAL_EDEFAULT);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__ABSTRACT:
      setAbstract(ABSTRACT_EDEFAULT);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__REDEFINED:
      setRedefined(REDEFINED_EDEFAULT);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__HANDLER:
      setHandler(HANDLER_EDEFAULT);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__CONSTRUCTOR:
      setConstructor(CONSTRUCTOR_EDEFAULT);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__STATIC:
      setStatic(STATIC_EDEFAULT);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__VISIBILITY:
      setVisibility(VISIBILITY_EDEFAULT);
      return;
    case ICallhierarchyPackage.METHOD_PROPERTIES__TEST_METHOD:
      setTestMethod(TEST_METHOD_EDEFAULT);
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
    case ICallhierarchyPackage.METHOD_PROPERTIES__FINAL:
      return final_ != FINAL_EDEFAULT;
    case ICallhierarchyPackage.METHOD_PROPERTIES__ABSTRACT:
      return abstract_ != ABSTRACT_EDEFAULT;
    case ICallhierarchyPackage.METHOD_PROPERTIES__REDEFINED:
      return redefined != REDEFINED_EDEFAULT;
    case ICallhierarchyPackage.METHOD_PROPERTIES__HANDLER:
      return handler != HANDLER_EDEFAULT;
    case ICallhierarchyPackage.METHOD_PROPERTIES__CONSTRUCTOR:
      return constructor != CONSTRUCTOR_EDEFAULT;
    case ICallhierarchyPackage.METHOD_PROPERTIES__STATIC:
      return static_ != STATIC_EDEFAULT;
    case ICallhierarchyPackage.METHOD_PROPERTIES__VISIBILITY:
      return visibility != VISIBILITY_EDEFAULT;
    case ICallhierarchyPackage.METHOD_PROPERTIES__TEST_METHOD:
      return testMethod != TEST_METHOD_EDEFAULT;
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
    result.append(" (final: ");
    result.append(final_);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(", redefined: ");
    result.append(redefined);
    result.append(", handler: ");
    result.append(handler);
    result.append(", constructor: ");
    result.append(constructor);
    result.append(", static: ");
    result.append(static_);
    result.append(", visibility: ");
    result.append(visibility);
    result.append(", testMethod: ");
    result.append(testMethod);
    result.append(')');
    return result.toString();
  }

} // MethodProperties
