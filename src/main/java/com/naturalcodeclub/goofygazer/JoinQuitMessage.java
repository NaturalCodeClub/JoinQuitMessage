package com.naturalcodeclub.goofygazer;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.event.player.PlayerJoinEvent;

public final class JoinQuitMessage extends JavaPlugin implements Listener {

    @Override
    public  void onLoad(){
        getLogger().info("JoinQuitMessage插件已成功加载！");
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(),this);    //注册事件
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(),this);
        getLogger().info("JoinQuitMessage插件已成功启用！");

        // Plugin startup logic


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("JoinQuitMessage插件已成功禁用！");

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

    }
}
