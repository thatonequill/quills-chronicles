package com.quill.epilogue.inkwell.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InkwellItems {
    // Core Items
    public static final Item CALIFER_SHARD = new Item(new Item.Settings());
    public static final Item CERISIUM_GEM = new Item(new Item.Settings());
    public static final Item FIREBRICK = new Item(new Item.Settings());

    // Master Dust Library
    public static final Item CARBON_DUST = new Item(new Item.Settings());
    public static final Item CALIFER_DUST = new Item(new Item.Settings());
    public static final Item OPULENT_DUST = new Item(new Item.Settings());
    public static final Item CERISIUM_DUST = new Item(new Item.Settings());

    public static final Item AMETHYST_DUST = new Item(new Item.Settings());
    public static final Item REDSTONE_DUST = new Item(new Item.Settings());
    public static final Item LAPIS_DUST = new Item(new Item.Settings());
    public static final Item QUARTZ_DUST = new Item(new Item.Settings());

    public static final Item COPPER_DUST = new Item(new Item.Settings());
    public static final Item IRON_DUST = new Item(new Item.Settings());
    public static final Item GOLD_DUST = new Item(new Item.Settings());
    public static final Item DIAMOND_DUST = new Item(new Item.Settings());
    public static final Item EMERALD_DUST = new Item(new Item.Settings());
    public static final Item DEBRIS_DUST = new Item(new Item.Settings());
    public static final Item NETHERITE_DUST = new Item(new Item.Settings());

    public static void initialize() {
        // Core Gems & Shards
        register("califer_shard", CALIFER_SHARD);
        register("cerisium_gem", CERISIUM_GEM);
        register("firebrick", FIREBRICK);

        // Master Dust Library
        register("carbon_dust", CARBON_DUST);
        register("califer_dust", CALIFER_DUST);
        register("opulent_dust", OPULENT_DUST);
        register("cerisium_dust", CERISIUM_DUST);

        register("amethyst_dust", AMETHYST_DUST);
        register("lapis_dust", LAPIS_DUST);
        register("redstone_dust", REDSTONE_DUST);
        register("quartz_dust", QUARTZ_DUST);
        
        register("copper_dust", COPPER_DUST);
        register("iron_dust", IRON_DUST);
        register("gold_dust", GOLD_DUST);
        register("diamond_dust", DIAMOND_DUST);
        register("emerald_dust", EMERALD_DUST);
        register("debris_dust", DEBRIS_DUST);
        register("netherite_dust", NETHERITE_DUST);
    }

    private static void register(String name, Item item) {
        Registry.register(Registries.ITEM, Identifier.of("inkwell", name), item);
    }
}