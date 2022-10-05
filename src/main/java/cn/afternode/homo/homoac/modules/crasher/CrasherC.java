package cn.afternode.homo.homoac.modules.crasher;

import cn.afternode.homo.homoac.utils.annotations.SkidHack;
import cn.afternode.homo.homoac.utils.module.ChildrenModule;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.module.PacketReceiveListener;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerBlockPlacement;

@SkidHack(liquidHack = SkidHack.HackTypes.LIQUID.FDP_CLIENT)
public class CrasherC extends ChildrenModule implements PacketReceiveListener {
    public CrasherC(Module parent) {
        super(parent);
    }

    @Override
    public void onPacket(PacketReceiveEvent event) {
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_BLOCK_PLACEMENT) {
            /*
            [FDPClient ServerCrasher][onUpdate]
            [switch -> nullc08]
            PacketUtils.sendPacketNoEvent(C08PacketPlayerBlockPlacement(BlockPos(Double.NaN, Double.NaN, Double.NaN), 1, null, 0f, 0f, 0f))
             */
            WrapperPlayClientPlayerBlockPlacement packet = new WrapperPlayClientPlayerBlockPlacement(event);
            Vector3i blockPos = packet.getBlockPosition();

        }
    }
}
