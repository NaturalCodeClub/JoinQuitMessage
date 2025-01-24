package com.naturalcodeclub.joinquitmessage;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.entity.Player;

public class LoginQuitMessage implements Listener {
    private final JoinQuitMessage plugin;

    public LoginQuitMessage(JoinQuitMessage plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(plugin.getRandomJoinMessage(player.getName()).toString());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(plugin.getRandomQuitMessage(player.getName()).toString());
    }
}