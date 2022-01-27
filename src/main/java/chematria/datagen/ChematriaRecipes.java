package chematria.datagen;

import chematria.items.ChematriaItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class ChematriaRecipes extends RecipeProvider {
    public ChematriaRecipes(DataGenerator generator){
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer){
        //LEAD
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ChematriaItems.LEAD_ORE_ITEM),
                ChematriaItems.LEAD_INGOT.get(),  1.0f, 100)
                .unlockedBy("has_ore", has(ChematriaItems.LEAD_ORE_ITEM))
                .save(consumer, "lead_ingot_ore");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ChematriaItems.RAW_LEAD_CHUNK.get()),
                        ChematriaItems.LEAD_INGOT.get(),  1.0f, 100)
                .unlockedBy("has_ore", has(ChematriaItems.LEAD_ORE_ITEM))
                .save(consumer, "lead_ingot_chunk");
        //TIN
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ChematriaItems.TIN_ORE_ITEM),
                        ChematriaItems.TIN_INGOT.get(),  1.0f, 100)
                .unlockedBy("has_ore", has(ChematriaItems.TIN_ORE_ITEM))
                .save(consumer, "tin_ingot_ore");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ChematriaItems.RAW_TIN_CHUNK.get()),
                        ChematriaItems.TIN_INGOT.get(),  1.0f, 100)
                .unlockedBy("has_ore", has(ChematriaItems.TIN_ORE_ITEM))
                .save(consumer, "tin_ingot_chunk");
        //MERCURY
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ChematriaItems.MERCURY_ORE_ITEM),
                        ChematriaItems.MERCURY_INGOT.get(),  1.0f, 100)
                .unlockedBy("has_ore", has(ChematriaItems.MERCURY_ORE_ITEM))
                .save(consumer, "mercury_ingot_ore");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ChematriaItems.RAW_MERCURY_CHUNK.get()),
                        ChematriaItems.MERCURY_INGOT.get(),  1.0f, 100)
                .unlockedBy("has_ore", has(ChematriaItems.MERCURY_ORE_ITEM))
                .save(consumer, "mercury_ingot_chunk");
        //SILVER
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ChematriaItems.SILVER_ORE_ITEM),
                        ChematriaItems.SILVER_INGOT.get(),  1.0f, 100)
                .unlockedBy("has_ore", has(ChematriaItems.SILVER_ORE_ITEM))
                .save(consumer, "silver_ingot_ore");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ChematriaItems.RAW_SILVER_CHUNK.get()),
                        ChematriaItems.SILVER_INGOT.get(),  1.0f, 100)
                .unlockedBy("has_ore", has(ChematriaItems.SILVER_ORE_ITEM))
                .save(consumer, "silver_ingot_chunk");
    }
}
