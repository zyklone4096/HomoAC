package cn.afternode.homo.homoac.commands;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.Settings;
import cn.afternode.homo.homoac.managers.UserManager;
import cn.afternode.homo.homoac.utils.Command;
import cn.afternode.homo.homoac.utils.module.Module;
import cn.afternode.homo.homoac.utils.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand extends Command {
    public MainCommand() {
        super("homo");
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(ChatColor.AQUA).append("HomoAC ").
                append(ChatColor.GREEN).append("Community Edition").
                append(ChatColor.RESET).append("\n");

        if (args.length == 0) {
            sb.append(ChatColor.YELLOW).append("/homoac help");
            sender.sendMessage(sb.toString());
            return true;
        }

        switch (args[0]) {
            case "help":
                break;
            case "analyse":
                if (args.length < 2) {
                    sb.append(ChatColor.RED).append("错误：需要玩家名称");
                    break;
                }

                Player player = Bukkit.getPlayer(args[1]);
                if (player == null || !player.isOnline()) {
                    sb.append(ChatColor.RED).append("错误：玩家不存在或不在线");
                    break;
                }

                User user = HomoAC.USER_MANAGER.getUser(player);
                sb.append("显示名称：").append(player.getDisplayName()).append("\n");
                sb.append("UUID：").append(player.getUniqueId().toString()).append("\n");
                if (sender.hasPermission("homoac.admin")
                && HomoAC.SETTINGS.SHOW_IP) {
                    sb.append("登录IP：").append(player.getAddress().toString()).append("\n");
                }
                if (user.VL.keySet().size() != 0) {
                    sb.append(ChatColor.RED).append("玩家Vl数值：");
                    for(Module module: user.VL.keySet()) {
                        sb.append(ChatColor.BLUE).
                                append(module.NAME).append(" - ").append(user.getVl(module))
                        .append(ChatColor.RESET).append("\n");
                    }
                } else {
                    sb.append(ChatColor.GREEN).append("此玩家没有已记录的Vl\n");
                }
                break;
            default:
                sb.append(ChatColor.YELLOW).append("/homoac help");
        }

        sender.sendMessage(sb.toString());
        return true;
    }

    @Override
    public void onLoad() {
        String pm = ChatColor.AQUA + "HomoAC " + ChatColor.GREEN + "Community Edition\n" +
                ChatColor.RED + "你没有权限执行任何指令";
        getCommand().setPermissionMessage(pm);
    }
}
