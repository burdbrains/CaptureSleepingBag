package team;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import sleepingbag.BagStatus;

public class Team {
	
	//////////////////////////////////////////
	// Team object used for a game instance //
	// responsible for handling all things	//
	// related to teams						//
	//////////////////////////////////////////
	
	private int teamCount;
	
	private ArrayList<Player> teamMembers;
	
	// change this to Bag object
	// b/c bag object will hold BagStatus
	//
	// private Bag sleepingBag;
	//
	private BagStatus bagStatus;
	
	private TeamData teamData;
	private TeamMapData mapData;
	
	

}
