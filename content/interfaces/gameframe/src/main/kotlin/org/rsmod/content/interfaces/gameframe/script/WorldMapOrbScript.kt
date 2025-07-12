package org.rsmod.content.interfaces.gameframe.script

import jakarta.inject.Inject
import org.rsmod.api.game.process.player.PlayerBuildAreaProcessor
import org.rsmod.api.game.process.player.PlayerZoneUpdateProcessor
import org.rsmod.api.script.onIfOverlayButton
import org.rsmod.content.interfaces.gameframe.config.GameframeComponents
import org.rsmod.content.interfaces.gameframe.openWorldMap
import org.rsmod.game.type.interf.InterfaceTypeList
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

class WorldMapOrbScript
@Inject
constructor(
    private val interfaceTypes: InterfaceTypeList,
    private val areaProcessor: PlayerBuildAreaProcessor,
    private val zoneProcessor: PlayerZoneUpdateProcessor,
) : PluginScript() {
    override fun ScriptContext.startup() {
        onIfOverlayButton(GameframeComponents.world_map_orb) {
            player.openWorldMap(interfaceTypes, areaProcessor, zoneProcessor)
        }
    }
}
