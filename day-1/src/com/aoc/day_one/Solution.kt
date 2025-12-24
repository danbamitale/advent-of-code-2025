package com.aoc.day_one

import java.io.InputStream

object Solution {

    fun getSolutionOne(stream: InputStream): Int {
        val inputs = InputParser.parse(stream)
        val lock = PasswordLock()
        for (input in inputs) {
            lock.dial(input)
        }

        return lock.zeroCounter
    }

    fun getSolutionTwo(stream: InputStream): Int {
        val inputs = InputParser.parse(stream)
        val lock = TransitionTrackingPasswordLock()
        for (input in inputs) {
            lock.dial(input)
        }

        return lock.zeroCounter
    }

}
