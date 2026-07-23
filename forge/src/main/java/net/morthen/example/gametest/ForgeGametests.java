package net.morthen.example.gametest;

import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.morthen.example.Constants;

import java.util.function.Consumer;

public class ForgeGametests {
    public static final DeferredRegister<Consumer<GameTestHelper>> GAMETESTS = DeferredRegister.create(Registries.TEST_FUNCTION, Constants.MOD_ID);

    /**
     * To fully register Gametests in Forge this isn't enough.
     * The resource directory needs the following .json file for each test
     * `data/{mod_id}/test_instance/{test_name}.json`
     * <br>
     * Example:
     * <pre>{@code
     * {
     *   "type": "minecraft:function",
     *   "environment": "minecraft:default",
     *   "function": "{mod_id}:{test_name}",
     *   "structure": "minecraft:empty",
     *   "max_ticks": 400,
     *   "setup_ticks": 50,
     *   "required": true
     * }
     * }</pre>
     */
    public static final RegistryObject<Consumer<GameTestHelper>> DIRT_AT_ORIGIN =
            GAMETESTS.register("dirt_at_origin", () -> CommonGametests::dirtAtOrigin);

}
