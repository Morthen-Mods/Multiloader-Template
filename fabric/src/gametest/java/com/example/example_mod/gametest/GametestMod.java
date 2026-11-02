package com.example.example_mod.gametest;

import net.fabricmc.fabric.api.gametest.v1.FabricGameTest;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

public class GametestMod implements FabricGameTest {
    @GameTest(template = GametestConstants.EMPTY_STRUCTURE)
    public void dirtAtOrigin(GameTestHelper helper) {
        ExampleModTest.dirtAtOrigin(helper);
    }
}
