package chematria.blocks;

import chematria.Chematria;
import chematria.blocks.entities.MortarAndPestleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import chematria.blocks.entities.LargeJarEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ChematriaBlocks {
    private ChematriaBlocks() {}

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Chematria.ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Chematria.ID);

    public static final RegistryObject<LargeJar> LARGE_JAR = BLOCKS.register("large_jar", LargeJar::new);
    public static final RegistryObject<BlockEntityType<LargeJarEntity>> LARGE_JAR_ENTITY = BLOCK_ENTITIES.register("large_jar_entity",
            () -> BlockEntityType.Builder.of(LargeJarEntity::new, LARGE_JAR.get()).build(null));

    public static final RegistryObject<MortarAndPestle> MORTAR_AND_PESTLE = BLOCKS.register("mortar_and_pestle", MortarAndPestle::new);
    public static final RegistryObject<BlockEntityType<MortarAndPestleEntity>> MORTAR_AND_PESTLE_ENTITY = BLOCK_ENTITIES.register("mortar_and_pestle_entity",
            () -> BlockEntityType.Builder.of(MortarAndPestleEntity::new, MORTAR_AND_PESTLE.get()).build(null));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        BLOCK_ENTITIES.register(bus);
    }

    //Wood
    public static final RegistryObject<WillowLog> WILLOW_LOG = BLOCKS.register("willow_log", WillowLog::new);
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WILLOW_LOG = BLOCKS.register("stripped_willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5f).explosionResistance(0.5f)));

    //Ores
    public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops();
    public static final RegistryObject<Block> LEAD_ORE_OVERWORLD = BLOCKS.register("lead_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Block> LEAD_ORE_DEEPSLATE = BLOCKS.register("lead_ore_deepslate", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Block> TIN_ORE_OVERWORLD = BLOCKS.register("tin_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Block> TIN_ORE_DEEPSLATE = BLOCKS.register("tin_ore_deepslate", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Block> MERCURY_ORE_OVERWORLD = BLOCKS.register("mercury_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Block> MERCURY_ORE_DEEPSLATE = BLOCKS.register("mercury_ore_deepslate", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Block> SILVER_ORE_OVERWORLD = BLOCKS.register("silver_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Block> SILVER_ORE_DEEPSLATE = BLOCKS.register("silver_ore_deepslate", () -> new Block(ORE_PROPERTIES));
    //Tags?
    public static final Tags.IOptionalNamedTag<Block> LEAD_ORE = BlockTags.createOptional(new ResourceLocation(Chematria.ID, "lead_ore"));
    public static final Tags.IOptionalNamedTag<Block> TIN_ORE = BlockTags.createOptional(new ResourceLocation(Chematria.ID, "tin_ore"));
    public static final Tags.IOptionalNamedTag<Block> MERCURY_ORE = BlockTags.createOptional(new ResourceLocation(Chematria.ID, "mercury_ore"));
    public static final Tags.IOptionalNamedTag<Block> SILVER_ORE = BlockTags.createOptional(new ResourceLocation(Chematria.ID, "silver_ore"));
}