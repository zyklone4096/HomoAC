package cn.afternode.homo.homoac.commands;

import cn.afternode.homo.homoac.bots.AuraBot;
import cn.afternode.homo.homoac.utils.Command;
import cn.afternode.homo.homoac.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BotCommand extends Command {
    public BotCommand() {
        super("homo-bot");
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length < 2) {
            PlayerUtils.notify(sender, "Usage: homo-bot <target> <duration-seconds>");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        long duration = 60;
        try {
            duration = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            PlayerUtils.notify(sender, "Illegal duration, using default (60s)");
        }

        AuraBot ab = new AuraBot(target, sender, duration);
        PlayerUtils.notify(sender, "AuraBot created with id " + ab.getUuid() + ", duration is " + duration + " seconds");

        return true;
    }
}
