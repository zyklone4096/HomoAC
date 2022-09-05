package cn.afternode.homo.homoac.modules.fly;

import cn.afternode.homo.homoac.utils.module.Module;

public class FlyMaster extends Module {
    public FlyMaster() {
        super("Fly");
    }

    @Override
    public void init() {
        banVl = 20;
        flagVl = 13;
        banReason = "奇怪的移动方式增加了(恼)";

        addListener(new FlyA(this));
    }
}
