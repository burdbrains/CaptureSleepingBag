package map;

import java.util.ArrayList;

import org.bukkit.World;

import mapobjs.Generator;
import mapobjs.Shopkeeper;
import team.Team;
import team.TeamData;
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
	
	
	///////////////////////////////////////////////////////////////////////////
	// Ability to write to TeamMapData values needs to be added				 //
	// in addition to this Map needs to be able to handle an integer value	 //
	// for a team and look into the teamsData ArrayList and change the value //
	// it is told to based on the integer it recieves.						 //
	///////////////////////////////////////////////////////////////////////////
	// Also need to continue functionality for adding and removing Generators//
	// and functionality for adding and removing Shopkeepers				 //
	///////////////////////////////////////////////////////////////////////////
	
	
	// TOOLS //
	
	// loop through max number of teams and use
	// TeamData hashmap to get an enum per int value
	// in loop of max teams
	public void establishMapData()
	{
		for (int i = 1; i <= this.teamCount; i++) 
		{
			TeamData tData = TeamData.valueOf(i);
			TeamMapData tmData = new TeamMapData(tData, this.teamCount);
			teamsData.add(tmData);
		}
	}
	
	// OBJECT ADDERS //
	public void addGenerator() 
	{
		
	}
	
	public void addShopkeeper() 
	{
		
	}

}
