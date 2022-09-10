package cn.afternode.homo.homoac.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

public abstract class Command implements CommandExecutor {
    public final String NAME;

    public Command(String name) {
        NAME = name;
    }

    public final PluginCommand getCommand() {
        PluginCommand pc = Bukkit.getPluginCommand(NAME);
        if (pc == null) {
            throw new NullPointerException();
        }
        return pc;
    }

    public void onLoad() {}
}
