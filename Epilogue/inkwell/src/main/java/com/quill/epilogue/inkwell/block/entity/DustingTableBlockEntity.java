package com.quill.epilogue.inkwell.block.entity;

import com.quill.epilogue.inkwell.recipe.DustingRecipe;
import com.quill.epilogue.inkwell.recipe.DustingRecipeInput;
import com.quill.epilogue.inkwell.recipe.InkwellRecipes;
import com.quill.epilogue.inkwell.screen.DustingTableScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class DustingTableBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {
    // 5 Slots: 0-3 = 2x2 Input Grid, 4 = Output
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    public DustingTableBlockEntity(BlockPos pos, BlockState state) {
        super(InkwellBlockEntities.DUSTING_TABLE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.inkwell.dusting_table");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new DustingTableScreenHandler(syncId, playerInventory, this);
    }

    private static boolean canInsertItemIntoOutputSlot(ItemStack currentOutput, ItemStack recipeOutput) {
        if (currentOutput.isEmpty()) return true;
        if (!ItemStack.areItemsEqual(currentOutput, recipeOutput)) return false;
        return currentOutput.getCount() + recipeOutput.getCount() <= currentOutput.getMaxCount();
    }

    private static void craftItem(DustingTableBlockEntity entity, DefaultedList<ItemStack> inputs, ItemStack output) {
        // Drain 1 from each input slot that has an item
        for (int i = 0; i < 4; i++) {
            if (!entity.getStack(i).isEmpty()) {
                entity.getStack(i).decrement(1);
            }
        }
        // Spawn the output
        if (entity.getStack(4).isEmpty()) {
            entity.setStack(4, output.copy());
        } else {
            entity.getStack(4).increment(output.getCount());
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();
        if (this.world != null && !this.world.isClient()) {
            updateRecipe();
        }
    }

    private void updateRecipe() {
        if (this.world == null || this.world.isClient()) return;

        // Collect the items from the 2x2 grid (slots 0 to 3)
        net.minecraft.util.collection.DefaultedList<ItemStack> stacks = 
            net.minecraft.util.collection.DefaultedList.ofSize(4, ItemStack.EMPTY);
        for (int i = 0; i < 4; i++) {
            stacks.set(i, this.getStack(i));
        }

        DustingRecipeInput input = new DustingRecipeInput(stacks);
        
        var match = this.world.getRecipeManager().getFirstMatch(InkwellRecipes.DUSTING_TYPE, input, this.world);
        
        ItemStack expectedOutput = ItemStack.EMPTY;
        if (match.isPresent()) {
            expectedOutput = match.get().value().getResult(this.world.getRegistryManager());
        }

        if (!ItemStack.areEqual(this.getStack(4), expectedOutput)) {
            this.setStack(4, expectedOutput.copy());
        }
    }
}