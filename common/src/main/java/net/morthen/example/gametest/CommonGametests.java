package net.morthen.example.gametest;

import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.level.block.Blocks;

public class CommonGametests {

    public static void dirtAtOrigin(GameTestHelper helper) {
        helper.setBlock(0, 0, 0, Blocks.DIRT);
        helper.assertBlockPresent(Blocks.DIRT, 0, 0, 0);
        helper.succeed();
    }
}
