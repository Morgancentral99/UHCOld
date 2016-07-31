package me.morgancentral99.uhc.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import me.morgancentral99.uhc.Main;

public class GameManager extends UHCManager{

	public GameManager(Main m) {
		super(m);
	}
	
	public void onGameStarting() {
		Bukkit.broadcastMessage("Starting in 1 minute"); 
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
			
			private int STimer = 60;

			@Override
			public void run() {
				Bukkit.broadcastMessage(ChatColor.GOLD + "Starting in " + STimer);
				STimer --;
					
			}
		}, 2);
	}

}
