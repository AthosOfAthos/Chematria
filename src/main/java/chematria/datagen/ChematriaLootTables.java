package chematria.datagen;

import chematria.blocks.ChematriaBlocks;
import chematria.items.ChematriaItems;
import net.minecraft.data.DataGenerator;

public class ChematriaLootTables extends ChematriaLootTableProvider {

    public ChematriaLootTables(DataGenerator generator){
        super(generator);
    }

    @Override
    protected void addTables(){
        lootTables.put(ChematriaBlocks.LARGE_JAR.get(), createSimpleTable("large_jar", ChematriaBlocks.LARGE_JAR.get()));
        lootTables.put(ChematriaBlocks.MORTAR_AND_PESTLE.get(), createSimpleTable("mortar_and_pestle", ChematriaBlocks.MORTAR_AND_PESTLE.get()));

        lootTables.put(ChematriaBlocks.WILLOW_LOG.get(), createSimpleTable("willow_log", ChematriaBlocks.WILLOW_LOG.get()));
        lootTables.put(ChematriaBlocks.STRIPPED_WILLOW_LOG.get(), createSimpleTable("willow_log", ChematriaBlocks.STRIPPED_WILLOW_LOG.get()));

        lootTables.put(ChematriaBlocks.LEAD_ORE_OVERWORLD.get(), createSilkTouchTable("lead_ore_overworld", ChematriaBlocks.LEAD_ORE_OVERWORLD.get(), ChematriaItems.RAW_LEAD_CHUNK.get(), 1, 3));
        lootTables.put(ChematriaBlocks.LEAD_ORE_DEEPSLATE.get(), createSilkTouchTable("lead_ore_deepslate", ChematriaBlocks.LEAD_ORE_DEEPSLATE.get(), ChematriaItems.RAW_LEAD_CHUNK.get(), 1, 3));

        lootTables.put(ChematriaBlocks.TIN_ORE_OVERWORLD.get(), createSilkTouchTable("tin_ore_overworld", ChematriaBlocks.TIN_ORE_OVERWORLD.get(), ChematriaItems.RAW_TIN_CHUNK.get(), 1, 3));
        lootTables.put(ChematriaBlocks.TIN_ORE_DEEPSLATE.get(), createSilkTouchTable("tin_ore_deepslate", ChematriaBlocks.TIN_ORE_DEEPSLATE.get(), ChematriaItems.RAW_TIN_CHUNK.get(), 1, 3));

        lootTables.put(ChematriaBlocks.MERCURY_ORE_OVERWORLD.get(), createSilkTouchTable("mercury_ore_overworld", ChematriaBlocks.MERCURY_ORE_OVERWORLD.get(), ChematriaItems.RAW_MERCURY_CHUNK.get(), 1, 3));
        lootTables.put(ChematriaBlocks.MERCURY_ORE_DEEPSLATE.get(), createSilkTouchTable("mercury_ore_deepslate", ChematriaBlocks.MERCURY_ORE_DEEPSLATE.get(), ChematriaItems.RAW_MERCURY_CHUNK.get(), 1, 3));

        lootTables.put(ChematriaBlocks.SILVER_ORE_OVERWORLD.get(), createSilkTouchTable("silver_ore_overworld", ChematriaBlocks.SILVER_ORE_OVERWORLD.get(), ChematriaItems.RAW_SILVER_CHUNK.get(), 1, 3));
        lootTables.put(ChematriaBlocks.SILVER_ORE_DEEPSLATE.get(), createSilkTouchTable("silver_ore_deepslate", ChematriaBlocks.SILVER_ORE_DEEPSLATE.get(), ChematriaItems.RAW_SILVER_CHUNK.get(), 1, 3));
    }
}
