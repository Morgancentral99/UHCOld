package me.morgancentral99.uhc;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;

public class LoggerAPI {
	
	private Main instance;
	//private static boolean debug;
	static Logger logger = Bukkit.getLogger();

	
	public LoggerAPI(Main instance) {
		this.instance = instance;
	//	this.debug = me.morgancentral99.uhc.Main.debug;
	}
	
	public static void debug(String msg) {
		if(Main.debug == true) {
			logger.log(Level.INFO, msg);
		}
		
	}
	public static void info(String msg) {
		logger.log(Level.INFO, msg);
	}
	public static void severe(String msg) {
		logger.log(Level.SEVERE, msg);
	}

}
