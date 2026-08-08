package net.morthen.template;

import net.fabricmc.api.ModInitializer;

public class TemplateMod implements ModInitializer {
    @Override
    public void onInitialize() {
        CommonConstants.commonInit();
        CommonConstants.LOGGER.info("Loading TemplateMod");
    }
}
