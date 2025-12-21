package com.aoc.day_one

object Solution {

    fun solve(inputFile: String): Int {
        var count = 0
        val stream = InputParser.Companion::class.java.getResourceAsStream(inputFile) ?: throw RuntimeException("Cannot find the input")
        val inputs = InputParser.parse(stream)
        val lock = PasswordLock()
        for (input in inputs) {
            if (lock.dial(input) == 0) {
                count++
            }
        }

        return count
    }
}
