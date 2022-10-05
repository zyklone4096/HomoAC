package cn.afternode.homo.homoac.modules.fly;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.FlagUtil;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.StdEventListener;
import cn.afternode.homo.homoac.utils.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityToggleGlideEvent;

// ElytraFly
public class FlyB extends ChildrenModule implements StdEventListener {
    public FlyB(Module parent) {
        super(parent);
    }

    @EventHandler
    public void onToggle(EntityToggleGlideEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        User user = HomoAC.USER_MANAGER.getUser((Player) event.getEntity());
        user.updateLocation();
        user.addVl(PARENT, 1);
        if (user.getVl(PARENT) >= PARENT.flagVl) {
            FlagUtil.flagNoEvent(user);
        }
    }
}
