package com.example.example_mod;

import com.example.example_mod.provider.ExampleModProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(CommonConstants.MOD_ID)
public class Datagen {
    public Datagen(IEventBus eventBus) {
        eventBus.addListener(Datagen::gatherData);
    }

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new ExampleModProvider.CustomRecipes.Runner(output, lookupProvider));
        generator.addProvider(event.includeServer(), new ExampleModProvider.CustomItemTags(output, lookupProvider, existingFileHelper));
    }
}
