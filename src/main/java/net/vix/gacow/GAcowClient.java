package net.vix.gacow;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.vix.gacow.client.renderer.GoldenAppleCowRenderer;
import net.vix.gacow.entity.ModEntities;

public class GAcowClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Connect the Entity to the Renderer
        EntityRendererRegistry.register(ModEntities.GOLDEN_APPLE_COW, GoldenAppleCowRenderer::new);
    }
}