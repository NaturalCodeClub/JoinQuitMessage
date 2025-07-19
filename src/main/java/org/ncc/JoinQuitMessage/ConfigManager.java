package org.ncc.JoinQuitMessage;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class ConfigManager {
    private static final File configFile = new File(JoinQuitMessage.instance.getDataFolder(), "config.yml");
    private static FileConfiguration config = JoinQuitMessage.instance.getConfig();
    private static List<String> defaultJoinMessage = List.of("<yellow>{player} 加入了游戏");
    private static List<String> defaultQuitMessage = List.of("<yellow>{player} 退出了游戏");

    public static List<String> joinMessage;
    public static List<String> quitMessage;

    public static void initConfig() {
        boolean b = false;
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            try {
                configFile.createNewFile();
                b = true;
            } catch (IOException e) {
                JoinQuitMessage.instance.getLogger().log(Level.SEVERE, e.getMessage());
            }
        }
        if (config.get("join-message") == null) {
            config.set("join-message", defaultJoinMessage);
            b = true;
        }
        if (config.get("quit-message") == null) {
            config.set("quit-message", defaultQuitMessage);
            b = true;
        }
        if(b){
            try {
                config.save(configFile);
            } catch (IOException e) {
                JoinQuitMessage.instance.getLogger().log(Level.SEVERE, e.getMessage());
            }
        }

    }

    public static void loadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
        joinMessage = config.getStringList("join-message").isEmpty() ? defaultJoinMessage : config.getStringList("join-message");
        quitMessage = config.getStringList("quit-message").isEmpty() ? defaultQuitMessage : config.getStringList("quit-message");
    }

    public static void reloadConfig() {
        initConfig();
        loadConfig();
    }
}
