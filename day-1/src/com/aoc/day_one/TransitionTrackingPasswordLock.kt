package com.aoc.day_one

import kotlin.math.abs

class TransitionTrackingPasswordLock : Lock {
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
        val prevState = state
        state = floorMod(transition)

        zeroCounter += floorDiv(prevState, diff)

        return state
    }

    /**
     * Computes a circular modulo of the dial. Breakdown:
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

    /**
     * Counts how many times zero is reached during a movement path. Breakdown:
     * 1. Compute the total transition: prevState + diff
     * 2. Count the number of full rotations (absolute value)
     *    - Each full rotation crosses zero once
     * 3. Check for a partial rotation that crosses zero:
     *    - Happens when moving left (diff < 0) from positive state and ending
     *      at or below zero
     *    - Adds 1 to account for the partial zero crossing
     * 4. Sum full rotations and partial crossing to get total zero touches
     */
    private fun floorDiv(prevState: Int, diff: Int): Int {
        val transition = prevState + diff

        // Step 2: Count full rotations
        val fullRotationCount = abs(transition / LOCK_LIMIT)

        // Step 3: Compute the remaining partial rotation
        val finalRotationTransition = transition % LOCK_LIMIT

        val finalRotation = fullRotationCount + when {
            diff < 0 && prevState > 0 && finalRotationTransition <= 0 -> 1
            else -> 0
        }

        // Step 4: Return total zero touches
        return finalRotation
    }
}
