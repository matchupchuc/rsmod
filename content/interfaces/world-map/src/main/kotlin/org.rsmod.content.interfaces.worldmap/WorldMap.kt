// File: rsmod/content/interfaces/world-map/src/main/kotlin/org/rsmod/content/interfaces/worldmap/WorldMapScript.kt
package org.rsmod.content.interfaces.worldmap

import jakarta.inject.Inject
import org.rsmod.api.player.output.clearMapFlag
import org.rsmod.api.player.ui.openInterface
import org.rsmod.api.script.onIfOverlayButton
import org.rsmod.plugin.PluginScript
import org.rsmod.plugin.ScriptContext
import org.rsmod.plugin.logger

// The unique ID for the world map interface.
private const val WORLD_MAP_INTERFACE_ID = 595

class WorldMapScript @Inject constructor() : PluginScript() {
    override fun ScriptContext.startup() {
        // Listen for a click on the World Map orb using the correct function.
        onIfOverlayButton(worldmap_components.open_map_orb) { player ->
            player.openInterface(WORLD_MAP_INTERFACE_ID)
            logger.info { "Player ${player.displayName} opened the world map." }
        }

        // Listen for a click on the "Clear" button for the map flag.
        onIfOverlayButton(worldmap_components.clear_map_flag) { player ->
            player.clearMapFlag()
            logger.info { "Player ${player.displayName} cleared their map flag." }
        }
    }
}
