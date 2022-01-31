package chematria.recipes;

import chematria.Chematria;
import chematria.items.ChematriaItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import java.util.ArrayList;

public class MortarAndPestleRecipe extends ChematriaRecipe{
    public static ArrayList<MortarAndPestleRecipe> RECIPES = new ArrayList<MortarAndPestleRecipe>();
    public static void registerRecipes() {
        MortarAndPestleRecipe.RECIPES.add(new MortarAndPestleRecipe(new ItemStack(ChematriaItems.LEAD_INGOT.get(), 1), new ItemStack(Blocks.GOLD_BLOCK, 5), 20, new ResourceLocation(Chematria.ID, "big_if_true")));
    }

    public final ItemStack input;
    public final ItemStack output;
    public final int workRequired;

    public MortarAndPestleRecipe(ItemStack input, ItemStack output, int workRequired, ResourceLocation id) {
        super(output, id);
        this.input = input;
        this.output = output;
        this.workRequired = workRequired;
    }

    public static MortarAndPestleRecipe findRecipe(ItemStack input) {
        if (input.isEmpty())
            return null;
        for (var recipe: RECIPES) {
            if (recipe.input.getItem() == input.getItem())
                return recipe;
        }
        return null;
    }

}
