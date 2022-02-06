package chematria.datagen;

import chematria.items.ChematriaItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static chematria.Chematria.ID;

public class ChematriaItemModel extends ItemModelProvider {

    public ChematriaItemModel(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Lead
        withExistingParent(ChematriaItems.LEAD_ORE_OVERWORLD_ITEM.get().getRegistryName().getPath(), modLoc("block/lead_ore_overworld"));
        withExistingParent(ChematriaItems.LEAD_ORE_DEEPSLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/lead_ore_deepslate"));

        singleTexture(ChematriaItems.RAW_LEAD_CHUNK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_lead_chunk"));
        singleTexture(ChematriaItems.LEAD_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/lead_ingot"));
        //Tin
        withExistingParent(ChematriaItems.TIN_ORE_OVERWORLD_ITEM.get().getRegistryName().getPath(), modLoc("block/tin_ore_overworld"));
        withExistingParent(ChematriaItems.TIN_ORE_DEEPSLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/tin_ore_deepslate"));

        singleTexture(ChematriaItems.RAW_TIN_CHUNK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_tin_chunk"));
        singleTexture(ChematriaItems.TIN_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/tin_ingot"));
        //Mercury
        withExistingParent(ChematriaItems.MERCURY_ORE_OVERWORLD_ITEM.get().getRegistryName().getPath(), modLoc("block/mercury_ore_overworld"));
        withExistingParent(ChematriaItems.MERCURY_ORE_DEEPSLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/mercury_ore_deepslate"));

        singleTexture(ChematriaItems.RAW_MERCURY_CHUNK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_mercury_chunk"));
        singleTexture(ChematriaItems.MERCURY_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/mercury_ingot"));

        //Silver
        withExistingParent(ChematriaItems.SILVER_ORE_OVERWORLD_ITEM.get().getRegistryName().getPath(), modLoc("block/silver_ore_overworld"));
        withExistingParent(ChematriaItems.SILVER_ORE_DEEPSLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/silver_ore_deepslate"));

        singleTexture(ChematriaItems.RAW_SILVER_CHUNK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_silver_chunk"));
        singleTexture(ChematriaItems.SILVER_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/silver_ingot"));


        //Rat egg
        withExistingParent(ChematriaItems.RAT_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
