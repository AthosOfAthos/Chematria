package chematria.blocks;

import chematria.items.ChematriaItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class WillowLog extends RotatedPillarBlock {
    private static final int AXE_DAMAGE = 2;

    public WillowLog() {
        super(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5f).explosionResistance(0.5f));
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level level, BlockPos position, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (player.getMainHandItem().getItem() == Items.IRON_AXE) {
            if (!level.isClientSide) {
                level.setBlock(position, ChematriaBlocks.STRIPPED_WILLOW_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, blockstate.getValue(BlockStateProperties.AXIS)), 0);
                player.getMainHandItem().hurtAndBreak(AXE_DAMAGE, player, (_unknown) -> { player.broadcastBreakEvent(hand); });
                player.addItem(new ItemStack(ChematriaItems.WILLOW_BARK.get(), 4));
            }
            return InteractionResult.SUCCESS;
        }

        return super.use(blockstate, level, position, player, hand, hitResult);
    }
}
