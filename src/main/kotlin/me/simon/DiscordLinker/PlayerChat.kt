/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package me.simon.DiscordLinker

import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent

object PlayerChat {
    fun onPlayerChat(event: PlayerChatEvent) {
        WebSocket.sendToAll("${event.sender.username}: ${event.content}")
    }

    fun onPlayerReady(event: PlayerReadyEvent){
        WebSocket.sendToAll("${event.player} joined!")
    }
}