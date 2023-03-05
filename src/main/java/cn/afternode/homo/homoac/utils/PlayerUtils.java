package cn.afternode.homo.homoac.utils;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class PlayerUtils {
    public static Player randomPlayer(World w) {
        List<Player> l = w.getPlayers();
        Random rd = new Random();
        return l.get(rd.nextInt(l.size()));
    }

    public static void notify(Player p, String msg) {
        p.sendMessage("[" + ChatColor.GREEN + "HomoAC" + ChatColor.RESET + "] " + msg);
    }

    public static void notify(CommandSender cs, String msg) {
        cs.sendMessage("[" + ChatColor.GREEN + "HomoAC" + ChatColor.RESET + "] " + msg);
    }
}
