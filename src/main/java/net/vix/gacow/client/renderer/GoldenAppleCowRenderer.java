package net.vix.gacow.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.vix.gacow.entity.GoldenAppleCowEntity;

public class GoldenAppleCowRenderer extends MobEntityRenderer<GoldenAppleCowEntity, GoldenAppleCowRenderState, GoldenAppleCowModel> {

    public GoldenAppleCowRenderer(EntityRendererFactory.Context context) {
        super(context, new GoldenAppleCowModel(context.getPart(EntityModelLayers.COW)), 0.7f);
        // REMOVED: this.addFeature(...)
    }

    @Override
    public GoldenAppleCowRenderState createRenderState() {
        return new GoldenAppleCowRenderState();
    }

    @Override
    public Identifier getTexture(GoldenAppleCowRenderState state) {
        return Identifier.of("gacow", "textures/entity/golden_apple_cow.png");
    }
}