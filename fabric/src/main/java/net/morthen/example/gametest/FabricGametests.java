package net.morthen.example.gametest;

import net.fabricmc.fabric.api.gametest.v1.CustomTestMethodInvoker;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

import java.lang.reflect.Method;

public class FabricGametests implements CustomTestMethodInvoker {

    @GameTest
    public void dirtAtOrigin(GameTestHelper helper) {
        CommonGametests.dirtAtOrigin(helper);
    }

    @GameTest
    public void ironToNuggetsRecipe(GameTestHelper helper) {
        CommonGametests.ironNuggetRecipe(helper);
    }

    @Override
    public void invokeTestMethod(GameTestHelper helper, Method method) throws ReflectiveOperationException {
        method.invoke(this, helper);
    }
}
