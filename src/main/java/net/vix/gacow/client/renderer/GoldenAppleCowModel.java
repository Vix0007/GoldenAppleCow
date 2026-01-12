package net.vix.gacow.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;

@Environment(EnvType.CLIENT)
public class GoldenAppleCowModel extends QuadrupedEntityModel<GoldenAppleCowRenderState> {

    public GoldenAppleCowModel(ModelPart root) {
        super(root); // In 1.21.11, super() only takes 'root'
    }
}