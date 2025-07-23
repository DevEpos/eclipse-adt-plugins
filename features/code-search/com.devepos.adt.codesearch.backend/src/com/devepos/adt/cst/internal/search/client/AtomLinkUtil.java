package com.devepos.adt.cst.internal.search.client;

import com.sap.adt.ris.model.virtualfolders.IObject;
import com.sap.adt.ris.model.virtualfolders.IVirtualFolder;
import com.sap.adt.tools.core.atom.AdtAtomUtilFactory;
import com.sap.adt.tools.core.atom.IAdtAtomUtil;

@SuppressWarnings("restriction")
public class AtomLinkUtil {
  private static IAdtAtomUtil atomUtil = AdtAtomUtilFactory.createAtomUtil();

  public static String getPackageUri(final IVirtualFolder f) {
    var uri = atomUtil.findAtomLinkAsUri(f.getLinks(), "http://www.sap.com/adt/relations/packages",
        "application/vnd.sap.sapgui");
    return uri != null ? uri.toString() : null;
  }

  public static String getObjectUri(final IObject o) {
    var uri = atomUtil.findAtomLinkAsUri(o.getLinks(), "http://www.sap.com/adt/relations/objects");
    return uri != null ? uri.toString() : null;
  }
}
