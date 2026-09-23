package com.quill.epilogue.inkwell.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class DustingTableScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    // Client-side constructor
    public DustingTableScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(5));
    }

    // Server-side constructor
    public DustingTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(InkwellScreens.DUSTING_TABLE_SCREEN_HANDLER, syncId);
        checkSize(inventory, 5);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

		// 2x2 Input Grid
		this.addSlot(new Slot(inventory, 0, 39, 26));
		this.addSlot(new Slot(inventory, 1, 57, 26));
		this.addSlot(new Slot(inventory, 2, 39, 44));
		this.addSlot(new Slot(inventory, 3, 57, 44));

		// Output Slot
		this.addSlot(new DustingResultSlot(playerInventory.player, inventory, 4, 124, 35));

        // Player Inventory (Standard 176x166 spacing)
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        // Player Hotbar
        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        // Shift-click logic can be added here later
        return ItemStack.EMPTY;
    }
}