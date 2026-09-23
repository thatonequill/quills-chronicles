package com.quill.epilogue.inkwell.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class InkwellScreens {
    public static final ScreenHandlerType<DustingTableScreenHandler> DUSTING_TABLE_SCREEN_HANDLER = 
        Registry.register(Registries.SCREEN_HANDLER, Identifier.of("inkwell", "dusting_table"), 
        new ScreenHandlerType<>(DustingTableScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

    public static void initialize() {}
}