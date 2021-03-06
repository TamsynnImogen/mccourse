package com.tamsynnclaydon.mccourse.events;

import com.tamsynnclaydon.mccourse.block.ModBlocks;
import com.tamsynnclaydon.mccourse.command.ReturnHomeCommand;
import com.tamsynnclaydon.mccourse.command.SetHomeCommand;
import com.tamsynnclaydon.mccourse.item.ModItems;
import com.tamsynnclaydon.mccourse.util.Config;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.server.command.ConfigCommand;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;

import org.apache.logging.log4j.Logger;

public class ModEvents
{
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public void onCopperedSheep(AttackEntityEvent event)
    {
        if(event.getPlayer().getHeldItemMainhand().getItem() == ModItems.COPPERED_APPLE.get())
        {
            if(event.getTarget().isAlive())
            {
                LivingEntity target = (LivingEntity)event.getTarget();
                if(target instanceof SheepEntity)
                {
                    PlayerEntity player = event.getPlayer();

                    // "delete" one of the held Items
                    player.getHeldItemMainhand().shrink(1);

                    target.addPotionEffect(new EffectInstance(Effects.GLOWING, Config.COPPERED_GLOW_DURATION.get()));

                    if(!player.world.isRemote())
                    {
                        String msg = TextFormatting.YELLOW + "Sheep is now glowing!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onCommandsRegister(RegisterCommandsEvent event)
    {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public void onCopperedSheepDrops(LivingDropsEvent event)
    {
        LivingEntity entity = event.getEntityLiving();

        if(entity instanceof SheepEntity)
        {
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();

            LogManager.getLogger().debug(entity.getActivePotionEffects());

            if(entity.isPotionActive(Effects.GLOWING))
            {
                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(ModItems.COPPER_INGOT.get())));
            }
        }
    }

    @SubscribeEvent
    public void PlayerWakeUp(PlayerWakeUpEvent event)
    {
        PlayerEntity entity = event.getPlayer();

        if(entity instanceof PlayerEntity)
        {
            PlayerEntity player = event.getPlayer();
            if(!player.world.isRemote()) {
                if(player.isPotionActive(Effects.GLOWING)) {
                    String msg = TextFormatting.RED + "Wakey Wakey, Rise and Shine!";
                    player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 300));
                }
                else {
                    String msg = TextFormatting.RED + "Wakey Wakey, Rise and Shine!";
                    player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                }
            }
        }
    }

    @SubscribeEvent
    public void onSoulSoilClick(PlayerInteractEvent.RightClickBlock e) {
        World worldIn = e.getWorld();
        PlayerEntity player = e.getPlayer();
        ItemStack hand = e.getItemStack();
        BlockPos pos = e.getPos();
        BlockState state = worldIn.getBlockState(pos);
        Block block = state.getBlock();
        if (worldIn.isRemote) {
            return;
        }
        if (!hand.getItem().equals(Items.BONE_MEAL)) {
            return;
        }
        if (block == (Blocks.SOUL_SOIL)) {
            worldIn.setBlockState(pos, ModBlocks.FERTILE_SOUL_SOIL.get().getDefaultState());
            if (!player.isCreative()) {
                hand.shrink(1);
            }
        }

        }

}

