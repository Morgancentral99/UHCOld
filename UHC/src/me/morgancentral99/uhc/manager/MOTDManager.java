package me.morgancentral99.uhc.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.morgancentral99.uhc.Main;
import me.morgancentral99.uhc.manager.UHCManager.GameState;

public class MOTDManager implements Listener {
	
	Main m;
	private GameState state;
	
	public MOTDManager(Main m) {
		this.m = m;
		this.state = UHCManager.getState(); 
	}
	
	@EventHandler
	public void onPlayerPingEvent(ServerListPingEvent e) {
		if(GameState.STARTING == state) {
			e.setMaxPlayers(100);
			e.setMotd(ChatColor.GOLD + "Welcome to UHC Mega there are currently" + ChatColor.GREEN + Bukkit.getOnlinePlayers().size() + ChatColor.GOLD + "/" + Bukkit.getMaxPlayers());
		} else if (GameState.INGAME == state) {
			e.setMotd(ChatColor.GOLD + "UHC Mega is currently running!");
		} else if (GameState.ENDING == state) {
			e.setMotd(ChatColor.GOLD + "UHC Mega is currently ending. Server restarting soon!!!");
		} else if (GameState.RELOADING == state) {
			e.setMaxPlayers(0);
			e.setMotd(ChatColor.RED + "UHC Restarting!");
		}
	}

}