/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package me.simon.DiscordLinker


class DiscordLinker {
    companion object {
        lateinit var instance: DiscordLinker
            private set
    }

    /**
     * Constructor - Called when plugin is loaded.
     */
    init {
        instance = this
        println("[TemplatePlugin] Plugin loaded!")
    }

    /**
     * Called when plugin is enabled.
     */
    fun onEnable() {
        println("[TemplatePlugin] Plugin enabled!")


        // TODO: Initialize your plugin here
        // - Load configuration
        // - Register event listeners
        // - Register commands
        // - Start services
    }

    /**
     * Called when plugin is disabled.
     */
    fun onDisable() {
        println("[TemplatePlugin] Plugin disabled!")


        // TODO: Cleanup your plugin here
        // - Save data
        // - Stop services
        // - Close connections
    }
}
