package me.morgancentral99.uhc.manager;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import me.morgancentral99.uhc.LoggerAPI;
import me.morgancentral99.uhc.Main;

public class LobbyTimer{
	
	public static int LobbyTimer1;

	public static int getTimer() {
		return LobbyTimer1;
	}

	public static void setTimer(int a) {
		LobbyTimer1 = a;
		
	}

	Main m;

	public LobbyTimer(final int LobbyTimer) {
		me.morgancentral99.uhc.manager.LobbyTimer.LobbyTimer1 = LobbyTimer;
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(m, new Runnable() {
			
			@Override
			public void run() {
				if(LobbyTimer1 != 0) {
					LoggerAPI.debug("Timer:" + LobbyTimer);
					LobbyTimer1--;
				}
				
			}
		}, 20L, 20L);
	}
	
	

//	@Override
//	public void run() {
//		if (LobbyTimer != 0) {
//			LoggerAPI.debug("Timer:" + LobbyTimer);
//			LobbyTimer--;
//		}
//

}

