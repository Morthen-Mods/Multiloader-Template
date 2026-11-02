package com.example.example_mod;

import net.minecraft.resources.ResourceLocation;
import com.example.example_mod.service.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonConstants {
    public static final String MOD_ID = "example_mod";
    public static final String MOD_NAME = "Example Mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static void commonInit() {
        LOGGER.info("Hello from {}", Services.PLATFORM.getName());
    }
}
