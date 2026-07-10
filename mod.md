``# General World Additions

- **Califer:**
    - **Califer Base Items:** Califer Shard, Califer Dust.
    - **Califer Growth Stages:** Small, Medium, Large Buds, and Cluster.
    - **Califer Spawner:** Crystallizing Califerine.
    - **Califer Building Blocks:** Califerine, Stellar Califerine, Astral Califerine.
    - **Radiant Califerine:** Interactive light block (toggled by inserting/extracting a Shard).

- **Cerisium:** Ultra-rare, deep cherry-red gem.

- **Dusting Table:** Used for crushing raw ores into dusts and mixing components.

- **Forge:** Used for smelting base ingots and dusts into high-tier alloys.

---

# Civilizations

## The High Table

### Cities & Structures:

- **Sky City:** Aurealis, the Pristine City. - Extra Rare Structure, only found in the Aurelean Heights Biome (Mushroom Island remix)
- **Ground City:** Aethelgard. - Rare Structure only in Sun Bathed Plains
- **Prefectures:** Walled small towns - Selected Biomes only

### Blocks:

- **Flora:** Sun-Silk Birch (White bark, shifting pink/gold foliage).
- **Base Architecture:** Luminite. Diorite remix.
- **Accent Blocks:** Gem-inlaid Luminite variants (Califer, Amethyst, Cerisium, Emerald, Diamond, Gilded).

### Biomes:

- **Sun Bathed Plains:** Yellow remix of the plains biome.
- **Gilded Canopy:** Yellowy forest of the Sun-Silk Birch.
- **Aurelean Heights:** The Floating Islands, home of Aurealis, the Pristine City.

## The Umbral Vanguards

### Cities & Structures:

- **Stronghold:** Noxalis, the Veiled Citadel. Only found Rarely in Eclipse Highlands
- **Settlements:** Decentralized camps and hidden villages beneath towering canopies.
    - **Encampments:** Small military / scouting camps - any biome.
    - **Townships:** Slightly bigger than villages - Twilight Canopy biomes only.

### Blocks:

- **Flora:** Dusk Redwood (Massive trunks, deep twilight-colored coniferous foliage).
- **Base Architecture:** Nyxite. Andesite remix.
- **Accent Blocks:** Gem-inlaid Nyxite variants (Califer, Amethyst, Cerisium, Emerald, Diamond, Gilded).

### Biomes:

- **Twilight Canopy:** Dusk Redwood forests.
- **Eclipse Highlands:** Snowy Mountains made of Nyxite.

---

# Progression Overhaul & Metallurgy

## Armor & Tool Tiers

- **Tier 1 (Leather):** Explicit base survival gear.
- **Tier 2 (Iron):** Explicit base metal, nerfed to vanilla chainmail stats.
- **Tier 3 (Galvanized Iron):** Forged from 1 Iron Ingot + 1 Copper Dust. _(Restores Vanilla Iron stats, or slightly worse)._
- **Tier 4 (Steel):** Forged from 1 Iron Ingot + 1 Carbon Dust.
    - _Dusting Table Recipe:_ 6 Coal + 1 Bone Meal = 2 Carbon Dust.

- **Tier 5 (Better Steels):** The Progression Split.
    - **Califer Steel** (Steel Ingot + Califer Dust): High enchantability, good for tools, same defense as Steel but better durability.
    - **Diamond Steel** (Steel Ingot + Diamond Dust): Better damage and durability, but poor enchantability.

- **Tier 6 (The Faction/Dimension Upgrades):**
    - **Aristocrat's Alloy** (Califer Steel + Emerald Dust + Gold Dust): Keeps Califer properties, grants passive _Hero of the Village_ status.
    - **Netherite Gear** (Diamond Steel + Netherite Dust): Heavy tank/combat gear.
        - _Netherite Dust Recipe:_ 1 Ancient Debris Dust + 1 Gold Dust (While making Netherite much more accessible than Vanilla).

- **Tier 7 (Cerisian Steel):** The definitive convergence. Upgraded via Smithing Table using Netherite Gear + Upgrade Template + Califer Steel + Cerisium Dust. _(Balancing of recipe and final stats TBD)._

## Recipes

