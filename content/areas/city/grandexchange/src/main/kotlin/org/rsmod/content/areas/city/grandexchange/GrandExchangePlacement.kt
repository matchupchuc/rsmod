package org.rsmod.content.areas.city.grandexchange

import jakarta.inject.Inject
import org.rsmod.api.config.refs.npcs
import org.rsmod.api.repo.npc.NpcRepository
import org.rsmod.content.generic.npcs.ge.GeClerkNpcs
import org.rsmod.game.entity.Npc
import org.rsmod.game.type.npc.NpcTypeList
import org.rsmod.map.CoordGrid
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

class GrandExchangePlacement
@Inject
constructor(private val npcRepo: NpcRepository, private val npcTypes: NpcTypeList) :
    PluginScript() {
    override fun ScriptContext.startup() {
        placeGEClerksAndBankers()
    }

    private fun placeGEClerksAndBankers() {
        val clerkType = npcTypes[GeClerkNpcs.ge_clerk.id!!]!!
        val bankerType = npcTypes[npcs.banker1.id!!]!!

        println("Clerk type ID: ${GeClerkNpcs.ge_clerk.id}")
        println("Banker type ID: ${npcs.banker1.id}")
        println("Clerk type found: ${clerkType != null}")
        println("Banker type found: ${bankerType != null}")

        val coords =
            listOf(
                CoordGrid(3164, 3488, 0), // North
                CoordGrid(3165, 3488, 0), // Northeast
                CoordGrid(3166, 3489, 0), // East
                CoordGrid(3166, 3490, 0), // Southeast
                CoordGrid(3165, 3491, 0), // South
                CoordGrid(3164, 3491, 0), // Southwest
                CoordGrid(3163, 3490, 0), // West
                CoordGrid(3163, 3489, 0), // Northwest
            )
        val types =
            listOf(
                clerkType,
                bankerType,
                clerkType,
                bankerType,
                clerkType,
                bankerType,
                clerkType,
                bankerType,
            )
        coords.zip(types).forEach { (coord, type) ->
            val npc = Npc(type, coord)
            npcRepo.add(npc, Int.MAX_VALUE)
            println("Placed NPC at $coord")
        }
    }
}
