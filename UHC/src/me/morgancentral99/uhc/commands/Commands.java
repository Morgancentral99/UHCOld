package me.morgancentral99.uhc.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Commands {

	public static void commandHelp(CommandSender s) {
		s.sendMessage(ChatColor.GRAY + "-------" + ChatColor.GREEN + "UHC Help" + ChatColor.GRAY + "-------");
		s.sendMessage(ChatColor.GOLD + "");
	}

}
