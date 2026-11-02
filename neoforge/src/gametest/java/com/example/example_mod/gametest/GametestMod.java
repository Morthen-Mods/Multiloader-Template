package com.example.example_mod.gametest;

import net.minecraft.gametest.framework.GameTestGenerator;
import net.minecraft.gametest.framework.TestFunction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterGameTestsEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mod(GametestConstants.MOD_ID)
public class GametestMod {
    public GametestMod(IEventBus eventBus) {
        eventBus.addListener(GametestMod::registerTests);
    }

    public static void registerTests(RegisterGameTestsEvent event) {
        event.register(GametestMod.class);
    }

    // NeoForge drops generated tests whose structure namespace is not in neoforge.enabledGameTestNamespaces
    @GameTestGenerator
    public static Collection<TestFunction> generateTests() {
        List<TestFunction> tests = new ArrayList<>();
        GametestConstants.initTests((testId, consumer) -> tests.add(new TestFunction(
                GametestConstants.MOD_ID, GametestConstants.MOD_ID + "." + testId, GametestConstants.EMPTY_STRUCTURE,
                100, 0, true, consumer)));
        return tests;
    }
}
