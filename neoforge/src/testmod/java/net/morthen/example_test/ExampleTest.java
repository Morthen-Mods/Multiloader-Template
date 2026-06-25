package net.morthen.example_test;

import net.morthen.example.ExampleConstants;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ExampleTestConstants.MOD_ID)
public class ExampleTest {
    public ExampleTest(IEventBus bus) {
        ExampleConstants.LOGGER.info("Test Created");
    }
}
