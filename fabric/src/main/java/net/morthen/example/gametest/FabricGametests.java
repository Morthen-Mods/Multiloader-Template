package net.morthen.example.gametest;

import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

public class FabricGametests {

    @GameTest
    public void dirtAtOrigin(GameTestHelper helper) {
        CommonGametests.dirtAtOrigin(helper);
    }

    @GameTest
    public void ironToNuggetsRecipe(GameTestHelper helper) {
        CommonGametests.ironNuggetRecipe(helper);
    }
}
