package net.morthen.example;

import net.morthen.example.provider.ExampleBlockTagProvider;
import net.morthen.example.provider.ExampleItemTagProvider;
import net.morthen.example.provider.ExampleRecipeProvider;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(Constants.MOD_ID)
public class Example {

    public Example(IEventBus bus) {
        // Block Registry
        // Item Registry
    }

    @EventBusSubscriber(modid = Constants.MOD_ID)
    public static class ExampleDatagen {

        @SubscribeEvent
        public static void generateData(GatherDataEvent.Client event) {
             event.createProvider(ExampleRecipeProvider.Runner::new);
             event.createProvider(ExampleBlockTagProvider::new);
             event.createProvider(ExampleItemTagProvider::new);
        }
    }
}
