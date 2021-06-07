package com.tamsynnclaydon.mccourse.block;

import com.tamsynnclaydon.mccourse.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

import java.util.Arrays;

public class ZucciniCrop extends CropsBlock
{
    private static final VoxelShape[] SHAPES = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public ZucciniCrop(Properties builder)
    {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem()
    {
        return ModItems.ZUCCINI_SEED.get();
    }

    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context)
    {
        return SHAPES[state.get(this.getAgeProperty())];
    }

    @Override
    public boolean isValidPosition(BlockState stateIn, IWorldReader worldIn, BlockPos pos)
    {
        BlockState state = worldIn.getBlockState(pos.down());


        {
            BlockPos blockpos = pos.down();

            for (Direction direction : Direction.Plane.HORIZONTAL)
            {
                BlockState blockstate = worldIn.getBlockState(blockpos.offset(direction));

                if (blockstate.getMaterial() == Material.LAVA)
                {
                    return true;
                }
            }

            return false;
        }
    }
    protected boolean canGrowOn(Block blockIn)
    {
        String name = blockIn.getRegistryName().toString();
        return Arrays.asList(Blocks.SOUL_SOIL).contains(name);
    }
}