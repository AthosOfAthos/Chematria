package chematria.blocks.entities;

import chematria.blocks.ChematriaBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class MortarAndPestleEntity extends BlockEntity {
    protected ItemStackHandler inventory;
    private final String INVENTORY_TAG = "mortar_inv";
    protected int workLeft;
    private final String WORK_TAG = "workLeft";

    public MortarAndPestleEntity(BlockPos position, BlockState blockstate) {
        super(ChematriaBlocks.MORTAR_AND_PESTLE_ENTITY.get(), position, blockstate);
        inventory = new ItemStackHandler(1);
        workLeft = 0;
    }

    public void attack() {
        if (level.isClientSide)
            return;

        ItemStack extracted = inventory.extractItem(0, 1, false);
        if (!extracted.isEmpty()) {
            ItemEntity itemEntity = new ItemEntity(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), extracted);
            level.addFreshEntity(itemEntity);
            setChanged();
        }
    }

    public void use(Player player) {
        if (level.isClientSide)
            return;

        if (inventory.getStackInSlot(0).isEmpty())
            addItem(player);
        else
            grind();
    }

    public void destroy() {
        if (level.isClientSide)
            return;
        if (!inventory.getStackInSlot(0).isEmpty()) {
            ItemEntity droppedItems = new ItemEntity(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), inventory.getStackInSlot(0).copy());
            level.addFreshEntity(droppedItems);
        }
    }

    protected void addItem(Player player) {
        ItemStack heldItem = player.getMainHandItem();
        ItemStack remainder = inventory.insertItem(0, player.getMainHandItem().copy(), false);
        heldItem.setCount(remainder.getCount());
        workLeft = 5;
        setChanged();
    }

    protected void grind() {
        workLeft--;
        if (workLeft <= 0) {
            inventory.getStackInSlot(0).setCount(inventory.getStackInSlot(0).getCount() - 1);
            ItemEntity itemEntity = new ItemEntity(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), new ItemStack(Items.SAND));
            level.addFreshEntity(itemEntity);
            workLeft = 5;
            setChanged();
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put(INVENTORY_TAG, inventory.serializeNBT());
        tag.putInt(WORK_TAG, workLeft);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        inventory.deserializeNBT(tag.getCompound(INVENTORY_TAG));
        workLeft = tag.getInt(WORK_TAG);
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
