package chematria.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LargeJar extends Block {
    private static final VoxelShape COLLISION = Block.box(4, 0, 4, 12, 14, 12);

    public LargeJar() {
        super(BlockBehaviour.Properties.of(Material.GLASS).noOcclusion().explosionResistance(0.3f).strength(0.3f));
    }

    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader level, BlockPos position) {
        return Block.canSupportCenter(level, position.relative(Direction.DOWN), Direction.UP);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return COLLISION;
    }
}
