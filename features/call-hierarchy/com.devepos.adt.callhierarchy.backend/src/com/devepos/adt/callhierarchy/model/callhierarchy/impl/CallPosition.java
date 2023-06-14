/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallPosition#getUri
 * <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallPosition#getLine
 * <em>Line</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallPosition#getColumn
 * <em>Column</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallPosition extends MinimalEObjectImpl.Container implements ICallPosition {
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
   * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLine()
   * @generated
   * @ordered
   */
  protected static final int LINE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLine()
   * @generated
   * @ordered
   */
  protected int line = LINE_EDEFAULT;

  /**
   * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected static final int COLUMN_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected int column = COLUMN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected CallPosition() {
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
    return ICallhierarchyPackage.Literals.CALL_POSITION;
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
  public void setUri(final String newUri) {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.CALL_POSITION__URI, oldUri, uri));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getLine() {
    return line;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setLine(final int newLine) {
    int oldLine = line;
    line = newLine;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.CALL_POSITION__LINE, oldLine, line));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getColumn() {
    return column;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setColumn(final int newColumn) {
    int oldColumn = column;
    column = newColumn;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.CALL_POSITION__COLUMN, oldColumn, column));
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
    case ICallhierarchyPackage.CALL_POSITION__URI:
      return getUri();
    case ICallhierarchyPackage.CALL_POSITION__LINE:
      return getLine();
    case ICallhierarchyPackage.CALL_POSITION__COLUMN:
      return getColumn();
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
    case ICallhierarchyPackage.CALL_POSITION__URI:
      setUri((String) newValue);
      return;
    case ICallhierarchyPackage.CALL_POSITION__LINE:
      setLine((Integer) newValue);
      return;
    case ICallhierarchyPackage.CALL_POSITION__COLUMN:
      setColumn((Integer) newValue);
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
    case ICallhierarchyPackage.CALL_POSITION__URI:
      setUri(URI_EDEFAULT);
      return;
    case ICallhierarchyPackage.CALL_POSITION__LINE:
      setLine(LINE_EDEFAULT);
      return;
    case ICallhierarchyPackage.CALL_POSITION__COLUMN:
      setColumn(COLUMN_EDEFAULT);
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
    case ICallhierarchyPackage.CALL_POSITION__URI:
      return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
    case ICallhierarchyPackage.CALL_POSITION__LINE:
      return line != LINE_EDEFAULT;
    case ICallhierarchyPackage.CALL_POSITION__COLUMN:
      return column != COLUMN_EDEFAULT;
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
    result.append(", line: ");
    result.append(line);
    result.append(", column: ");
    result.append(column);
    result.append(')');
    return result.toString();
  }

} // CallPosition
