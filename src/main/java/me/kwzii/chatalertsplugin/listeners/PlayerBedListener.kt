package me.kwzii.chatalertsplugin.listeners

import com.destroystokyo.paper.event.player.PlayerSetSpawnEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerBedLeaveEvent

class PlayerBedListener : Listener{

    @EventHandler
    fun playerEnterBedEvent(event: PlayerBedEnterEvent) {
        val player = event.player
        if (player.world.time in 12530..23419 || player.world.hasStorm())
            player.sendMessage(Component.text("Sleep tight " + player.name + "...\n").color(TextColor.color(128, 68, 255)).decorate(TextDecoration.ITALIC))
    }

    @EventHandler
    fun playerExitBedEvent(event: PlayerBedLeaveEvent) {
        val player = event.player
        if (player.world.time < 12530)
            player.sendMessage(Component.text("Rise and shine " + player.name + ", another day another diamond...").color(TextColor.color(128, 68, 255)).decorate(TextDecoration.ITALIC))
        else
            player.sendMessage(Component.text("Go back to bed " + player.name + ", it isn't morning yet...").color(TextColor.color(128, 68, 255)).decorate(TextDecoration.ITALIC))
    }

    @EventHandler
    fun playerSetRespawn(event: PlayerSetSpawnEvent) {
        val player = event.player
        // todo: figure out how to block the default "respawn point set" message
            // todo: problem is that respawn is set before this is called i believe.
        // todo: only show message if it is their spawn is being changed
        if (player.bedSpawnLocation != event.location) {
            player.sendMessage(Component.text("The Gods will remember this place...").color(TextColor.color(200, 255, 199)).decorate(TextDecoration.ITALIC))
        }
    }
}