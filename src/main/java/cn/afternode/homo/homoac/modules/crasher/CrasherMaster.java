package cn.afternode.homo.homoac.modules.crasher;

import cn.afternode.homo.homoac.HomoAC;
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

        if (HomoAC.PROP_ENABLED && HomoAC.EXT_PROPERTY.NOCOM_ENABLED) {
            addListener(new Nocom(this));
        }
    }
}
