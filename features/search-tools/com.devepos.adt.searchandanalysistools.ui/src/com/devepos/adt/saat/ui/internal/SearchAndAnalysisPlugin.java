package com.devepos.adt.saat.ui.internal;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.BundleContext;

import com.devepos.adt.base.ui.plugin.AbstractAdtUIPlugin;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig;
import com.devepos.adt.saat.model.objectsearch.ImageRegistryId;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * The activator class controls the plug-in life cycle
 */
public class SearchAndAnalysisPlugin extends AbstractAdtUIPlugin {

  public static final String PLUGIN_ID = "com.devepos.adt.searchandanalysistools.ui"; //$NON-NLS-1$

  // The shared instance
  private static SearchAndAnalysisPlugin plugin;

  /**
   * The constructor
   */
  public SearchAndAnalysisPlugin() {
    super(PLUGIN_ID);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static SearchAndAnalysisPlugin getDefault() {
    return plugin;
  }

  /**
   * Returns image of a search type.
   *
   * @param typeConfig configuration of an object search type
   * @return the found image or {@code null}
   */
  public Image getSearchTypeImage(final ISearchTypeConfig typeConfig) {
    var imageInfo = typeConfig.getImageInfo();
    if (imageInfo == null || imageInfo.getImageId() == null) {
      return null;
    }
    if (imageInfo.getImageEncoded() != null) {
      var imageDescr = getImage(imageInfo.getImageId());
      if (imageDescr == null) {
        registerEncodedImage(imageInfo.getImageId(), imageInfo.getImageEncoded());
        imageDescr = getImage(imageInfo.getImageId());
      }
      return imageDescr;
    }
    if (imageInfo.getImageRegistryId() == ImageRegistryId.ADT_OBJECT_TYPE) {
      return AdtTypeUtil.getInstance().getTypeImage(imageInfo.getImageId());
    }
    return null;
  }

  /**
   * Returns image descriptor for the given search type
   *
   * @param typeConfig configuration of an object search type
   * @return the image descriptor for the search type
   */
  public ImageDescriptor getSearchTypeImgDescr(final ISearchTypeConfig typeConfig) {
    var image = getSearchTypeImage(typeConfig);
    return image != null ? ImageDescriptor.createFromImage(image) : null;
  }

  @Override
  public void start(final BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  @Override
  public void stop(final BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  @Override
  protected void initializeImageRegistry(final ImageRegistry imageRegistry) {
    // register all kinds of images
    registerImage(imageRegistry, IImages.DB_BROWSER_DATA_PREVIEW, "icons/DBBrowser.png");
    registerImage(imageRegistry, IImages.CDS_VIEW, "icons/obj/entity.png",
        "com.sap.adt.cds.base.ddl.ui");
    registerImage(imageRegistry, IImages.VIEW_DEFINITION, "icons/obj/viewDefinition.png",
        "com.sap.adt.tools.core.ui");
    registerImage(imageRegistry, IImages.EXCEL_APPLICATION, "icons/Excel.png");
    registerImage(imageRegistry, IImages.ANALYTICAL_QUERY, "icons/AnalyticalQuery.png");
    registerImage(imageRegistry, IImages.EXTERNAL_TOOLS, "icons/ExternalTools.png");
    registerImage(imageRegistry, IImages.OBJECT_SEARCH, "icons/ABAPSearch.png");
    registerImage(imageRegistry, IImages.CDS_ANALYZER, "icons/CdsAnalyzerView.png");
    registerImage(imageRegistry, IImages.TOP_DOWN, "icons/TopDown.png");
    registerImage(imageRegistry, IImages.FIELD_ANALYSIS, "icons/CdsFieldAnalysis.png");
    registerImage(imageRegistry, IImages.WHERE_USED_IN, "icons/WhereUsedInCds.png");
    registerImage(imageRegistry, IImages.USAGE_ANALYZER, "icons/CdsUsageAnalyzer.png");
    registerImage(imageRegistry, IImages.UNION, "icons/Union.png");
    registerImage(imageRegistry, IImages.INTERSECT, "icons/Intersect.png");
    registerImage(imageRegistry, IImages.EXCEPT, "icons/Except.png");
    registerImage(imageRegistry, IImages.JOIN_RESULT_SOURCE, "icons/JoinedDataSource.png");
    registerImage(imageRegistry, IImages.KEY_COLUMN, "icons/KeyColumn.png");
    registerImage(imageRegistry, IImages.FIELD_TOP_DOWN, "icons/FieldTopDown.png");
    registerImage(imageRegistry, IImages.FIELD_WHERE_USED, "icons/FieldWhereUsed.png");
    registerImage(imageRegistry, IImages.FUNCTION, "icons/obj/Function.png",
        "com.sap.adt.cds.base.ddl.ui");

    // register overlay images
    registerImage(imageRegistry, IImages.RELEASED_API_OVR, "icons/ovr/Released.png");
    registerImage(imageRegistry, IImages.DEPRECATED_API_OVR, "icons/ovr/Deprecated.png");
    registerImage(imageRegistry, IImages.SOURCE_TYPE_FUNCTION_OVR, "icons/ovr/Function.png");
    registerImage(imageRegistry, IImages.SOURCE_TYPE_ABSTRACT_ENTITY_OVR,
        "icons/ovr/AbstractEntity.png");
    registerImage(imageRegistry, IImages.SOURCE_TYPE_PROJECTION_ENTITY_OVR,
        "icons/ovr/ProjectionEntity.png");
    registerImage(imageRegistry, IImages.SOURCE_TYPE_HIERARCHY_ENTITY_OVR,
        "icons/ovr/HierarchyEntity.png");
    registerImage(imageRegistry, IImages.SOURCE_TYPE_CUSTOM_ENTITY_OVR,
        "icons/ovr/CustomEntity.png");

    // Object Search parameter image registrations
    registerImage(imageRegistry, IImages.PACKAGE_PARAM, "icons/obj/package_obj.png",
        "com.sap.adt.tools.core.ui");
    registerImage(imageRegistry, IImages.SELECT_FROM_PARAM, "icons/SelectFromSource.png");
    registerImage(imageRegistry, IImages.COLUMN, "icons/Column.png");
    registerImage(imageRegistry, IImages.USED_AS_ASSOCICATION_PARAM,
        "icons/obj/AssociationDeclaration.png", "com.sap.adt.tools.core.ui");
    registerImage(imageRegistry, IImages.RUN_NEW_ANALYSIS, "icons/RunCdsAnalysis.png");
    registerImage(imageRegistry, IImages.CDS_ANALYSIS_MODE_SWITCH, "icons/OtherAnalysis.png");
    registerImage(imageRegistry, IImages.NEW_CDS_ANALYSIS_VIEW, "icons/NewCdsAnalyzerView.png");
  }
}
