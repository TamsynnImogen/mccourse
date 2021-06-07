package com.tamsynnclaydon.mccourse.block;

import com.tamsynnclaydon.mccourse.MCCourseMod;
import com.tamsynnclaydon.mccourse.block.config.cropsConfig;
import com.tamsynnclaydon.mccourse.compat.StrippableBlock;
import com.tamsynnclaydon.mccourse.item.BigChestItemStackTileEntityRenderer;
import com.tamsynnclaydon.mccourse.tileentity.ModTileEntities;
import com.tamsynnclaydon.mccourse.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore",
            () -> new CopperOre(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3f, 10f)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.STONE)));

    public static final RegistryObject<Block> BIG_CHEST = registerTileEntity("big_chest",
            () -> new BigChestBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3f, 10f), () -> ModTileEntities.BIG_CHEST_TILE_ENTITY.get()));

    public static final RegistryObject<Block> COPPER_STAIRS =
            register("copper_stairs", () -> new StairsBlock(() -> ModBlocks.COPPER_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_FENCE =
            register("copper_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_FENCE_GATE =
            register("copper_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_DOOR =
            register("copper_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.IRON).notSolid()));

    public static final RegistryObject<Block> COPPER_TRAPDOOR =
            register("copper_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.IRON).notSolid()));

    public static final RegistryObject<Block> COPPER_BARS =
            register("copper_bars", () -> new PaneBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_BUTTON =
            register("copper_button", () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_PRESSURE_PLATE =
            register("copper_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_SLAB =
            register("copper_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)));


    public static final RegistryObject<Block> ZUCCINI_CROP =
            Registration.BLOCKS.register("zuccini_crop",
                    () -> new ZucciniCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));


    public static final RegistryObject<Block> ELECTRIFIER =
            register("electrifier", () -> new Electrifier(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(4f).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> REDWOOD_PLANK = register("redwood_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = register("stripped_redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> REDWOOD_LOG = register("redwood_log",
            ()-> new StrippableBlock(STRIPPED_REDWOOD_LOG.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.WOOD)
                            .hardnessAndResistance(0.5f,2.0f)
                            .harvestTool(ToolType.AXE)
                            .harvestLevel(0)));

    public static final RegistryObject<Block> REDWOOD_LEAVES = register("redwood_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> REDWOOD_SAPLING = register("redwood_sapling",
            () -> new RedwoodSapling(
                    () -> new RedwoodTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)
            ));

    public static void register() {
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(MCCourseMod.COURSE_TAB)));
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerTileEntity(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(MCCourseMod.COURSE_TAB).setISTER(() -> BigChestItemStackTileEntityRenderer::new)));
        return toReturn;
    }
}