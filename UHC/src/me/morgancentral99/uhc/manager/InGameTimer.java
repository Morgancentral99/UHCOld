package me.morgancentral99.uhc.manager;

import org.bukkit.scheduler.BukkitRunnable;

import me.morgancentral99.uhc.LoggerAPI;
import me.morgancentral99.uhc.Main;

public class InGameTimer extends BukkitRunnable {

	public static int InGameTimer;

	public static int getTimer() {
		return InGameTimer;
	}

	public static void setTimer(int inGameTimer) {
		InGameTimer = inGameTimer;
	}

	Main m;

	public InGameTimer(int InGameTimer) {
		me.morgancentral99.uhc.manager.InGameTimer.InGameTimer = InGameTimer;
	}

	@Override
	public void run() {
		if (InGameTimer != 0) {
			LoggerAPI.debug("Timer:" + InGameTimer);
			InGameTimer--;
		}

	}

}
