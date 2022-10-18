package cn.afternode.homo.homoac.utils;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;
import org.jetbrains.annotations.Nullable;

public class BedrockUtil {
    private static FloodgateApi fapi = null;
    private static boolean useAble = false;

    public static void init () {
        if (Bukkit.getPluginManager().getPlugin("Floodgate") != null) {
            fapi = FloodgateApi.getInstance();
            HomoAC.LOGGER.info("Floodgate hooked");
            useAble = true;
        }
    }

    public static boolean isUseAble() {
        return useAble;
    }

    public static @Nullable FloodgateApi getFapi() {
        return fapi;
    }

    public static boolean isFloodgatePlayer(Player player) {
        return fapi != null && fapi.isFloodgatePlayer(player.getUniqueId());
    }

    public static boolean isFloodgatePlayer(User user) {
        return isFloodgatePlayer(user.PLAYER);
    }
}
