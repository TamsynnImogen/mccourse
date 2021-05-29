package com.tamsynnclaydon.mccourse.data;

import com.tamsynnclaydon.mccourse.MCCourseMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModToolModelProvider extends ItemModelProvider
{
    public ModToolModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        ModelFile itemGenerated = getExistingFile(mcLoc("item/handheld"));

        builder(itemGenerated, "copper_pickaxe");
        builder(itemGenerated, "copper_club");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name)
    {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/"  + name);
    }
}
