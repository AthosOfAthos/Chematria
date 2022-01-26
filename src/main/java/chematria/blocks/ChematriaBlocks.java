package chematria.blocks;

import chematria.Chematria;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ChematriaBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Chematria.ID);

    public static final RegistryObject<Block> LARGE_JAR = BLOCKS.register("large_jar", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).noOcclusion()));

    private ChematriaBlocks() {}

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
