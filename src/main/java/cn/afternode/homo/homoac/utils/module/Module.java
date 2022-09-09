package cn.afternode.homo.homoac.utils.module;

import cn.afternode.homo.homoac.HomoAC;
import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Module implements Listener {
    public final String NAME;
    public int banVl = 10;
    public int flagVl = 5;
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
        } else if (listener instanceof Listener) {
            Bukkit.getPluginManager().registerEvents((Listener) listener, HomoAC.INSTANCE);
        }
    }
}
