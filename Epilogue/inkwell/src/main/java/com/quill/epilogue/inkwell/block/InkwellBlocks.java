package com.quill.epilogue.inkwell.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InkwellBlocks {
    
    // Califerine Crystals & Growth Stages
    public static final Block BUDDING_CALIFERINE = new Block(AbstractBlock.Settings.copy(Blocks.BUDDING_AMETHYST));
    public static final Block CALIFER_BUD_SMALL = new Block(AbstractBlock.Settings.copy(Blocks.SMALL_AMETHYST_BUD));
    public static final Block CALIFER_BUD_MEDIUM = new Block(AbstractBlock.Settings.copy(Blocks.MEDIUM_AMETHYST_BUD));
    public static final Block CALIFER_BUD_LARGE = new Block(AbstractBlock.Settings.copy(Blocks.LARGE_AMETHYST_BUD));
    public static final Block CALIFER_CLUSTER = new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER));

    // Custom Structural Blocks
    public static final Block CALIFERINE = new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK));
    public static final Block STELLAR_CALIFERINE = new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK));
    public static final Block ASTRAL_CALIFERINE = new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK));
    
    // Storage Blocks
    public static final Block CERISIUM_BLOCK = new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK));

    // Functional Blocks
    public static final Block RADIANT_CALIFERINE = new RadiantCaliferineBlock(
        AbstractBlock.Settings.copy(Blocks.REDSTONE_LAMP)
        .luminance(state -> state.get(RadiantCaliferineBlock.LIT) ? 15 : 0)
    );
    public static final Block FORGE = new ForgeBlock(
        AbstractBlock.Settings.copy(Blocks.BLAST_FURNACE)
        .luminance(state -> state.get(ForgeBlock.LIT) ? 13 : 0)
    );
    public static final Block DUSTING_TABLE = new DustingTableBlock(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE));

    public static void registerBlocks() {
        register("budding_califerine", BUDDING_CALIFERINE);
        register("califer_bud_small", CALIFER_BUD_SMALL);
        register("califer_bud_medium", CALIFER_BUD_MEDIUM);
        register("califer_bud_large", CALIFER_BUD_LARGE);
        register("califer_cluster", CALIFER_CLUSTER);

        register("califerine", CALIFERINE);
        register("stellar_califerine", STELLAR_CALIFERINE);
        register("astral_califerine", ASTRAL_CALIFERINE);
        
        register("cerisium_block", CERISIUM_BLOCK);

        register("radiant_califerine", RADIANT_CALIFERINE);
        register("dusting_table", DUSTING_TABLE);
        register("forge", FORGE);
    }

    private static void register(String name, Block block) {
        Identifier id = Identifier.of("inkwell", name);
        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
    }
}