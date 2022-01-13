package dev.jayjaytee.testplugin.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.MultiLiteralArgument;

public class GeneratorCommand {

    public GeneratorCommand(){

        new CommandAPICommand("generator")
                .withAliases("gen")
                .withPermission("generator")
                .withArguments(new MultiLiteralArgument("normal", "super"))
                .executes((sender, args) -> {

                }).register();

    }

}
