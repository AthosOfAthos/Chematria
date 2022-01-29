package chematria.entities;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ChematriaEntityType {

    public static final EntityType<Crawler> CRAWLER = register("crawler", EntityType.Builder.<Crawler>of(Crawler::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    private static <T extends Entity> EntityType<T> register(String p_20635_, EntityType.Builder<T> p_20636_) {
        return Registry.register(Registry.ENTITY_TYPE, p_20635_, p_20636_.build(p_20635_));
    }
}
