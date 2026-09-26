package com.quill.epilogue.inkwell.client;

import com.quill.epilogue.inkwell.block.InkwellBlocks;
import com.quill.epilogue.inkwell.screen.DustingTableScreen;
import com.quill.epilogue.inkwell.screen.ForgeScreen;
import com.quill.epilogue.inkwell.screen.InkwellScreens;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class InkwellClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(InkwellScreens.DUSTING_TABLE_SCREEN_HANDLER, DustingTableScreen::new);
        HandledScreens.register(InkwellScreens.FORGE_SCREEN_HANDLER, ForgeScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderLayer.getCutout(),
                InkwellBlocks.CALIFER_BUD_SMALL,
                InkwellBlocks.CALIFER_BUD_MEDIUM,
                InkwellBlocks.CALIFER_BUD_LARGE,
                InkwellBlocks.CALIFER_CLUSTER);
    }
}