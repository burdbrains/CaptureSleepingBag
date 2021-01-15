package mapobjs;

import org.bukkit.Location;

public class Generator {
	
	public static final int MIN_TIER = 1;
	public static final int MAX_TIER = 3;
	
	private Location genLocation;
	
	private GenTier genTier;
	
	public Generator() 
	{
		this.genLocation = null;
		this.genTier = null;
	}
	
	public Generator(Location loc, int tier) 
	{
		this.genLocation = loc;
		
		if (tier >= MIN_TIER && tier <= MAX_TIER) 
		{
			this.genTier = GenTier.valueOf(tier);
		}
		else 
		{
			this.genTier = GenTier.One;
		}
	}
	
	
	// ESTABLISHING GENERATOR //
	public void createGenerator() 
	{
		// BukkitScheduler
		// Runnable stuff
	}
	
	// SETTERS //
	public void setGenLoc(Location loc) 
	{
		this.genLocation = loc;
	}
	
	public void setGenTier(GenTier tier) 
	{
		this.genTier = tier;
	}
	
	
	// GETTERS //
	public Location getGenLoc() 
	{
		return this.genLocation;
	}
	
	public GenTier getGenTier() 
	{
		return this.genTier;
	}

}
