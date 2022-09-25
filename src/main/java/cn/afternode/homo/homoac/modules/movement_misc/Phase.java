package cn.afternode.homo.homoac.modules.movement_misc;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.FlagUtil;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.StdEventListener;
import cn.afternode.homo.homoac.utils.user.User;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class Phase extends ChildrenModule implements StdEventListener {
    public Phase(Module parent) {
        super(parent);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Location tLoc = event.getTo();
        if (tLoc.getBlock().getType() != Material.AIR && tLoc.add(0, 1, 0).getBlock().getType() != Material.AIR) {
            User user = HomoAC.USER_MANAGER.getUser(event.getPlayer());
            FlagUtil.flagBukkitEvent(user, event);
            user.addVl(PARENT, 1);
        }
    }
}
