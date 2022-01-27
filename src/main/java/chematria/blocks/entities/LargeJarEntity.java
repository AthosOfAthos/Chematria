package chematria.blocks.entities;

import chematria.blocks.ChematriaBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class LargeJarEntity extends BlockEntity {
    private final ItemStackHandler inventory;

    public LargeJarEntity(BlockPos position, BlockState blockstate) {
        super(ChematriaBlocks.LARGE_JAR_ENTITY.get(), position, blockstate);
        inventory = new ItemStackHandler();
    }

    public ItemStack insert(ItemStack playerStack) {
        setChanged();
        return inventory.insertItem(0, playerStack, false);
    }

    public ItemStack extract(int amount) {
        setChanged();
        return inventory.extractItem(0, amount, false);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inv", inventory.serializeNBT());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        inventory.deserializeNBT(tag.getCompound("inv"));
    }

    @Override
    public CompoundTag getUpdateTag() {
        return super.getUpdateTag();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return super.getUpdatePacket();
    }
}
