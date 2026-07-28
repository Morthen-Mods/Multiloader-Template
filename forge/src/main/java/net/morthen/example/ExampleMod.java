package net.morthen.example;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.morthen.example.gametest.ForgeGametests;
import net.morthen.example.platform.Services;

@Mod(Constants.MOD_ID)
public class ExampleMod {

    public ExampleMod(FMLJavaModLoadingContext context) {
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();

        if (Services.PLATFORM.isDevelopmentEnvironment()) {
            ForgeGametests.GAMETESTS.register(context.getModBusGroup());
        }
    }
}