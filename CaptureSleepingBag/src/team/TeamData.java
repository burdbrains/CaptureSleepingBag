package team;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Color;

public enum TeamData {
	
	RED(Color.RED, ChatColor.RED, "Red", 1),
	BLUE(Color.BLUE, ChatColor.BLUE, "Blue", 2),
	GREEN(Color.GREEN, ChatColor.GREEN, "Green", 3),
	YELLOW(Color.YELLOW, ChatColor.YELLOW, "Yellow", 4),
	AQUA(Color.AQUA, ChatColor.AQUA, "Aqua", 5),
	WHITE(Color.WHITE, ChatColor.WHITE, "White", 6),
	PINK(Color.FUCHSIA, ChatColor.LIGHT_PURPLE, "Pink", 7),
	SILVER(Color.SILVER, ChatColor.DARK_GRAY, "Gray", 8);
	
	private Color armorColor;
	private ChatColor chatColor;
	private String gameName;
	
	private int value;
	
	private static HashMap<Integer, TeamData> dataMap = new HashMap<>();
	
	// CONSTRUCTOR //
	private TeamData(Color aColor, ChatColor cColor, String gName, int val) 
	{
		this.armorColor = aColor;
		this.chatColor = cColor;
		this.gameName = gName;
		this.value = val;
	}
	
	// HASHMAP //
	static 
	{
		for (TeamData teamData : TeamData.values()) 
		{
			dataMap.put(teamData.getValue(), teamData);
		}
	}
	
	public static TeamData valueOf(int teamData) 
	{
		return dataMap.get(teamData);
	}
	
	// GETTERS //
	public Color getArmorColor() 
	{
		return this.armorColor;
	}
	
	public ChatColor getChatColor() 
	{
		return this.chatColor;
	}
	
	public String getTeamName() 
	{
		return this.gameName;
	}
	
	public int getValue() 
	{
		return this.value;
	}
}
