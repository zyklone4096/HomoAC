package cn.afternode.homo.homoac.modules.fly;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.FlagUtil;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.PacketReceiveListener;
import cn.afternode.homo.homoac.utils.user.User;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerPosition;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerPositionAndRotation;

// AACFly PacketScanner
public class FlyA extends ChildrenModule implements PacketReceiveListener {
    public FlyA(Module parent) {
        super(parent);
    }

    @Override
    public void onPacket(PacketReceiveEvent event) {
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION) {
            User user = HomoAC.USER_MANAGER.getUser(event);
            WrapperPlayClientPlayerPosition packet = new WrapperPlayClientPlayerPosition(event);

            /*
            [FDPClient AAC520VanillaFly][sendPacket]
            sendPacketNoEvent(C04PacketPlayerPosition(packet.x, 1e+308, packet.z, true))
            sendPacketNoEvent(C04PacketPlayerPosition(packet.x, -1e+159, packet.z + 10, true))
            */
            if (packet.getPosition().y == 1e+308 || packet.getPosition().y == -1e+159) {
                user.addVl(PARENT, 1);
                if (PARENT.flagVl <= user.getVl(PARENT)) {
                    FlagUtil.flagWithEvent(user, event);
                }
            }

            /*
            [FDPClient AAC520Fly][onEnable & onPacket]
            PacketUtils.sendPacketNoEvent(C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, 1.7976931348623157E+308, mc.thePlayer.posZ, true))
             */
            if (packet.getPosition().y == 1.7976931348623157E+308) {
                user.addVl(PARENT, 1);
                if (PARENT.flagVl <= user.getVl(PARENT)) {
                    FlagUtil.flagWithEvent(user, event);
                }
            }
        } else if (event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION_AND_ROTATION) {
            User user = HomoAC.USER_MANAGER.getUser(event);
            WrapperPlayClientPlayerPositionAndRotation packet = new WrapperPlayClientPlayerPositionAndRotation(event);

            /*
            [FDPClient AAC520VanillaFly][sendPacket]
            sendPacketNoEvent(C06PacketPlayerPosLook(packet.x, 1e+308, packet.z, yaw, pitch, true))
            sendPacketNoEvent(C06PacketPlayerPosLook(packet.x, -1e+159, packet.z + 10, yaw, pitch, true))
             */
            if (packet.getPosition().y == 1e+308 || packet.getPosition().y == -1e+159) {
                user.addVl(PARENT, 1);
                if (PARENT.flagVl <= user.getVl(PARENT)) {
                    FlagUtil.flagWithEvent(user, event);
                }
            }
        }
    }
}
