package dev.jayjaytee.testplugin.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.Argument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GamemodeCommand {

    public GamemodeCommand(){
        List<Argument> arguments = new ArrayList<>();
        arguments.add(new StringArgument("gamemode").replaceSuggestions(info ->
                new String[] {"creative", "survival", "adventure", "spectator" }
        ));

        new CommandAPICommand("gamemode")
                .withAliases("gm")
                .withPermission(CommandPermission.fromString("gamemode"))
                .withArguments(arguments)
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
                .withArguments(arguments)
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
