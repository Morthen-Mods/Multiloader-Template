package net.morthen.example;

import com.google.common.collect.Maps;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.FunctionGameTestInstance;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.gametest.framework.TestData;
import net.minecraft.gametest.framework.TestEnvironmentDefinition;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.morthen.example.gametest.CommonGametests;
import net.morthen.example.gametest.NeoforgeGametest;
import net.morthen.example.platform.Services;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterGameTestsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;
import java.util.function.Consumer;

@Mod(Constants.MOD_ID)
public class ExampleMod {
    public static final DeferredRegister<Consumer<GameTestHelper>> GAMETEST = DeferredRegister.create(BuiltInRegistries.TEST_FUNCTION, Constants.MOD_ID);

    public ExampleMod(IEventBus eventBus) {
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

        // loads the gametests only in dev environment
        if (Services.PLATFORM.isDevelopmentEnvironment()) {
            GAMETEST.register(eventBus);
            CommonGametests.init(NeoforgeGametest::registerTest);
            eventBus.addListener(NeoforgeGametest::registerTests);
        }
    }
}