- ### Dusting Table:
    - Basic Conversions:
        ```
        [ 1x Copper Ingot ]  ➔ [ 1x Copper Dust ]
        [ 1x Gold Ingot ]    ➔ [ 1x Gold Dust ]
        [ 1x Diamond ]       ➔ [ 1x Diamond Dust ]
        [ 1x Emerald ]       ➔ [ 1x Emerald Dust ]
        [ 1x Califer Shard ] ➔ [ 1x Califer Dust ]
        [ 1x Cerisium ]      ➔ [ 1x Cerisium Dust ]
        [ 1x Debris Bloom ]  ➔ [ 1x Debris Dust ] *Replaces Netherite Scrap
        ```
    - Combinations:
        ```
        [ 6x Coal ]        + [ 1x Bone Meal ]    ➔ [ 2x Carbon Dust ]
        [ 1x Gold Dust ]   + [ 1x Emerald Dust ] ➔ [ 2x Opulent Dust ]
        [ 1x Debris Dust ] + [ 1x Gold Dust ]    ➔ [ 1x Netherite Dust ]
        ```

- ### Forge:

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

- ### Smithing Table:

    ```text
    ┌───────────────────┬─────────────────────────────────────────────────────┐
    │ Upgrade Template  │ Cerisian Upgrade Template (Replaces Vanilla)        │
    │ Base Item         │ Netherite Gear (Armor/Tool)                         │
    │ Material          │ 1x Cerisium Steel Ingot                             │
    └───────────────────┴─────────────────────────────────────────────────────┘
                                             ▼
                                 [ TIER 7: CERISIAN GEAR ]
    ```

Forge:
[ Iron Ingot ] [ Firebrick ] [ Iron Ingot ]
[ Firebrick ] [ Blast Furnace ] [ Firebrick ]
[ Brick/Clay ] [ Firebrick ] [ Brick/Clay ]

---

# Development Notes & Future Footnotes

## Notes

- **1.0 Mob Plan:** Custom entities will not be coded for the initial release. Vanilla Villagers will handle trade mechanics in High Table settlements, and vanilla Illagers will serve as placeholders for the Umbral Vanguards until full custom AI and mobs are added in a future phase.
- **Future Expansion Concept (Ice Region):** A standalone add-on featuring a frozen ship-graveyard biome. Lore-wise, this marks where the Umbral Vanguards' grand naval armada froze and failed during their siege on the sky city. This expansion will introduce ice-themed alloys and unique frost armors. Or something idk its an idea.

## Mod Plans

The mod will be divided in 4 sub-mods:

- **Quill's Inkwell:** Library mod, adding the new ores and functional blocks.
- **Quill's Book of Metallurgy:** Utilizing the new ores and functional blocks while reworking the progression.
- **Quill's Chronicles: Aurelean Heights:** The High Table's civilisation.
- **Quill's Chronicles: Eclipse Highlands:** The Umbral Vanguards' civilisation.
- Possible additions: `Quill's Chronicles | Extended`

---

# Texture Asset Production Checklist

## Mod 1: Quill's Inkwell (quills_inkwell)

### Gems and Core Items

- [x] califer_shard.png (Unrefined raw purple shard item)

### Ores and Crystals

- [x] califer_bud_small.png (Cross-model crystal cluster stage 1)
- [x] califer_bud_medium.png (Cross-model crystal cluster stage 2)
- [x] califer_bud_large.png (Cross-model crystal cluster stage 3)
- [x] califer_cluster.png (Full harvestable large crystal cluster block)

### Custom Structural Blocks

- [x] califerine.png (Raw stone block texture)
- [x] stellar_califerine.png (Chiseled/decorative block texture)
- [x] astral_califerine.png (Polished block texture)
- [x] radiant_califerine_off.png (Interactive light block texture unlit state)
- [x] radiant_califerine_on.png (Interactive light block texture glowing state)

### Workstation Blocks

- [ ] dusting_table_top.png (Grid interface/surface texture)
- [ ] dusting_table_side.png (Wooden structural side frame panel)
- [ ] dusting_table_front.png (Front interface panel)
- [ ] dusting_table_bottom.png (Base floor texturing)
- [ ] forge_top.png (Upper heat vents texture)
- [ ] forge_side.png (Heavy stone side panels)
- [ ] forge_front_off.png (Extinguished furnace door panel)
- [ ] forge_front_on.png (Blazing furnace fuel door panel)
- [ ] forge_bottom.png (Ash tray base floor panel)

### Master Dust Library (On-Paper Style)

