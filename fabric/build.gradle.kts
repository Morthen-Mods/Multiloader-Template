import net.morthen.gradle.multiloader.api.Loader
import net.morthen.gradle.multiloader.api.ModifierType

plugins {
    id("net.morthen.gradle.multiloader")
}

multiloader {
    loader = Loader.FABRIC

    // example_mod.classtweaker, from common or fabric
    modifierType = ModifierType.CLASS_TWEAKER
}

dependencies {
    implementation("com.terraformersmc:modmenu:20.0.3")
}
