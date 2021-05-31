package com.tamsynnclaydon.mccourse.data;

import com.tamsynnclaydon.mccourse.MCCourseMod;
import com.tamsynnclaydon.mccourse.block.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        getOrCreateBuilder(Tags.Blocks.ORES).add(ModBlocks.COPPER_ORE.get());
        getOrCreateBuilder(BlockTags.FENCES).add(ModBlocks.COPPER_FENCE.get());

        super.registerTags();
    }
}
