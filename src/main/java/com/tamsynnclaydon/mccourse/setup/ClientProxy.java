package com.tamsynnclaydon.mccourse.setup;

import com.tamsynnclaydon.mccourse.MCCourseMod;
import com.tamsynnclaydon.mccourse.block.ModBlocks;
import com.tamsynnclaydon.mccourse.container.ModContainers;
import com.tamsynnclaydon.mccourse.entity.ModEntityTypes;
import com.tamsynnclaydon.mccourse.entity.render.BuffaloRenderer;
import com.tamsynnclaydon.mccourse.item.ModSpawnEggItem;
import com.tamsynnclaydon.mccourse.screens.BigChestScreen;
import com.tamsynnclaydon.mccourse.screens.ElectrifierScreen;
import com.tamsynnclaydon.mccourse.tileentity.BigChestTileEntityRenderer;
import com.tamsynnclaydon.mccourse.tileentity.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy
{

    @Override
    public void init()
    {
        RenderTypeLookup.setRenderLayer(ModBlocks.ZUCCINI_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.REDWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COPPER_BARS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COPPER_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COPPER_TRAPDOOR.get(), RenderType.getCutout());

        ScreenManager.registerFactory(ModContainers.ELECTRIFIER_CONTAINER.get(), ElectrifierScreen::new);
        ScreenManager.registerFactory(ModContainers.BIGCHEST_CONTAINER.get(), BigChestScreen::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUFFALO.get(), BuffaloRenderer::new);

        ClientRegistry.bindTileEntityRenderer(ModTileEntities.BIG_CHEST_TILE_ENTITY.get(), BigChestTileEntityRenderer::new);

        ModSpawnEggItem.initSpawnEggs();
    }


    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }
}
