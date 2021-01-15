package com.burdbrains.capturesleepingbag;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import map.Map;
import map.MapCommand;
import map.MapWriter;

public class Main extends JavaPlugin {
	
	///////////// Main class /////////////
	// Main class will be used to link  //
	// all objects and classes together //
	//////////////////////////////////////
	
	// public final String CTSB_PREFIX = ChatColor.; <--- consider adding this, but in many cases it is ugly
	
	
	//// MAP WRITER SECTION ////
	
	// ATTRIBUTES //
	private HashMap<Player, Map> creatingMap = new HashMap<>();
	
	// TOOLS //
	public boolean playerCreatingMap(Player player) 
	{
		if (this.creatingMap.get(player) != null) 
		{
			return true;
		}
		
		return false;
	}
	
	public Map playerGetWriter(Player player) 
	{
		if (this.playerCreatingMap(player)) 
		{
			return this.creatingMap.get(player);
		}
		
		return null;
	}
	
	
	// SETTER(S) [or in the case of the hashmap it would be adder] //
	public boolean addCreatingMap(Player player, Map map) 
	{
		if (!this.playerCreatingMap(player)) 
		{
			this.creatingMap.put(player, map);
			return true;
		}
		
		return false;
	}
	
	
	//// BASIC PLUGIN SECTION ////
	@Override
	public void onLoad() 
	{
		// placeholder
	}
	
	@Override
	public void onEnable() 
	{
		this.getCommand("sbm").setExecutor(new MapCommand(this));
		
		// placeholder
	}
	
	@Override
	public void onDisable() 
	{
		// placeholder
	}
}
