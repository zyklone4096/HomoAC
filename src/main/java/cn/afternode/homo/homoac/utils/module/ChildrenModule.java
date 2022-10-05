package cn.afternode.homo.homoac.utils.module;

public class ChildrenModule {
    public final Module PARENT;
    public final String BAN_REASON;

    public ChildrenModule(Module parent) {
        PARENT = parent;
        BAN_REASON = parent.banReason;
    }

    public ChildrenModule(Module parent, String banReason) {
        PARENT = parent;
        BAN_REASON = banReason;
    }

    public void init() {}
}
