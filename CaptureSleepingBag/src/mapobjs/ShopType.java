package mapobjs;

import java.util.HashMap;

public enum ShopType {
	
	Item("Item", 0),
	Team("Team", 1);
	
	private String typeDisplay;
	private int value;
	
	private static HashMap<Integer, ShopType> dataMap = new HashMap<>();
	
	
	private ShopType(String tDisplay, int val) 
	{
		this.typeDisplay = tDisplay;
		
		this.value = val;
	}
	
	
	static 
	{
		for (ShopType shop : ShopType.values()) 
		{
			dataMap.put(shop.getValue(), shop);
		}
	}
	
	public static ShopType valueOf(int val) 
	{
		return dataMap.get(val);
	}
	
	
	// GETTERS //
	
	public String getDisplay() 
	{
		return this.typeDisplay;
	}
	
	public int getValue() 
	{
		return this.value;
	}
	
}
