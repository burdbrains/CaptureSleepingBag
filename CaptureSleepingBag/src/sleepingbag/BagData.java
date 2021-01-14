package sleepingbag;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum BagData {
	
	RED(redBag()),
	BLUE(blueBag()),
	GREEN(greenBag()),
	YELLOW(yellowBag()),
	AQUA(aquaBag()),
	WHITE(whiteBag()),
	PINK(pinkBag()),
	SILVER(silverBag());
	
	private ItemStack bagItem;
	
	private BagData(ItemStack item) 
	{
		this.bagItem = item;
	}
	
	// GETTER
	public ItemStack getBag() 
	{
		return this.bagItem;
	}
	
	
	// CREATE BAG ITEMSTACKS //
	private static ItemStack redBag() 
	{
		ItemStack bag = new ItemStack(Material.RED_DYE);
		ItemMeta bagMeta = bag.getItemMeta();
		bagMeta.setDisplayName(ChatColor.RED + "Red Sleeping Bag");
		bag.setItemMeta(bagMeta);
		
		return bag;
	}
	
	private static ItemStack blueBag()
	{
		ItemStack bag = new ItemStack(Material.BLUE_DYE);
		ItemMeta bagMeta = bag.getItemMeta();
		bagMeta.setDisplayName(ChatColor.BLUE + "Blue Sleeping Bag");
		bag.setItemMeta(bagMeta);
		
		return bag;
	}
	
	private static ItemStack greenBag()
	{
		ItemStack bag = new ItemStack(Material.GREEN_DYE);
		ItemMeta bagMeta = bag.getItemMeta();
		bagMeta.setDisplayName(ChatColor.GREEN + "GREEN Sleeping Bag");
		bag.setItemMeta(bagMeta);
		
		return bag;
	}
	
	private static ItemStack yellowBag()
	{
		ItemStack bag = new ItemStack(Material.YELLOW_DYE);
		ItemMeta bagMeta = bag.getItemMeta();
		bagMeta.setDisplayName(ChatColor.YELLOW + "Yellow Sleeping Bag");
		bag.setItemMeta(bagMeta);
		
		return bag;
	}
	
	private static ItemStack aquaBag()
	{
		ItemStack bag = new ItemStack(Material.CYAN_DYE);
		ItemMeta bagMeta = bag.getItemMeta();
		bagMeta.setDisplayName(ChatColor.AQUA + "Aqua Sleeping Bag");
		bag.setItemMeta(bagMeta);
		
		return bag;
	}
	
	private static ItemStack whiteBag()
	{
		ItemStack bag = new ItemStack(Material.BLUE_DYE);
		ItemMeta bagMeta = bag.getItemMeta();
		bagMeta.setDisplayName(ChatColor.WHITE + "White Sleeping Bag");
		bag.setItemMeta(bagMeta);
		
		return bag;
	}
	
	private static ItemStack pinkBag()
	{
		ItemStack bag = new ItemStack(Material.PINK_DYE);
		ItemMeta bagMeta = bag.getItemMeta();
		bagMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Sleeping Bag");
		bag.setItemMeta(bagMeta);
		
		return bag;
	}
	
	private static ItemStack silverBag()
	{
		ItemStack bag = new ItemStack(Material.BLUE_DYE);
		ItemMeta bagMeta = bag.getItemMeta();
		bagMeta.setDisplayName(ChatColor.DARK_GRAY + "Silver Sleeping Bag");
		bag.setItemMeta(bagMeta);
		
		return bag;
	}

}
