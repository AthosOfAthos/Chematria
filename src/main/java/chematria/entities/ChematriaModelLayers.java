package chematria.entities;

import com.google.common.collect.Sets;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Set;

import static chematria.Chematria.ID;

public class ChematriaModelLayers {
    public static final ModelLayerLocation CRAWLER = register("crawler");
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    private static ModelLayerLocation register(String p_171294_) {
        return register(p_171294_, "main");
    }
    private static ModelLayerLocation register(String p_171296_, String p_171297_) {
        ModelLayerLocation modellayerlocation = createLocation(p_171296_, p_171297_);
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
        return new ModelLayerLocation(new ResourceLocation(ID, p_171301_), p_171302_);
    }
    public static ModelLayerLocation createCrawlerModelName(Crawler.Type p_171290_) {
        return createLocation("crawler/" + p_171290_.getName(), "main");
    }
}
