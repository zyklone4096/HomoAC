package cn.afternode.homo.homoac.modules.crasher;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.module.ChatListener;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.PacketReceiveListener;
import cn.afternode.homo.homoac.utils.user.User;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerBlockPlacement;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerPosition;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CrasherA extends ChildrenModule implements PacketReceiveListener, ChatListener {

    public CrasherA(Module parent) {
        super(parent);
    }

    @Override
    public void init() {
    }

    @Override
    public void onPacket(PacketReceiveEvent event) {
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION) {
            User user = HomoAC.USER_MANAGER.getUser(event);
            WrapperPlayClientPlayerPosition packet = new WrapperPlayClientPlayerPosition(event);

            /*
            [FDPClient ServerCrasher][onEnable]
            [switch -> mathoverflow]
            PacketUtils.sendPacketNoEvent(C03PacketPlayer.C04PacketPlayerPosition(1.7976931348623157E+308, 1.7976931348623157E+308, 1.7976931348623157E+308, true))
             */
            Vector3d vec = packet.getPosition();
            if (vec.x == 1.7976931348623157E+308) {
                user.addVl(PARENT, 1);
                event.setCancelled(true);
            }
            if (vec.y == 1.7976931348623157E+308) {
                user.addVl(PARENT, 1);
                event.setCancelled(true);
            }
            if (vec.z == 1.7976931348623157E+308) {
                user.addVl(PARENT, 1);
                event.setCancelled(true);
            }

            /*
            [FDPClient ServerCrasher][onEnable]
            [switch -> aacold]
            PacketUtils.sendPacketNoEvent(C03PacketPlayer.C04PacketPlayerPosition(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, true))
             */
            if (vec.x == Double.NEGATIVE_INFINITY) {
                user.addVl(PARENT, 1);
                event.setCancelled(true);
            }
            if (vec.y == Double.NEGATIVE_INFINITY) {
                user.addVl(PARENT, 1);
                event.setCancelled(true);
            }
            if (vec.z == Double.NEGATIVE_INFINITY) {
                user.addVl(PARENT, 1);
                event.setCancelled(true);
            }
        }
        else if (event.getPacketType() == PacketType.Play.Client.TAB_COMPLETE) {

        } else if (event.getPacketType() == PacketType.Play.Client.PLAYER_BLOCK_PLACEMENT) {
            /*
            [FDPClient ServerCrasher][onUpdate]
            [switch -> nullc08]
            PacketUtils.sendPacketNoEvent(C08PacketPlayerBlockPlacement(BlockPos(Double.NaN, Double.NaN, Double.NaN), 1, null, 0f, 0f, 0f))
             */
            WrapperPlayClientPlayerBlockPlacement packet = new WrapperPlayClientPlayerBlockPlacement(event);
            Vector3i blockPos = packet.getBlockPosition();

        }
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
