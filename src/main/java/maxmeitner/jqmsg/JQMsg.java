package maxmeitner.jqmsg;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class JQMsg extends JavaPlugin {
    private static JQMsg plugin;
    public JQMsg() {}

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        getCommand("jqmsg").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {}

    public static JQMsg getPlugin() {return plugin;}
}