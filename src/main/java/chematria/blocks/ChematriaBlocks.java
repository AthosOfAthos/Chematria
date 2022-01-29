package chematria.blocks;

import chematria.Chematria;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
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

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        BLOCK_ENTITIES.register(bus);
    }

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

    //Trees
    public static final BlockBehaviour.Properties WOOD_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOD);
    public static final BlockBehaviour.Properties LEAVES_PROPERTIES = BlockBehaviour.Properties.of(Material.LEAVES);
    public static final BlockBehaviour.Properties PLANT_PROPERTIES = BlockBehaviour.Properties.of(Material.PLANT);

    public static final RegistryObject<RotatedPillarBlock> WILLOW_LOG = BLOCKS.register("willow_log", () -> new RotatedPillarBlock(WOOD_PROPERTIES));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WILLOW_LOG = BLOCKS.register("stripped_willow_log", () -> new RotatedPillarBlock(WOOD_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_WOOD = BLOCKS.register("willow_wood", () -> new Block(WOOD_PROPERTIES));
    public static final RegistryObject<Block> STRIPPED_WILLOW_WOOD = BLOCKS.register("stripped_willow_wood", () -> new Block(WOOD_PROPERTIES));

    public static final RegistryObject<Block> WILLOW_PLANKS = BLOCKS.register("willow_planks", () -> new Block(WOOD_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_SLAB = BLOCKS.register("willow_slab", () -> new SlabBlock(WOOD_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_STAIRS = BLOCKS.register("willow_stairs", () -> new StairBlock(WOOD_PROPERTIES));
    public static final RegistryObject<FenceBlock> WILLOW_FENCE = BLOCKS.register("willow_fence", () -> new FenceBlock(WOOD_PROPERTIES));
    public static final RegistryObject<FenceGateBlock> WILLOW_FENCE_GATE = BLOCKS.register("willow_fence_gate", () -> new FenceGateBlock(WOOD_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_DOOR = BLOCKS.register("willow_door", () -> new DoorBlock(WOOD_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_TRAPDOOR = BLOCKS.register("willow_trapdoor", () -> new TrapDoorBlock(WOOD_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_PRESSURE_PLATE = BLOCKS.register("willow_pressure_plate", () -> new PressurePlateBlock(WOOD_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_BUTTON = BLOCKS.register("willow_button", () -> new Block(WOOD_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_SIGN = BLOCKS.register("willow_sign", () -> new Block(WOOD_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_WALL_SIGN = BLOCKS.register("willow_wall_sign", () -> new Block(WOOD_PROPERTIES));

    public static final RegistryObject<Block> WILLOW_SAPLING = BLOCKS.register("willow_sapling", () -> new Block(PLANT_PROPERTIES));
    public static final RegistryObject<Block> POTTED_WILLOW_SAPLING = BLOCKS.register("potted_willow_sapling", () -> new Block(PLANT_PROPERTIES));
    public static final RegistryObject<Block> WILLOW_LEAVES = BLOCKS.register("willow_leaves", () -> new Block(LEAVES_PROPERTIES));


    //Tags?
    public static final Tags.IOptionalNamedTag<Block> LEAD_ORE = BlockTags.createOptional(new ResourceLocation(Chematria.ID, "lead_ore"));
    public static final Tags.IOptionalNamedTag<Block> TIN_ORE = BlockTags.createOptional(new ResourceLocation(Chematria.ID, "tin_ore"));
    public static final Tags.IOptionalNamedTag<Block> MERCURY_ORE = BlockTags.createOptional(new ResourceLocation(Chematria.ID, "mercury_ore"));
    public static final Tags.IOptionalNamedTag<Block> SILVER_ORE = BlockTags.createOptional(new ResourceLocation(Chematria.ID, "silver_ore"));
}