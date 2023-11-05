package com.devepos.adt.saat.ui.internal.cdsanalysis;

import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation;

/**
 * Holds information about the used entity in the dependency tree of a CDS view
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface ICdsEntityUsageEntry {
  ICdsUsedEntityInformation getUsageInfo();
}
