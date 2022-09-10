package cn.afternode.homo.homoac.modules.crasher;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.module.ChatListener;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.user.User;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CrasherB extends ChildrenModule implements ChatListener {
    public CrasherB(Module parent) {
        super(parent);
    }

    @Override
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        /*
        [FDPClient ServerCrasher][onEnable]

        [switch -> log4j]
        val str = "\${jndi:ldap://192.168.${RandomUtils.nextInt(1,253)}.${RandomUtils.nextInt(1,253)}}"

        [switch -> worldedit]
        mc.thePlayer.sendChatMessage("//calc for(i=0;i<256;i++){for(a=0;a<256;a++){for(b=0;b<256;b++){for(c=0;c<255;c++){}}}}")

        [switch -> multiversecore]
        mc.thePlayer.sendChatMessage("/mv ^(.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.++)$^")

        [switch -> pex]
        mc.thePlayer.sendChatMessage(if (Random().nextBoolean()) "/pex promote a a" else "/pex demote a a")
         */
        if (message.contains("${jndi:ldap://") ||
                message.contains("for(i=0;i<256;i++){for(a=0;a<256;a++){for(b=0;b<256;b++){for(c=0;c<255;c++){}}}}") ||
                message.contains("^(.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.++)$^") ||
                message.contains("pex promote a a") || message.contains("pex demote a a")) {
            User user = HomoAC.USER_MANAGER.getUser(event.getPlayer());
            user.addVl(PARENT, 1);
            event.setCancelled(true);
        }
    }
}
