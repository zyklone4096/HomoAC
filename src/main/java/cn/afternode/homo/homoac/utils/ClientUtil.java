package cn.afternode.homo.homoac.utils;

import cn.afternode.homo.homoac.utils.user.User;
import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.Vector3f;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerExplosion;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ClientUtil {
    public static void sendCrashPacket(Player target) {
        WrapperPlayServerExplosion packet = new WrapperPlayServerExplosion(
                new Vector3f(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE),
                Float.MAX_VALUE,
                new ArrayList<>(),
                new Vector3f(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE)
        );

        packet.prepareForSend();
        PacketEvents.getAPI().getPlayerManager().getUser(target).sendPacket(packet);
    }

    public static void sendCrashPacket(User user) {
        sendCrashPacket(user.PLAYER);
    }
}
