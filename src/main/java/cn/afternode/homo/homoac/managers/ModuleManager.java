package cn.afternode.homo.homoac.managers;

import cn.afternode.homo.homoac.HomoAC;
import cn.afternode.homo.homoac.modules.fly.FlyMaster;
import cn.afternode.homo.homoac.utils.module.Module;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager implements Manager{
    public List<Module> registeredModules = new ArrayList<>();

    @Override
    public void init() {
        List<Module> pre = new ArrayList<>();
        pre.add(new FlyMaster());

        for (Module module: pre) {
            loadModule(module);
        }
    }

    public void loadModule(Module module) {
        try {
            module.init();
            Bukkit.getPluginManager().registerEvents(module, HomoAC.INSTANCE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
