package com.tamsynnclaydon.mccourse.world.dimension;

import com.tamsynnclaydon.mccourse.MCCourseMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions
{
    public static RegistryKey<World> TCDim;

    public static void register()
    {
        TCDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
                new ResourceLocation(MCCourseMod.MOD_ID, "tcdim"));
    }

}
