package com.naturalcodeclub.goofygazer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.*;

public class PlayerQuit implements Listener{
    public static List<Integer> randomNumberList2 = new ArrayList<>();

    private static final Map<Integer, String> Sites2 = new HashMap<>();
    static {
        Sites2.put(1, "<gray><bold>{player}</bold></gray> 主人悄悄溜走了喵……人家会想你的~");
        Sites2.put(2, "<dark_red>{player}</dark_red> 主人下线了喵…要记得早点回来陪我玩哦！");
        Sites2.put(3, "<red><bold>{player}</bold></red> 主人离开游戏了，猫猫心碎了喵 QAQ");
        Sites2.put(4, "<aqua>{player}</aqua> 主人走了…别忘了带小鱼干回来喵~");
        Sites2.put(5, "<dark_purple>" + "唔呣~ <bold>{player}</bold> 主人要走了吗？人家不舍得喵……</dark_purple>");
        Sites2.put(6, "{player} <gray><italic>主人轻轻地走了，正如他轻轻地来喵…</italic></gray>");
        Sites2.put(7, "<blue>战胜逆境者方为英雄。来日<bold><shadow:#000000FF><b>{player}</b></shadow>></bold>将再度出征！</blue>");
        Sites2.put(8, "<dark_purple>委托内容稍有些复杂，但……并非<bold>{player}</bold>无法解决之事！毕竟吾奉行的是将障碍物全部粉碎消灭的主义呢。</dark_purple>");
        Sites2.put(9, "<gray><italic>感觉像是轻松地散了个步。现在回去的话……会遇到{player}吧。 哎呀~</italic></gray>");
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        event.quitMessage(null); //关闭原版提示

        Player player=event.getPlayer();
        String PlayerName= player.getName();

        Random random = new Random();
        int randomNumber2 = random.nextInt(9)+1; //1~9
        randomNumberList2.add(randomNumber2); //存进列表!!!


        String rawMessage = Sites2.get(randomNumber2).replace("{player}", PlayerName);
        Component message = MiniMessage.miniMessage().deserialize(rawMessage);

        //这是 Paper 专属的发送方式，必须是 adventure Component 类型
        Bukkit.broadcast(message); //全局广播


    }

}