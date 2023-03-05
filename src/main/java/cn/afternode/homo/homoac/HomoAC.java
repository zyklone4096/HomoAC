package cn.afternode.homo.homoac;

import cn.afternode.homo.homoac.managers.BotManager;
import cn.afternode.homo.homoac.managers.CommandManager;
import cn.afternode.homo.homoac.managers.ModuleManager;
import cn.afternode.homo.homoac.managers.UserManager;
import cn.afternode.homo.homoac.utils.ServerUtil;
import cn.afternode.homo.homoac.utils.bStats;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Properties;
import java.util.logging.Logger;

public final class HomoAC extends JavaPlugin {
    public static HomoAC INSTANCE;
    public static ConsoleCommandSender CCS;
    public static Settings SETTINGS;
    public static FileConfiguration FC;
    public static Logger LOGGER;
    public static bStats BSTATS;

    public static ModuleManager MODULE_MANAGER;
    public static UserManager USER_MANAGER;
    public static CommandManager COMMAND_MANAGER;
    public static BotManager BOT_MANAGER;

    public static boolean PROP_ENABLED;
    public static ExtProperties EXT_PROPERTY;

    @Override
    public void onLoad() {
        INSTANCE = this;
        CCS = Bukkit.getConsoleSender();
        LOGGER = getLogger();

        if (ServerUtil.isForge()) {
            LOGGER.warning("检测到服务端可能是Forge，部分模块可能出现误判");
        }

        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        FC = getConfig();
        SETTINGS = new Settings(getConfig());
        Properties prop = new Properties();
        saveResource("ext.properties", false);
        try {
            prop.load(getResource("ext.properties"));
            EXT_PROPERTY = new ExtProperties(prop);
        } catch (Exception e) {
            LOGGER.warning("ExtProperties load failed");
            e.printStackTrace();
        }

        MODULE_MANAGER = new ModuleManager();
        MODULE_MANAGER.init();

        USER_MANAGER = new UserManager();
        USER_MANAGER.init();

        COMMAND_MANAGER = new CommandManager();
        COMMAND_MANAGER.init();

        BSTATS = new bStats();
        BSTATS.init();

        BOT_MANAGER = new BotManager();
        BOT_MANAGER.init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
