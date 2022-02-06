package chematria.setup;

import chematria.blocks.ChematriaBlocks;
import chematria.entities.ChematriaEntities;
import chematria.items.ChematriaItems;
import net.minecraftforge.eventbus.api.IEventBus;

public class Registration {
    public static void init(IEventBus bus) {
        ChematriaItems.register(bus);
        ChematriaBlocks.register(bus);
        ChematriaEntities.register(bus);
    }
}
