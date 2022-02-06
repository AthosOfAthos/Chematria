package chematria.entities;

import chematria.Chematria;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class RatRenderer extends HumanoidMobRenderer<RatEntity, RatModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Chematria.ID, "textures/entity/rat.png");

    public RatRenderer(EntityRendererProvider.Context context) {
        super(context, new RatModel(context.bakeLayer(RatModel.RAT_LAYER)), 1f);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(RatEntity entity) {
        return TEXTURE;
    }
}
