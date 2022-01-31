package chematria.entities;

import chematria.Chematria;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ChematriaEntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Chematria.ID);

    public static final RegistryObject<EntityType<Crawler>> CRAWLER = register(
            "crawler",
            () -> EntityType.Builder.<Crawler>of(Crawler::new, MobCategory.MISC)
                    .sized(0.1F, 0.1F)
    );

    private static <T extends Entity>
    RegistryObject<EntityType<T>> register(String name, Supplier<EntityType.Builder<T>> prepare)
    {
        return REGISTER.register(name, () -> prepare.get().build(Chematria.ID+":"+name));
    }
}
