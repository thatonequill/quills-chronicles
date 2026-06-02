package com.quill.epilogue.inkwell.item;

import com.quill.epilogue.inkwell.Inkwell;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InkwellItems {

    // 1. Create the copper dust item
    public static final Item COPPER_DUST = registerItem("copper_dust", new Item(new Item.Settings()));

    // Helper method to register it to the game
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Inkwell.MOD_ID, name), item);
    }

    public static void initialize() {
        // 2. Add it to the vanilla Ingredients tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(COPPER_DUST);
        });
    }
}