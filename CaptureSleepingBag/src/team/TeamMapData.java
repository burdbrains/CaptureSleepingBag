package team;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;

import map.Map;
import net.md_5.bungee.api.ChatColor;

public class TeamMapData {
	
	private Location region1;
	private Location region2;
	
	private int otherTeams; // team count - 1
	
	private HashMap<TeamData, Location> capturedLocations;
	private Location spawnLocation;
	
	private Location bagLocation;
	
	private TeamData teamData;
	
	
	// CONSTRUCTOR(S) //
	public TeamMapData(TeamData data, int maxTeams) 
	{
		this.teamData = data;
		this.otherTeams = maxTeams-1;
		
		this.capturedLocations = new HashMap<>();
		
		this.initializeHash();
	}
	
	// TOOLS //
	
	static volatile String retStr = "";
	
	public String checkFinished() 
	{	
		retStr = "";
		if (this.region1 != null && this.region2 != null && this.spawnLocation != null && this.bagLocation != null) 
		{
			this.capturedLocations.forEach((
					(key, value) 
					-> {
						if (value == null) 
						{
							retStr += teamData.getChatColor() + teamData.getTeamName() + ChatColor.GRAY + " teams captured location for " + key.getChatColor() + key.getTeamName() + ChatColor.GRAY + "bag\n";
						}	
					}
					));
		}
		
		return retStr;
	}
	
	// GETTERS //
	public Location getRegion1() 
	{
		return this.region1;
	}
	
	public Location getRegion2() 
	{
		return this.region2;
	}
	
	public Location getSpawn() 
	{
		return this.spawnLocation;
	}
	
	public Location getBagLocation() 
	{
		return this.bagLocation;
	}
	
	public TeamData getTeamData() 
	{
		return this.teamData;
	}
	
	
	
	// SETTERS //
	public void setRegion1(Location loc) 
	{
		this.region1 = loc;
	}
	
	public void setRegion2(Location loc) 
	{
		this.region2 = loc;
	}
	
	public void setSpawnLocation(Location loc) 
	{
		this.spawnLocation = loc;
	}
	
	public void setBagLocation(Location loc) 
	{
		this.bagLocation = loc;
	}
	
	// HASHMAP //
	
	// Initializes HashMap so captured can be set instead of added
	// in setCaptured() function
	public void initializeHash() 
	{
		for (int i = 1; i <= this.otherTeams; i++) 
		{
			TeamData tData = TeamData.valueOf(i);
			this.capturedLocations.put(tData, null);
		}
	}
	
	// checks if capturedTeam is contained in HashMap
	public void setCaptured(int capturedTeam, Location loc) 
	{
		if (this.capturedLocations.containsKey(TeamData.valueOf(capturedTeam))) 
		{
			TeamData tData = TeamData.valueOf(capturedTeam);
			
			this.capturedLocations.put(tData, loc);
		}
		else 
		{
			System.out.println("Captured team location doesn't exist.");
		}
	}
	
	
	
	

}
