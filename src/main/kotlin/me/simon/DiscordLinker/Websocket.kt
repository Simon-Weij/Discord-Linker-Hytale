/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package me.simon.DiscordLinker

import com.hypixel.hytale.server.core.Message
import io.javalin.Javalin
import io.javalin.websocket.WsContext
import java.io.File
import java.io.FileInputStream
import java.util.Properties
import java.util.concurrent.ConcurrentHashMap

object WebSocket {

    private val sessions: MutableSet<WsContext> = ConcurrentHashMap.newKeySet<WsContext>()

    private val token: String by lazy {
        val file = File("server.properties")
        if (file.exists()) {
            val props = Properties()
            FileInputStream(file).use { props.load(it) }
            props.getProperty("token", "")
        } else {
            ""
        }
    }

    fun add(ctx: WsContext) {
        sessions.add(ctx)
    }

    fun remove(ctx: WsContext) {
        sessions.remove(ctx)
    }

    fun sendToAll(message: String) {
        sessions.forEach { ctx ->
            if (ctx.session.isOpen) {
                ctx.send(message)
            }
        }
    }

    fun registerWebsocket(app: Javalin) {
        app.ws("/discordlinker/ws") { ws ->
            ws.onConnect { ctx ->
                val queryToken = ctx.queryParam("token")
                if (queryToken == token) {
                    add(ctx)
                    DiscordLinker.LOGGER.atInfo().log("Connected: ${ctx.session}")
                } else {
                    ctx.session.close()
                    DiscordLinker.LOGGER.atInfo().log("Connection rejected: invalid token")
                }
            }

            ws.onClose { ctx ->
                remove(ctx)
                DiscordLinker.LOGGER.atInfo().log("Closed: ${ctx.session}")
            }

            ws.onError { ctx ->
                remove(ctx)
                ctx.error()?.printStackTrace()
            }

            ws.onMessage { ctx ->
                val msg = ctx.message()
                for (player in PlayerTracker.players){
                    player.sendMessage(Message.raw(msg))
                }
            }
        }
    }
}
