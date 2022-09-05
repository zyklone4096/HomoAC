package cn.afternode.homo.homoac.utils;

import cn.afternode.homo.homoac.utils.user.User;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;

public class FlagUtil {
    public static void flagWithEvent(User user, PacketReceiveEvent event) {
        user.PLAYER.teleport(user.lastULocation);
        event.setCancelled(true);
        user.updateLocation();
    }
}
