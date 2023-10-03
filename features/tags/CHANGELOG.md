# Changelog

## [1.11.0] - 2023-xx-xx - Newest Release

### ABAP Tagged Object Search

#### Added

- added possibility to save searches as favorites 
- added text filter to search result view
- local classes/interface of programs and function groups can now be tagged
- enable Object deletion from *Tagged Object Trees* (in Project Explorer View)

#### Fixed

- remove tags from local components via *Tagged Object Trees* (in Project Explorer View)

## [1.10.0] - 2023-05-27

### General Updates

#### Changed

- For objects of type Data Definition the contained Entity names are displayed instead of the upper case DDL name
- For objects of type Behavior Definition the corresponding entity name of the root CDS Entity is shown instead.

## [1.9.0] - 2023-04-22

### ABAP Tagged Object Search

#### Added

- Adds the Select Sub Tree action to the context menu of the tree

### Tag Selection Dialog - Extension in ABAP Code Search

#### Added

- Adds the Select Sub Tree action to the context menu of the tree

### Tag Manager View

#### Fixed

- Fixed minor graphic issue when the filter control was shown/hidden

## [1.8.0] - 2023-04-16

### Wizard to remove Tags from Objects

This wizard gives you an easy way to remove Tags from Repository objects.

### ABAP Tagged Object Search

#### Added

- Added toolbar for tags viewer with actions Expand All, Collapse All, Deselect All
- New shortcut Ctrl+F to jump to filter field from tree

### Tag Manager View

#### Added

- Improved User experience on the tags tree
  - New shortcut Ctrl+ENTER to create new tags
  - New shortcut ENTF to delete a list of selected tags
  - Selection and expandsion levels of folders are kept after a tree refresh

### Tag Objects Wizard

#### Added

- New shortcut Ctrl+F to jump from the tree to filter field on the Tag Selection Page

#### Changed

- Viewer buttons on table/tree controls have been replaced with toolbar controls

## [1.7.0] - 2023-03-27

### Component Tagging

This is a brand new feature that gives you possibility to add Tags to a component of a Repository Object

### ABAP Tagged Object Search

#### Added

- Added new context menu actions to result nodes like Run as..., Coverage as...

## [1.6.0] - 2023-03-17

### Tagged Object Tree

Dynamic Tree, similar to the ABAP Repository Trees that is located in the Project Explorer View (see here for more information).

#### Added

- Lists all tags that have assigned objects (direct or on lower tree levels)
- Upon expanding a node in the tree the assigned tags or objects are loaded on the fly
- Assigned Objects (e.g. Classes, Interfaces, etc.) have context menu entries like Run as, Open with... or Share Link

### Tag Manager View

#### Added

- New deletion dialog for tags → tags can only be deleted now if no more objects are assigned to it or tags on a lower tree level
- New context menu entry Remove assigned Objects that deletes all assigned objects of that node

### Tag Objects Wizard

#### Changed

- Hierarchical tags do no longer require a mandatory parent object
- A hierarchical tags can now be assigned multiple times with different parent objects
- A hierarchical Tag can be assigned with any tagged parent object in the same tree (ascending only)

### Object tags View

#### Added

- Parent objects are now visible as well if an object is tagged with a hierarchical Tag and a parent object was chosen

### ABAP Tagged Object Search

#### Changed

- Browsing of referenced child objects via Parent Tag assignments was removed → Tagged Object Tree should be used instead

## [1.3.0] - 2022-03-05

### Technical Changes

- Minimum execution environment changed to JavaSE-11

### Updates for all plugins

#### Added

- The Preferences and Views are now grouped under the name DevEpos

## [1.2.0] - 2021-04-21

### Updates for all plugins

#### Added

- Added DevEpos branding in eclipse About dialog.

## [1.1.0] - 2021-04-19

### Tag Manager View

#### Added

- Renamed from Tags
- Create Shared Tags by assigning User Tags to one or several other users

### Tag Objects Wizard

#### Added

- Tag objects with Shared Tags

### Object Tags View

#### Added

- Renamed from Tag Explorer

### ABAP Tagged Object Search

#### Added

- Renamed from ABAP Tag Search

## [1.0.0] - 2020-07-12

### ABAP Tags

Plug-in which allows the tagging of repository objects and searching those tagged objects

#### Tags View

View to manage all tags in the currently selected project

#### Tag Objects Wizard

Wizard to tag one or several repository objects

#### Tag Explorer View

View to manage the tags of the currently selected ADT

#### ABAP Tag Search

Search page - integrated into the eclipse Search Dialog - which allows the searching for tagged objects
