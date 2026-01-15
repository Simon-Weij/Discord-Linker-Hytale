/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package me.simon.DiscordLinker

import com.hypixel.hytale.logger.HytaleLogger
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent
import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import javax.annotation.Nonnull


class DiscordLinker (@Nonnull init: JavaPluginInit) : JavaPlugin(init) {
    companion object {
        lateinit var instance: DiscordLinker
        var LOGGER: HytaleLogger = HytaleLogger.forEnclosingClass()
            private set
    }

    init {
        instance = this
        println("[DiscordLinker] Plugin loaded!")
    }

    override fun setup() {
        this.eventRegistry
            .registerGlobal<String?, PlayerChatEvent?>(PlayerChatEvent::class.java, PlayerChat::onPlayerChat)
        LOGGER.atSevere().log("DiscordLinker started")
    }

    override fun start() {
        LOGGER.atSevere().log("DiscordLinker started!")
    }
}