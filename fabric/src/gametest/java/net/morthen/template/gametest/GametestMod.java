package net.morthen.template.gametest;

import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.morthen.example.gametest.TemplateTest;

public class GametestMod {
    @GameTest
    public void dirtAtOrigin(GameTestHelper helper) {
        TemplateTest.dirtAtOrigin(helper);
    }
}
