package me.simon.DiscordLinker

import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent
import me.simon.DiscordLinker.DiscordLinker.Companion.LOGGER


object PlayerChat {

    fun onPlayerChat(event: PlayerChatEvent) {
        LOGGER.atSevere().log("Message send ${event.content} by ${event.sender}")
    }
}