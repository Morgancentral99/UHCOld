package me.morgancentral99.uhc;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.craftbukkit.v1_10_R1.CraftServer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.morgancentral99.uhc.commands.UHCCommand;
import me.morgancentral99.uhc.manager.MOTDManager;
import me.morgancentral99.uhc.manager.ScoreBoardManager;
import me.morgancentral99.uhc.manager.UHCManager;
import me.morgancentral99.uhc.servermanager.ConfigWrapper;

public class Main extends JavaPlugin {
	
	private static Plugin plugin;
	Main m;
	
	public static Main instance;
	public static boolean debug = true ; 
	public static ConfigWrapper Config;
	//private static boolean isEnabled = plugin.getConfig().getBoolean("Enabled");
	
	
	@Override
	public void onEnable() {
		LoggerAPI.info("Loaded UHC");
		World UHCWORLD = this.getServer().createWorld(new WorldCreator("UHCWorld"));
		UHCManager.onServerStart();
		registerListeners();
		registerCommands();
	}

	private void registerCommands() {
		((CraftServer)this.getServer()).getCommandMap().register("UHC", new UHCCommand("UHC"));
		
	}

	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ScoreBoardManager(), this);
		pm.registerEvents(new MOTDManager(m), this);
		
	}

	public static Main getInstance() {
		return instance;
	}
	
	public static String getPrefix() {
		return "&6[&5UHC&6]";
		
	}

}
