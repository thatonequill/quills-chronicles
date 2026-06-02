package com.quill.epilogue.inkwell;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.quill.epilogue.inkwell.item.InkwellItems;

public class Inkwell implements ModInitializer {
	public static final String MOD_ID = "inkwell";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Inkwell Library...");

		// Add this line to trigger the item registration
		InkwellItems.initialize();
	}
}