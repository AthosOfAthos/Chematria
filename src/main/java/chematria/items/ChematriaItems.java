package chematria.items;

import chematria.Chematria;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ChematriaItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Chematria.ID);

    private ChematriaItems() {}

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
