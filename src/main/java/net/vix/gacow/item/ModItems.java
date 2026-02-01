package net.vix.gacow.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem; // <--- 1. NEW IMPORT
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.vix.gacow.GAcow;
import net.vix.gacow.entity.ModEntities; // <--- 2. NEW IMPORT (Need the cow!)

public class ModItems {

    // 3. THE FIX: Use our custom class. No colors needed!
    public static final Item GA_COW_SPAWN_EGG = registerItem("ga_cow_spawn_egg",
            // Use the factory for our new class
            settings -> new GoldenAppleCowSpawnEgg(settings),
            new Item.Settings()
    );



    // Your existing helper method (Perfect for 1.21.2+, don't touch!)
    private static Item registerItem(String name,  java.util.function.Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        Identifier id = Identifier.of(GAcow.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings itemSettings = settings.registryKey(key);
        Item item = itemFactory.apply(itemSettings);
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {
        GAcow.LOGGER.info("Registering Mod Items for " + GAcow.MOD_ID);

        // Added to Spawn Eggs tab instead of Ingredients (easier to find!)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(GA_COW_SPAWN_EGG);
        });
    }
}