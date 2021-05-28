package com.tamsynnclaydon.mccourse.sound;

import com.tamsynnclaydon.mccourse.MCCourseMod;
import com.tamsynnclaydon.mccourse.util.Registration;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class ModSoundEvents
{
    public static final RegistryObject<SoundEvent> SMALL_EXPLOSION =
            Registration.SOUND_EVENTS.register("samll_explostion",
                    () -> new SoundEvent(new ResourceLocation(MCCourseMod.MOD_ID, "small_explosion")));

    public static void register() { }
}
