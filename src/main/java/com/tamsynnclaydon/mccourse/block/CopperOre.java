package com.tamsynnclaydon.mccourse.block;

import com.tamsynnclaydon.mccourse.sound.ModSoundEvents;
import com.tamsynnclaydon.mccourse.world.dimension.ModDimensions;
import com.tamsynnclaydon.mccourse.world.dimension.TCTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CopperOre extends Block
{
        public CopperOre(Properties properties) {
            super(properties);
        }

        @Override
        public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                                 PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
        {
            if(!worldIn.isRemote())
            {
                if(!player.isCrouching())
                {
                    MinecraftServer server = worldIn.getServer();

                    if(server != null)
                    {
                        if(worldIn.getDimensionKey() == ModDimensions.TCDim)
                        {
                            ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                            if(overWorld != null)
                            {
                                player.changeDimension(overWorld, new TCTeleporter(pos, false));
                            }
                        }
                        else
                        {
                            ServerWorld tcDim = server.getWorld(ModDimensions.TCDim);
                            if(tcDim != null)
                            {
                                player.changeDimension(tcDim, new TCTeleporter(pos, true));
                            }
                        }
                        Minecraft.getInstance().player.playSound(ModSoundEvents.SMALL_EXPLOSION.get(),
                                1f, 1f);

                        return ActionResultType.SUCCESS;
                    }
                }
            }

            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
}
