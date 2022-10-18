package cn.afternode.homo.homoac.utils;

import cn.afternode.homo.homoac.utils.user.User;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FlagUtil {
    /**
     * Lag back with a PacketReceiveEvent
     * @param user Target user
     * @param event Event to cancel
     */
    public static void flagWithEvent(User user, PacketReceiveEvent event) {
        user.PLAYER.teleport(user.lastULocation);
        event.setCancelled(true);
        user.updateLocation();
    }

    /**
     * Lag back without any events
     * @param user Target user
     */
    public static void flagNoEvent(User user) {
        user.PLAYER.teleport(user.lastULocation);
        user.updateLocation();
    }

    /**
     * Lag back with a Bukkit Event
     * @param user Target user
     * @param event A PlayerMoveEvent to cancel
     */
    public static void flagBukkitEvent(User user, PlayerMoveEvent event) {
        event.setCancelled(true);
        user.updateLocation();
    }
}
