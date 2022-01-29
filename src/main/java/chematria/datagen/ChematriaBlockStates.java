package chematria.datagen;
import chematria.blocks.ChematriaBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static chematria.Chematria.ID;

public class ChematriaBlockStates extends BlockStateProvider {

    public ChematriaBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Ores
        simpleBlock(ChematriaBlocks.LEAD_ORE_OVERWORLD.get());
        simpleBlock(ChematriaBlocks.LEAD_ORE_DEEPSLATE.get());
        simpleBlock(ChematriaBlocks.TIN_ORE_OVERWORLD.get());
        simpleBlock(ChematriaBlocks.TIN_ORE_DEEPSLATE.get());
        simpleBlock(ChematriaBlocks.MERCURY_ORE_OVERWORLD.get());
        simpleBlock(ChematriaBlocks.MERCURY_ORE_DEEPSLATE.get());
        simpleBlock(ChematriaBlocks.SILVER_ORE_OVERWORLD.get());
        simpleBlock(ChematriaBlocks.SILVER_ORE_DEEPSLATE.get());
        //Trees
        logBlock(ChematriaBlocks.WILLOW_LOG.get());
        logBlock(ChematriaBlocks.STRIPPED_WILLOW_LOG.get());

        simpleBlock(ChematriaBlocks.WILLOW_WOOD.get());
        simpleBlock(ChematriaBlocks.STRIPPED_WILLOW_WOOD.get());
        simpleBlock(ChematriaBlocks.WILLOW_PLANKS.get());
        simpleBlock(ChematriaBlocks.WILLOW_LEAVES.get());

        slabBlock(ChematriaBlocks.WILLOW_SLAB.get());
        stairsBlock(ChematriaBlocks.WILLOW_STAIRS.get());
        fenceBlock(ChematriaBlocks.WILLOW_FENCE.get());
        fenceGateBlock(ChematriaBlocks.WILLOW_FENCE_GATE.get());
        doorBlock(ChematriaBlocks.WILLOW_DOOR.get());
        trapdoorBlock(ChematriaBlocks.WILLOW_TRAPDOOR.get());
        pressurePlateBlock(ChematriaBlocks.WILLOW_PRESSURE_PLATE.get());
        buttonBlock(Block(ChematriaBlocks.WILLOW_BUTTON.get());
        signBlock(ChematriaBlocks.WILLOW_SIGN.get());
        simpleBlock(ChematriaBlocks.WILLOW_WALL_SIGN.get());//boom
        simpleBlock(ChematriaBlocks.WILLOW_SAPLING.get());
        simpleBlock(ChematriaBlocks.POTTED_WILLOW_SAPLING.get());

    }
}
