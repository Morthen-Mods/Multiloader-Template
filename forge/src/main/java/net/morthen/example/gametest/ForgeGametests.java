package net.morthen.example.gametest;

import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.morthen.example.Constants;

import java.util.function.Consumer;

public class ForgeGametests {
    public static final DeferredRegister<Consumer<GameTestHelper>> GAMETESTS = DeferredRegister.create(Registries.TEST_FUNCTION, Constants.MOD_ID);

    static {
        GAMETESTS.register("dirt_at_origin", () -> CommonGametests::dirtAtOrigin);
        GAMETESTS.register("iron_nugget_recipe", () -> CommonGametests::ironNuggetRecipe);
    }
}
