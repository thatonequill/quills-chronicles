package com.quill.epilogue.inkwell.screen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;

public class ForgeScreenHandler extends ScreenHandler {
	private final Inventory inventory;
	private final PropertyDelegate propertyDelegate;

	public static final Identifier EMPTY_STEEL_SLOT = Identifier.of("inkwell", "item/empty_slot_steel");
	public static final Identifier EMPTY_DUST_SLOT = Identifier.of("inkwell", "item/empty_slot_inkwell_dust");

	public ForgeScreenHandler(int syncId, PlayerInventory playerInventory) {
		this(syncId, playerInventory, new SimpleInventory(4), new ArrayPropertyDelegate(4));
	}

	public ForgeScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory,
			PropertyDelegate delegate) {
		super(InkwellScreens.FORGE_SCREEN_HANDLER, syncId);
		this.inventory = inventory;
		this.propertyDelegate = delegate;

		checkSize(inventory, 4);
		inventory.onOpen(playerInventory.player);

		// Input 1 (Steel/Ingots)
		this.addSlot(new Slot(inventory, 0, 18, 17) {
			@Override
			public Pair<Identifier, Identifier> getBackgroundSprite() {
				return Pair.of(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, EMPTY_STEEL_SLOT);
			}
		});

		// Input 2 (Dusts)
		this.addSlot(new Slot(inventory, 1, 54, 17) {
			@Override
			public Pair<Identifier, Identifier> getBackgroundSprite() {
				return Pair.of(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, EMPTY_DUST_SLOT);
			}
		});

		// Input 3 (Fuel)
		this.addSlot(new Slot(inventory, 2, 36, 53));

		// Output
		this.addSlot(new Slot(inventory, 3, 116, 35));

		for (int i = 0; i < 3; ++i) {
			for (int l = 0; l < 9; ++l) {
				this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
			}
		}
		for (int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
		}

		this.addProperties(delegate);
	}

	public int getScaledProgress() {
		int progress = this.propertyDelegate.get(2);
		int maxProgress = this.propertyDelegate.get(3);
		if (maxProgress == 0)
			maxProgress = 200;
		int arrowWidth = 24;
		return progress != 0 ? progress * arrowWidth / maxProgress : 0;
	}

	public int getScaledFuelProgress() {
		int fuelTime = this.propertyDelegate.get(0);
		int maxFuelTime = this.propertyDelegate.get(1);
		if (maxFuelTime == 0)
			maxFuelTime = 200;
		int flameHeight = 14;
		return fuelTime * flameHeight / maxFuelTime;
	}

	public boolean isCrafting() {
		return this.propertyDelegate.get(0) > 0;
	}

	@Override
	public ItemStack quickMove(PlayerEntity player, int invSlot) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}
}