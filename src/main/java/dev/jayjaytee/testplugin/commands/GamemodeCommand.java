package dev.jayjaytee.testplugin.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.MultiLiteralArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class GamemodeCommand {

    public GamemodeCommand(){

        new CommandAPICommand("gamemode")
                .withAliases("gm")
                .withPermission("gamemode")
                .withArguments(new MultiLiteralArgument("creative", "survival", "adventure", "spectator"))
                .executes((sender, args) -> {
                    Player player = (Player) sender;
                    try{
                        player.setGameMode(GameMode.valueOf(args[0].toString().toUpperCase()));
                    }catch (IllegalArgumentException e){
                        player.sendMessage("§c§l§nERROR§r That gamemode doesn't exist!");
                        return;
                    }
                    player.sendMessage("§c§l§nGAMEMODE§r Your gamemode has been set to " + args[0].toString().toUpperCase());
                }).register();

        new CommandAPICommand("gamemode")
                .withAliases("gm")
                .withPermission(CommandPermission.fromString("gamemode.others"))
                .withArguments(new MultiLiteralArgument("creative", "survival", "adventure", "spectator"))
                .withArguments(new PlayerArgument("target"))
                .executes((sender, args) -> {
                    Player player = (Player) args[1];
                    try{
                        player.setGameMode(GameMode.valueOf(args[0].toString().toUpperCase()));
                    }catch (IllegalArgumentException e){
                        player.sendMessage("§c§l§nERROR§r That gamemode doesn't exist!");
                        return;
                    }
                    player.sendMessage("§c§l§nGAMEMODE§r Your gamemode has been set to " + args[0].toString().toUpperCase());
                    sender.sendMessage("§c§l§nGAMEMODE§r You've set " + args[1].toString() + "'s gamemode to " + args[0].toString().toUpperCase());
                }).register();

    }

}
