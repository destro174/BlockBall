package com.github.shynixn.blockball.bukkit.logic.persistence.entity

import com.github.shynixn.blockball.api.business.enumeration.ParticleColor
import com.github.shynixn.blockball.api.business.enumeration.ParticleType
import com.github.shynixn.blockball.api.persistence.entity.Particle
import com.github.shynixn.blockball.bukkit.logic.business.extension.YamlSerializer

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
class ParticleEntity(
        @YamlSerializer.YamlSerialize(value = "name", orderNumber = 1)
        override var type: ParticleType = ParticleType.NONE) : Particle {
    /**
     * Database Id.
     */
    var id: Long = 0
    /**
     * Amount of particles.
     */
    @YamlSerializer.YamlSerialize(value = "amount", orderNumber = 2)
    override var amount: Int = 1
    /**
     * Particle speed.
     */
    @YamlSerializer.YamlSerialize(value = "speed", orderNumber = 3)
    override var speed: Double = 1.0
    /**
     * Offset for the x coordinate.
     */
    @YamlSerializer.YamlSerialize(value = "offset.x", orderNumber = 4)
    override var offSetX: Double = 1.0
    /**
     * Offset for the y coordinate.
     */
    @YamlSerializer.YamlSerialize(value = "offset.y", orderNumber = 5)
    override var offSetY: Double = 1.0
    /**
     * Offset for the z coordinate.
     */
    @YamlSerializer.YamlSerialize(value = "offset.u", orderNumber = 6)
    override var offSetZ: Double = 1.0

    /**
     * Material value.
     */
    @YamlSerializer.YamlSerialize(value = "material", orderNumber = 7)
    override var materialName: String? = null
    /**
     * Data value.
     */
    @YamlSerializer.YamlSerialize(value = "data", orderNumber = 8)
    override var data: Int = 0

    /**
     * Custom note color code.
     */
    override var noteColor: Int
        get() = this.offSetX.toInt()
        set(value) {
            this.offSetX = value.toDouble()
        }

    /**
     * Color of the particle effect.
     */
    override var color: ParticleColor
        get() = ParticleColor.WHITE
        set(value) {
            colorRed = color.red
            colorGreen = color.green
            colorBlue = color.blue
        }

    /**
     * RGB Color code of red.
     */
    override var colorRed: Int
        get() = this.offSetX.toInt()
        set(value) {
            this.offSetX = value.toDouble()
        }

    /**
     * RGB Color code of green.
     */
    override var colorGreen: Int
        get() = this.offSetY.toInt()
        set(value) {
            this.offSetY = value.toDouble()
        }
    /**
     * RGB Color code of blue.
     */
    override var colorBlue: Int
        get() = this.offSetZ.toInt()
        set(value) {
            this.offSetZ = value.toDouble()
        }
}