package com.quill.epilogue.inkwell.block.entity;

import com.quill.epilogue.inkwell.block.ForgeBlock;
import com.quill.epilogue.inkwell.item.InkwellItems; // Ensure this matches your item registry class
import com.quill.epilogue.inkwell.screen.ForgeScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ForgeBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
	private final SimpleInventory inventory = new SimpleInventory(4) {
		@Override
		public void markDirty() {
			super.markDirty();
			ForgeBlockEntity.this.markDirty();
		}
	};

	protected final PropertyDelegate propertyDelegate;
	private int burnTime = 0;
	private int maxBurnTime = 0;
	private int progress = 0;
	private int maxProgress = 200;

	public ForgeBlockEntity(BlockPos pos, BlockState state) {
		super(InkwellBlockEntities.FORGE, pos, state);
		this.propertyDelegate = new PropertyDelegate() {
			public int get(int index) {
				return switch (index) {
					case 0 -> ForgeBlockEntity.this.burnTime;
					case 1 -> ForgeBlockEntity.this.maxBurnTime;
					case 2 -> ForgeBlockEntity.this.progress;
					case 3 -> ForgeBlockEntity.this.maxProgress;
					default -> 0;
				};
			}

			public void set(int index, int value) {
				switch (index) {
					case 0 -> ForgeBlockEntity.this.burnTime = value;
					case 1 -> ForgeBlockEntity.this.maxBurnTime = value;
					case 2 -> ForgeBlockEntity.this.progress = value;
					case 3 -> ForgeBlockEntity.this.maxProgress = value;
				}
			}

			public int size() {
				return 4;
			}
		};
	}

	@Override
	public Text getDisplayName() {
		return Text.translatable("block.inkwell.forge");
	}

	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		return new ForgeScreenHandler(syncId, playerInventory, this.inventory, this.propertyDelegate);
	}

	public static void tick(World world, BlockPos pos, BlockState state, ForgeBlockEntity entity) {
		if (world.isClient)
			return;

		boolean isBurning = entity.burnTime > 0;
		boolean dirty = false;

		if (isBurning) {
			entity.burnTime--;
		}

		ItemStack ingotSlot = entity.inventory.getStack(0);
		ItemStack dustSlot = entity.inventory.getStack(1);
		ItemStack fuelSlot = entity.inventory.getStack(2);
		ItemStack outputSlot = entity.inventory.getStack(3);

		// Dummy Test Recipe Check
		boolean hasRecipe = ingotSlot.isOf(Items.IRON_INGOT) && dustSlot.isOf(InkwellItems.COPPER_DUST);

		// Ensure the output slot is either empty or has room for more Firebricks
		boolean canOutput = outputSlot.isEmpty() ||
				(outputSlot.isOf(InkwellItems.FIREBRICK) && outputSlot.getCount() < outputSlot.getMaxCount());

		if (hasRecipe && canOutput) {
			// Consume fuel
			if (entity.burnTime <= 0 && !fuelSlot.isEmpty()) {
				entity.burnTime = 1600; // Standard coal burn time
				entity.maxBurnTime = entity.burnTime;
				fuelSlot.decrement(1);
				dirty = true;
			}

			// Process recipe
			if (entity.burnTime > 0) {
				entity.progress++;
				if (entity.progress >= entity.maxProgress) {
					entity.progress = 0;

					// Consume ingredients
					ingotSlot.decrement(1);
					dustSlot.decrement(1);

					// Generate output
					if (outputSlot.isEmpty()) {
						entity.inventory.setStack(3, new ItemStack(InkwellItems.FIREBRICK, 1));
					} else {
						outputSlot.increment(1);
					}
					dirty = true;
				}
			} else {
				entity.progress = 0;
			}
		} else {
			// Reset progress if items are removed or output is full
			entity.progress = 0;
		}

		if (isBurning != (entity.burnTime > 0)) {
			dirty = true;
			world.setBlockState(pos, state.with(ForgeBlock.LIT, entity.burnTime > 0));
		}

		if (dirty) {
			entity.markDirty();
		}
	}
}