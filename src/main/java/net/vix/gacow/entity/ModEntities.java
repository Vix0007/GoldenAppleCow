package net.vix.gacow.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.vix.gacow.GAcow;

public class ModEntities {
    // 1. Create the Key (ID)
    public static final RegistryKey<EntityType<?>> GOLDEN_APPLE_COW_KEY = RegistryKey.of(
            RegistryKeys.ENTITY_TYPE,
            Identifier.of(GAcow.MOD_ID, "golden_apple_cow")
    );

    // 2. Build the Entity Type
    public static final EntityType<GoldenAppleCowEntity> GOLDEN_APPLE_COW = Registry.register(
            Registries.ENTITY_TYPE,
            GOLDEN_APPLE_COW_KEY,
            EntityType.Builder.create(GoldenAppleCowEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9f, 1.4f) // Hitbox size (Cow size)
                    .build(GOLDEN_APPLE_COW_KEY)
    );

    public static void registerModEntities() {
        GAcow.LOGGER.info("Registering Entities for " + GAcow.MOD_ID);
    }
}