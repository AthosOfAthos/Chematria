package chematria.datagen;

import chematria.Chematria;
import chematria.items.ChematriaItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static chematria.Chematria.ID;

public class ChematriaItemTags extends ItemTagsProvider {
    public ChematriaItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper){
        super(generator, blockTags, ID, helper);
    }
    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(ChematriaItems.LEAD_ORE_OVERWORLD_ITEM.get())
                .add(ChematriaItems.LEAD_ORE_DEEPSLATE_ITEM.get())
                .add(ChematriaItems.TIN_ORE_OVERWORLD_ITEM.get())
                .add(ChematriaItems.TIN_ORE_DEEPSLATE_ITEM.get())
                .add(ChematriaItems.MERCURY_ORE_OVERWORLD_ITEM.get())
                .add(ChematriaItems.MERCURY_ORE_DEEPSLATE_ITEM.get())
                .add(ChematriaItems.SILVER_ORE_OVERWORLD_ITEM.get())
                .add(ChematriaItems.SILVER_ORE_DEEPSLATE_ITEM.get());
        tag(Tags.Items.INGOTS)
                .add(ChematriaItems.LEAD_INGOT.get())
                .add(ChematriaItems.TIN_INGOT.get())
                .add(ChematriaItems.MERCURY_INGOT.get())
                .add(ChematriaItems.SILVER_INGOT.get());
        tag(ChematriaItems.LEAD_ORE_ITEM)
                .add(ChematriaItems.LEAD_ORE_OVERWORLD_ITEM.get())
                .add(ChematriaItems.LEAD_ORE_DEEPSLATE_ITEM.get());
        tag(ChematriaItems.TIN_ORE_ITEM)
                .add(ChematriaItems.TIN_ORE_OVERWORLD_ITEM.get())
                .add(ChematriaItems.TIN_ORE_DEEPSLATE_ITEM.get());
        tag(ChematriaItems.MERCURY_ORE_ITEM)
                .add(ChematriaItems.MERCURY_ORE_OVERWORLD_ITEM.get())
                .add(ChematriaItems.MERCURY_ORE_DEEPSLATE_ITEM.get());
        tag(ChematriaItems.SILVER_ORE_ITEM)
                .add(ChematriaItems.SILVER_ORE_OVERWORLD_ITEM.get())
                .add(ChematriaItems.SILVER_ORE_DEEPSLATE_ITEM.get());
    }
    @Override
    public String getName() {
        return "Chematria Tags";
    }
}
