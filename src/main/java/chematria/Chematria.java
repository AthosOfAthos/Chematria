package chematria;

import chematria.blocks.ChematriaBlocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("chematria")
public final class Chematria {
    public static final String ID = "chematria";

    public Chematria() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ChematriaBlocks.register(bus);
    }
}
