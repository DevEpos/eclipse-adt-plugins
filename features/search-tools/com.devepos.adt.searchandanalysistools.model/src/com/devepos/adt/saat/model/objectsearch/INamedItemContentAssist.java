/**
 */
package com.devepos.adt.saat.model.objectsearch;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Item Content Assist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getCategoryScheme
 * <em>Category Scheme</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getCategoryTerm
 * <em>Category Term</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getSecondaryCategoryTerm
 * <em>Secondary Category Term</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getNamedItemContentAssist()
 * @model
 * @generated
 */
public interface INamedItemContentAssist extends IContentAssist {
  /**
   * Returns the value of the '<em><b>Category Scheme</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Category Scheme</em>' attribute.
   * @see #setCategoryScheme(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getNamedItemContentAssist_CategoryScheme()
   * @model extendedMetaData="name='categoryScheme' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getCategoryScheme();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getCategoryScheme
   * <em>Category Scheme</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Category Scheme</em>' attribute.
   * @see #getCategoryScheme()
   * @generated
   */
  void setCategoryScheme(String value);

  /**
   * Returns the value of the '<em><b>Category Term</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Category Term</em>' attribute.
   * @see #setCategoryTerm(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getNamedItemContentAssist_CategoryTerm()
   * @model extendedMetaData="name='categoryTerm' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getCategoryTerm();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getCategoryTerm
   * <em>Category Term</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Category Term</em>' attribute.
   * @see #getCategoryTerm()
   * @generated
   */
  void setCategoryTerm(String value);

  /**
   * Returns the value of the '<em><b>Secondary Category Term</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Secondary Category Term</em>' attribute.
   * @see #setSecondaryCategoryTerm(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getNamedItemContentAssist_SecondaryCategoryTerm()
   * @model extendedMetaData="name='secondaryCategoryTerm' kind='attribute'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getSecondaryCategoryTerm();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getSecondaryCategoryTerm
   * <em>Secondary Category Term</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Secondary Category Term</em>' attribute.
   * @see #getSecondaryCategoryTerm()
   * @generated
   */
  void setSecondaryCategoryTerm(String value);

} // INamedItemContentAssist
