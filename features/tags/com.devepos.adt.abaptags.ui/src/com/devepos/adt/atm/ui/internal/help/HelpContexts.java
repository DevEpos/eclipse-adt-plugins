package com.devepos.adt.atm.ui.internal.help;

/**
 * Holds Help Contexts
 *
 * @author stockbal
 */
public enum HelpContexts {
  TAG_WIZARD_OBJECT_SELECTION("tag_wizard_object_selection"),
  TAG_WIZARD_TAG_SELECTION("tag_wizard_tag_selection"),
  TAG_WIZARD_PARENT_OBJECT_SELECTION("tag_wizard_parent_object_selection"),
  UNASSIGN_TAGS_WIZARD("unassign_tags_wizard"),
  UNASSIGN_TAGS_WIZARD_TAG_SELECTION("unassign_tags_wizard_tag_selection"),
  UNASSIGN_TAGS_WIZARD_OBJ_SELECtION("unassign_tags_wizard_object_selection"),
  IMPORT_TAGS_WIZARD("import_tags_wizard"),
  IMPORT_TAGS_SOURCE_SELECTION("import_tags_wiz_source_sel"),
  IMPORT_TAGS_CONTENT_SELECTION("import_tags_wiz_content_sel"),
  EXPORT_TAGS_WIZARD("export_tags_wizard"),
  EXPORT_TAGS_WIZARD_CONTENT_SEL("export_tags_wizard_content_sel"),
  TAG_MANAGER("tag_manager"),
  OBJECT_TAGS("object_tags"),
  TAGGED_OBJECT_SEARCH("tagged_object_search");

  private final String helpContextId;

  HelpContexts(final String contextId) {
    helpContextId = contextId;
  }

  public String getHelpContextId() {
    return helpContextId;
  }
}
