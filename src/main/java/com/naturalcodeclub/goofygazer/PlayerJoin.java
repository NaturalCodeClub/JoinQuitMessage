package com.naturalcodeclub.goofygazer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.*;

import static org.bukkit.Bukkit.getPlayer;

public class PlayerJoin implements Listener {
    public static List<Integer> randomNumberList = new ArrayList<>();

    private static final Map<Integer, String> Sites = new HashMap<>();
    static {
        Sites.put(1, "<blue>喵呜~ <light_purple><bold>{player}</bold></light_purple> 主人来啦！欢迎回家喵！</blue>");
        Sites.put(2, "<aqua>咦~ 是 <yellow><bold>{player}</bold></yellow> 主人耶，快来一起玩嘛喵♪</aqua>");
        Sites.put(3, "<light_purple><bold>{player}</bold></light_purple> 主人终于上线了喵！我等你好久啦~");
        Sites.put(4, "<gold>欢迎欢迎~ <green>{player}</green> 主人~喵娘给你准备了小鱼干哦！</gold>");
        Sites.put(5, "<yellow><bold>{player}</bold></yellow> 主人加入了游戏！今天也一起加油喵！ฅ^•ω•^ฅ");
        Sites.put(6, "<blue>叮咚~ <bold>{player}</bold> 主人闪亮登场喵~！♥</blue>");
        Sites.put(7, "<blue><bold>{player}</bold></blue> 主人回来啦喵~ 快让我抱抱~ (>^ω^<)");
        Sites.put(8, "<yellow>正义降临！<bold>{player}</bold><red>将把恶人引向平等的死亡！\n" +
                "<blue>已至吾之时刻？<green>吾乃，{player}！");
        Sites.put(9, "<light_purple><bold>哈欠……{player}</bold></light_purple> 可真是个勤恳的人啊。这个点是怎么让自己保持清醒的啊…？");

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null); //关闭原版提示

        Player player=event.getPlayer();
        String PlayerName= player.getName();

        Random random = new Random();
        int randomNumber = random.nextInt(9)+1; //1~9
        randomNumberList.add(randomNumber);// 存进列表!!!


        String rawMessage = Sites.get(randomNumber).replace("{player}", PlayerName);
        Component message = MiniMessage.miniMessage().deserialize(rawMessage);

        //这是 Paper 专属的发送方式，必须是 adventure Component 类型
        Bukkit.broadcast(message);


    }

}
