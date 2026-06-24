package net.morthen.example;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(ExampleConstants.MOD_ID)
public class Example {

    public Example(IEventBus bus) {
        // Block Registry
        // Item Registry
    }

    @EventBusSubscriber(modid = ExampleConstants.MOD_ID)
    public static class ExampleDatagen {

        @SubscribeEvent
        public static void generateData(GatherDataEvent.Client event) {
            // event.createProvider(RecipeClass.Runner::new);
        }
    }
}
