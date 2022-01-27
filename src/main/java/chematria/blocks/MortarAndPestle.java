package chematria.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MortarAndPestle extends Block {
    private static final VoxelShape COLLISION = Block.box(5, 0, 5, 11, 3, 11);

    public MortarAndPestle() {
        super(BlockBehaviour.Properties.of(Material.STONE).noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level level, BlockPos position, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return InteractionResult.SUCCESS;
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
