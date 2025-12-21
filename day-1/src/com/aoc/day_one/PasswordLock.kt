package com.aoc.day_one

import java.lang.Math.floorMod
import kotlin.math.abs

private const val LIMIT = 100

class PasswordLock : Lock {
    var state: Int = 50
        private set

    override fun dial(input: DialInput): Int {
        val tempState = when (input.direction) {
            DialDirection.Right -> input.count
            DialDirection.Left -> -input.count
        }

        state = floorMod(state + tempState, LIMIT)
        return state
    }
}
