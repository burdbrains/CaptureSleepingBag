package mapobjs;

import org.bukkit.Location;

public class Shopkeeper {
	
	private Location shopLocation;
	
	// 1 is team shop
	// 0 is item shop
	private ShopType shopType;
	
	public Shopkeeper() 
	{
		this.shopLocation = null;
		this.shopType = ShopType.Item;
	}
	
	public Shopkeeper(Location loc, int shopType) 
	{
		this.shopLocation = loc;
		this.shopType = ShopType.valueOf(shopType);
	}
	
	
	// SETTERS //
	public void setShopLoc(Location loc) 
	{
		this.shopLocation = loc;
	}
	
	public void setShopType(int itemShop) 
	{
		this.shopType = ShopType.valueOf(itemShop);
	}
	
	// GETTERS //
	public Location getShopLoc() 
	{
		return this.shopLocation;
	}
	
	public ShopType getShopType() 
	{
		return this.shopType;
	}

}
