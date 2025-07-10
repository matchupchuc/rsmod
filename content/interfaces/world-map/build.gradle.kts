// File: rsmod/content/interfaces/world-map/build.gradle.kts
plugins {
    id("base-conventions")
}

dependencies {
    // This is the crucial part that was missing.
    // We are telling this module that it depends on the code from
    // these other modules, allowing us to import their functions.
    implementation(projects.api.pluginCommons)
    implementation(projects.api.script)
    implementation(projects.api.player)
    implementation(projects.api.playerOutput)
    implementation(projects.engine.plugin)
}
