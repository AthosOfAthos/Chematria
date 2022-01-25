package chematria.blocks;

import chematria.Chematria;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ChematriaBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Chematria.ID);

    private ChematriaBlocks() {}

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
