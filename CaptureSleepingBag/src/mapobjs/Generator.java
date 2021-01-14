package mapobjs;

import org.bukkit.Location;

public class Generator {
	
	private Location genLocation;
	
	private GenTier genTier;
	
	public Generator() 
	{
		this.genLocation = null;
		this.genTier = null;
	}
	
	public Generator(Location loc, GenTier tier) 
	{
		this.genLocation = loc;
		this.genTier = tier;
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
