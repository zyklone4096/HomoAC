package cn.afternode.homo.homoac.utils.module;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import org.bukkit.event.Listener;

public class Module implements Listener {
    public final String NAME;
    public int banVl = 10;
    public String banReason = "被撅力";

    public Module(String name) {
        this.NAME = name;
    }

    public void init() {}

    protected void addListener(HomoListener listener){
        if (listener instanceof PacketReceiveListener) {
            PacketEvents.getAPI().getEventManager().registerListener(new PacketListenerAbstract() {
                @Override
                public void onPacketReceive(PacketReceiveEvent event) {
                    ((PacketReceiveListener) listener).onPacket(event);
                }
            });
        }
    }
}
