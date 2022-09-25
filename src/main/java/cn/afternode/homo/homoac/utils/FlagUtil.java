package cn.afternode.homo.homoac.utils;

import cn.afternode.homo.homoac.utils.user.User;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FlagUtil {
    public static void flagWithEvent(User user, PacketReceiveEvent event) {
        user.PLAYER.teleport(user.lastULocation);
        event.setCancelled(true);
        user.updateLocation();
    }

    public static void flagNoEvent(User user) {
        user.PLAYER.teleport(user.lastULocation);
        user.updateLocation();
    }

    public static void flagBukkitEvent(User user, PlayerMoveEvent event) {
        event.setCancelled(true);
        user.updateLocation();
    }
}
