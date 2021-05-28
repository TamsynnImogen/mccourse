package com.tamsynnclaydon.mccourse.block;

import com.tamsynnclaydon.mccourse.sound.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class CopperOre extends Block
{

    public CopperOre(Properties properties)
    {
        super(properties);
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state)
    {
        if(worldIn.isRemote())
        {
            Minecraft.getInstance().player.playSound(ModSoundEvents.SMALL_EXPLOSION.get(),
                    1f, 1f);
        }

        super.onPlayerDestroy(worldIn, pos, state);
    }
}
