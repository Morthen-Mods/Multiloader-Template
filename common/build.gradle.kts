plugins {
    id("net.morthen.gradle.multiloader")
}

multiloader {
    neoFormVersion = "26.1.2-1"

    withTestMod()
    withGametest()
}