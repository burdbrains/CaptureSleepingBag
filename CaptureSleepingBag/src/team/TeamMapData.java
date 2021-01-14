package team;

import java.util.ArrayList;

import org.bukkit.Location;

public class TeamMapData {
	
	private Double[] region1;
	private Double[] region2;
	
	private int otherTeams; // team count - 1
	
	private ArrayList<Location> capturedLocations;
	private Location spawnLocation;
	
	private Location bagLocation;
	
	private TeamData teamData;
	
	public TeamMapData(TeamData data, int maxTeams) 
	{
		this.teamData = data;
		this.otherTeams = maxTeams-1;
	}
	
	
	// GETTERS //
	private TeamData getTeamData() 
	{
		return this.teamData;
	}

}
