package com.tamsynnclaydon.mccourse.compat;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ModStrippedBlock extends RotatedPillarBlock {
    private final BlockState stripped;
    public ModStrippedBlock(BlockState state, Properties properties) {
        super(properties);
        this.stripped = state;
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
        return toolType == ToolType.AXE ? stripped.with(AXIS, state.get(AXIS)) : null;
    }
}