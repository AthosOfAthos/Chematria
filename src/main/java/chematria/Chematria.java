package chematria;

import chematria.blocks.ChematriaBlocks;
import chematria.entities.ChematriaEntities;
import chematria.items.ChematriaItems;
import chematria.recipes.ChematriaRecipe;
import chematria.setup.ClientSetup;
import chematria.setup.ModSetup;
import chematria.setup.Registration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("chematria")
public final class Chematria {
    public static final String ID = "chematria";

    public Chematria() {
        ModSetup.setup();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Registration.init(bus);


        bus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientSetup::init));
        bus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ChematriaRecipe::register);
    }
}
