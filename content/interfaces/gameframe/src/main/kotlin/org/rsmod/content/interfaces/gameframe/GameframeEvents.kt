package org.rsmod.content.interfaces.gameframe

import org.rsmod.events.UnboundEvent
import org.rsmod.game.entity.Player

data class CloseWorldMapEvent(val player: Player) : UnboundEvent
