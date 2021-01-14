package map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.burdbrains.capturesleepingbag.Main;

import net.md_5.bungee.api.ChatColor;

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
	// * /sbm create <max teams> <Map Name> | creates a worldname.yml file that									//
	//								 		   			  will be written to with other commands 							//
	//								 		   			  (also teleports the player to the given world)					//
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
	// * /sbm set shopkeeper <type> | sets the location to either an item shopkeeper										//
	//								  or a team upgrade shopkeeper?															//
	//																														//
	// * /sbm finalize | finalize the map and write																			//
	//					 everything to a yml file																			//
	//																														//
	// * MORE COMMANDS WHEN I CAN THINK OF THEM																				//
	//																														//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private Main main;
	
	public MapCommand(Main main) 
	{
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		///////////////////////////////////////////////////////////
		// placeholder for command implementation				 //
		//														 //
		// create individual methods for each command function	 //
		// (in MapCreator class) for the sake of cleanliness	 //
		//														 //
		// use this method purely for the sake of organizing the //
		// handling of the commands to be implemented			 //
		///////////////////////////////////////////////////////////
		
		
		// Make sure the command executor is a player
		if (sender instanceof Player && args.length > 1) 
		{
			// cast the player
			Player player = (Player) sender;
			
			// check if the command is creating the map
			if (args[0].equals("create")) 
			{
				// check if executor is within bounds of command arguments
				if (args.length >= 3)
				{
					// run MapWriter creation and putting into HashMap logic
				}
				else 
				{
					player.sendMessage(ChatColor.RED + "Incorrect arguments: /sbm create <worldname> <max teams> <Map Name>");
				}
			}
			// or if the command is setting something in the map
			// in this case we will check that the player is in 
			// the creatingMap hashMap from the main class
			else if (args[0].equals("set"))
			{
				// player is actively creating a map
				if (this.main.playerCreatingMap(player)) 
				{
					if (args[1].equals("bag")) 
					{
						// bag setting logic
					}
					else if (args[1].equals("captured")) 
					{
						// captured setting logic
					}
					else if (args[1].equals("spawn")) 
					{
						// spawn setting logic
					}
					else if (args[1].equals("generator")) 
					{
						// generator setting logic
					}
					else if (args[1].equals("shopkeeper")) 
					{
						// shopkeeper setting logic
					}
					else 
					{
						player.sendMessage(ChatColor.RED + "Incorrect argument(s): /sbm set (bag|captured|spawn|generator|shopkeeper)");
					}
				}
			}
			else if (args[0].equals("finalize")) 
			{
				if (args.length == 1) 
				{
					// map finalization logic
					// function from MapWriter
				}
			}
		}
		else 
		{
			System.out.println("[CTSB] You cannot run this command from the console.");
		}
		return false;
	}
	
}
