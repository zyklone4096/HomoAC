package cn.afternode.homo.homoac.modules.movement_misc;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.CSpeed;
import cn.afternode.homo.homoac.utils.FlagUtil;
import cn.afternode.homo.homoac.utils.annotations.SkidClass;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.StdEventListener;
import cn.afternode.homo.homoac.utils.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

@SkidClass(plugin = "XinAntiCheat", clazz = "dev.zenhao.xin.listeners.movement.BoatSpeed", modified = true)
public class BoatSpeed extends ChildrenModule implements StdEventListener {
    public BoatSpeed(Module parent) {
        super(parent);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        double Offset = 0.0;
        if (!(event.getFrom().getY() > event.getTo().getY())) {
            Offset = CSpeed.offset(event.getFrom(), event.getTo());
        }
        if (event.getPlayer().isInsideVehicle() && Offset >= 6.1 && event.getTo().getY() - event.getFrom().getY() < 1.0) {
            User user = HomoAC.USER_MANAGER.getUser(event.getPlayer());
            FlagUtil.flagNoEvent(user);
        }
    }
}
