/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Adt Obj
 * Ref</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getPackageName
 * <em>Package Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getUri
 * <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getOwner
 * <em>Owner</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getTadirType
 * <em>Tadir Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdtObjRef extends MinimalEObjectImpl.Container implements IAdtObjRef {
    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getPackageName() <em>Package Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPackageName()
     * @generated
     * @ordered
     */
    protected static final String PACKAGE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPackageName() <em>Package Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPackageName()
     * @generated
     * @ordered
     */
    protected String packageName = PACKAGE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final String TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getType()
     * @generated
     * @ordered
     */
    protected String type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getUri() <em>Uri</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected static final String URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected String uri = URI_EDEFAULT;

    /**
     * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOwner()
     * @generated
     * @ordered
     */
    protected static final String OWNER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOwner()
     * @generated
     * @ordered
     */
    protected String owner = OWNER_EDEFAULT;

    /**
     * The default value of the '{@link #getTadirType() <em>Tadir Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTadirType()
     * @generated
     * @ordered
     */
    protected static final String TADIR_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTadirType() <em>Tadir Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTadirType()
     * @generated
     * @ordered
     */
    protected String tadirType = TADIR_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AdtObjRef() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IAdtBasePackage.Literals.ADT_OBJ_REF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDescription(final String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION,
                    oldDescription, description));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setName(final String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__NAME, oldName, name));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getPackageName() {
        return packageName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPackageName(final String newPackageName) {
        String oldPackageName = packageName;
        packageName = newPackageName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME,
                    oldPackageName, packageName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setType(final String newType) {
        String oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__TYPE, oldType, type));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getUri() {
        return uri;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setUri(final String newUri) {
        String oldUri = uri;
        uri = newUri;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__URI, oldUri, uri));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getOwner() {
        return owner;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOwner(final String newOwner) {
        String oldOwner = owner;
        owner = newOwner;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__OWNER, oldOwner, owner));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getTadirType() {
        return tadirType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTadirType(final String newTadirType) {
        String oldTadirType = tadirType;
        tadirType = newTadirType;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE, oldTadirType,
                    tadirType));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION:
            return getDescription();
        case IAdtBasePackage.ADT_OBJ_REF__NAME:
            return getName();
        case IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME:
            return getPackageName();
        case IAdtBasePackage.ADT_OBJ_REF__TYPE:
            return getType();
        case IAdtBasePackage.ADT_OBJ_REF__URI:
            return getUri();
        case IAdtBasePackage.ADT_OBJ_REF__OWNER:
            return getOwner();
        case IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE:
            return getTadirType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION:
            setDescription((String) newValue);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__NAME:
            setName((String) newValue);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME:
            setPackageName((String) newValue);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__TYPE:
            setType((String) newValue);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__URI:
            setUri((String) newValue);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__OWNER:
            setOwner((String) newValue);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE:
            setTadirType((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION:
            setDescription(DESCRIPTION_EDEFAULT);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__NAME:
            setName(NAME_EDEFAULT);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME:
            setPackageName(PACKAGE_NAME_EDEFAULT);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__TYPE:
            setType(TYPE_EDEFAULT);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__URI:
            setUri(URI_EDEFAULT);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__OWNER:
            setOwner(OWNER_EDEFAULT);
            return;
        case IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE:
            setTadirType(TADIR_TYPE_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION:
            return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
        case IAdtBasePackage.ADT_OBJ_REF__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME:
            return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
        case IAdtBasePackage.ADT_OBJ_REF__TYPE:
            return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
        case IAdtBasePackage.ADT_OBJ_REF__URI:
            return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
        case IAdtBasePackage.ADT_OBJ_REF__OWNER:
            return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
        case IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE:
            return TADIR_TYPE_EDEFAULT == null ? tadirType != null : !TADIR_TYPE_EDEFAULT.equals(tadirType);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (description: ");
        result.append(description);
        result.append(", name: ");
        result.append(name);
        result.append(", packageName: ");
        result.append(packageName);
        result.append(", type: ");
        result.append(type);
        result.append(", uri: ");
        result.append(uri);
        result.append(", owner: ");
        result.append(owner);
        result.append(", tadirType: ");
        result.append(tadirType);
        result.append(')');
        return result.toString();
    }

} // AdtObjRef
