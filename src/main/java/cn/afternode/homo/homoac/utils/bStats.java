package cn.afternode.homo.homoac.utils;

import cn.afternode.homo.homoac.HomoAC;
import org.bstats.bukkit.Metrics;

public class bStats {
    public static final int ID = 16498;

    public final Metrics METRICS;

    public bStats() {
        METRICS = new Metrics(HomoAC.INSTANCE, ID);
    }

    public void init() {

    }
}
