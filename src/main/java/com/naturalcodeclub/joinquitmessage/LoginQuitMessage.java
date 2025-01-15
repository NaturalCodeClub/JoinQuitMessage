package com.naturalcodeclub.joinquitmessage;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LoginQuitMessage implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerLoginEvent event){
        Player player =event.getPlayer();
        Component joinMessage = /*buildJoinMessage*/(player.getName());
        player.sendMessage(joinMessage);
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player =event.getPlayer();
        Component quitMessage = /*buildQuitMessage*/(player.getName());
        player.getServer().broadcast(quitMessage);
    }



    private Component buildJoinMessage(String playerName) {
        return Component.text("欢迎 ")
                .color(NamedTextColor.GREEN)
                .append(Component.text(playerName)
                        .color(NamedTextColor.LIGHT_PURPLE)
                        .decorate(TextDecoration.BOLD))
                .append(Component.text(" 加入游戏！")
                        .color(NamedTextColor.GREEN));
    }
    private Component buildJoinMessage(String playerName) {
        return Component.text("欢迎 ")
                .color(NamedTextColor.GREEN)
                .append(Component.text(playerName)
                        .color(NamedTextColor.LIGHT_PURPLE)
                        .decorate(TextDecoration.BOLD))
                .append(Component.text(" 加入游戏！")
                        .color(NamedTextColor.GREEN));
    }
    private Component buildQuitMessage(String playerName) {
        return Component.text("再见了，")
                .color(NamedTextColor.RED)
                .append(Component.text(playerName)
                        .color(NamedTextColor.LIGHT_PURPLE)
                        .decorate(TextDecoration.ITALIC))
                .append(Component.text("！期待你的归来！")
                        .color(NamedTextColor.RED));
    }
}
