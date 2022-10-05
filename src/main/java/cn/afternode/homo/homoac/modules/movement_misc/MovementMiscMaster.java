package cn.afternode.homo.homoac.modules.movement_misc;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.utils.module.Module;

public class MovementMiscMaster extends Module {
    public MovementMiscMaster() {
        super("MovementMisc");
        banVl = 20;
    }

    @Override
    public void init() {
        if (HomoAC.PROP_ENABLED && HomoAC.EXT_PROPERTY.PHASE_ENABLED) {
            addListener(new Phase(this));
        }
    }
}
