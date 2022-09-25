package cn.afternode.homo.homoac.modules.antiattack;

import cn.afternode.homo.homoac.ExtProperties;
import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.StdEventListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.regex.Pattern;

public class AntiAttackA extends ChildrenModule implements StdEventListener {
    public AntiAttackA(Module parent) {
        super(parent);
    }

    private boolean isEMPBot(String name) {
        Pattern pattern = Pattern.compile("([\\s\\S])([0-9a-z])");
        return pattern.matcher(name).find();
    }

    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent event) {
        if (HomoAC.PROP_ENABLED && HomoAC.EXT_PROPERTY.EMP_ENABLED && isEMPBot(event.getPlayer().getName())) {
            HomoAC.LOGGER.warning("匹配EMPv2随机名称逻辑，已踢出玩家：" + event.getPlayer().getName() + " (" + event.getPlayer().getUniqueId().toString() +")");
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, HomoAC.EXT_PROPERTY.EMP_KICK_MSG);
        }
    }
}
