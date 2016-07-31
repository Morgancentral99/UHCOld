package me.morgancentral99.uhc.manager;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;

public class WorldBoarderTest {
	
	static World world = Bukkit.getWorld("UHC");
	
	public static WorldBorder border = world.getWorldBorder();
	
	
	public static int Size;
	
	public WorldBoarderTest() {
		
	}
	public static void setSize(int s) {
		WorldBoarderTest.Size = s;
		border.setCenter(0.0, 0.0);
		border.setSize(s);
	}
	
	public static int returnSize() {
		return Size;
	}
	
	

}
