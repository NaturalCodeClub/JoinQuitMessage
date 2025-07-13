package org.ncc.JoinQuitMessage;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinQuitMessage extends JavaPlugin implements Listener {
    public static JoinQuitMessage instance;

    @Override
    public void onLoad() {
        getLogger().info("JoinQuitMessage插件已成功加载！");
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);    //注册事件
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
        ConfigManager.initConfig();
        ConfigManager.loadConfig();
        if(!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            getLogger().warning("PlaceHolderAPI is needed for further features.");
        }
        getLogger().info("JoinQuitMessage插件已成功启用！");
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("JoinQuitMessage插件已成功禁用！");
    }

}
