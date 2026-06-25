package net.morthen.example_test;

import net.fabricmc.api.ModInitializer;
import net.morthen.example.ExampleConstants;

public class ExampleTest implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleConstants.LOGGER.error("Test Error");
    }
}
