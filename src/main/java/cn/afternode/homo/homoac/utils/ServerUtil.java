package cn.afternode.homo.homoac.utils;

import cn.afternode.homo.homoac.HomoAC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ServerUtil {
    public static void dispatchCommand(String command) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.dispatchCommand(HomoAC.CCS, command);
            }
        }.runTask(HomoAC.INSTANCE);
    }

    public static void banPlayer(Player player, String reason) {
        dispatchCommand(HomoAC.SETTINGS.BAN_METHOD.replace("$player", player.getName())
        .replace("$reason", reason));
    }
}
