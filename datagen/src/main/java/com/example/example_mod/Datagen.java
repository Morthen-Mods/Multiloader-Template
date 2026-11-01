package com.example.example_mod;

import com.example.example_mod.provider.ExampleModProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;

@Mod(CommonConstants.MOD_ID)
public class Datagen {
    public Datagen(IEventBus eventBus) {
        eventBus.addListener(Datagen::gatherRegistries);
        eventBus.addListener(Datagen::gatherData);
    }

    // Recipes are registry entries since 26.3
    public static void gatherRegistries(GatherDataRegistryEntriesEvent event) {
        event.add(RecipeProvider.asBootstrap(ExampleModProvider.CustomRecipes::new));
    }

    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ExampleModProvider.CustomItemTags::new);
    }
}
