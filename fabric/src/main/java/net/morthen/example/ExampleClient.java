package net.morthen.example;

import net.fabricmc.api.ClientModInitializer;

public class ExampleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ExampleConstants.initClient();
    }
}
