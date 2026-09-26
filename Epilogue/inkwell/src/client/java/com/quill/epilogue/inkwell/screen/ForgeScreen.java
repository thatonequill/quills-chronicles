package com.quill.epilogue.inkwell.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ForgeScreen extends HandledScreen<ForgeScreenHandler> {
	private static final Identifier TEXTURE = Identifier.of("inkwell", "textures/gui/container/forge_gui.png");

	// 1.21.1 Sprite Identifiers
	private static final Identifier LIT_PROGRESS = Identifier.of("inkwell", "container/forge/lit_progress");
	private static final Identifier BURN_PROGRESS = Identifier.of("inkwell", "container/forge/burn_progress");

	public ForgeScreen(ForgeScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}

	@Override
	protected void init() {
		super.init();
		this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
	}

	@Override
	protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (width - backgroundWidth) / 2;
		int y = (height - backgroundHeight) / 2;

		// Draw the static background frame
		context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

		// Draw the modern isolated fire sprite
		if (handler.isCrafting()) {
			int scaledFuel = handler.getScaledFuelProgress();
			// drawGuiTexture(Identifier, textureWidth, textureHeight, u, v, x, y, width,
			// height)
			context.drawGuiTexture(LIT_PROGRESS, 14, 14, 0, 14 - scaledFuel, x + 36, y + 37 + 14 - scaledFuel, 14,
					scaledFuel);
		}

		// Draw the modern isolated arrow sprite
		int scaledProgress = handler.getScaledProgress();
		if (scaledProgress > 0) {
			context.drawGuiTexture(BURN_PROGRESS, 24, 16, 0, 0, x + 79, y + 34, scaledProgress, 16);
		}
	}

	@Override
	public void render(DrawContext context, int mouseX, int mouseY, float delta) {
		renderBackground(context, mouseX, mouseY, delta);
		super.render(context, mouseX, mouseY, delta);
		drawMouseoverTooltip(context, mouseX, mouseY);
	}
}