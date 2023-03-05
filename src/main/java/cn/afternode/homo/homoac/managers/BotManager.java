package cn.afternode.homo.homoac.managers;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.bots.Bot;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class BotManager implements Manager, Listener {
    private final HashMap<UUID, Bot> bots = new HashMap<>();

    @Override
    public void init() {
        Bukkit.getPluginManager().registerEvents(this, HomoAC.INSTANCE);
    }

    public void registerBot(Bot bot) {
        bots.put(bot.getUuid(), bot);
    }

    public Bot forUuid(UUID uuid) {
        return bots.get(uuid);
    }

    public void removeBot(UUID uuid) {
        Bot b = bots.get(uuid);
        removeBot(b);
    }

    public void removeBot(Bot bot) {
        new BukkitRunnable() {
            @Override
            public void run() {
                bot.getEntity().remove();
                bots.remove(bot.getUuid());
            }
        }.runTask(HomoAC.INSTANCE);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        for (Bot b: bots.values()) {
            if (b.getEntity() == event.getEntity()) {
                try {
                    b.onDamage(event);
                } catch (Throwable ignored) {}
            }
        }
    }
}
