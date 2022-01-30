package chematria.blocks.entities;

import chematria.blocks.ChematriaBlocks;
import chematria.recipes.MortarAndPestleRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class MortarAndPestleEntity extends BlockEntity {
    protected ItemStackHandler inventory;
    private final String INVENTORY_TAG = "mortar_inv";
    protected int workLeft;
    private final String WORK_TAG = "workLeft";
    protected MortarAndPestleRecipe currentRecipe;

    public MortarAndPestleEntity(BlockPos position, BlockState blockstate) {
        super(ChematriaBlocks.MORTAR_AND_PESTLE_ENTITY.get(), position, blockstate);
        inventory = new ItemStackHandler(1);
        workLeft = 0;
        currentRecipe = null;
    }

    public void onAttack() {
        if (level.isClientSide)
            return;

        ItemStack extracted = inventory.extractItem(0, 1, false);
        if (!extracted.isEmpty()) {
            ItemEntity itemEntity = new ItemEntity(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), extracted);
            level.addFreshEntity(itemEntity);
            setChanged();
        }
    }

    public void onUse(Player player) {
        if (level.isClientSide)
            return;

        if (inventory.getStackInSlot(0).isEmpty())
            tryAddItem(player);
        else
            grind();
    }

    public void onDestroy() {
        if (level.isClientSide)
            return;
        if (!inventory.getStackInSlot(0).isEmpty()) {
            ItemEntity droppedItems = new ItemEntity(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), inventory.getStackInSlot(0).copy());
            level.addFreshEntity(droppedItems);
        }
    }

    protected void tryAddItem(Player player) {
        ItemStack heldItem = player.getMainHandItem();
        MortarAndPestleRecipe recipe = MortarAndPestleRecipe.findRecipe(heldItem);

        if (recipe != null) {
            currentRecipe = recipe;
            ItemStack remainder = inventory.insertItem(0, player.getMainHandItem().copy(), false);
            heldItem.setCount(remainder.getCount());
            workLeft = recipe.workRequired;
            setChanged();
        }
    }

    protected boolean isWorkValid() {
        return currentRecipe.input.getCount() <= inventory.getStackInSlot(0).getCount();
    }

    protected void grind() {
        if (!isWorkValid())
            return;

        workLeft--;
        if (workLeft <= 0) {
            inventory.extractItem(0, currentRecipe.input.getCount(), false);
            ItemEntity result = new ItemEntity(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), currentRecipe.output.copy());
            level.addFreshEntity(result);
            workLeft = currentRecipe.workRequired;
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
