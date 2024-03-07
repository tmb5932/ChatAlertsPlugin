package me.kwzii.chatalertsplugin.listeners

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
        player.sendMessage(Component.text("Sleep tight " + player.name + "...\n").color(TextColor.color(128, 68, 255)).decorate(TextDecoration.ITALIC))
    }

    @EventHandler
    fun playerExitBedEvent(event: PlayerBedLeaveEvent) {
        val player = event.player
        // todo: check if there is a way to see if they got out of bed before morning came
        player.sendMessage(Component.text("Rise and shine " + player.name + ", another day another diamond...").color(TextColor.color(128, 68, 255)).decorate(TextDecoration.ITALIC))

        player.sendMessage(Component.text("Go back to bed " + player.name + ", it isn't morning yet...").color(TextColor.color(128, 68, 255)).decorate(TextDecoration.ITALIC))
    }
}