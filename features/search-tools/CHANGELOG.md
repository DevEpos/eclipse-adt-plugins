# Changelog

## [1.11.0] - 2023-xx-xx - Newest Release

### ABAP Object Search

#### Added

- New design for Object Search Dialog
- New architecture to allow for mostly backend-driven approach for the Object Search
- New Search Type "Method"
- New Search Type "Message"
- New filters *changedby*, *changed*, *comp*, *appl* for CDS Search Type
- New filters *changedby*, *changed*, *comp*, *appl*, *enhcat*, *maintflag*, *storetype*, *buffering*, *buffertype*, *dataclass*, *sizecat* for Database Table Search Type
- New filters *changedby*, *changed*, *comp*, *appl* for Class/Interface Search Type

#### Changed

- Search type *Database Table/View* was splitted into search types *Database Table* and *View*
- Increased maximum number of results to 10.000.

### CDS Analysis

#### Added

- New setting to allow recursive loading of results in *Where-Used in CDS-Analysis*
- New text filter option in *Where-Used in CDS-Analysis*
- New option in *Where-Used in CDS-Analysis* to restrict results to sub trees where released entities exist
- New design for Intro of CDS Analysis View

## [1.10.0] - 2023-05-27

### ABAP Object Search

#### Added

- CDS entities of type Projection are now overlayed with a custom icon
- CDS entities of type Hierarchy are now overlayed with a custom icon

## [1.9.0] - 2023-03-27

### ABAP Object Search

#### Added

- Added new context menu actions to result nodes like Run as..., Coverage as...

## [1.7.0] - 2022-08-29

### CDS Analyzer

#### Added

- View settings can now be changed in eclipse preferences
- Settings state is stored together with each analysis result

## [1.6.0] - 2022-08-28

### CDS Analyzer

#### Added

- New command in view toolbar (Run CDS analysis) to run a CDS analysis for a given object
- New command in main toolbar (Run CDS analysis) to run a CDS analysis for a given object
- Added Pin to View action to toolbar
- Added option to open Analysis in new View from the history dialog
- Added option to open Analysis from history dropdown via CTRL+LMouse

## [1.5.0] - 2022-03-05

### Technical Changes

- Minimum execution environment changed to JavaSE-11

### Updates for all plugins

#### Added

- The Preferences and Views are now grouped under the name DevEpos

## [1.4.0] - 2021-04-21

### Updates for all plugins

#### Added

- Added DevEpos branding in eclipse About dialog.

### ABAP Object Search

#### Added

- Add search parameter Delivery class (Owner) in search type Database Table/View

### CDS Analyzer

#### Added

- Enable Show In context (`ALT+SHIFT+W`)

## [1.2.0] - 2019-12-05

### ABAP Object Search

#### Added

- New preference to set the input control which get's the initial focus in the search dialog
- New preference to take the current text selection as Object name in the search dialog

#### Fixed

- Allow negation for parameters param and desc

## [1.1.0] - 2019-12-01

### ABAP Object Search

#### Added

- Added new search type Class/Interface

#### Fixed

- Adds missing search filter validation after project changed

### CDS Analyzer - Where-Used In Analysis

#### Added

- New Setting to control whether all association usages are shown or only those where the association is defined locally

### CDS Analyzer - Top-Down Analysis

#### Added

- Show custom tooltip with the name, description and alias of the current entity under the cursor

### CDS Analyzer - Field Analysis

#### Added

- Add view layout toggle (automatic, horizontal, vertial)

## [1.0.0] - 2019-11-26

Initial release with following included Added

### ABAP Object Search +

Extended ABAP Object search integrated into eclipse Search Dialog.
It currently supports the following object types

- CDS View
- Database Table/View

### CDS Analyzer

View for analyzing CDS View.
The following analyses are possible at the moment

- Top-Down Analysis for CDS Views
- Used-Entities analysis of a CDS View
- Where-Used in CDS View for a CDS View/Database table/Database view
- Field Analysis for a CDS View/Database table/Database view
