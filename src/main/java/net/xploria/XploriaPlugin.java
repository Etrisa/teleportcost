package net.xploria;

import org.bukkit.plugin.java.JavaPlugin;

public class XploriaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        XploriaListener xploriaListener = new XploriaListener();
        this.getCommand("etrisa").setExecutor(xploriaListener);
        this.getServer().getPluginManager().registerEvents(xploriaListener, this);
    }

}
