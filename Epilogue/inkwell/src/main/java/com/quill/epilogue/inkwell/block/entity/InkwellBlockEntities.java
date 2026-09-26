package com.quill.epilogue.inkwell.block.entity;

import com.quill.epilogue.inkwell.block.InkwellBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InkwellBlockEntities {
    public static final BlockEntityType<DustingTableBlockEntity> DUSTING_TABLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE, Identifier.of("inkwell", "dusting_table_be"),
            FabricBlockEntityTypeBuilder.create(DustingTableBlockEntity::new,
                    InkwellBlocks.DUSTING_TABLE).build());
    public static final BlockEntityType<ForgeBlockEntity> FORGE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("inkwell", "forge_be"),
            FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new, InkwellBlocks.FORGE).build());

    public static void initialize() {
        // Triggers the static registration
    }
}