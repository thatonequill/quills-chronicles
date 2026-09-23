package com.quill.epilogue.inkwell.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class DustingResultSlot extends Slot {
    private final PlayerEntity player;

    public DustingResultSlot(PlayerEntity player, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.player = player;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false; // Prevent putting items into the output
    }

    @Override
    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        // Consume 1 item from each of the 4 input slots
        for (int i = 0; i < 4; i++) {
            ItemStack slotStack = this.inventory.getStack(i);
            if (!slotStack.isEmpty()) {
                this.inventory.removeStack(i, 1);
            }
        }
        super.onTakeItem(player, stack);
    }
}