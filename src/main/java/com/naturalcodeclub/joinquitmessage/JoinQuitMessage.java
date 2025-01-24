package com.naturalcodeclub.joinquitmessage;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class JoinQuitMessage extends JavaPlugin {
    private String joinMessageFormat;
    private String quitMessageFormat;
    private final Map<Integer, String> joinMessages = new HashMap<>();
    private final Map<Integer, String> quitMessages = new HashMap<>();
    private final Random random = new Random();

    public Component getRandomJoinMessage(String playerName) {
        int index = random.nextInt(joinMessages.size()); // 生成 0 到 size-1 的随机索引
        String message = joinMessages.get(index).replace("{player}", playerName);
        return MiniMessage.miniMessage().deserialize(message);
    }

    public Component getRandomQuitMessage(String playerName) {
        int index = random.nextInt(quitMessages.size());
        String message = quitMessages.get(index).replace("{player}", playerName);
        return MiniMessage.miniMessage().deserialize(message);
    }


    @Override
    public void onEnable() {
        saveDefaultConfig(); // 确保 config.yml 存在
        loadMessages(); // 读取消息
        getLogger().info("JoinQuitMessage 插件已启用！");
        getServer().getPluginManager().registerEvents(new LoginQuitMessage(this), this);
    }
        private void loadMessages() {
            FileConfiguration config = getConfig();

            // 读取 join_messages（List）
            List<String> joinList = config.getStringList("join_messages");
            if (joinList.isEmpty()) {
                joinList = List.of("<green>欢迎 <light_purple><bold>{player}</bold></light_purple>!",
                        "<yellow>{player} 加入了，我们一起玩吧！",
                        "<aqua>欢迎 {player}，祝你游戏愉快！");
            }

            // 读取 quit_messages（List）
            List<String> quitList = config.getStringList("quit_messages");
            if (quitList.isEmpty()) {
                quitList = List.of("<red>{player} 离开了，希望下次再见！",
                        "<dark_red>{player} 退出了，期待你的归来！",
                        "<gray>{player} 默默离开了......");
            }

            // 存入 Map（索引从 0 开始）
            for (int i = 0; i < joinList.size(); i++) {
                joinMessages.put(i, joinList.get(i));
            }
            for (int i = 0; i < quitList.size(); i++) {
                quitMessages.put(i, quitList.get(i));
            }
        }

    public Component formatJoinMessage(String playerName) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        return miniMessage.deserialize(joinMessageFormat.replace("{player}", playerName));
    }

    public @Nullable Component formatQuitMessage(String playerName) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        return miniMessage.deserialize(quitMessageFormat.replace("{player}", playerName));
    }
}