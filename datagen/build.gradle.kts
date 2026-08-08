plugins {
    id("net.morthen.gradle.multiloader")
}

multiloader {
    neoForgeVersion = "26.1.2.71"
    loader = "datagen"

    applyMetadataReplacements(listOf("pack.mcmeta", "META-INF/neoforge.mods.toml"))
}