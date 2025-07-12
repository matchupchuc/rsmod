package org.rsmod.content.interfaces.gameframe

import org.rsmod.api.config.refs.varps
import org.rsmod.api.game.process.player.PlayerBuildAreaProcessor
import org.rsmod.api.game.process.player.PlayerZoneUpdateProcessor
import org.rsmod.api.player.ui.ifOpenTop
import org.rsmod.api.player.vars.VarPlayerIntMapSetter
import org.rsmod.game.entity.Player
import org.rsmod.game.type.interf.InterfaceTypeList
import org.rsmod.map.CoordGrid

fun Player.openWorldMap(
    interfaceTypes: InterfaceTypeList,
    areaProcessor: PlayerBuildAreaProcessor,
    zoneProcessor: PlayerZoneUpdateProcessor,
) {
    val worldMap =
        interfaceTypes.types[595] ?: error("World map interface (595) not found in cache.")
    ifOpenTop(worldMap)
    VarPlayerIntMapSetter.set(this, varps.worldmap_you_are_here_toggle, 1)

    val currentBuildArea = buildArea
    buildArea = CoordGrid.NULL
    areaProcessor.process(this)
    zoneProcessor.process(this)
    buildArea = currentBuildArea
}

fun Player.closeWorldMap() {
    VarPlayerIntMapSetter.set(this, varps.worldmap_you_are_here_toggle, 0)
}
