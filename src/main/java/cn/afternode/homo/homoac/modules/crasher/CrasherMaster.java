package cn.afternode.homo.homoac.modules.crasher;

import cn.afternode.homo.homoac.utils.module.Module;

public class CrasherMaster extends Module {
    public CrasherMaster() {
        super("Crasher");
        banVl = 5;
    }

    @Override
    public void init() {
        addListener(new CrasherA(this));
        addListener(new CrasherB(this));
        addListener(new CrasherC(this));
    }
}
