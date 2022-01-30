package chematria.recipes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public abstract class ChematriaRecipe implements Recipe<Container> {
    public static void register() {
        MortarAndPestleRecipe.registerRecipes();
    }

    protected final ItemStack output;
    protected final ResourceLocation id;

    public ChematriaRecipe(ItemStack output, ResourceLocation id) {
        this.output = output;
        this.id = id;
    }

    @Override
    public boolean matches(Container p_44002_, Level p_44003_) {
        return false;
    }

    @Override
    public ItemStack assemble(Container p_44001_) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return false;
    }

    @Override
    public ItemStack getResultItem() {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }
}
