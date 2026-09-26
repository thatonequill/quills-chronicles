package com.quill.epilogue.inkwell.block;

import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BuddingCaliferineBlock extends Block {
	public BuddingCaliferineBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (random.nextInt(5) != 0)
			return; // 20% chance to grow per random tick

		Direction direction = Direction.random(random);
		BlockPos targetPos = pos.offset(direction);
		BlockState targetState = world.getBlockState(targetPos);

		Block block = null;
		if (canGrowIn(targetState)) {
			block = InkwellBlocks.CALIFER_BUD_SMALL;
		} else if (targetState.isOf(InkwellBlocks.CALIFER_BUD_SMALL)
				&& targetState.get(AmethystClusterBlock.FACING) == direction) {
			block = InkwellBlocks.CALIFER_BUD_MEDIUM;
		} else if (targetState.isOf(InkwellBlocks.CALIFER_BUD_MEDIUM)
				&& targetState.get(AmethystClusterBlock.FACING) == direction) {
			block = InkwellBlocks.CALIFER_BUD_LARGE;
		} else if (targetState.isOf(InkwellBlocks.CALIFER_BUD_LARGE)
				&& targetState.get(AmethystClusterBlock.FACING) == direction) {
			block = InkwellBlocks.CALIFER_CLUSTER;
		}

		if (block != null) {
			BlockState newState = block.getDefaultState()
					.with(AmethystClusterBlock.FACING, direction)
					.with(AmethystClusterBlock.WATERLOGGED, targetState.getFluidState().isStill());
			world.setBlockState(targetPos, newState);
		}
	}

	private static boolean canGrowIn(BlockState state) {
		return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
	}
}