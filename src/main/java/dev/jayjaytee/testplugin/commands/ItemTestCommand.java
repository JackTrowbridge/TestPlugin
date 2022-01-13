package dev.jayjaytee.testplugin.commands;

import dev.jayjaytee.testplugin.utils.ItemBuilder;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ItemTestCommand {

    public ItemTestCommand(){

        new CommandAPICommand("itemtest")
                .executes((sender, args) -> {
                    Player player = (Player) sender;
                    player.getInventory().addItem(new ItemBuilder(Material.DIAMOND_AXE)
                            .setName("&bTest Axe")
                            .setDamage(10)
                            .toItemStack());
                }).register();

    }

}
