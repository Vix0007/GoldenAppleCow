package net.vix.gacow;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications; // Needed for Biomes
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;     // Needed to select Mushroom Fields
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;                 // Needed for "MUSHROOM_FIELDS"
import net.vix.gacow.entity.GoldenAppleCowEntity;
import net.vix.gacow.entity.ModEntities;
import net.vix.gacow.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GAcow implements ModInitializer {
	public static final String MOD_ID = "gacow";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

@Override
public void onInitialize() {
	ModItems.registerModItems();
	ModEntities.registerModEntities();

	// 1. Register Attributes
	FabricDefaultAttributeRegistry.register(ModEntities.GOLDEN_APPLE_COW, GoldenAppleCowEntity.createCowAttributes());

	// 2. Strict Spawn Restriction (Mycelium Only)
	SpawnRestriction.register(
			ModEntities.GOLDEN_APPLE_COW,
			SpawnLocationTypes.ON_GROUND,
			Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
			(type, world, spawnReason, pos, random) ->
					world.getBlockState(pos.down()).isOf(net.minecraft.block.Blocks.MYCELIUM)
							&& world.getLightLevel(pos, 0) > 8
	);

	// 3. Biome Selection (Mushroom Fields Only)
	BiomeModifications.addSpawn(
			BiomeSelectors.includeByKey(BiomeKeys.MUSHROOM_FIELDS),
			SpawnGroup.CREATURE,
			ModEntities.GOLDEN_APPLE_COW,
			8,  // Weight (8 matches Mooshrooms)
			2,  // Min group size
			4   // Max group size
	);

	LOGGER.info("Golden Apple Cows successfully restricted to Mycelium in Mushroom Fields!");
} }