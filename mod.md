# General World Additions

* **Califer:**
  * **Califer Base Items:** Califer Shard, Califer Dust.
  * **Califer Growth Stages:** Small, Medium, Large Buds, and Cluster.
  * **Califer Spawner:** Crystallizing Califerine.
  * **Califer Building Blocks:** Califerine, Stellar Califerine, Astral Califerine.
  * **Radiant Califerine:** Interactive light block (toggled by inserting/extracting a Shard).

* **Cerisium:** Ultra-rare, deep cherry-red gem.

* **Dusting Table:** Used for crushing raw ores into dusts and mixing components.

* **Forge:** Used for smelting base ingots and dusts into high-tier alloys.

---

# Civilizations

## The High Table

### Cities & Structures:
* **Sky City:** Aurealis, the Pristine City. - Extra Rare Structure, only found in the Aurelean Heights Biome (Mushroom Island remix)
* **Ground City:** Aethelgard. - Rare Structure only in Sun Bathed Plains
* **Prefectures:** Walled small towns - Selected Biomes only

### Blocks:
* **Flora:** Sun-Silk Birch (White bark, shifting pink/gold foliage).
* **Base Architecture:** Luminite. Diorite remix.
* **Accent Blocks:** Gem-inlaid Luminite variants (Califer, Amethyst, Cerisium, Emerald, Diamond, Gilded).

### Biomes:
* **Sun Bathed Plains:** Yellow remix of the plains biome.
* **Gilded Canopy:** Yellowy forest of the Sun-Silk Birch.
* **Aurelean Heights:** The Floating Islands, home of Aurealis, the Pristine City.

## The Umbral Vanguards

### Cities & Structures:
* **Stronghold:** Noxalis, the Veiled Citadel. Only found Rarely in Eclipse Highlands
* **Settlements:** Decentralized camps and hidden villages beneath towering canopies.
  * **Encampments:** Small military / scouting camps - any biome.
  * **Townships:** Slightly bigger than villages - Twilight Canopy biomes only.

### Blocks:
* **Flora:** Dusk Redwood (Massive trunks, deep twilight-colored coniferous foliage).
* **Base Architecture:** Nyxite. Andesite remix.
* **Accent Blocks:** Gem-inlaid Nyxite variants (Califer, Amethyst, Cerisium, Emerald, Diamond, Gilded).

### Biomes:
* **Twilight Canopy:** Dusk Redwood forests.
* **Eclipse Highlands:** Snowy Mountains made of Nyxite.

---

# Progression Overhaul & Metallurgy

## Armor & Tool Tiers

* **Tier 1 (Leather):** Explicit base survival gear.
* **Tier 2 (Iron):** Explicit base metal, nerfed to vanilla chainmail stats.
* **Tier 3 (Galvanized Iron):** Forged from 1 Iron Ingot + 1 Copper Dust. *(Restores Vanilla Iron stats, or slightly worse).*
* **Tier 4 (Steel):** Forged from 1 Iron Ingot + 1 Carbon Dust.
  * *Dusting Table Recipe:* 6 Coal + 1 Bone Meal = 2 Carbon Dust.

* **Tier 5 (Better Steels):** The Progression Split.
    * **Califer Steel** (Steel Ingot + Califer Dust): High enchantability, good for tools, same defense as Steel but better durability.
    * **Diamond Steel** (Steel Ingot + Diamond Dust): Better damage and durability, but poor enchantability.

* **Tier 6 (The Faction/Dimension Upgrades):**
  * **Aristocrat's Alloy** (Califer Steel + Emerald Dust + Gold Dust): Keeps Califer properties, grants passive *Hero of the Village* status.
  * **Netherite Gear** (Diamond Steel + Netherite Dust): Heavy tank/combat gear.
    * *Netherite Dust Recipe:* 1 Ancient Debris Dust + 1 Gold Dust (While making Netherite much more accessible than Vanilla).

