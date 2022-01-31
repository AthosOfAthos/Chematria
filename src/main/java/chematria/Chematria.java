package chematria;

import chematria.blocks.ChematriaBlocks;
import chematria.entities.ChematriaEntityTypes;
import chematria.items.ChematriaItems;
import chematria.recipes.ChematriaRecipe;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("chematria")
public final class Chematria {
    public static final String ID = "chematria";

    public Chematria() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ChematriaBlocks.register(bus);
        ChematriaItems.register(bus);
        bus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ChematriaRecipe::register);
    }
}
