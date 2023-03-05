package cn.afternode.homo.homoac.bots;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.concurrent.TimeUnit;

public class AuraBot extends Bot implements Listener {
    private final Player target;
    private final CommandSender owner;
    private final Thread timingThread;

    public AuraBot(Player player, CommandSender owner, long duration) {
        super(PlayerUtils.randomPlayer(player.getLocation().getWorld()).getDisplayName(),
                new Location(player.getLocation().getWorld(),
                        player.getLocation().getX(), player.getLocation().getY() + 2, player.getLocation().getZ()));
        this.target = player;
        this.owner = owner;
        HomoAC.BOT_MANAGER.registerBot(this);

        timingThread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(duration);
            } catch (Throwable t) {
                HomoAC.LOGGER.warning("Error timing of bot with id " + getUuid());
                t.printStackTrace();
            } finally {
                HomoAC.BOT_MANAGER.removeBot(AuraBot.this);
            }
        });
        timingThread.start();
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getDamager() == target) {
            double distance = getEntity().getLocation().distance(target.getLocation());

            PlayerUtils.notify(owner, "BotAttacked[target=\"" + target.getDisplayName() + ChatColor.RESET + "\";" +
                    "distance=" + distance + "]");
        }
    }
}
