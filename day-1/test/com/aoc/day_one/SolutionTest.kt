package com.aoc.day_one

import java.io.ByteArrayInputStream
import kotlin.test.Test
import kotlin.test.assertEquals


class SolutionTest {

    @Test
    fun testPartOneSolution() {
        val stream = javaClass.getResourceAsStream("/solution-test.txt")
        val result = Solution.getSolutionOne(stream)
        assertEquals(3, result, "Part 1 solution result should be 3")
    }

    @Test
    fun testPartTwoSolution() {
        val stream = javaClass.getResourceAsStream("/solution-test.txt")
        val result = Solution.getSolutionTwo(stream)
        assertEquals(6, result, "Part 2 solution result should be 6")
    }

    @Test
    fun testPartTwoSolutionRightMultiRotation() {
        val stream = ByteArrayInputStream("R1000".encodeToByteArray())
        val result = Solution.getSolutionTwo(stream)
        assertEquals(10, result, "Part 2 solution right multi-rotation should be 10")
    }

    @Test
    fun testPartTwoSolutionLeftMultiRotation() {
        val stream = ByteArrayInputStream("L1000".encodeToByteArray())
        val result = Solution.getSolutionTwo(stream)
        assertEquals(10, result, "Part 2 solution left multi-rotation should be 10")
    }

    @Test
    fun testPartTwoSolutionLeft() {
        val stream = ByteArrayInputStream("""
            L50
        """.trimIndent().encodeToByteArray())
        val result = Solution.getSolutionTwo(stream)
        assertEquals(1, result, "Part 2 solution left rotation should be 1")
    }


    @Test
    fun testPartTwoSolutionLeftMultiRotation2() {
        val stream = ByteArrayInputStream("""
            L50
            L1000
        """.trimIndent().encodeToByteArray())
        val result = Solution.getSolutionTwo(stream)
        assertEquals(11, result, "Part 2 solution left multi-rotation should be 11")
    }

    @Test
    fun testPartTwoSolutionRightMultiRotation2() {
        val stream = ByteArrayInputStream("""
            R50
            R1000
        """.trimIndent().encodeToByteArray())
        val result = Solution.getSolutionTwo(stream)
        assertEquals(11, result, "Part 2 solution right multi-rotation should be 11")
    }
}
