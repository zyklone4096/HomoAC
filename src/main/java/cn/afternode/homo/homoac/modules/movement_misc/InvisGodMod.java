package cn.afternode.homo.homoac.modules.movement_misc;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.StdEventListener;
import cn.afternode.homo.homoac.utils.user.User;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class InvisGodMod extends ChildrenModule implements StdEventListener {
    public InvisGodMod(Module parent) {
        super(parent, "离载具那么远是什么操作");
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Vehicle vehicle = (Vehicle) player.getVehicle();
        Chunk playerChunk = player.getLocation().getChunk();
        if (playerChunk != vehicle.getLocation().getChunk()) {
            vehicle.eject();
            User user = HomoAC.USER_MANAGER.getUser(player);
            user.addVl(PARENT, 5);
        }
    }
}
