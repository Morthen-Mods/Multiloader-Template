package net.morthen.example.gametest;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CommonGametests {

    public static void init(BiConsumer<String, Consumer<GameTestHelper>> consumer) {
        consumer.accept("dirt_at_origin", CommonGametests::dirtAtOrigin);
        consumer.accept("iron_nugget_recipe", CommonGametests::ironNuggetRecipe);
        consumer.accept("check_chicken_drops", CommonGametests::checkChickenDrops);
        consumer.accept("check_chest_loot", CommonGametests::checkChestLoot);
    }

    private static Holder<Enchantment> getEnchantment(GameTestHelper helper, ResourceKey<Enchantment> enchantment) {
        return helper.getLevel().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(enchantment);
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

    public static void checkChickenDrops(GameTestHelper helper) {
        Holder<Enchantment> looting = getEnchantment(helper, Enchantments.LOOTING);
        ItemStack sword = new ItemStack(Items.DIAMOND_SWORD);
        sword.enchant(looting, 3);

        Player player = helper.makeMockPlayer(GameType.SURVIVAL);
        Chicken chicken = helper.spawn(EntityType.CHICKEN, 0, 0, 0);
        DamageSources sources = new DamageSources(helper.getLevel().registryAccess());

        player.setItemInHand(InteractionHand.MAIN_HAND, sword);

        helper.assertEntitiesPresent(EntityType.CHICKEN, 1);
        helper.hurt(chicken, sources.playerAttack(player), 100);

        helper.assertItemEntityPresent(Items.FEATHER);
        helper.assertItemEntityPresent(Items.CHICKEN);

        helper.succeed();
    }

    public static void checkChestLoot(GameTestHelper helper) {
        Player player = helper.makeMockPlayer(GameType.SURVIVAL);
        helper.setBlock(BlockPos.ZERO, Blocks.CHEST);

        ChestBlockEntity chest = helper.getBlockEntity(BlockPos.ZERO,  ChestBlockEntity.class);
        chest.setLootTable(BuiltInLootTables.SPAWN_BONUS_CHEST);

        helper.useBlock(BlockPos.ZERO, player);

        for (int i = 0; i < chest.getContainerSize(); i++) {
            if (!chest.getItem(i).isEmpty()) {
                ItemStack stack = chest.getItem(i);
                if (stack.getItem() == Items.APPLE ||
                        stack.getItem() == Items.SALMON ||
                        stack.getItem() == Items.BREAD) {
                    helper.succeed();
                }
            }
        }
    }
}
