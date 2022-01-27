package chematria.setup;

import chematria.worldgen.ores.Ores;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class SharedSetup {

    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addListener(Ores::onBiomeLoadingEvent);
    }

    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Ores.registerConfiguredFeatures();
        });
    }
}
