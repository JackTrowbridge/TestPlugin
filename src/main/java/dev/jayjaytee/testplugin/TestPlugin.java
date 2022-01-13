package dev.jayjaytee.testplugin;

import dev.jayjaytee.testplugin.commands.*;
import dev.jayjaytee.testplugin.events.EntityHitEvent;
import dev.jorel.commandapi.CommandAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        CommandAPI.unregister("kick");

        new BroadcastCommand();
        new AlertCommand();
        new GamemodeCommand();
        new KickCommand();
        new ItemTestCommand(); // This command is an example for ItemBuilder, and will be most likely removed in production.
        new GeneratorCommand();

        getServer().getPluginManager().registerEvents(new EntityHitEvent(), this);

        CommandAPI.onEnable(this);
    }

    public static TestPlugin getInstance(){
        return (TestPlugin) Bukkit.getPluginManager().getPlugin("TestPlugin");
    }

}
