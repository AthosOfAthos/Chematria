package chematria.items;

import chematria.Chematria;
import chematria.blocks.ChematriaBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ChematriaItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Chematria.ID);

    public static final RegistryObject<BlockItem> LARGE_JAR_ITEM = ITEMS.register("large_jar", () -> new BlockItem(ChematriaBlocks.LARGE_JAR.get(), new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));

    private ChematriaItems() {}

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
