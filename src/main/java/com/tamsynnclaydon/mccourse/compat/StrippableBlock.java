package com.tamsynnclaydon.mccourse.compat;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class StrippableBlock extends RotatedPillarBlock {
    private final BlockState stripped;
    public StrippableBlock(BlockState state, Properties properties) {
        super(properties);
        this.stripped = state;
    }


    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
        return toolType == ToolType.AXE ? stripped : null;
    }
}