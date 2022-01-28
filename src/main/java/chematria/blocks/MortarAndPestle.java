package chematria.blocks;

import chematria.blocks.entities.MortarAndPestleEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MortarAndPestle extends Block implements EntityBlock {
    private static final VoxelShape COLLISION = Block.box(5, 0, 5, 11, 3, 11);

    public MortarAndPestle() {
        super(BlockBehaviour.Properties.of(Material.STONE).noOcclusion().strength(0.5f).explosionResistance(0.5f));
    }

    @Override
    public void attack(BlockState blockstate, Level level, BlockPos position, Player player) {
        if (level.isClientSide)
            return;

        super.attack(blockstate, level, position, player);
        MortarAndPestleEntity mortar = (MortarAndPestleEntity) level.getBlockEntity(position);
        if (mortar != null)
            mortar.attack();
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos position, Player player, boolean willHarvest, FluidState fluid) {
        MortarAndPestleEntity mortar = (MortarAndPestleEntity) level.getBlockEntity(position);
        if (mortar != null)
            mortar.destroy();
        return super.onDestroyedByPlayer(state, level, position, player, willHarvest, fluid);
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level level, BlockPos position, Player player, InteractionHand hand, BlockHitResult hitResult) {
        MortarAndPestleEntity mortar = (MortarAndPestleEntity) level.getBlockEntity(position);
        if (mortar != null)
            mortar.use(player);
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos position, BlockState blockstate) {
        return new MortarAndPestleEntity(position, blockstate);
    }
}
