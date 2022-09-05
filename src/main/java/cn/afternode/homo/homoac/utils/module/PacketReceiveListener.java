package cn.afternode.homo.homoac.utils.module;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;

public interface PacketReceiveListener extends HomoListener {
    void onPacket(PacketReceiveEvent event);
}
