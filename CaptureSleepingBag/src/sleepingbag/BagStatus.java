package sleepingbag;

import org.bukkit.ChatColor;

public enum BagStatus {
	
	Safe(ChatColor.GREEN + "Safe", true, false),
	Taken(ChatColor.YELLOW + "Taken", true, true),
	Captured(ChatColor.RED + "Captured", false, true),
	Retrieving(ChatColor.BLUE + "Retrieving", false, true);
	
	private String display;
	private boolean respawn;
	private boolean pickup;
	// add pick up boolean variable?
	
	private BagStatus(String display, boolean respawn, boolean pickup) 
	{
		this.display = display;
		this.respawn = respawn;
		this.pickup = pickup;
	}
	
	// GETTERS //
	public String getDisplay() 
	{
		return this.display;
	}
	
	public boolean getRespawn() 
	{
		return this.respawn;
	}
	
	public boolean canPickup() 
	{
		return this.pickup;
	}

}
