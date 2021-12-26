package dev.jayjaytee.testplugin.commands;

import com.connorlinfoot.titleapi.TitleAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class AlertCommand {

    public AlertCommand(){

        new CommandAPICommand("alert")
                .withArguments(new GreedyStringArgument("message"))
                .withPermission(CommandPermission.OP)
                .executes((sender, args) -> {
                    String message = (String) args[0];
                    for(Player player : Bukkit.getServer().getOnlinePlayers()){
                        TitleAPI.sendTitle(player, 20, 20*5, 20, "§c§l§nALERT§r", ChatColor.translateAlternateColorCodes('&', message));
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 10);
                    }
                }).register();

    }

}
