package me.morgancentral99.uhc.manager;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import me.morgancentral99.uhc.Main;
import net.md_5.bungee.api.ChatColor;

public class UHCManager {
	
	static Main m;
	
	public enum GameState {
		STARTING, INGAME, ENDING, RELOADING, ERROR;
	}
	
	public boolean teamsEnabled;
	public static Player playerWon;

//	private HashMap<Player, Integer> timer = new HashMap<Player, Integer>();

	private static World w;
	private static boolean isEnding;
	private static GameState state;
	
	public UHCManager(Main m) {
		UHCManager.m = m;
	}
	
	public static void onServerStart() {
		state = GameState.STARTING;
		
		
		
		
	}
	
	public void onGameStart() {
		if(Bukkit.getOnlinePlayers().size() >= Bukkit.getMaxPlayers());
	//	InGameTimer.setTimer(1500);
	}
	
	public void onEnd() {
		state = GameState.ENDING;
		Bukkit.broadcastMessage(ChatColor.GOLD + "The Winner of the UHC is " + playerWon);
		Bukkit.broadcastMessage(ChatColor.GOLD + "Server restarting in 1 minute");
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(m, new Runnable() {
			public void run() {
				Bukkit.reload();
			}
		}, 20L);
	}

	public void setTeamEnabled(boolean b) {
		this.teamsEnabled = b;
	}
	
	public boolean getTeamsEnabled() {
		return teamsEnabled;
	}

	/**
	 * @return the isEnding
	 */
	public static boolean isEnding() {
		return isEnding;
	}

	/**
	 * @param isEnding the isEnding to set
	 */
	public static void setEnding(boolean isEnding) {
		UHCManager.isEnding = isEnding;
	}
	/*
	 * @return who won the game
	 */
	
	public static Player getPlayerWon() {
		return playerWon;
	}

	/**
	 * @return the state
	 */
	public static GameState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(GameState state) {
		this.state = state;
	}

	/**
	 * @return the timer
	 */
}
