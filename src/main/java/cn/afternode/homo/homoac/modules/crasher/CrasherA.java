package cn.afternode.homo.homoac.modules.crasher;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.annotations.SkidHack;
import cn.afternode.homo.homoac.utils.module.ChatListener;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.PacketReceiveListener;
import cn.afternode.homo.homoac.utils.user.User;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerPosition;

@SkidHack(liquidHack = SkidHack.HackTypes.LIQUID.FDP_CLIENT)
public class CrasherA extends ChildrenModule implements PacketReceiveListener {

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
    }
}
