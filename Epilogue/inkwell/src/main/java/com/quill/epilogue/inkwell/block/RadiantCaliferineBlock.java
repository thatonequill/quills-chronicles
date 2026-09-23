package com.quill.epilogue.inkwell.block;

import com.quill.epilogue.inkwell.item.InkwellItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RadiantCaliferineBlock extends Block {
    public static final BooleanProperty LIT = Properties.LIT;

    public RadiantCaliferineBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean isLit = state.get(LIT);

        // 1. Turn ON: Block is empty (OFF) and player is holding a Califer Shard
        if (!isLit && stack.isOf(InkwellItems.CALIFER_SHARD)) {
            if (!world.isClient) {
                stack.decrement(1); // Consume 1 shard from the player's hand
                world.setBlockState(pos, state.with(LIT, true));
                world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_CLUSTER_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
            return ItemActionResult.success(world.isClient);
        }

        // 2. Turn OFF: Block has a shard in it (ON), player clicks to remove it
        if (isLit) {
            if (!world.isClient) {
                world.setBlockState(pos, state.with(LIT, false));
                // Spawn the shard in the world on the side the player clicked
                Block.dropStack(world, pos, hit.getSide(), new ItemStack(InkwellItems.CALIFER_SHARD));
                world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
            return ItemActionResult.success(world.isClient);
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    // 3. The Safeguard: Drop the shard if the player breaks the block while it is ON
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock() && state.get(LIT)) {
            Block.dropStack(world, pos, new ItemStack(InkwellItems.CALIFER_SHARD));
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }
}