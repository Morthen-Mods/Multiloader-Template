package net.morthen.example.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.morthen.example.Constants;

import java.util.concurrent.CompletableFuture;

public class ExampleRecipeProvider extends RecipeProvider {

    protected ExampleRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        this.shapeless(RecipeCategory.MISC, Items.DIAMOND, 2)
                .requires(Items.DIAMOND)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(this.output, path(getItemName(Items.DIAMOND)));
    }

    protected ResourceKey<Recipe<?>> path(String path) {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(Constants.MOD_ID, path));
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new  ExampleRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Example Recipe Provider";
        }
    }
}
