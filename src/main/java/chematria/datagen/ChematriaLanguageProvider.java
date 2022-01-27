package chematria.datagen;

import chematria.blocks.ChematriaBlocks;
import chematria.items.ChematriaItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static chematria.Chematria.ID;

public class ChematriaLanguageProvider extends LanguageProvider {
    public ChematriaLanguageProvider(DataGenerator generator, String locale) {
        super(generator, ID, locale);
    }

    @Override
    protected void addTranslations(){
        add("itemGroup."+ID, "Chematria");
        //Lead
        add(ChematriaBlocks.LEAD_ORE_OVERWORLD.get(), "Lead Ore");
        add(ChematriaBlocks.LEAD_ORE_DEEPSLATE.get(), "Lead Ore");
        add(ChematriaItems.RAW_LEAD_CHUNK.get(), "Lead Raw Chunk");
        add(ChematriaItems.LEAD_INGOT.get(), "Lead Ingot");
        //Tin
        add(ChematriaBlocks.TIN_ORE_OVERWORLD.get(), "Tin Ore");
        add(ChematriaBlocks.TIN_ORE_DEEPSLATE.get(), "Tin Ore");
        add(ChematriaItems.RAW_TIN_CHUNK.get(), "Tin Raw Chunk");
        add(ChematriaItems.TIN_INGOT.get(), "Tin Ingot");
        //Mercury
        add(ChematriaBlocks.MERCURY_ORE_OVERWORLD.get(), "Mercury Ore");
        add(ChematriaBlocks.MERCURY_ORE_DEEPSLATE.get(), "Mercury Ore");
        add(ChematriaItems.RAW_MERCURY_CHUNK.get(), "Mercury Raw Chunk");
        add(ChematriaItems.MERCURY_INGOT.get(), "Mercury Ingot");
        //Silver
        add(ChematriaBlocks.SILVER_ORE_OVERWORLD.get(), "Silver Ore");
        add(ChematriaBlocks.SILVER_ORE_DEEPSLATE.get(), "Silver Ore");
        add(ChematriaItems.RAW_SILVER_CHUNK.get(), "Silver Raw Chunk");
        add(ChematriaItems.SILVER_INGOT.get(), "Silver Ingot");




    }

}
