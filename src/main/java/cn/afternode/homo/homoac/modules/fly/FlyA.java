package cn.afternode.homo.homoac.modules.fly;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.PacketReceiveListener;
import cn.afternode.homo.homoac.utils.user.User;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerPosition;

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
            */
            if (packet.getPosition().y == 1e+308) {
                user.addVl(PARENT, 1);
            }
        }
    }
}
