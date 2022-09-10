package cn.afternode.homo.homoac;

import cn.afternode.homo.homoac.utils.module.Module;
import org.bukkit.configuration.file.FileConfiguration;

public class Settings {
    public FileConfiguration FC;

    public Settings(FileConfiguration fc) {
        if (fc == null) throw new NullPointerException();
        FC = fc;

        BAN_METHOD = FC.getString("ban-method", "ban $player 1d $reason");

        SHOW_IP = FC.getBoolean("command.show-player-ip", false);
    }

    public boolean getModuleState(Module module) {
        return FC.getBoolean("modules." + module.NAME, false);
    }

    public String BAN_METHOD;

    public boolean SHOW_IP;
}
