package com.tamsynnclaydon.mccourse.tileentity;

import com.tamsynnclaydon.mccourse.block.ModBlocks;
import com.tamsynnclaydon.mccourse.util.Registration;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities
{
    public static final RegistryObject<TileEntityType<ElectrifierTile>> ELECTRIFIER_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register("electrifier_tile_entity", () -> TileEntityType.Builder.create(
            () -> new ElectrifierTile(), ModBlocks.ELECTRIFIER.get()).build(null));

    public static final RegistryObject<TileEntityType<BigChestTile>> BIG_CHEST_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register("big_chest_tile_entity", () -> TileEntityType.Builder.create(
            () -> new BigChestTile(), ModBlocks.BIG_CHEST.get()).build(null));

    public static void register() { }
}
