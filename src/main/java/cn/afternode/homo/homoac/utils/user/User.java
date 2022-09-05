package cn.afternode.homo.homoac.utils.user;

import cn.afternode.homo.homoac.utils.ServerUtil;
import cn.afternode.homo.homoac.utils.module.Module;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class User {
    public final Player PLAYER;
    public final HashMap<Module, Integer> VL;

    public User(Player player) {
        PLAYER = player;
        VL = new HashMap<>();
    }

    public void addVl(Module module, int vl) {
        if (!VL.containsKey(module)) {
            VL.put(module, vl);
        } else {
            VL.replace(module, VL.get(module) + vl);
        }
        if (VL.get(module) >= module.banVl) {
            ServerUtil.banPlayer(PLAYER, module.banReason);
        }
    }
}
