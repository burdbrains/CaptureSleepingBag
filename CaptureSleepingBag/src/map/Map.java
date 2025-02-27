package map;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.World;

import com.burdbrains.capturesleepingbag.Main;

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
	
	public final int MAX_TEAMS = 8;
	
	public final int MIN_TEAMS = 2;
	
	
	
	// private boolean writingMap;
	
	private Main main;
	
	private String mapName;
	
	private World mapWorld;
	
	private int teamCount;
	
	private ArrayList<TeamData> allTeams;
	
	private ArrayList<TeamMapData> teamsMapData;
	// private HashMap<TeamData, TeamMapData> teamsMapData;
	
	private ArrayList<Generator> generators;
	
	private ArrayList<Shopkeeper> shopkeepers;
	
	private boolean isFinished;
	
	public Map(Main main, World world, int maxTeams, String name) 
	{
		this.main = main;
		
		this.mapWorld = world;
		
		this.setTeamCount(maxTeams);
		
		this.mapName = name;
		
		this.allTeams = new ArrayList<>();
		this.teamsMapData = new ArrayList<>();
		this.generators = new ArrayList<>();
		this.shopkeepers = new ArrayList<>();
		
		this.isFinished = false;
		
		this.establishAllTeams();
		this.establishMapData();
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
	
	// check if an integer value is a valid team in 
	// the maps HashMap of teams
	
	
	//public static volatile String errorStr = "";
	// check if all the values in this instance (specifically TeamMapData) are filled in
	// if not add to the return String the things that are
	// not finished
	public String checkFinished() 
	{
		this.isFinished = true;
		
		String errorStr = "";
		
		for (TeamMapData tmData : this.teamsMapData) 
		{
			errorStr += tmData.checkFinished();
			
			if (!tmData.getIsFinished()) 
			{
				this.isFinished = false;
			}
		}
		
		return errorStr;
	}
	
	public boolean validTeam(int teamVal) 
	{
		TeamData tData = TeamData.valueOf(teamVal);
		if (this.allTeams.contains(tData)) 
		{
			return true;
		}
		
		return false;
	}
	
	
	private void establishAllTeams() 
	{
		for (int i = 1; i <= this.teamCount; i++) 
		{
			TeamData tData = TeamData.valueOf(i);
			this.allTeams.add(tData);
		}
	}
	
	
	// set TeamData values in teamsMapData hashmap
	// for later use in object
	private void establishMapData()
	{
		for (TeamData tData : this.allTeams) 
		{
			TeamMapData tmData = new TeamMapData(tData, this.teamCount);
			this.teamsMapData.add(tmData);
		}
	}
	
	
	// GETTERS //
	
	public boolean getIsFinished() 
	{
		return this.isFinished;
	}
	
	public World getMapWorld() 
	{
		return this.mapWorld;
	}
	
	public String getMapName() 
	{
		return this.mapName;
	}
	
	public int getMaxTeams() 
	{
		return this.teamCount;
	}
	
	public ArrayList<Generator> getGenerators()
	{
		return this.generators;
	}
	
	public ArrayList<Shopkeeper> getShopkeepers()
	{
		return this.shopkeepers;
	}
	
	public ArrayList<TeamMapData> getDataHash()
	{
		return this.teamsMapData;
	}
	
	// get the TeamMapData
	private TeamMapData getMapData(int teamVal) 
	{
		if (this.validTeam(teamVal)) 
		{
			TeamData tData = TeamData.valueOf(teamVal);
			
			for (TeamMapData tmData : this.teamsMapData) 
			{
				if (tmData.getTeamData().equals(tData)) 
				{
					return tmData;
				}
			}
		}
		
		return null;
	}
	
	
	// SETTERS //
	public void setTeamCount(int tCount) 
	{
		if (tCount > MAX_TEAMS) 
		{
			this.teamCount = MAX_TEAMS;
		}
		else if (tCount < MIN_TEAMS) 
		{
			this.teamCount = MIN_TEAMS;
		}
		else 
		{
			this.teamCount = tCount;
		}
	}
	
	public void setMapBag(int teamVal, Location bagLoc) 
	{
		TeamMapData tmData = this.getMapData(teamVal);
		if (tmData != null) 
		{
			tmData.setBagLocation(bagLoc);
		}
	}
	
	public void setMapSpawn(int teamVal, Location spawnLoc) 
	{
		TeamMapData tmData = this.getMapData(teamVal);
		if (tmData != null) 
		{
			tmData.setSpawnLocation(spawnLoc);
		}
	}
	
	public void setMapR1(int teamVal, Location region1Loc) 
	{
		TeamMapData tmData = this.getMapData(teamVal);
		if (tmData != null) 
		{
			tmData.setRegion1(region1Loc);
		}
	}
	
	public void setMapR2(int teamVal, Location region2Loc) 
	{
		TeamMapData tmData = this.getMapData(teamVal);
		if (tmData != null) 
		{
			tmData.setRegion1(region2Loc);
		}
	}
	
	public void setCaptured(int team1, int team2, Location capturedLoc) 
	{
		TeamMapData tmData = this.getMapData(team1);
		if (tmData != null) 
		{
			tmData.setCaptured(team2, capturedLoc);
		}
	}
	
	// GENERATORS //
	public void addGenerator(int tier, Location loc) 
	{
		Generator newGen = new Generator(loc, tier);
		this.generators.add(newGen);
	}
	
	public void clearGenerators() 
	{
		this.generators.clear();
	}
	
	
	// SHOPKEEPERS //
	public void addShopkeeper(int type, Location loc) 
	{
		if (type == 1 || type == 0) 
		{
			Shopkeeper newShop = new Shopkeeper(loc, type);
			this.shopkeepers.add(newShop);
		}
	}
	
	public void clearShopkeepers() 
	{
		this.shopkeepers.clear();
	}

}
