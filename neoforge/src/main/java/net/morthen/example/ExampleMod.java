package net.morthen.example;


import net.morthen.example.gametest.NeoforgeGametests;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class ExampleMod {

    public ExampleMod(IEventBus eventBus) {
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

        NeoforgeGametests.GAMETESTS.register(eventBus);
        eventBus.register(NeoforgeGametests.class);
    }
}