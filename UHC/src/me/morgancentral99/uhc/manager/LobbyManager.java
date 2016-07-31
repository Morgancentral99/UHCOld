package me.morgancentral99.uhc.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LobbyManager implements Listener {
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		
		
		
	}

}
