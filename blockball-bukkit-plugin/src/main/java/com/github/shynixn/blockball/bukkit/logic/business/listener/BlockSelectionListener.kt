package com.github.shynixn.blockball.bukkit.logic.business.listener

import com.github.shynixn.blockball.api.business.service.BlockSelectionService
import com.google.inject.Inject
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerQuitEvent

/**
 * Created by Shynixn 2018.
 * <p>
 * Version 1.2
 * <p>
 * MIT License
 * <p>
 * Copyright (c) 2018 by Shynixn
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
class BlockSelectionListener @Inject constructor(private val blockSelectionService: BlockSelectionService) : Listener {
    /**
     * Gets called when the player interacts with a block.
     */
    @EventHandler
    fun onPlayerInteractEvent(event: PlayerInteractEvent) {
        if (event.action == Action.LEFT_CLICK_BLOCK) {
            event.isCancelled = blockSelectionService.selectLeftLocation(event.player, event.clickedBlock.location)
        } else if (event.action == Action.RIGHT_CLICK_BLOCK) {
            event.isCancelled = blockSelectionService.selectRightLocation(event.player, event.clickedBlock.location)
        }
    }

    /**
     * Gets called when a player leaves the server.
     */
    @EventHandler
    fun onPlayerQuitEvent(event: PlayerQuitEvent) {
        blockSelectionService.cleanResources(event.player)
    }
}