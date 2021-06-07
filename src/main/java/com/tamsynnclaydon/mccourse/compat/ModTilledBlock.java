package com.tamsynnclaydon.mccourse.compat;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ModTilledBlock extends RotatedPillarBlock {
    private final BlockState tilled;
    public ModTilledBlock(BlockState state, Properties properties) {
        super(properties);
        this.tilled = state;
    }


    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
        return toolType == ToolType.HOE ? tilled : null;
    }
}