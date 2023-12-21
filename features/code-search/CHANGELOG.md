# Changelog

## [1.9.0] - 2023-11-28

### ABAP Code Search

#### Added

- added possibility to save searches as favorites
- added text filter to search result view

#### Changed

- added descriptions to the filters in the object selection

#### Fixes

- Match count is now updated in List mode also

## [1.8.0] - 2023-05-27

### ABAP Code Search

#### Added

- Adds option to continue a search query that was cancelled or interrupted

#### Changed

- Search Matches in object type Data Definition are now grouped under the contained Entity with its contained camel-case name.
- Behavior definitions are displayed with the name of the corresponding root CDS entity

## [1.6.0] - 2023-04-23

### ABAP Code Search

#### Added

- Adds export function for code search results

## [1.5.0] - 2023-03-27

### ABAP Code Search

#### Added

- Added new context menu actions to result nodes like Run as..., Coverage as...

## [1.4.0] - 2023-02-20

### ABAP Code Search

#### Added

- New preference for controlling some Search Dialog options
- Adds new option Expand Includes for program types, that allows searching of includes of a program
- The Code Search can now be trigger via the context menu of the Search View. This is supported for the following search result pages:
  - Where-Used-List Result
  - ABAP Object Search Result
  - ABAP Object Search Result (DevEpos)
  - ABAP Tagged Object Search Result (DevEpos)

- The Code Search can now be triggered via the context menu of the CDS Analyzer View (ABAP Search and Analysis Tools Plug-in required)
- Enhance filter transfer if Code Search is called from context menu of Project Explorer
- The Code Search Dialog can now also be opened from the following folder types in the Project Explorer:
  - Type Folder (type)
  - Type Group Folder (group)
  - Date (created, month, date)
  - User (owner)
  - Application Component (appl)
  - Package (package)  
    **Info**  
    Only the relevant filters for the Code Search will be transferred to the search dialog.

## [1.3.0] - 2022-10-21

### ABAP Code Search

#### Added

- Show the searched lines of code in the runtime information dialog

## [1.2.0] - 2022-10-19

### ABAP Code Search

#### Added

- Show multiline matches in a custom tooltip in the Code Search result

## [1.1.0] - 2022-03-23

### ABAP Code Search

#### Added

- Integration of **ABAP Tags** into Search Dialog  
  This allows you to restrict the search scope to objects with specific tags
- Open Code Search Dialog from context menu action on Repository Trees  

  **Info**  
  Only the relevant filters for the Code Search will be transferred from the tree configuration to the search dialog.

## [1.0.0] - 2022-03-05

Initial release with following included Added

### ABAP Code Search

New Search Tab ABAP Object search integrated into eclipse Search Dialog.
The initial release supports the following source types

- Classes
- Interfaces
- Programs / Includes
- Function Groups
- Type Groups
- Data Definitions
- Access Controls
- Metadata Extensions
- Simple Transformations
- Behavior Definitions
