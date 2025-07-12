package org.rsmod.api.route

import jakarta.inject.Inject
import org.rsmod.game.entity.PathingEntityAvatar
import org.rsmod.game.movement.RouteRequest
import org.rsmod.game.movement.RouteRequestCoord
import org.rsmod.game.movement.RouteRequestLoc
import org.rsmod.game.movement.RouteRequestPathingEntity
import org.rsmod.map.CoordGrid
import org.rsmod.routefinder.Route
import org.rsmod.routefinder.RouteFinding
import org.rsmod.routefinder.collision.CollisionFlagMap
import org.rsmod.routefinder.collision.CollisionStrategy

public class RouteFactory @Inject constructor(flags: CollisionFlagMap) {
    private val routeFinding = RouteFinding(flags)
    private val threadLocalRouteFinding = ThreadLocal.withInitial { RouteFinding(flags) }

    private fun routeFinder(async: Boolean): RouteFinding =
        if (async) {
            threadLocalRouteFinding.get()
        } else {
            routeFinding
        }

    public fun create(
        source: PathingEntityAvatar,
        destination: CoordGrid,
        collision: CollisionStrategy = CollisionStrategy.Normal,
    ): Route =
        if (source is org.rsmod.game.entity.PlayerAvatar && source.parent?.noclip == true) {
            // Direct path: walk in a straight line to the destination, ignoring collision
            val path = mutableListOf<org.rsmod.routefinder.RouteCoordinates>()
            var curr = source.coords
            while (curr != destination) {
                val dx = (destination.x - curr.x).coerceIn(-1, 1)
                val dz = (destination.z - curr.z).coerceIn(-1, 1)
                curr = curr.translate(dx, dz)
                path += org.rsmod.routefinder.RouteCoordinates(curr.x, curr.z, curr.level)
            }
            org.rsmod.routefinder.Route(path, alternative = false, success = true)
        } else {
            with(routeFinder(async = true)) {
                findRoute(
                    level = source.coords.level,
                    srcX = source.coords.x,
                    srcZ = source.coords.z,
                    destX = destination.x,
                    destZ = destination.z,
                    srcSize = source.size,
                    destWidth = 1,
                    destLength = 1,
                    collision = collision,
                )
            }
        }

    public fun create(
        source: PathingEntityAvatar,
        destination: PathingEntityAvatar,
        collision: CollisionStrategy = CollisionStrategy.Normal,
    ): Route =
        with(routeFinder(async = false)) {
            findRoute(
                level = source.coords.level,
                srcX = source.coords.x,
                srcZ = source.coords.z,
                destX = destination.coords.x,
                destZ = destination.coords.z,
                srcSize = source.size,
                destWidth = destination.size,
                destLength = destination.size,
                collision = collision,
                locShape = RECTANGLE_EXCLUSIVE_STRATEGY,
            )
        }

    public fun create(
        source: PathingEntityAvatar,
        request: RouteRequestLoc,
        collision: CollisionStrategy = CollisionStrategy.Normal,
    ): Route {
        with(request) {
            val routeFinder = routeFinder(async = true)
            return routeFinder.findRoute(
                level = source.coords.level,
                srcX = source.coords.x,
                srcZ = source.coords.z,
                destX = destination.x,
                destZ = destination.z,
                srcSize = source.size,
                destWidth = width,
                destLength = length,
                locShape = shape,
                locAngle = angle,
                blockAccessFlags = forceApproachFlags,
                collision = collision,
            )
        }
    }

    public fun create(source: PathingEntityAvatar, request: RouteRequest): Route =
        when (request) {
            is RouteRequestCoord -> create(source, request.destination)
            is RouteRequestPathingEntity -> create(source, request.destination)
            is RouteRequestLoc -> create(source, request)
        }

    public companion object {
        private const val RECTANGLE_EXCLUSIVE_STRATEGY: Int = -2
    }
}
