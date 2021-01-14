package map;

import java.util.ArrayList;

import org.bukkit.World;

import mapobjs.Generator;
import mapobjs.Shopkeeper;
import team.Team;
import team.TeamMapData;

public class Map {
	
	////////////////////////////// Map class //////////////////////////////
	// This class is for ease of use when establishing a game from a map //
	// since this will written to from the MapReader class it will store //
	// all the information needed for starting a game with a map		 //
	//																	 //
	// since this will hold all the information read from a map.yml, we  //
	// will also use this for writing to a map with MapWriter			 //
	///////////////////////////////////////////////////////////////////////
	
	// private boolean writingMap;
	
	private String mapName;
	
	private World mapWorld;
	
	private int teamCount;
	private ArrayList<TeamMapData> teamsData;
	
	private ArrayList<Generator> generators;
	
	private ArrayList<Shopkeeper> shopkeepers;
	
	public Map(World world, int maxTeams, String name) 
	{
		this.mapWorld = world;
		
		this.teamCount = maxTeams;
		
		this.mapName = name;
	}

}
