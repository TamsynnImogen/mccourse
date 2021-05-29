package com.tamsynnclaydon.mccourse.data;

import com.tamsynnclaydon.mccourse.MCCourseMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider
{
    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, MCCourseMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations()
    {
        String locale = this.getName().replace("Languages: ", "");

        switch (locale)
        {
            case "en_us":
                add("item.mccourse.copper_ingot", "Copper Ingot");
                add("item.mccourse.copper_wire", "Copper Wire");
                add("item.mccourse.coppered_apple", "Coppered Apple");

                add("item.mccourse.copper_shovel", "Copper Shovel");
                add("item.mccourse.copper_axe", "Copper Axe");
                add("item.mccourse.copper_pickaxe", "Copper Pickaxe");
                add("item.mccourse.copper_hoe", "Copper Hoe");
                add("item.mccourse.copper_sword", "Copper Sword");

                add("item.mccourse.copper_helmet", "Copper Helmet");
                add("item.mccourse.copper_chestplate", "Copper Chestplate");
                add("item.mccourse.copper_leggings", "Copper Leggings");
                add("item.mccourse.copper_boots", "Copper Boots");

                add("block.mccourse.zuccini_crop", "Zuccini Seeds");

                add("block.mccourse.copper_block", "Copper Block");
                add("block.mccourse.copper_ore", "Copper Ore");

                add("itemGroup.coursetab", "Course Tab");

                add("entity.mccourse.buffalo", "Buffalo");

                add("mccourse.small_explosion", "Small Explosion");

                add("advancement.story.copper_block.title", "Coppering");
                add("advancement.story.copper_block.description", "Aquire Copper Blocks");


                break;
            default:
                break;
        }

    }
}
