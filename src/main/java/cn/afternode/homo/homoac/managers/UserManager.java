package cn.afternode.homo.homoac.managers;

import cn.afternode.homo.homoac.utils.user.User;
import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class UserManager implements Manager{
    public final HashMap<Player, User> users = new HashMap<>();

    @Override
    public void init() {

    }

    public void reset() {
        users.clear();
    }

    public User getUser(Player player) {
        if (users.containsKey(player)) {
            return users.get(player);
        } else {
            User result = new User(player);
            users.put(player, result);
            return result;
        }
    }

    public User getUser(ProtocolPacketEvent<?> event) {
        return getUser(Bukkit.getPlayer(event.getUser().getUUID()));
    }
}
