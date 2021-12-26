package dev.jayjaytee.testplugin;

import dev.jayjaytee.testplugin.commands.AlertCommand;
import dev.jayjaytee.testplugin.commands.BroadcastCommand;
import dev.jayjaytee.testplugin.commands.GamemodeCommand;
import dev.jayjaytee.testplugin.commands.KickCommand;
import dev.jorel.commandapi.CommandAPI;
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

        CommandAPI.onEnable(this);
    }

}
