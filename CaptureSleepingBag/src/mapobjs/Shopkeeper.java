package mapobjs;

import org.bukkit.Location;

public class Shopkeeper {
	
	private Location shopLocation;
	
	private boolean itemShop;
	
	public Shopkeeper() 
	{
		this.shopLocation = null;
		this.itemShop = false;
	}
	
	public Shopkeeper(Location loc, boolean itemShop) 
	{
		this.shopLocation = loc;
		this.itemShop = itemShop;
	}
	
	
	// SETTERS //
	public void setShopLoc(Location loc) 
	{
		this.shopLocation = loc;
	}
	
	public void setItemShop(boolean itemShop) 
	{
		this.itemShop = itemShop;
	}
	
	// GETTERS //
	public Location getShopLoc() 
	{
		return this.shopLocation;
	}
	
	public boolean isItemShop() 
	{
		return this.itemShop;
	}

}
