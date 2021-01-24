package team;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;

import map.Map;

public class TeamMapData {
	
	private Location region1;
	private Location region2;
	
	private int maxTeams; // team count - 1 (not true anymore has to include self in team count for 
	
	private HashMap<TeamData, Location> capturedLocations;
	private Location spawnLocation;
	
	private Location bagLocation;
	
	private TeamData teamData;
	
	private boolean isFinished;
	
	
	// CONSTRUCTOR(S) //
	public TeamMapData(TeamData data, int maxTeams) 
	{
		this.teamData = data;
		this.maxTeams = maxTeams;
		
		this.capturedLocations = new HashMap<>();
		
		this.isFinished = false;
		
		this.initializeHash();
	}
	
	// TOOLS //
	
	static volatile String retStr = "";
	// check if all the values in this instance are filled in
	// if not add to the return String the things that are
	// not finished
	public String checkFinished() 
	{	
		retStr = "";
		
		this.isFinished = true;
		
		retStr += "\n\n" + this.teamData.getChatColor() + ChatColor.BOLD.toString() + this.teamData.getTeamName() + ":" + "\n" + ChatColor.RESET;
		
		this.capturedLocations.forEach((
				(key, value) 
				-> {
					if (value == null) 
					{
						retStr += ChatColor.GRAY + "Captured location for " + key.getChatColor() + key.getTeamName() + ChatColor.GRAY + " bag" + "\n";
						this.isFinished = false;
					}	
				}
				));
		
		if (this.region1 == null) 
		{
			retStr += ChatColor.GRAY + "Region corner 1" + "\n";
			this.isFinished = false;
		}
		if (this.region2 == null)
		{
			retStr += ChatColor.GRAY + "Region corner 2" + "\n";
			this.isFinished = false;
		}
		if (this.spawnLocation == null) 
		{
			retStr += ChatColor.GRAY + "Spawn location" + "\n";
			this.isFinished = false;
		}
		if (this.bagLocation == null) 
		{
			retStr += ChatColor.GRAY + "Bag location" + "\n";
			this.isFinished = false;
		}
		
		return retStr;
	}
	
	// GETTERS //
	public boolean getIsFinished() 
	{
		return this.isFinished;
	}
	
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
		for (int i = 1; i <= this.maxTeams; i++) 
		{
			if (!TeamData.valueOf(i).equals(this.teamData)) 
			{
				TeamData tData = TeamData.valueOf(i);
				this.capturedLocations.put(tData, null);
			}
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
			System.out.println("Captured team location doesn't exist or is the team it's being set for.");
		}
	}
	
	
	
	

}
