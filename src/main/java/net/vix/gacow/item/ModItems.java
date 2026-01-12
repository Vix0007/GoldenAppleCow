package net.vix.gacow.item; // Double check your package name matches!

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey; // Required for 1.21.2+
import net.minecraft.registry.RegistryKeys; // Required for 1.21.2+
import net.minecraft.util.Identifier;
import net.vix.gacow.GAcow; // Import your main class

public class ModItems {

    // 1. We change the method call to pass a "Factory" (Item::new) instead of a finished Item.
    // This allows us to create the settings with the ID *inside* the helper method.
    public static final Item GA_COW_SPAWN_EGG = registerItem("ga_cow_spawn_egg", Item::new, new Item.Settings());

    // 2. Updated helper method
    private static Item registerItem(String name,  java.util.function.Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the Identifier and RegistryKey first
        Identifier id = Identifier.of(GAcow.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        // Assign the key to the settings (REQUIRED in 1.21.2+)
        Item.Settings itemSettings = settings.registryKey(key);

        // Create the item using the factory
        Item item = itemFactory.apply(itemSettings);

        // Finally, register it
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {
        GAcow.LOGGER.info("Registering Mod Items for " + GAcow.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(GA_COW_SPAWN_EGG);
        });
    }
}