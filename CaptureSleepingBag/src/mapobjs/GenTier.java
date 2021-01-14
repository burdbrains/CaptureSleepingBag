package mapobjs;

import org.bukkit.Material;

import org.bukkit.ChatColor;

public enum GenTier {
	
	One(Material.IRON_INGOT, ChatColor.WHITE + "IRON"),
	Two(Material.GOLD_INGOT, ChatColor.GOLD + "GOLD"),
	Three(Material.NETHERITE_INGOT, ChatColor.DARK_GRAY + "NETHERITE");
	
	private Material tierMat;
	private String tierName;
	
	private GenTier(Material material, String name) 
	{
		this.tierMat = material;
		this.tierName = name;
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

}
