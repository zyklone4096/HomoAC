package cn.afternode.homo.homoac.managers;

import cn.afternode.homo.homoac.bots.Bot;

import java.util.HashMap;
import java.util.UUID;

public class BotManager implements Manager{
    private final HashMap<UUID, Bot> bots = new HashMap<>();

    @Override
    public void init() {

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
        bot.getEntity().remove();
        bots.remove(bot.getUuid());
    }
}
