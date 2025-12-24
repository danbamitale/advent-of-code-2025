package com.aoc.day_one

class PasswordLock: Lock {
    var state: Int = INITIAL_LOCK_STATE
        private set

    var zeroCounter: Int = 0
        private set

    override fun dial(input: DialInput): Int {
        val diff = when (input.direction) {
            DialDirection.Right -> input.count
            DialDirection.Left -> -input.count
        }

        val transition = state + diff
        state = floorMod(transition) // or replace with Math.floorMod

        zeroCounter += if (state == 0) 1 else 0
        return state
    }

    /**
     * Computes a circular modulo of the dial.
     * Breakdown:
     * 1. Add LOCK_LIMIT to ensure positivity
     * 2. Normalize with % LOCK_LIMIT
     * 3. Ensure result is within [0, LOCK_LIMIT)
     */
    private fun floorMod(transition: Int): Int {
        val rotations = LOCK_LIMIT + transition
        val positiveValueNormalizer = (rotations % LOCK_LIMIT) + LOCK_LIMIT
        val limitRestriction = positiveValueNormalizer % LOCK_LIMIT
        return limitRestriction
    }
}
