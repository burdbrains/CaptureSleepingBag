package map;

import org.bukkit.World;
import org.bukkit.entity.Player;

import com.burdbrains.capturesleepingbag.Main;

public class MapWriter {
	
	////////////////////// MapWriter class //////////////////////
	// This class is responsible for methods used to write	   //
	// the custom yml file, uses a Map object to be written to //
	// (basically there will be a method(s) for each command   //
	// used to create a map in this class)					   //
	/////////////////////////////////////////////////////////////
	
	public static void createMap(Main main, String[] args, Player player, World world) 
	{
		// define maxTeams integer;
		int maxTeams = Integer.parseInt(args[1]);
		
		// parse team name args
		String mapName = "";
		
		for (int i = 2; i < args.length; i++)
		{
			mapName += args[i] + " ";
		}
		
		mapName = mapName.substring(0, mapName.length()-1);
		
		// establish map object and add to creatingMap class
		Map map = new Map(main, world, maxTeams, mapName);
		
		// add to main hashMap
		main.addCreatingMap(player, map);
	}
	
	// writes the map to a .yml file
	public static void finalizeMap(Main main, Map map) 
	{
		// finalize map into map.yml
		
	}
	
	
	// Write Location (Take Location Object and convert to list of 3 coordinates)
	
}
