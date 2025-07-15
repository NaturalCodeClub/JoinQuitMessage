package org.ncc.JoinQuitMessage;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinQuitMessage extends JavaPlugin implements Listener {
    public static JavaPlugin instance;

    @Override
    public void onLoad() {
        getLogger().info("JoinQuitMessage插件已成功加载！");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("joinquitmessage")){// 判断输入的指令是否是/joinquitmessage
            if (!(sender instanceof Player)) { // 判断输入者的类型 为了防止出现 控制台或命令方块 输入的情况
                sender.sendMessage("你必须是一名玩家!");
                return true; // 返回true只因该输入者不是玩家,并不是输入错指令,故返回true
            }
            //如果sender是一名玩家，可以将其强转为Player对象,把它作为一个"玩家"来处理
            Player player = (Player) sender;
            //重新加载配置文件
            ConfigManager.initConfig();  // 确保配置文件存在（如果被删除会重新创建）
            ConfigManager.loadConfig();  // 从文件加载最新配置

            player.sendMessage("JoinQuitMessage配置文件已成功重新加载！");
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
