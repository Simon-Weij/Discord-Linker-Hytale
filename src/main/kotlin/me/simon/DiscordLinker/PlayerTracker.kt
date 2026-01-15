/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package me.simon.DiscordLinker

import com.hypixel.hytale.server.core.entity.entities.Player
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent

object PlayerTracker {
    val players = arrayListOf<Player>()
    fun onPlayerJoin(event: PlayerReadyEvent){
        players.add(event.player)
    }
}