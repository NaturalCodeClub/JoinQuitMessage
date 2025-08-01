package org.ncc.JoinQuitMessage;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinQuitMessage extends JavaPlugin implements Listener {
    public static JavaPlugin instance;

    @Override
    public void onLoad() {
        getLogger().info("JoinQuitMessage插件已成功加载！");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("joinquitmessage.admin")){// 判断输入的指令是否是/joinquitmessage
            ConfigManager.reloadConfig();
            sender.sendMessage("JoinQuitMessage配置文件已成功重新加载！");
            return true; // 返回true防止返回指令的usage信息
        }
        return false;
    }

    @Override
    public void onEnable() {
        instance = this;
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
