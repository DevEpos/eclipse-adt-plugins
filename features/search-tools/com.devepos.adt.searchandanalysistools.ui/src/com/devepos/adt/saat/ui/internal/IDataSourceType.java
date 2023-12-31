package com.devepos.adt.saat.ui.internal;

import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * Marks the type of a data source
 *
 * @author stockbal
 */
public interface IDataSourceType {

  /**
   * Returns the internal ID of the source type
   *
   * @return
   */
  String getId();

  /**
   * Returns the associated Image id for this source type
   *
   * @see IImages
   * @return
   */
  String getImageId();
}
