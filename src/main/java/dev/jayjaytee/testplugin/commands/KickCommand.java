package dev.jayjaytee.testplugin.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class KickCommand {

    public KickCommand(){

        new CommandAPICommand("kick")
                .withPermission("kick")
                .withArguments(new PlayerArgument("target"))
                .withArguments(new GreedyStringArgument("message"))
                .executes((sender, args) -> {
                    Player player = (Player) args[0];
                    String message = (String) args[1];
                    player.kick(Component.text(ChatColor.translateAlternateColorCodes('&', "&cYou have been kicked!\n&fReason: &c" + message)));
                }).register();

    }

}
