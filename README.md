# Quills Chronicles: Epilogue & Chapter 1

A modular Minecraft 1.21.1 Fabric overhaul suite.

## The Modules
* **Inkwell:** The core library API. Contains foundational items, blocks, and functional block logic.
* **Book of Metallurgy:** The progression overhaul. Alters vanilla tool/armor progression, edits vanilla recipes, changes ore generation, overhauls ancient debris drops, and adds new alloys/tools.
* **Aurelean Heights:** Chapter 1 civilization. Adds custom biomes, structures, wood sets, and building blocks.
* **Eclipse Highlands:** Chapter 1 civilization. Adds custom biomes, structures, wood sets, and building blocks.

## Useful Gradle Commands
Run these in the terminal at the root directory to test the mods.

**Boot the Game (Client):**
* `.\gradlew :inkwell:runClient`
* `.\gradlew :book-of-metallurgy:runClient`
* `.\gradlew :aurelean-heights:runClient`
* `.\gradlew :eclipse-highlands:runClient`

**Build the final .jar files for publishing:**
* `.\gradlew build`