pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.morthen.net/releases")

        maven("https://maven.neoforged.net/releases")
        maven("https://maven.minecraftforge.net")
        maven("https://maven.fabricmc.net")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "Multiloader-Template"

listOf("common", "datagen", "fabric").forEach(::include)