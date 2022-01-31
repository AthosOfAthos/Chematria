package chematria.entities;

import chematria.Chematria;
import com.google.common.collect.Sets;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.client.ForgeHooksClient;

import java.util.Set;

import static chematria.Chematria.ID;

public class ChematriaModelLayers {
    public static final ModelLayerLocation CRAWLER = new ModelLayerLocation(ChematriaEntityTypes.CRAWLER.getId(), "crawler");

    public static void registerDefinitions()
    {
        ForgeHooksClient.registerLayerDefinition(CRAWLER, CrawlerModel::createBodyModel);
    }

}
