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
        Sites.put(1, "<green>欢迎 <light_purple><bold>{player}</bold></light_purple> 加入游戏！</green>");
        Sites.put(2, "<yellow>{player} 加入了，我们一起玩吧！");
        Sites.put(3, "<aqua>欢迎 {player}，祝你游戏愉快！");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player=event.getPlayer();
        String PlayerName= player.getName();

        Random random = new Random();
        int randomNumber = random.nextInt(3)+1; //1~3
        randomNumberList.add(randomNumber);// 存进列表!!!


        String rawMessage = Sites.get(randomNumber).replace("{player}", PlayerName);
        Component message = MiniMessage.miniMessage().deserialize(rawMessage);

        //这是 Paper 专属的发送方式，必须是 adventure Component 类型
        player.sendMessage(message);

    }

}
