package map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.burdbrains.capturesleepingbag.Main;

import mapobjs.GenTier;
import mapobjs.Generator;
import team.TeamData;

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
	//								  or a team upgrade shopkeeper? 														//
	//																														//
	// * /sbm set region1 <team> | sets region1 corner of 																	//
	//							   specified teams base region																//
	//																														//
	// * /sbm set region2 <team> | sets region2 corner of																	//
	//							   specified teams base region																//
	//																														//
	// * /sbm clear (shopkeepers|generators) | clear all shopkeepers for the current working								//
	//										   map object																	//
	//																														//
	// * /sbm finalize | finalize the map and write																			//
	//					 everything to a yml file																			//
	//																														//
	// * MORE COMMANDS WHEN I CAN THINK OF THEM																				//
	//																														//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private Main main;
	
	// CONSTRUCTOR //
	
	public MapCommand(Main main) 
	{
		this.main = main;
	}
	
	
	// TOOLS //
	
	private String locToStr(Location loc) 
	{
		String retStr = "";
		
		retStr += loc.getX() + ", " + loc.getY() + ", " + loc.getZ();
		
		return retStr;
	}
	
	private double roundPointFive(double round) 
	{
		double output = Math.ceil(round) - 0.5;
		return output;
	}
	
	private Location pointFiveLoc(Location location) 
	{
		World world = location.getWorld();
		
		double roundedX = roundPointFive(location.getX());
		double y = location.getY();
		double roundedZ = roundPointFive(location.getZ());
		
		Location retLoc = new Location(world, roundedX, y, roundedZ);
		
		return retLoc;
	}
	
	private boolean testInt(String str) 
	{
		try 
		{
			Integer.parseInt(str);
			return true;
		}
		catch (NumberFormatException e) 
		{
			return false;
		}
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
		if (sender instanceof Player && args.length >= 1) 
		{
			// cast the player
			Player player = (Player) sender;
			World world = player.getWorld();
			
			// check if the command is creating the map
			if (args[0].equals("create") && !this.main.playerCreatingMap(player)) 
			{
				// check if executor is within bounds of command arguments
				if (args.length >= 3)
				{
					// check whether args[1] valid int and that it isnt bigger than 8 or smaller than 2
					if (this.testInt(args[1]) && (Integer.parseInt(args[1]) >= 2 && Integer.parseInt(args[1]) <= 8))
					{
						// uses map writer to add newly established map (with command)
						// to creatingMap HashMap
						
						// ADD SOME CHECK TO SEE IF THE .YML FILE
						// ALREADY EXISTS AND SEND AN ERROR MESSAGE
						// IF THE .YML FILE DOES ALREADY EXIST
						MapWriter.createMap(this.main, args, player, world);
					}
					else 
					{
						player.sendMessage(ChatColor.RED + "Please provide a valid integer for 'max teams' argument: /sbm create <max teams> <Map Name>");
					}
				}
				else 
				{
					player.sendMessage(ChatColor.RED + "Incorrect arguments: /sbm create <max teams> <Map Name>");
				}
			}
			// or if the command is setting something in the map
			// in this case we will check that the player is in 
			// the creatingMap hashMap from the main class
			else if (this.main.playerCreatingMap(player)) 
			{
				Map map = this.main.playerGetWriter(player);
				if (map != null) 
				{
					if (args[0].equals("set"))
					{
						// player is actively creating a map
						if (this.main.playerCreatingMap(player)) 
						{
							if (args[1].equals("bag")) 
							{
								// bag setting logic
								if (args.length == 3 && this.testInt(args[2]) && map.validTeam(Integer.parseInt(args[2]))) 
								{
									int team = Integer.parseInt(args[2]);
									
									// get location at players feet
									Location loc = pointFiveLoc(player.getLocation().add(0, -1, 0));
									
									map.setMapBag(team, loc);
									
									TeamData tData = TeamData.valueOf(team);
									
									player.sendMessage(ChatColor.GRAY + "Bag successfully set for " + tData.getChatColor() + tData.getTeamName());
								}
								else 
								{
									player.sendMessage(ChatColor.RED + "Incorrect argument: /sbm set bag <team1>");
								}
							}
							else if (args[1].equals("captured")) 
							{
								// captured setting logic
								if (args.length == 4 && (this.testInt(args[2]) && this.testInt(args[3])) && (map.validTeam(Integer.parseInt(args[2])) && map.validTeam(Integer.parseInt(args[3])))) 
								{
									int team1 = Integer.parseInt(args[2]);
									int team2 = Integer.parseInt(args[3]);
									
									// get location at players feet
									Location loc = pointFiveLoc(player.getLocation().add(0, -1, 0));
									
									map.setCaptured(team1, team2, loc);
									
									TeamData tData1 = TeamData.valueOf(team1);
									TeamData tData2 = TeamData.valueOf(team2);
									
									String tName1 = tData1.getChatColor() + tData1.getTeamName() + "s";
									String tName2 = tData2.getChatColor() + tData2.getTeamName() + "s";
									
									player.sendMessage(ChatColor.GRAY + "Captured for " + tName2 + ChatColor.GRAY + "bag at" + tName1 + "base successfully set");
								}
								else 
								{
									player.sendMessage(ChatColor.RED + "Incorrect argument: /sbm set captured <team1> <team2>");
								}
							}
							else if (args[1].equals("spawn")) 
							{
								// spawn setting logic
								if (args.length == 3 && this.testInt(args[2]) && map.validTeam(Integer.parseInt(args[2]))) 
								{
									int team = Integer.parseInt(args[2]);
									
									// get location at players feet
									Location loc = pointFiveLoc(player.getLocation());
									
									map.setMapSpawn(team, loc);
									
									TeamData tData = TeamData.valueOf(team);
									
									player.sendMessage(ChatColor.GRAY + "Spawn set for " + tData.getChatColor() + tData.getTeamName());
								}
								else 
								{
									player.sendMessage(ChatColor.RED + "Incorrect argument: /sbm set spawn <team: " + ">= 1 or " + "<=" + map.getMaxTeams() + ">");
								}
							}
							else if (args[1].equals("generator")) 
							{
								// generator setting logic
								if (args.length == 3 && this.testInt(args[2]) && (Integer.parseInt(args[2]) >= Generator.MIN_TIER && Integer.parseInt(args[2]) <= Generator.MAX_TIER)) 
								{
									int tier = Integer.parseInt(args[2]);
									
									// get location at players feet
									Location loc = pointFiveLoc(player.getLocation().add(0, -1, 0));
									
									map.addGenerator(tier, loc);;
									
									GenTier gTier = GenTier.valueOf(tier);
									
									// for some reason gTier.getName() is null
									// because I never set the value parameter
									// in GenTier Enum CCx
									player.sendMessage(ChatColor.GRAY + "Generator of tier " + gTier.getName() + ChatColor.GRAY + " sucessfully set @ " + locToStr(loc));
								}
								else 
								{
									player.sendMessage(ChatColor.RED + "Incorrect argument: /sbm set shopkeeper <tier: " + ">=" + Generator.MIN_TIER + " or " + "<=" + Generator.MAX_TIER + ">");
								}
							}
							else if (args[1].equals("shopkeeper")) 
							{
								// shopkeeper setting logic
								if (args.length == 3 && this.testInt(args[2]) && (Integer.parseInt(args[2]) == 1 && Integer.parseInt(args[2]) == 0)) 
								{
									int type = Integer.parseInt(args[2]);
									
									Location loc = pointFiveLoc(player.getLocation());
									
									map.addGenerator(type, loc);
									
									if (type == 1) 
									{
										player.sendMessage(ChatColor.GRAY + "Item shop successfully set");
									}
									else 
									{
										player.sendMessage(ChatColor.GRAY + "Team shop successfully set");
									}
								}
								else 
								{
									player.sendMessage(ChatColor.RED + "Incorrect argument: /sbm set shopkeeper <1=item|0=team>");
								}
							}
							else if (args[1].equals("region1"))
							{
								// region1 setting logic
								if (args.length == 3 && this.testInt(args[2]) && map.validTeam(Integer.parseInt(args[2]))) 
								{
									int team = Integer.parseInt(args[2]);
									
									// get location at players feet
									Location loc = pointFiveLoc(player.getLocation().add(0, -1, 0));
									
									map.setMapR1(team, loc);
									
									TeamData tData = TeamData.valueOf(team);
									
									player.sendMessage(ChatColor.GRAY + "Region corner 1 set for " + tData.getChatColor() + tData.getTeamName());
								}
								else 
								{
									player.sendMessage(ChatColor.RED + "Incorrect argument: /sbm set region1 <team: " + ">= 1 or " + "<=" + map.getMaxTeams() + ">");
								}
							}
							else if (args[1].equals("region2")) 
							{
								// region2 setting logic
								if (args.length == 3 && this.testInt(args[2]) && map.validTeam(Integer.parseInt(args[2]))) 
								{
									int team = Integer.parseInt(args[2]);
									
									// get location at players feet
									Location loc = pointFiveLoc(player.getLocation().add(0, -1, 0));
									
									map.setMapR2(team, loc);
									
									TeamData tData = TeamData.valueOf(team);
									
									player.sendMessage(ChatColor.GRAY + "Spawn set for " + tData.getChatColor() + tData.getTeamName());
								}
								else 
								{
									player.sendMessage(ChatColor.RED + "Incorrect argument: /sbm set region2 <team: " + ">= 1 or " + "<=" + map.getMaxTeams() + ">");
								}
							}
							else 
							{
								player.sendMessage(ChatColor.RED + "Incorrect argument(s): /sbm set <bag|captured|spawn|generator|shopkeeper>");
							}
						}
					}
					else if (args[0].equals("clear") && args.length == 2) 
					{
						if (args[1].equals("shopkeepers")) 
						{
							map.clearShopkeepers();
						}
						else if (args[1].equals("generators")) 
						{
							map.clearGenerators();
						}
					}
					else if (args[0].equals("finalize")) 
					{
						if (args.length == 1) 
						{
							// map finalization logic
							// function from MapWriter
							MapWriter.finalizeMap(this.main, map, player);
						}
					}
				}
			}
			else 
			{
				player.sendMessage(ChatColor.RED + "Either you did not use the arguments correctly, you are trying to create a new map while already creating one, or you are trying to finalize/set something on the map without having created a map.");
			}
		}
		else 
		{
			System.out.println("[CTSB] You cannot run this command from the console.");
		}
		return false;
	}
	
}