- [x] carbon_dust.png (Matte black coal blend on parchment)
- [x] copper_dust.png (Ground copper layout on parchment)
- [x] gold_dust.png (Gold flakes layout on parchment)
- [x] diamond_dust.png (Hard diamond shavings on parchment)
- [x] emerald_dust.png (Green currency dust layout on parchment)
- [x] califer_dust.png (Ground glowing purple dust item)
- [ ] opulent_dust.png (Lavish emerald/gold blend layout on parchment)
- [ ] debris_dust.png (Coarse dark debris dust on parchment)
- [x] netherite_dust.png (Heavy refined alloy dust on parchment)
- [x] iron_dust.png (Optional - Raw industrial orange-gray powder on parchment)
- [x] lapis_dust.png (Optional - Deep blue mystical dust layout on parchment)
- [ ] redstone_dust.png (Optional - Fine crystalline red dust layout on parchment)
- [ ] quartz_dust.png (Optional - Sharp, brilliant white Nether quartz dust on parchment)
- [x] amethyst_dust.png (Optional - Sharded violet geode powder on parchment)

---

## Mod 2: Quill's Book of Metallurgy (quills_book_of_metallurgy)

### Metal Ingot Items

- [ ] galvanized_iron_ingot.png (Copper-tinted iron bar)
- [ ] steel_ingot.png (Dark, sleek gunmetal gray bar)
- [ ] califer_steel_ingot.png (Steel bar accented with magical purple veins)
- [ ] diamond_steel_ingot.png (Ultra-dense steel bar with reflective diamond sheen)
- [ ] aristocrat_steel_ingot.png (Lavish, royal golden-green alloy bar)
- [ ] netherite_steel_ingot.png (Heavy, blackened blast-resistant combat bar)
- [ ] cerisium_steel_ingot.png (Shimmering crimson-red endgame alloy bar)

### Galvanized Iron Gear

- [ ] galvanized_iron_helmet.png
- [ ] galvanized_iron_chestplate.png
- [ ] galvanized_iron_leggings.png
- [ ] galvanized_iron_boots.png
- [ ] galvanized_iron_sword.png
- [ ] galvanized_iron_pickaxe.png
- [ ] galvanized_iron_axe.png
- [ ] galvanized_iron_shovel.png
- [ ] galvanized_iron_hoe.png
- [ ] galvanized_iron_layer_1.png (Armor model outer)
- [ ] galvanized_iron_layer_2.png (Armor model inner leggings)

### Steel Gear

- [ ] steel_helmet.png
- [ ] steel_chestplate.png
- [ ] steel_leggings.png
- [ ] steel_boots.png
- [ ] steel_sword.png
- [ ] steel_pickaxe.png
- [ ] steel_axe.png
- [ ] steel_shovel.png
- [ ] steel_hoe.png
- [ ] steel_layer_1.png (Armor model outer)
- [ ] steel_layer_2.png (Armor model inner leggings)

### Califer Steel Gear

- [ ] califer_steel_helmet.png
- [ ] califer_steel_chestplate.png
- [ ] califer_steel_leggings.png
- [ ] califer_steel_boots.png
- [ ] califer_steel_sword.png
- [ ] califer_steel_pickaxe.png
- [ ] califer_steel_axe.png
- [ ] califer_steel_shovel.png
- [ ] califer_steel_hoe.png
- [ ] califer_steel_layer_1.png (Armor model outer)
- [ ] califer_steel_layer_2.png (Armor model inner leggings)

### Diamond Steel Gear

- [ ] diamond_steel_helmet.png
- [ ] diamond_steel_chestplate.png
- [ ] diamond_steel_leggings.png
- [ ] diamond_steel_boots.png
- [ ] diamond_steel_sword.png
- [ ] diamond_steel_pickaxe.png
- [ ] diamond_steel_axe.png
- [ ] diamond_steel_shovel.png
- [ ] diamond_steel_hoe.png
- [ ] diamond_steel_layer_1.png (Armor model outer)
- [ ] diamond_steel_layer_2.png (Armor model inner leggings)

### Aristocrat Steel Gear

- [ ] aristocrat_steel_helmet.png
- [ ] aristocrat_steel_chestplate.png
- [ ] aristocrat_steel_leggings.png
- [ ] aristocrat_steel_boots.png
- [ ] aristocrat_steel_sword.png
- [ ] aristocrat_steel_pickaxe.png
- [ ] aristocrat_steel_axe.png
- [ ] aristocrat_steel_shovel.png
- [ ] aristocrat_steel_hoe.png
- [ ] aristocrat_steel_layer_1.png (Armor model outer)
- [ ] aristocrat_steel_layer_2.png (Armor model inner leggings)

### Cerisian Steel Gear

