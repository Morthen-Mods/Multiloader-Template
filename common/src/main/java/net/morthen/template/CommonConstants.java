package net.morthen.template;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonConstants {
    public static final String MOD_ID = "template";
    public static final String MOD_NAME = "Template";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static Identifier of(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    public static void commonInit() {

    }
}
