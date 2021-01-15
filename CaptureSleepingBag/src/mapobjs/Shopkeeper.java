package mapobjs;

import org.bukkit.Location;

public class Shopkeeper {
	
	private Location shopLocation;
	
	// 0 is team shop
	// 1 is item shop
	private int itemShop;
	
	public Shopkeeper() 
	{
		this.shopLocation = null;
		this.itemShop = 0;
	}
	
	public Shopkeeper(Location loc, int itemShop) 
	{
		this.shopLocation = loc;
		this.itemShop = itemShop;
	}
	
	
	// SETTERS //
	public void setShopLoc(Location loc) 
	{
		this.shopLocation = loc;
	}
	
	public void setItemShop(int itemShop) 
	{
		this.itemShop = itemShop;
	}
	
	// GETTERS //
	public Location getShopLoc() 
	{
		return this.shopLocation;
	}
	
	public int isItemShop() 
	{
		return this.itemShop;
	}

}