* **Tier 7 (Cerisian Steel):** The definitive convergence. Upgraded via Smithing Table using Netherite Gear + Upgrade Template + Califer Steel + Cerisium Dust. *(Balancing of recipe and final stats TBD).*

## Recipes

* ### Dusting Table:

  * Basic Conversions:  
    ```
    [ 1x Copper Ingot ]  ➔ [ 1x Copper Dust ]  
    [ 1x Gold Ingot ]    ➔ [ 1x Gold Dust ]  
    [ 1x Diamond ]       ➔ [ 1x Diamond Dust ]  
    [ 1x Emerald ]       ➔ [ 1x Emerald Dust ] 
    [ 1x Califer Shard ] ➔ [ 1x Califer Dust ]  
    [ 1x Cerisium ]      ➔ [ 1x Cerisium Dust ]  
    [ 1x Debris Bloom ]  ➔ [ 1x Debris Dust ] *Replaces Netherite Scrap
    ```
  * Combinations:
    ```
    [ 6x Coal ]        + [ 1x Bone Meal ]    ➔ [ 2x Carbon Dust ]
    [ 1x Gold Dust ]   + [ 1x Emerald Dust ] ➔ [ 2x Opulent Dust ]
    [ 1x Debris Dust ] + [ 1x Gold Dust ]    ➔ [ 1x Netherite Dust ]
    ```

* ### Forge:

  Template: [ Ingot ] + [ Dust ] ➔ [ Alloyed Ingot ]
  ```txt
  [ 1x Iron Ingot ]          + [ 1x Copper Dust ]    ➔ [ 1x Galvanized Iron Ingot ]
  [ 1x Iron Ingot ]          + [ 1x Carbon Dust ]    ➔ [ 1x Steel Ingot ]
  [ 1x Steel Ingot ]         + [ 1x Califer Dust ]   ➔ [ 1x Califer Steel Ingot ]
  [ 1x Steel Ingot ]         + [ 1x Diamond Dust ]   ➔ [ 1x Diamond Steel Ingot ]
  [ 1x Califer Steel Ingot ] + [ 1x Opulent Dust ]   ➔ [ 1x Aristocrat Steel Ingot ]
  [ 1x Diamond Steel Ingot ] + [ 1x Netherite Dust ] ➔ [ 1x Netherite Steel Ingot ]
  [ 1x Califer Steel Ingot ] + [ 1x Cerisium Dust ]  ➔ [ 1x Cerisium Steel Ingot ]
  ```
* ### Smithing Table:

  ```text
  ┌───────────────────┬─────────────────────────────────────────────────────┐
  │ Upgrade Template  │ Cerisian Upgrade Template (Replaces Vanilla)        │
  │ Base Item         │ Netherite Gear (Armor/Tool)                         │
  │ Material          │ 1x Cerisium Steel Ingot                             │
  └───────────────────┴─────────────────────────────────────────────────────┘
                                           ▼
                               [ TIER 7: CERISIAN GEAR ]
  ```
---

# Development Notes & Future Footnotes

## Notes
* **1.0 Mob Plan:** Custom entities will not be coded for the initial release. Vanilla Villagers will handle trade mechanics in High Table settlements, and vanilla Illagers will serve as placeholders for the Umbral Vanguards until full custom AI and mobs are added in a future phase.
* **Future Expansion Concept (Ice Region):** A standalone add-on featuring a frozen ship-graveyard biome. Lore-wise, this marks where the Umbral Vanguards' grand naval armada froze and failed during their siege on the sky city. This expansion will introduce ice-themed alloys and unique frost armors. Or something idk its an idea.

## Mod Plans
The mod will be divided in 4 sub-mods:
* **Quill's Inkwell:** Library mod, adding the new ores and functional blocks.
* **Quill's Book of Metallurgy:** Utilizing the new ores and functional blocks while reworking the progression.
* **Quill's Chronicles: Aurelean Heights:** The High Table's civilisation.
* **Quill's Chronicles: Eclipse Highlands:** The Umbral Vanguards' civilisation.
* Possible additions: `Quill's Chronicles | Extended`