- [ ] cerisian_steel_helmet.png
- [ ] cerisian_steel_chestplate.png
- [ ] cerisian_steel_leggings.png
- [ ] cerisian_steel_boots.png
- [ ] cerisian_steel_sword.png
- [ ] cerisian_steel_pickaxe.png
- [ ] cerisian_steel_axe.png
- [ ] cerisian_steel_shovel.png
- [ ] cerisian_steel_hoe.png
- [ ] cerisian_steel_layer_1.png (Armor model outer)
- [ ] cerisian_steel_layer_2.png (Armor model inner leggings)

---

## Mod 3: Quill's Chronicles: Aurelean Heights (quills_chronicles_aurelean_heights)

### Sun-Silk Birch Woodset

- [ ] sun_silk_leaves.png (Shifting pink/gold leaf layout with high transparency cutouts)
- [ ] sun_silk_log_side.png (Clean pristine white bark layout)
- [ ] sun_silk_log_top.png (Golden inner tree ring core texture)
- [ ] stripped_sun_silk_log_side.png (Exposed golden barkless trunk sides)
- [ ] stripped_sun_silk_log_top.png (Stripped inner wood log ends)
- [ ] sun_silk_planks.png (Finished construction wood planks texture)
- [ ] sun_silk_sapling.png (Sprite icon item block)
- [ ] sun_silk_door_upper.png (Upper door block layout)
- [ ] sun_silk_door_lower.png (Lower door block layout)
- [ ] sun_silk_trapdoor.png (Carved cutout window shutter hatch block)

### Luminite Block Palace Set

- [ ] luminite.png (Smooth white architectural diorite style base block)
- [ ] gilded_luminite.png (Polished base block banded in real gold trim)
- [ ] califer_inlaid_luminite.png (Luminite set with raw glowing califer crystals)
- [ ] amethyst_inlaid_luminite.png (Luminite set embedded with polished amethysts)
- [ ] cerisium_inlaid_luminite.png (Luminite set sporting rare blood-red cerisium gems)
- [ ] emerald_inlaid_luminite.png (Luminite set showing green mosaic brick shards)
- [ ] diamond_inlaid_luminite.png (Luminite set reflecting uncut sky-blue diamonds)

---

## Mod 4: Quill's Chronicles: Eclipse Highlands (quills_chronicles_eclipse_highlands)

### Dusk Redwood Woodset

- [ ] dusk_redwood_leaves.png (Highly detailed, feathery, multi-holed needle leaf texture)
- [ ] dusk_redwood_log_side.png (Deep weathered brown coarse conifer bark sides)
- [ ] dusk_redwood_log_top.png (Midnight purple tinted inner heartwood ring tree core)
- [ ] stripped_dusk_redwood_log_side.png (Stripped purple wood side texture)
- [ ] stripped_dusk_redwood_log_top.png (Stripped core log top ends)
- [ ] dusk_redwood_planks.png (Rich twilight purple hued finished wood planks texture)
- [ ] dusk_redwood_sapling.png (Spire conifer pine style cross sprite item)
- [ ] dusk_redwood_door_upper.png (Reinforced iron banded upper door texture)
- [ ] dusk_redwood_door_lower.png (Reinforced iron banded lower door texture)
- [ ] dusk_redwood_trapdoor.png (Heavy slotted slatted bunker hatch block)

### Nyxite Mountain Citadel Set

- [ ] nyxite.png (Raw dark gray andesite style volcanic base stone block)
- [ ] gilded_nyxite.png (Dark base stone etched with crude running golden veins)
- [ ] califer_inlaid_nyxite.png (Dark brick embedded with striking purple califer gems)
- [ ] amethyst_inlaid_nyxite.png (Dark brick displaying contrasting violet crystals)
- [ ] cerisium_inlaid_nyxite.png (Dark brick bleeding deep cherry red crystal lines)
- [ ] emerald_inlaid_nyxite.png (Dark brick set with raw glowing green minerals)
- [ ] diamond_inlaid_nyxite.png (Dark brick holding highly bright stark white diamond shards)

### 💎 Cerisium Suite (Chapter 1 Core Gem)

- [x] `cerisium_gem.png` (Artisan-perfect, heavy 32x32 spherical Cherry Cut jewel)
- [x] `cerisium_dust.png` (Ground pure gem powder item)
- [ ] `nyxite_cerisium_ore.png` (Red cabochon domes embedded in dark volcanic Nyxite)
- [ ] `luminite_cerisium_ore.png` (Red cabochon domes embedded in pristine white Luminite)
- [ ] `cerisium_block.png` (Pending - Storage/Vault block)
