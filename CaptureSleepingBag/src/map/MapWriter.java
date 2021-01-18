package map;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.burdbrains.capturesleepingbag.Main;

import mapobjs.Generator;
import mapobjs.Shopkeeper;
import net.md_5.bungee.api.ChatColor;
import team.TeamData;
import team.TeamMapData;

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
	public static void finalizeMap(Main main, Map map, Player player) 
	{
		// finalize map into map.yml
		// we need main to write a .yml file
		
		// check if Map object is completed
		String errorMsg = map.checkFinished();
		if (!map.getIsFinished()) 
		{
			player.sendMessage(errorMsg);
			
			// THIS IS JUST HERE FOR TESTING //
			writeConfig(map, player);
		}
		else 
		{
			// writeConfig method here
			writeConfig(map, player);
		}
	}
	
	// initiateFile
	// creates a file if it does not exist
	// and sets YamlConfiguration parameter
	//
	// if a file does exist it links the "file"
	// and "yml" parameters to the existing yml file
	//
	// can be used for editing function as well as finalizing
	private static boolean initiateFile(File file, YamlConfiguration yml, Player player)// throws IOException
	{
		String worldStr = player.getWorld().getName();
		try 
		{
			file = new File(Bukkit.getServer().getPluginManager().getPlugin("CaptureSleepingBag").getDataFolder(), worldStr + ".yml");
			if (!file.exists()) 
			{
				file.createNewFile();
				yml = YamlConfiguration.loadConfiguration(file);
				
				return true;
			}
			else 
			{
				player.sendMessage(ChatColor.RED + worldStr + ".yml already exists...");
				yml = YamlConfiguration.loadConfiguration(file);
				
				return false;
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			
			return false;
		}
	}
	
	
	// THIS SHOULD BE A WORK AROUND FOR THE STRANGE CASE THAT THE ABOVE FUNCTION CREATES //
	// 		PROGRAM DOESN'T LIKE LINE "modifyYmlFile.set("Name", mapName);" BECAUSE 	 //
	//   THE "initateFile" FUNCTION FOR SOME REASON DOESN'T CHANGE "modifyYmlFile" FROM  //
	//					   					 NULL										 //
	// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv //
	
	// initiateFile (just File not YamlConfiguration)
	public static File initiateFile(Player player) throws IOException
	{
		// return null if the file exists?
		// so we know
		String worldStr = player.getWorld().getName();
		
		File retFile = new File(Bukkit.getServer().getPluginManager().getPlugin("CaptureSleepingBag").getDataFolder(), worldStr + ".yml");
		
		if (!retFile.exists()) 
		{
			retFile.createNewFile();
			return retFile;
		}
		else 
		{
			player.sendMessage(ChatColor.RED + worldStr + ".yml already exists...");
			return null;
		}
	}
	
	// writeConfig method(s)
	private static void writeConfig(Map map, Player player) 
	{
		World world = map.getMapWorld();
		String worldName = world.getName();
		
		String mapName = map.getMapName();
		
		ArrayList<Generator> generators = map.getGenerators();
		
		ArrayList<Shopkeeper> shopkeepers = map.getShopkeepers();
		
		HashMap<TeamData, TeamMapData> mapData = map.getDataHash();
		
		try 
		{
			File ymlFile = initiateFile(player);
			if (ymlFile != null) 
			{
				player.sendMessage(ChatColor.GREEN + worldName + ".yml created!");
				
				// actual writing to the .yml section
				YamlConfiguration modifyYmlFile = YamlConfiguration.loadConfiguration(ymlFile);
				
				writeGenerators(generators, modifyYmlFile);
				
				modifyYmlFile.save(ymlFile);
			}
			// .yml file already exists
			else 
			{
				player.sendMessage(ChatColor.RED + worldName + ".yml already exists...");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			player.sendMessage(ChatColor.RED + "Something went wrong, please check the console.");
		}
		
		// if the file already exists
//		if (initiateFile(ymlFile, modifyYmlFile, player)) 
//		{
//			modifyYmlFile.set("Name", mapName);
//			
//			writeGenerators(generators, ymlFile, modifyYmlFile);
//		}
//		else 
//		{
//			// editing code logic here?
//			// probably not because it returns here in case of IOExcetion
//			return;
//		}
	}
	
	
	private static void writeGenerators(ArrayList<Generator> generators, YamlConfiguration yml) 
	{
		HashMap<String, HashMap<Integer, double[]>> accumulativeHash = new HashMap<>();
		
		for (int i = Generator.MIN_TIER; i <= Generator.MAX_TIER; i++) 
		{
			
			HashMap<Integer, double[]> genHash = new HashMap<>();
			
			for (Generator gen : generators) 
			{
				int count = 1;
				
				if (gen.getGenTier().getValue() == i) 
				{
					genHash.put(count, formatLocation(gen.getGenLoc()));
					count++;
				}
			}
			
			String configTier = "T" + i;
			
			accumulativeHash.put(configTier, genHash);
		}
		
		yml.set("Generators", accumulativeHash);
	}
	
	
	// formatLocation (Take Location Object and convert to list of 3 coordinates)
	private static double[] formatLocation(Location location) 
	{
		double x = location.getX();
		double y = location.getY();
		double z = location.getZ();
		
		double[] retArray = {x, y, z};
		
		return retArray;
	}
	
}
