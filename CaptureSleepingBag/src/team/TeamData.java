package team;

import org.bukkit.ChatColor;
import org.bukkit.Color;

public enum TeamData {
	
	RED(Color.RED, ChatColor.RED, "Red"),
	BLUE(Color.BLUE, ChatColor.BLUE, "Blue"),
	GREEN(Color.GREEN, ChatColor.GREEN, "Green"),
	YELLOW(Color.YELLOW, ChatColor.YELLOW, "Yellow"),
	AQUA(Color.AQUA, ChatColor.AQUA, "Aqua"),
	WHITE(Color.WHITE, ChatColor.WHITE, "White"),
	PINK(Color.FUCHSIA, ChatColor.LIGHT_PURPLE, "Pink"),
	SILVER(Color.SILVER, ChatColor.DARK_GRAY, "Gray");
	
	private Color armorColor;
	private ChatColor chatColor;
	private String gameName;
	
	private TeamData(Color aColor, ChatColor cColor, String gName) 
	{
		this.armorColor = aColor;
		this.chatColor = cColor;
		this.gameName = gName;
	}
	
	// GETTERS
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
}
