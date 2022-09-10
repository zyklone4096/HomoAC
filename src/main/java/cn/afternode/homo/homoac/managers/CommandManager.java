package cn.afternode.homo.homoac.managers;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.commands.MainCommand;
import cn.afternode.homo.homoac.utils.Command;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandManager implements Manager{
    public HashMap<String, Command> registered;

    @Override
    public void init() {
        registered = new HashMap<>();

        List<Command> prepare = new ArrayList<>();
        prepare.add(new MainCommand());

        for (Command command : prepare) {
            registerCommand(command);
        }
    }

    public void registerCommand(Command command) {
        try {
            command.onLoad();
            command.getCommand().setExecutor(command);
            registered.put(command.NAME, command);
        } catch (Exception e) {
            HomoAC.LOGGER.warning("Command load failed: " + e.getMessage());
            HomoAC.LOGGER.warning("At command: " + command.NAME);
            e.printStackTrace();
        }
    }
}
