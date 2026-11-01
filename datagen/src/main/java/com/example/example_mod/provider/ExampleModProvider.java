package com.example.example_mod.provider;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.references.ItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import com.example.example_mod.CommonConstants;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ExampleModProvider {
    // Since 26.3 recipes (and their advancements) are registry entries, registered via RecipeProvider.asBootstrap
    public static class CustomRecipes extends RecipeProvider {
        public CustomRecipes(BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
            super(recipes, advancements);
        }

        @Override
        protected void buildRecipes() {
            this.shapeless(RecipeCategory.MISC, Items.DIAMOND, 2)
                    .requires(Items.DIAMOND)
                    .unlockedBy("has_diamond", has(Items.DIAMOND))
                    .save(this.output, path(getItemName(Items.DIAMOND)));
        }

        protected ResourceKey<Recipe<?>> path(String path) {
            return ResourceKey.create(Registries.RECIPE, CommonConstants.of(path));
        }
    }

    public static class CustomItemTags extends ItemTagsProvider {
        public CustomItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider, CommonConstants.MOD_ID);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            this.tag(ItemTags.LEAVES)
                    .add(ItemIds.BONE);
        }
    }
}
