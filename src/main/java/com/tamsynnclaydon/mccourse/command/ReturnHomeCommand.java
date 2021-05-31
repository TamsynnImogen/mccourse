package com.tamsynnclaydon.mccourse.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class ReturnHomeCommand
{
    public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(Commands.literal("home").
                then(Commands.literal("return").executes((command) -> {
                    return returnHome(command.getSource());
                })));
    }

    private int returnHome(CommandSource source) throws CommandSyntaxException
    {
        ServerPlayerEntity player = source.asPlayer();

        // not 0 means it contains SOMETHING
        if(player.getPersistentData().getIntArray("homepos").length != 0)
        {
            int[] playerPos = player.getPersistentData().getIntArray("homepos");
            player.setPositionAndUpdate(playerPos[0], playerPos[1], playerPos[2]);

            source.sendFeedback(new StringTextComponent("Player returned Home!"), true);
            return 1;
        }
        else
        {
            source.sendFeedback(new StringTextComponent("No Home Position has been Set!"), true);
            return -1;
        }



    }

}
