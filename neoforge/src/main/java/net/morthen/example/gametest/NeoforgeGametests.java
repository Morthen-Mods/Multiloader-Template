package net.morthen.example.gametest;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.FunctionGameTestInstance;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.gametest.framework.TestData;
import net.minecraft.gametest.framework.TestEnvironmentDefinition;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Rotation;
import net.morthen.example.Constants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.RegisterGameTestsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class NeoforgeGametests {
    public static final DeferredRegister<Consumer<GameTestHelper>> GAMETESTS =
            DeferredRegister.create(BuiltInRegistries.TEST_FUNCTION, Constants.MOD_ID);

    public static final DeferredHolder<Consumer<GameTestHelper>, Consumer<GameTestHelper>> DIRT_AT_ORIGIN =
            GAMETESTS.register("dirt_at_origin", () -> CommonGametests::dirtAtOrigin);

    public static final DeferredHolder<Consumer<GameTestHelper>, Consumer<GameTestHelper>> IRON_NUGGET_RECIPE =
            GAMETESTS.register("iron_nugget_recipe", () -> CommonGametests::ironNuggetRecipe);

    public static void registerGametest(String testName, DeferredHolder<Consumer<GameTestHelper>, Consumer<GameTestHelper>> holder, RegisterGameTestsEvent event) {
        Holder<TestEnvironmentDefinition<?>> env = event.registerEnvironment(
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, testName + "_environment"),
                new TestEnvironmentDefinition.Weather(TestEnvironmentDefinition.Weather.Type.CLEAR)
        );

        event.registerTest(
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, testName),
                new FunctionGameTestInstance(holder.getKey(),
                        new TestData<>(env, Identifier.withDefaultNamespace("empty"),
                                400, 50, true, Rotation.NONE)
                )
        );
    }

    @SubscribeEvent
    public static void registerGametests(RegisterGameTestsEvent event) {
        registerGametest("dirt_at_origin", DIRT_AT_ORIGIN, event);
        registerGametest("iron_nugget_recipe", IRON_NUGGET_RECIPE, event);
    }
}
