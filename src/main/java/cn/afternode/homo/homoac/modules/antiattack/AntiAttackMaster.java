package cn.afternode.homo.homoac.modules.antiattack;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.module.Module;

public class AntiAttackMaster extends Module {
    public AntiAttackMaster() {
        super("AntiAttack");
    }

    @Override
    public void init() {
        if (HomoAC.PROP_ENABLED && HomoAC.EXT_PROPERTY.EMP_ENABLED) {
            addListener(new AntiAttackA(this));
        }
    }
}
