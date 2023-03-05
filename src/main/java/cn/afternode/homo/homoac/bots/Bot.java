package cn.afternode.homo.homoac.bots;

import cn.afternode.homo.homoac.HomoAC;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.UUID;

public class Bot {
    public static Bot create(String name, Location loc) {
        Bot b = new Bot(name, loc);
        HomoAC.BOT_MANAGER.registerBot(b);
        return b;
    }

    private final HumanEntity entity;
    private final UUID uuid;

    protected Bot(String name, Location loc) {
        entity = (HumanEntity) loc.getWorld().spawnEntity(loc, EntityType.PLAYER);
        uuid = entity.getUniqueId();

        entity.setCustomName(name);
        try {
            ((Player) entity).setDisplayName(name);
            ((Player) entity).setPlayerListName(name);
        } catch (Throwable ignored) {}
    }

    public void unregister(){
        if (HomoAC.BOT_MANAGER.forUuid(uuid) != null) {
            HomoAC.BOT_MANAGER.removeBot(this);
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public HumanEntity getEntity() {
        return entity;
    }

    public void onDamage(EntityDamageByEntityEvent event) {}
}
