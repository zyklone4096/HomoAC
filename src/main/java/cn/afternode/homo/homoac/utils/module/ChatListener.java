package cn.afternode.homo.homoac.utils.module;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public interface ChatListener extends Listener, HomoListener {
    @EventHandler
    void onPlayerChat(AsyncPlayerChatEvent event);
}
