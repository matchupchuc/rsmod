plugins {
    id("base-conventions")
}

dependencies {
    implementation(projects.api.config)
    implementation(projects.api.player)
    implementation(projects.api.playerOutput)
    implementation(projects.api.script)
    implementation(projects.api.scriptAdvanced)
    implementation(projects.api.pluginCommons)
    implementation(projects.engine.events)
    implementation(projects.engine.game)
    implementation(projects.api.type.typeSymbols)
    implementation(projects.api.type.typeReferences)
    implementation(projects.api.gameProcess)
}
