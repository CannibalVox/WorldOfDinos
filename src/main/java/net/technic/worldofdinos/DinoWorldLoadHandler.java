package net.technic.worldofdinos;

import net.fossilsarch.common.entity.EntityBrachiosaurus;
import net.fossilsarch.common.entity.EntityMammoth;
import net.fossilsarch.common.entity.EntityMosasaurus;
import net.fossilsarch.common.entity.EntityNautilus;
import net.fossilsarch.common.entity.EntityPlesiosaur;
import net.fossilsarch.common.entity.EntityPterosaur;
import net.fossilsarch.common.entity.EntityRaptor;
import net.fossilsarch.common.entity.EntitySaberCat;
import net.fossilsarch.common.entity.EntityStegosaurus;
import net.fossilsarch.common.entity.EntityTRex;
import net.fossilsarch.common.entity.EntityTriceratops;
import net.fossilsarch.common.entity.Entitydil;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DinoWorldLoadHandler {

	private Map<Integer, BiomeGenBase> mBiomeMap = new HashMap<Integer, BiomeGenBase>();

	@ForgeSubscribe
	public void WorldLoad(WorldEvent.Load loadEvent) {
		for (int i = 0; i < WorldOfDinos.OutfittedBiomeList.size(); i++) {
			Integer biomeId = WorldOfDinos.OutfittedBiomeList.get(i);
			int intBiomeId = biomeId.intValue();
			if (BiomeGenBase.biomeList[intBiomeId] != null && (!mBiomeMap.containsKey(biomeId) || mBiomeMap.get(biomeId) != BiomeGenBase.biomeList[intBiomeId])) {

				WorldOfDinos.logger.fine("Outfitting "+BiomeGenBase.biomeList[intBiomeId].biomeName);

				outfitSpawnList(BiomeGenBase.biomeList[intBiomeId].getSpawnableList(EnumCreatureType.creature));
				outfitWaterSpawnList(BiomeGenBase.biomeList[intBiomeId].getSpawnableList(EnumCreatureType.waterCreature));

				if (mBiomeMap.containsKey(biomeId))
					mBiomeMap.remove(biomeId);

				mBiomeMap.put(biomeId, BiomeGenBase.biomeList[intBiomeId]);
			}
		}
	}

	private void outfitSpawnList(List biomeSpawnList) {
		biomeSpawnList.add(new SpawnListEntry(EntityTriceratops.class, 10, 4, 4));
		biomeSpawnList.add(new SpawnListEntry(EntityBrachiosaurus.class, 6, 1, 3));
		biomeSpawnList.add(new SpawnListEntry(EntityPterosaur.class, 10, 4, 4));
		biomeSpawnList.add(new SpawnListEntry(EntityTRex.class, 3, 1, 1));
		biomeSpawnList.add(new SpawnListEntry(Entitydil.class, 6, 1, 3));
		biomeSpawnList.add(new SpawnListEntry(EntityRaptor.class, 6, 4, 8));
		biomeSpawnList.add(new SpawnListEntry(EntityMammoth.class, 10, 2, 4));
		biomeSpawnList.add(new SpawnListEntry(EntitySaberCat.class, 10, 2, 4));
		biomeSpawnList.add(new SpawnListEntry(EntityStegosaurus.class, 10, 4, 4));
	}

	private void outfitWaterSpawnList(List biomeSpawnList) {
		biomeSpawnList.add(new SpawnListEntry(EntityNautilus.class, 10, 4, 14));
		biomeSpawnList.add(new SpawnListEntry(EntityPlesiosaur.class, 5, 1, 4));
		biomeSpawnList.add(new SpawnListEntry(EntityMosasaurus.class, 1, 1, 1));
	}
}
