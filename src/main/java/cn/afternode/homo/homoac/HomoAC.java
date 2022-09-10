package cn.afternode.homo.homoac;

import cn.afternode.homo.homoac.managers.ModuleManager;
import cn.afternode.homo.homoac.managers.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomoAC extends JavaPlugin {
    public static HomoAC INSTANCE;
    public static ConsoleCommandSender CCS;
    public static Settings SETTINGS;
    public static FileConfiguration FC;

    public static ModuleManager MODULE_MANAGER;
    public static UserManager USER_MANAGER;

    @Override
    public void onLoad() {
        INSTANCE = this;
        CCS = Bukkit.getConsoleSender();

        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        FC = getConfig();
        SETTINGS = new Settings(getConfig());

        MODULE_MANAGER = new ModuleManager();
        MODULE_MANAGER.init();

        USER_MANAGER = new UserManager();
        USER_MANAGER.init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
