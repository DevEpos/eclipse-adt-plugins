package com.devepos.adt.saat.ui.internal;

public class ExtendedAdtObjectInfo implements IExtendedAdtObjectInfo {

  private boolean isReleased;
  private String owner;
  private IDataSourceType sourceType;

  @Override
  public String getOwner() {
    return owner;
  }

  @Override
  public IDataSourceType getSourceType() {
    return sourceType;
  }

  @Override
  public boolean isReleased() {
    return isReleased;
  }

  /**
   * Sets the API State of the ADT Object
   *
   * @param apiState the API state. It can only have the following values:
   *                 <ul>
   *                 <li>{@link IExtendedAdtObjectInfo#API_STATE_DEPRECATED}</li>
   *                 <li>{@link IExtendedAdtObjectInfo#API_STATE_RELEASED}</li>
   *                 </ul>
   */
  public void setApiState(final String apiState) {
    if (apiState == null) {
      return;
    }
    if (API_STATE_DEPRECATED.equals(apiState)) {
      isReleased = false;
    } else if (API_STATE_RELEASED.equals(apiState)) {
      isReleased = true;
    }
  }

  /**
   * Sets the owner of this ADT object
   *
   * @param owner the owner
   */
  public void setOwner(final String owner) {
    this.owner = owner;
  }

  /**
   * @param sourceType the sourceType to set
   */
  public void setSourceType(final IDataSourceType sourceType) {
    this.sourceType = sourceType;
  }
}