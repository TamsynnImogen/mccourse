package com.tamsynnclaydon.mccourse.util;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class Config
{
    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.IntValue COPPERED_GLOW_DURATION;
    public static ForgeConfigSpec.IntValue ELECTRIFIER_CONVERSION;
    public static ForgeConfigSpec.IntValue ELECTRIFIER_MAX_ENERGY;

    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        glowingDuration(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void glowingDuration(ForgeConfigSpec.Builder SERVER_BUILDER,
                                        ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        COPPERED_GLOW_DURATION = CLIENT_BUILDER.comment("How long the glowing lasts for Coppered Apples (in ticks)")
                .defineInRange( "glow_duration", 600, 100, Integer.MAX_VALUE);
    }

    private static void energyConversion(ForgeConfigSpec.Builder SERVER_BUILDER,
                                        ForgeConfigSpec.Builder CLIENT_BUILDER)

    {
        ELECTRIFIER_CONVERSION = CLIENT_BUILDER.comment("How long it takes to convert Diamonds into energy")
                .defineInRange( "energy_conversion", 10, 0, Integer.MAX_VALUE);
    }

    private static void maxEnergy(ForgeConfigSpec.Builder SERVER_BUILDER,
                                         ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        ELECTRIFIER_MAX_ENERGY = CLIENT_BUILDER.comment("How much energy it takes to make an Emerald")
                .defineInRange( "max_energy", 64, 10, Integer.MAX_VALUE);
    }

    public static void loadConfigFile(ForgeConfigSpec config, String path)
    {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path))
                .sync().autosave().writingMode(WritingMode.REPLACE).build();

        file.load();
        config.setConfig(file);
    }
}
