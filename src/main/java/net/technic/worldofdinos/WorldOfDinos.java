package net.technic.worldofdinos;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Mod(modid = WorldOfDinos.MODID, version = WorldOfDinos.VERSION)
public class WorldOfDinos
{
	public static final String MODID = "worldofdinos";
	public static final String VERSION = "1.0";
	public static Logger logger = Logger.getLogger("WorldOfDinos");

	public static List<Integer> OutfittedBiomeList = new ArrayList<Integer>();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger.setParent(FMLLog.getLogger());
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		Property biomeList = config.get("general", "dinoBiomeIdList", "");
		biomeList.comment = "A comma-separated list of integer Biome IDs where dinos should spawn.";

		String[] biomes = biomeList.getString().split(",");

		for (String biome : biomes) {
			if (!biome.isEmpty()) {
				Integer biomeId = Integer.parseInt(biome);
				OutfittedBiomeList.add(biomeId);
			}
		}

		config.save();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new DinoWorldLoadHandler());
	}
}
