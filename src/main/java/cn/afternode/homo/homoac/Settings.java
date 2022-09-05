package cn.afternode.homo.homoac;

import cn.afternode.homo.homoac.utils.module.Module;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class Settings {
    @NotNull
    public FileConfiguration FC;

    public Settings(@NotNull FileConfiguration fc) {
        FC = fc;
    }

    public boolean getModuleState(Module module) {
        return FC.getBoolean("modules." + module.NAME, false);
    }

    public String BAN_METHOD = FC.getString("ban-method", "ban $player 1d $reason");
}
