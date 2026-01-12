package net.vix.gacow;

import net.fabricmc.api.ModInitializer;

import net.vix.gacow.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GAcow implements ModInitializer {
	public static final String MOD_ID = "gacow";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

	}
}