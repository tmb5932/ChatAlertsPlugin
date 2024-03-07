package me.kwzii.chatalertsplugin.listeners

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerJoinLeaveListener : Listener {

    @EventHandler
    fun onJoinEvent(event: PlayerJoinEvent) {
        val pName = event.player.name

        event.joinMessage(Component.text("$pName has returned to the land of misery...").color(TextColor.color(255, 200, 2)))
    }

    @EventHandler
    fun onLeaveEvent(event: PlayerQuitEvent) {
        val pName = event.player.name

        event.quitMessage(Component.text("$pName has departed from the land of misery\uD83E\uDEE1\n Lets hope he can stay away...").color(TextColor.color(255, 200, 2)))
        /*
             todo: at some point have multiple in a list that is randomly selected when leaving or joining the server
        Start of list:

        Shh, here comes %player

        Come on, %player, another cobblestone build?

        A WILD %player APPEARS!

        %player USED (colorcode)QUIT(resetcolor)! IT'S SUPER-EFFECTIVE

        [+] %player

        [-] %player

        '%player is leaving forever, and means it this time.'

        %player has joined with one of his friends. Oh, no, that's just his schizophrenic hallucinations

         */

    }
}