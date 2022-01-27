package chematria.datagen;


import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import static chematria.Chematria.ID;

@Mod.EventBusSubscriber(modid = ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new ChematriaRecipes(generator));
            generator.addProvider(new ChematriaLootTables(generator));
            ChematriaBlockTags blockTags = new ChematriaBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new ChematriaItemTags(generator, blockTags, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            generator.addProvider(new ChematriaBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new ChematriaItemModel(generator, event.getExistingFileHelper()));
            generator.addProvider(new ChematriaLanguageProvider(generator, "en_us"));
        }
    }
}
