package com.aoc.day_2


fun main() {
    val solution1 = Solution.part1(InputParser.parseInput( InputParser::class.java.getResourceAsStream("/input.txt")))
    println("Part 1 result: $solution1")


    val solution2 = Solution.part2(InputParser.parseInput( InputParser::class.java.getResourceAsStream("/input.txt")))
    println("Part 2 result: $solution2")
}
