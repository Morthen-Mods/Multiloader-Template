package com.example.example_mod.gametest;

import net.minecraft.gametest.framework.GameTestGenerator;
import net.minecraft.gametest.framework.TestFunction;
import net.minecraftforge.event.RegisterGameTestsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mod(GametestConstants.MOD_ID)
public class GametestMod {
    public GametestMod(FMLJavaModLoadingContext context) {
        GametestConstants.LOGGER.info("Loading Gametest Mod");
        context.getModEventBus().addListener(GametestMod::registerTests);
    }

    public static void registerTests(RegisterGameTestsEvent event) {
        event.register(GametestMod.class);
    }

    // Forge drops tests whose batch name does not match forge.enabledGameTestNamespaces, so the batch is the mod id
    @GameTestGenerator
    public static Collection<TestFunction> generateTests() {
        List<TestFunction> tests = new ArrayList<>();
        GametestConstants.initTests((testId, consumer) -> tests.add(new TestFunction(
                GametestConstants.MOD_ID, GametestConstants.MOD_ID + "." + testId, GametestConstants.EMPTY_STRUCTURE,
                400, 50, true, consumer)));
        return tests;
    }
}
