package mapobjs;

import org.bukkit.Material;

import team.TeamData;

import java.util.HashMap;

import org.bukkit.ChatColor;

public enum GenTier {
	
	One(Material.IRON_INGOT, ChatColor.WHITE + "IRON", 1),
	Two(Material.GOLD_INGOT, ChatColor.GOLD + "GOLD", 2),
	Three(Material.NETHERITE_INGOT, ChatColor.DARK_GRAY + "NETHERITE", 3);
	
	private Material tierMat;
	private String tierName;
	
	private int value;
	
	private static HashMap<Integer, GenTier> dataMap = new HashMap<>();
	
	private GenTier(Material material, String name, int value) 
	{
		this.tierMat = material;
		this.tierName = name;
	}
	
	static 
	{
		for (GenTier tier : GenTier.values()) 
		{
			dataMap.put(tier.getValue(), tier);
		}
	}
	
	public static GenTier valueOf(int genTier) 
	{
		return dataMap.get(genTier);
	}
	
	
	// GETTERS //
	public Material getMaterial() 
	{
		return this.tierMat;
	}
	
	public String getName() 
	{
		return this.tierName;
	}
	
	public int getValue() 
	{
		return this.value;
	}

}
