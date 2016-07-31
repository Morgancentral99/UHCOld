package me.morgancentral99.uhc.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import me.morgancentral99.uhc.Main;
import me.morgancentral99.uhc.manager.LobbyTimer;
import net.md_5.bungee.api.ChatColor;

public class UHCCommand extends BukkitCommand {

	public UHCCommand(String name) {
		super(name);
		this.description = "Main Command for UHC";
		this.usageMessage = "/UHC";
		this.setPermission("UHC.Main");
		
	}

	@Override
	public boolean execute(CommandSender s, String cmd, String[] args) {
		if(!s.hasPermission(this.getPermission())) {
			s.sendMessage(ChatColor.RED + "You do not have permission to run this command");
			return true;
		}
		if(args.length != 1) {
			Commands.commandHelp(s);
		}
		if(args[0].equalsIgnoreCase("SetTimer")) {
			LobbyTimer.setTimer(60);
		} else if (args[0].equalsIgnoreCase("debug")) {
			if(Main.debug == true) {
				Main.debug = false;
				s.sendMessage(ChatColor.RED + "Debug: Disabled");
			} else if(Main.debug == false) {
				s.sendMessage(ChatColor.RED + "Debug: Enabled");
				Main.debug = true;
			}
		} else if (args[0].equalsIgnoreCase("DebugStatus")) {
			s.sendMessage(ChatColor.RED + "Debug Status: " + Main.debug);
		}
		return false;
	}

}
