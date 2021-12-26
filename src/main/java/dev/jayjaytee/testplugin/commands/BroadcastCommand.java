package dev.jayjaytee.testplugin.commands;


import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class BroadcastCommand {

    public BroadcastCommand(){

        new CommandAPICommand("broadcast")
                .withArguments(new GreedyStringArgument("message")) // The arguments
                .withAliases("broadcastmsg", "broadcastmessage")       // Command aliases
                .withPermission(CommandPermission.OP)               // Required permissions
                .executes((sender, args) -> {
                    String message = (String) args[0];
                    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&c&l&nALERT&r " + message));
                }).register();

    }

}
