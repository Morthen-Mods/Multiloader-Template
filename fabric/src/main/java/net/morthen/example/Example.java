package net.morthen.example;

import net.fabricmc.api.ModInitializer;

public class Example implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleConstants.initCommon();
    }
}
