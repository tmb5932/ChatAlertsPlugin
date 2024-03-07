package me.kwzii.chatalertsplugin

import org.bukkit.plugin.java.JavaPlugin
import me.kwzii.chatalertsplugin.listeners.*

class ChatAlertsPlugin : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        logger.info("Custom Plugin Loaded")
        registerListener()
    }

    private fun registerListener() {

        // Event that sends message when player gets in bed
        server.pluginManager.registerEvents(PlayerBedListener(), this)

        // Event that handles join and leave server notifications
        server.pluginManager.registerEvents(PlayerJoinLeaveListener(), this)
        logger.info("Registered Listeners")
    }

    override fun onDisable() {
        logger.info("Custom Plugin Unloaded")
    }
}
