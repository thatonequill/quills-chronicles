package com.quill.epilogue.inkwell;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.quill.epilogue.inkwell.item.InkwellItems;
import com.quill.epilogue.inkwell.item.InkwellItemGroups;
import com.quill.epilogue.inkwell.block.InkwellBlocks;
import com.quill.epilogue.inkwell.block.entity.InkwellBlockEntities;
import com.quill.epilogue.inkwell.recipe.InkwellRecipes;
import com.quill.epilogue.inkwell.screen.InkwellScreens;

public class Inkwell implements ModInitializer {
	public static final String MOD_ID = "quills_inkwell";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[init] Initializing Inkwell Library...");

		LOGGER.info("[init] Items...");
		InkwellItems.initialize();

		LOGGER.info("[init] Blocks...");
		InkwellBlocks.registerBlocks();

		LOGGER.info("[init] Block Entities...");
		InkwellBlockEntities.initialize();

		LOGGER.info("[init] Item Groups...");
		InkwellItemGroups.initialize();

		LOGGER.info("[init] Recipes...");
		InkwellRecipes.initialize();

		LOGGER.info("[init] Screens...");
		InkwellScreens.initialize();
	}
}