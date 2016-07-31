package me.morgancentral99.uhc.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import me.morgancentral99.uhc.manager.UHCManager.GameState;

public class ScoreBoardManager implements Listener {
	
	public Objective o; 
	public static Scoreboard MainScoreboard;

	
	public Scoreboard scoreBoardMain(Player p) {
		Scoreboard board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
		
		o = board.registerNewObjective("Main", "dummy");
		o.setDisplayName(ChatColor.GOLD + "Override UHC");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		if(UHCManager.getState() == GameState.STARTING) {
			Score Name1 = o.getScore(ChatColor.WHITE + "Name:");
			Name1.setScore(5);
			Score Name = o.getScore(ChatColor.WHITE + p.getDisplayName());
			Name.setScore(4);
			Score Spacer = o.getScore("");
			Spacer.setScore(3);
			Score Starting = o.getScore(ChatColor.RED + "Starting in:");
			Starting.setScore(2);
			Score StartingT = o.getScore(ChatColor.GREEN + "" + LobbyTimer.getTimer());
			StartingT.setScore(1);
			p.setScoreboard(board);
		} else if (UHCManager.getState() == GameState.INGAME) {
			Score Name1 = o.getScore(ChatColor.WHITE + "Name:");
			Name1.setScore(5);
			Score Name = o.getScore(ChatColor.WHITE + p.getDisplayName());
			Name.setScore(4);
			Score Spacer = o.getScore("");
			Spacer.setScore(3);
			Score Starting = o.getScore(ChatColor.RED + "End Time:");
			Starting.setScore(2);
			Score StartingT = o.getScore(ChatColor.GREEN + "" + InGameTimer.getTimer());
			StartingT.setScore(1);
		}
		return board;
		
		
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.setScoreboard(scoreBoardMain(p));
		e.setJoinMessage(null);
		Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.GREEN + "+" + ChatColor.DARK_PURPLE + "] " + ChatColor.GREEN + e.getPlayer().getDisplayName() + ChatColor.GOLD + " Has joined Mega UHC " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
	}
}
