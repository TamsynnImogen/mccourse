package com.tamsynnclaydon.mccourse.world.feature;

import com.tamsynnclaydon.mccourse.block.ModBlocks;
import com.tamsynnclaydon.mccourse.block.ModFluids;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModConfiguredFeatures
{
    public static final ConfiguredFeature<?, ?> OIL_LAKE =
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "lake_oil",
                Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(ModFluids.OIL_BLOCK.get().getDefaultState()))
                        .withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(10))));

    private static final BlockClusterFeatureConfig COPPER_SPREAD_CONFIG =
            (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.COPPER_BLOCK.get().getDefaultState()),
            new SimpleBlockPlacer())).tries(25).build();

    public static final ConfiguredFeature<?, ?> COPPER_BLOCK_SPREAD =
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "copper_spread",
                    Feature.RANDOM_PATCH.withConfiguration(COPPER_SPREAD_CONFIG)
                            .withPlacement(Placement.CHANCE.configure(new ChanceConfig(200))));
}
