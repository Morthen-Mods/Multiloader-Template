package net.morthen.example.gametest;

import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CommonGametests {

    public static void init(BiConsumer<String, Consumer<GameTestHelper>> consumer) {
        consumer.accept("dirt_at_origin", CommonGametests::dirtAtOrigin);
        consumer.accept("iron_nugget_recipe", CommonGametests::ironNuggetRecipe);
    }

    public static void dirtAtOrigin(GameTestHelper helper) {
        helper.setBlock(0, 0, 0, Blocks.DIRT);
        helper.assertBlockPresent(Blocks.DIRT, 0, 0, 0);
        helper.succeed();
    }

    public static void ironNuggetRecipe(GameTestHelper helper) {
        ItemStack[] grid = new ItemStack[9];
        Arrays.fill(grid, new ItemStack(Items.AIR));
        grid[0] = new ItemStack(Items.IRON_INGOT);

        CraftingInput input = CraftingInput.of(3, 3, List.of(grid));

        // find recipe match
        Optional<RecipeHolder<CraftingRecipe>> match = helper.getLevel().recipeAccess().getRecipeFor(RecipeType.CRAFTING, input, helper.getLevel());

        helper.assertTrue(match.isPresent(), "No recipe match found.");
        CraftingRecipe recipe = match.get().value();

        // get result
        ItemStack result = recipe.assemble(input);
        helper.assertTrue(!result.isEmpty(), "No result found.");
        helper.assertTrue(result.getCount() == 9, "Expected 9 iron nuggets");

        helper.succeed();
    }
}
