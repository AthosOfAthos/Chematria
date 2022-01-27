package chematria.datagen;

import chematria.blocks.ChematriaBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static chematria.Chematria.ID;

public class ChematriaBlockTags extends BlockTagsProvider {

    public ChematriaBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, ID, helper);
    }
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ChematriaBlocks.LEAD_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.LEAD_ORE_DEEPSLATE.get())
                .add(ChematriaBlocks.TIN_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.TIN_ORE_DEEPSLATE.get())
                .add(ChematriaBlocks.MERCURY_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.MERCURY_ORE_DEEPSLATE.get())
                .add(ChematriaBlocks.SILVER_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.SILVER_ORE_DEEPSLATE.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ChematriaBlocks.LEAD_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.LEAD_ORE_DEEPSLATE.get())
                .add(ChematriaBlocks.TIN_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.TIN_ORE_DEEPSLATE.get())
                .add(ChematriaBlocks.MERCURY_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.MERCURY_ORE_DEEPSLATE.get())
                .add(ChematriaBlocks.SILVER_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.SILVER_ORE_DEEPSLATE.get());
        tag(Tags.Blocks.ORES)
                .add(ChematriaBlocks.LEAD_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.LEAD_ORE_DEEPSLATE.get())
                .add(ChematriaBlocks.TIN_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.TIN_ORE_DEEPSLATE.get())
                .add(ChematriaBlocks.MERCURY_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.MERCURY_ORE_DEEPSLATE.get())
                .add(ChematriaBlocks.SILVER_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.SILVER_ORE_DEEPSLATE.get());
        tag(ChematriaBlocks.LEAD_ORE)
                .add(ChematriaBlocks.LEAD_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.LEAD_ORE_DEEPSLATE.get());
        tag(ChematriaBlocks.TIN_ORE)
                .add(ChematriaBlocks.TIN_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.TIN_ORE_DEEPSLATE.get());
        tag(ChematriaBlocks.MERCURY_ORE)
                .add(ChematriaBlocks.MERCURY_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.MERCURY_ORE_DEEPSLATE.get());
        tag(ChematriaBlocks.SILVER_ORE)
                .add(ChematriaBlocks.SILVER_ORE_OVERWORLD.get())
                .add(ChematriaBlocks.SILVER_ORE_DEEPSLATE.get());
    }

    @Override
    public String getName() {
        return "Chematria Tags";
    }
}
