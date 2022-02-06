package chematria.entities;

import chematria.Chematria;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChematriaEntities {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Chematria.ID);

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }

    public static final RegistryObject<EntityType<RatEntity>> RAT = ENTITIES.register("rat", () -> EntityType.Builder.of(RatEntity::new, MobCategory.CREATURE)
            .sized(0.6f, 1.95f)
            .clientTrackingRange(8)
            .setShouldReceiveVelocityUpdates(false)
            .build("rat"));

}
