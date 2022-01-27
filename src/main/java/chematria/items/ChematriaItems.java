package chematria.items;

import chematria.Chematria;
import chematria.blocks.ChematriaBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static chematria.Chematria.ID;

public final class ChematriaItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ID);

    public static final RegistryObject<BlockItem> LARGE_JAR_ITEM = ITEMS.register("large_jar", () -> new BlockItem(ChematriaBlocks.LARGE_JAR.get(), new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));

    private ChematriaItems() {}

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.LIGHTNING_ROD);
        }
    };

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }

    //Ores
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ITEM_GROUP);
    public static final RegistryObject<Item> LEAD_ORE_OVERWORLD_ITEM = fromBlock(LEAD_ORE_OVERWORLD);
    public static final RegistryObject<Item> LEAD_ORE_DEEPSLATE_ITEM = fromBlock(LEAD_ORE_DEEPSLATE);
    public static final RegistryObject<Item> TIN_ORE_OVERWORLD_ITEM = fromBlock(TIN_ORE_OVERWORLD);
    public static final RegistryObject<Item> TIN_ORE_DEEPSLATE_ITEM = fromBlock(TIN_ORE_DEEPSLATE);
    public static final RegistryObject<Item> MERCURY_ORE_OVERWORLD_ITEM = fromBlock(MERCURY_ORE_OVERWORLD);
    public static final RegistryObject<Item> MERCURY_ORE_DEEPSLATE_ITEM = fromBlock(MERCURY_ORE_DEEPSLATE);
    public static final RegistryObject<Item> SILVER_ORE_OVERWORLD_ITEM = fromBlock(SILVER_ORE_OVERWORLD);
    public static final RegistryObject<Item> SILVER_ORE_DEEPSLATE_ITEM = fromBlock(SILVER_ORE_DEEPSLATE);

    //Processed Ores
    public static final RegistryObject<Item> RAW_LEAD_CHUNK = ITEMS.register("raw_lead_chunk", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> RAW_TIN_CHUNK = ITEMS.register("raw_tin_chunk", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> RAW_MERCURY_CHUNK = ITEMS.register("raw_mercury_chunk", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MERCURY_INGOT = ITEMS.register("mercury_ingot", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> RAW_SILVER_CHUNK = ITEMS.register("raw_silver_chunk", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(ITEM_PROPERTIES));

    //Tags?
    public static final Tags.IOptionalNamedTag<Item> LEAD_ORE_ITEM = ItemTags.createOptional(new ResourceLocation(ID, "lead_ore"));
    public static final Tags.IOptionalNamedTag<Item> TIN_ORE_ITEM = ItemTags.createOptional(new ResourceLocation(ID, "tin_ore"));
    public static final Tags.IOptionalNamedTag<Item> MERCURY_ORE_ITEM = ItemTags.createOptional(new ResourceLocation(ID, "mercury_ore"));
    public static final Tags.IOptionalNamedTag<Item> SILVER_ORE_ITEM = ItemTags.createOptional(new ResourceLocation(ID, "silver_ore"));

}
