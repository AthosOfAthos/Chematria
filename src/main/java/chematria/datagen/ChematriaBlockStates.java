package chematria.datagen;
import chematria.blocks.ChematriaBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static chematria.Chematria.ID;

public class ChematriaBlockStates extends BlockStateProvider {

    public ChematriaBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ChematriaBlocks.LEAD_ORE_OVERWORLD.get());
        simpleBlock(ChematriaBlocks.LEAD_ORE_DEEPSLATE.get());
        simpleBlock(ChematriaBlocks.TIN_ORE_OVERWORLD.get());
        simpleBlock(ChematriaBlocks.TIN_ORE_DEEPSLATE.get());
        simpleBlock(ChematriaBlocks.MERCURY_ORE_OVERWORLD.get());
        simpleBlock(ChematriaBlocks.MERCURY_ORE_DEEPSLATE.get());
        simpleBlock(ChematriaBlocks.SILVER_ORE_OVERWORLD.get());
        simpleBlock(ChematriaBlocks.SILVER_ORE_DEEPSLATE.get());
    }
}
