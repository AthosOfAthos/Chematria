package chematria.entities;

import chematria.Chematria;
import net.minecraft.client.model.RabbitModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;

public class RatModel extends HumanoidModel<RatEntity> {

    public static final String BODY = "body";

    public static ModelLayerLocation RAT_LAYER = new ModelLayerLocation(new ResourceLocation(Chematria.ID, "rat"), BODY);

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = createMesh(CubeDeformation.NONE, 0.6f);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public RatModel(ModelPart part) {
        super(part);
    }
}