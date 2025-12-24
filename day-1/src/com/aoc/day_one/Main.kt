package com.aoc.day_one

fun main() {
    var code = Solution.getSolutionOne(InputParser.Companion::class.java.getResourceAsStream("/input.txt") ?: throw RuntimeException("Cannot find the input"))
    println("Solution 1 Code => $code")

    code = Solution.getSolutionTwo(InputParser.Companion::class.java.getResourceAsStream("/input.txt") ?: throw RuntimeException("Cannot find the input"))
    println("Solution 2 Code => $code")
}
