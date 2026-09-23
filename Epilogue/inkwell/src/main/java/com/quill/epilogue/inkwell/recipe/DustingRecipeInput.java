package com.quill.epilogue.inkwell.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.util.collection.DefaultedList;

public record DustingRecipeInput(DefaultedList<ItemStack> slots) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return slots.get(slot);
    }

    @Override
    public int getSize() {
        return 4; // 2x2 grid
    }
}