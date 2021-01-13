package map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MapCommand implements CommandExecutor {

	//////////////////////////////////////////////////// MapCommand class ////////////////////////////////////////////////////
	// MapCommand is responsible for working with MapCreator and															//
	// providing all the commands to create a map and map.yml																//
	//																														//
	// for ease of use sake and implementation sake we will use numbers 													//
	// instead of team names when actually using the command to create a map												//
	//																														//
	// 							!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!						//
	// 							!! COMMANDS SHOULD ALWAYS SET THE COORDINATES TO THE PLAYER'S FEET !!						//
	// 							!! 					NOT THEIR ACTUAL LOCATION					   !!						//
	// 							!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!						//
	//																														//
	//																														//
	// Commands (sbm stands for Sleeping Bag Map):																			//
	//																														//
	// * /sbm create <worldname> <max teams> | creates a worldname.yml file that											//
	//								 		   will be written to with other commands 										//
	//								 		   (also teleports the player to the given world)								//
	//																														//
	// * /sbm set bag <team> | sets the cordinates of the teams sleeping bag												//
	//						   at the location of the players feet															//
	//																														//
	// * /sbm set captured <team1> <team2> | sets the captured location of team2's bag for									//
	//										 for team1 at the players feet (so if team1 = red and team2 = blue				//
	//										 this will be the location at red teams base where blue teams captured bed sits)//
	//																														//
	// * /sbm set spawn <team> | sets the given teams 																		//
	//							 respawn location																			//
	//																														//
	// * /sbm set generator <gen tier> | sets the location to a generator													//
	//									 of the given tier (as an integer													//
	//									 [Hypixel — Iron:1, Gold:2, Diamond:3, Emerald:4])									//
	//																														//
	// * MORE COMMANDS WHEN I CAN THINK OF THEM																				//
	//																														//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// placeholder for command implementation
		//
		// create individual methods for each command function
		// (in MapCreator class) for the sake of cleanliness
		//
		// use this method purely for the sake of organizing the
		// handling of the commands to be implemented
		return false;
	}
	
}
