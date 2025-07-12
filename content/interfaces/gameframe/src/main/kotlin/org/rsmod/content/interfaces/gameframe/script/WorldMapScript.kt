package org.rsmod.content.interfaces.gameframe.script

import jakarta.inject.Inject
import org.rsmod.api.script.onIfOverlayButton
import org.rsmod.content.interfaces.gameframe.CloseWorldMapEvent
import org.rsmod.content.interfaces.gameframe.closeWorldMap
import org.rsmod.content.interfaces.gameframe.config.GameframeComponents
import org.rsmod.events.EventBus
import org.rsmod.game.entity.Player
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

class WorldMapScript @Inject constructor(private val eventBus: EventBus) : PluginScript() {
    override fun ScriptContext.startup() {
        // Handler for world map key toggle button (595:24)
        onIfOverlayButton(GameframeComponents.worldmap_key_toggle) { player.toggleWorldMapKey() }

        // Handler for world map overview toggle button (595:29)
        onIfOverlayButton(GameframeComponents.worldmap_overview_toggle) {
            player.toggleWorldMapOverview()
        }

        onIfOverlayButton(GameframeComponents.worldmap_close) {
            player.closeWorldMap()
            eventBus.publish(CloseWorldMapEvent(player))
        }
    }

    private fun Player.toggleWorldMapKey() {
        // TODO: show/hide key
    }

    private fun Player.toggleWorldMapOverview() {
        // TODO: show overview map
    }
}
