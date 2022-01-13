package dev.jayjaytee.testplugin.commands;

import dev.jorel.commandapi.CommandAPICommand;

public class JokeCommand {

    public JokeCommand(){

        new CommandAPICommand("joke")
                .executes((sender, args) -> {
                    sender.sendMessage("Hello World!");
                }).register();

    }

}
