package com.quill.epilogue.inkwell.item;

import com.quill.epilogue.inkwell.block.InkwellBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class InkwellItemGroups {
    public static final ItemGroup INKWELL_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of("inkwell", "inkwell_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.inkwell.inkwell_group"))
                    .icon(() -> new ItemStack(InkwellItems.CALIFER_SHARD))
                    .entries((displayContext, entries) -> {
                        // Core Items
                        entries.add(InkwellItems.CALIFER_SHARD);
                        entries.add(InkwellItems.CERISIUM_GEM);
                        entries.add(InkwellItems.FIREBRICK);

                        // Dusts
                        entries.add(InkwellItems.CALIFER_DUST);
                        entries.add(InkwellItems.CERISIUM_DUST);
                        entries.add(InkwellItems.CARBON_DUST);
                        entries.add(InkwellItems.COPPER_DUST);
                        entries.add(InkwellItems.GOLD_DUST);
                        entries.add(InkwellItems.DIAMOND_DUST);
                        entries.add(InkwellItems.EMERALD_DUST);
                        entries.add(InkwellItems.OPULENT_DUST);
                        entries.add(InkwellItems.DEBRIS_DUST);
                        entries.add(InkwellItems.NETHERITE_DUST);
                        entries.add(InkwellItems.IRON_DUST);
                        entries.add(InkwellItems.LAPIS_DUST);
                        entries.add(InkwellItems.REDSTONE_DUST);
                        entries.add(InkwellItems.QUARTZ_DUST);
                        entries.add(InkwellItems.AMETHYST_DUST);

                        // Growth Stages
                        entries.add(InkwellBlocks.BUDDING_CALIFERINE);
                        entries.add(InkwellBlocks.CALIFER_BUD_SMALL);
                        entries.add(InkwellBlocks.CALIFER_BUD_MEDIUM);
                        entries.add(InkwellBlocks.CALIFER_BUD_LARGE);
                        entries.add(InkwellBlocks.CALIFER_CLUSTER);

                        // Architecture & Storage
                        entries.add(InkwellBlocks.CALIFERINE);
                        entries.add(InkwellBlocks.STELLAR_CALIFERINE);
                        entries.add(InkwellBlocks.ASTRAL_CALIFERINE);
                        entries.add(InkwellBlocks.CERISIUM_BLOCK);

                        // Functional Workstations
                        entries.add(InkwellBlocks.RADIANT_CALIFERINE);
                        entries.add(InkwellBlocks.DUSTING_TABLE);
                        entries.add(InkwellBlocks.FORGE);
                    })
                    .build()
    );

    public static void initialize() {
        // Calling this loads the static fields and registers the group
    }
}