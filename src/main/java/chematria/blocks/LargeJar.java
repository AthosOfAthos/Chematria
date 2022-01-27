package chematria.blocks;

import chematria.blocks.entities.LargeJarEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class LargeJar extends Block implements EntityBlock {
    private static final VoxelShape COLLISION = Block.box(4, 0, 4, 12, 14, 12);

    public LargeJar() {
        super(BlockBehaviour.Properties.of(Material.GLASS).noOcclusion().explosionResistance(0.3f).strength(0.3f));
    }

    @Override
    public void attack(BlockState blockstate, Level level, BlockPos position, Player player) {
        super.attack(blockstate, level, position, player);
        if (!level.isClientSide()) {
            LargeJarEntity ent = (LargeJarEntity) level.getBlockEntity(position);
            player.addItem(ent.extract(1).copy());
        }
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level level, BlockPos position, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            LargeJarEntity container = (LargeJarEntity) level.getBlockEntity(position);
            ItemStack playerItems = player.getMainHandItem();
            playerItems.setCount(container.insert(playerItems.copy()).getCount());;
            return InteractionResult.SUCCESS;
        }
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
        return new LargeJarEntity(position, blockstate);
    }
}
