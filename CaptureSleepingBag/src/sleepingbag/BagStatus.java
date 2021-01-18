package sleepingbag;

import org.bukkit.ChatColor;

public enum BagStatus {
	
	SAFE(ChatColor.GREEN + "Safe", true, false),
	TAKEN(ChatColor.YELLOW + "Taken", true, true),
	CAPTURED(ChatColor.RED + "Captured", false, true),
	RETRIEVING(ChatColor.BLUE + "Retrieving", false, true);
	
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
