package net.morthen.example;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.morthen.example.gametest.ForgeGametests;

@Mod(Constants.MOD_ID)
public class ExampleMod {

    public ExampleMod(FMLJavaModLoadingContext context) {
        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();

        ForgeGametests.GAMETESTS.register(context.getModBusGroup());
    }
}