package cn.afternode.homo.homoac.utils;

import cn.afternode.homo.homoac.Settings;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigLoader {
    public static FileConfiguration getConfigFromFile(File file) {
        return YamlConfiguration.loadConfiguration(file);
    }

    public static Settings getSettingsFromFile(File file) {
        return new Settings(getConfigFromFile(file));
    }
}
