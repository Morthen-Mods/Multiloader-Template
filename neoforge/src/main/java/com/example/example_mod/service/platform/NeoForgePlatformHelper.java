package com.example.example_mod.service.platform;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

import java.nio.file.Path;

public class NeoForgePlatformHelper implements IPlatformHelper {
    @Override
    public Path getConfigDir() {
        return FMLLoader.getGamePath();
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDev() {
        return !FMLLoader.isProduction();
    }

    @Override
    public String getName() {
        return "NeoForge";
    }
}
